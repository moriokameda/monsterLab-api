# monster-lab api 課題

## OverView

お気に入りの動画の一覧、動画一覧、動画詳細、お気に入り追加の
４つの操作ができるAPI

## Enviroment

```
Java        : 11.0.10.hs-adpt
Spring Boot : 2.5.3
doma2       : 2.20
flyway      : 6.5.0
mysql       : 5.7
```

## Installation

```
1. docker-compose up -d --build
2. ./gradlew flywayMigrate
3. ./gradlew bootRun
4. http://localhost:8080
```