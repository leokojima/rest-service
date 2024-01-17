# rest-service

simple crud for a digital wallet
each branch is considered a repo checkmark, play with them


## For Devs

### to save a snapshot

./mvnw package

### to run a specific snapshot

java -jar target/rest-service-0.0.1-SNAPSHOT.jar


## Honorable Branch Mentions

### swagger-ui

1. Only GetAll works
2. You can configure not to add some initial lines to h2 in application.properties
3. removed Class CreditCardCommandLineRunner, which is a simple implementation to visualize said initial lines on when debugging
4. added swagger ui
5. switch from static variable repository to JPA repository
