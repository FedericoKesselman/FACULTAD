program FOD_P2_Ej2;
const
    valoralto = 9999;
type
    alumnoM = record
        codigo: integer;
        apellido: string;
        nombre: string;
        mat_sinF: integer;
        mat_conF: integer;
    end;

    alumnoD = record
        codigo: integer;
        aprobo: boolean; // true si aprobo el final. false si unicamente cursada
    end;

    AR_maestro =  file of alumnoM;
    AR_detalle = file of alumnoD;
//

procedure leer (var ar: AR_detalle; var a: alumnoD);
begin
    if (not eof (ar)) then
        read (ar, a)
    else
        a.codigo := valoralto;
end;

procedure opcionA (var detalle: AR_detalle; var maestro: AR_maestro);
var
    regM: alumnoM; regD: alumnoD;
begin
    assign (detalle, 'detalle');
    assign (maestro, 'maestro');
    reset (detalle); reset (maestro);

    leer (detalle, regD);
    while (regD.codigo <> valoralto) do begin
        read (maestro, regM);

        while (regD.codigo = regM.codigo) do begin
            if (regD.aprobo = true) then begin
                regM.mat_conF := regM.mat_conF + 1;
                regM.mat_sinF := regM.mat_sinF - 1
            end
            else
                regM.mat_sinF := regM.mat_sinF + 1;

            leer (detalle, regD);
        end;

        seek (maestro, Filepos(maestro)-1);
        write (maestro, regM);
    end;
    close (detalle); close (maestro);
end;

procedure opcionB (var maestro: AR_maestro);
var
    texto: Text;
    alumno: alumnoM;
begin
    assign (maestro, 'maestro');
    reset (maestro);
    assign (texto, 'alumnos_con_mas_finales.txt');
    rewrite (texto);

    while (not eof(maestro)) do begin
        read (maestro, alumno);
        
        if (alumno.mat_conF > alumno.mat_sinF) then begin
            with alumno do write (texto, codigo);
            with alumno do write (texto, ' ', apellido);
            with alumno do write (texto, ' ', nombre);
            with alumno do write (texto, ' Materias con final ', mat_conF);
            with alumno do writeln (texto, ' Materias sin final ', mat_sinF);
        end;
    end;

    close(maestro); close(texto);
end;

var
    maestro: AR_maestro;
    detalle: AR_detalle;
    opcion: integer;
begin
    write ('Ingrese opcion (1: Actualizar maestro, 2: Listar alumnos): ');
    readln (opcion);

    if (opcion = 1) then
        opcionA (detalle, maestro)
    else
        opcionB (maestro);
end.