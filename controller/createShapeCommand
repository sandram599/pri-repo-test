package controller;

import java.util.ArrayList;
import model.pointClass;
import model.interfaces.IApplicationState;
import view.gui.PaintCanvas;

public class createShapeCommand implements IJCommand, IUndoable {
	
	private PaintCanvas paintCanvas;
	private pointClass startPoint;
	private pointClass endPoint;
	private IApplicationState appState;
	ArrayList<IShape> shapelist = new ArrayList<IShape>();
	private IShape shape;
	
	
	public createShapeCommand(pointClass startPoint, pointClass endPoint, PaintCanvas paintCanvas, IApplicationState appState) {
		this.paintCanvas = paintCanvas;
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.appState = appState;
	}

	@Override
	public void execute() {
		CommandHistory.add(this);
		shape = new IShape(startPoint, endPoint);
		shapelist.add(shape);
	}

	@Override
	public void redo() {
		shapelist.add(shape);

	}

	@Override
	public void undo() {
		shapelist.remove(shape);
		
	}
}
