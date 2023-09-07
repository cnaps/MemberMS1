package com.msa.MemberMS.domain.model.event;

import com.msa.MemberMS.domain.model.vo.IDName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@Getter @Setter
public class OverdueCleared implements Serializable {
    public IDName idName;
    public long point;
}
