# Usar la imagen oficial de MySQL
FROM mysql:8.0

# Configurar variables de entorno
ENV MYSQL_DATABASE=PROG2_122024_Apellido
ENV MYSQL_ROOT_PASSWORD=1234
ENV MYSQL_USER=admin
ENV MYSQL_PASSWORD=admin123

# Copiar el script de inicialización
COPY db/init.sql /docker-entrypoint-initdb.d/

# Exponer el puerto 3306
EXPOSE 3306
