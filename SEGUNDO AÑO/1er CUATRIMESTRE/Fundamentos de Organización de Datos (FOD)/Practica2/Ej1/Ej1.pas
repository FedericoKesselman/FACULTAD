program FOD_P2_Ej1; 
const
    valoralto = 9999;
type
    empleado = record
        codigo: integer;
        nombre: string;
        monto: integer;
    end;
    com_empleado = record
        codigo: integer;
        comisiones: integer;
    end;

    maestro = file of empleado;
    detalle = file of com_empleado;
//

procedure imprimir (var ar: maestro);
var
    emp: empleado;
begin
    reset (ar);
    while (not eof(ar)) do begin
        read (ar, emp);
        writeln ('Codigo: ', emp.codigo);
        writeln ('Nombre: ', emp.nombre);
        writeln ('Monto: ', emp.monto);
        writeln ('---------');
    end;
    close (ar);
end;

procedure leer (var archivo: detalle; var dato: com_empleado);
begin
    if (not eof(archivo)) then
        read (archivo, dato)
    else
        dato.codigo := valoralto;
end;


var
    regm: empleado;
    regd: com_empleado;
    mae1: maestro;
    det1: detalle;
begin
    assign (mae1, 'maestro');
    assign (det1, 'detalle');
    reset (mae1); reset (det1);

    leer (det1, regd);

    while (regd.codigo <> valoralto) do begin
        read (mae1, regm);
        while (regm.codigo <> regd.codigo) do
            read (mae1, regm);

        while (regm.codigo = regd.codigo) do begin
            regm.monto := regm.monto + regd.comisiones;
            leer (det1, regd);
        end;

        seek (mae1, Filepos (mae1)-1);
        write (mae1, regm);
    end;
    close (mae1); close(det1);

    imprimir(mae1);
end.