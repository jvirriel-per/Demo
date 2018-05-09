package com.jvirriel.demo.backend.configuration.audit;

import com.pt.core.audit.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.Map;

import static com.jvirriel.demo.backend.configuration.KafkaConfigProperties.getProducerConfigPropertiesWithStringJson;

@Configuration
@EnableAsync
public class KafkaDocumentProducerConfig {

    @Value("${kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Bean
    public Map<String, Object> producerConfigs() {
        return getProducerConfigPropertiesWithStringJson(bootstrapServers);
    }


    @Bean
    public ProducerFactory<String, com.pt.core.audit.Document> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }


    @Bean
    public KafkaTemplate<String, Document> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

}
