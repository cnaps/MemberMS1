package com.infrean.MemberMS.framework.adapter;

import com.infrean.MemberMS.domain.model.Member;
import com.infrean.MemberMS.domain.model.vo.IDName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, IDName> {
    // Add custom query methods if needed
}

