package controller;

import java.awt.Color;

import model.Point;
import model.ShapeShadingType;
import model.ShapeType;
import model.persistence.ApplicationState;
import view.gui.PaintCanvas;

//build shapes by using the builder pattern

public class buildShape { 
	
	private Point startPoint, endPoint;
	private ShapeType shapetype;
	private ShapeShadingType shapeshadingtype;
	private Color primaryC, secondaryC;
	private PaintCanvas paintCanvas;
	private ApplicationState appState;
	
	
	public buildShape shapetype(ShapeType shapetype) {
		this.shapetype = shapetype;
		return this;
	}
	
	public buildShape shapeshadingtype(ShapeShadingType shapeshadingtype) {
		this.shapeshadingtype = shapeshadingtype;
		return this;
	}
	
	public buildShape primaryC(Color primaryC) {
		this.primaryC = primaryC;
		return this;
	}
	
	public buildShape secondaryC(Color secondaryC) {
		this.secondaryC = secondaryC;
		return this;
	}
	
	public buildShape startPoint(Point startPoint) {
		this.startPoint = startPoint;
		return this;
	}
	
	public buildShape endPoint(Point endPoint) {
		this.endPoint = endPoint;
		return this;
	}
	
	
	public CreateShape toBuild() {
		return new CreateShape (startPoint, endPoint, paintCanvas, appState, shapetype, primaryC, shapeshadingtype, secondaryC);
	}
}
