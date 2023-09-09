package com.msa.MemberMS.framework.kafkaAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.msa.MemberMS.application.usecase.SavePointUsecase;
import com.msa.MemberMS.application.usecase.UsePointUsecase;
import com.msa.MemberMS.domain.model.event.ItemRented;
import com.msa.MemberMS.domain.model.event.ItemReturned;
import com.msa.MemberMS.domain.model.event.OverdueCleared;
import com.msa.MemberMS.domain.model.vo.IDName;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;



@Service
@RequiredArgsConstructor
public class MemberEventConsumers {

    private final Logger log = LoggerFactory.getLogger(MemberEventConsumers.class);
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final SavePointUsecase savePointUsecase;
    private final UsePointUsecase usePointUsecase;

    @KafkaListener(topics="rental_rent",groupId = "member")
    public void consumeRent(ConsumerRecord<String, String> record) throws IOException{
        System.out.printf("rental_rent:"+ record.value());
        ItemRented itemRented = objectMapper.readValue(record.value(), ItemRented.class);
        savePointUsecase.savePoint(itemRented.getIdName(),itemRented.getPoint());
    }
    @KafkaListener(topics="rental_return",groupId = "member")
    public void consumeReturn(ConsumerRecord<String, String> record) throws IOException{
        System.out.printf("rental_return:"+ record.value());
        ItemReturned itemReturned = objectMapper.readValue(record.value(), ItemReturned.class);
        savePointUsecase.savePoint(itemReturned.getIdName(),itemReturned.getPoint());
    }
    @KafkaListener(topics="overdue_clear",groupId = "member")
    public void consumeClear(ConsumerRecord<String, String> record) throws Exception {
        System.out.printf(record.value());
        OverdueCleared overdueCleared = objectMapper.readValue(record.value(), OverdueCleared.class);
        usePointUsecase.userPoint(overdueCleared.getIdName(),overdueCleared.getPoint());
    }
}