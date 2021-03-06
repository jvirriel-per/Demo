package com.jvirriel.demo.backend.entitystatus;

import com.jvirriel.demo.backend.bus.Producer;
import com.jvirriel.demo.backend.configuration.BEController;
import com.jvirriel.demo.backend.configuration.audit.DocumentProducer;
import com.jvirriel.demo.backend.constants.BackEndConstants;
import com.jvirriel.demo.model.entitystatus.EntityStatus;
import com.jvirriel.event.ResourceCreated;
import com.jvirriel.exception.CustomErrorType;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.jvirriel.demo.backend.configuration.audit.RequestInfoExtractor.getDocument;
import static com.jvirriel.demo.backend.constants.InterceptorConstants.$_CREDIX_AUDIT_TOPIC;
import static com.jvirriel.demo.backend.constants.InterceptorConstants.$_CREDIX_SECURITY_APPCODE;
import static com.jvirriel.demo.backend.constants.InterceptorConstants.TEST_MODE_ENABLED;
import static com.jvirriel.property.PropertyUtil.getProperty;
import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping(value = BackEndConstants.API + EntityStatusConstants.ENTITYSTATUS)
public class EntityStatusController implements BEController<EntityStatus, Integer> {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final ApplicationEventPublisher eventPublisher;
    private final EntityStatusService service;
    private final Ignite ignite;
    private final Producer producer;
    private final DocumentProducer documentProducer;

    @Value($_CREDIX_AUDIT_TOPIC)
    private String auditTopic;

    @Value($_CREDIX_SECURITY_APPCODE)
    private String appCode;

    @PersistenceContext()
    private EntityManager entityManager;

    @Autowired
    public EntityStatusController(ApplicationEventPublisher eventPublisher, EntityStatusService service, Ignite ignite,
                                  Producer producer,DocumentProducer documentProducer) {
        this.service = service;
        this.eventPublisher = eventPublisher;
        this.producer = producer;
        this.ignite = ignite;
        this.documentProducer = documentProducer;
    }

