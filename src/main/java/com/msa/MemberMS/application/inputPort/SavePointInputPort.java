package com.infrean.MemberMS.application.inputPort;

import com.infrean.MemberMS.application.outputPort.MemberOutPutPort;
import com.infrean.MemberMS.application.usecase.SavePointUsecase;
import com.infrean.MemberMS.domain.model.Member;
import com.infrean.MemberMS.domain.model.vo.IDName;
import com.infrean.MemberMS.domain.model.vo.Point;
import com.infrean.MemberMS.framework.web.dto.MemberOutPutDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Transactional
public class SavePointInputPort implements SavePointUsecase {

    private final MemberOutPutPort memberOutPutPort;
    @Override
    public MemberOutPutDTO savePoint(long memberNo, Long point) {
        Member loadMember = memberOutPutPort.loadMember(memberNo);
        loadMember.savePoint(point);
        Member saveedMember = memberOutPutPort.saveMember(loadMember);
        return MemberOutPutDTO.mapToDTO(saveedMember);
    }
}
