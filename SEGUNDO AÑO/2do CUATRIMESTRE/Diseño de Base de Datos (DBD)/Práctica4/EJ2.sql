/* EJ 1 */
SELECT a.especie, a.años, a.calle, a.codigoPostal, l.nombreL as localidad
FROM arbol a
INNER JOIN poda p ON (a.nroArbol = p.nroArbol)
INNER JOIN podador pr ON (p.DNI = pr.DNI)
INNER JOIN localidad l ON a.codigoPostal = l.codigoPostal
WHERE (pr.nombre = "Juan" AND pr.apellido = "Perez") OR (pr.nombre = "Jose" AND pr.apellido = "García");



/* EJ 2 */
SELECT pr.DNI, pr.nombre, pr.apellido, pr.fnac, l.nombreL as localidad
FROM podador pr 
INNER JOIN localidad l ON (pr.codigoPostalVive = l.codigoPostal)
INNER JOIN poda p ON (pr.DNI = p.DNI) 
WHERE YEAR(p.fecha)=2023;



/* EJ 3 */
SELECT a.especie, a.años, a.calle, a.nro, l.nombreL as localidad
FROM arbol a 
INNER JOIN localidad l ON (a.codigoPostal = l.codigoPostal)
WHERE NOT EXISTS (
    SELECT *
    FROM poda p 
    WHERE (a.nroArbol = p.nroArbol)
);

/* EJ 3 (otra forma) */
SELECT a.especie,a.años,a.calle,a.nro,l.nombreL as nombre_localidad
FROM arbol a
INNER JOIN localidad l ON (a.codigoPostal=l.codigoPostal)
WHERE a.nroArbol NOT IN (
    SELECT p.nroArbol
    FROM poda p
)



/* EJ 4 */
SELECT a.especie, a.años, a.calle, a.nro, l.nombreL as localidad
FROM arbol a 
INNER JOIN localidad l ON (a.codigoPostal = l.codigoPostal)
INNER JOIN poda p ON (a.nroArbol = p.nroArbol)
WHERE YEAR(p.fecha)=2022 AND NOT EXISTS (
    SELECT *
    FROM poda p
    WHERE (p.nroArbol = a.nroArbol) AND (YEAR(p.fecha)=2023)
   ); /* En este caso, no es necesario especificar arbol a ya que es el resultado de la consulta PRINCIPAL. poda p si es necesario, xq no se especifica sino */



/* EJ 5 */
SELECT pr.DNI, pr.nombre, pr.apellido, pr.fnac, l.nombreL as localidad
FROM podador pr
INNER JOIN localidad l ON (pr.codigoPostalVive = l.codigoPostal)
WHERE pr.apellido LIKE "%ata" AND EXISTS (
    SELECT *
    FROM poda p
    WHERE (p.DNI = pr.DNI) AND (YEAR(p.fecha)=2024)
)
ORDER BY pr.apellido, pr.nombre;

/* EJ 5 (otra forma) */
SELECT pr.DNI, pr.nombre, pr.apellido, pr.fnac, l.nombreL AS localidad
FROM Podador pr
INNER JOIN Localidad l ON pr.codigoPostalVive = l.codigoPostal
INNER JOIN Poda p ON pr.DNI = p.DNI
WHERE (pr.apellido LIKE '%ata') AND (YEAR(p.fecha) = 2024)
GROUP BY pr.DNI, pr.nombre, pr.apellido, pr.fnac, l.nombreL
ORDER BY pr.apellido, pr.nombre;



/* EJ 6 */ 
SELECT pr.DNI, pr.apellido, pr.nombre, pr.telefono, pr.fnac
FROM podador pr
INNER JOIN poda p ON (pr.DNI = p.DNI)
INNER JOIN arbol a ON (p.nroArbol = a.nroArbol)
WHERE (a.especie = "Coníferas") AND NOT EXISTS (
    SELECT *
    FROM poda p2 
    INNER JOIN arbol a2 ON (p2.nroArbol = a2.nroArbol)
    WHERE (p2.DNI = pr.DNI) AND (a2.especie != "Coníferas")
    ) 
GROUP BY pr.DNI, pr.apellido, pr.nombre, pr.telefono, pr.fnac;



/* EJ 7 */ 
SELECT a.especie
FROM arbol a
INNER JOIN localidad l ON (a.codigoPostal = l.codigoPostal)
WHERE (l.nombreL = "La Plata") AND EXISTS (
    SELECT *
    FROM arbol a2
    INNER JOIN localidad l2 ON (a2.codigoPostal = l2.codigoPostal)
	WHERE (l2.nombreL = "Salta") AND (a2.especie = a.especie)
   );

/* EJ 7 (otra forma) */ 
SELECT a.especie
FROM arbol a
INNER JOIN localidad l ON (a.codigoPostal = l.codigoPostal)
WHERE (l.nombreL = "Salta")
INTERSECT
SELECT a.especie
FROM arbol a
INNER JOIN localidad l ON (a.codigoPostal = l.codigoPostal)
WHERE (l.nombreL = "La Plata");



/* EJ 8 */ 
DELETE FROM poda WHERE DNI = 2223456 /* Ver si esto esta bien, xq no deja eliminar directamente de podador, borrado en cascada */ 
DELETE FROM podador WHERE DNI = 2223456



/* EJ 9 */ 
SELECT l.nombreL, l.descripcion, l.habitantes
FROM localidad l
LEFT JOIN arbol a ON (l.codigoPostal = a.codigoPostal)
GROUP BY l.codigoPostal, l.nombreL, l.descripcion, l.habitantes
HAVING COUNT(a.nroArbol) < 100;