    // ------------------- Delete an EntityStatus-----------------------------------------

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id, HttpServletRequest request) {
        if (!service.exists(id)) {
            return new ResponseEntity<>(
                    CustomErrorType.get("Unable to delete. User with id " + id + " not found."),
                    NOT_FOUND
            );
        }

        service.delete(id);

        ResponseEntity<EntityStatus> responseEntity = new ResponseEntity<>(NO_CONTENT);
        if (!Boolean.valueOf(getProperty(TEST_MODE_ENABLED)) && !Boolean.valueOf(getProperty(TEST_MODE_ENABLED)))
            documentProducer.send(auditTopic, getDocument(request, appCode, responseEntity));
        return responseEntity;
    }

    // ------------------- Search All EntityStatus ---------------------------------------------

    @GetMapping
    public ResponseEntity<List<EntityStatus>> findAll(
            @RequestHeader(value = "search", defaultValue = BackEndConstants.DEFAULT_SEARCH) String search,
            @RequestHeader(value = "orderBy", defaultValue = BackEndConstants.DEFAULT_ORDER_BY) String orderBy,
            @RequestHeader(value = "page", defaultValue = BackEndConstants.DEFAULT_PAGE) String page,
            @RequestHeader(value = "size", defaultValue = BackEndConstants.DEFAULT_SIZE) String size,
            HttpServletRequest request) {

        List<EntityStatus> result;

        result = service.findAll(search, orderBy, page, size);

        if (result.isEmpty()) {
            return new ResponseEntity<>(NOT_FOUND);
        }

        ResponseEntity<List<EntityStatus>> responseEntity = new ResponseEntity<>(result, OK);
        if (!Boolean.valueOf(getProperty(TEST_MODE_ENABLED)) && !Boolean.valueOf(getProperty(TEST_MODE_ENABLED)))
            documentProducer.send(auditTopic, getDocument(request, appCode, responseEntity));
        return responseEntity;
    }

    // -------------------Retrieve Entity Status------------------------------------------

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Integer id, HttpServletRequest request) {
        if (!service.exists(id)) {

            return new ResponseEntity<>(
                    CustomErrorType.get("Entity Status with id " + id + " not found"),
                    NOT_FOUND
            );
        }

        ResponseEntity<EntityStatus> responseEntity = new ResponseEntity<>(service.findById(id), OK);
        if (!Boolean.valueOf(getProperty(TEST_MODE_ENABLED)) && !Boolean.valueOf(getProperty(TEST_MODE_ENABLED)))
            documentProducer.send(auditTopic, getDocument(request, appCode, responseEntity));
        return responseEntity;
    }

    // -------------------Create  EntityStatus-------------------------------------------

    @PostMapping(value = "/")
    public ResponseEntity<?> save(@RequestBody EntityStatus entityStatus, HttpServletRequest request) {
        boolean nullEntity = entityStatus == null;
        String errorMessage;

        if (nullEntity) {
            errorMessage = "Empty entity Status.";
        } else if (entityStatus.getId() != null) {
            errorMessage = "Entity Status must not have Id for Save, use Update instead.";
        } else {
            ResponseEntity<EntityStatus> responseEntity = new ResponseEntity<>(service.save(entityStatus), CREATED);
            if (!Boolean.valueOf(getProperty(TEST_MODE_ENABLED)) && !Boolean.valueOf(getProperty(TEST_MODE_ENABLED)))
                documentProducer.send(auditTopic, getDocument(request, appCode, responseEntity));
            return responseEntity;
        }

        return new ResponseEntity<>(
                CustomErrorType.get(400, errorMessage),
                BAD_REQUEST
        );
    }

    // ------------------- Update an EntityStatus ------------------------------------------------

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id,
                                    @RequestBody EntityStatus entityStatus, HttpServletRequest request) {
        if (!service.exists(id)) {
            return new ResponseEntity<>(
                    CustomErrorType.get("Unable to update. User with id " + id + " not found."),
                    NOT_FOUND
            );
        }

        ResponseEntity<EntityStatus> responseEntity = new ResponseEntity<>(service.save(entityStatus), OK);
        if (!Boolean.valueOf(getProperty(TEST_MODE_ENABLED)) && !Boolean.valueOf(getProperty(TEST_MODE_ENABLED)))
            documentProducer.send(auditTopic, getDocument(request, appCode, responseEntity));
        return responseEntity;
    }

    // ------------------- Process an action-----------------------------------------

    @PostMapping(
            value = "/process/{action}")
    public ResponseEntity<String> processEntityStatusByProcess(
            @PathVariable("action") String action,
            HttpServletResponse response
    ) {
        logger.info("*** process: " + action + " ***");

        ResourceCreated resourceCreated = new ResourceCreated(this, response, 7);
        eventPublisher.publishEvent(resourceCreated);


        return new ResponseEntity<>("Respuesta" + action + resourceCreated.getIdOfNewResource(), OK);
    }

    @PostMapping(
            value = "/publicer/{action}")
    public ResponseEntity<String> publicerEntityStatusByProcess(
            @PathVariable("action") String action,
            HttpServletResponse response
    ) {
        logger.info("*** publicar: " + action + " ***");
        EntityStatus entityStatus = new EntityStatus();
        entityStatus.setCode("Kafka");
        entityStatus.setEntityClass(action);
        producer.send("t.general", entityStatus.toString());
        producer.send("test2", action);

        logger.info("*** Cache ***");
        try (IgniteCache<Integer, String> cache = ignite.getOrCreateCache("MyCache")) {
            logger.info("*** Cache Registro***");
            for (int i = 0; i < 10; i++) {
                cache.put(i, Integer.toString(i));
            }

            for (int i = 0; i < 10; i++) {
                logger.info("Obtener [key=" + i + ", val=" + cache.get(i) + ']');
            }
        }

        return new ResponseEntity<>("Respuesta" + action, OK);
    }

    @ExceptionHandler(NullPointerException.class)
    void handleBadRequest(HttpServletResponse response) throws IOException {
        response.sendError(BAD_REQUEST.value(), "Entity Status not found, probably wrong ID");
    }
}