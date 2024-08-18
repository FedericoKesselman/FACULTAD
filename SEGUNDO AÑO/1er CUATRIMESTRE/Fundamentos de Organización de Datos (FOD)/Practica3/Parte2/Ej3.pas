program FOD_P3_Ej3;
const
    valoralto = 9999;
type
    reg_fecha = record
        ano: integer;
        mes: integer;
        dia: integer;
    end;

    usuario = record
        codigo: integer;   
        fecha: reg_fecha;
        tiempo: integer;
    end;

    AR = file of usuario;

    vector_detalles = array[1..5] of AR;
//

procedure leer (var detalle: AR; var reg: usuario);
begin
    if (not eof (detalle)) then
        read(detalle, reg)
    else
        reg.codigo := valoralto;
end;


function esta_maestro (var archivo: AR; codigo: integer): boolean;
var
    esta: boolean;
    reg: usuario;
begin
    esta := false;
    seek (archivo, 0);

    read (archivo, reg);

    while (not eof(archivo)) AND (not esta) do begin
        if (reg.codigo = codigo) then
            esta := true
        else
            read (archivo, reg);
    end;

    esta_maestro := esta;
end; // la funcion busca si ya hay un maestro con dicho codigo


function fecha_es_mayor (fecha1: reg_fecha; fecha2: reg_fecha): boolean;
begin
    // Compara primero los años
    if fecha2.ano > fecha1.ano then
        fecha_es_mayor := true
    else if fecha2.ano < fecha1.ano then
        fecha_es_mayor := false
    else
    begin
        // Si los años son iguales, compara los meses
        if fecha2.mes > fecha1.mes then
            fecha_es_mayor := true
        else if fecha2.mes < fecha1.mes then
            fecha_es_mayor := false
        else
        begin
            // Si los meses son iguales, compara los días
            fecha_es_mayor := fecha2.dia > fecha1.dia;
        end;
    end;
end;


procedure crear_maestro (var det: vector_detalles; var maestro: AR);
var
    regD, regM: usuario;
    i: integer;
    esta: boolean;
begin
    reset (maestro);
    for i := 1 to 5 do reset (det[i]);

    for i := 1 to 5 do begin
        leer (det[i], regD);

        while (regD.codigo <> valoralto) do begin

            // si dicho registro no esta en el maestro, lo agrega al final del mismo
            if (not esta_maestro(maestro, regD.codigo)) then begin
                seek (maestro, filesize(maestro));
                write (maestro, regD)
            end
            // si está, lo busca y lo actualiza
            else begin 
                seek (maestro, 0);
                esta := false;
                
                leer (maestro, regM);
                while (regM.codigo <> valoralto) AND (not (esta)) do begin 
                    if (regM.codigo = regD.codigo) then begin
                        esta := true;
                        regM.tiempo := regM.tiempo + regD.tiempo;
                        if (fecha_es_mayor(regM.fecha, regD.fecha)) then 
                            regM.fecha := regD.fecha;

                        seek (maestro, filepos(maestro)-1);
                        write (maestro, regM);
                    end
                    else
                        leer (maestro, regM);
                end;
            end;

            leer (det[i], regD);
        end;
    end;
end;

