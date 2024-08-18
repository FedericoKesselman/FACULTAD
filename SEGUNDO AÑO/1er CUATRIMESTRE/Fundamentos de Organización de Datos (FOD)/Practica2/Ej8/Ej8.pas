program FOD_P2_Ej8;
const
    valoralto = 9999;
type
    reg_cliente = record
        codigo: integer;
        nombre: string;
        apellido: string;
        ano: integer;
        mes: integer;
        dia: integer;
        monto: integer;
    end;

    archivo = file of reg_cliente;
//

procedure leer (var maestro: archivo; var cliente: reg_cliente);
begin
    if (not eof (maestro)) then
        read(maestro, cliente)
    else
        cliente.codigo := valoralto;
end;

var
    maestro: archivo;
    cliente: reg_cliente;

    cliente_actual: integer;
    total_mensual: integer;
    mes_actual: integer;
    ano_actual: integer;
    total_anual: integer;
    
    total_ventas: integer;
begin
    assign (maestro, 'maestro');
    reset (maestro);
    leer (maestro, cliente);

    total_ventas := 0;

    while (cliente.codigo <> valoralto) do begin // mientras que no termine el archivo
        writeln (cliente.codigo, ' ', cliente.nombre, ' ', cliente.apellido, '.');
        cliente_actual := cliente.codigo;

        while (cliente.codigo = cliente_actual) do begin // mismo cliente
                total_anual := 0;
                ano_actual := cliente.ano;

            while (cliente.codigo = cliente_actual) AND (cliente.ano = ano_actual) do begin // mismo ano
                total_mensual := 0;
                mes_actual := cliente.mes;
            
                while (cliente.codigo = cliente_actual) AND (cliente.ano = ano_actual) AND (cliente.mes = mes_actual) do begin // mismo mes
                    total_mensual := total_mensual + cliente.monto;
                    leer (maestro, cliente);
                end;

                if (total_mensual > 0) then begin
                    writeln ('Total mes ', mes_actual, ': $', total_mensual);
                    total_anual := total_anual + total_mensual;
                end;
            end;

                if (total_anual > 0) then begin
                    writeln ('Total año ', ano_actual, ': $', total_anual);
                    total_ventas := total_ventas + total_anual;
                end;
        end;
    end;

    writeln ('Total ventas de la empresa: $', total_ventas);
end.

        

