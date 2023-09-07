package com.msa.MemberMS.application.usecase;

import com.msa.MemberMS.domain.model.vo.IDName;
import com.msa.MemberMS.framework.web.dto.MemberOutPutDTO;

public interface SavePointUsecase {
    public MemberOutPutDTO savePoint(IDName idName, Long point);
}
