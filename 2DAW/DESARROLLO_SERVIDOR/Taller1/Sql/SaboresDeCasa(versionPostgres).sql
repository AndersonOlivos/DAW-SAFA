create table mesa (
    id serial primary key,
    numero int,
    disponible bool default true,
    num_com_max int
);

create table pedido (
    id serial primary key,
    cliente varchar(40) null,
    id_mesa int,
    constraint fk_pedido_mesa foreign key (id_mesa) references mesa(id)
);

create table producto (
    id serial primary key,
    nombre varchar(50),
    descripcion text,
    precio numeric(10, 2)
);

create table lpedido (
    id serial primary key,
    id_pedido int,
    id_producto int,
    cantidad int,
    constraint fk_lpedido_pedido foreign key (id_pedido) references pedido(id),
	constraint fk_lpedido_producto foreign key (id_producto) references producto(id)
    );

CREATE TABLE cliente (
	id serial PRIMARY KEY,
	nombre varchar(50),
	apellidos varchar(120),
	telefono int,
	correo varchar(150),
	contrasena varchar(600)
);
