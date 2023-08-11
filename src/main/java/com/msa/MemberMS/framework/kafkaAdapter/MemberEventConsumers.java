package com.infrean.MemberMS.framework.kafkaAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;


@Service
@RequiredArgsConstructor
public class MemberEventConsumers {

    private final Logger log = LoggerFactory.getLogger(MemberEventConsumers.class);

    public static final  String  TOPIC = "topic_kafka";

    private final ObjectMapper objectMapper = new ObjectMapper();

    private final MakeAvailableUsecase makeAvailableUsecase;
    private final MakeUnavailableUsecase makeUnavailableUsecase;
//    @KafkaListener(topics = "exam", groupId = "your-group-id")

    @KafkaListener(topics="exam",groupId = "foo")
    public void consume(ConsumerRecord<String, String> record) throws IOException{
        System.out.printf(record.value());
        ItemRented itemRented = objectMapper.readValue(record.value(), ItemRented.class);
        makeUnavailableUsecase.makeUnavailable(itemRented.getItem().getNo());
    }
}