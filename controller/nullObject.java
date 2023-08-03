package controller;

import java.awt.Color;
import java.awt.Graphics2D;

import model.Point;
import model.ShapeColor;
import model.ShapeList;
import model.ShapeShadingType;
import model.ShapeType;
import model.interfaces.IShape;

public class nullObject implements IShape {

	@Override
	public int getX() {
		return 0;
	}

	@Override
	public int getY() {
		return 0;
	}

	@Override
	public int getHeight() {
		return 0;
	}

	@Override
	public int getWidth() {
		return 0;
	}

	@Override
	public Point getStartPoint() {
		return null;
	}

	@Override
	public Point getEndPoint() {
		return null;
	}

	@Override
	public ShapeColor getPrimary() {
		return ShapeColor.WHITE;
	}

	@Override
	public ShapeColor getSecondary() {
		return ShapeColor.WHITE;
	}

	@Override
	public ShapeType getShapeType() {
		return null;
	}

	@Override
	public ShapeShadingType getShadeType() {
		return null;
	}

	@Override
	public void draw(Graphics2D g) {
		System.out.println("unable to draw shape");
	}

	@Override
	public ShapeBuilder getShapeBuilder() {
		return null;
	}

	@Override
	public void move(int xDelta, int yDelta) {
		System.out.println("unable to move shape coordinates");
	}

	@Override
	public void shapeOutline(Graphics2D g) {
		System.out.println("unable to outline selected shape");
	}

	@Override
	public ShapeList getshapeList() {
		return null;
		
	} 
}
