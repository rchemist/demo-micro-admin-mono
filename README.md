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

#### 로그인 화면 설정

- 로그인 화면 설정 property 는 platform.config.admin.view.login.* 의 하위 요소 입니다.

| 항목             | property                      | 입력 예시                                   | 설명                                                                                                      |
|----------------|-------------------------------|-----------------------------------------|---------------------------------------------------------------------------------------------------------|
 | 로그인 타이틀        | title                         | Rchemist Admin Console                  | 로그인 폼에 표시하는 타이틀                                                                                         |
| 부가 설명 메시지      | description                   | Welcome to RCM MicroShop Admin Console! | 타이틀 하단에 표시되는 설명 문구                                                                                      |
| 로그인 로고 이미지     | logoImage                     | ./image/login_logo.png                  | 로그인 폼 상단에 표시할 로고 이미지. 입력하지 않으면 아무 것도 표시되지 않으며, 세로 40px 이내의 크기로 저장해야 함                                   |
| 로그인 폼 타이틀      | loginFormTitle                | 로그인                                     | 로그인 입력폼 상단에 표시될 문구                                                                                      |
| 비밀번호 찾기 폼 타이틀  | requestFormTitle              | 비밀번호 찾기                                 | 비밀번호 찾기 입력폼 상단에 표시될 문구                                                                                  |
| 아이디 라벨         | labelUsername                 | 아이디                                     | 타이틀 하단에 표시되는 설명 문구                                                                                      |
| 비밀번호 라벨        | labelPassword                 | 비밀번호                                    | 타이틀 하단에 표시되는 설명 문구                                                                                      |
| 비밀번호 찾기 입력폼 라벨 | labelRequest                  | 아이디 또는 이메일                              | 타이틀 하단에 표시되는 설명 문구                                                                                      |
| 로그인 에러 타이틀     | errorLoginSubmitTitle         | 로그인할 수 없습니다.                            | 로그인 실패 시 ! 와 함께 표시될 에러 타이틀                                                                              |
| 로그인 에러 메시지     | errorLoginSubmitDescription   | 아이디 또는 비밀번호를 다시 확인해 주세요.                | 로그인 실패 상세 설명                                                                                            |
| 비밀번호 찾기 에러 타이틀 | errorRequestSubmitTitle       | 사용자 정보를 확인할 수 없습니다.                     | 비밀번호 찾기 실패 시 ! 와 함께 표시될 에러 타이틀                                                                          |
| 비밀번호 찾기 에러 메시지 | errorRequestSubmitDescription | 아이디 또는 이메일을 다시 확인해 주세요.                 | 비밀번호 찾기 실패 시 상세 설명                                                                                      |
| 로그인 SUBMIT     | buttonLoginText               | 로그인                                     | 로그인 입력폼 SUBMIT 버튼 텍스트                                                                                   |
| 로그인 링크 텍스트     | buttonLinkLoginText           | 로그인 화면으로                                | 비밀번호 찾기 입력폼에서 로그인 입력폼으로 전환할 때 링크 텍스트                                                                    |
| 비밀번호 찾기 SUBMIT | buttonRequestText             | 비밀번호 찾기                                 | 비밀번호 찾기 입력폼 SUBMIT 버튼 텍스트                                                                               |
| 비밀번호 찾기 링크 텍스트 | buttonLinkRequestText         | 로그인이 안 되시나요?                            | 로그인 입력폼에서 비밀번호 입력폼으로 전환할 때 링크 텍스트                                                                       |
| 테마             | theme                         | red                                     | 로그인 화면 테마 선택. BLUE, LIGHT_BLUE, GREEN, LIGHT_GREEN, VIOLET, YELLOW, YELLOW_WHITE, HOT_PINK, RED , BLACK |

- 로그인 테마

![로그인_테마](./asset/login_theme.png)



#### 메뉴 로고 이미지 변경

- platform.config.admin.*

| 항목                    | property        | 입력 예시                  |
|-----------------------|-----------------|------------------------|
| 메뉴 상단 로고 이미지 URL      | view.logo-image | /images/logo.png       |
| 메뉴 상단 로고 이미지 ALT TEXT | view.logo-text  | Rchemist Admin Console |


#### 대시보드 게시판 보기 설정

- platform.config.admin.dashboard.board.*

