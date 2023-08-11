package com.infrean.MemberMS.application.usecase;

import com.infrean.MemberMS.domain.model.Member;
import com.infrean.MemberMS.domain.model.vo.Authority;
import com.infrean.MemberMS.domain.model.vo.Email;
import com.infrean.MemberMS.domain.model.vo.IDName;
import com.infrean.MemberMS.domain.model.vo.PassWord;

public interface MemberUsecase {
    Member registerMember(IDName idName, PassWord pwd, Email email);
    Member editMember();
    void savePoint(Long point);
    void usePoint(Long point) throws Exception;
    Member login(IDName idName, PassWord password);
    void logout(IDName idName);
    void addAuthority(Authority authority);
    Member sample();
}
