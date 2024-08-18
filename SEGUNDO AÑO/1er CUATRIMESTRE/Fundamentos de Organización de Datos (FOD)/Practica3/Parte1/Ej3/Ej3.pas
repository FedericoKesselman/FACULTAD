program FOD_P3_Ej3;
const
    valoralto = 9999;
type
    novela = record // no hacen falta el resto de campos
        codigo: integer;
        genero: string;
        nombre: string;
    end;

    AR = file of novela;
//

procedure leer (var archivo: AR; var reg: novela);
begin
    if (not eof (archivo)) then
        read (archivo, reg)
    else
        reg.codigo := valoralto;
end;

procedure leer_teclado (var reg: novela);
begin
    writeln ('---NOVELA---');
    write ('Ingrese codigo novela: '); readln (reg.codigo);
    if (reg.codigo <> valoralto) then begin
        write ('Ingrese genero: '); readln (reg.genero);
        write ('Ingrese nombre: '); readln (reg.nombre);
    end;
    writeln ('------------');
end;

procedure opcionA (var archivo: AR);
var
    reg: novela;
begin
    rewrite (archivo);

    reg.codigo := 0; reg.genero:= '-'; reg.nombre:= '-'; // registro ficticio
    write (archivo, reg);

    leer_teclado (reg);
    while (reg.codigo <> valoralto) do begin
        write (archivo, reg);
        leer_teclado (reg);
    end;
    
    close (archivo);
end;

procedure alta (var archivo: AR);
var
    reg, header: novela;
begin
    reset (archivo);
    read (archivo, header); // cabecera

    leer_teclado(reg);

    if (header.codigo = 0) then begin
        seek (archivo, filesize(archivo));
        write (archivo, reg)
    end
    else begin 
        seek (archivo, (header.codigo * -1));
        leer (archivo, header); // cabecera nueva

        seek (archivo, filepos(archivo)-1);
        write (archivo, reg); // escribo registro nuevo

        seek (archivo, 0);
        write (archivo, header); // actualizo cabecera
    end;

    close (archivo);
end;

procedure opcionB_ii (var archivo: AR);
var
    codigo: integer;
    reg: novela;
    esta: boolean;
begin
    esta := false;

    write ('Ingrese codigo de novela a modificar: ');
    readln (codigo);

    reset (archivo);
    seek (archivo, 1); // salto cabecera

    leer (archivo, reg);
    while (reg.codigo <> valoralto) and (not esta) do begin
        if (reg.codigo = codigo) then
            esta := true
        else    
            leer (archivo, reg);
    end;

    if (esta = true) then begin
        write ('Ingrese genero nuevo: '); readln (reg.genero);
        write ('Ingrese nombre nuevo: '); readln (reg.nombre);
        seek (archivo, filepos(archivo)-1);
        write (archivo, reg);
        writeln ('Novela actualizada.')
    end
    else
        writeln ('No se encontro esa novela.');

    close (archivo);
end;

procedure eliminar (var archivo: AR);
var
    pos, codigo: integer;
    reg, header: novela;
    esta: boolean;
begin
    esta := false;
    pos := 1;
    write ('Ingrese codigo de novela a eliminar: '); readln (codigo);

    reset (archivo);
    read (archivo, header);

    leer (archivo, reg);
    while (reg.codigo <> valoralto) and (not esta) do begin
        if (reg.codigo = codigo) then
            esta := true
        else begin   
            leer (archivo, reg);
            pos := pos + 1;
        end;
    end;

    if (esta = true) then begin
        seek (archivo, filepos(archivo)-1);
        write (archivo, header); // cabecera en registro eliminado

        header.codigo := (pos * -1);
        seek (archivo, 0);
        write (archivo, header); // actualizo header

        writeln ('Novela eliminada correctamente.')
    end
    else
        writeln ('Novela no encontrado.');

    close (archivo);
end;

procedure opcionC (var archivo: AR);
var
    reg: novela;
    ar_texto: text;
begin
    reset (archivo);

    assign (ar_texto, 'novelas.txt');
    rewrite (ar_texto);

    // seek (archivo, 1); // descarto header

    leer (archivo, reg);
    while (reg.codigo <> valoralto) do begin
        write (ar_texto, reg.codigo, ', ');
        write (ar_texto, reg.genero, ', ');
        writeln (ar_texto, reg.nombre);

        leer (archivo, reg);
    end;

    close (archivo); close (ar_texto);
end;


var
    archivo: AR;
    nombre: string;
    opcion: integer;
begin
    write ('Ingrese nombre archivo: '); readln (nombre);
    assign (archivo, nombre);

    writeln ('   1: Crear archivo.'); 
    writeln ('   2: Alta novela.');
    writeln ('   3: Modificar novela.');
    writeln ('   4: Eliminar novela.');
    writeln ('   5: Listar en txt.');
    writeln ('   6: Salir.');
    write ('--OPCION: '); readln (opcion);

    while (opcion <> 6) do begin
        case opcion of
            1: opcionA (archivo);
        
            2: opcionB_i (archivo);

            3: opcionB_ii (archivo);

            4: opcionB_iii (archivo);

            5: opcionC (archivo);

            6: writeln ('Saliendo...');
        end;
        write ('--OPCION: '); readln (opcion);
    end;
end.