package model.interfaces;

import java.awt.Color;
import java.awt.Graphics2D;

import controller.ShapeBuilder;
import model.Point;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.ShapeList;

public class Shape implements IShape {
	
	private Point startPoint, endPoint;
	ShapeColor primary;
	private ShapeColor secondary;
	private int x, y, width, height;
	private ShapeShadingType shade;
	private ShapeType shapetype;
	private ShapeList shapeList;

	public Shape(Point startPoint, Point endPoint, ShapeColor primary2, ShapeColor secondary2, ShapeShadingType shade, ShapeType shapetype, int height, int width) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.primary = primary2;
		this.secondary = secondary2;
		this.height = height;
		this.width = width;
		this.shade = shade;
		this.shapetype = shapetype;	
		this.x = startPoint.x;
		this.y = startPoint.y;
	}
	

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public int getHeight() {
		return endPoint.getX() - startPoint.getX();
	}

	@Override
	public int getWidth() {
		return endPoint.getY() - startPoint.getY();
	}

	@Override
	public Point getStartPoint() {
		return startPoint;
	}

	@Override
	public Point getEndPoint() {
		return endPoint;
	}

	@Override
	public ShapeColor getPrimary() {
		return primary;
	}

	@Override
	public ShapeColor getSecondary() {
		return secondary;
	}

	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		//NEXT THING TO DO
		
	}

	@Override
	public ShapeType getShapeType() {
		return shapetype;
	}

	@Override
	public ShapeShadingType getShadeType() {
		return shade;
	}


	public boolean isIn(Point startPoint) {
		return false;
	}


	public void moved(int xDelta, int yDelta) {
		// TODO Auto-generated method stub
		
		
	}


	@Override
	public ShapeBuilder getShapeBuilder() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void move(int xDelta, int yDelta) {
		// TODO Auto-generated method stub

	}



	@Override
	public void shapeOutline(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public ShapeList getshapeList() {
		return shapeList;
		
	}
}
