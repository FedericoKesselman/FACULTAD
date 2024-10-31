package io.github.unlp_oo.EJ15_OO1;

import java.time.LocalDate;

public class Factura {
	private Persona usuario;
	private LocalDate fechaEmision;
	private double bonificacion;
	private double monto;
	
	
	public Factura(Persona usuario, double bonificacion, double monto) {
		this.usuario = usuario;
		this.bonificacion = bonificacion;
		this.monto = monto;
		this.fechaEmision = LocalDate.now();
	}
	
	public Persona getUsuario() {
        return usuario;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public boolean isBonificacion() {
        return bonificacion > 0;
    }

    public double getMonto() {
        return monto;
    }	
}
