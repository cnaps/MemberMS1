package com.msa.MemberMS.domain.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Embeddable;
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Authority {
    public UserRole roleName;

    public static Authority sample()
    {
        return new Authority(UserRole.USER);
    }
}
