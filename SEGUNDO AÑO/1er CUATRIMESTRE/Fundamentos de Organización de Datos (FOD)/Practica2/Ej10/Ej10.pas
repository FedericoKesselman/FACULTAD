program FOD_P2_Ej10;
const
    valoralto = 9999;
type
    empleado_reg = record
        departamento: integer;
        division: integer;
        numero: integer;
        categoria: integer;
        horas: integer;
    end;

    AR_maestro = file of empleado_reg;
    valor_categorias = array [1..15] of integer;
//
  
procedure leer (var maestro: AR_maestro; var empleado: empleado_reg);
begin
    if (not eof(maestro)) then
        read(maestro, empleado)
    else
        empleado.departamento := valoralto;
end;

procedure cargar_vector (var categorias: valor_categorias);
var
    carga: Text;
    i, monto: integer;
begin
    for i := 1 to 15 do
        categorias[i] := 0;

    assign (carga, 'valores_categorias.txt');
    reset (carga);

    while (not eof(carga)) do begin
        readln (carga, i, monto);
        categorias[i] := categorias[i] + monto;
    end;

    close (carga);
end;

var
    maestro: AR_maestro;
    categorias: valor_categorias;
    empleado: empleado_reg;

    departamento_act: integer;
    horas_departamento: integer;
    monto_departamento: integer;

    division_act: integer;
    horas_division: integer;
    monto_division: integer;

    empleado_act: integer;
    horas_empleado: integer;
    monto_empleado: integer;

begin
    cargar_vector(categorias);

    assign (maestro, 'maestro');
    reset (maestro);
    leer (maestro, empleado);

    while (empleado.departamento <> valoralto) do begin
        writeln (' ');
        writeln ('Departamento: ', empleado.departamento);
        departamento_act := empleado.departamento;
        horas_departamento := 0;
        monto_departamento := 0;

        while (empleado.departamento = departamento_act) do begin
            writeln (' ');
            writeln ('Division: ', empleado.division);
            division_act := empleado.division;
            horas_division := 0;
            monto_division := 0;
            writeln ('Número de Empleado      Total de Hs.      Importe a cobrar');

            while (empleado.departamento = departamento_act) AND (empleado.division = division_act) do begin
                empleado_act := empleado.numero;
                horas_empleado := 0;
                monto_empleado := 0;

                while (empleado.departamento = departamento_act) AND (empleado.division = division_act) AND (empleado.numero = empleado_act) do begin
                    horas_empleado := horas_empleado + empleado.horas;
                    leer (maestro, empleado);
                end;
                monto_empleado := horas_empleado * categorias[empleado.categoria];

                writeln (empleado_act, '   ', horas_empleado, '   ', monto_empleado);
                writeln ('Número de Empleado      Total de Hs.      Importe a cobrar');

                horas_division := horas_division + horas_empleado;
                monto_division := monto_division + monto_empleado;
            end;

            writeln ('Total horas division: ', horas_division);
            writeln ('Monto total por division: ', monto_division);

            horas_departamento := horas_departamento + horas_division;
            monto_departamento := monto_departamento + horas_division;
        end;

        writeln ();
        writeln ('Total horas departamento: ', horas_departamento);
        writeln ('Monto total por departamento: ', monto_departamento);
    end;

    writeln ('Impresion finalizada');
    close (maestro);
end.



            


    

    