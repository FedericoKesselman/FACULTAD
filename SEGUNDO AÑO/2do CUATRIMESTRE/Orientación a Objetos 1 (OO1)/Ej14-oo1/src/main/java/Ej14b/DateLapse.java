package Ej14b;
import java.time.LocalDate;

import io.github.unlp_oo.Ej14_oo1.Date;

public class DateLapse implements Date{
	private LocalDate from;
	private int sizeInDays;
	
	
	public DateLapse(LocalDate desde, int cant) {
		this.from = desde;
		this.sizeInDays = cant;
	}
	
	
	public DateLapse(LocalDate desde, LocalDate hasta) {
        this.from = desde;
        this.sizeInDays = (int) desde.until(hasta, java.time.temporal.ChronoUnit.DAYS);
    }
	
	
	public LocalDate getFrom() {
		return this.from;
	}
	
	public LocalDate getTo() {
		// PlusDays suma un int a una fecha.
		return this.from.plusDays(this.sizeInDays);
	}
	
	public int sizeInDays() {
		return this.sizeInDays;
	}
	
	
	public boolean includesDate(LocalDate other) {
		//Reemplazo la variable TO por el metodo getTo.
		
		return (other.equals(this.from) || other.equals(this.getTo()) || 
				(other.isBefore(this.getTo()) && other.isAfter(this.from)) );
	}
	
	
	public boolean overlaps(DateLapse other) {
        return this.getFrom().isBefore(other.getTo()) && this.getTo().isAfter(other.getFrom());
    }
}