| 항목                     | property   | 입력 예시                     | 설명                                                                       |
|------------------------|------------|---------------------------|--------------------------------------------------------------------------|
| 조회 대상 게시판 Alias        | alias      | notice, qna, free, report | 등록된 게시판의 alias 를 입력하면 대시보드에 해당 게시판의 최신 게시물이 표시됩니다                        |
| 표시할 게시물 개수             | row-size   | 3                         | 대시보드에서 각 게시판의 게시물을 설정된 개수만큼 표시합니다                                        |
| 한 줄에 게시판을 두개씩 표시할 지 여부 | split-view | true                      | 대시보드 화면에 게시판을 표시할 때 한 줄에 하나씩 표시할지(false), 한 줄에 두개씩 분할해 표시할지(true) 선택합니다. |
| 대시보드 캐시 타임(분)          | refresh    | 5                         | 설정된 캐시 주기마다 게시판 데이터를 조회합니다                                               | 

#### 관리자도구 메뉴 설정

- platform.config.admin.menu.*

| 항목       | property | 입력 예시                       | 설명                                                                                                                                         |
|----------|----------|-----------------------------|--------------------------------------------------------------------------------------------------------------------------------------------|
| 사용 가능 메뉴 | explicit | DASHBOARD, CUSTOMER, TENANT | 관리자도구에 기본 제공되는 메뉴 대신, 명시적으로 사용할 메뉴를 설정하면 해당 메뉴만 표시됩니다. 입력할 수 있는 문자열은 SectionType 클래스에 정의된 SectionType 값 입니다. 아무 설정이 없는 경우 전체 메뉴를 모두 표시합니다. |
| 사용 불가 메뉴 | exclude  | CUSTOMER, TENANT            | 관리자도구 메뉴에서 property 로 지정된 메뉴를 제거할 수 있습니다.                                                                                                  |
#### 관리자도구 로그인 보안 설정 (OTP)

다음 옵션을 활성화 하면 관리자도구에 로그인할 때 지정된 인증 수단에 의한 2 Factor 로그인 기능을 사용할 수 있습니다.

- platform.config.admin.notification.*

| 항목             | property         | 입력 예시                | 설명                                                                                                                              |
|----------------|------------------|----------------------|---------------------------------------------------------------------------------------------------------------------------------|
| 아이디 비밀번호 찾기 수단 | find-id-password | EMAIL, SMS, KAKAO... | 관리자도구의 아이디 비밀번호 찾기 할 때 로그인 정보를 어떤 타입의 메시지로 전송할지 설정합니다. io.rchemist.common.jpa.domain.type.NotificationType.type 참조.             |
| 2 Factor 로그인   | two-factor-login | SMS, KAKAO...        | 관리자도구에서 2팩터 로그인 기능을 사용할 때 Secure code 를 어떤 타입의 메시지로 전송할 것인지 설정합니다. io.rchemist.common.jpa.domain.type.NotificationType.type 참조. |

<br>

#### 관리자도구 로그인 보안 설정 (MFA)

다음 옵션을 활성화 하면 관리자도구에 로그인할 때 MFA 인증을 사용할 수 있습니다.

- platform.config.admin.security.mfa.*

| 항목               | property      | 입력 예시  | 설명                                          |
|------------------|---------------|--------|---------------------------------------------|
| MFA 사용 여부        | force         | true   | 관리자도구 로그인을 할 때 MFA 를 사용할 것인지 여부, 기본값은 false |
| MFA Code 알고리즘    | algorithm     | SHA512 | MFA 발급 코드의 해싱 알고리즘. 기본값은 SHA512             |
| MFA Code 길이      | digits-length | 12     | MFA 발급 코드의 길이. 기본값은 6                       |
| MFA Code 유효기간(초) | time-period   | 30     | MFA 발급 코드의 유효 기간(초). 기본값은 15                |


#### 관리자도구 GRID 설정


- platform.config.admin.view.*

