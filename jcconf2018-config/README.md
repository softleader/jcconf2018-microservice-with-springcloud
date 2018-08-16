# Jcconf2018 Demo Config

- `./config/`
    - spring config server 預設是利用 git 管理 config
    - 為了方便起一個docker的獨立環境，我們這邊不使用外部 git server，而是在 docker 內部 init git server
    - 此資料夾即是 base
    > git init 會透過 ./entrypoint.sh 執行

- `./config/{spring.application.name}.properties`
    - spring boot app 在向 config server 取得設定檔時會根據自己的 `spring.application.name` 來取得相對應設定檔
    - 若有共通的設定，可以設定在 `./config/application.properties`
