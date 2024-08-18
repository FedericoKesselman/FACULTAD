program FOD_P1_Ej1;
var
    ar_numero: file of integer;
    nombre_fisico: string;
    num: integer;
begin
    writeln ('Ingrese nombre del archivo: ');
    readln (nombre_fisico);

    assign (ar_numero, nombre_fisico); // asigna
    rewrite (ar_numero);  // crea

    writeln ('Ingrese numeros: ');
    readln (num);

    while (num<>3000) do begin
        write (ar_numero, num);
        readln (num);
    end;
    
    close (ar_numero);
end.   
