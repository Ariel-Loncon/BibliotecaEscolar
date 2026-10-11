[README_plantilla_EFT.md](https://github.com/user-attachments/files/28673507/README_plantilla_EFT.md)

![Duoc UC](https://www.duoc.cl/wp-content/uploads/2022/09/logo-0.png)
# 🧠 Evaluación final Transversal – Desarrollo Orientado a Objetos II

## 👤 Autor del proyecto
- **Nombre completo:** [Ariel Gustavo Loncon Lefimil]
- **Sección:** [008A]
- **Carrera:** Desarrollo de aplicaciones
- **Sede:** [Online]

---

# 📚 Sistema de Gestión de Biblioteca Escolar

## 📘 Descripción general del sistema
Este proyecto consiste en el diseño e implementación de un software de escritorio desarrollado en **Java**, orientado a optimizar y modernizar la gestión escolar de la circulación de materiales bibliográficos. El sistema facilita el control de inventario de libros, el registro de estudiantes, la autenticación por roles (bibliotecario y estudiante) y la administración eficiente de préstamos y devoluciones, incorporando control de concurrencia y persistencia en base de datos MySQL mediante JDBC.

---

## 🧱 Estructura general del proyecto

El proyecto sigue estrictamente el patrón arquitectónico **MVC (Modelo-Vista-Controlador)** y el patrón de diseño **DAO (Data Access Object)** para desacoplar la lógica de negocio, la interfaz y el acceso a datos.

```plaintext
📁 src/
├── com.Biblioteca/
│   ├── app/
│   │   └── Main.java                 # Clase principal que inicializa el sistema en el hilo EDT de Swing.
│   ├── conexion/
│   │   └── DatabaseConnection.java   # Patrón Singleton para gestionar la conexión única a MySQL.
│   ├── controlador/
│   │   ├── ControladorEstudiante.java# Intermediario para la gestión de estudiantes.
│   │   ├── ControladorLibro.java     # Intermediario para la administración del inventario.
│   │   ├── ControladorLogin.java     # Lógica de autenticación y validación de credenciales.
│   │   ├── ControladorPrestamo.java  # Controla el lanzamiento de hilos asíncronos para préstamos.
│   │   └── ControladorReporte.java   # Gestiona las consultas analíticas y estadísticas.
│   ├── dao/
│   │   ├── CategoriaDAO.java         # Operaciones de base de datos para categorías.
│   │   ├── EstudianteDAO.java        # Operaciones CRUD para la tabla de estudiantes.
│   │   ├── LibroDAO.java             # CRUD y método sincronizado transaccional de stock.
│   │   ├── PrestamoDAO.java          # Consultas multitabla (JOIN/GROUP BY) para reportes.
│   │   └── UsuarioDAO.java           # Validación de usuarios en base de datos.
│   ├── hilos/
│   │   └── PrestamoSincro.java       # Hilo en segundo plano (Runnable) para evitar bloqueo de la GUI.
│   ├── model/
│   │   ├── Categoria.java            # Entidad que representa la categoría de un libro.
│   │   ├── Estudiante.java           # Entidad que representa a un estudiante registrado.
│   │   ├── Libro.java                # Entidad que modela la información de los libros.
│   │   ├── Prestamo.java             # Entidad que almacena el registro de préstamos.
│   │   └── Usuario.java              # Entidad que gestiona credenciales y roles.
│   └── view/
│       ├── VistaEstudiante.java      # Interfaz gráfica (JFrame) para listar estudiantes.
│       ├── VistaLibro.java           # Interfaz gráfica para la gestión y visualización de libros.
│       ├── VistaLibrosDisponibles.java# Vista rápida para estudiantes con stock disponible e IDs.
│       ├── VistaLogin.java           # Ventana de autenticación de acceso.
│       ├── VistaMenuPrincipal.java   # Panel central con restricciones de navegación según rol.
│       ├── VistaPrestamo.java        # Formulario de solicitud de préstamos con autocompletado.
│       └── VistaReportes.java        # Pantalla interactiva para visualización de reportes.

© Duoc UC | Escuela de Informática y Telecomunicaciones |Desarrollo Orientado a Objetos II - Evaluación Final Transversal EFT
