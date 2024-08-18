program parcial;
const
    valoralto = 9999;
type
    reg_fecha = record
        anio, mes, dia: integer;
    end;

    empleado = record
        dni, edad: integer;
        nombre, apellido, domicilio: string;
        fecha_nacimiento: reg_fecha;
    end;

    AR = file of empleado;
//

procedure leer (var archivo: AR; var reg: empleado);
begin
    if (not eof(archivo)) then
        read (archivo, reg);
    else
        reg.dni := valoralto;
end;


procedure agregarEmpleado (var archivo: AR);
var
    reg, header, reg_nuevo: empleado;
begin
    reset (archivo);
    write ('Ingre DNI del empleado a agregar: '); readln(reg_nuevo.dni) // LO MISMO CON EL RESTO DE CAMPOS
    leer (archivo, header);

    if (not existeEmpleado(archivo, reg)) then begin
        if (header.dni = 0) then begin
            seek (archivo, filesize(archivo));
            write (archivo, reg_nuevo);
        end
        else begin
            seek (archivo, header.dni*-1);
            leer (archivo, header); // CABECERA NUEVA

            seek (archivo, filepos(archivo)-1);
            write (archivo, reg_nuevo);  // ESCRIBE REGISTRO NUEVO

            seek (archivo, 0);
            write (archivo, header);  // ESCRIBE CABECERA NUEVA
        end;
    end
    else write ('El empleado con ese codigo ya existe.');

    close (archivo);
end;


procedure quitarEmpleado (var archivo: AR);
var
    header, reg: empleado;
    dni: integer;
begin
    reset (archivo);
    write ('Ingrese dni del empleado a eliminar: ');
    leer (archivo, header);

    if (existeEmpleado(archivo, dni)) then begin
        leer (archivo, reg);

        while (reg.dni <> dni) do
            leer (archivo, reg);

        seek (archivo, filepos(archivo)-1);
        write (archivo, header);

        header.dni := (filepos(archivo)-1)*-1;

        seek (archivo, 0);
        write (archivo, header);
    end
    else writeln ('No se encontro empleado con ese DNI.');

    close (archivo);
end;

var
    archivo: AR;
begin
    assign (archivo, 'archivo');
    agregarEmpleado(archivo);
    quitarEmpleado(archivo);
end.

