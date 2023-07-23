package controller;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import model.Point;
import model.ShapeShadingType;
import model.interfaces.IShapeDraw;
import view.gui.PaintCanvas;

public class drawRectangle implements IShapeDraw { //interface for shapes
	
	private Point startPoint, endPoint;
	private int height, width;
	private PaintCanvas paintCanvas;
	private Color primary, secondary;
	private ShapeShadingType shapeshadingtype;
	//int x,y;

	
	public drawRectangle(PaintCanvas paintCanvas, Point startPoint, Point endPoint, Color primary, Color secondary, ShapeShadingType shapeshadingtype) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.paintCanvas = paintCanvas;		
		this.primary = primary;
		this.secondary = secondary;
		this.shapeshadingtype = shapeshadingtype;
		width = endPoint.getX() - startPoint.getX();
		height = endPoint.getY() - startPoint.getY();
		
	}

	public void designShape(CreateShape shape) { 

		Graphics2D g2d = (Graphics2D) paintCanvas.getGraphics();
		
		switch(shape.getShapeshadingtype()) {
		
		case FILLED_IN: 
			g2d.setColor(primary);
			g2d.fillRect(startPoint.getX(), startPoint.getY(), width, height);
			break;
		case OUTLINE: 
			g2d.setColor(primary);
			g2d.setStroke(new BasicStroke(5));
			g2d.drawRect(startPoint.getX(), startPoint.getY(), width, height);
			break;
		case OUTLINE_AND_FILLED_IN:
			g2d.setColor(primary);
			g2d.fillRect(startPoint.getX(), startPoint.getY(), width, height);
			g2d.setStroke(new BasicStroke(5));
			g2d.setColor(secondary);
			g2d.drawRect(startPoint.getX(), startPoint.getY(), width, height);
			break;	
		}
		
	}

}



//g2d.setColor(primary);
//g2d.fillRect(startPoint.getX(), startPoint.getY(), height, width);
//g2d.drawRect(startPoint.getX(), startPoint.getY(), height, width);		
//switch statement for various shades/colors

