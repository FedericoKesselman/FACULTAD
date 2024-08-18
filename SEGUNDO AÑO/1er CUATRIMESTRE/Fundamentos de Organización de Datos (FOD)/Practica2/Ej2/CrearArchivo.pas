program creararchivo;
type
    alumnoM = record
        codigo: integer;
        apellido: string;
        nombre: string;
        mat_sinF: integer;
        mat_conF: integer;
    end;

    alumnoD = record
        codigo: integer;
        aprobo: boolean; // true si aprobo el final. false si unicamente cursada
    end;

    AR_maestro =  file of alumnoM;
    AR_detalle = file of alumnoD;
//     

var 
alM: alumnoM;
alD: alumnoD;

det: AR_detalle;
mae: AR_maestro;

aux: integer;

begin
    assign (mae,'maestro');
    rewrite (mae);

    writeln ('MAESTRO');
    write ('Codigo: '); readln (alM.codigo);
    while (alM.codigo <> 00) do begin
        write ('Apellido: '); readln (alM.apellido);
        write ('Nombre: '); readln (alM.nombre);
        write ('Materias sin aprobar: '); readln (alM.mat_sinF);
        write ('Materias aprobadas: '); readln (alM.mat_conF);
        
        write (mae, alM);
        write ('Codigo: '); readln (alM.codigo);
    end;
    close (mae);

    assign (det,'detalle');
    rewrite (det);

    writeln ('DETALLE');
    write ('Codigo: '); readln (alD.codigo);
    while (alD.codigo <> 00) do begin
        write ('Aprobo: '); readln (aux);
        if (aux = 1) then
            alD.aprobo := True
        else
            alD.aprobo := False;

        write (det, alD);
        write ('Codigo: '); readln (alD.codigo);
    end;
    close (det);
end.