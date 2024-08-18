program FOD_P1_Ej3;
type
    RegistroEmpleado = record
        numero: integer;
        apellido: string;
        nombre: string;
        edad: integer;
        dni: integer;
    end;

    tipoArchivo = file of RegistroEmpleado;
//

procedure leerEmpleado (var empleado: RegistroEmpleado);
begin
    writeln ('Ingrese apellido: ');
    readln (empleado.apellido);

    if (empleado.apellido <> 'fin') then begin
        writeln ('Ingrese numero: ');
        readln (empleado.numero);

        writeln ('Ingrese nombre: ');
        readln (empleado.nombre);

        writeln ('Ingrese edad: ');
        readln (empleado.edad);

        writeln ('Ingrese DNI: ');
        readln (empleado.dni);
    end;

    writeln ('-----');
end;


procedure mostrarEmpleado (empleado: RegistroEmpleado);
begin
    writeln ('EMPLEADO: ');
    writeln (empleado.numero);
    writeln (empleado.apellido);
    writeln (empleado.nombre);
    writeln (empleado.edad);
    writeln (empleado.dni);
    writeln ('-----');
end;


procedure cargarArchivo (var ArchivoEmpleados: tipoArchivo);
var
    empleado: RegistroEmpleado;
begin
    leerEmpleado (empleado);

    while (empleado.apellido <> 'fin') do begin
        write (ArchivoEmpleados, empleado);
        leerEmpleado (empleado);
    end;
end;


procedure listarEmpleadosA (var ArchivoEmpleados: tipoArchivo);
var
    nombre: string;
    empleado: RegistroEmpleado;
begin
    writeln ('Buscar empleados con el nombre: ');
    readln (nombre);

    while not eof (ArchivoEmpleados) do begin
        read (ArchivoEmpleados, empleado);
        
        if (empleado.nombre = nombre) then  
          mostrarEmpleado (empleado);
    end;
end;

procedure listarEmpleadosB (var ArchivoEmpleados: tipoArchivo);
var
    empleado: RegistroEmpleado;
begin
    while not eof (ArchivoEmpleados) do begin
        read (ArchivoEmpleados, empleado);
        mostrarEmpleado (empleado);
    end;
end;


procedure listarEmpleadosC (var ArchivoEmpleados: tipoArchivo);
var
    empleado: RegistroEmpleado;
begin
    while not eof (ArchivoEmpleados) do begin
        read (ArchivoEmpleados, empleado);
        
        if (empleado.edad > 70) then
            mostrarEmpleado (empleado);
    end;
end;
// 

var
    ArchivoEmpleados: tipoArchivo;
    opcionMenu: integer;
    opcionSubmenu: string;
    nombreFisico: string;

    nombreDeterminado, apellidoDeterminado: string;

begin

    repeat 
        writeln ('Ingrese 1(Crear) , 2(Abrir), 3(Finalizar): ');
        readln (opcionMenu);

        if (opcionMenu = 1) then begin
            writeln ('Ingrese nombre del archivo: '); 
            readln (nombreFisico);

            assign (ArchivoEmpleados, nombreFisico); // asigna
            rewrite (ArchivoEmpleados); // crea
            cargarArchivo (ArchivoEmpleados); //carga
            close (ArchivoEmpleados); // cierra
        end
        else
            if (opcionMenu = 2) then begin
                writeln ('Ingrese nombre del archivo: ');
                readln (nombreFisico);
                
                assign (ArchivoEmpleados, nombreFisico); // asigna

                writeln ('Ingrese A(Listar Determinados), B(Listar Todos), C(Listar +70): '); 
                readln (opcionSubmenu);

                reset (ArchivoEmpleados); // abre

                case (opcionSubmenu) of
                'A': listarEmpleadosA (ArchivoEmpleados); 
                'B': listarEmpleadosB (ArchivoEmpleados);
                'C': listarEmpleadosC (ArchivoEmpleados);
                end;

                close (ArchivoEmpleados); // cierra
            end;

    until (opcionMenu = 3); 
end.
        






