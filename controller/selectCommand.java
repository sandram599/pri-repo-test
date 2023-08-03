package controller;

import java.awt.Color;
import java.awt.Graphics2D;

import model.Point;
import model.ShapeList;
import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.interfaces.IShapeObserver;
import model.interfaces.IUndoable;
import model.interfaces.Shape;
import model.persistence.ApplicationState;
import view.gui.PaintCanvas;

public class selectCommand implements ICommand, IShapeObserver {
	
	PaintCanvas paintCanvas;
	private Point startPoint, endPoint, xPoint, yPoint;
	private int height, width;
	private ShapeList shapeList;

	public selectCommand(Point startPoint, Point endPoint, PaintCanvas paintCanvas, ShapeList shapeList) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.paintCanvas = paintCanvas;
		this.shapeList = shapeList;
		
		xPoint = new Point(startPoint.getX(), endPoint.getX());
		yPoint =  new Point(startPoint.getY(), endPoint.getY());
		
		width = startPoint.getX() - endPoint.getX();
		height = startPoint.getY() - endPoint.getY();
	}


	@Override
	public void run() {
		//collision detection for bounding box		
		shapeList.selectedshapeList().clear();
		for(IShape shape : shapeList.getshapelist()) { 
			
			if(shape.getStartPoint().getX() < xPoint.getX() + width && 
			shape.getStartPoint().getX() + shape.getWidth() + shape.getWidth() 
			  > xPoint.getX() && shape.getStartPoint().getY() < yPoint.getY() 
			+ height && shape.getStartPoint().getY() + shape.getHeight() > 
			  yPoint.getY()) {
				
			shapeList.selectedshapeList().add(shape);	
			}
		}
			paintCanvas.repaint();
	}


	@Override
	public void update() {
		Graphics2D graphics2d = (Graphics2D) paintCanvas.getGraphics();
		graphics2d.setColor(Color.WHITE);
		graphics2d.fillRect(0, 0, paintCanvas.getWidth(), paintCanvas.getHeight());
		paintCanvas.repaint();	
	}
}
	
