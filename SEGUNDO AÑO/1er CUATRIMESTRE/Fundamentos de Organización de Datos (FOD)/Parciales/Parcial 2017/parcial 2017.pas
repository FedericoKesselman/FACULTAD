program pacial;
const
    valoralto = 9999;
type
    sistemaO = record
        nombre_sistema_operativo, tipo_licencia: string;
        cantidad_instalaciones: integer;
        es_de_codigo_abierto: boolean;
    end;

    AR = file of registro;
//
procedure leer (var archivo: AR; var reg: sistemaO);
begin
    if (not eof(archivo)) then
        read (archivo, reg);
    else
        reg.cantidad_instalaciones := valoralto;
end;

procedure leerSO (var archivo: AR; var s: sistemaO);
begin
    writeln('Ingrese el nombre del SO: ');
    readln(s.nombre_sistema_operativo);
    writeln('Ingrese la cantidad de instalaciones del SO: ');
    readln(s.cantidad_instalaciones);
    writeln('Ingrese si es de codigo abierto: ');
    readln(s.es_de_codigo_abierto);
    writeln('Ingrese el tipo de licencia: ');
    readln(s.tipo_licencia);
end;


procedure ALTA_SistemaOperativo (var archivo: AR; var reg_nuevo: sistemaO);
var
    reg, header: sistemaO;
begin
    reset (archivo);

    leer (archivo, header);
    if (header.cantidad_instalaciones = 0) then begin
        seek (archivo, filesize(archivo));
        write (archivo, reg_nuevo);
    end
    else begin
        seek (archivo, header.cantidad_instalaciones * -1);
        leer (archivo, header); // CABECERA NUEVA

        seek (archivo, filepos(archivo)-1);
        write (archivo, reg_nuevo);  // ESCRIBE REGISTRO NUEVO

        seek (archivo, 0);
        write (archivo, header);  // CABECERA NUEVA
    end;

    writeln ('SO agregado correctamente.');
    close (archivo);
end;


procedure BAJA_SistemaOperativo (var archivo: AR; var reg_borar: sistemaO);
var
    reg, header: sistemaO;
begin
    reset (archivo);

    leer (archivo, header);
    leer (archivo, reg);
    while (reg.cantidad_instalaciones <> valoralto) AND (reg.cantidad_instalaciones <> reg_borar.cantidad_instalaciones) do 
        leer (archivo, reg);
    
    if (reg.cantidad_instalaciones = reg_borrar.cantidad_instalaciones) then begin
        seek (archivo, filepos(archivo)-1); 
        write (archivo, header); // HEADER EN REG ELIMINADO

        header.cantidad_instalaciones := (filepos(archivo)-1)*-1;

        seek (archivo, 0);
        write (archivo, header);

        writeln ('SO borrado correctamente.');
    end;
    else writeln ('No se pudo borrar, no se encontro ese SO.');

    close (archivo);
end;

var
    archivo: AR;
    reg_nuevo, reg_borrar: sistemaO;
begin
    assign (archivo);
    leerSO (reg_nuevo); 
    leerSO (reg_borar);  
    ALTA_SistemaOperativo (archivo, reg_nuevo);
    BAJA_SistemaOperativo (archivo, reg_borrar);
end.
