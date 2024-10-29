/* EJ 1 */
SELECT c.idCliente, c.nombre, c.apellido, c.DNI, c.telefono, c.direccion
FROM cliente c
WHERE c.apellido LIKE 'Pe%'
ORDER BY c.DNI



/* EJ 2 */
SELECT c.nombre, c.apellido, c.DNI, c.telefono, c.direccion
FROM cliente c 
INNER JOIN factura f ON (c.idCliente = f.idCliente)
WHERE YEAR(f.fecha)=2017 AND NOT EXISTS (
    SELECT *
    FROM factura f2
    WHERE (c.idCliente = f2.idCliente) AND YEAR(f2.fecha)!=2017
   )



/* EJ 3 */
SELECT p.nombreP, p.descripcion, p.precio, p.stock
FROM producto p
INNER JOIN detalle d ON (p.idProducto = d.idProducto)
INNER JOIN factura f ON (d.nroTicket = f.nroTicket)
INNER JOIN cliente c ON (f.idCliente = c.idCliente)
WHERE (c.DNI = 45789456) AND NOT EXISTS (
    SELECT *
    FROM detalle d2
    INNER JOIN factura f2 ON (d2.nroTicket = f2.nroTicket)
    INNER JOIN cliente c2 ON (f2.idCliente = c2.idCliente)
    WHERE c2.apellido = "García" AND d2.idProducto = d.idProducto
   	)
    


/* EJ 4 */
SELECT p.nombreP, p.descripcion, p.precio, p.stock
FROM producto p
WHERE NOT EXISTS (
    SELECT *
    FROM detalle d
    INNER JOIN factura f ON (d.nroTicket = f.nroTicket)
    INNER JOIN cliente c ON (f.idCliente = c.idCliente)
    WHERE (d.idProducto = p.idProducto) AND c.telefono LIKE '221%'
   	)
ORDER BY p.nombreP
    


/* EJ 5 */
SELECT p.nombreP, p.descripcion, p.precio, SUM(d.cantidad) AS cantidadVendida
FROM producto p
LEFT JOIN detalle d ON (p.idProducto = d.idProducto)
GROUP BY p.idProducto, p.nombreP, p.descripcion, p.precio



/* EJ 6 */
SELECT c.nombre, c.apellido, c.DNI, c.telefono, c.direccion
FROM cliente c
INNER JOIN factura f ON (c.idCliente = f.idCliente)
INNER JOIN detalle d ON (f.nroTicket = d.nroTicket)
INNER JOIN producto p ON (d.idProducto = p.idProducto)
WHERE (p.nombreP IN ('prod1','prod2')) AND NOT EXISTS (
    SELECT *
    FROM factura f2
    INNER JOIN detalle d2 ON (f2.nroTicket = d2.nroTicket)
	INNER JOIN producto p2 ON (d2.idProducto = p2.idProducto)
    WHERE (f2.idCliente = c.idCliente) AND (p2.nombreP = 'prod3')
    )
GROUP BY c.idCliente, c.nombre, c.apellido, c.DNI, c.telefono, c.direccion



/* EJ 7 */
SELECT f.nroTicket, f.total, f.fecha, f.hora, c.DNI 
FROM factura f
INNER JOIN cliente c ON (f.idCliente = c.idCliente)
INNER JOIN detalle d ON (f.nroTicket = d.nroTicket)
INNER JOIN producto p ON (d.idProducto = p.idProducto)
WHERE (p.nombreP = "prod38") OR (YEAR(f.fecha)=2019);



/* EJ 8 */
INSERT INTO cliente (idCliente, nombre, apellido, DNI, telefono, direccion)
VALUES (500002, "Jorge Luis", "Castor", 40578999, "221-4400789", "11 entre 500 y 501 nro:2587")



/* EJ 9 */
SELECT f.nroTicket, f.total, f.fecha, f.hora
FROM factura f
INNER JOIN cliente c ON (f.idCliente = c.idCliente)
WHERE (c.nombre="Jorge" AND c.apellido="Pérez") AND f.nroTicket NOT IN (
    SELECT d.nroTicket
    FROM detalle d
    INNER JOIN producto p ON (d.idProducto = p.idProducto)
    WHERE (p.nombreP = "Z")
    )



/* EJ 10 */
SELECT c.DNI, c.apellido, c.nombre
FROM cliente c
INNER JOIN factura f ON (c.idCliente = f.idCliente)
GROUP BY c.idCliente, c.DNI, c.apellido, c.nombre
HAVING SUM(f.total) > 10000000;