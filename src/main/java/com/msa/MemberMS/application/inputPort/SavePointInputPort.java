package com.msa.MemberMS.application.inputPort;

import com.msa.MemberMS.application.outputPort.MemberOutPutPort;
import com.msa.MemberMS.application.usecase.SavePointUsecase;
import com.msa.MemberMS.domain.model.Member;
import com.msa.MemberMS.domain.model.vo.IDName;
import com.msa.MemberMS.framework.web.dto.MemberOutPutDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class SavePointInputPort implements SavePointUsecase {

    private final MemberOutPutPort memberOutPutPort;
    @Override
    public MemberOutPutDTO savePoint(IDName idName, Long point) {
        Member loadMember = memberOutPutPort.loadMemberByIdName(idName);
        loadMember.savePoint(point);
        Member saveedMember = memberOutPutPort.saveMember(loadMember);
        return MemberOutPutDTO.mapToDTO(saveedMember);
    }
}
