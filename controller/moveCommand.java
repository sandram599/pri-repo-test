package controller;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import model.Point;
import model.ShapeList;
import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.interfaces.IShapeObserver;
import model.interfaces.IShapeSubject;
import model.interfaces.IUndoable;
import model.interfaces.Shape;
import model.persistence.ApplicationState;
import view.gui.PaintCanvas;

public class moveCommand implements ICommand, IUndoable, IShapeObserver {

	private Point startPoint, endPoint;
	private ApplicationState appState;
	private PaintCanvas paintCanvas;
	private ShapeList shapeList;
	private int xDelta, yDelta;
	private IShape shape;
	private ArrayList<IShape> tempshapelist;
	
	
	public moveCommand(Point startPoint, Point endPoint, PaintCanvas paintCanvas, ShapeList shapeList) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.paintCanvas = paintCanvas;
		this.shapeList = shapeList;
		
		xDelta = endPoint.getX() - startPoint.getX();
		yDelta = endPoint.getY() - startPoint.getY();

		//instantiating the shapelist here
		tempshapelist = new ArrayList<IShape>();
	}
	
	@Override
	public void redo() {
		for(IShape shape : tempshapelist) {
			shape.move(xDelta, yDelta);
		}
		paintCanvas.repaint();
	}
	
	@Override
	public void undo() {
		for(IShape shape : tempshapelist) {
			shape.move(-xDelta, -yDelta);
		}
		paintCanvas.repaint();
	}

	@Override
	public void run() {		
		CommandHistory.add(this); 
		for(IShape shape : shapeList.selectedshapeList()) { 
			tempshapelist.add(shape); //nothing is being added here yet
			shape.move(xDelta, yDelta);
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

