package com.msa.MemberMS.application.inputPort;

import com.msa.MemberMS.application.outputPort.MemberOutPutPort;
import com.msa.MemberMS.application.usecase.AddMemberUsecase;
import com.msa.MemberMS.domain.model.Member;
import com.msa.MemberMS.domain.model.vo.Email;
import com.msa.MemberMS.domain.model.vo.IDName;
import com.msa.MemberMS.domain.model.vo.PassWord;
import com.msa.MemberMS.framework.web.dto.MemberInfoDTO;
import com.msa.MemberMS.framework.web.dto.MemberOutPutDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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
