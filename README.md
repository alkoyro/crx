# crx (Rest)

# Table of Contents
1. How to
    1. [Env](#markdown-header-env)
    2. [Build and Run](#markdown-header-build-run)
    3. [API usage](#markdown-api-usage)
    4. [Logs](#markdown-logs)
    5. [Debug](#markdown-debug)

# How To

## Env <a name="markdown-header-env"></a>

-   Ensure that the following is installed;
    -   Java 8 JDK
    -   Maven (min 3.5)
    -   GIT
    -   curl or Postman

## Build and Run <a name="markdown-header-build-run"></a>

-   Check out/Clone the Project
-   Run `mvn clean install` on the **crx (project parent)** pom
-   Go to **rest/target** dir
-   Run `java -jar rest-1.0.0-SNAPSHOT.jar`

## API usage <a name="markdown-api-usage"></a>

Basic sample of how to use:
```bash
curl -XGET --header "Content-Type: application/json" --data '{"surfacePoints":["vd"]}' http://localhost:8080/hills/volume
curl -XGET --header "Content-Type: application/json" --data '{"surfacePoints":["0", "10", "0", "10"]}' http://localhost:8080/hills/volume
```

## Logs <a name="markdown-logs"></a>

log file **crx.log** is located at the same location as **rest-1.0.0-SNAPSHOT.jar**

## Debug <a name="markdown-debug"></a>
To be able to debug app use
```bash
java -Xdebug -Xrunjdwp:transport=dt_socket,server=y,address=8001,suspend=y -jar rest-1.0.0-SNAPSHOT.jar
```

# Complexity analysis
HillVolumeService#calculateHillVolume
Big O notation:
- best case: linear O(n) -> e.g.: 1,2,3,4 or 4,3,2,1
- worst case: quadratic O(n*n) -> e.g.: 10,0,0,10
