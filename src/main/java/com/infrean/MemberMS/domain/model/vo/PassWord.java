package com.infrean.MemberMS.domain.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassWord {
    public String presentPWD;
    public String pastPWD;

    public static PassWord sample(){
        return new PassWord("12345","abcde");
    }
}
