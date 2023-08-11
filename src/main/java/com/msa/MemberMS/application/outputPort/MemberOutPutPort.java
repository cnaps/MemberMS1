package com.infrean.MemberMS.application.outputPort;

import com.infrean.MemberMS.domain.model.Member;
import com.infrean.MemberMS.domain.model.vo.IDName;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberOutPutPort {
    public Member loadMember(long memberNo);

    public Member saveMember(Member member);
}
