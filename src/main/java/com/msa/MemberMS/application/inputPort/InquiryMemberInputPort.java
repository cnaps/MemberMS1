package com.infrean.MemberMS.application.inputPort;

import com.infrean.MemberMS.application.outputPort.MemberOutPutPort;
import com.infrean.MemberMS.application.usecase.InquiryMemberUsecase;
import com.infrean.MemberMS.domain.model.Member;
import com.infrean.MemberMS.domain.model.vo.IDName;
import com.infrean.MemberMS.framework.web.dto.MemberOutPutDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
