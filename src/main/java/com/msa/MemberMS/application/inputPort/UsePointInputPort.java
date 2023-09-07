package com.msa.MemberMS.application.inputPort;

import com.msa.MemberMS.application.outputPort.MemberOutPutPort;
import com.msa.MemberMS.application.usecase.UsePointUsecase;
import com.msa.MemberMS.domain.model.Member;
import com.msa.MemberMS.domain.model.vo.IDName;
import com.msa.MemberMS.framework.web.dto.MemberOutPutDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class UsePointInputPort implements UsePointUsecase {

    private final MemberOutPutPort memberOutPutPort;
    @Override
    public MemberOutPutDTO userPoint(IDName idName, long point) throws Exception {
        Member loadMember = memberOutPutPort.loadMemberByIdName(idName);
        loadMember.usePoint(point);
        Member savedMember = memberOutPutPort.saveMember(loadMember);
        return MemberOutPutDTO.mapToDTO(savedMember);
    }
}
