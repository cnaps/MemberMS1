package com.infrean.MemberMS.domain.model.vo;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable @Setter
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
