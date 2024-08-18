program FOD_P2_Ej3;
const
    valoralto = 9999;
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

procedure leer (var archivo: AR_detalle; var prod: productoD);
begin
    if (not eof(archivo)) then 
        read(archivo, prod)
    else
        prod.codigo := valoralto; 
end;

procedure opcionA (var detalle: AR_detalle; var maestro: AR_maestro);
var
    regD: productoD; regM: productoM;
begin
    assign (detalle, 'detalle');
    assign (maestro, 'maestro');
    reset (detalle); reset (maestro);

    leer (detalle, regD);
    while (regD.codigo <> valoralto) do begin
        read (maestro, regM);

        while (regD.codigo = regM.codigo) do begin
            regM.stock_act := regM.stock_act - regD.cantidad;
            leer (detalle, regD);
        end;

        seek (maestro, filepos(maestro)-1);
        write (maestro, regM);
    end;

    close (maestro); close (detalle);
end;

procedure opcionB (var maestro: AR_maestro);
var
    texto: Text;
    producto: productoM;
begin
    assign (maestro, 'maestro');
    reset (maestro);
    assign (texto, 'stock_minimo.txt');
    rewrite (texto);

    while (not eof(maestro)) do begin
        read(maestro, producto);

        if (producto.stock_act < producto.stock_min) then 
            writeln (texto, producto.nombre);
    end;
    close (maestro); close(texto);
end;

var
    maestro: AR_maestro;
    detalle: AR_detalle;
    opcion: integer;
begin
    write ('Ingrese (1: Actualizar archivo, 2: Listar productos por debajo del stock minimo): ');
    readln (opcion);

    if (opcion = 1) then 
        opcionA (detalle, maestro)
    else
        opcionB (maestro);
end.