package dad.javafx.ventanaconmemoria.mvc;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class VentanaModel {
	
private IntegerProperty red= new SimpleIntegerProperty();
private IntegerProperty green= new SimpleIntegerProperty();
private IntegerProperty blue= new SimpleIntegerProperty();

private DoubleProperty height= new SimpleDoubleProperty();
private DoubleProperty width= new SimpleDoubleProperty();
private DoubleProperty coordX= new SimpleDoubleProperty();
private DoubleProperty coordY= new SimpleDoubleProperty();


public final IntegerProperty redProperty() {
	return this.red;
}

public final int getRed() {
	return this.redProperty().get();
}

public final void setRed(final int red) {
	this.redProperty().set(red);
}

public final IntegerProperty greenProperty() {
	return this.green;
}

public final int getGreen() {
	return this.greenProperty().get();
}

public final void setGreen(final int green) {
	this.greenProperty().set(green);
}

public final IntegerProperty blueProperty() {
	return this.blue;
}

public final int getBlue() {
	return this.blueProperty().get();
}

public final void setBlue(final int blue) {
	this.blueProperty().set(blue);
}

public final DoubleProperty heightProperty() {
	return this.height;
}

public final double getHeight() {
	return this.heightProperty().get();
}

public final void setHeight(final double height) {
	this.heightProperty().set(height);
}

public final DoubleProperty widthProperty() {
	return this.width;
}

public final double getWidth() {
	return this.widthProperty().get();
}

public final void setWidth(final double width) {
	this.widthProperty().set(width);
}

public final DoubleProperty coordXProperty() {
	return this.coordX;
}

public final double getCoordX() {
	return this.coordXProperty().get();
}

public final void setCoordX(final double coordX) {
	this.coordXProperty().set(coordX);
}

public final DoubleProperty coordYProperty() {
	return this.coordY;
}

public final double getCoordY() {
	return this.coordYProperty().get();
}

public final void setCoordY(final double coordY) {
	this.coordYProperty().set(coordY);
}



















}
