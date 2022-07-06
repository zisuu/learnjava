package app.Kap16;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Raum {
	private DoubleProperty temperatur;
	
	public double getTemperatur() {
		return this.temperaturProperty().get();
	}
	
	public void setTemperatur(double temperatur) {
		this.temperaturProperty().set(temperatur);
	}
	
	public DoubleProperty temperaturProperty() {
		if (this.temperatur == null) { 
			this.temperatur = new SimpleDoubleProperty(20); 
        } 
		return this.temperatur;
	}

}