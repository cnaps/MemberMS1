package com.infrean.MemberMS.application.inputPort;

import com.infrean.MemberMS.application.outputPort.MemberOutPutPort;
import com.infrean.MemberMS.application.usecase.UsePointUsecase;
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
public class UsePointInputPort implements UsePointUsecase {

    private final MemberOutPutPort memberOutPutPort;
    @Override
    public MemberOutPutDTO userPoint(long memberNo, long point) throws Exception {
        Member loadMember = memberOutPutPort.loadMember(memberNo);
        loadMember.usePoint(point);
        Member savedMember = memberOutPutPort.saveMember(loadMember);
        return MemberOutPutDTO.mapToDTO(savedMember);
    }
}
