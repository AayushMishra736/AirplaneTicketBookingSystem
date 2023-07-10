package com.flight.booking.system.service;

import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.stereotype.Service;

@Service
public interface Kafkaconsumer {
   public ConsumerFactory<String, String> consumerFactory();
   public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory();
}
