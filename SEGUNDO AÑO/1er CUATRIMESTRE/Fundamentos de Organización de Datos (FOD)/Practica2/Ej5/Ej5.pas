program FOD_P2_Ej5;
const
    valoralto = 9999;
type
    productoM = record
        codigo: integer;
        nombre: String;
        descripcion: String;
        stock_dis: integer;
        stock_min: integer;
        precio: integer;
    end;

    productoD = record
        codigo: integer;
        cantidad: integer;
    end;

    AR_detalle = file of productoD;
    AR_maestro = file of productoM;

    detalle_vec = array[1..30] of AR_detalle;
    registro_vec = array[1..30] of productoD;
//

procedure leer (var detalle: AR_detalle; var regD: productoD);
begin
    if (not eof (detalle)) then 
        read (detalle, regD)
    else
        regD.codigo := valoralto;
end;

procedure minimo (var regD: registro_vec; var min: productoD; var detalle: detalle_vec);
var
    i, pos, minimo: integer;
begin
    minimo := 999999;

    for i := 1 to 30 do begin
        if (regD[i].codigo < minimo) then begin
            minimo := regD[i].codigo;
            pos := i;
        end;
    end;

    min := regD[pos];
    leer (detalle[pos], regD[pos]);
end;

var
    maestro: AR_maestro;
    regM: productoM;
    regD: registro_vec;
    detalle: detalle_vec;
    min: productoD;
    i: integer;
    texto: Text;
begin

    for i := 1 to 30 do begin
        assign (detalle[i], 'detalle'+i);
        reset (detalle[i]);
        leer (detalle[i], regD[i]);
    end;

    assign (maestro, 'maestro'); reset (maestro);
    minimo (regD, min, detalle);

    while (min.codigo <> valoralto) do begin
        read (maestro, regM);

        while (regM.codigo <> min.codigo) do
            read (maestro, regM);
        
        while (regM.codigo = min.codigo) do begin
            regM.stock_dis := regM.stock_dis - min.cantidad;
            minimo (regD, min, detalle);
        end;

        seek (maestro, filepos(maestro)-1);
        write (maestro, regM);
    end;

    for i := 1 to 30 do 
        close (detalle[i]);
    
    // ARCHIVO TEXTo
    seek (maestro, 0);
    assign (texto, 'productos_por_debajo_minimo.txt');
    rewrite (texto);

    while (not eof(maestro)) do begin
        read (maestro, regM);
        
        if (regM.stock_dis < regM.stock_min) then begin
            with regM do write (texto, nombre);
            with regM do write (texto, ' Stock disponible: ', stock_dis);
            with regM do write (texto, ' Stock minimo: ', stock_min);
            with regM do write (texto, ' $', precio);
        end;
    end;

    close(maestro); close(texto);
end.