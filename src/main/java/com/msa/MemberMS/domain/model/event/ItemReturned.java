package com.msa.MemberMS.domain.model.event;

import com.msa.MemberMS.domain.model.vo.IDName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class ItemReturned implements Serializable {
    private IDName idName;
    private Item item;
    private long point;
}
