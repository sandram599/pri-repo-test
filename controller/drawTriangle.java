package controller;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.util.ArrayList;

import model.Point;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.ShapeList;
import model.interfaces.IShape;
import model.interfaces.Shape;
import model.persistence.ApplicationState;
import view.gui.PaintCanvas;

public class drawTriangle implements IShape {
	
	private shapeBuilder shapebuilder;
	private ApplicationState appState;
	PaintCanvas paintCanvas;
	private int[] xPoints = new int[3]; //new coordinates
	private int[] yPoints = new int[3]; //new coordinates
	private Point startPoint, endPoint;
	ShapeColor primary, secondary;
	public ShapeShadingType shade;
	private ShapeType shapetype;
	private int height, width;
	private Point xPoint, yPoint;
	private ShapeList shapeList;	
	
	public drawTriangle(Point startPoint, Point endPoint, ShapeColor primary, ShapeColor secondary,
			ShapeShadingType shade, ShapeType shapetype, int height, int width) {
		
		this.startPoint = new Point(startPoint.x, startPoint.y);
		this.endPoint = new Point(endPoint.x, endPoint.y);
		this.primary = primary;
		this.secondary = secondary;
		this.shapetype = shapetype;
		this.shade = shade;
		this.height = height;
		this.width = width;
		
		//x coordinates		
		xPoints[0] = startPoint.x;
		xPoints[1] = startPoint.x;
		xPoints[2] = endPoint.x;
	
		//y coordinates
		yPoints[0] = startPoint.y;
		yPoints[1] = endPoint.y;
		yPoints[2] = endPoint.y;
		
	}
	
	public void draw(Graphics2D g2d) {
				
		switch(shade) {
		
		case FILLED_IN: 
			g2d.setColor(primary.grabColors());
			g2d.fillPolygon(xPoints, yPoints, 3);
			break;
		case OUTLINE: 
			g2d.setColor(primary.grabColors());
			g2d.setStroke(new BasicStroke(5));
			g2d.drawPolygon(xPoints, yPoints, 3);
			break;
		case OUTLINE_AND_FILLED_IN: 
			g2d.setColor(primary.grabColors());
			g2d.setStroke(new BasicStroke(5));
			g2d.fillPolygon(xPoints, yPoints, 3);
			g2d.setColor(secondary.grabColors());
			g2d.drawPolygon(xPoints, yPoints, 3);
			break;
		}
	}

	@Override
	public shapeBuilder getShapeBuilder() { 
		return shapebuilder;
	}

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
		return height;
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

	@Override
	public ShapeType getShapeType() {
		return shapetype;
	}

	@Override
	public ShapeShadingType getShadeType() {
		return shade;
	}
	
	@Override
	public void move(int xDelta, int yDelta) {
		
		//new x coordinates
		xPoints[0] = xPoints[0] + xDelta;
		xPoints[1] = xPoints[1] + xDelta;
		xPoints[2] = xPoints[2] + xDelta;
		
		//new y coordinates
		yPoints[0] = yPoints[0] + yDelta;
		yPoints[1] = yPoints[1] + yDelta;
		yPoints[2] = yPoints[2] + yDelta;
		
	}

	@Override
	public ShapeList getshapeList() {
		return shapeList;
	}

	@Override
	public void outline(Graphics2D g) {
		
		//outline x coordinates
		xPoints[0] = xPoints[0] - 8;
		xPoints[1] = xPoints[1] - 8;
		xPoints[2] = xPoints[2] + 15;
		
		//outline y coordinates
		yPoints[0] = yPoints[0] - 15;
		yPoints[1] = yPoints[1] + 8;
		yPoints[2] = yPoints[2] + 8;
		
		Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
		g.setStroke(stroke);
		g.setColor(Color.BLACK);
		g.drawPolygon(xPoints , yPoints, 3);	
	}

	@Override
	public ArrayList<IShape> getChildren() {
		return null;
	}
}
