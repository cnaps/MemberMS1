package com.msa.MemberMS.framework.web.dto;

import com.msa.MemberMS.domain.model.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
public class MemberOutPutDTO {
    private String id;
    private String Name;
    private String passWord;
    private String email;

    private long point;

    public static  MemberOutPutDTO mapToDTO(Member member){
        MemberOutPutDTO meberOutPutDTO = new MemberOutPutDTO();
        meberOutPutDTO.setId(member.getIdName().getId());
        meberOutPutDTO.setName(member.getIdName().getName());
        meberOutPutDTO.setPassWord(member.getPassWord().getPresentPWD());
        meberOutPutDTO.setEmail(member.getEmail().getAddress());
        meberOutPutDTO.setPoint(member.getPoint().getPointValue());
        return meberOutPutDTO;
    }

}
