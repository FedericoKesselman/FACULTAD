program FOD_P1_Ej6;
type 
    RegCelular = record
        codigo: integer;
        nombre: string[12];
        descripcion: string[12];
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
    assign (carga, 'celulares.txt');
    reset (carga);

    write ('Ingrese nombre del archivo nuevo: ');
    readln (nombreF);
    assign (celulares, nombreF);
    rewrite (celulares);

    while (not eof(carga)) do begin
        with rCelular do readln (carga, codigo, stockMin, stockDis);
        with rCelular do readln (carga, nombre);
        with rCelular do read (carga, descripcion);
        write (celulares, rCelular);
    end; 

    writeln ('Archivo cargado');
    close (carga); close (celulares);
end;

procedure mostrarCelular (rCelular: RegCelular);
begin
    writeln ('Codigo: ', rCelular.codigo);
    writeln ('Nombre: ', rCelular.nombre);
    writeln ('Descripcion: ', rCelular.descripcion);
    writeln ('Stock minimo: ', rCelular.stockMin);
    writeln ('Stock disponible: ', rCelular.stockDis);
end;

procedure listarArchivo (var celulares: archivoCelulares);
var
    rCelular: RegCelular;
    nombreA: string;
begin
    write ('Ingrese nombre del archivo: ');
    readln (nombreA);
    assign (celulares, nombreA);
    reset (celulares);

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
    nombreA: string; 
begin
    write ('Ingrese nombre del archivo: ');
    readln (nombreA);
    assign (celulares, nombreA);
    reset (celulares);

    assign (texto, 'celulares2.txt');
    rewrite (texto);

    while (not eof(celulares)) do begin
        read (celulares, rCelular);

        with rCelular do writeln (texto, 'Codigo: ', codigo, ' / Nombre: ', nombre, ' / Descripcion: ', descripcion);
        with rCelular do writeln (texto, 'Stock disponible: ', stockDis, ' / Stock minimo: ', stockMin);
    end;

    close (celulares);
end;

procedure agregarAlFinal (var celulares: archivoCelulares);
var
    rCelular: RegCelular;
    nombreA: string;
begin
    write ('Ingrese nombre del archivo: ');
    readln (nombreA);
    assign (celulares, nombreA);
    reset (celulares);

    seek (celulares, FileSize(celulares)); // ultima posicion

    write ('Ingrese codigo de celular: '); readln (rCelular.codigo);
    while (rCelular.codigo <> 00) do begin
        write ('Nombre: '); read (rCelular.nombre); 
        write ('Descripcion: '); read (rCelular.descripcion); 
        write ('Stock minimo: '); read (rCelular.stockMin); 
        write ('Stock disponible: '); read (rCelular.stockDis); 

        write (celulares, rCelular);
        write ('Ingrese codigo de celular: '); readln (rCelular.codigo);
    end;

    close (celulares);
end;

procedure modificarStock (var celulares: archivoCelulares);
var
    rCeluar: RegCelular;
    nombreA: string;
    cod, stockNuevo: integer;
    sigo: boolean;
begin
    sigo := true;

    write ('Ingrese nombre del archivo: ');
    readln (nombreA);
    assign (celulares, nombreA);
    reset (celulares);

    write ('Codigo de celular a modificar: ');
    readln (cod);
    write ('Stock nuevo: ');
    readln (stockNuevo);

    while not eof(celulares) AND sigo do begin
        read (celulares, rCeluar);

        if (rCeluar.codigo = cod) then begin
            sigo := false;
            rCeluar.stockDis := stockNuevo;
            
            seek (celulares, filepos(celulares)-1);
            write (celulares, rCeluar);
        end;
    end;

    close (celulares);
end;

procedure exportarArchivoSinStock (var celulares: archivoCelulares);
var
    texto: Text;
    rCelular: RegCelular;
    nombreA: string; 
begin
    write ('Ingrese nombre del archivo: ');
    readln (nombreA);
    assign (celulares, nombreA);
    reset (celulares);

    assign (texto, 'SinStock.txt');
    rewrite (texto);

    while (not eof(celulares)) do begin
        read (celulares, rCelular);
        
        if (rCelular.stockDis = 0) then begin
            with rCelular do writeln (texto, 'Codigo: ', codigo, ' / Nombre: ', nombre, ' / Descripcion: ', descripcion);
            with rCelular do writeln (texto, 'Stock disponible: ', stockDis, ' / Stock minimo: ', stockMin);
        end;
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
    5: agregarAlFinal (celulares);
    6: modificarStock (celulares);
    7: 
    end;
end.