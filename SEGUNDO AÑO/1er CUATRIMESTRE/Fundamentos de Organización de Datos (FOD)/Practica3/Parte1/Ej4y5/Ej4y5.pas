program FOD_P3_Ej4y5;
const
    valoralto = 9999;
type
    reg_flor = record
        nombre: String[45];
        codigo:integer;
    end;

    tArchFlores = file of reg_flor;
//

procedure agregarFlor (var a: tArchFlores; nombre: string; codigo:integer);
var
    reg, header: reg_flor;
begin
    reset (a);
    read (a, header);

    reg.nombre := nombre;
    reg.codigo := codigo;

    if (header.codigo = 0) then begin
        seek (a, filesize(a));
        write (a, reg)
    end 
    else begin
        seek (a, (header.codigo * -1));
        read (a, header); // toma cabecera nueva
        seek (a, filepos(a)-1);
        write (a, reg); // reg nuevo
        seek (a, 0);
        write (a, header); // actualiza cabecera
    end;

    close (a);
end;

procedure leer (var archivo: tArchFlores; var reg: reg_flor);
begin
    if (not eof (archivo)) then
        read (archivo, reg)
    else
        reg.codigo := valoralto;
end;

procedure listarContenido (var a: tArchFlores);
var
    reg: reg_flor;
begin   
    reset (a);
    seek (a, 1); // descarto cabecera

    leer (a, reg);
    while (reg.codigo <> valoralto) do begin
        if (reg.codigo > 0) then
            writeln (reg.nombre, ' / ', reg.codigo, '.');
        leer (a, reg);
    end;

    close (a);
end;

procedure eliminarFlor (var a: tArchFlores; flor: reg_flor);
var
    reg, header: reg_flor;
    pos: integer;
    esta: boolean;
begin   
    pos := 1;
    esta := false;

    reset (a);
    read (a, header);

    leer (a, reg);
    while (reg.codigo <> valoralto) and (not esta) do begin
        if (reg.codigo = flor.codigo) and (reg.nombre = flor.nombre) then
            esta := true
        else begin
            leer (a, reg);
            pos := pos + 1;
        end;
    end;

    if (esta = true) then begin
        seek (a, filepos(a)-1);
        write (a, header); // cabecera en reg eliminado
        
        header.codigo := (pos * -1);
        seek (a, 0);
        write (a, header);

        writeln ('Flor eliminada correctamente.')
    end
    else
        writeln ('No se encontro flor con ese codigo.');
    
    close (a);
end;
        
var
    a: tArchFlores;
    nombre: string;
    flor: reg_flor;
    opcion: integer;
begin
    write ('Ingrese nombre archivo: '); readln (nombre);
    assign (a, nombre);

    writeln ('   1: Agregar flor.'); 
    writeln ('   2: Eliminar flor.');
    writeln ('   3: Listar archivo.');
    writeln ('   4: Salir.');
    write ('--OPCION: '); readln (opcion);

    while (opcion <> 4) do begin
        case opcion of
            1: begin
                write ('Ingrese nombre flor: '); readln (flor.nombre);
                write ('Ingrese codigo flor: '); readln (flor.codigo);
                agregarFlor (a, flor.nombre, flor.codigo);
            end;

            2: begin
                write ('Ingrese nombre flor: '); readln (flor.nombre);
                write ('Ingrese codigo flor: '); readln (flor.codigo);
                eliminarFlor (a, flor);
            end;

            3: listarContenido (a);

            4: writeln ('Saliendo...');
        end;
        write ('--OPCION: '); readln (opcion);
    end;
end.