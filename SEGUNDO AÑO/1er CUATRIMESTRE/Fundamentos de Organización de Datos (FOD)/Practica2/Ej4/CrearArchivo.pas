program creararchivo;

type
    provinciaM = record
        nombre: string;
        alfabetizados: integer;
        encuestados: integer;
    end;

    provinciaD = record
        nombre: string;
        codigo_localidad: integer;
        alfabetizados: integer;
        encuestados: integer;
    end;

    AR_maestro = file of provinciaM;
    AR_detalle = file of provinciaD;

var
    provM: provinciaM;
    provD1, provD2: provinciaD;
    arch_maestro: AR_maestro;
    det1, det2: AR_detalle;

begin
    assign(arch_maestro, 'maestro');
    rewrite(arch_maestro);

    writeln('Ingresando datos de provincias en el archivo maestro...');
    repeat
        write('Nombre de la provincia (o "Z" para finalizar): '); readln(provM.nombre);
        if provM.nombre <> 'Z' then
        begin
            write('Cantidad de personas alfabetizadas: '); readln(provM.alfabetizados);
            write('Total de encuestados: '); readln(provM.encuestados);

            write(arch_maestro, provM);
        end;
    until provM.nombre = 'Z';

    close(arch_maestro);

    assign(det1, 'detalle1');
    rewrite(det1);

    assign(det2, 'detalle2');
    rewrite(det2);

    writeln('Ingresando datos de detalle en el archivo detalle1...');
    repeat
        write('Nombre de la provincia (o "Z" para finalizar): '); readln(provD1.nombre);
        if provD1.nombre <> 'Z' then
        begin
            write('Código de localidad: '); readln(provD1.codigo_localidad);
            write('Cantidad de personas alfabetizadas: '); readln(provD1.alfabetizados);
            write('Total de encuestados: '); readln(provD1.encuestados);

            write(det1, provD1);
        end;
    until provD1.nombre = 'Z';

    close(det1);

    writeln('Ingresando datos de detalle en el archivo detalle2...');
    repeat
        write('Nombre de la provincia (o "Z" para finalizar): '); readln(provD2.nombre);
        if provD2.nombre <> 'Z' then
        begin
            write('Código de localidad: '); readln(provD2.codigo_localidad);
            write('Cantidad de personas alfabetizadas: '); readln(provD2.alfabetizados);
            write('Total de encuestados: '); readln(provD2.encuestados);

            write(det2, provD2);
        end;
    until provD2.nombre = 'Z';

    close(det2);

    writeln('Archivos creados exitosamente.');
end.
