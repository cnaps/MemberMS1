package com.msa.MemberMS.application.usecase;

import com.msa.MemberMS.framework.web.dto.MemberOutPutDTO;

public interface InquiryMemberUsecase{
    public MemberOutPutDTO getMember(long memberNo);
}
