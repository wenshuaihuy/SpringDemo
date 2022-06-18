server:
  port: 8080
spring:
  application:
    name: "TestSpringDataJPA"
  config:
    activate:
      on-cloud-platform: "kubernetes"
  datasource:
    driver-class-name: com.mysql.jdbc.Driver
    url: jdbc:mysql://localhost:3306/testjavaproject?characterEncoding=utf-8&useOldAliasMetadataBehavior=true
    username: root
    password: 123456
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    database: mysql
  thymeleaf:
    cache: false



#配置Eureka注册中心的地址
#对于euraka-server而言，在application.properties或yml中需要配置作用在于只把当前程序当做eureka-server 而不充当eureka-client的角色
#eureka:
#  client:
#    service-url: http://localhost:8761/eureka/
#    register-with-eureka: false
#    fetch-registry: false



