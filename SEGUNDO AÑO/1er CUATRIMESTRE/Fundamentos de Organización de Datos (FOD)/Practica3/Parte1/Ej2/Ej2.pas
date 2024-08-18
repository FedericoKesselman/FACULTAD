program FOD_P3_Ej2;
const
    valoralto = 9999;
type
    registro = record
        numero: integer;
        nombre: string[12];
        apellido: string[12];
    end;

    AR = file of registro;
//

procedure leer (var archivo: AR; var reg: registro);
begin
    if (not eof (archivo)) then
        read (archivo, reg)
    else
        reg.numero := valoralto;
end;

procedure leerTeclado (var reg: registro);
begin
    writeln ('--ASISTENTE NUEVO--');
    write ('Ingrese numero: '); readln(reg.numero);

    if (reg.numero <> valoralto) then begin
        write ('Ingrese nombre: '); readln(reg.nombre);
        write ('Ingrese apellido: '); readln(reg.apellido);
    end;
    writeln ('-------------------');
end;

procedure cargarArchivo (var archivo: AR);
var
    reg: registro;
begin
    leerTeclado(reg);

    while (reg.numero <> valoralto) do begin
        write (archivo, reg);
        leerTeclado(reg);
    end;
    writeln ('---CARGA FINALIZADA---');
end;

procedure eliminar (var archivo: AR);
var 
    reg: registro;
    ok: boolean;
begin
    ok := true;

    while (ok) do begin
        leer (archivo, reg);
        
        if (reg.numero <> valoralto) AND (reg.numero < 1000) then begin
            seek(archivo, filepos(archivo)-1);
            reg.nombre := '@Saldaño'; // marca borrado
            write (archivo, reg);
        end
        else
            ok := false;
    end;
    writeln ('--ASISTENTES CON NRO<1000 ELIMINADOS--');
end;

procedure imprimir (var archivo: AR); 
var
    reg: registro;
begin
    leer (archivo, reg);

    while (reg.numero <> valoralto) do begin
        if (reg.nombre <> '@Saldaño') then begin 
            write ('NUM: '); writeln (reg.numero);
            write ('Nombre: '); writeln (reg.nombre);
            write ('Apellido: '); writeln (reg.apellido);
        end;
        leer (archivo, reg);
    end;
end;

var
    archivo: AR;
begin
    assign (archivo, 'archivo');
    rewrite (archivo);

    cargarArchivo(archivo);
    
    seek(archivo, 0);
    eliminar (archivo);

    seek(archivo, 0);
    imprimir(archivo);

    close(archivo);
end.



