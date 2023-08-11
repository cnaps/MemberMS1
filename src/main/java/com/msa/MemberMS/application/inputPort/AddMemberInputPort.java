package com.infrean.MemberMS.application.inputPort;

import com.infrean.MemberMS.application.outputPort.MemberOutPutPort;
import com.infrean.MemberMS.application.usecase.AddMemberUsecase;
import com.infrean.MemberMS.domain.model.Member;
import com.infrean.MemberMS.domain.model.vo.*;
import com.infrean.MemberMS.framework.web.dto.MemberInfoDTO;
import com.infrean.MemberMS.framework.web.dto.MemberOutPutDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AddMemberInputPort implements AddMemberUsecase {

    private final MemberOutPutPort memberOutPutPort;
    @Override
    public MemberOutPutDTO addMember(MemberInfoDTO memberInfoDTO) {

        IDName idName = new IDName(memberInfoDTO.getId(),memberInfoDTO.getName());
        PassWord pwd = new PassWord(memberInfoDTO.getPassWord(),memberInfoDTO.getPassWord());
        Email email = new Email(memberInfoDTO.getEmail());
        Member addedMember = Member.registerMember(idName,pwd,email);
        Member savedMember = memberOutPutPort.saveMember(addedMember);

        return MemberOutPutDTO.mapToDTO(savedMember);

    }
}
