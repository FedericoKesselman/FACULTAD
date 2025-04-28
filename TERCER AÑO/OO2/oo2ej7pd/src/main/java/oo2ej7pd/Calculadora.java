package oo2ej7pd;
public class Calculadora {
    private double valorAcumulado;
    private StateCalculadora estado;

    public Calculadora() {
        this.valorAcumulado = 0;
        this.estado = new Inicial();
    }

    public void setValorAcumulado(double valorAcumulado) {
        this.valorAcumulado = valorAcumulado;
    }

    public double getValorAcumulado() {
        return this.valorAcumulado;
    }

    public void setEstado(StateCalculadora estado) {
        this.estado = estado;
    }

    private void reiniciarCalculadora() {
		this.valorAcumulado = 0;
		this.estado = new Inicial();
	}

    public String getResultado() {
        return this.estado.getResultado(this);
    }

    public void borrar() {
        this.reiniciarCalculadora();
    }

    public void mas() {
        this.estado.mas(this);
    }

    public void menos() {
        this.estado.menos(this);
    }
}
