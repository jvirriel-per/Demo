package com.jvirriel.demo.backend.entitytype;

import com.jvirriel.demo.backend.bus.Producer;
import com.jvirriel.demo.backend.configuration.BEController;
import com.jvirriel.demo.backend.constants.BackEndConstants;
import com.jvirriel.demo.model.entitytype.EntityType;
import com.jvirriel.event.ResourceCreated;
import com.jvirriel.demo.backend.configuration.audit.DocumentProducer;
import com.jvirriel.exception.CustomErrorType;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static com.jvirriel.demo.backend.constants.InterceptorConstants.$_CREDIX_AUDIT_TOPIC;
import static com.jvirriel.demo.backend.constants.InterceptorConstants.$_CREDIX_SECURITY_APPCODE;
import static com.jvirriel.demo.backend.constants.InterceptorConstants.TEST_MODE_ENABLED;
import static com.jvirriel.property.PropertyUtil.getProperty;
import static com.jvirriel.demo.backend.configuration.audit.RequestInfoExtractor.getDocument;
import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping(value = BackEndConstants.API + EntityTypeConstants.ENTITYTYPE)
public class EntityTypeController implements BEController<EntityType, Integer> {

    private final EntityTypeService service;
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final ApplicationEventPublisher eventPublisher;
    private final Producer producer;
    private final DocumentProducer documentProducer;

    private final Ignite ignite;

    @Value($_CREDIX_AUDIT_TOPIC)
    private String auditTopic;

    @Value($_CREDIX_SECURITY_APPCODE)
    private String appCode;

    @PersistenceContext()
    private EntityManager entityManager;

    @Autowired
    public EntityTypeController(ApplicationEventPublisher eventPublisher,
                                EntityTypeService service,
                                Ignite ignite, Producer producer,
                                DocumentProducer documentProducer) {
        this.service = service;
        this.eventPublisher = eventPublisher;
        this.producer = producer;
        this.ignite = ignite;
        this.documentProducer = documentProducer;
    }

    /**
     * Función eliminar un registro en EntityType.
     *
     * @param id id de la entidad a ser eliminada
     * @return responseEntity
     */
    @DeleteMapping(value = BackEndConstants.ID_URI)
    public ResponseEntity<?> delete(@PathVariable(BackEndConstants.ID) Integer id, HttpServletRequest request) {
        if (!service.exists(id)) {
            return new ResponseEntity<>(
                    CustomErrorType.get(BackEndConstants.UNABLE_TO_DELETE_RECORD + id + " " + NOT_FOUND),
                    NOT_FOUND
            );
        }

        service.delete(id);

        ResponseEntity<EntityType> responseEntity = new ResponseEntity<>(NO_CONTENT);
        if (!Boolean.valueOf(getProperty(TEST_MODE_ENABLED)) && !Boolean.valueOf(getProperty(TEST_MODE_ENABLED)))
            documentProducer.send(auditTopic, getDocument(request, appCode, responseEntity));
        return responseEntity;
    }

    /**
     * Busca todos los registros dado una lista de condiciones.
     *
     * @param search  Expresión en RSQL para hacer consultas a través de servicios RESTful
     * @param orderBy Criterio de ordenamiento ascedente o descendente según uno o más atributos de la entidad.
     * @param page    Número de página a devolver en una grid. Por defecto adquiere el valor de 1.
     * @param size    Número de entidades recuperadas por cada página. Por defecto tiene el valor de 10.
     * @return lista de valores.
     */
    @GetMapping
    public ResponseEntity<List<EntityType>> findAll(
            @RequestHeader(value = BackEndConstants.SEARCH, defaultValue = BackEndConstants.DEFAULT_SEARCH) String search,
            @RequestHeader(value = BackEndConstants.ORDER_BY, defaultValue = BackEndConstants.DEFAULT_ORDER_BY) String orderBy,
            @RequestHeader(value = BackEndConstants.PAGE, defaultValue = BackEndConstants.DEFAULT_PAGE) String page,
            @RequestHeader(value = BackEndConstants.SIZE, defaultValue = BackEndConstants.DEFAULT_SIZE) String size,
            HttpServletRequest request) {

        List<EntityType> result;

        result = service.findAll(search, orderBy, page, size);

        if (result.isEmpty()) {
            return new ResponseEntity<>(NOT_FOUND);
        }

        ResponseEntity<List<EntityType>> responseEntity = new ResponseEntity<>(result, OK);
        if (!Boolean.valueOf(getProperty(TEST_MODE_ENABLED)) && !Boolean.valueOf(getProperty(TEST_MODE_ENABLED)))
            documentProducer.send(auditTopic, getDocument(request, appCode, request));
        return responseEntity;
    }

