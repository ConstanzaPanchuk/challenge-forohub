<h1 align="center"> Challenge Alura – Foro Hub API :paperclip:</h1>

:notebook: **Descripción del proyecto**

ForoHub es una API REST desarrollada con Java y Spring Boot que permite gestionar tópicos dentro de un foro.
Los usuarios pueden crear, consultar, actualizar y eliminar tópicos mediante endpoints protegidos con autenticación JWT.
El proyecto fue desarrollado como parte del challenge de backend de Alura, con el objetivo de practicar el uso de Spring Boot, Spring Security, JPA y JWT.


:computer: **Tecnologías utilizadas**
- Java 17
- Spring Boot 4.0.3
- Spring Data JPA
- Spring Security
- JWT (JSON Web Token)
- MySQL
- Maven
- Postman (para pruebas de la API)


:hammer: **Funcionalidades del proyecto**
- Crear un nuevo tópico

- Listar todos los tópicos

- Consultar un tópico por ID

- Actualizar un tópico

- Eliminar un tópico

- Autenticación de usuarios mediante JWT


:closed_lock_with_key: **Seguridad**

La API utiliza Spring Security junto con JWT para proteger los endpoints.
Solo el endpoint /login es público. Todos los demás requieren autenticación mediante token.


:camera: **Capturas de pantalla**
- Login en Postman
<img width="1221" height="699" alt="loginForoHub" src="https://github.com/user-attachments/assets/686b0684-67f8-4fa1-ad44-1c2766f08d3f" />
- Se ingresa el token dado en la pestaña de Authorization
<img width="1231" height="696" alt="loginForoHub2" src="https://github.com/user-attachments/assets/02ef7ba4-0167-4dd2-8b77-ebb772bff54c" />
- Listar topicos
<img width="1224" height="696" alt="ListarTopicos" src="https://github.com/user-attachments/assets/0f8ea42e-0b8e-4dd0-8f8e-8f6efc24feb7" />
- Listar topicos por curso
<img width="1222" height="694" alt="ListarPorCurso" src="https://github.com/user-attachments/assets/1b5a2e3e-aa47-4705-98bb-5a2c2d9b6a69" />
- Buscar topico por ID
<img width="1227" height="536" alt="BuscarTopicoPorId" src="https://github.com/user-attachments/assets/3e33239d-e488-4891-9930-479bad57bc81" />
- Actualizar topicos
<img width="1237" height="689" alt="ActualizarTopico" src="https://github.com/user-attachments/assets/8dfa16fd-553b-4e22-948c-d259c523beb4" />
- Eliminar topicos
<img width="1232" height="467" alt="EliminarTopico" src="https://github.com/user-attachments/assets/72c1c8a7-450d-4300-8a40-8eed634d597a" />
