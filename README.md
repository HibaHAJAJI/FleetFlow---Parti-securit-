FleetFlow API

#Lancer le projet avec Docker Compose

# Démarrer
docker compose up --build

# Arrêter
docker compose down

# Supprimer les données MySQL
docker compose down -v

# Accès à l'API

- Swagger UI : http://localhost:8080/swagger-ui.html

# Lancer les tests
mvn test