program creararchivo;
type
    productoM = record
        codigo: integer;
        nombre: string;
        precio: integer;
        stock_act: integer;
        stock_min: integer;
    end;

    productoD = record
        codigo: integer;
        cantidad: integer;
    end;

    AR_detalle = file of productoD;
    AR_maestro = file of productoM;
//   

var 
regM: productoM;
regD: productoD;

det: AR_detalle;
mae: AR_maestro;

begin
    assign (mae,'maestro');
    rewrite (mae);

    writeln ('MAESTRO');
    write ('Codigo: '); readln (regM.codigo);
    while (regM.codigo <> 00) do begin
        write ('Nombre: '); readln (regM.nombre);
        write ('Precio: '); readln (regM.precio);
        write ('Stock minimo: '); readln (regM.stock_min);
        write ('Stock actual: '); readln (regM.stock_act);
        
        write (mae, regM);
        write ('Codigo: '); readln (regM.codigo);
    end;
    close (mae);

    assign (det,'detalle');
    rewrite (det);

    writeln ('DETALLE');
    write ('Codigo: '); readln (regD.codigo);
    while (regD.codigo <> 00) do begin
        write ('Cantidad: '); readln (regD.cantidad);
        
        write (det, regD);
        write ('Codigo: '); readln (regD.codigo);
    end;
    close (det);
end.