package com.infrean.MemberMS.framework.adapter;

import com.infrean.MemberMS.domain.model.event.ItemRented;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.support.json.Jackson2JsonObjectMapper;

import java.awt.event.ItemEvent;
import java.io.IOException;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class MemberEventConsumers {
    private Jackson2JsonObjectMapper mapper = new Jackson2JsonObjectMapper();
    private static Logger logger = LoggerFactory.getLogger(MemberEventConsumers.class);

    @Bean
    public Consumer itemRented() {
        return (o) -> {
            logger.info("ItemRented 이벤트 수신");
            try {
                ItemRented event = mapper.fromJson(o, ItemRented.class);
                logger.info("[memberId : {}, ItemId : {}] is updated.", event.getMeberId(),event.getItemId());
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
    }

//    @Bean
//    public Supplier<String> produceEvent() {
//        return () -> {
//            // 이벤트를 생성하고 반환하는 로직을 여기에 구현합니다.
//            return "Event message";
//        };
//    }
//

}
