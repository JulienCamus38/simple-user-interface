# simple-user-interface

## Running the application

To accomplish this, let's first run the Spring Boot application, so the REST service is alive and listening for requests (at http://localhost:8080). Type the following commands:

```bash
$ cd ./application/
$ ./mvnw clean install
$ java -jar ./backend/target/backend-0.0.1-SNAPSHOT.jar
```

Once the Spring Boot application has been started, let's open a command console and type the following command:

```bash
$ cd ./application/frontend/
$ ng serve --open
```

This will start Angular's live development server and also open the browser at http://localhost:4200.
