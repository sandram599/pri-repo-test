package controller;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import model.Point;
import model.ShapeShadingType;
import model.interfaces.IShapeDraw;
import view.gui.PaintCanvas;

public class drawEllipse implements IShapeDraw { //interface to draw the shapes
	
	private Point startPoint, endPoint;
	int shapeX1, shapeY1, shapeX2, shapeY2;;
	public int startX, startY;
	private PaintCanvas paintCanvas;
	private int height, width;
	private Color primary, secondary;
	private ShapeShadingType shapeshadingtype;
	//int x,y;
	
	
	public drawEllipse(Point startPoint, Point endPoint, PaintCanvas paintCanvas, Color primary, Color secondary, ShapeShadingType shapeshadingtype) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.paintCanvas = paintCanvas;
		this.primary = primary;
		this.secondary = secondary;
		this.shapeshadingtype = shapeshadingtype;
		
		shapeX1 = Math.min(startPoint.getX(), endPoint.getX()); 
		shapeX2 = Math.max(startPoint.getX(), endPoint.getX()); 
        shapeY1 = Math.min(startPoint.getY(), endPoint.getY()); 
        shapeY2 = Math.max(startPoint.getY(), endPoint.getY());
        
        width = (shapeX2 - shapeX1);
        height = (shapeY2 - shapeY1);
}

	@Override
	public void designShape(CreateShape shape) {
		Graphics2D g2d = (Graphics2D) paintCanvas.getGraphics();

		switch(shape.getShapeshadingtype()) {
		
		case FILLED_IN://only the inside of the shape, primary
			g2d.setColor(primary);
			g2d.fillOval(shapeX1, shapeY1, width, height);
			break;
		case OUTLINE: //only shape outline, primary
			g2d.setColor(primary);
			g2d.setStroke(new BasicStroke(5));
			g2d.fillOval(shapeX1, shapeY1, width, height);
			break;
		case OUTLINE_AND_FILLED_IN: //both inside and outside line, primary and secondary
			g2d.setColor(primary);
			g2d.fillOval(shapeX1, shapeY1, width, height);
			g2d.setStroke(new BasicStroke(5));
			g2d.setColor(secondary);
			g2d.drawOval(shapeX1, shapeY1, width, height);
			break;
		
		}
		
	}
}

