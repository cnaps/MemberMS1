package com.infrean.MemberMS.domain.model.vo;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
