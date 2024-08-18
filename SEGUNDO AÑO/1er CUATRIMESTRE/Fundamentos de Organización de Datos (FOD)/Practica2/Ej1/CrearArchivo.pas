program creararchivo;
type
    empleado = record
        codigo: integer;
        nombre: string;
        monto: integer;
    end;
    com_empleado = record
        codigo: integer;
        comisiones: integer;
    end;

    maestro = file of empleado;
    detalle = file of com_empleado;        

var 

empM:empleado;
empD:com_empleado;

det: detalle;
mae: maestro;

begin
    assign (det,'detalle');
    rewrite (det);

    writeln ('DETALLE');
    write ('Codigo: '); readln (empD.codigo);
    while (empD.codigo <> 00) do begin
        write ('Comision: '); readln (empD.comisiones);
        write (det, empD);
        write ('Codigo: '); readln (empD.codigo);
    end;
    close (det);

    assign (mae,'maestro');
    rewrite (mae);

    writeln ('MAESTRO');
    write ('Codigo: '); readln (empM.codigo);
    while (empM.codigo <> 00) do begin
        write ('Nombre: '); readln (empM.nombre);
        empM.monto := 0;
        write (mae, empM);
        write ('Codigo: '); readln (empM.codigo);
    end;
    close (mae);
end.