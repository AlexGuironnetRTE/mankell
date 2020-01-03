package org.mankell.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    //Based on https://dzone.com/articles/magic-of-kafka-with-spring-boot

    private final Logger logger = LoggerFactory.getLogger(KafkaController.class);

    private final Producer producer;

    @Autowired
    public KafkaController(Producer producer) {

        this.producer = producer;

    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message){
        logger.info("Publish endpoint was reached.");
        this.producer.sendMessage(message);

    }

}
