# Entrega Final - Talento Tech (Java & Springboot)

**API REST** - Gestion de **Proveedores**

- Diseñada con una arquitectura modular **MVC**



**Prueba de API**

1) Clonar el repositorio
```bash
git clone https://github.com/Ivosaja/proyecto_final_ivosaja_java_springboot.git
```

2) Dirigirse a la carpeta raiz del proyecto
```bash
cd proyecto_final_ivosaja_java_springboot/
```

3) Levantar la BD con Docker

> [!IMPORTANT]
> Debes tener Docker instalado en tu maquina y corriendo

```bash
# Levanta los contenedores definidos en el archivo docker-compose.yml
docker compose up  
```

4) Levantar la API realizada en springboot
- Dirigirse a ```src/main/java/com/talentotech/gestionproveedores/GestionProveedoresApplication.java```
- Click en Run dentro del IDE o abrir
- (Otra opcion): Abrir terminal dentro de la carpeta raiz del proyecto y ejecutar: 
```bash
./mvnw spring-boot:run
```

5) Ver los cambios reflejados en la BD

```bash
# Abre una terminal interactiva bash en el contenedor
# "gestion_proveedores_mysql", donde se encuentra la base de datos
docker exec -it gestion_proveedores_mysql bash
```

```bash
# Entras al servicio de MySQL
mysql -u root -p
```
> 


```sql
/* Selecciona la BD gestion_proveedores */
USE gestion_proveedores;

/*
Listo, ya podes ver los registros en la tabla 
donde se almacenan los proveedores
*/
SELECT * FROM proveedor; 
```


