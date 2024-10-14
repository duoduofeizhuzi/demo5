# 超级英雄管理应用

这是一个使用 Spring Boot 开发的应用，旨在管理超级英雄实体。该应用提供两个端点来创建和检索超级英雄数据。

## 功能
- 创建超级英雄（HTTP POST）
- 检索所有超级英雄（HTTP GET）

## 前提条件
要运行此项目，需要安装以下软件：
- Java 17
- Maven 3.x
- Docker

### 克隆代码仓库
git clone 【https://github.com/duoduofeizhuzi/demo-2.git】


### 命令行进入根目录
cd 【/code/demo-2】

### 构建 Docker 镜像
- 命令行输入【mvn clean pacakge】
- 命令行输入【docker build -t demo-app . 】
### 运行 Docker 容器
- 命令行输入 【docker run -p 8081:8080 demo-app】

### 访问资源
在浏览器中访问 http://localhost:8081/api/superheroes 来获取超级英雄列表。可以使用工具如 Postman 来测试创建超级英雄的接口。

### 后续变动
增加body拦截器