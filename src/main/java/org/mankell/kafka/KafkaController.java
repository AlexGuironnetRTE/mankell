package org.mankell.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.mankell.model.iss.ISSPassesReport;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    //Based on https://dzone.com/articles/magic-of-kafka-with-spring-boot

    private final Logger logger = LoggerFactory.getLogger(KafkaController.class);

    private final KafkaProducer kafkaProducer;

    @Autowired
    public KafkaController(KafkaProducer kafkaProducer) {

        this.kafkaProducer = kafkaProducer;

    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestBody ISSPassesReport issPassesReport){ //TODO Generic message type with metadata and inheritance from data object
        this.kafkaProducer.sendMessage(issPassesReport);

    }

}
