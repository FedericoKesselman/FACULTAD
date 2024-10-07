package io.github.unlp_oo.Ej14_oo1;
import java.time.LocalDate;

public interface Date {
	public LocalDate getFrom();
	public LocalDate getTo();
	public int sizeInDays();
	public boolean includesDate(LocalDate other);
}
