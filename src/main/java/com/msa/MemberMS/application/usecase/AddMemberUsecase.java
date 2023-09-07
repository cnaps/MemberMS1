package com.msa.MemberMS.application.usecase;

import com.msa.MemberMS.framework.web.dto.MemberInfoDTO;
import com.msa.MemberMS.framework.web.dto.MemberOutPutDTO;

public interface AddMemberUsecase {
    public MemberOutPutDTO addMember(MemberInfoDTO memberInfoDTO);
}
