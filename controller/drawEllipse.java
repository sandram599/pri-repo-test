package controller;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;

import model.MouseMode;
import model.Point;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.ShapeList;
import model.interfaces.IShape;
import model.interfaces.Shape;
import model.persistence.ApplicationState;
import view.gui.PaintCanvas;

public class drawEllipse implements IShape { 
	
	private int X1, Y1, X2, Y2;
	private Point startX, startY;
	ShapeColor primary, secondary;
	private Point startPoint, endPoint;
	private int height, width, x, y;
	private ShapeShadingType shade;
	private ShapeType shapetype;
	private ShapeBuilder shapebuilder;
	private ApplicationState appState;
	PaintCanvas paintCanvas;
	private int updateX, updateY;
	private Point xPoint, yPoint;
	private ShapeList shapeList;
	
	
	public drawEllipse(Point startPoint, Point endPoint, ShapeColor primary, ShapeColor secondary,
			ShapeShadingType shade, ShapeType shapetype, int height, int width) {
		
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.primary = primary;
		this.secondary = secondary;
		this.shade = shade;
		this.shapetype = shapetype;
		this.height = height;
		this.width = width;
		
	X1 = Math.min(startPoint.getX(), endPoint.getX()); 
	X2 = Math.max(startPoint.getX(), endPoint.getX()); 
        Y1 = Math.min(startPoint.getY(), endPoint.getY()); 
        Y2 = Math.max(startPoint.getY(), endPoint.getY());
        
        width = (X2 - X1);
        height = (Y2 - Y1);
	
}

	public void draw(Graphics2D g2d) {
		
		switch(shade) { 
		
		case FILLED_IN:
			g2d.setColor(primary.grabColors());
			g2d.fillOval(X1, Y1, width, height);
			break;
		case OUTLINE: 
			g2d.setColor(primary.grabColors());
			g2d.setStroke(new BasicStroke(5));
			g2d.fillOval(X1,Y1, width, height);
			break;
		case OUTLINE_AND_FILLED_IN:
			g2d.setColor(primary.grabColors());
			g2d.fillOval(X1, Y1, width, height);
			g2d.setStroke(new BasicStroke(5));
			g2d.setColor(secondary.grabColors());
			g2d.drawOval(X1, Y1, width, height);
			break;		
		}		
	}

	@Override
	public ShapeBuilder getShapeBuilder() {
		return shapebuilder;
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
		return height;
	}

	@Override
	public int getWidth() {
		return width;
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
		X1 = X1 + xDelta;
		Y1 = Y1 + yDelta;
	}

	@Override
	public ShapeList getshapeList() {
		return shapeList;
	}

	@Override
	public void outline(Graphics2D g) {
		Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
		g.setStroke(stroke);
		g.setColor(Color.BLACK);
		g.drawOval(X1 + 1, Y1 + 1, width, height);

	}
}

