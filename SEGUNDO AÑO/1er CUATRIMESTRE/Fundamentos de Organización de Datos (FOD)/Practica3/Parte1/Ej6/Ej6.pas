program FOD_P3_Ej6;
const
    valoralto = 9999;
type
    prenda = record // no hacen falta todos los campos
        codigo: integer;
        descripcion: string;
        precio: integer;
    end;

    AR = file of prenda;
    AR_2 = file of integer;
//

procedure leer (var archivo: AR; var reg: prenda);
begin
    if (not eof (archivo)) then
        read (archivo, reg)
    else
        reg.codigo := valoralto;
end;

procedure leer_2 (var archivo: AR_2; var codigo: integer);
begin
    if (not eof (archivo)) then
        read (archivo, codigo)
    else
        codigo := valoralto;
end;

procedure baja_logica (var archivo: AR; var archivo_2: AR_2);
var
    reg: prenda;
    codigo: integer;
    esta: boolean;
begin
    reset(archivo); reset(archivo_2);

    leer_2 (archivo_2, codigo);
    while (codigo <> valoralto) do begin
        esta := false;

        leer (archivo, reg);
        while (reg.codigo <> valoralto) AND (not esta) do begin
            if (reg.codigo = codigo) then begin 
                esta := true;
                reg.codigo := (reg.codigo * -1);
                seek (archivo, filepos(archivo)-1);
                write (archivo, reg)
            end
            else
                leer (archivo, reg);
        end;

        seek (archivo, 0);
        leer_2 (archivo_2, codigo);
    end;

    close (archivo); close (archivo_2);
end;

procedure compactacion (var archivo: AR);
var
    reg: prenda;
    nuevo_archivo: AR;
begin
    assign (nuevo_archivo, 'nuevo_archivo');
    rewrite (nuevo_archivo);
    reset (archivo);

    leer (archivo, reg);
    while (reg.codigo <> valoralto) do begin
        if (reg.codigo > 0) then 
            write (nuevo_archivo, reg);
        leer (archivo, reg);
    end;

    // delete (archivo);
    // rename (nuevo_archivo, 'archivo');

    close (archivo); close (nuevo_archivo);
end;

procedure generarArchivoMaestro (var archivo: AR);
var
    p: prenda;
begin
    rewrite(archivo);

    p.codigo := 1; p.descripcion := 'Camiseta'; p.precio := 200; write(archivo, p);
    p.codigo := 2; p.descripcion := 'Pantalón'; p.precio := 300; write(archivo, p);
    p.codigo := 3; p.descripcion := 'Chaqueta'; p.precio := 500; write(archivo, p);
    p.codigo := 4; p.descripcion := 'Vestido'; p.precio := 400; write(archivo, p);
    p.codigo := 5; p.descripcion := 'Zapatos'; p.precio := 250; write(archivo, p);

    close(archivo);
end;

procedure generarArchivoBajas(var archivo: AR_2);
var
    codigo: integer;
begin
    rewrite(archivo);

    codigo := 2; write(archivo, codigo);
    codigo := 4; write(archivo, codigo);

    close(archivo);
end;

procedure mostrarContenidoArchivo(var archivo: AR);
var
    p: prenda;
begin
    reset(archivo);

    writeln('Contenido del archivo :');
    while not eof(archivo) do
    begin
        read(archivo, p);
        if p.codigo > 0 then
            writeln('Código: ', p.codigo, ', Descripción: ', p.descripcion, ', Precio: ', p.precio);
    end;

    close(archivo);
end;

var
    archivo: AR;
    archivo_2: AR_2;
begin
    assign(archivo, 'archivo');
    assign(archivo_2, 'archivo_2');
    
    generarArchivoMaestro (archivo);
    generarArchivoBajas (archivo_2);

    baja_logica (archivo, archivo_2);
    writeln ('Baja finalizada');

    compactacion(archivo);
    writeln ('Compactacion de archivo finalizada.');

    mostrarContenidoArchivo (archivo);
end.
    