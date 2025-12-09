# Gestión de Proveedores - API REST (Spring Boot + MySQL)


**API REST** desarrollada con **Spring Boot**, siguiendo una arquitectura **MVC**, utilizando **JPA/Hibernate** para la persistencia de datos, **Lombok** para getters, setters y constructors con el objetivo de reducir codigo boilerplate y una base de datos **MySQL dockerizada** para facilitar la ejecución en cualquier entorno.

Permite realizar un **CRUD completo** de proveedores y filtrarlos por **rubro** y **tipo** mediante parámetros opcionales **(query params)**

[Video demostracion de la API](https://youtu.be/VWoce2aBjkA?si=OGjCslMx3VfL04VB)

### Requisitos
- JDK de Java 17
- Docker

### Tecnologias utilizadas
- Java 17
- Spring Boot
    - Spring Web
    - Spring Data JPA
    - Spring Validation (Jakarta)
    - Lombok
- Hibernate (ORM)
- MySQL (via Docker)
- Maven

---


### Endpoints de la API

- `GET /api/v1/proveedores` - Listar todos los proveedores o buscar segun criterios (rubro, tipo)
    - **Parametros opcionales (query params):**
        - `rubro` - Buscar por rubro (ALIMENTOS, TECNOLOGIA, CONSTRUCCION)
        - `tipo` - Buscar por tipo (MAYORISTA, MINORISTA, DISTRIBUIDOR, FABRICANTE)
    - **Ejemplos:**
        - `/api/v1/proveedores?rubro=ALIMENTOS` - Proveedores cuyo rubro sea ALIMENTOS
        - `/api/v1/proveedores?tipo=MAYORISTA` - Proveedores cuyo tipo sea MAYORISTA
        - `/api/v1/proveedores?rubro=ALIMENTOS&tipo=MAYORISTA` - Proveedores cuyo rubro sea ALIMENTOS y cuyo tipo sea MAYORISTA
- `GET /api/v1/proveedores/{id}` - Obtener un proveedor por ID
- `POST /api/v1/proveedores` - Crear un nuevo proveedor
- `PUT /api/v1/proveedores/{id}` - Actualizar un proveedor existente
- `DELETE /api/v1/proveedores/{id}` - Eliminar un proveedor existente  

---

### Estructura del proyecto

```bash
src/
 └── main/
      ├── java/com/talentotech/gestionproveedores/
      │    ├── controller/       # Controladores REST
      │    ├── service/          # Lógica de negocio
      │    ├── repository/       # Acceso a datos JPA
      │    ├── model/            # Entidades JPA
      │    ├── enums/            # Enumeraciones (TipoRubro, TipoProveedor)
      │    ├── exception/        # Excepciones personalizadas
      │    ├── errors/           # Manejo de excepciones
      │    └── GestionProveedoresApplication.java
      │
      └── resources/
           └── application.properties # Configuraciones
```

---

### Prueba de API

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
- Opcion 1): Ejecutar la clase ```src/main/java/com/talentotech/gestionproveedores/GestionProveedoresApplication.java```
- Opcion 2): Abrir terminal dentro de la carpeta raiz del proyecto y ejecutar: 
```bash
./mvnw spring-boot:run
```

> [!NOTE]
> La API estara disponible en <http://localhost:8080/api/v1/proveedores>

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
> [!TIP]
> Usar contraseña definida en application.properties

```sql
/* Selecciona la BD gestion_proveedores */
USE gestion_proveedores;

/*
Listo, ya podes ver los registros en la tabla 
donde se almacenan los proveedores
*/
SELECT * FROM proveedor; 
```

6) Una vez testeada, apagar aplicacion y contenedores

```bash
# Detener aplicacion de Spring Boot (API)
Ctrl + C

# Detener contenedores (BD)
docker compose down

# Detener contenedores y limpieza total de datos (eliminacion de volumenes)
docker compose down -v
```


