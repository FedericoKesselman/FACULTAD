program b2;
type 
    RegCelular = record
        codigo: integer;
        nombre: string[12];
        descripcion: string[20];
        stockMin: integer;
        stockDis: integer;
    end;

    archivoCelulares = file of RegCelular;
//

procedure crearArchivo (var celulares: archivoCelulares);
var
    carga: Text;
    rCelular: RegCelular;
    nombreF: string;
begin
    write ('Ingrese nombre del archivo de texto: ');
    readln (nombreF);

    assign (carga, nombreF);
    reset (carga);

    rewrite (celulares);

    while (not eof(carga)) do begin
        readln(carga, rCelular.codigo, rCelular.nombre, rCelular.descripcion, rCelular.stockMin, rCelular.stockDis);
        write(celulares, rCelular);
    end; 

    writeln ('Archivo cargado');
    close (carga); close (celulares);
end;

procedure mostrarCelular (rCelular: RegCelular);
begin
    writeln ('Codigo: ', rCelular.codigo);
    writeln ('Nombre: ', rCelular.descripcion);
    writeln ('Descripcion: ', rCelular.descripcion);
    writeln ('Stock minimo: ', rCelular.stockMin);
    writeln ('Stock disponible: ', rCelular.stockDis);
end;

procedure listarArchivo (var celulares: archivoCelulares);
var
    rCelular: RegCelular;
begin
    reset (celulares);
    assign 

    while (not eof(celulares)) do begin
        read (celulares, rCelular);

        mostrarCelular (rCelular);
    end;

    close (celulares);
end;

{ procedure listarSinDesc (var celulares: archivoCelulares);
var
    rCelular: RegCelular;
begin
    reset (celulares);

    while (not eof(celulares)) do begin
        read (celulares, rCelular);

        if (rCelular.descripcion = text) then  
            mostrarCelular (rCelular);
    end;

    close (celulares);
end; }

procedure exportarArchivo (var celulares: archivoCelulares);
var
    texto: Text;
    rCelular: RegCelular;
begin
    assign (texto, 'celulares2.txt');
    rewrite (texto);

    reset (celulares);

    while (not eof(celulares)) do begin
        read (celulares, rCelular);

        with rCelular do writeln (texto, 'Codigo: ', codigo, ' / Nombre: ', nombre, ' / Descripcion: ', descripcion);
        with rCelular do writeln (texto, 'Stock disponible: ', stockDis, ' / Stock minimo: ', stockMin);
    end;

    close (celulares);
end;

var
    celulares: archivoCelulares;
    opcionMenu: integer;
begin
    write ('Ingrese opcion: ');
    readln (opcionMenu);

    case (opcionMenu) of 
    1: crearArchivo (celulares); 
    2: listarArchivo (celulares);
    3: writeln ('Opcion no disponible'); // listarSinDesc (celulares);
    4: exportarArchivo (celulares);
    end;
end.