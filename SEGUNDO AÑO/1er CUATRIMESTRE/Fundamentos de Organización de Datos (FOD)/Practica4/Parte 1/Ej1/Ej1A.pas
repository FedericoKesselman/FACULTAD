program FOD_P4_Ej1A;

// Inciso A
const
    M = 8; // formula
type
    alumno = record
        nombre, apellido: string;
        dni, legajo, anio_ingreso: integer;
    end;

    nodo = record
        cant_claves: integer;  
        claves: array[1..M-1] of alumno;
        hijos: array[1..M] of integer;
    end;

    arbol = file of nodo;

