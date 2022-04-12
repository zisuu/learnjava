package de.philipackermann.java.javafx.propertybinding;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class Main {
	public static void main(String[] args) {
		Raum wohnzimmer = new Raum();
		wohnzimmer.temperaturProperty().addListener(new ChangeListener() {
			@Override
			public void changed(ObservableValue o, Object alterWert, Object neuerWert) {
				System.out.println(String.format("Temperatur wurde von %.0f Grad auf %.0f Grad geändert.", alterWert, neuerWert));
			}
		});
		wohnzimmer.setTemperatur(25);
	}
}
