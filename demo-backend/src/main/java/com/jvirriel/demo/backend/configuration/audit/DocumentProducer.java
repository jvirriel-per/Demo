package com.jvirriel.demo.backend.configuration.audit;


import com.pt.core.audit.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
public class DocumentProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(DocumentProducer.class);

    @Autowired
    private KafkaTemplate<String, com.pt.core.audit.Document> kafkaTemplate;

    public DocumentProducer() {
    }

    @Async
    public void send(String topic, com.pt.core.audit.Document message) {
        // the KafkaTemplate provides asynchronous send methods returning a Future
        ListenableFuture<SendResult<String, com.pt.core.audit.Document>> future = kafkaTemplate.send(topic, message);

        LOGGER.info("Trying to send message...");

        // register a callback with the listener to receive the result of the send asynchronously
        future.addCallback(new ListenableFutureCallback<SendResult<String, com.pt.core.audit.Document>>() {

            @Override
            public void onSuccess(SendResult<String, Document> result) {
                LOGGER.info("enviar mensaje ='{}' with offset={}", message,
                        result.getRecordMetadata().offset());
            }

            @Override
            public void onFailure(Throwable ex) {
                LOGGER.error("### ERROR unable to send message='{}'", message, ex);
            }
        });

//         or, to block the sending thread to await the result, invoke the future's get() method
    }
}
