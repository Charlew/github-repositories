Rest API that fetches data about user's Github repository.

## Deployment

Build an app:
```
./gradlew build
```
Run it
```
java -jar build/libs/github-repositories-0.0.1-SNAPSHOT.jar
```

## Integration tests

```
gradle integrationTest
```

## Usage example

```
curl http://localhost:8080/repositories/octocat/Hello-World
```
