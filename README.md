# demo-micro-admin-mono

RCM-MicroShop 의 ADMIN 서비스를 Monolithic 모드로 띄울 때 사용할 수 있는 boilerplate code service 입니다.
RCM-MicroShop 플랫폼의 코드는 https://github.com/rchemist/release-micro 에 공개되어 있습니다.

## 서비스 개발하기

### 1. 프로젝트 생성

이 boilerplate code 프로젝트를 다운로드하거나 fork 하여, 새 프로젝트를 만듭니다.

_이때 반드시 기존 pom.xml 파일과 MonolithicAdminApplication.java 파일의 원본 내용이 유지되어야 합니다. (추가는 가능합니다)_

<br>


### 2. 필요한 코드 추가하기

- pom.xml 에 dependency 추가하기<br>기존 프로젝트에 추가되지 않은 의존성을 추가하려면 pom.xml 의 dependency 설정을 통해 추가합니다. 
- lombok 이나 hibernate, common-utils 등 웹서비스를 개발할 때 유용한 라이브러리가 대부분 추가되어 있으므로 먼저 pom.xml 의 dependency 내역을 확인하고 이후 필요한 것들을 추가하면 됩니다.
- 서비스 개발하기<br>다른 프로젝트를 개발할 때와 완전히 동일한 방식으로 개발을 시작하면 됩니다. 단, 개발 전 아래 `실행하기` 내용을 반드시 읽고 숙지하시기 바랍니다.
- 참고로, 내장된 ADMIN 사이트는 Vaadin 으로 개발되어 있습니다. 


<br>


### 3. 관리자도구 설정

#### 로그인 화면 안내 메시지 변경

| 항목        | property                               | 입력 예시                                   | 설명                 |
|-----------|----------------------------------------|-----------------------------------------|--------------------|
 | 로그인 타이틀   | platform.config.admin.view.login-title | Rchemist Admin Console                  | 로그인 폼에 표시하는 타이틀    |
| 부가 설명 메시지 | platform.config.admin.view.login-title | Welcome to RCM MicroShop Admin Console! | 타이틀 하단에 표시되는 설명 문구 |

#### 메뉴 로고 이미지 변경
| 항목                    | property                              | 입력 예시                  |
|-----------------------|---------------------------------------|------------------------|
| 메뉴 상단 로고 이미지 URL      | platform.config.admin.view.logo-image | /images/logo.png       |
| 메뉴 상단 로고 이미지 ALT TEXT | platform.config.admin.view.logo-text  | Rchemist Admin Console |


#### 대시보드 게시판 보기 설정
| 항목                     | property                                         | 입력 예시                     | 설명                                                                       |
|------------------------|--------------------------------------------------|---------------------------|--------------------------------------------------------------------------|
| 조회 대상 게시판 Alias        | platform.config.admin.dashboard.board.alias      | notice, qna, free, report | 등록된 게시판의 alias 를 입력하면 대시보드에 해당 게시판의 최신 게시물이 표시됩니다                        |
| 표시할 게시물 개수             | platform.config.admin.dashboard.board.row-size   | 3                         | 대시보드에서 각 게시판의 게시물을 설정된 개수만큼 표시합니다                                        |
| 한 줄에 게시판을 두개씩 표시할 지 여부 | platform.config.admin.dashboard.board.split-view | true                      | 대시보드 화면에 게시판을 표시할 때 한 줄에 하나씩 표시할지(false), 한 줄에 두개씩 분할해 표시할지(true) 선택합니다. |
| 대시보드 캐시 타임(분)          | platform.config.admin.dashboard.board.refresh    | 5                         | 설정된 캐시 주기마다 게시판 데이터를 조회합니다                                               | 

#### 기타
| 항목                  | property                                 | 입력 예시                       | 설명                                                                                                                                         |
|---------------------|------------------------------------------|-----------------------------|--------------------------------------------------------------------------------------------------------------------------------------------|
| 메타데이터 캐시 여부         | platform.config.admin.metadata.cacheable | true                        | 관리자도구를 표시할 때 사용하는 각종 메타데이터를 캐시할 지 여부. 운영 시스템에는 반드시 true 로 설정해야 합니. (기본값 true)                                                              |
| 사용 가능한 메뉴를 명시적으로 설정 | platform.config.admin.menu.explicit      | DASHBOARD, CUSTOMER, TENANT | 관리자도구에 기본 제공되는 메뉴 대신, 명시적으로 사용할 메뉴를 설정하면 해당 메뉴만 표시됩니다. 입력할 수 있는 문자열은 io.rchemist.admin.router.SectionType 클래스에 정의된 SectionType.type 값 입니다. |

