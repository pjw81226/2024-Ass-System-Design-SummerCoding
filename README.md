# 1주차 과제
## 요구사항

### MySQL과 연동한 book API 생성
- Mysql을 컨테이너로 생성 후 book 테이블 생성
  - book 테이블은 id(PK), title(제목) 두 가지 필드를 가지고 있음
- POST /book 으로 책 정보를 입력하면 mysql의 book테이블에 책 정보를 insert하는 API 생성
- GET /book/{id} 으로 book 테이블의 id에 해당하는 컬럼을 반환하는 API 생성
- GET /book 으로 book 테이블의 모든 컬럼을 반환하는 API 생성
- db 접근 기술은 jdbc만을 사용할 것(jdbctemplate까지는 허용, jpa/mybatis X)

### docker compose를 이용하여 컨테이너 생성로직 작성
- spring project, prometheus, grafana, mysql을 한 스크립트에 띄울 수 있도록 docker compose 관련 스크립트들을 작성
  - volume 관련 정보를 저장할 수 있으므로 디렉토리안에 작성해도 무방
- ass01_runner.sh를 생성하여 이를 실행하면 docker compose를 이용하여 localhost에서 모든 컨테이너에 접속할 수 있도록 쉘스크립트 작성

## 출제 목적
- mysql을 도커 컨테이너를 이용하여 구축하는 방법을 이해
- mysql과 java 프로그램간 통신하는 방법을 이해
- 여러 컨테이너를 하나하나 생성하기 버거우므로 더 나은 방법을 도입
- 쉘스크립트를 작성하여 복잡한 과정을 단 하나의 명령어로 자동화 할 수 있음을 이해
