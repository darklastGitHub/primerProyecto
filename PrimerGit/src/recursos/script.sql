/**
 * Tabla base de datos.
 * PostgreSQL.
 *
 *  Daniel's
 * Created: 1/04/2017
 */
create table profesional(
especializacion varchar(50),
nombre varchar(30),
apellido varchar(30),
cedula varchar (15),
edad integer,
telefono varchar(30),
primary key(cedula)
)
