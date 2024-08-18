procedure leer (var archivo: detalle; var dato: com_empleado);
begin
    if (not eof(archivo)) then
        read (archivo, dato)
    else
        dato.codigo := valoralto;
end;


begin
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
end.