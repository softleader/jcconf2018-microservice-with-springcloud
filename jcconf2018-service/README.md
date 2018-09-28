# Service
- 提供最基礎的服務，包含持久化(Persistence)資源的操作等
- 以 WebApp 的架構為主，提供 Restful Api

## Setup
### dependency
- web: 以 Restful 的形式提供 Api
- actuator: 客製化 HealthCheck
- config client: 能至 ConfigServer 取得設定檔
- eureka client: 註冊到 EurekaServer 並提供服務

### config
```properties
server.port=80

eureka.client.enable=true
```
- 每個 service 皆會有一個 docker 負責啟動, 這邊的 80 port 是 docker network 內部訪問用的, 不會開放給外部呼叫

### api
- `tw.com.softleader.jcconf2018.service.web.SampleController`
- 就是一個標準的 RestController