| 항목                  | property           | 입력 예시     | 설명                                                                                                     |
|---------------------|--------------------|-----------|--------------------------------------------------------------------------------------------------------|
| 리스트그리드 필터 모드        | filter.type        | LAYER     | 리스트그리드의 상세 검색 필터를 표시할 때 목록 위에 Div 로 표시할 지(LAYER), 모달 윈도우로 띄워 표시할지(MODAL)                               |
| 리스트그리드 날짜 표시 방법     | filter.date-format | DATETIME  | 리스트그리드의 목록에 날짜를 표시할 때 날짜만(yyyy-MM-dd) 표시할 것인지(DATE), 날짜와 시각을 함께(yyyy-MM-dd HH:mm:ss) 표시할 것인지(DATETIME) |
| 리스트그리드 사용자 정보 표시 방법 | grid.user-field    | loginName | 리스트그리드의 목록에 사용자 정보를 표시할 때 로그인 아이디를 보여 줄 것인지(loginName), 사용자 이름을 보여 줄 것인지(userName)                     |


#### 관리자도구 메뉴(LNB) 설정

##### 특정 메뉴만 표시하기

관리자도구에 제공하는 메뉴 중 특정 메뉴만 표시하도록 설정할 수 있습니다. 이 경우 설정되지 않은 다른 모든 메뉴는 표시되지 않습니다.

- platform.config.admin.menu.*

| 항목       | property           | 입력 예시            | 설명                                                                                                     |
|----------|--------------------|------------------|--------------------------------------------------------------------------------------------------------|
| 표시 메뉴 지정 | explicit           | CUSTOMER,MILEAGE | 표시하고자 하는 SectionType.type 값을 , 로 구분해 공백 없이 입력                                                          |

##### 특정 메뉴를 표시하지 않기

관리자도구에 제공하는 메뉴 중 특정 메뉴만 표시하지 않도록 설정할 수 있습니다.
- platform.config.admin.menu.*

| 항목       | property | 입력 예시            | 설명                                            |
|----------|----------|------------------|-----------------------------------------------|
| 제외 메뉴 지정 | exclude  | CUSTOMER,MILEAGE | 제외하고자 하는 SectionType.type 값을 , 로 구분해 공백 없이 입력 |

*explicit 으로 설정한 메뉴를 exclude 에 설정하면 해당 메뉴가 보이지 않게 됩니다.*


#### 회원 관리 기능 설정

관리자도구 > 회원관리 기능을 설정할 수 있습니다. 

- platform.config.customer.create.admin.*

| 항목                | property | 입력 예시                       | 설명                                                                                                                                            |
|-------------------|----------|-----------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------|
| 회원 생성<br/>사용 여부   | enabled  | false                       | 관리자도구에서 회원 생성 기능을 사용할 것인지(true), 사용하지 않을 것인지(false)<br/>기본값은 false                                                                            |
 | 회원 생성 시<br/>사용 필드 | fields   | loginName<br/>,emailAddress | 관리자도구에서 회원을 생성할 때 사용할 필드를 명시적으로 지정<br/>기본값은 없으며, 이 값이 없을 때는 CustomerCreateForm 의 기본값을 사용함.<br/>단, loginName 과 emailAddress 는 지정하지 않아도 무조건 추가됨 |

- platform.config.admin.view.customer.list.*

| 항목            | property        | 입력 예시 | 설명                                               |
|---------------|-----------------|-------|--------------------------------------------------|
| Hidden 기능 활성화 | hidden-customer | true  | 관리자도구 회원 관리에서 회원 hidden 기능을 사용할지 여부. (기본값 false) |


#### 기타

- platform.config.admin.*

| 항목                     | property                           | 입력 예시    | 설명                                                                      |
|------------------------|------------------------------------|----------|-------------------------------------------------------------------------|
| 메타데이터 캐시 여부            | metadata.cacheable                 | true     | 관리자도구 메타데이터를 캐시할 지 여부. 운영 시스템에는 반드시 true 로 설정해야 합니다. (기본값 true)         |
| 사이트 이름                 | site-name                          | RCHEMIST | 관리자도구 어플리케이션에서 사용하는 사이트 이름. (기본값 없음). 메시지를 발송하거나 UI 에서 사이트 이름을 표시할 때 사용 |


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
    - 커뮤니티 프로젝트에서는 지원하지 않으나, 해당 endpoint url 은 사용 불가.
- /event/**
    - 모놀리틱 서비스 모드에서는 지원하지 않으나, 해당 endpoint url 은 사용 불가.
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

이 문제를 방지하기 위해 다음 구문을 이용합니다.

```shell
java -jar -Xverify:none -XX:TieredStopAtLevel=1 demo-micro-admin-mono-0.0.1-SNAPSHOT.jar
```



