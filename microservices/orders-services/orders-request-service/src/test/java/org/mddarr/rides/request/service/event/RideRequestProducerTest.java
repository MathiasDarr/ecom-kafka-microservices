package org.mddarr.rides.request.service.event;

import org.junit.Test;
import org.mddarr.rides.request.service.UatAbstractTest;

import org.mddarr.rides.request.service.services.AvroOrderRequestProducer;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class RideRequestProducerTest extends UatAbstractTest {

    @Autowired
    private AvroOrderRequestProducer avroRideRequestProducer;

    @Test
    public void should_send_ride_request() {
//        avroRideRequestProducer.sendRideRequest(new OrderRequest("Charles",6));
//        ConsumerRecord<String, AvroOrder> singleRecord = KafkaTestUtils.getSingleRecord(ordersConsumer, Constants.ORDER_TOPIC);
//        assertThat(singleRecord).isNotNull();
    }
}