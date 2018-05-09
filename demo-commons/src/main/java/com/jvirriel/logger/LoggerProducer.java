package com.jvirriel.logger;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
public class LoggerProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerProducer.class);

    @Value("${credix.logger.topic}")
    private String topic;

    private final KafkaTemplate<String, LoggerLog> kafkaTemplate;

    @Autowired
    public LoggerProducer(KafkaTemplate<String, LoggerLog> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Async
    public void log(Throwable t) {
        LoggerLog log = new LoggerLog(t);
        ListenableFuture<SendResult<String, LoggerLog>> future = kafkaTemplate.send(this.topic, log);

        future.addCallback(new ListenableFutureCallback<SendResult<String, LoggerLog>>() {

            @Override
            public void onSuccess(SendResult<String, LoggerLog> result) {
                LOGGER.info("log error ='{}' with offset={}", log,
                        result.getRecordMetadata().offset());
            }

            @Override
            public void onFailure(Throwable ex) {
                LOGGER.error("### ERROR unable to send log='{}'", log, ex);
            }
        });
    }
}
