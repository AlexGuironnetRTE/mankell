package org.mankell.kafka;

import org.lfenergy.operatorfabric.cards.model.Card;
import org.lfenergy.operatorfabric.cards.model.CardCreationReport;
import org.mankell.operatorfabric.CardPublisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    @Autowired
    CardPublisher cardPublisher;

    @KafkaListener(topics = "users", groupId = "group_id")

    public void consume(String message){

        logger.info(String.format("$$ -> Consumed Message -> %s",message));

        Card card = cardPublisher.createSimpleCard(message);

        logger.info("Created card: "+card.toString());

        CardCreationReport report = cardPublisher.publishCard(card);

        logger.info("Card publication report: "+report.toString());

    }

}
