package com.infrean.MemberMS.application.inputPort;

import com.infrean.MemberMS.application.usecase.SavePointUsecase;
import com.infrean.MemberMS.domain.model.vo.IDName;
import com.infrean.MemberMS.domain.model.vo.Point;

public class SaveInputPort implements SavePointUsecase {
    @Override
    public Point savePoint(IDName idName, Long point) {
        return null;
    }
}
