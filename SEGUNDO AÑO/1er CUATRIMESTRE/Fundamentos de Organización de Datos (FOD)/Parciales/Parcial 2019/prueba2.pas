program parcial;
const
    valoralto = 9999;
    dim = 30;
type
    fecha_reg = record
        anio, mes, dia: integer;
    end;

    farmaco = record
        cod_farmaco, cantidad_vendida: integer;
        nombre, forma_pago: string
        fecha: fecha_reg;
    end;

    AR = file of farmaco;
    AR_vector = array[1..dim] of AR;
    REG_vector = array[1..dim] of farmaco;
//

procedure leer (var archivo: AR; var reg: farmaco);
begin
    if (not eof(archivo)) then
        read (archivo, reg);
    else
        reg.cod_farmaco := valoralto;
end;

procedure minimo (var archivos: AR_vector; var registros: REG_vector; var min: farmaco);
var
    i, pos, minimo: integer;
begin
    minimo := 99999;

    for i := 1 to dim do begin
        if (registros[i].cod_farmaco < minimo) then begin
            pos := i;
            minimo := registros[i].cod_farmaco;
        end;
    end;

    min := registros[pos].cod_farmaco;
    leer (archivos[pos], registros[pos]);
end;

procedure procesamiento_A (var archivos: AR_vector);
var
    i, cant, farmaco_max, farmaco_actual, max: integer;
    registros: REG_vector;
    min: farmaco;
begin
    for i := 1 to dim do begin
        reset (archivos[i]);
        leer (archivos[i], registros[i]);
    end;

    max := -1;
    minimo (archivos, registros, min);

    while (min.cod_farmaco <> valoralto) do begin   
        farmaco_actual := min.cod_farmaco;
        cant := 0;

        while (min.cod_farmaco = farmaco_actual) do begin
            cant := cant + min.cantidad_vendida;
            minimo (archivos, registros, min);
        end;

        if (cant > max) then begin
            max := cant;
            farmaco_max := farmaco_actual;
        end;
    end;

    if (max > 0) then
        write ('Farmaco con mayor cantidad vendida: ', farmaco_max);
    
    for i := 1 to dim do
        close (archivos[i]);
end;


procedure procesamiento_B (var archivos: AR_vector);
var
    i, cantidad, farmaco_actual: integer;
    registros: REG_vector;
    min: farmaco;
    texto: Text;
    fecha_actual: fecha_reg;
begin
    for i := 1 to dim do begin
        reset (archivos[i]);
        leer (archivos[i], registros[i]);
    end;

    assign (texto, 'Resumen_de_ventas.txt');
    rewrite (texto);
    writeln (texto, '--INFORME VENTAS--');

    minimo (archivos, registros, min);

    while (min.cod_farmaco <> valoralto) do begin
        cantidad := 0;
        farmaco_actual := min.cod_farmaco;
        writeln (texto, 'Farmaco: ', farmaco_actual);

        while (min.cod_farmaco = farmaco_actual) do begin
            fecha_actual := min.fecha;
            writeln (texto, '  ', min.fecha.anio, '/', min.fecha.mes, '/', min.fecha.anio);

            while (min.cod_farmaco = farmaco_actual) AND (fecha_actual.anio = min.fecha.anio) AND (fecha_actual.mes = min.fecha.mes) AND (fecha_actual.dia = min.fecha.dia) do begin
                cantidad := cantidad + min.cantidad_vendida;
                minimo (archivos, registros, min);
            end;

            writeln (texto, '    Cantidad vendida: ', cantidad);
        end;
    end;

    for i := 1 to dim do
        close (archivos[i]);
    
    close (texto);
end;

var
    archivos: AR_vector;
    i: integer;
begin
    for i := 1 to dim do
        assign (archivo, 'archivo'+i);
    
    procesamiento_A (archivos);
    procesamiento_B (archivos);
end;




