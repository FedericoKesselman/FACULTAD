// BAJAS - ARCHIVOS DESORDENADOS - COPIAR EL ULTIMO Y TRUNCAR

procedure borrarTRUNCANDO (var archivo: AR);
var
    reg, last: registro;
    esta: boolean;
    codigo: integer;
begin
    reset (archivo);
    write ('Ingrese codigo del registro a eliminar: '); readln (codigo);

    while (codigo <> valoralto) do begin
        seek (archivo, filesize(archivo)-1);
        leer (archivo, last); // SE LEE EL ULTIMO

        seek (archivo, 0);
        leer (archivo, reg);  // SE LEE EL PRIMERO

        esta := false;
        while (reg.codigo <> valoralto) AND (not esta) do begin
            if (reg.codigo = codigo) then begin
                esta := true;

                seek (archivo, filepos(archivo)-1);
                write (archivo, last);  // SE ESCRIBE EL ULTIMO

                seek (archivo, filesize(archivo)-1);
                truncate (archivo);   // SE TRUNCA UNO ANTES DE EOF
            end
            else
                leer (archivo, reg);
        end;

        if (esta) then
            writeln ('Eliminado correctamente.');
        else
            writeln ('No se pudo encontrar ese registro.');
        //

        write ('Ingrese codigo del registro a eliminar: '); readln (codigo);
        writeln ('9999 para terminar.');
    end;

    close (archivo);
end;


//////////////////////////////////////////////////////////////////////////////////////////////////////////
// LISTA INVERTIDA

procedure alta_ListaInvertida (var archivo: AR);
var 
    reg, header, reg_nuevo: registro;
begin
    write ('Ingrese codigo del registro: '); readln (reg_nuevo.codigo); // Asi con el resto de campos


    if (not existeRegistro(archivo, reg_nuevo.codigo)) then begin
        reset (archivo);
        leer (archivo, header);

        if (header.codigo = 0) then begin
            seek (archivo, filesize(archivo));
            write (archivo, reg_nuevo);
        end
        else begin
            seek (archivo, header.codigo * -1);
            leer (archivo, header); // cabecera nueva

            seek (archivo, filepos(archivo)-1);
            write (archivo, reg_nuevo);

            seek (archivo, 0);
            write (archivo, header);
        end;
    end
    else write ('Ya existe ese registro.');

    close (archivo);
end;


procedure baja_ListaInvertida (var archivo: AR);
var
    reg, header: registro;
    codigo: integer;
begin
    writeln ('Ingrese codigo del registro a eliminar: '); readln (codigo);

    if (existeRegistro(archivo, codigo)) then begin
        reset (archivo);
        leer (archivo, header);

        leer (archivo, reg);
        while (reg.codigo <> codigo) do
            leer (archivo, reg);
        
        seek (archivo, filepos(archivo)-1);
        write (archivo, header);

        header.codigo := (filepos(archivo)-1)*-1;
        seek (archivo, 0);
        write (archivo, header);
    end
    else write ('No se pudo eliminar porque no se encontro registro con ese codigo.');

    close (archivo);
end;


//////////////////////////////////////////////////////////////////////////////////////////////////////////
// MERGE N DETALLES

procedure leer (var archivo: AR; var reg: registro);
begin
    if (not eof(archivo)) then
        read (archivo, reg);
    else
        reg.codigo := valoralto;
end;

procedure minimo (var archivos: AR_vector; var registros: REG_vector; var min: registro);
var
    i, pos, minimo: integer;
begin
    minimo := valoralto;

    for i := 1 to 30 do begin
        if (registros[i].codigo < minimo) then begin    
            pos := i;
            minimo := registros[i].codigo;
        end;
    end;

    min := registros[pos];
    leer (archivos[pos], registros[pos]);
end;

var
    maestro: AR_maestro;
    archivos: AR_vector;
    registros: REG_vector;
    regM: REG_maestro;
    i: integer;
begin
    assign (maestro, 'maestro');
    reset (maestro);

    for i := 1 to 30 do begin
        assign (archivos[i], 'archivo'+i);
        reset (archivos[i]);
        leer (archivos[i], registros[i]);
    end;

    minimo (archivos, registros, min);
    while (min.codigo <> valoralto) do begin
        read (maestro, regM);

        while (regM.codigo <> min.codigo) do 
            read (maestro, regM);

        while (regM.codigo = min.codigo) do begin
            // PROCESAMIENTO VARIABLES CON REGISTRO MAESTRO
            minimo (archivos, registros, min);
        end;

        seek (maestro, filepos(maestro)-1);
        write (maestro, regM);
    end;

    for i := 1 to 30 do
        close (archivos[i]);
    
    close (maestro);
end;


//////////////////////////////////////////////////////////////////////////////////////////////////////////
// MERGE 1 DETALLES

procedure leer (var archivo: AR; var reg: registro);
begin
    if (not eof(archivo)) then
        read (archivo, reg);
    else
        reg.codigo := valoralto;
end;

var
    detalle: AR_detalle;
    maestro: AR_maestro;
    regM: registro_maestro;
    regD: registro_detalle;
begin
    assign (maestro, 'maestro');
    reset (maestro);
    assign (detalle, 'detalle');
    reset (detalle);

    leer (detalle, regD);
    while (regD.codigo <> valoralto) do begin
        read (maestro, regM);

        while (regM.codigo <> regD.codigo) do
            read (maestro, regM);

        while (regM.codigo = regD.codigo) do begin
            // PROCESAMIENTO VARIABLES CON REGISTRO MAESTRO
            leer (detalle, regD);
        end;

        seek (maestro, filepos(maestro)-1);
        write (maestro, regM);
    end;

    close (detalle);
    close (maestro);
end;
