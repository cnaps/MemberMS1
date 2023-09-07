package com.msa.MemberMS.domain.model.vo;


import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IDName  implements Serializable {
    private String id;

    private String name;

    public static IDName sample(){
        return new IDName("scant","jenny");
    }

    public static void main(String[] args) {
        System.out.println(sample().toString());
    }
}