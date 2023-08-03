package controller;

import java.awt.Color;

import model.Point;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.interfaces.IShape;
import model.interfaces.Shape;
import model.persistence.ApplicationState;
import view.gui.PaintCanvas;

//build shapes by using the builder pattern 

public class ShapeBuilder { 
	
	private Point startPoint, endPoint;
	private int height, width;
	private ShapeColor primary, secondary;
	private ShapeType shapetype;
	private nullObject shapetype1;
	private ShapeShadingType shade;
	private IShape shape;
	
	public ShapeShadingType getShadingType(ShapeShadingType shade) {
		return this.shade = shade;
	}
	
	public Point Start(Point startPoint) {
		 return this.startPoint = startPoint;
	}
	
	public Point End(Point endPoint) {
		return this.endPoint = endPoint;
	}
	
	public int getHeight() {
		return this.height = endPoint.getY() - startPoint.getY();
		
	}
	
	public int getWidth() {
		return this.width = endPoint.getX() - startPoint.getX();
	}
	
	public ShapeColor primary(ShapeColor shapeColor) {
		return this.primary = shapeColor;
	}
	
	public ShapeColor secondary(ShapeColor secondary) {
		 return this.secondary = secondary;
	}
	
	public ShapeType getShapeType (ShapeType shapetype) {
		return this.shapetype = shapetype;
	}
	public IShape toBuild() {  
			
		switch(shapetype) { 

		case ELLIPSE: 
			return new drawEllipse(startPoint, endPoint, primary, secondary, shade, shapetype, getHeight(), getWidth());
		case RECTANGLE:
			return new drawRectangle(startPoint, endPoint, primary, secondary, shade, shapetype, getHeight(), getWidth());
		case TRIANGLE:
			return new drawTriangle(startPoint, endPoint, primary, secondary, shade, shapetype, getHeight(), getWidth());
		default:
			shapetype1 = new nullObject();				
		}
		return shape;
	}
}
