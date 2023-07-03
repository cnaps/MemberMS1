# MemberMS1

- 회원 도메인 모델
  
![image](https://github.com/cnaps/MemberMS1/assets/15258916/6c12500d-9114-4f8b-9c66-1f82b2927b4b)
- 도메인 모델과 코드 구현 시 차이
  - deleteMember는 Member가 가질 수 없는 책임
  - IDName 과 Authoriy의 프로퍼티명이 겹치므로 OR 매핑 시 문제 발생
    - name --> rolename으로 변경
  - Point의 경우에도 vaule에서 에러 발생
    - Long pointValue 로 변경
  - authorities도 SET --> List<Authority> 변경