CREATE TABLE Mesa (
    ID_MESA INT AUTO_INCREMENT,
    ESTADO VARCHAR(30),
    NUM_COMENSALES_DISPONIBLES INT(2),
    CONSTRAINT PK_MESA PRIMARY KEY (ID_MESA),
    CONSTRAINT CH_ESTADO CHECK (ESTADO IN ('DISPONIBLE', 'NO DISPONIBLE'))
);

CREATE TABLE Pedido (
    ID_PEDIDO INT AUTO_INCREMENT,
    CLIENTE VARCHAR(40) NULL,
    ID_MESA INT,
    CONSTRAINT PK_PEDIDO PRIMARY KEY (ID_PEDIDO),
    CONSTRAINT FK_PEDIDO_MESA FOREIGN KEY (ID_MESA) REFERENCES Mesa(ID_MESA)
);

CREATE TABLE Producto (
    ID_PRODUCTO INT AUTO_INCREMENT,
    DESCRIPCION VARCHAR(50),
    PRECIO INT(5),
    CONSTRAINT PK_MESA PRIMARY KEY (ID_PRODUCTO)
);

CREATE TABLE Linea_Pedido (
    ID_LINEA_PEDIDO INT AUTO_INCREMENT,
    ID_PEDIDO INT,
    ID_PRODUCTO INT,
    CANTIDAD INT,
    CONSTRAINT PK_LINEA_PEDIDO PRIMARY KEY (ID_LINEA_PEDIDO),
    CONSTRAINT FK_LINEA_PEDIDO_PEDIDO FOREIGN KEY (ID_PEDIDO) REFERENCES Pedido(ID_PEDIDO),
	CONSTRAINT FK_LINEA_PEDIDO_PRODUCTO FOREIGN KEY (ID_PRODUCTO) REFERENCES Producto(ID_PRODUCTO)
    );

-- Insertar Mesas (suponiendo 5 mesas disponibles)
INSERT INTO Mesa (ESTADO, NUM_COMENSALES_DISPONIBLES) VALUES
('DISPONIBLE', 4),
('DISPONIBLE', 2),
('NO DISPONIBLE', 0),
('DISPONIBLE', 6),
('DISPONIBLE', 3);

-- Insertar Productos (comidas y bebidas)
INSERT INTO Producto (DESCRIPCION, PRECIO) VALUES
('Patatas Bravas', 5),
('Croquetas', 4),
('Jamón Serrano', 7),
('Chorizo al vino', 6),
('Ensaladilla Rusa', 4),
('Queso Manchego', 5),
('Calamares', 8),
('Tostas de Anchoa', 3),
('Tortilla Española', 6),
('Albóndigas', 5),
('Cerveza', 2),
('Vino Tinto', 3),
('Vino Blanco', 3),
('Refresco', 2),
('Agua', 1),
('Sidra', 3),
('Clara de limón', 2),
('Cava', 4),
('Gin Tonic', 5),
('Cóctel Mojito', 6);

-- Insertar Pedidos (suponiendo 5 pedidos diferentes, uno para cada mesa disponible)
INSERT INTO Pedido (CLIENTE, ID_MESA) VALUES
('Juan Pérez', 1),
('Maria López', 2),
('Carlos García', 4),
('Ana Sánchez', 5),
('Pedro Ruiz', 2);

-- Insertar líneas de pedido (productos con cantidades para cada pedido)
INSERT INTO Linea_Pedido (ID_PEDIDO, ID_PRODUCTO, CANTIDAD) VALUES
(1, 1, 2),  -- Juan Pérez, 2 Patatas Bravas
(1, 12, 1), -- Juan Pérez, 1 Cerveza
(2, 3, 1),  -- Maria López, 1 Jamón Serrano
(2, 11, 2), -- Maria López, 2 Vino Tinto
(3, 5, 1),  -- Carlos García, 1 Ensaladilla Rusa
(3, 15, 1), -- Carlos García, 1 Agua
(4, 7, 2),  -- Ana Sánchez, 2 Calamares
(4, 13, 1), -- Ana Sánchez, 1 Vino Blanco
(5, 10, 1), -- Pedro Ruiz, 1 Tortilla Española
(5, 14, 2), -- Pedro Ruiz, 2 Refresco
(1, 9, 3),  -- Juan Pérez, 3 Tostas de Anchoa
(2, 8, 1),  -- Maria López, 1 Chorizo al vino
(3, 6, 1),  -- Carlos García, 1 Queso Manchego
(4, 2, 2),  -- Ana Sánchez, 2 Croquetas
(5, 4, 1),  -- Pedro Ruiz, 1 Albóndigas
(1, 16, 2), -- Juan Pérez, 2 Sidra
(2, 17, 1), -- Maria López, 1 Clara de limón
(3, 19, 1), -- Carlos García, 1 Cóctel Mojito
(4, 18, 1), -- Ana Sánchez, 1 Cava
(5, 20, 1); -- Pedro Ruiz, 1 Gin Tonic



SELECT * FROM Pedido;

SELECT SUM(CANTIDAD* PRECIO) AS TOTAL_PEDIDO FROM Linea_Pedido lp, Pedido p, Producto pr WHERE lp.ID_PEDIDO = p.ID_PEDIDO AND lp.ID_PRODUCTO = pr.ID_PRODUCTO
AND p.ID_PEDIDO = 1;

SELECT DESCRIPCION, CANTIDAD AS VENDIDO FROM Linea_Pedido lp , Producto p WHERE lp.ID_PRODUCTO = p.ID_PRODUCTO GROUP BY DESCRIPCION ORDER BY VENDIDO DESC;

SELECT p.CLIENTE, pr.DESCRIPCION  , lp.CANTIDAD
FROM Pedido p
JOIN Linea_Pedido lp ON lp.ID_PEDIDO = p.ID_PEDIDO
JOIN Producto pr ON lp.ID_PRODUCTO = pr.ID_PRODUCTO 
WHERE lp.CANTIDAD = (
    SELECT MIN(lp2.CANTIDAD)
    FROM Pedido p2
    JOIN Linea_Pedido lp2 ON lp2.ID_PEDIDO = p2.ID_PEDIDO
    WHERE p2.CLIENTE = p.CLIENTE
) GROUP BY CLIENTE;

ALTER USER 'root'@'localhost' IDENTIFIED BY 'root123';

FLUSH PRIVILEGES;


