program parcial;
const
    valoralto = 9999;
type
    reg_fecha = record
        anio, mes, dia: integer;
    end;

    venta = record
        cod_farmaco, cantidad_vendida: integer;
        fecha: reg_fecha;
        forma_pago: string;
    end;

    AR = file of venta;
    AR_vector = array [1..30] of AR;
    REG_vector = array [1..30] of venta;
//

procedure leer (var archivo: AR; var reg: venta);
begin
    if (not eof(archivo)) then
        read (archivo, reg);
    else
        reg.cod_farmaco := valoralto;
end;

procedure minimo (var archivos: AR_vector; var registros: REG_vector; var min: venta);
var
    i, pos, minimo: integer;
begin
    minimo := valoralto;

    for i := 1 to 30 do begin
        if (registros[i].cod_farmaco < minimo) then begin
            minimo := registros[i].cod_farmaco;
            pos := i;
        end;
    end;

    min := registros[pos];
    leer (archivos[pos], registros[pos]);
end;

procedure procesamiento_A (var archivos: AR_vector);
var
    registros: REG_vector;
    cantidad, i, codigo_actual, codigo_max, max: integer;
    min: venta;
begin
    max := -1;

    for i := 1 to 30 do begin
        reset(archivos[i]);
        leer (archivos[i], registros[i]);
    end;

    minimo (archivos, registros, min);
    while (min.cod_farmaco <> valoralto) do begin
        codigo_actual := min.cod_farmaco;
        cantidad := 0;

        while (codigo_actual = min.cod_farmaco) do begin
            cantidad := cantidad + min.cantidad_vendida;
            minimo (archivos, registros, min);
        end;

        if (cantidad > max) then begin
            max := cantidad;
            codigo_max := codigo_actual;
        end;
    end;

    if (max >= 0) then begin
        writeln ('Codigo de farmaco con mayor cantidad vendida: ', codigo_max);
        writeln ('Cantidad vendida de dicho producto: ', max);
    end;

    for i := 1 to 30 do 
        close (archivos[i]);
end;


procedure procesamiento_C (var archivos: AR_vector);
var
    anio_actual, mes_actual, dia_actual, farmaco_actual, i: integer;
    cantidad_total_vendida: integer;
    min: venta;
    texto: Text;
begin
    for i := 1 to 30 do begin
        reset(archivos[i]);
        leer (archivos[i], registros[i]);
    end;

    assign (texto, 'Resumen_ventas.txt');
    rewrite (texto);
    write (texto, 'Resumen de ventas por fecha de farmacos: ');
    minimo (archivos, registros, min);
    
    while (min.cod_farmaco <> valoralto) do begin
        anio_actual := min.fecha.anio;
        writeln (texto, 'Año: ', anio_actual);

        while (min.cod_farmaco <> valoralto) AND (min.fecha.anio = anio_actual) do begin
            mes_actual := min.fecha.mes;
            writeln (texto, '  Mes: ', mes_actual);

            while (min.cod_farmaco <> valoralto) AND (min.fecha.anio = anio_actual) AND (min.fecha.mes = mes_actual) do begin
                dia_actual := min.fecha.dia;
                writeln (texto, '    Dia: ', dia_actual);

                while (min.cod_farmaco <> valoralto) AND (min.fecha.anio = anio_actual) AND (min.fecha.mes = mes_actual) AND (min.fecha.dia = dia_actual) do begin
                    farmaco_actual := min.cod_farmaco;
                    writeln (texto, '     Farmaco: ', farmaco_actual, '   ', min.nombre);
                    cantidad_total_vendida := 0;

                    while (min.cod_farmaco <> valoralto) AND (min.fecha.anio = anio_actual) AND (min.fecha.mes = mes_actual) AND (min.fecha.dia = dia_actual) AND (min.cod_farmaco = farmaco_actual) do begin
                        cantidad_total_vendida := cantidad_total_vendida + min.cantidad_vendida;
                        minimo (archivos, registros, min);
                    end;
                    writeln (texto, '       Cantidad: ', cantidad_total_vendida);
                end;
            end;
        end;
    end;

    for i := 1 to 30 do
        close (archivos[i]);
end;
// NO HARIA FALTA EL CORTE DE CONTROL . SE PODRIA HACER DIRECTAMENTE PREGUNTANDO SI LA FECHA ES LA MISMA

var
    archivos: AR_vector;
    i: integer;
begin   
    for i := 1 to 30 do 
        assing (archivos[i], 'archivo'+i);
    
    procesamiento_A(archivos);
    procesamiento_B(archivos);
end.




