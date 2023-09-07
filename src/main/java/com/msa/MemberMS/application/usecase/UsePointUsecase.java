package com.msa.MemberMS.application.usecase;

import com.msa.MemberMS.domain.model.vo.IDName;
import com.msa.MemberMS.framework.web.dto.MemberOutPutDTO;

public interface UsePointUsecase {
    public MemberOutPutDTO userPoint(IDName idName, long point) throws Exception;
}
