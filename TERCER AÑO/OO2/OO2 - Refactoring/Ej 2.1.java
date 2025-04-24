public class Empleado{ 
    private String nombre;
    private String apellido;
    private double sueldoBasico = 0;

    public double sueldo() {
        return this.sueldoBasico - (this.sueldoBasico * 0.13);
    }
}

public class EmpleadoPlanta extends Empleado{
    private int cantidadHijos = 0;

    public double sueldo() {
        return super.sueldo() + (this.cantidadHijos * 2000);
    }   
}

public class EmpleadoTemporal extends Empleado{
    private int cantidadHijos = 0;
    private double horasTrabajadas = 0;

    public double sueldo() {
        return super.sueldo() + (this.horasTrabajadas * 500) + (this.cantidadHijos * 1000);
    }   
}