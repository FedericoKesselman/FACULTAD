program FOD_P1_Ej2;
var
    ar_numero: file of integer;
    nombre_fisico: string;

    menores: integer;

    suma: integer;
    nro: integer;
    cant: integer;
begin
    menores := 0;

    writeln ('Ingrese nombre del archivo: ');
    readln (nombre_fisico);
 
    assign (ar_numero, nombre_fisico); // asigna

    reset (ar_numero); // abre
    cant := FileSize (ar_numero);

    while not eof (ar_numero) do begin
        read (ar_numero, nro);
        
        if (nro < 1500) then
            menores := menores+1;
    
        suma := suma + nro;
        writeln (nro);
    end;
    close (ar_numero);

    writeln ('Cantidad de numeros menores a 1500: ', menores);
    writeln ('Promedio de numeros: ', (suma/cant):1:2);
end.


