http://192.168.99.100:9090/test

Saikoushik_Addanki@EPINHYDW07A3 MINGW64 /c/Programming/SpringBoot-Practice-Applications/spring-docker-practice (main)
$ docker build -t spring-docker-sample.jar .
Sending build context to Docker daemon  19.49MB
Step 1/4 : FROM openjdk:8
8: Pulling from library/openjdk
001c52e26ad5: Pull complete
d9d4b9b6e964: Pull complete
2068746827ec: Pull complete
9daef329d350: Pull complete
d85151f15b66: Pull complete
52a8c426d30b: Pull complete
8754a66e0050: Pull complete
Digest: sha256:86e863cc57215cfb181bd319736d0baf625fe8f150577f9eb58bd937f5452cb8
Status: Downloaded newer image for openjdk:8
 ---> b273004037cc
Step 2/4 : EXPOSE 8080
 ---> Running in f0afa8762ace
Removing intermediate container f0afa8762ace
 ---> e3e0a44a92d9
Step 3/4 : ADD /target/spring-docker-sample.jar spring-docker-sample.jar
 ---> 24f0690a0255
Step 4/4 : ENTRYPOINT ["java", "-jar", "/spring-docker-sample.jar"]
 ---> Running in ca43c0d3515b
Removing intermediate container ca43c0d3515b
 ---> 69cabdc7bba3
Successfully built 69cabdc7bba3
Successfully tagged spring-docker-sample.jar:latest
SECURITY WARNING: You are building a Docker image from Windows against a non-Windows Docker host. All files and directories added to build context will have '-rwxr-xr-x' permissions. It is recommended to double check and reset permissions for sensitive files and directories.

Saikoushik_Addanki@EPINHYDW07A3 MINGW64 /c/Programming/SpringBoot-Practice-Applications/spring-docker-practice (main)
$ docker image ls
REPOSITORY                 TAG                 IMAGE ID            CREATED             SIZE
spring-docker-sample.jar   latest              69cabdc7bba3        8 minutes ago       545MB
openjdk                    8                   b273004037cc        7 months ago        526MB

Saikoushik_Addanki@EPINHYDW07A3 MINGW64 /c/Programming/SpringBoot-Practice-Applications/spring-docker-practice (main)
$ docker run -p 9090:8080 spring-docker-sample.jar

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.5.0)

2023-03-05 17:31:49.510  INFO 1 --- [           main] c.k.d.SpringDockerPracticeApplication    : Starting SpringDockerPracticeApplication v0.0.1-SNAPSHOT using Java 1.8.0_342 on 61fca09b465b with PID 1 (/spring-docker-sample.jar started by root in /)
2023-03-05 17:31:49.516  INFO 1 --- [           main] c.k.d.SpringDockerPracticeApplication    : No active profile set, falling back to default profiles: default
2023-03-05 17:31:56.339  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2023-03-05 17:31:56.399  INFO 1 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2023-03-05 17:31:56.404  INFO 1 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.46]
2023-03-05 17:31:56.738  INFO 1 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2023-03-05 17:31:56.744  INFO 1 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 6936 ms
2023-03-05 17:32:00.592  INFO 1 --- [           main] o.s.b.a.e.web.EndpointLinksResolver      : Exposing 1 endpoint(s) beneath base path '/actuator'
2023-03-05 17:32:00.918  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2023-03-05 17:32:00.984  INFO 1 --- [           main] c.k.d.SpringDockerPracticeApplication    : Started SpringDockerPracticeApplication in 13.665 seconds (JVM running for 15.943)
2023-03-05 17:32:01.164  INFO 1 --- [           main] o.s.b.a.ApplicationAvailabilityBean      : Application availability state LivenessState changed to CORRECT
2023-03-05 17:32:01.172  INFO 1 --- [           main] o.s.b.a.ApplicationAvailabilityBean      : Application availability state ReadinessState changed to ACCEPTING_TRAFFIC
2023-03-05 17:35:14.134  INFO 1 --- [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2023-03-05 17:35:14.139  INFO 1 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2023-03-05 17:35:14.146  INFO 1 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 6 ms
