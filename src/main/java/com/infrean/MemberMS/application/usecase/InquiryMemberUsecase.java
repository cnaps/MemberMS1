package com.infrean.MemberMS.application.usecase;

import com.infrean.MemberMS.framework.web.dto.MemberOutPutDTO;

public interface InquiryUsecase {
    public MemberOutPutDTO getBookInfo(long bookNo);
}
