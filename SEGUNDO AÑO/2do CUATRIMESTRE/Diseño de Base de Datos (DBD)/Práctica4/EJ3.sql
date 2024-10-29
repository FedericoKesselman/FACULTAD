/* EJ 1 */
SELECT i.DNI, i.nombre, i.apellido, i.direccion, i.email 
FROM integrante i
WHERE YEAR(i.fecha_nacimiento)>=1980 AND YEAR(i.fecha_nacimiento)<=1990 AND EXISTS (
    SELECT *
    FROM recital r
	WHERE r.codigoB = i.codigoB AND YEAR(r.fecha)=2023 
    )



/* EJ 2 */
SELECT b.nombreBanda, b.genero_musical, b.año_creacion 
FROM banda b 
INNER JOIN recital r ON (b.codigoB = r.codigoB)
WHERE YEAR(r.fecha)=2023 AND NOT EXISTS (
    SELECT *
    FROM recital r2
    WHERE r2.codigoB = b.codigoB AND YEAR(r2.fecha)=2022
    )
GROUP BY b.codigoB;



/* EJ 3 */
SELECT b.nombreBanda, r.fecha, r.hora, e.nombre_escenario AS escenario, e.ubicacion AS ubicacionEscenario
FROM recital r
INNER JOIN banda b ON (b.codigoB = r.codigoB)
INNER JOIN escenario e ON (r.nroEscenario = e.nroEscenario)
WHERE r.fecha="2023-12-04";



/* EJ 4 */
SELECT i.DNI, i.nombre, i.apellido, i.email
FROM integrante i
INNER JOIN recital r ON (i.codigoB = r.codigoB)
INNER JOIN escenario e ON (r.nroEscenario = e.nroEscenario)
WHERE e.nombre_escenario = "Gustavo Cerati"
INTERSECT
SELECT i.DNI, i.nombre, i.apellido, i.email
FROM integrante i
INNER JOIN recital r ON (i.codigoB = r.codigoB)
INNER JOIN escenario e ON (r.nroEscenario = e.nroEscenario)
WHERE e.nombre_escenario = "Carlos Gardel";



/* EJ 5 */
SELECT b.nombreBanda, b.genero_musical, b.año_creacion
FROM banda b
INNER JOIN integrante i ON (b.codigoB = i.codigoB)
GROUP BY b.codigoB, b.nombreBanda, b.genero_musical, b.año_creacion
HAVING COUNT(i.DNI)>8;



/* EJ 6 */
SELECT e.nombre_escenario, e.ubicacion, e.descripcion
FROM escenario e
INNER JOIN recital r ON (e.nroEscenario = r.nroEscenario)
INNER JOIN banda b ON (r.codigoB = b.codigoB)
WHERE b.genero_musical = "Rock And Roll"

EXCEPT

SELECT e.nombre_escenario, e.ubicacion, e.descripcion
FROM escenario e
INNER JOIN recital r ON (e.nroEscenario = r.nroEscenario)
INNER JOIN banda b ON (r.codigoB = b.codigoB)
WHERE b.genero_musical != "Rock And Roll"

ORDER BY nombre_escenario;

/* En MySQL, cuando se utilizan operaciones de conjunto (UNION, INTERSECT, EXCEPT), 
no se permite el uso de alias de tabla en la cláusula ORDER BY. */



/* EJ 7 */
SELECT b.nombreBanda, b.genero_musical, b.año_creacion
FROM banda b
INNER JOIN recital r ON (b.codigoB = r.codigoB)
INNER JOIN escenario e ON (r.nroEscenario = e.nroEscenario)
WHERE e.cubierto=true AND YEAR(r.fecha)=2023;



/* EJ 8 (DUDA) */ 
SELECT e.nombre_escenario, COUNT(e.nroEscenario) AS cantidadDeRecitales2024
FROM escenario e
LEFT JOIN recital r ON (e.nroEscenario = r.nroEscenario) 
WHERE YEAR(r.fecha)=2024
GROUP BY e.nroEscenario, e.nombre_escenario;



/* EJ 9 */
UPDATE banda SET nombreBanda = "Memphis la Blusera" WHERE nombreBanda = "Mempis la Blusera"
















