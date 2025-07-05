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
    git remote add origin https://github.com/hachanghyun/Javaanalyzer.git
    git push -u origin main 

