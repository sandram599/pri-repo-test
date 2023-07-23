package controller;

import model.Point;
import model.ShapesList;
import model.interfaces.ICommand;
import model.interfaces.IUndoable;
import model.persistence.ApplicationState;
import view.gui.PaintCanvas;

public class selectCommand implements ICommand {
	
	CreateShape shape, selectedShape;
	private PaintCanvas paintCanvas;
	private ShapesList shapeList;
	static boolean ifSelected = false;
	Point startPoint, endPoint;
	
	
	public selectCommand(ShapesList shapeList, PaintCanvas paintCanvas) {
		this.shapeList = shapeList;
		this.paintCanvas = paintCanvas;
	}

	@Override
	public void run() {
		for(CreateShape shape : shapeList.getshapelist()) {
		if(shape.isIn(shape.grabStart())) { 
			ifSelected = true; selectedShape = shape;
			shapeList.addSelectShape(selectedShape);
			}
		}	
	}
}
