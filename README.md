# M5-REPASO-RETO

# Repaso: Aplicación de Gestión de Préstamos Bancarios con Spring Boot y PostgreSQL
> **Larry M. Ramírez - Coach Técnico**

## Objetivo.
Desarrollar una aplicación completa en Spring Boot para la gestión de préstamos bancarios. El sistema permitirá registrar, aprobar, rechazar, y consultar préstamos, aplicando los conceptos de Spring Boot, JPA, PostgreSQL, manejo de excepciones y REST APIs. Este reto debe cubrir tanto el diseño de la base de datos como la implementación de la lógica de negocio.

## Funcionalidades Principales
1. **Préstamos Bancarios:**
    -   **Préstamo**: Debe existir una clase que represente un préstamo, con los siguientes atributos:
        -   `id`: Identificador único (generado automáticamente).
        -   `monto`: Monto solicitado para el préstamo.
        -   `interes`: Tasa de interés aplicada.
        -   `duracionMeses`: Plazo en meses del préstamo.
        -   `estado`: Estado actual del préstamo (Pendiente, Aprobado, Rechazado).
        -   `cliente`: Relación con la entidad **Cliente** que solicita el préstamo.

2. **Clientes:**
    -   **Cliente**: Debe haber una clase para representar al cliente que solicita el préstamo, con los atributos:
        -   `id`: Identificador único.
        -   `nombre`: Nombre completo del cliente.
        -   `email`: Dirección de correo electrónico.
        -   `telefono`: Número de teléfono.
        -   `direccion`: Dirección física del cliente.
        -   **Historial de préstamos**: Relación con la entidad **Préstamo**, para registrar el historial de préstamos del cliente.

3. **Operaciones sobre Préstamos:**
	-   **Solicitud de préstamo**: Permite registrar una nueva solicitud de préstamo por parte de un cliente.
	-   **Aprobación de préstamo**: Permite que un empleado del banco apruebe o rechace una solicitud.
	-   **Consulta de estado**: Permite consultar el estado de un préstamo y ver el historial de préstamos de un cliente.    
	-   **Simulación de cuotas**: Implementar una funcionalidad para calcular el valor de las cuotas mensuales con base en el monto, la tasa de interés, y la duración del préstamo (usando fórmulas financieras simples).

4. **Historial de Préstamos:**
    -   Registrar el historial de cada préstamo en una tabla PostgreSQL, con información sobre:
        -   **Monto** solicitado.
        -   **Estado** del préstamo.
        -   **Fecha de creación** y **fecha de actualización**.

5. **Consultas:**
    -   **Consultar préstamo**: Consultar el préstamo por ID, y permitir que el cliente vea el historial de los últimos 3 préstamos.
    -   **Historial de clientes**: Permitir que el banco consulte el historial de préstamos de un cliente específico.

**Nota:** Al igual que los talleres, el reto debe entregarse por medio de la estrategia establecida para la formación, por medio de un Pull Request desde el repositorio Fork hacia la rama main del repositorio del reto.
