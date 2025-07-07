# 프로젝트 네이밍 및 초기화 (JAVA - SPRING BOOT)
    Group:           io.github.hachanghyun
    Artifact:        analyzer
    Name:            analyzer
    Description:     Java project analyzer and RAG platform
    Package name:    io.github.hachanghyun.analyzer
    Packaging:       Jar
    Java version:    17


# 깃허브 REPO 생성후 프로젝트 등록
## Full-package 생성후 Full-package 내에서 실행
    mkdir Javaanalyzer-platform

## gitignore 루트 디렉토리로 이동
    mv Javaanalyzer/.gitignore .gitignore

## GitHub repo로 gitignore파일 커밋
    git init
    git add .gitignore
    git commit -m "first commit"
    git branch -M main
    git remote add origin https://github.com/hachanghyun/Javaanalyzer-platform.git
    git push -u origin main 

## intellij 초기 프로젝트 열때 gradle 감지로 프로젝트 열어야 하위 스프링 프로젝트 보임


# minikube 설치 및 실행
## 1. Minikube 설치 방법 (Mac, Homebrew 기준)
    brew install minikube
## 2. Minikube 설치 확인
    minikube version

## 3. Docker 설치 확인
    Minikube는 로컬 클러스터를 Docker 위에 띄우기 때문에,
    Docker Desktop이 먼저 설치되어 실행 중이어야 합니다.

## 4. Minikube 클러스터 실행 (설치 완료 후)
    minikube start --driver=docker

### 이제 로컬에서 Kubernetes 클러스터가 뜨고, kubectl도 자동 연동됩니다.

## 5. 테스트: 클러스터 확인
    kubectl get nodes

## 6. Minikube에 Docker 이미지 직접 빌드
### Minikube는 로컬 Docker와 분리되어 있어서, 이미지를 Minikube 내부에서 빌드해줘야 합니다.

## Minikube의 Docker 환경으로 전환
    eval $(minikube docker-env)

## 이미지 빌드 (프로젝트 루트에서)
    docker build -t javaanalyzer:latest -f Javaanalyzer/Dockerfile.dev Javaanalyzer/
### → 이제 javaanalyzer:latest 이미지는 Minikube 안에서 쓸 수 있습니다.

## ✅ 7. Helm Chart 만들기
    helm create javaanalyzer-chart
### → javaanalyzer-chart 디렉토리가 생성됩니다.

## ✅ 8. values.yaml 수정
### javaanalyzer-chart/values.yaml:
    image:
        repository: javaanalyzer
        tag: latest
        pullPolicy: IfNotPresent
    
    service:
        type: NodePort
        port: 8080
        nodePort: 30080

## ✅ 9. deployment.yaml 수정 (templates/deployment.yaml)

## ✅ 10. service.yaml 수정 (templates/service.yaml)

## ✅ 11. Helm으로 배포
    helm install javaanalyzer ./javaanalyzer-chart

### 배포 확인:
    kubectl get pods
    kubectl get svc
## ✅ 12. 웹 접속 테스트
    minikube service javaanalyzer

    curl $(minikube ip):30080/actuator/health