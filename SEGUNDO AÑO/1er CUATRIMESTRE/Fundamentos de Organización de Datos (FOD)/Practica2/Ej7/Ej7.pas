program FOD_P2_Ej7;
const
    valoralto = 9999;
type
    reporteD = record
        cod_localidad: integer;   
        cod_cepa: integer;
        c_activos: integer;
        c_nuevos: integer;
        c_recuperados: integer;
        c_fallecidos: integer;
    end;

    reporteM = record
        cod_localidad: integer;
        nom_localidad: string;
        cod_cepa: integer;
        nom_cepa: string;
        c_activos: integer;
        c_nuevos: integer;
        c_recuperados: integer;
        c_fallecidos: integer;
    end;

    AR_maestro = file of reporteM;
    AR_detalle = file of reporteD;

    detalle_vec = array[1..10] of AR_detalle;
    registro_vec = array[1..10] of reporteD;
//

procedure leer (var detalle: AR_detalle; var regD: reporteD);
begin
    if (not eof (detalle)) then
        read(detalle, regD)
    else
        regD.cod_localidad := valoralto;
end;

procedure minimo (var detalle: detalle_vec; var regD: registro_vec; var min: reporteD);
var
    i, pos, minimo1, minimo2: integer;
begin
    minimo1 := 9999;
    minimo2 := 9999;

    for i := 1 to 10 do begin
        if (regD[i].cod_localidad <= minimo1) then begin

            if (regD[i].cod_localidad <> minimo1) then begin
                minimo2 := 9999; // si hay otro cod localidad mas baja reinicia segundo minimo
                minimo1 := regD[i].cod_localidad; // cambia minimo 1
            end;

            if (regD[i].cod_localidad < minimo2) then // misma localidad pero cod cepa mas bajo
                minimo2 := regD[i].cod_cepa;
                pos := i;
        end;
    end;
    min := regD[pos];
    leer (detalle[pos], regD[pos]);
end;

var
    maestro: AR_maestro;
    regM: reporteM;
    detalle: detalle_vec;
    regD: registro_vec;
    min: reporteD;
    i: integer;
begin
    assign (maestro, 'maestro');
    rewrite (maestro);

    for i := 1 to 10 do begin
        assign (detalle[i], 'detalle'+i);
        reset (detalle[i]);
        leer (detalle[i], regD[i]);
    end;

    minimo (detalle, regD, min);

    while (min.cod_localidad <> valoralto) do begin
        read (maestro, regM);

        while (regM.cod_localidad <> min.cod_localidad) AND (regM.cod_cepa <> min.cod_cepa) do 
            read (maestro, regM);

        while (regM.cod_localidad = min.cod_localidad) AND (regM.cod_cepa = min.cod_cepa) do begin
            regM.c_fallecidos := regM.c_fallecidos + min.c_fallecidos;
            regM.c_recuperados := regM.c_recuperados + min.c_recuperados;
            regM.c_activos := min.c_activos;
            regM.c_nuevos := min.c_nuevos;

            minimo (detalle, regD, min);
        end;
    end;

    for i := 1 to 10 do
        close (detalle[i]);
    seek (maestro, 0);

    while (not eof(maestro)) do begin
        read (maestro, regM);

        if (regM.c_activos > 50) then
            writeln ('Localidad: ', regM.nom_localidad, ' cuenta con mas de 50 casos activos.');
    end;
    
    close (maestro);
end.