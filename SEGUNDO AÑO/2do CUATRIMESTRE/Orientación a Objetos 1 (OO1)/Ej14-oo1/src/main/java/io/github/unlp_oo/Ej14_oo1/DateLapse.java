package io.github.unlp_oo.Ej14_oo1;
import java.time.LocalDate;

public class DateLapse implements Date{
	private LocalDate from;
	private LocalDate to;
	
	public DateLapse(LocalDate from, LocalDate to) {
		this.from = from;
		this.to = to;
	}
	
	public LocalDate getFrom() {
		return this.from;
	}
	
	public LocalDate getTo() {
		return this.to;
	}
	
	public int sizeInDays() {
		return this.from.until(to).getDays();
	}
	
	public boolean includesDate(LocalDate other) {
		return (other.equals(this.from) || other.equals(this.to) || (other.isAfter(this.from) && other.isBefore(this.to)) );
	}
}
