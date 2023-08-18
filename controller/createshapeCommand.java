package controller;

import model.ShapeList;
import model.Point;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.interfaces.IShapeObserver;
import model.interfaces.IUndoable;
import model.interfaces.Shape;
import model.persistence.ApplicationState;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import view.gui.PaintCanvas;


public class createshapeCommand implements ICommand, IUndoable, IShapeObserver { 
	
	Point startPoint, endPoint;
	PaintCanvas paintCanvas;
	private ApplicationState appState;
	private ShapeType shapetype;
	private ShapeShadingType shade;
	private Color primary, secondary;
	private int width, height;
	private IShape shape;
	private shapeBuilder shapebuilder;
	private ShapeList shapeList;

	
	 public createshapeCommand(ApplicationState appState, PaintCanvas paintCanvas, ShapeList shapeList, shapeBuilder shapebuilder) {
		this.appState = appState;
		this.paintCanvas = paintCanvas;
		this.shapeList = shapeList;
		this.shapebuilder = shapebuilder;
		
	 }
	 
	@Override
	public void run() {  
		CommandHistory.add(this);
		shape = shapebuilder.toBuild();	//part of builder pattern design 
		shapeList.add(shape);
	}

	@Override
	public void redo() {
		shapeList.add(shape);
		paintCanvas.repaint();
	}

	@Override
	public void undo() {
		shapeList.remove(shape);	
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
