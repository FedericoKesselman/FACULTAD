program FOD_P3_Ej7;
const
    valoralto = 9999;
type
    ave = record
        codigo: integer;
        nombre: string;
        descripcion: string;
    end;

    AR = file of ave;
//

procedure leer (var archivo: AR; var reg: ave);
begin
    if (not eof (archivo)) then
        read (archivo, reg)
    else
        reg.codigo := valoralto;
end;

procedure baja (var archivo: AR);
var
    reg: ave;
    codigo: integer;
    esta: boolean;
begin
    reset(archivo);

    write ('Ingrese codigo de ave a eliminar (corta con 500.000): '); read (codigo);
    while (codigo <> 500000) do begin
        esta := false;

        leer (archivo, reg);
        while (reg.codigo <> valoralto) AND (not esta) do begin
            if (reg.codigo = codigo) then begin 
                esta := true;
                reg.codigo := -9999;
                seek (archivo, filepos(archivo)-1);
                write (archivo, reg)
            end
            else
                leer (archivo, reg);
        end;

        seek (archivo, 0);
        write ('Ingrese codigo de ave a eliminar (corta con 500.000): '); read (codigo);
    end;

    writeln ('Proceso de bajas finalizado.');
    close (archivo);
end;

procedure compactar (var archivo: AR);
var
    reg, aux: ave;
    tamano, pos, i: integer;
    nuevo_archivo: AR;
begin
    reset (archivo);

    // ultimos registros en los eliminados
    tamano := filesize(archivo);
    pos := 1;

    leer (archivo, reg);
    while (reg.codigo <> valoralto) and (pos < tamano) do begin

        if (reg.codigo = -9999) then begin
            pos := filepos(archivo)-1; // almacena pos actual

            seek (archivo, tamano);
            read (archivo, aux); // lee el ultimo

            seek (archivo, pos);
            write (archivo, aux); // ult registro en eliminado

            tamano := tamano-1;
        end;

        leer (archivo, reg);
        pos := pos + 1;
    end;

    // eliminar ultimos registros 
    seek (archivo, tamano);
    truncate (archivo);
    
    writeln ('Proceso de compactacion finalizado.');
    close (archivo); close (nuevo_archivo);
end;

var 
    archivo: AR;
begin
    assign (archivo, 'archivo');

    baja (archivo);
    compactar (archivo);
end.


