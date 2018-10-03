# Service
- 提供最基礎的服務(Base Service), 包含持久化(Persistence)資源的操作, 外部API呼叫..等
- 以 WebApp 的架構為主, 提供 Restful API
- 可控制 Transaction 的最大單位

## Setup
### dependency
- `spring-boot-starter-web`: 以 Restful 的形式提供 API
- `spring-boot-starter-actuator`: 客製化 HealthCheck
- `spring-cloud-starter-config`: 能至 ConfigServer 取得設定檔
- `spring-cloud-starter-netflix-eureka-client`: 註冊到 EurekaServer 並提供服務

### config
```properties
server.port=80

eureka.client.enable=true
```
- 每個 service 皆會有一個 docker 負責啟動, 這邊的 80 port 是 docker network 內部訪問用的, 不會開放給外部呼叫

### api
- `tw.com.softleader.jcconf2018.service.web.SampleController`
- 就是一個標準的 RestController

### actuator
- 自動產生 SrpingBootApp 相關運行狀態的 API, 可以根據需求於設定檔開啟要開放的 API
- Eureka 會透過呼叫 `{ip}:{port}/{servlet.path}/actuator/health` 取得 status 屬性, 來判斷服務是否可用
    - `http://localhost:8080/service/actuator/health`
    - 根據 Eureka 與各 Client 的同步週期設定而影響反應速度, 預設設定下約為30秒
- 客製化狀態需要實做 `HealthIndicator` 或繼承 `AbstractHealthIndicator`
    - 實際上 Actuator 已經有一些預設實作 diskSpace, refreshScope, discoveryComposite..等
    - 必須所有 `HealthIndicator` 為UP才會算是有效的服務

[back](../README.md#detail)
