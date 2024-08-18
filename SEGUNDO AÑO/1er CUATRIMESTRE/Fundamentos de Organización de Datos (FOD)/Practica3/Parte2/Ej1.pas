program FOD_P3_Ej1;
const
    valoralto = 9999;
type
    productoM = record
        codigo: integer;
        nombre: string [20];
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

procedure leerD (var detalle: AR_detalle; var regD: productoD);
begin
    if (not eof (detalle)) then
        read(detalle, regD)
    else
        regD.codigo := valoralto;
end;


procedure leerM (var maestro: AR_maestro; var regM: productoM);
begin
    if (not eof (maestro)) then
        read(maestro, regM)
    else
        regM.codigo := valoralto;
end;


procedure actualizar_maestro (var maestro: AR_maestro; var detalle: AR_detalle);
var
    regM: productoM;
    regD: productoD;
    esta: boolean;
begin
    reset (maestro);
    reset (detalle);

    leerD (detalle, regD);

    while (regD.codigo <> valoralto) do begin
        esta := false;
        leerM (maestro, regM);

        while (regM.codigo <> valoralto) AND (not (esta)) do begin 
            if (regM.codigo = regD.codigo) then
                esta := true
            else
                leerM (maestro, regM);
        end;

        if (esta = true) then begin
            regM.stock_act := regM.stock_act - regD.cantidad;
            seek (maestro, filepos(maestro)-1);
            write (maestro, regM);
        end;

        leerD (detalle, regD);
        seek (maestro, 0); // maestro vuelve al principio
    end;

    close (maestro);
    close (detalle);
end;

