program FOD_P3_Ej8;
const
    valoralto = 'ZZZZ';
type
    distribucion = record
        nombre: string;
        anio: integer;
        version: integer;
        cant_desarrolladores: integer;
    end;

    AR = file of distribucion;
//

procedure leer (var archivo: AR; var reg: distribucion);
begin
    if (not eof(archivo)) then
        read (archivo, reg)
    else
        reg.nombre := valoralto;
end;

function ExisteDistribucion (var archivo: AR; nombre: string): boolean;
var
    reg: distribucion;
    esta: boolean;
begin
    esta := false;

    leer (archivo, reg);
    while (reg.nombre <> valoralto) AND (not esta) do begin 
        if (reg.nombre = nombre) then
            esta := true
        else
            leer (archivo, reg);
    end;

    ExisteDistribucion := esta;
    seek (archivo, 0);
end;

procedure AltaDistribucion (var archivo: AR);
var
    reg, header: distribucion;
    esta: boolean;
begin
    reset (archivo);

    writeln ('---DISTRIBUCION NUEVA---');
    write ('Nombre: '); readln (reg.nombre);
    esta := ExisteDistribucion (archivo, reg.nombre);

    if (esta) then
        writeln ('Ya existe la distribucion.')
    else begin
        write ('Anio: '); readln (reg.anio);
        write ('Version: '); readln (reg.version);
        write ('Cantidad desarrolladores: '); readln (reg.cant_desarrolladores);

        read (archivo, header);

        if (header.cant_desarrolladores = 0) then begin 
            seek (archivo, filesize(archivo));
            write (archivo, reg)
        end 
        else begin
            seek (archivo, (header.cant_desarrolladores * -1));
            read (archivo, header); // cabecera nueva
            seek (archivo, filepos(archivo)-1);
            write (archivo, reg); // escribo registro nuevo
            seek (archivo, 0);
            write (archivo, header); // actualizo cabecera
        end;

        writeln ('Distribucion agregada correctamente.')
    end;

    writeln ('--------------');
    close (archivo);
end;

procedure BajaDistribucion (var archivo: AR);
var
    pos: integer;
    reg, header: distribucion;
    esta: boolean;
    nombre: string;
begin
    reset (archivo);

    writeln ('---DISTRIBUCION A ELIMINAR---');
    write ('Nombre: '); readln (nombre);
    esta := ExisteDistribucion (archivo, nombre);

    if (not esta) then
        writeln ('Distribucion no existente.')
    else begin
        esta := false;
        pos := 1;

        read (archivo, header);

        leer (archivo, reg);
        while (reg.nombre <> valoralto) and (not esta) do begin
            if (reg.nombre = nombre) then begin
                esta := true;

                seek (archivo, filepos(archivo)-1);
                write (archivo, header); // cabecera en registro eliminado

                header.cant_desarrolladores := (pos * -1);
                seek (archivo, 0);
                write (archivo, header); // actualizo header

                writeln ('Distribucion eliminada correctamente.')
            end
            else begin   
                leer (archivo, reg);
                pos := pos + 1;
            end;
        end;
    end;

    writeln ('--------------');
    close (archivo);
end;

var
    archivo: AR;
begin
    assign (archivo, 'archivo');

    AltaDistribucion (archivo);
    BajaDistribucion (archivo);
end.