### 4. 이미 예약된 Controller Endpoint

다음 endpoint URL 은 플랫폼 내부에서 이미 사용중입니다. 추가 개발 시 아래 URL 은 사용할 수 없습니다.

**(중요) 해당 URL 로 endpoint 를 개발하게 되면 서비스가 실행되지 않습니다.**

IDE 에서 프로젝트를 열고 아래 각 Controller 를 탐색하면 실제 소스코드를 확인할 수 있습니다.

- /asset/**
    - io.rchemist.asset.controller.AssetManageController
    - io.rchemist.asset.controller.AssetViewController
- /customer/**
    - io.rchemist.customer.controller.CustomerController
    - io.rchemist.customer.controller.CustomerAuthenticationController
- /cms/**
    - io.rchemist.cms.group.controller.GroupController
    - io.rchemist.cms.board.controller.BoardController
    - io.rchemist.cms.page.controller.PageController
    - io.rchemist.cms.page.controller.PageFieldController
- /commerce/**
    - 커뮤니티 프로젝트에서는 지원하지 않으나, 해당 endpoint url 은 사용 금지.
- /event/**
    - 모놀리틱 서비스 모드에서는 지원하지 않으나, 해당 endpoint url 은 사용 금지.
- /tenant/**
    - io.rchemist.tenant.controller.TenantController
    - io.rchemist.tenant.security.AdminUserAuthenticationController
    - io.rchemist.tenant.security.AdminUserController
    - io.rchemist.tenant.security.ApiKeyController
    - io.rchemist.tenant.security.ApiSecurityController
    - io.rchemist.tenant.security.SecurityController
    - io.rchemist.tenant.translate.TranslateController

<br>

<br>

## 실행하기

### 1. 준비하기

서비스를 개발하기 위해서는 먼저 아래 프로그램이 설치되어야 합니다.  

- maven 3.5+ (버전은 그다지 중요하지 않음)
- jdk 11(openjdk)

### 2. 프로젝트 개발 환경

RCM Micro-Shop 플랫폼은 다음 기술로 개발되었습니다.

- SpringBoot 2.6.1
- SpringDataJPA 2.6.1
- Hibernate 5.6.0.Final
- HibernateSearch 6.1.1.Final
- QueryDsl 5.0.0
- Elasticsearch 7.15.2
- MongoDB 5
- mysql 5.8+
- Vaadin 22+

...

### 3. pom 설정
프로젝트 root pom 의 repository 설정에서 반드시 다음과 같이 repository 를 등록해야 합니다.

(boilerplate 프로젝트에는 이미 설정되어 있으므로 그대로 사용하면 됩니다)

<br>

#### 1) github repository 설정

```
<repositories>
<!-- ... -->
  <repository>
      <id>rchemist.snapshots</id>
      <url>https://github.com/rchemist/release-micro/raw/main/snapshots</url>
      <snapshots>
        <enabled>true</enabled>
        <updatePolicy>always</updatePolicy>
      </snapshots>
    </repository>
<!-- ... -->
</repositories>

```
<br>


#### 2) micro-admin-mono dependency 추가 

micro-admin-mono 는 RCM-MicroShop 의 각 마이크로서비스를 모놀리틱 모드로 편리하게 사용할 수 있도록 하나로 묶어 놓은 후 ADMIN 프로젝트를 포함해 Admin 사이트를 내장한 서비스 dependency 입니다.

```
<dependencies>
    <dependency>
      <groupId>io.rchemist</groupId>
      <artifactId>micro-admin-mono</artifactId>
      <exclusions>
        <exclusion>
          <groupId>org.springframework.cloud</groupId>
          <artifactId>spring-cloud-starter-openfeign</artifactId>
        </exclusion>
        <exclusion>
          <groupId>io.github.openfeign.form</groupId>
          <artifactId>feign-form</artifactId>
        </exclusion>
        <exclusion>
          <groupId>io.github.openfeign.form</groupId>
          <artifactId>feign-form-spring</artifactId>
        </exclusion>
        <exclusion>
          <groupId>org.springframework.cloud</groupId>
          <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </exclusion>
        <exclusion>
          <groupId>org.springframework.cloud</groupId>
          <artifactId>spring-cloud-config-client</artifactId>
        </exclusion>
      </exclusions>
    </dependency>
  </dependencies>
```
_micro-admin-mono 를 dependency 로 추가할 때 반드시 spring cloud 와 관련한 설정을 exclusion 으로 추가해야 합니다. 마이크로서비스 모드로 동작하지 않도록 하기 위해서 입니다._

<br>

#### 3) 프로젝트 build 설정

메이븐 빌드할 때 배포용 jar 파일이 생성되도록 build 스크립트에 다음 구문을 추가 합니다.

```xml
  <build>
    <finalName>${project.artifactId}-${project.version}</finalName>
    <pluginManagement>
      <plugins>
        <plugin>
          <artifactId>maven-dependency-plugin</artifactId>
          <version>${maven-dependency-plugin.version}</version>
        </plugin>
      </plugins>
    </pluginManagement>
    <plugins>
      <plugin>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-maven-plugin</artifactId>
      </plugin>
    </plugins>
  </build>
```

이 설정을 통해 SpringBoot 로 만들어진 프로젝트가 fat jar 로 빌드되어 독립적으로 실행될 수 있도록 합니다


<br>


### 4. application yml 설정

#### 1) yml load 순서
- (1) application.yml
- (2) 참조하는 각 서비스의 application-override.yml
- (3) 참조하는 각 서비스의 application-{spring.profiles.active}-override.yml
- (4) application-override.yml
- (5) application-{spring.profiles.active}-override.yml

(2) ~ (3) 의 서비스는 common, asset, cms, commerce, customer, event, tenant 순으로 load 됩니다.`

**우선순위를 신경쓰지 않고 싶다면 application-override.yml 에 설정하면 됩니다.**


<br>

#### 2) application yml 설정
DB, redis, elastic search 서버 접속 정보 등을 설정합니다.

설정을 적용할 때 반드시 yml load 우선순위에 유의하세요.

모든 yml 에 같은 설정을 할 필요는 없습니다.

위 1) 에서 설명한 바와 같이 우선순위가 높은 yml 에서 한번만 설정해 주면 됩니다.


##### (1) 서비스 포트
기본 서비스 포트는 8000 번으로 설정되어 있습니다.

이 설정도 application yml 에서 변경할 수 있습니다.

```yaml
server:
  port: 8000
https:
  port: 8010
```

##### (2) DB 접속 정보 설정

###### 모놀리틱 모드에서 단일 DB 사용하도록 설정하기

```yaml
platform:
  config:
    database:
      data-per-services: false    #단일 DB 사용

spring:
  datasource:
    rcm-rdb:
      front:
        driver-class-name: com.mysql.cj.jdbc.Driver
        jdbc-url: #MYSQL 접속 URL & 파라미터
        username: #MYSQL 접속 아이디
        password: #MYSQL 비밀번호
        url: #MYSQL URL
        hibernate:
          cache:
            use_query_cache: true
            use_second_level_cache: true
            # Hibernate CACHE 추가 설정
            redisson:
              entity-asset:
                eviction:
                  max_entries: 100000
                expiration:
                  time_to_live: 86400000
              query-asset:
                eviction:
                  max_entries: 100000
                expiration:
                  time_to_live: 86400000
          dialect: org.hibernate.dialect.MySQL5InnoDBDialect
          hbm2ddl:
            auto: update
          show_sql: true
```

_서비스 별로 DB를 분리하고자 하는 경우 /main/resources/service-properties/ 의 각 서비스 별 application.yml 에서 위의 DB 설정을 각 서비스에 맞게 추가로 설정해야 합니다._

<br>

###### mongoDB 사용하기
mongoDB를 사용하면 ASSET, BOARD 등 일부 서비스에서 RDB를 사용할 때 보다 향상된 성능을 기대할 수 있습니다. mongoDB를 사용하려면 아래와 같이 설정합니다.

```yaml
platform:
  config:
    provider:
      mongo: true
```

그리고 각 서비스 별 yml 설정으로 다음과 같이 mongoDB 접속정보를 설정합니다.
```yaml
spring:
  datasource:
    rcm-mongo: # for override spring.data.mongodb.* values each at services
      catalog:    # 서비스명: asset, cms, common, catalog, order, promotion, customer, event, tenant 로 micro-XXX 에서 micro- 가 제거된 값 
        connectionString: mongodb+srv://MONGO_CLIENT_ID:MONGO_CLIENT_PASSWORD@MONGODB_ADDRESS/rcm-catalog?retryWrites=true&w=majority&connecttimeoutms=10000&sockettimeoutms=15000&waitqueuetimeoutms=3000&maxlifetimems=60000&maxlifetimems=120000&heartbeatfrequencyms=20000&ssl=true
        database: rcm-catalog
        username: #MONGO_CLIENT_ID
        password: #MONGO_CLIENT_PASSWORD
        retryWrite: true
        authSource: admin
```
_mongoDB 를 설정할 때는 서비스 별로 어떤 컬렉션을 사용하는지 반드시 지정해야 합니다._

<br>

###### REDIS 접속 정보 설정

플랫폼의 Spring Cache 의 기본 Provider 는 jcache 로 설정되어 있습니다. jcache 의 실제 Provider 는 REDIS 입니다.

```yaml
spring:
  cache:
    type: jcache
  redis:
    host: #REDIS_ADDRESS
    port: 6379
    password: 
```

###### redisson 설정
하이버네이트에서 REDIS 캐시를 사용하기 위해 redisson 정보를 설정합니다.

/main/resources/redisson-dev.yml 에서 redisson 의 REDIS 접속 정보를 변경합니다.

```yaml
singleServerConfig:
  password: #REDIS PASSWORD
  address: #REDIS IP
```

<br>

###### ElasticSearch 설정

ES 검색엔진을 사용하는 경우, 검색 성능을 제고할 수 있습니다.

ES를 사용하려면 아래와 같이 설정합니다.

먼저 HibernateSearch 를 활성화 하기 위해 아래와 같이 설정합니다.

`/main/resources/bootstrap.yml`
```yaml
platform:
  config:
    provider:
      search: hibernate
```

<br>

그리고 application 설정을 아래와 같이 변경합니다.

```yaml
platform:
  config:
    provider:
      search: hibernate   #HibernateSearch 사용
      elastic: true

spring:
  data:
    elasticsearch:
      port: 9200
      host: #ELASTIC_SEARCH_ADDRESS
      username:
      password:
  elasticsearch:
    rest:
      port: 9200
      host: #ELASTIC_SEARCH_ADDRESS
      username: 
      password: 
  datasource:
    rcm-elastic: 
      common: # 서비스명: for override spring.data.elasticsearch.* values each at services
        port: 9200
        host: #ELASTIC_SEARCH_ADDRESS
        username:
        password: 
  jpa:
    properties:
      hibernate:
        search:
          backend:
            username:
            password: 
            uris: #http[s]://ELASTIC_SEARCH_ADDRESS:PORT
```


그 외 설정할 수 있는 각 옵션에 대한 자세한 사항은 application yml 의 각 항목의 설명을 참고 하시기 바랍니다.


<br>

#### 2) 서비스 실행 환경 설정

서비스 실행 환경은 다음과 같이 분류되며, 각각 application.yml 설정 외 추가로 yml 설정을 override 합니다.

- local: 로컬 개발 환경<br>application-local.yml<br>application-local-override.yml
- development: 개발 서버<br>application-development.yml<br>application-development-override.yml
- staging: 스테이징 서버<br>application-staging.yml<br>application-staging-override.yml
- production: 운영 서버<br>application-production.yml<br>application-production-override.yml

<br>

jvm 옵션으로 아무 설정을 하지 않으면 기본적으로 local 모드로 실행합니다.

```
String profile = System.getProperty("spring.profiles.active");
if(StringUtils.isEmpty(profile)) {
  application.setAdditionalProfiles("local");
}
```

<br>

실행 환경을 변경하려면 jvm 옵션 또는 bootstrap.yml 에 다음 옵션으로 환경을 정의합니다.

```
#운영 서버 환경 설정 예시
spring.profiles.active=production 
```




### 6. 배포 및 실행

#### 1) build
프로젝트 root 디렉토리 에서 `mvn clean install` 을 실행합니다.

배포를 위해 jar 파일만 추출하고자 하는 경우 `mvn package` 를 실행해도 됩니다.

실행 결과 다음과 같은 메시지가 출력되면 정상 완료된 것입니다.

```shell
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
```

<br>

#### 2) run

실행하기 전 jar 가 fat jar 인지 반드시 확인합니다. <br>(최소 1~200 mb 이상의 파일이어야 합니다)

기본적으로는 java -jar demo-micro-admin-mono-0.0.1-SNAPSHOT.jar 만 실행하면 됩니다. 하지만 이렇게 할 경우 spring boot jar 파일이 로드될 때 모든 class path 를 계속 탐색하게 되어 SpringBoot 의 기동 속도가 매우 느려집니다.

이 문제를 방지하기 위해 다음 구문을 이용하면 됩니다.

```shell
java -jar -Xverify:none -XX:TieredStopAtLevel=1 demo-micro-admin-mono-0.0.1-SNAPSHOT.jar
```



