package com.infrean.MemberMS.domain.model.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class ItemRented implements Serializable {
    private IDName idName;
    private Item item;
    private long point;
}
