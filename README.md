# banque-service

Description
- Service Spring Boot (Java 17) exposant une API GraphQL pour gérer des comptes et transactions.

Technologies
- Java 17
- Spring Boot 4
- Spring Data JPA (H2 en mémoire par défaut)
- GraphQL
- Maven (wrapper `mvnw` fourni)

Prérequis
- JDK 17 installé
- Windows PowerShell (exemples de commandes fournis)
- Aucun besoin d'installer Maven globalement (utiliser `.\mvnw.cmd`)

Build (Windows PowerShell)
- Builder sans tests :
    $env:MAVEN_OPTS='-Xmx512m'; & .\mvnw.cmd -DskipTests package

Run (développement)
- Lancer l'application avec le wrapper Maven :
    $env:MAVEN_OPTS='-Xmx512m'; & .\mvnw.cmd spring-boot:run

- Exécuter le jar produit :
    java -jar target/banque-service-0.0.1-SNAPSHOT.jar

- Changer le port à l'exécution :
    java -jar target/banque-service-0.0.1-SNAPSHOT.jar --server.port=8083

Endpoints importants
- GraphQL endpoint (POST) : `/graphql`

Configuration
- Fichier de configuration : `src/main/resources/application.properties` (ou `application.yml`)
- Propriété pour le port : `server.port`
- Base en mémoire par défaut : `jdbc:h2:mem:banque`

Dépannage rapide
- Erreur Maven/PowerShell : utiliser `;` et l'opérateur d'invocation `&` pour `.\mvnw.cmd`.
- Port déjà utilisé (ex: 8082) : arrêter le processus écoutant ce port ou changer `server.port`.
- Erreurs de compilation du type `class, interface, enum, or record expected` : vérifier la première ligne de chaque fichier Java (package/imports) et s'assurer qu'il n'y a pas de texte ou caractères avant la déclaration de package/classe.
- Avertissements `jakarta.persistence.Temporal` : annotation dépréciée, envisager d'utiliser `java.time` et les annotations appropriées.

Tests
- Lancer les tests :
    & .\mvnw.cmd test

Licence
- À préciser (par ex. `MIT`)
