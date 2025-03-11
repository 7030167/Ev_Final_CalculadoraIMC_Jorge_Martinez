# Calculadora de IMC

## Descripción

Esta aplicación web permite a los usuarios calcular su Índice de Masa Corporal (IMC) y hacer un seguimiento de su progreso a lo largo del tiempo. La aplicación está desarrollada en Java siguiendo el patrón de arquitectura MVC y utiliza una base de datos MySQL para el almacenamiento de datos.

## Tecnologías Utilizadas

-Java EE (Servlets y JSP)

-Jakarta RESTful Web Services (JAX-RS)

-MySQL

-JDBC

-GlassFish Server

-Bootstrap (CDN) para la interfaz de usuario

-Git y GitHub para el control de versiones

## Flujo principal de la Aplicación

### 1. Vista (JSP: imc.jsp)

Muestra un formulario para que el usuario ingrese su masa corporal en kg.

Envía la solicitud al IMCServlet mediante el método POST.

Muestra el historial de cálculos recuperado del servicio REST.

### 2. Controlador (Servlet: IMCServlet)

Entrada del Usuario: Recupera el nombre del usuario desde la sesión y la masa corporal desde el formulario.

Validación de Entrada: Redirige al inicio de sesión si faltan datos.

Llamada al Servicio REST:

Utiliza jakarta.ws.rs.client.Client para llamar al servicio REST en la ruta /api/imc/calcular.

Envía los parámetros usuario y masa como datos FORM_URLENCODED.

Si la respuesta es exitosa (código 200), convierte la respuesta JSON a un objeto IMC.

Mostrar Resultado:

Si el cálculo es exitoso, reenvía la solicitud a calcularIMC.jsp con el objeto IMC.

Si falla, muestra un mensaje de error en la vista.

### 3. Servicio REST (Clase: IMCService)

Expone un endpoint POST /api/imc/calcular para calcular el IMC.

Validación de Masa:

Si la masa es menor o igual a cero, responde con un error 400.

Cálculo del IMC:

Crea un nuevo objeto IMC pasando el nombre del usuario y la masa corporal.

Obtiene la estatura del usuario desde la base de datos usando UsuarioDAO.obtenerEstatura(nombreUsuario).

### 4. Modelo (Clases: IMC y UsuarioDAO)

Cálculo del IMC:

La clase IMC almacena el nombre del usuario, la masa corporal y el resultado del IMC.

Calcula el IMC usando la fórmula:



Acceso a la Base de Datos (UsuarioDAO)

Proporciona métodos para:

Registrar un usuario (registrarUsuario).

Autenticar usuarios (autenticar).

Obtener la estatura del usuario (obtenerEstatura).

Utiliza JDBC para conectarse a MySQL con la URL jdbc:mysql://localhost:3306/calculadora_imc.

## Instalación y Configuración

Clonar el repositorio:

git clone https://github.com/usuario/calculadora-imc.git

Configurar la base de datos MySQL:

Crear la base de datos calculadora_imc.

Ejecutar el script SQL en database/schema.sql para crear las tablas necesarias.

Configurar GlassFish Server y desplegar la aplicación.

Ejecutar la aplicación en el navegador accediendo a http://localhost:8080/calculadora-imc/.

