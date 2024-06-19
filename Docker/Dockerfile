# Utiliser une image de base officielle PostgreSQL
FROM postgres:latest

# Définir les variables d'environnement pour PostgreSQL
ENV POSTGRES_USER=admin
ENV POSTGRES_PASSWORD=secret
ENV POSTGRES_DB=mydatabase

# Copier les scripts d'initialisation SQL dans le répertoire d'initialisation
COPY ./init.sql /docker-entrypoint-initdb.d/

# Exposer le port 5432 pour PostgreSQL
EXPOSE 5432
