package org.mankell.kafka;

import org.mankell.model.iss.ISSPassesReport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    //TODO Replace with Slf4j and annotation
    private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);

    private static final String TOPIC = "users";

    @Autowired
    private KafkaTemplate<Object,Object> kafkaTemplate;

    public void sendMessage(ISSPassesReport issPassesReport){

        logger.info(String.format("$$ -> Producing message --> %s",issPassesReport));
        this.kafkaTemplate.send(TOPIC,issPassesReport);
        //To be able to send an object rather than a string, the following property needs to be set:
        // spring.kafka.value-serializer: org.springframework.kafka.support.serializer.JsonSerializer


    }

}
