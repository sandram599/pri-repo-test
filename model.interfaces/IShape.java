package model.interfaces;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import controller.shapeBuilder;
import model.Point;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.persistence.ApplicationState;
import model.ShapeList;

public interface IShape {
	
	int getX();
	int getY();
	int getHeight();
	int getWidth();
	Point getStartPoint();
	Point getEndPoint();
	ShapeColor getPrimary();
	ShapeColor getSecondary();
	ShapeType getShapeType();
	ShapeShadingType getShadeType();	
	void draw(Graphics2D g); 
	shapeBuilder getShapeBuilder();
	void move(int xDelta, int yDelta);
	ShapeList getshapeList();
	void outline(Graphics2D g);
	ArrayList<IShape> getChildren();
}
