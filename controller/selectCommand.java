package controller;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import model.MouseMode;
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
	private ApplicationState appState;
	
	public selectCommand(Point startPoint, Point endPoint, PaintCanvas paintCanvas, ShapeList shapeList, ApplicationState appState) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.paintCanvas = paintCanvas;
		this.shapeList = shapeList;
		this.appState = appState;
		
		xPoint = new Point(startPoint.x, endPoint.x);
		yPoint =  new Point(startPoint.y, endPoint.y);
		
		//width = startPoint.x - endPoint.x;
		//height = startPoint.y - endPoint.y;
	}

	@Override
	public void run() {
		//collision detection 
		shapeList.selectedshapeList().clear();

		for(IShape shape : shapeList.getshapelist()) { 

			if(shape.getStartPoint().getX() < xPoint.getX() + width && 
					shape.getStartPoint().getX() + shape.getWidth() //fix
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
	