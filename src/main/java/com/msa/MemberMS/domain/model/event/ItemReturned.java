package com.msa.rentalcard.domain.model.event;

import com.msa.rentalcard.domain.model.vo.IDName;
import com.msa.rentalcard.domain.model.vo.Item;
import lombok.AllArgsConstructor;

import java.io.Serializable;


@AllArgsConstructor
public class ItemReturned implements Serializable {
    private IDName idName;
    private Item item;
    private long point;
}
