package de.philipackermann.java.javafx.urlaub002;

import java.time.LocalDate;

public class Urlaubsantrag {
	private String vorname;
	private String nachname;
	private LocalDate datumUrlaubsBeginn;
	private LocalDate datumUrlaubsEnde;
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	public LocalDate getDatumUrlaubsBeginn() {
		return datumUrlaubsBeginn;
	}
	public void setDatumUrlaubsBeginn(LocalDate datumUrlaubsBeginn) {
		this.datumUrlaubsBeginn = datumUrlaubsBeginn;
	}
	public LocalDate getDatumUrlaubsEnde() {
		return datumUrlaubsEnde;
	}
	public void setDatumUrlaubsEnde(LocalDate datumUrlaubsEnde) {
		this.datumUrlaubsEnde = datumUrlaubsEnde;
	}
	
}
