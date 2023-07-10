package com.flight.booking.system.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface Kafkaproducer {

    public KafkaTemplate<String, String> kafkaTemplate();

}
