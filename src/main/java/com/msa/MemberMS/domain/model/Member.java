package com.msa.MemberMS.domain.model;

import com.msa.MemberMS.domain.model.vo.*;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long MemberNo;

    @Embedded
    private IDName idName;
    @Embedded
    private PassWord passWord;
    @Embedded
    private Email email;

    @ElementCollection
    private List<Authority> authorites = new ArrayList<Authority>();

    @Embedded
    private Point point;

    public static Member registerMember(IDName idName,PassWord pwd,Email email){

        Member member = new Member();
        member.setIdName(idName);
        member.setPassWord(pwd);
        member.setEmail(email);
        member.setPoint( Point.cratePoint());
        member.addAuthority(new Authority(UserRole.USER));
        return member;
    }


    public void savePoint(Long point)
    {
        this.point.addPoint(point);
    }

    public void usePoint(long point) throws Exception {
        this.point.removePoint(point);
    }
    public Member login(IDName idNname, PassWord password)
    {
        return this;
    }

    public void logout(IDName idName){}

    public void addAuthority(Authority authority)
    {
        this.authorites.add(authority);
    }

    public static Member sample(){
        return Member.registerMember(IDName.sample(),PassWord.sample(),Email.sample());
    }

}
