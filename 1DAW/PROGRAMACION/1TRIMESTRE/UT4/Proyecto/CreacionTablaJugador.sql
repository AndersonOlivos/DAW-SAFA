create table jugador (
	id int(10) auto_increment primary key,
	nombre varchar(150) not null,
	numero_ranking int(10) not null,
	puntos int(20) not null,
	posicion varchar(150) not null,
	pareja varchar(150) not null,
	pais varchar(150) not null,
	partidos_jugados int(10) not null,
	partidos_ganados int(10) not null,
	partidos_perdidos int(10) not null,
	victorias_consecutivas int(10) not null,
	efectividad varchar(5) not null,
	titulos int(10) not null,
	fecha_nacimiento varchar(150) not null,
	pais_nacimiento varchar(150) not null,
	lugar_residencia varchar(150),
	altura float not null,
	url_foto varchar(400) not NULL,
	sexo varchar(1) not null
);


select nombre,sexo,url_foto from jugador;
commit;

select * from jugador;

drop table jugador;
commit;

update jugador set nombre='Arturito' where id=1;