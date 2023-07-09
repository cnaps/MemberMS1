package com.infrean.MemberMS.domain.model.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class ItemRented {
    public String meberId;

    public Long itemId;

    public Long point;

}
