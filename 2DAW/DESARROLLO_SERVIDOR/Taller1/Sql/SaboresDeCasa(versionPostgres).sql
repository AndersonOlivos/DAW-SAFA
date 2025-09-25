create table mesa (
    id serial primary key,
    numero int, /* de 101 a 120 se refiere a interior y de 201 a 220 se refiere a terraza */
    disponible bool default true,
    num_comesales_max int
);

create table cliente (
	id serial primary key,
	nombre varchar(50),
	apellidos varchar(120),
	telefono int,
	correo varchar(150),
	contrasena varchar(600)
);

create table pedido (
    id serial primary key,
    id_cliente int null,
    id_mesa int,
    num_comensales int,
    precio_total numeric(10,2) null,
    estado int default 0, /*PENDIENTE, COMPLETADO, CANCELADO*/
    constraint fk_pedido_cliente foreign key (id_cliente) references cliente(id),
    constraint fk_pedido_mesa foreign key (id_mesa) references mesa(id)
);

create table producto (
    id serial primary key,
    nombre varchar(50),
    ingredientes text,
    precio numeric(10, 2),
    tipo int default 0, /*BEBIDA CALIENTE, REFRESCO, COMIDA, ETC*/
    subtipo int default 0 /*NULL, TOSTADA, DULCE, ETC*/
);
	
create table lpedido (
    id serial primary key,
    id_pedido int,
    id_producto int,
    cantidad int,
    constraint fk_lpedido_pedido foreign key (id_pedido) references pedido(id),
	constraint fk_lpedido_producto foreign key (id_producto) references producto(id)
);


