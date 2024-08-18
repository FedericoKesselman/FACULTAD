program FOD_P2_Ej6;
const
    valoralto = 9999;
type
    reg_fecha = record
        ano: integer;
        mes: integer;
        dia: integer;
    end;

    usuarioD = record
        codigo: integer;   
        fecha: reg_fecha;
        tiempo: integer;
    end;

    usuarioM = record
        codigo: integer;
        tiempo: integer;
    end;

    AR_maestro = file of usuarioM;
    AR_detalle = file of usuarioD;

    detalle_vec = array[1..5] of AR_detalle;
    registro_vec = array[1..5] of usuarioD;
//

procedure leer (var detalle: AR_detalle; var regD: usuarioD);
begin
    if (not eof (detalle)) then
        read(detalle, regD)
    else
        regD.codigo := valoralto;
end;

procedure minimo (var detalle: detalle_vec; var regD: registro_vec; var min: usuarioD);
var
    i, pos, minimo: integer;
begin
    minimo := 9999;

    for i := 1 to 5 do begin
        if (regD[i].codigo < minimo) then begin
            pos := i;
            minimo := regD[i].codigo;
        end;
    end;
    min := regD[pos];
    leer (detalle[pos], regD[pos]);
end;

var
    maestro: AR_maestro;
    regM: usuarioM;
    detalle: detalle_vec;
    regD: registro_vec;
    min: usuarioD;
    i, codigo_act: integer;
begin
    assign (maestro, '/var/log/maestro');
    rewrite (maestro);
    // se hace manualmente asi se puede ejecutar. deberia ser con for
    assign (detalle[1], 'detalle1'); 
    assign (detalle[2], 'detalle2'); 
    assign (detalle[3], 'detalle3'); 
    assign (detalle[4], 'detalle4'); 
    assign (detalle[5], 'detalle5'); 

    for i := 1 to 5 do begin
        assing (detalle[i], 'detalle'+i); 
    // esto no funciona en pascal

    for i := 1 to 5 do begin
        reset (detalle[i]);
        leer (detalle[i], regD[i]);
    end;

    minimo (detalle, regD, min);

    while (min.codigo <> valoralto) do begin
        codigo_act := min.codigo;
        regM.tiempo := 0;

        while (min.codigo = codigo_act) do begin
            regM.tiempo := regM.tiempo + min.tiempo;  
            minimo (detalle, regD, min);
        end;
        
        regM.codigo := codigo_act;
        write (maestro, regM);
    end;

    close (maestro);
    for i := 1 to 5 do
        close(detalle[i]);
end.