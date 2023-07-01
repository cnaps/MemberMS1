package com.infrean.MemberMS;

import com.infrean.MemberMS.domain.model.Member;
import com.infrean.MemberMS.domain.model.vo.Email;
import com.infrean.MemberMS.domain.model.vo.IDName;
import com.infrean.MemberMS.domain.model.vo.PassWord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MemberMsApplication {

	public static void main(String[] args) throws Exception {
		dominTest();
		SpringApplication.run(MemberMsApplication.class, args);
	}

	public static void dominTest() throws Exception {
		System.out.println("------------도메인 모델 테스트 진행------------");
		System.out.println("회원 등록");
		var member = Member.registerMember(IDName.sample(), PassWord.sample(), Email.sample());
		System.out.println(member.toString());


		System.out.println("포인트 10 추가");
		member.savePoint(10L);

		System.out.println(member.getPoint());
		System.out.println("포인트 20 추가");
		member.savePoint(20L);
		System.out.println(member.getPoint());

		System.out.println("포인트 10 감소");
		member.usePoint(10L);
		System.out.println(member.getPoint());

		System.out.println("-----------------------------------------");

	}
}

