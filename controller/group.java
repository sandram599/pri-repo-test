package controller;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.util.ArrayList;
import java.util.List;

import model.Point;
import model.ShapeColor;
import model.ShapeList;
import model.ShapeShadingType;
import model.ShapeType;
import model.interfaces.IShape;

public class group implements IShape {
	
	private ArrayList<IShape> children; //design pattern - folder pattern (5)
	private Point startPoint, endPoint;
	private ShapeColor primary, secondary;
	private ShapeType shapetype;
	private ShapeShadingType shade;
	private shapeBuilder shapebuilder;
	private ShapeList shapeList;
	private int height, width, x, y;
	
	public group(ArrayList<IShape> children, Point endPoint, Point startPoint) { 	//find math.min of x,y startpoint of children 
		this.children = children;
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}
	
	//public void addChild(IShape shape) { //part of folder pattern (5)
		//children.add(shape);
	//}
	
	@Override
	public int getX() {
		return startPoint.x;
	}

	@Override
	public int getY() {
		return startPoint.y;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public Point getStartPoint() {
		
		int minx = Integer.MAX_VALUE;
		int miny = Integer.MAX_VALUE;
		
		for(IShape s : children) {
					
		minx = Math.min(minx, s.getStartPoint().x);
		miny = Math.min(miny, s.getStartPoint().y);
			
		}
		return new Point(minx,miny);
	}

	@Override
	public Point getEndPoint() {
		
		int maxx = Integer.MIN_VALUE;
		int maxy = Integer.MIN_VALUE;
		
		for(IShape s : children) {
			
			maxx = Math.max(maxx, s.getEndPoint().x);
			maxy = Math.max(maxy, s.getEndPoint().y);
		}
		return new Point(maxx, maxy);
	}

	@Override
	public ShapeColor getPrimary() {
		return null;
	}

	@Override
	public ShapeColor getSecondary() {
		return secondary;
	}

	@Override
	public ShapeType getShapeType() {
		return shapetype;
	}

	@Override
	public ShapeShadingType getShadeType() {
		return shade;
	}

	@Override
	public void draw(Graphics2D g) {
		for(IShape s : children) {
			s.draw(g);
		}
	}

	@Override
	public shapeBuilder getShapeBuilder() {
		return shapebuilder;
	}

	@Override
	public void move(int xDelta, int yDelta) {
		for(IShape s : children) {
			s.move(xDelta, yDelta);
		}
	}

	@Override
	public ArrayList<IShape> getChildren() {	
		return children; 
	}

	@Override
	public void outline(Graphics2D g) {
		
		Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
		g.setStroke(stroke);
		g.setColor(Color.BLACK);
		g.drawRect(getStartPoint().x, getStartPoint().y, getWidth(), getHeight());
	}

	@Override
	public ShapeList getshapeList() {
		return null;
	}
}
