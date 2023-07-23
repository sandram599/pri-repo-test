package controller;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import model.Point;
import model.ShapeShadingType;
import model.interfaces.IShapeDraw;
import view.gui.PaintCanvas;

public class drawTriangle implements IShapeDraw {
	
	private PaintCanvas paintCanvas;
	private int[] xPoints = new int[3]; //new coordinates
	private int[] yPoints = new int[3]; //new coordinates
	private Point startPoint, endPoint;
	private Color primary, secondary;
	public ShapeShadingType shapeshadingtype;
	int x,y;
	
	public drawTriangle(Point startPoint, Point endPoint,PaintCanvas paintCanvas, Color primary, Color secondary, ShapeShadingType shapeshadingtype) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.paintCanvas = paintCanvas;
		this.primary = primary;
		this.secondary = secondary;
		this.shapeshadingtype = shapeshadingtype;
		
		//new x coordinates
		xPoints[0] = startPoint.getX();
		xPoints[1] = startPoint.getX();
		xPoints[2] = endPoint.getX();
		
		//new y coordinates
		yPoints[0] = startPoint.getY();
		yPoints[1] = endPoint.getY();
		yPoints[2] = endPoint.getY();
	}
	
	public void designShape(CreateShape shape) {
		
		Graphics2D g2d = (Graphics2D) paintCanvas.getGraphics();
		
		switch(shape.getShapeshadingtype()) {
		
		case FILLED_IN: 
			g2d.setColor(primary);
			g2d.fillPolygon(xPoints, yPoints, 3);
			break;
		case OUTLINE: 
			g2d.setColor(primary);
			g2d.setStroke(new BasicStroke(5));
			g2d.drawPolygon(xPoints, yPoints, 3);
			break;
		case OUTLINE_AND_FILLED_IN: 
			g2d.setColor(primary);
			g2d.setStroke(new BasicStroke(5));
			g2d.fillPolygon(xPoints, yPoints, 3);
			g2d.setColor(secondary);
			g2d.drawPolygon(xPoints, yPoints, 3);
			break;
		}
	}
}
