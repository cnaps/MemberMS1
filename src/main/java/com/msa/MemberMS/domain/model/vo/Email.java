package com.msa.MemberMS.domain.model.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Embeddable;
@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Email {
    public String address;

    public static Email sample(){
        return new Email("scant10@gmail.com");
    }
}
