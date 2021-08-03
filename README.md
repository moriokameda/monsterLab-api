# monster-lab api 課題

## OverView

お気に入りの動画の一覧、動画一覧、動画詳細、お気に入り追加の ４つの操作ができるAPI

## SourceTree

実ソースディレクトリ構成は下記

```
src -|
     |- main -|
          |- java -|
              |- com.moriokameda.monsterlab -|
                  |- api -|
                  |   |- controller -|
                  |   |  |- converter -|
                  |   |      |- MovieConverter MovieControllerのDtoコンヴァーター
                  |   |- dto -|
                  |      |- FavoriteMovieResponseDto お気に入りMovieのデータトランスファークラス
                  |      |- MovieResponseDto Movieのデータトランスファークラス
                  |- infra -|
                  |   |- dao -|
                  |   |  |- MovieDao Movieのデータアクセスオブジェクトインターフェース
                  |   |- entity -|
                  |   |  |- MovieEntity 動画のinfra層のエンティティ
                  |   |- exception -|
                  |   |  |- NotFoundException Idがみつからない例外クラス
                  |   |- repository -|
                  |       |- MovieRepositoryImpl リポジトリ実処理クラス
                  |- application -|
                  |   |- service -|
                  |      |- MovieService 動画のサービスクラス
                  |- domain -|  
                      |- model -|
                      |  |- FavoriteCount お気に入りカウント数値オブジェクト
                      |  |- FavoriteMovie お気に入り動画エンティティ
                      |  |- Movie 動画エンティティ
                      |  |- MovieDescription 動画説明値オブジェクト
                      |  |- MovieId 動画Id値オブジェクト
                      |  |- MovieTitle 動画タイトル値オブジェクト
                      |- repository -|
                         |- MovieRepository 動画リポジトリインターフェース
                  
                    
```

## Enviroment

```
Java           : 11.0.10.hs-adpt
Spring Boot    : 2.5.3
doma2          : 2.20
flyway         : 6.5.0
mysql          : 5.7
docker         : 20.x
docker-compose : 3.x
openapi        : 3.x
```

## Installation

下記コマンドを実行し環境を構築してください。

```
1. docker-compose up -d --build
2. ./gradlew flywayMigrate
3. ./gradlew bootRun
```

## Usage

```
1. bootRun後、monsterLab-api.yamlに記載のpathに必要パラメータを追加しcurlでリクエスト
2. レスポンスを確認
```

### confirm API overView

`monsterLab-api.yaml`を参照または`redoc-static.html`をchromeに貼り付けて参照

## Author

* morio kameda

## Note

* APIリクエストの定義の確認はPostman等のAPIリクエストツールを使用し、ツールに`monsterLab-api.yaml`を読み込んで確認することをお勧めします。