program parcial;
const
    valoralto = 9999;
type
    reg_fecha = record
        anio, mes, dia: integer;

    venta = record
        numero_sucursal, dni_empleado, numero_prestamo, monto: integer;
        fecha: reg_fecha;
    end;

    AR = file of venta;

procedure leer (var archivo: AR; var reg: venta);
begin
    if (not eof(archivo)) then
        read(archivo, reg);
    else
        reg.numero_sucursal := valoralto;
end;

procedure informe (var archivo: AR);
var
    reg: venta; 
    texto: Text;
    // VARIABLES DE ACTUALES Y CANTIDADES
begin
    reset (archivo);
    assign (texto, 'Informe.txt'); 
    rewrite (texto);
    write (texto, 'Informe de ventas de la empresa: ');

    leer (archivo, reg);
    total_ventas_empresa := 0; total_monto_empresa := 0;

    while (reg.numero_sucursal <> valoralto) do begin
        write (texto, 'Sucursal ', reg.numero_sucursal); sucursal_actual := reg.numero_sucursal;
        total_ventas_sucursal := 0; total_monto_sucursal := 0;

        while (reg.numero_sucursal <> valoralto) AND (reg.numero_sucursal = sucursal_actual) do begin
            write (texto, 'Empleado', reg.dni_empleado); empleado_actual := reg.dni_empleado;
            total_ventas_empleado := 0; total_monto_empleado := 0;

            while (reg.numero_sucursal <> valoralto) AND (reg.numero_sucursal = sucursal_actual) AND (reg.dni_empleado = empleado_actual) do begin
                write (texto, reg.fecha.anio); anio_actual := reg.fecha.anio;
                ventas_anio := 0; monto_anio := 0;

                while (reg.numero_sucursal <> valoralto) AND (reg.numero_sucursal = sucursal_actual) AND (reg.dni_empleado = empleado_actual) AND (reg.fecha.anio = anio_actual) do begin
                    ventas_anio := ventas_anio + 1; monto_anio := monto_anio + reg.monto;
                    leer (archivo, reg);
                end;

                write (texto, ventas_anio, monto_anio);
                total_ventas_empleado := total_ventas_empleado + ventas_anio;
                total_monto_empleado := total_monto_empleado + monto_anio;
            end;

            write (texto, total_ventas_empleado, total_monto_empleado);
            total_ventas_sucursal := total_ventas_sucursal + total_ventas_empleado;
            total_monto_sucursal := total_monto_sucursal + total_monto_empleado;
        end;

        write (texto, 'Total ventas sucursal: ', total_ventas_sucursal, ' Total monto sucursal: ', total_monto_sucursal);
        total_ventas_empresa := total_ventas_empresa + total_ventas_sucursal;
        total_monto_empresa := total_monto_empresa + total_monto_sucursal;
    end;

    write (texto, 'Total ventas empresa: ', total_ventas_empresa, 'Total monto empresa: ', total_monto_empresa);
    close (archivo); close (texto);
end;

var
    archivo: AR;
begin
    assing (archivo, 'archivo');
    informe (archivo);
end;


