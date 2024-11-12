/* EJ 1 */
SELECT L.Titulo, G.Nombre_Genero, L.descripcion
FROM Libro L 
INNER JOIN Genero G ON (L.Cod_Genero = G.Cod_Genero)
INNER JOIN Libro_Editorial LE ON (L.ISBN = LE.ISBN)
INNER JOIN Editorial E ON (LE.Cod_Editorial = E.Cod_Editorial)
WHERE E.Denominacion = 'Nueva Editorial'
ORDER BY L.Titulo


/* EJ 2 */
SELECT S.Apellido, S.Nombre
FROM Socio S
WHERE Fecha_Ingreso BETWEEN '01/09/2022' AND '30/09/2022'
ORDER BY S.Apellido, S.Nombre


/* EJ 3 */
SELECT S.Apellido, S.Nombre, S.Fecha_Nacimiento, COUNT(P.nro_socio) AS cant_prestamos
FROM Socio S
INNER JOIN Prestamo P ON (S.nro_socio = P.nro_Socio)
GROUP BY S.nro_socio, S.Apellido. S.Nombre. S.Fecha_Nacimiento
HAVING COUNT(P.nro_Socio) > 5
ORDER BY S.Apellido


/* EJ 4 */
SELECT S.DNI, S.Apellido, S.Nombre
FROM Socio S
WHERE NOT EXISTS (
        SELECT *
        FROM Prestamo P 
        INNER JOIN Libro_Editorial LE ON (P.ISBN = LE.ISBN)
        INNER JOIN Editorial E ON (LE.Cod_Editorial = E.Cod_Editorial)
        WHERE E.Denominacion = 'Gran Editorial' AND P.nro_socio = S.nro_socio)


/* EJ 5 */
SELECT COUNT(P.nro_socio) AS cantidad_socios_estadoBueno
FROM Prestamo P 
INNER JOIN Copia C ON (P.ISBN = C.ISBN)
WHERE C.Estado = 'Bueno' AND P.Fecha_Prestamo < '2024-11-12' AND P.Fecha_Devolucion > '2024-11-12'
GROUP BY P.nro_socio