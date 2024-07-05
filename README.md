# prometheus와 granfana를 이용한 모니터링 대쉬보드 구축

prometheus 및 metric을 위한 actuator dependency 추가 

application의 metric을 prometheus로 추적하기위해 prometheus.yml 파일 생성 및 해당 내용 추가

application을 docker를 이용해 배포하기 위해 dockerfile 생성 및 작성

docker-compose.yml을 이용해서 application, grafana, prometheus 모두 이미지 생성 및 배포

