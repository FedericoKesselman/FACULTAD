program imprimir_maestro_simple;
const
    valoralto = 'ZZZ';

type
    provinciaM = record
        nombre: string;
        alfabetizados: integer;
        encuestados: integer;
    end;

    AR_maestro = file of provinciaM;

var
    provM: provinciaM;
    arch_maestro: AR_maestro;

begin
    assign(arch_maestro, 'maestro');
    reset(arch_maestro);

    writeln('Contenido del archivo maestro:');
    while not eof(arch_maestro) do
    begin
        read(arch_maestro, provM);
        writeln('Nombre Provincia: ', provM.nombre);
        writeln('Alfabetizados: ', provM.alfabetizados);
        writeln('Encuestados: ', provM.encuestados);
        writeln;
    end;

    close(arch_maestro);
end.
