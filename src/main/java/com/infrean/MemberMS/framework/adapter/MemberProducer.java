package com.infrean.MemberMS.framework.adapter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infrean.MemberMS.config.KafkaProperties;
import com.infrean.MemberMS.domain.model.event.ItemRented;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
public class MemberProducer  {

    private final Logger log = LoggerFactory.getLogger(MemberProducer.class);

    private static final String TOPIC = "exam";
    private static final String TOPIC_CATALOG = "topic_catalog";
    private static final String TOPIC_POINT = "topic_point";

    private final KafkaTemplate<String, String> kafkaTemplate;

    private final KafkaProperties kafkaProperties;
    private KafkaProducer<String, String> producer;
    private final ObjectMapper objectMapper = new ObjectMapper();

//    @PostConstruct
//    public void initialize(){
//        log.info("Kafka producer initializing...");
//        this.producer = new KafkaProducer<>(kafkaProperties.getProducerProps());
//        Runtime.getRuntime().addShutdownHook(new Thread(this::shutdown));
//        log.info("Kafka producer initialized");
//    }


    /******
     * kafka 메세지 수신 후, 결과 메세지 받도록 변경* *******/

//     public void sendTest(String msg) throws ExecutionException, InterruptedException, JsonProcessingException {
//
//        ItemRented event = new ItemRented();
//        event.setItemId(23L);
//        event.setMeberId(msg);
//
//        String message = objectMapper.writeValueAsString(event);
//        producer.send(new ProducerRecord<>(TOPIC, message)).get();
//    }

    public void sendMessage(String message) {
        System.out.printf("Produce message : %s%n", message);
        this.kafkaTemplate.send(TOPIC, message);
    }

//    @PreDestroy
//    public void shutdown(){
//        log.info("Shutdown Kafka producer");
//        producer.close();
//    }

}