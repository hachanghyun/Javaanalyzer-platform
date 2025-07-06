# 도커 dev, ci 사용 방법 정리
## 💻 로컬 개발 (빠르게 반복)
    cd Javaanalyzer
    ./gradlew build
    cd ../Javaanalyzer-platform
    docker-compose up --build javaanalyzer-dev
## 🚀 CI/CD 자동화
    docker-compose up --build javaanalyzer-ci 

## 🛠️ Minikube 설정
    minikube dashboard

