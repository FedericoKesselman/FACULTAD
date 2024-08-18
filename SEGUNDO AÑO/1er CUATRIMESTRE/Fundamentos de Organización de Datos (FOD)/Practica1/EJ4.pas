program FOD_P1_Ej4;
type
    RegistroEmpleado = record
        numero: integer;
        apellido: string [20];
        nombre: string [20];
        edad: integer;
        dni: integer;
    end;

    tipoArchivo = file of RegistroEmpleado;

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

procedure agregarAlFinal (var ArchivoEmpleados: tipoArchivo);
var
    empleado, ref: RegistroEmpleado;
    esta: boolean;
begin
    esta := false;
    leerEmpleado (ref);

    while (ref.apellido <> 'fin') do begin
        while (not eof(ArchivoEmpleados)) AND (not esta) do begin
            read (ArchivoEmpleados, empleado);

            if (empleado.numero = ref.numero) then
                esta := true;
        end;

        if (esta) then
            writeln ('Empleado ya ingresado')
        else begin
            write (ArchivoEmpleados, ref);
            writeln ('Agregado correctamente');
        end;
        leerEmpleado (ref);
    end;
end;

procedure modificarEdad (var ArchivoEmpleados: tipoArchivo);
var
    edadNueva: integer;
    numero: integer;
    seguir: boolean;
    empleado: RegistroEmpleado;
begin
    seguir := true;

    writeln ('Ingrese numero de empleado a modificar: ');
    readln (numero);
    
    writeln ('Ingrese edad nueva:');
    readln (edadNueva);

    while (not eof(ArchivoEmpleados)) AND (seguir) do begin
        read (ArchivoEmpleados, empleado);

        if (empleado.numero = numero) then
            seguir := false;
    end;   // se busca al empleado a modificar

    empleado.edad := edadNueva;  // se modifica

    seek (ArchivoEmpleados, filepos(ArchivoEmpleados)-1);
    write (ArchivoEmpleados, empleado);  // se guarda
end;

procedure exportarArchivo (var ArchivoEmpleados: tipoArchivo);
var
    texto: Text; 
    empleado: RegistroEmpleado;
begin
    assign (texto, 'todos_empleados.txt');
    rewrite (texto); // crea

    while (not eof(ArchivoEmpleados)) do begin
        read (ArchivoEmpleados, empleado); // lee el registro
        With empleado do 
            writeln (texto, numero,'   ',apellido,'   ',nombre,'   ',edad,'   ',dni);
    end;

    close (texto); // cierra
end;

procedure exportarSinDNI (var ArchivoEmpleados: tipoArchivo);
var
    texto: Text; 
    empleado: RegistroEmpleado;
begin
    assign (texto, 'faltaDNIEmpleado.txt');
    rewrite (texto); // crea

    while (not eof(ArchivoEmpleados)) do begin
        read (ArchivoEmpleados, empleado); // lee el registro
        
        if (empleado.dni = 00) then
            With empleado do 
                writeln (texto, numero,'   ',apellido,'   ',nombre,'   ',edad,'   ',dni);
    end;

    close (texto); // cierra
end;

procedure listarEmpleadosA (var ArchivoEmpleados: tipoArchivo);
var
    nombre: string;
    empleado: RegistroEmpleado;
begin
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

var
    ArchivoEmpleados: tipoArchivo;
    opcionMenu: integer;
    opcionSubmenu: string;
    nombreFisico: string;

begin
    writeln ('Ingrese opcion: ');
    readln (opcionMenu);

    case opcionMenu of
    1: begin   // crear
        writeln ('Ingrese nombre del archivo: '); 
        readln (nombreFisico);

        assign (ArchivoEmpleados, nombreFisico); // asigna
        rewrite (ArchivoEmpleados); // crea
        cargarArchivo (ArchivoEmpleados); //carga
        close (ArchivoEmpleados); // cierra
    end;

    2: begin   // abrir
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

    3: begin   // anadir empleado
        writeln ('Ingrese nombre del archivo: ');
        readln (nombreFisico);
        assign (ArchivoEmpleados, nombreFisico); // asigna

        reset (ArchivoEmpleados); // abre
        agregarAlFinal (ArchivoEmpleados);
        close (ArchivoEmpleados); // cierra
    end;

    4: begin   // modificar edad
        writeln ('Ingrese nombre del archivo: ');
        readln (nombreFisico);
        assign (ArchivoEmpleados, nombreFisico); // asigna

        reset (ArchivoEmpleados); // abre
        modificarEdad (ArchivoEmpleados);
        close (ArchivoEmpleados); // cierra
    end;

    5: begin   // exportar1
        writeln ('Ingrese nombre del archivo: ');
        readln (nombreFisico);
        assign (ArchivoEmpleados, nombreFisico); // asigna

        reset (ArchivoEmpleados); // abre
        exportarArchivo (ArchivoEmpleados);
        close (ArchivoEmpleados); // cierra
    end;

    6: begin   // exportar2
        writeln ('Ingrese nombre del archivo: ');
        readln (nombreFisico);
        assign (ArchivoEmpleados, nombreFisico); // asigna

        reset (ArchivoEmpleados); // abre
        exportarSinDNI (ArchivoEmpleados);
        close (ArchivoEmpleados); // cierra
    end;
end;
end.
        






