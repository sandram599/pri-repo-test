package controller;

import java.util.ArrayList;

import model.Point;
import model.ShapesList;
import model.interfaces.IBB;
import model.interfaces.ICommand;
import model.interfaces.IShapeSubject;
import model.interfaces.IUndoable;
import view.gui.PaintCanvas;

public class moveCommand implements ICommand, IUndoable {

	private Point startPoint, endPoint;
	private PaintCanvas paintCanvas;
	ShapesList shapeList;
	int xDelta, yDelta;
	//CreateShape shape;
	private ArrayList<CreateShape> movedshapes; //the new shape
	private IBB b;
	
	public moveCommand(PaintCanvas paintCanvas, ShapesList shapeList) {
		this.paintCanvas = paintCanvas;	
		this.shapeList = shapeList;
		
		xDelta = b.grabEnd().getX() - b.grabStart().getX();
		yDelta = b.grabEnd().getY() - b.grabStart().getY();
	}

	@
	Override
	public void redo() {
		for(CreateShape movedshape : shapeList.getselectedshapes())
			movedshape.moved(xDelta, yDelta);
	}

	@Override
	public void undo() {
		for(CreateShape movedshape : shapeList.getselectedshapes())
			movedshape.moved(-xDelta, -yDelta);
	}

	@Override
	public void run() {
		for(CreateShape moveshape : shapeList.getselectedshapes()) {
			moveshape.moved(xDelta, yDelta);
			movedshapes.add(moveshape);
		}
		
	} 	

}
