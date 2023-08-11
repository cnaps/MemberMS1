package com.infrean.MemberMS.framework.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.infrean.MemberMS.application.usecase.AddMemberUsecase;
import com.infrean.MemberMS.application.usecase.InquiryMemberUsecase;
import com.infrean.MemberMS.framework.kafkaAdapter.MemberProducer;
import com.infrean.MemberMS.framework.web.dto.MemberInfoDTO;
import com.infrean.MemberMS.framework.web.dto.MemberOutPutDTO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MemberController {


    private final MemberProducer memberProducer;

    private static Logger logger = LoggerFactory.getLogger(MemberController.class);

    private final AddMemberUsecase addMemberUsecase;
    private final InquiryMemberUsecase inquiryMemberUsecase;

    @PostMapping("/msg")
    public void sendMessage(@RequestBody String message) throws ExecutionException, InterruptedException, JsonProcessingException {

        //memberProducer.sendTest(message);
        memberProducer.sendMessage(message);
        logger.info("ItemRented 이벤트 발신 : {}", message);
    }

    @PostMapping("/Member/")
    public ResponseEntity<MemberOutPutDTO> addMember(@RequestBody MemberInfoDTO memberInfoDTO)
    {
        MemberOutPutDTO addedMember = addMemberUsecase.addMember(memberInfoDTO);
        return new ResponseEntity<>(addedMember, HttpStatus.CREATED);
    }

    @GetMapping("/Member/{no}")
    public ResponseEntity<MemberOutPutDTO> getMember(@PathVariable("no")long no)
    {
        MemberOutPutDTO member = inquiryMemberUsecase.getMember(no);
        return member != null
                ? new ResponseEntity<>(member,HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
