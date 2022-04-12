package de.philipackermann.java.javafx.propertybinding;

import javafx.beans.binding.NumberBinding;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class UnidirectionalBinding {
	public static void main(String[] args) {
		Raum wohnzimmer = new Raum();
		Raum kueche = new Raum();
		kueche.setTemperatur(15.0);
		System.out.println(kueche.getTemperatur());
		kueche.temperaturProperty().bind(wohnzimmer.temperaturProperty());
//		kueche.setTemperatur(20.0); // nicht erlaubt
		wohnzimmer.setTemperatur(25.0);
		System.out.println(kueche.getTemperatur());
	}
}
