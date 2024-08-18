program FOD_P2_Ej4;
const
    valoralto = 'ZZZ';
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
//

procedure leer (var detalle: AR_detalle; var provincia: provinciaD);
begin
    if (not eof(detalle)) then 
        read (detalle, provincia)
    else
        provincia.nombre := valoralto;
end;

procedure minimo (var det1, det2: AR_detalle; var r1, r2, min: provinciaD);
begin
    if (r1.nombre <= r2.nombre) then begin
        min := r1;
        leer (det1, r1)
    end
    else begin
        min := r2;
        leer (det2, r2);
    end;
end;

procedure actualizarMaestro(var maestro: AR_maestro; det1, det2: AR_detalle);
var
    regM: provinciaM;
    regD1: provinciaD;
    regD2: provinciaD;
    min: provinciaD;
begin
    leer (det1, regD1); leer (det2, regD2);
    minimo (det1, det2, regD1, regD2, min);

    while (min.nombre <> valoralto) do begin
        read (maestro, regM);

        while (regM.nombre <> min.nombre) do
            read (maestro, regM);

        while (regM.nombre = min.nombre) do begin
            regM.alfabetizados := regM.alfabetizados + min.alfabetizados;
            regM.encuestados := regM.encuestados + min.encuestados;
            minimo (det1, det2, regD1, regD2, min);
        end;

        seek (maestro, Filepos(maestro)-1);
        write (maestro, regM);
    end;
end;

var
    maestro: AR_maestro;
    det1: AR_detalle;
    det2: AR_detalle;
begin
    assign (maestro, 'maestro');
    assign (det1, 'detalle1'); assign (det2, 'detalle2');
    reset (maestro); reset (det1); reset (det2);

    actualizarMaestro (maestro, det1, det2);

    close (maestro); close (det1); close(det2); 
end.
    
