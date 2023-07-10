package com.flight.booking.system.serviceimpl;


import com.flight.booking.system.service.Kafkaproducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
@Configuration
public class Kafkaproducerimpl implements Kafkaproducer {
    private static final Logger logger =
            LoggerFactory.getLogger(Kafkaproducerimpl.class);

    @Bean
    public ProducerFactory<String, String> producerFactory(){
    Map<String, Object> configProps = new HashMap<String, Object>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate(){
     return  new KafkaTemplate<>(producerFactory());
    }

}
