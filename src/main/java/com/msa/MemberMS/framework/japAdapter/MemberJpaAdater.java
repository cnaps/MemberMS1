package com.msa.MemberMS.framework.japAdapter;

import com.msa.MemberMS.application.outputPort.MemberOutPutPort;
import com.msa.MemberMS.domain.model.Member;
import com.msa.MemberMS.domain.model.vo.IDName;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberJpaAdater implements MemberOutPutPort {

    private final MemberRepository memberRepository;
    @Override
    public Member loadMember(long memberNo) {
        return memberRepository.findById(memberNo).get();
    }

    @Override
    public Member loadMemberByIdName(IDName idName) {
        return memberRepository.findMemberByIdName(idName).get();
    }

    @Override
    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }
}
