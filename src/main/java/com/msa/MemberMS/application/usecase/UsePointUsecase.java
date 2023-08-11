package com.infrean.MemberMS.application.usecase;

import com.infrean.MemberMS.domain.model.vo.IDName;
import com.infrean.MemberMS.domain.model.vo.Point;
import com.infrean.MemberMS.framework.web.dto.MemberOutPutDTO;

public interface UsePointUsecase {
    public MemberOutPutDTO userPoint(long memberNo, long point) throws Exception;
}
