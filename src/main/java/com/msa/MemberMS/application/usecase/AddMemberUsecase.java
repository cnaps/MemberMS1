package com.infrean.MemberMS.application.usecase;

import com.infrean.MemberMS.domain.model.Member;
import com.infrean.MemberMS.framework.web.dto.MemberInfoDTO;
import com.infrean.MemberMS.framework.web.dto.MemberOutPutDTO;

public interface AddMemberUsecase {
    public MemberOutPutDTO addMember(MemberInfoDTO memberInfoDTO);
}
