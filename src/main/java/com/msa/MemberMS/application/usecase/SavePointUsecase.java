package com.infrean.MemberMS.application.usecase;

import com.infrean.MemberMS.domain.model.vo.IDName;
import com.infrean.MemberMS.domain.model.vo.Point;
import com.infrean.MemberMS.framework.web.dto.MemberOutPutDTO;

public interface SavePointUsecase {
    public MemberOutPutDTO savePoint(long memberNo, Long point);
}
