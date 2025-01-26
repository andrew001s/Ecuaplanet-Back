
# Ecuaplanet-Back

## Integrantes

<ul>
    <li>Carlos Oña</li>
    <li>Brandon Pozo</li>
    <li>Andrés Román</li>
    <li>Normal Uquillas</li>
</ul>

# Spring Boot Project

## ✨ Bienvenida
Este proyecto utiliza **Spring Boot** para el desarrollo de una aplicación backend. Este documento detalla cómo clonar, instalar, ejecutar el proyecto y seguir las mejores prácticas.

---

## ⚡ Requisitos previos

1. **Java 17** o superior: Descarga e instala [Java](https://adoptopenjdk.net/) si aún no lo tienes.
2. **Maven**: Para la gestión de dependencias y construcción del proyecto. Instálalo siguiendo las [instrucciones oficiales](https://maven.apache.org/install.html).
3. **Git**: Asegúrate de tener [Git](https://git-scm.com/) instalado.
4. **IDE recomendado**:**Visual Studio Code** con soporte para Java y Spring o  **IntelliJ IDEA**.

---

## 💿 Clonar el proyecto

Clona este repositorio con el siguiente comando:

```bash
git clone https://github.com/andrew001s/Ecuaplanet-Back.git
cd Ecuaplanet-Back
```

---

## 📄 Instalación de dependencias

Si no tienes las dependencias instaladas, ejecuta el siguiente comando para descargarlas:

```bash
mvn install
```

---

## 🚀 Ejecución del proyecto

### 1. Ejecutar en **IntelliJ IDEA**:

1. Abre el proyecto en IntelliJ IDEA.
2. En el menú superior, selecciona **Run** > **Run 'EcuaplanetApplication'**.

### 2. Ejecutar desde la línea de comandos:

```bash
mvn spring-boot:run
```
Esto iniciará el servidor de Spring Boot en el puerto `8080` de forma predeterminada.

### 3. Ejecutar desde Visual Studio Code:
1. Abre el proyecto en Visual Studio Code.
2. Asegúrate de tener instaladas las siguientes extensiones:
3. [Spring Boot Extension Pack](https://marketplace.visualstudio.com/items?itemName=vmware.vscode-boot-dev-pack)
4. [Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)
Si no las tienes, instálalas desde la sección de extensiones de VS Code.
En la barra de herramientas podras ver un boton de power,dentro deberías ver un botón de Run cerca del nombre de la clase ecuaplanet. Haz clic en él para ejecutar la aplicación.
---

## ⚖ Buenas prácticas

### Estructura de carpetas

Organiza los archivos del proyecto de esta manera:

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── grupo3/
│   │           └── ecuaplanet/
│   │               ├── controller/  # Controladores REST
│   │               ├── model/       # Clases de modelo o entidades
│   │               ├── repository/  # Interfaces de repositorio
│   │               ├── service/     # Lógica de negocio
│   │               └── EcuaplanetApplication.java  # Clase principal
│   └── resources/
│       ├── application.properties  # Configuraciones del proyecto
│       └── static/                # Archivos estáticos (si es necesario)
├── .gitignore  # Archivos ignorados por Git
├── pom.xml     # Archivo de configuración de Maven
└── README.md   # Este archivo
```

### Convenciones de nombres

1. **Controladores**: Los controladores deben seguir la convención `NombreEntidadController`.
2. **Servicios**: Los servicios deben tener el sufijo `Service`.
3. **Repositorios**: Los repositorios deben tener el sufijo `Repository` y extender `JpaRepository`.

### ¿Cómo organizar el código?

1. **Evitar lógica compleja en los controladores**: Los controladores deben contener solo la lógica de enrutamiento y delegar el trabajo real a los servicios.
2. **Uso de DTOs**: Si es necesario, crea objetos de transferencia de datos (DTO) en la capa de servicios para la comunicación con los controladores.

---

## 🌈 Buenas prácticas de codificación

1. **Documentar el código**: Asegúrate de documentar adecuadamente el código con comentarios y Javadoc, especialmente en los métodos públicos.
2. **Pruebas unitarias**: Usa **JUnit** y **Mockito** para crear pruebas unitarias y de integración para garantizar la calidad del código.
3. **Manejo de errores**: Usa excepciones personalizadas para manejar errores de una manera coherente.

---

## 🔣 Configuración del código

### Checkstyle y formateo de código

Para verificar el estilo del código y formatearlo, usa las siguientes configuraciones:

1. **Checkstyle**: Asegúrate de que tu código cumpla con las normas de estilo configuradas.
   Ejecuta:
   ```bash
   mvn checkstyle:check
   ```

---

## ✅ Conventional Commits

Utiliza el formato de **Conventional Commits** para los mensajes de commit:

### Formato básico:

```plaintext
:emoji: mensaje breve
```

### Ejemplos:

- ✨ `feat: :sparkles: agregar funcionalidad de inicio de sesión`
- 🐛 `fix: :bug: corregir error en validación de usuarios`
- 🖊️ `doc: actualizar la documentación del backend`

**⚠️ Importante ⚠️**: Asegúrate de que todos los commits sigan el formato de **Conventional Commits** y que el código pase las verificaciones de Checkstyle antes de realizar un push.

