program FOD_P3_Ej2;
const
    valoralto = 9999;
type
    mesa_electoral = record
        codigo_localidad: integer;
        numero_mesa: integer;
        cantidad_votos: integer;
    end;

    AR = file of mesa_electoral;
    AR_aux = file of integer;
//

procedure leer (var archivo: AR; var reg: mesa_electoral);
begin
    if (not eof (archivo)) then
        read(archivo, reg)
    else
        reg.codigo_localidad := valoralto;
end;


function procesado (var archivo: AR_aux; codigo: integer): boolean;
var
    esta: boolean;
    cod: integer;
begin
    esta := false;
    seek (archivo, 0);

    read (archivo, cod);

    while (not eof(archivo)) AND (not esta) do begin
        if (cod = codigo) then
            esta := true
        else
            read (archivo, cod);
    end;

    procesado := esta;
end; // la funcion busca si el codigo ya se encuentra en el archivo de los procesados


procedure contabilizar_votos (var archivo: AR);
var
    reg: mesa_electoral;

    localidad_actual: integer;
    pos_actual : integer;
    cant: integer;
    cant_total: integer;

    archivo_aux: AR_aux;
begin
    rewrite (archivo_aux);
    reset (archivo);

    write ('Codigo de Localidad            '); writeln ('Total de votos');

    leer (archivo, reg);
    cant_total := 0;

    while (reg.codigo_localidad <> valoralto) do begin

        // si no fue procesado dicho codigo todavia hace la suma de votos
        if (not procesado(archivo_aux, reg.codigo_localidad)) then begin 
            cant := reg.cantidad_votos;
            localidad_actual := reg.codigo_localidad;
            pos_actual := filepos (archivo);

            while (reg.codigo_localidad <> valoralto) do begin
                if (reg.codigo_localidad = localidad_actual) then 
                    cant := cant + reg.cantidad_votos;
                leer (archivo, reg);
            end;

            write (localidad_actual, '     '); writeln (cant);

            seek (archivo, pos_actual); // devuelve archivo a su posicion original
            cant_total := cant_total + cant;

            seek (archivo_aux, filesize(archivo_aux)); // archivo de procesados al final
            write (archivo_aux, localidad_actual); // guarda codigo de localidad que ya fue procesada
        end;

        leer (archivo, reg);
    end;

    writeln ('Total General de Votos: ', cant_total);

    close (archivo);
    close (archivo_aux);
end;


