program parcial;
const
    valoralto = 9999;
type
    producto = record
        codigo, precio_compra, precio_venta: integer;
        nombre, ubicacion: string;
    end;

    AR = file of producto;
//

procedure leer (var archivo: AR; var reg: producto);
begin
    if (not eof(archivo)) then 
        read (archivo, reg);
    else
        reg.codigo := valoralto;
end;

procedure agregarProducto (var archivo: AR);
var
    reg, reg_nuevo, header: producto;
begin
    reset(archivo);
    write ('Ingrese codigo del nuevo producto: '); readln(reg_nuevo.codigo); // LO MISMO PARA EL RESTO DE CAMPOS

    if (not existeProducto(archivo, reg_nuevo.codigo)) then begin
        leer (archivo, header);

        if (header.codigo = 0) then begin
            seek(archivo, filesize(archivo));
            write (archivo, reg_nuevo);
        end 
        else begin
            seek (archivo, (header.codigo)*-1);
            leer (archivo, header); // CABECERA NUEVA

            seek (archivo, filepos(archivo)-1);
            write (archivo, reg_nuevo); // REGISTRO NUEVO

            seek (archivo, 0);
            write (archivo, header); // ESCRIBO CABCERA NUEVA
        end;
    end
    else write('Este producto ya esta cargado.');

    close (archivo);
end;
    

procedure quitarProducto (var archivo: AR);
var
    reg, header: producto;
    codigo: integer;
begin
    reset (archivo);
    leer (archivo, header);

    write ('Ingrese codigo de producto a eliminar: '); readln(codigo);

    if (existeProducto(archivo, codigo)) then begin
        leer (archivo, reg);

        while (reg.codigo <> codigo) do
            leer (archivo, reg);
        
        seek (archivo, filepos(archivo)-1);
        write (archivo, header);  // CABECERA ANTERIOR EN EL LUGAR DEL REGISTRO A ELIMINAR

        header.codigo := (filepos(archivo)-1)*-1;  // CABECERA NUEVA CON DIRECCION DEL ELIMANDO *-1

        seek (archivo, 0);
        write (archivo, header); // CABCERA NUEVA
    end
    else write ('Producto no encontrado.');

    close (archivo);
end;


var 
    archivo: AR;
begin
    assign (archivo, 'archivo');
    agregarProducto (archivo);
    quitarProducto (archivo);
end.        
