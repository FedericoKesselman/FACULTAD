program FOD_P4_Ej4;


procedure buscar(NRR, clave, NRR_encontrado, pos_encontrada, resultado)
var 
    clave_encontrada: boolean;
begin
    if (nodo = null)
        resultado := false; {clave no encontrada}
    else
        posicionarYLeerNodo(A, nodo, NRR);
    
    claveEncontrada(A, nodo, clave, pos, clave_encontrada);
    
    if (clave_encontrada) then begin
        NRR_encontrado := NRR; { NRR actual }
        pos_encontrada := pos; { posicion dentro del array }
        resultado := true;
    end
    else
        buscar(nodo.hijos[pos], clave, NRR_encontrado, pos_encontrada, resultado)
end;

{ 
    a) PosicionayYLeerNodo(): Lo que hace es recorrer los nodos teniendo en cuenta
        el orden del arbol. (DUDA)
        Parametros: 
            A: Arbol, al ser un archivo tiene que ser enviado por REFERENCIA.
            NRR: Numero de Registro Relavito, REFERENCIA.
            nodo: No lo va a tener que modificar, va a tener que recorrerlo. VALOR.

    b) claveEncontrada(): Verifica si una clave dada está presente en un nodo específico del 
        árbol B. Su función es buscar la clave dentro del nodo y devolver un valor booleano 
        que indique si la clave se encontró o no.
            Parametros: 
            A: REFERENCIA (es un archivo).
            nodo, clave: VALOR (unicamente los va a leer).
            pos: REFERENCIA (devuelve la posicion si es que esta).
            clave_encontrada: REFERENCIA (devuelve la posicion).

    c) Errores: En la condición de verificación de si el nodo es nulo (if (nodo = null)), la variable 
        nodo no está definida o inicializada previamente en el procedimiento buscar().
        Se podria hace que nodo se reciba como un parametro. 

    d)  * Modificar la lógica de búsqueda para tener en cuenta las características específicas de un árbol B+, 
        como la presencia de nodos hoja adicionales que contienen referencias a registros de datos.

        * Ajustar la manera en que se manejan las claves y los nodos, ya que en un árbol B+ las claves solo se 
        almacenan en los nodos hoja, mientras que los nodos intermedios solo contienen claves de búsqueda y 
        referencias a otros nodos.

        * Actualizar la forma en que se realizan las operaciones de búsqueda y acceso a los datos, teniendo en 
        cuenta la estructura de índice de un árbol B+.
}

procedure posicionarYLeerNodo (var A: arbol; var NRR: integer; nodo: integer); // DUDA
begin

end;


procedure claveEncontrada (var A: arbol; nodo, clave: integer; var pos, clave_encontrada: integer); 
var
    sigo: boolean;
    i: integer;
begin
    sigo := true;
    i := 1;

    while (sigo) AND (i < (M-1)) do begin
        if (nodo.claves[i].dni = clave) then 
            sigo := false;
            clave_encontrada := true;
        end;
    end;

    pos := i;
end;