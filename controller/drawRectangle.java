package controller;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.util.ArrayList;

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


public class drawRectangle implements IShape { 
	
	private Point startPoint, endPoint;
	private int height, width, xDelta, yDelta;
	ShapeColor primary, secondary;
	private ShapeShadingType shade;
	private ShapeType shapetype;
	private shapeBuilder shapebuilder;
	private ApplicationState appState;
	PaintCanvas paintCanvas;
	private ShapeList shapeList;

	
	public drawRectangle (Point startPoint, Point endPoint, ShapeColor primary, ShapeColor secondary,
			ShapeShadingType shade, ShapeType shapetype, int height, int width) {

		this.startPoint = new Point(startPoint.x, startPoint.y);
		this.endPoint = new Point(endPoint.x, endPoint.y) ;
		this.primary = primary;
		this.secondary = secondary;
		this.shapetype = shapetype;
		this.shade = shade;
		this.height = height;
		this.width = width;		
	}
	
	@Override
	public void draw(Graphics2D g2d) { 
		
		switch(shade) {
		
		case FILLED_IN: 
			g2d.setColor(primary.grabColors());
			g2d.fillRect(startPoint.x, startPoint.y, width, height);
			break;
		case OUTLINE: 
			g2d.setColor(primary.grabColors());
			g2d.setStroke(new BasicStroke(5));
			g2d.drawRect(startPoint.x, startPoint.y, width, height);
			break;
		case OUTLINE_AND_FILLED_IN:
			g2d.setColor(primary.grabColors());
			g2d.fillRect(startPoint.x, startPoint.y, width, height);
			g2d.setStroke(new BasicStroke(5));
			g2d.setColor(secondary.grabColors());
			g2d.drawRect(startPoint.x, startPoint.y , width, height);
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
		startPoint.x = startPoint.x + xDelta;
		startPoint.y = startPoint.y + yDelta;		
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
		g.drawRect(startPoint.x - 6, startPoint.y - 6, width + 12, height + 12);
	}

	@Override
	public ArrayList<IShape> getChildren() {
		return null;
	}	
}
