program parcial;
const
    valoralto =  9999;
type
    producto_M = record
        codigo: integer;
        nombre: string;
        precio_venta, stock_act, stock_min: integer;
    end;

    producto_D = record
        codigo: integer;
        cantidad: integer;
    end;

    AR_M = file of producto_M;
    AD_D = file of producto_D;

    vec_archivos = array [1..20] of AR_D;
    vec_registros = array [1..20] of producto_D;
//

procedure leer (var archivo: AR_D; var reg: producto_D);
begin
    if (not EOF(archivo)) then 
        read(archivo, reg);
    else
        reg.codigo := valoralto;
end;

procedure minimo (var archivos: vec_archivos; var registros: vec_registros; var min: producto_D);   
var
    minimo, i, pos: integer;
begin
    minimo := 9999;

    for i := 1 to 20 do begin
        if (registros[i].codigo < minimo) then begin
            minimo := registros[i].codigo;
            pos := i;
        end;
    end;

    min := registros[pos]; 
    leer (archivos[pos], registros[pos]);
end;

procedure procesamiento (var archivos: vec_archivos; var maestro: AR_M);
var
    i, pos, cant: integer; 
    min: producto_D;
    texto: Text;
    registros: vec_registros;
    regM: producto_M;

begin
    assign (texto, 'Productos_con_mas_de_$10.000.txt');
    rewrite (texto);

    reset (maestro);

    for i := 1 to 20 do begin
        reset (archivos[i]);
        leer (archivos[i], registros[i]);
    end;

    minimo (archivos, registros, min);
    read (maestro, regM);

    while (min.codigo <> valoralto) do begin
        while (regM.codigo <> min.codigo) do 
            read (maestro, regM);

        cant := 0;
        while (regM.codigo = min.codigo) do begin
            regM.stock_act := regM.stock_act - min.cantidad;
            cant := cant + min.cantidad;
            minimo (archivos, registros, min);
        end;

        if (cant * regM.precio_venta) > 10000 then
            with regM do writeln (texto, codigo, nombre, precio_venta, stock_act, stock_min);

        seek (filepos(maestro)-1); 
        write (maestro, regM);
    end;

    for i := 1 to 20 do 
        close (archivos[i]);
    
    close (maestro);
    close (texto);
end;

var
    i: integer;
    archivos: vec_archivos;
    maestro: AR_M;
begin
    assign (maestro, 'maestro');
    
    for i := 1 to 20 do
        assign (archivos[i], 'archivo'+1);

    procesamiento (archivos, maestro);
end.

    
leerM