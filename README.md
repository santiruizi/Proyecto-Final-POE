# Proyecto de programación orientada a eventos

## Sistema de sede Clínica Hell Pass


Se realiza **una** solución en **Java** para el siguiente enunciado:

La clínica Hells Pass va a hacer una sede en la ciudad y desea que se realice una solución que permita controlar las citas de los pacientes con los médicos generales o de otros procedimientos **(vacunas, curaciones leves, etc),** que las hacen las enfermeras, en los consultorios correspondientes.

## Modulo Pacientes


* Se debe ingresar los siguientes datos del paciente: Tipo de documento, número de documento, nombre completo, fecha de nacimiento, dirección, ciudad de residencia, ocupación, teléfono fijo, celular, EPS, tipo de régimen (Contributivo o Subsidiado), estado.

* Poder consultar la información de un paciente que haya realizado una cita por medio de su documento.

* Listar todos los pacientes que han realizado citas en orden alfabético.

* Se debe permitir modificar los datos del paciente en dirección, teléfono fijo, celular, ciudad de residencia, país de residencia, ocupación, los demás no se podrán modificar.

* Se debe permitir la eliminación de los pacientes de usuario por medio de su documento.

## MODULO EMPLEADO

* Se debe ingresar los siguientes datos del empleado: Tipo de documento, número de documento, nombre completo, fecha de nacimiento, dirección, ciudad de residencia, cargo (medico, enfermera), celular.

* Poder consultar la información de un empleado por medio de su documento.

* Listar todos los empleados por cargo.

* Listar todos los empleados en orden alfabético.

* Se debe permitir modificar los datos del empleado en dirección, teléfono fijo, celular, ciudad de residencia, país de residencia, los demás no se podrán modificar.

* Se debe permitir la eliminación de los empleados por medio de su documento.

## MODULO CONSULTORIO

* Se debe ingresar los siguientes datos del consultorio: id de consultorio, tipo de consultorio (revisión, procedimiento), id empleado asignado (si es de revisión solo podrá registrase un médico, si es de procedimiento solo podrá registrar una enfermera), extensión de teléfono, estado (activo o inactivo), causa (se registra si el estado es inactivo, por ejemplo, por reparación o mantenimiento).

* Consultar consultorio por medio de su id.

* Consultar consultorio por medio del id del empleado.

* Consultar consultorio por estado.

* Consultar consultorio por tipo.

* Mostrar disponibilidad de consultorio para cita, si no hay cita en proceso el consultorio está disponible.

* Modificar los datos de id de empleado asignado, extensión de teléfono, estado y causa.

## MODULO CITAS

* Se debe ingresar los datos de la cita: id de la cita, documento paciente, fecha cita, hora cita (entre las 8 am y las 5pm, otra hora no será válida), tipo de consulta (revisión, procedimiento), estado cita (solicitada, en proceso, finalizada), id consultorio (tener presente el tipo de consulta para la asignación del consultorio), nivel de urgencia (baja, media, alta), cobro total.

* Si es una cita de revisión se realiza un cobro único de $50.000.

* Si es un procedimiento se registra los insumos usados, medicamentos, etc. con el costo de estos.

* Consultar las citas por su id.

* Consultar citas por documento del paciente.

* Consultar citas por documento del empleado.

* Listar todos los pacientes que han realizado citas por fecha.

* Modificar citas en fecha u hora y estado de la cita.

## Propuesta de Desarrollo


* Se **plantean 4 módulos**,  mas una bd de datos relaciones.
* Modulo **Pacientes**.
* Modulo **Empleados**.
* Modulo **Citas**.
* Modulo **Consultorio**.

 **Modulo Pacientes**:
* Este módulo se dividió en 5 etapas las cuales son:
* **1. FuncionesPacientes:** En las cuales se trabajaron lo que son metodos de busqueda y ordenación **.**
*  **2. IngresoPacientes:** Esta funcionalidad me permite el ingreso de un nuevo paciente **.**
* **3.  ModificarP:** Esta funcionalidad permite al paciente hacer alguna **modificación** en los datos personales que registro los cuales puedes ser,  **dirección, teléfono fijo, celular, ciudad de residencia, país de residencia, ocupación.**
*  **4. Paciente:** Esta funcionalidad es la maqueta que se usa para el registro de un empleado **ademas cabe aclarar**, que esta **Entidad**, es heredada de la  **Entidad Persona**, la cual comparte los **atributos primarios**.

## Tecnologías a usar


- git.
- github
- spring
- spring-bot.
- Java
<<<<<<< HEAD
- Mysql.
=======
- Mysql.
>>>>>>> 09db45a796475db97a7ba9bc63973e3c7d09dea0
