package com.infrean.MemberMS.application.usecase;

import com.infrean.MemberMS.domain.model.vo.IDName;
import com.infrean.MemberMS.framework.web.dto.MemberOutPutDTO;

public interface InquiryMemberUsecase{
    public MemberOutPutDTO getMember(long memberNo);
}
