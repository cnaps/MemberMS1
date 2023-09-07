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

- 카프카 실행
  - cd kafka
  - docker-compose up -d
- 카프카 ui 실행
  - docker-compose -f docker-compose_ui.yml up -d
- 카프카 토픽 생성 
  - docker exec -it kafka-msa /opt/kafka/bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic item-rented-topic


- 작업 시 고려사항 들
  - spring stream 3.0을 고려했으나, spring boot등의 버전을 고려했을 경우, 시기 상조임.(스웨거와의 호환등 문제 발생)
  - kafka client를 사용하는 방향으로 변경 필요 

- 도커 파일 생성
  - Dockerfile 생성
  ```
    FROM adoptopenjdk/openjdk11
    CMD ["./mvnw", "clean", "package"]
    ARG JAR_FILE_PATH=target/*.jar
    COPY ${JAR_FILE_PATH} app.jar
    EXPOSE 8080
    ENTRYPOINT ["java", "-jar", "app.jar"]
     ```

- 빌드
  - 어플리케이션 빌드

    ```
    mvn clean package 
    ```

- 컨테이너 생성
  - 도커 컨테이너 이미지 생성

    ```
     docker build -t memberms:0.0.1 . 
    ```

    ```
    docker image 
    ```

  - 도커 컨테이너 실행

    ``` 
    docker run --name MemberMS -p 8082:8082 memberms:0.0.1
    ```
