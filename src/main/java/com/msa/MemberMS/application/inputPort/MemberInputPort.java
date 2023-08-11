package com.infrean.MemberMS.application.inputPort;

import com.infrean.MemberMS.application.usecase.MemberUsecase;
import com.infrean.MemberMS.domain.model.Member;
import com.infrean.MemberMS.domain.model.vo.Authority;
import com.infrean.MemberMS.domain.model.vo.Email;
import com.infrean.MemberMS.domain.model.vo.IDName;
import com.infrean.MemberMS.domain.model.vo.PassWord;
import com.infrean.MemberMS.framework.japAdapter.MemberRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MemberInputPort implements MemberUsecase {
    private final MemberRepository memberRepository;


    @Override
    public Member registerMember(IDName idName, PassWord pwd, Email email) {
        Member member = Member.registerMember(idName, pwd, email);
        return memberRepository.save(member);
    }

    @Override
    public Member editMember() {
        // Implement editMember logic here
        return null;
    }

    @Override
    public void savePoint(Long point) {
        // Implement savePoint logic here
    }

    @Override
    public void usePoint(Long point) throws Exception {
        // Implement usePoint logic here
    }

    @Override
    public Member login(IDName idName, PassWord password) {
        // Implement login logic here
        return null;
    }

    @Override
    public void logout(IDName idName) {
        // Implement logout logic here
    }

    @Override
    public void addAuthority(Authority authority) {
        // Implement addAuthority logic here
    }

    @Override
    public Member sample() {
        return Member.sample();
    }
}
