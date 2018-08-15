# Jcconf2018-SpringCloud-Demo

<img src="./qr-code.svg" height="500">

> http://bit.ly/jcconf2018-springcloud

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
├── jcconf2018-demo-config
├── jcconf2018-demo-eureka
├── jcconf2018-demo-gateway
└── jcconf2018-demo-service

# 打包 source 成 docker image
$ docker-compose build
```

### Starting the application

```
$ docker-compose up
```

TBD..