    /**
     * Encuentra un registro dado un id.
     *
     * @param id id de la entidad a ser recuperada, en caso de que la misma exista.
     * @return el registro encontrado.
     */
    @GetMapping(value = BackEndConstants.ID_URI)
    public ResponseEntity<?> findById(@PathVariable(BackEndConstants.ID) Integer id, HttpServletRequest request) {
        if (!service.exists(id)) {

            return new ResponseEntity<>(
                    CustomErrorType.get(EntityTypeConstants.ENTITY_TYPE_WITH_ID_ERROR_MESSAGE + id + " not found"),
                    NOT_FOUND
            );
        }

        ResponseEntity<EntityType> responseEntity = new ResponseEntity<>(service.findById(id), OK);
        if (!Boolean.valueOf(getProperty(TEST_MODE_ENABLED)) && !Boolean.valueOf(getProperty(TEST_MODE_ENABLED)))
            documentProducer.send(auditTopic, getDocument(request, appCode, responseEntity));
        return responseEntity;
    }

    /**
     * Inserta un registro.
     *
     * @param entity Entidad a ser insertada en la base de datos.
     * @return la entidad insertada.
     */
    @PostMapping(value = "/")
    public ResponseEntity<?> save(@RequestBody EntityType entity, HttpServletRequest request) {
        boolean nullEntity = entity == null;
        String errorMessage;

        if (nullEntity) {
            errorMessage = "Empty entity Type.";
        } else if (entity.getId() != null) {
            errorMessage = "Entity Type must not have Id for Save, use Update instead.";
        } else {
            ResponseEntity<EntityType> responseEntity = new ResponseEntity<>(service.save(entity), CREATED);
            if (!Boolean.valueOf(getProperty(TEST_MODE_ENABLED)) && !Boolean.valueOf(getProperty(TEST_MODE_ENABLED)))
            documentProducer.send(auditTopic, getDocument(request, appCode, responseEntity));
            return responseEntity;
        }

        return new ResponseEntity<>(
                CustomErrorType.get(400, errorMessage),
                BAD_REQUEST
        );
    }

    /**
     * Actualiza un registro.
     *
     * @param id     id de la entidad a ser actualizada
     * @param entity entidad a ser actualizada con los datos modificados.
     * @return la entidad actualizada.
     */
    @PutMapping(value = BackEndConstants.ID_URI)
    public ResponseEntity<?> update(@PathVariable(BackEndConstants.ID) Integer id,
                                    @RequestBody EntityType entity, HttpServletRequest request) {
        if (!service.exists(id)) {
            return new ResponseEntity<>(
                    CustomErrorType.get(BackEndConstants.UNABLE_TO_UPDATE_RECORD + id +
                    " " + " not found"),
                    NOT_FOUND
            );
        }

        ResponseEntity<EntityType> responseEntity = new ResponseEntity<>(service.save(entity), OK);
        if (!Boolean.valueOf(getProperty(TEST_MODE_ENABLED)) && !Boolean.valueOf(getProperty(TEST_MODE_ENABLED)))
            documentProducer.send(auditTopic, getDocument(request, appCode, responseEntity));
        return responseEntity;
    }

    @PostMapping(
            value = "/entityType/process/{action}")
    @ResponseBody
    public ResponseEntity<String> processEntityTypeByProcess(@PathVariable(BackEndConstants.ACTION) String action,
                                                             HttpServletResponse response) {

        logger.info("*** process: " + action + " ***");

        ResourceCreated resourceCreated = new ResourceCreated(this, response, 7);
        eventPublisher.publishEvent(resourceCreated);

        return new ResponseEntity<>("Respuesta" + action + resourceCreated.getIdOfNewResource(),
                HttpStatus.OK);
    }

    @PostMapping(
            value = "/entityType/publicer/{action}")
    @ResponseBody
    public ResponseEntity<String> publicerEntityTypeByProcess(@PathVariable(BackEndConstants.ACTION) String action,
                                                              HttpServletResponse response) {
        logger.info("*** publicar: " + action + " ***");
        EntityType entityType = new EntityType();
        entityType.setCode("Kafka");
        entityType.setEntityClass(action);
        producer.send("t.general", entityType.toString());
        producer.send("test2", action);

        logger.info("*** Cache ***");
        try (IgniteCache<Integer, String> cache = ignite.getOrCreateCache("MyCache2")) {
            logger.info("*** Cache Registro***");
            for (int i = 0; i < 10; i++)
                cache.put(i, Integer.toString(i));

            for (int i = 0; i < 10; i++)
                logger.info("Obtener [key=" + i + ", val=" + cache.get(i) + ']');

        }

        return new ResponseEntity<>("Respuesta" + action, HttpStatus.OK);
    }
}