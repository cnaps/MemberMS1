package com.infrean.MemberMS.framework.web;

import com.infrean.MemberMS.domain.model.event.ItemRented;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MemberController {


    private final StreamBridge streamBridge;

    private static Logger logger = LoggerFactory.getLogger(MemberController.class);


    @PostMapping("/msg")
    public void sendMessage(@RequestBody String message) {
        ItemRented event = new ItemRented();
        event.setItemId(23L);
        event.setMeberId(message);
        streamBridge.send("ItemRented", event);
        logger.info("ItemRented 이벤트 발신 : {}", event);
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
