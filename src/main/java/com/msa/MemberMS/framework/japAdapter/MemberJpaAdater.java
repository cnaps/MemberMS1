package com.infrean.MemberMS.framework.japAdapter;

import com.infrean.MemberMS.application.outputPort.MemberOutPutPort;
import com.infrean.MemberMS.domain.model.Member;
import com.infrean.MemberMS.domain.model.vo.IDName;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberJpaAdater implements MemberOutPutPort {

    private final MemberRepository memberRepository;
    @Override
    public Member loadMember(long memberNo) {
        return memberRepository.findById(memberNo).get();
    }

    @Override
    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }
}
