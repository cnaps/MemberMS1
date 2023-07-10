package com.infrean.MemberMS.framework.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.infrean.MemberMS.domain.model.event.ItemRented;
import com.infrean.MemberMS.framework.adapter.MemberProducer;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MemberController {


    private final MemberProducer memberProducer;

    private static Logger logger = LoggerFactory.getLogger(MemberController.class);


    @PostMapping("/msg")
    public void sendMessage(@RequestBody String message) throws ExecutionException, InterruptedException, JsonProcessingException {

        //memberProducer.sendTest(message);
        memberProducer.sendMessage(message);
        logger.info("ItemRented 이벤트 발신 : {}", message);
}

//    @PostMapping
//    public ResponseEntity<Member> registerMember(@RequestBody MemberRequestDTO requestDTO) {
//        // Map requestDTO to IDName, PassWord, Email objects
//        IDName idName = // ...
//                PassWord passWord = // ...
//                Email email = // ...
//                Member member = memberUsecase.registerMember(idName, passWord, email);
//        return ResponseEntity.ok(member);
//    }
}
