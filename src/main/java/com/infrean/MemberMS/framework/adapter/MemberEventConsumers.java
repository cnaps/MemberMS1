package com.infrean.MemberMS.framework.adapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.infrean.MemberMS.config.KafkaProperties;
import com.infrean.MemberMS.domain.model.event.ItemRented;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.Duration;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;


@Service
@RequiredArgsConstructor
public class MemberEventConsumers {
    private final Logger log = LoggerFactory.getLogger(MemberEventConsumers.class);

    private final AtomicBoolean closed = new AtomicBoolean(false);

    public static final String TOPIC = "topic_kafka";

    private final KafkaProperties kafkaProperties;

    private KafkaConsumer<String, String> kafkaConsumer;

    private ExecutorService executorService = Executors.newCachedThreadPool();

    @KafkaListener(topics = "exam", groupId = "foo")
    public void consume(String message) throws IOException {
        System.out.printf("Consumed message : %s%n", message);
    }

    /*
    @PostConstruct
    public void start(){
        log.info("Kafka consumer starting ...");
        this.kafkaConsumer = new KafkaConsumer<>(kafkaProperties.getConsumerProps());
        Runtime.getRuntime().addShutdownHook(new Thread(this::shutdown));
        kafkaConsumer.subscribe(Collections.singleton(TOPIC));
        log.info("Kafka consumer started");

        executorService.execute(()-> {
                    try {

                        while (!closed.get()){
                            ConsumerRecords<String, String> records = kafkaConsumer.poll(Duration.ofSeconds(3));
                            for(ConsumerRecord<String, String> record: records) {
                                log.info("Consumed message in {} : {}", TOPIC, record.value());
                                ObjectMapper objectMapper = new ObjectMapper();
                                ItemRented itemRented = objectMapper.readValue(record.value(), ItemRented.class);
                                log.info("itemRentedID is {}",itemRented.getItemId());
//                                Rental rental = rentalService.createRental(userIdCreated);

                            }

                        }
                        kafkaConsumer.commitSync();

                    }catch (WakeupException e){
                        if(!closed.get()){
                            throw e;
                        }

                    }catch (Exception e){
                        log.error(e.getMessage(), e);
                    }finally {
                        log.info("kafka consumer close");
                        kafkaConsumer.close();
                    }

                }



        );
    }


    public KafkaConsumer<String, String> getKafkaConsumer() {
        return kafkaConsumer;
    }

    public void shutdown() {
        log.info("Shutdown Kafka consumer");
        closed.set(true);
        kafkaConsumer.wakeup();
    }

     */
    }