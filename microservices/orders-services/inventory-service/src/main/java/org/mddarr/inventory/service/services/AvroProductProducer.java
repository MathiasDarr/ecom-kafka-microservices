package org.mddarr.inventory.service.services;

import org.mddarr.inventory.service.Constants;
import org.mddarr.products.AvroProduct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class AvroProductProducer implements AvroProductInterface {

    @Autowired
    private KafkaTemplate<String, AvroProduct> kafkaTemplateEvent1;

    private static final Logger logger = LoggerFactory.getLogger(AvroProductProducer.class);

    public void postAvroProduct() {
        AvroProduct ride = AvroProduct.newBuilder()
                .setName("BackPack")
                .setPrice(12.1).setStock(210L)
                .setVendor("Osprey")
                .build();

        logger.info("Send Product to Kafka 1 {}", ride);
        kafkaTemplateEvent1.send(Constants.DRIVERS_TOPIC, ride);
    }

}
