program FOD_P4_Ej2A;

// Inciso A
const
    M = 43; // Formula
type
    alumno = record
        nombre, apellido: string;
        dni, legajo, anio_ingreso: integer;
    end;

    reg_indice = record // claves de los nodos del arbol
        dni: integer; // criterio para ordenar arbol
        pos: integer; // posicion en el archivo de alumnos
    end;

    nodo = record
        cant_claves: integer;  
        claves: array[1..M-1] of reg_indice;
        hijos: array[1..M] of integer;
    end;

    archivo_alumnos = file of alumno;
    archivo_indice = file of nodo;
