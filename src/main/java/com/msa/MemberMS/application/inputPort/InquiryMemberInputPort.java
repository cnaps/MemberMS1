package com.msa.MemberMS.application.inputPort;

import com.msa.MemberMS.application.outputPort.MemberOutPutPort;
import com.msa.MemberMS.application.usecase.InquiryMemberUsecase;
import com.msa.MemberMS.domain.model.Member;
import com.msa.MemberMS.framework.web.dto.MemberOutPutDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class InquiryMemberInputPort implements InquiryMemberUsecase {

    private final MemberOutPutPort memberOutPutPort;
    @Override
    public MemberOutPutDTO getMember(long memberNo) {
        Member loadMember = memberOutPutPort.loadMember(memberNo);
        return MemberOutPutDTO.mapToDTO(loadMember);
    }
}
