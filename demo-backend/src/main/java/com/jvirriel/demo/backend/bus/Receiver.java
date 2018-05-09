package com.jvirriel.demo.backend.bus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

public class Receiver {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    private CountDownLatch latch = new CountDownLatch(1);

    public CountDownLatch getLatch() {
        return latch;
    }

   //@KafkaListener(topics = "${topic.helloworld}")
    public void receive(String message) {
        LOGGER.info(" *** Mensaje Recibido='{}'", message);
        latch.countDown();
    }

}
