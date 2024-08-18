program parcial;
const
    valoralto = 9999;
type
    acceso = record
        anio, mes, dia, idUsuario, tiempo_acceso: integer;
    end;

    AR = file of acceso;
//

procedure leer (var archivo: AR; var reg: acceso);
begin
    if (not eof(archivo)) then 
        read (archivo, reg);
    else
        reg.anio := valoralto;
end;


procedure informe (var archivo: AR);
var
    anio_informe: integer;
    mes_actual, dia_actual, usuario_actual: integer;
    total_anio, total_mes, total_dia, total_usuario: integer;
    reg: acceso;
begin
    reset (archivo);
    write ('Ingrese año para realizar informe: '); readln (anio_informe);

    leer (archivo, reg);
    while (reg.anio <> valoralto) AND (reg.anio <> anio_informe) do
        leer (archivo, reg);

    if (reg.anio = anio_informe) then begin
        total_anio := 0;

        while (reg.anio <> valoralto) AND (reg.anio = anio_informe) do begin
            mes_actual := reg.mes; total_mes := 0;
            writeln ('Mes: ', reg.mes);

            while (reg.anio <> valoralto) AND (reg.anio = anio_informe) AND (reg.mes = mes_actual) do begin
                dia_actual := reg.dia; total_dia := 0;
                writeln ('Dia: ', reg.dia);

                while (reg.anio <> valoralto) AND (reg.anio = anio_informe) AND (reg.mes = mes_actual) AND (reg.dia = dia_actual) do begin
                    usuario_actual := reg.idUsuario; total_usuario := 0;
                    write ('isUsuario: ', reg.idUsuario);

                    while (reg.anio <> valoralto) AND (reg.anio = anio_informe) AND (reg.mes = mes_actual) AND (reg.dia = dia_actual) AND (reg.idUsuario = usuario_actual) do begin
                        total_usuario := total_usuario + reg.tiempo_acceso;
                        leer (archivo, reg);
                    end;

                    writeln ('Tiempo total de acceso en el dia ', dia_actual, ' mes ', mes_actual, ': ', total_usuario);
                    total_dia := total_dia + total_usuario;
                end;

                writeln ('Tiempo total acceso dia, ', dia_actual, ' mes', mes_actual, ': ', total_dia);
                total_mes := total_mes + total_dia;
            end;

            writeln ('Tiempo total acceso mes ', mes_actual, ': ', total_mes);
            total_anio := total_anio + total_mes;
        end;

        write ('Total año '. anio_informe, ': ', total_anio);
    end 
    else writeln ('Año no encontrado.');

    close (archivo);
end;

var
    archivo: AR:
begin
    assign (archivo, 'archivo');
    informe (archivo);
end.
