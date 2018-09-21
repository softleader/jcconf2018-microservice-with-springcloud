## 從 Spring Cloud 開始的 Microservice

> 帶領大家了解 Spring Cloud 是如何把每一個 Spring Boot App 透過 Feign、Eureka 串聯起來

[http://bit.ly/jcconf2018-spring-cloud](http://bit.ly/jcconf2018-spring-cloud)

<img src="./docs/qr-code.svg" width="500">

### Requirements

- Some knowledge of Spring Framework (preferably Sprign Boot)
- Some basic knowledge of docker (run, trace logs of container, etc..)

### What Will I Learn?

- 在 45 分鐘內了解如何使用 Spring Cloud 實作微服務


## Getting Started

### Prerequisites

執行環境必須已安裝好以下軟體:

- Docker - 請從 [Docker Store](https://store.docker.com/search?offering=community&type=edition) 選擇適合的版本下載安裝, 或執行以下指令自動安裝最新版本: 
    ```
    $ curl -fsSL https://get.docker.com/ | sh
    ```
	
- Docker Compose - 如果你是安裝 Docker for Windows 或是 Docker for Mac 則已經內涵 Compose, 如果是 Linux 請參考 [
Install Compose on Linux systems](https://docs.docker.com/compose/install/#install-compose)

### Build

將此 repository clone 到本機後, 本篇的所有指令都是在 repository 的根目錄執行:

```sh
. <在這執行>
├── README.md
├── docker-compose.yml
├── jcconf2018-config/
├── jcconf2018-eureka/
├── ...
└── ...


# 打包 source 成 docker image
$ docker-compose build
```

### Starting the application

```sh
$ docker-compose up -d

# scale up service to 2 cluster
$ docker-compose up -d --scale service=2
```


## Overview
### Modules
<img src="./docs/diagram.svg">
> 本次介紹僅針對藍色的部分
- jcconf2018-config
    - Features: Config Server
    - Port: 8888:8888
    - `config-server`
- jcconf2018-eureka
    - Features: Service Discovery
    - Port: 8000:8000
    - `eureka-server`, `config-client`
- jcconf2018-gateway
    - Features: Api Router
    - Port: 8080:80
    - `eureka-client`, `config-client`, `gateway`
- jcconf2018-feign
    - Features: Composite Service
    - Port: :80
    - `eureka-client`, `config-client`, `web`, `feign`
- jcconf2018-service
    - Features: Base Service(Web App)
    - Port: :80
    - `eureka-client`, `config-client`, `web`
> 本次的服務皆啟在 docker 上，因此 Port 描述上，`:`左邊表公開Port、右邊為DockerNetwork Port

### Configs
- `bootstrap.yml`: 由於每個服務在啟動前就需要先知道`ConfigServer`的位置，這類設定應寫在此檔案
    - `spring.application.name`: 定義服務名稱
    - `spring.cloud.config.uri`: 定義`ConfigServer`位置
    - `spring.cloud.config.failFast`: 若獲取`ConfigServer`失敗是否中斷App
    - `spring.cloud.config.label`: 設定檔是git的結構，這邊是定義要從哪一個 git label 中取得 config
    - `spring.cloud.config.retry.maxAttempts`: 與`ConfigServer`連線失敗時的重試次數，預設六次，由於可以由docker來進行自動重啟，因此這邊設定不使用重試機制
- TBD...

### First Response
<img src="./docs/eureka_flow.svg">
1. 啟動
    1. `ConfigServer` 啟動
        > 由於有設定 `spring.cloud.config.failFast=true` 的緣故，其餘服務在 Config Server 可以開始提供服務前，會啟動失敗，並嘗試重啟到獲得 Config 為止
    2. `Eureka` 啟動
    3. `CompositeService`, `BaseService` 啟動，並嘗試向 `Eureka` 註冊 ServiceName
2. 回應請求
    1. 由 `Gateway` 接收所有的 request ，並根據 router 規則轉導到相對應的服務上
    2. 若轉到對向為內部服務，則 `Eureka` 會根據呼叫的 ServiceName 提供服務的 IP
    3. `Gateway` 獲取 IP 後呼叫服務

