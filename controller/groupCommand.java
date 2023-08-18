package controller;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import model.Point;
import model.ShapeList;
import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.interfaces.IShapeObserver;
import model.interfaces.IUndoable;
import model.persistence.ApplicationState;
import view.gui.PaintCanvas;

public class groupCommand implements ICommand, IUndoable, IShapeObserver {
	
	private ArrayList<IShape> templist = new ArrayList<IShape>();
	private ApplicationState appState;
	private PaintCanvas paintCanvas;
	private ShapeList shapeList;
	private ShapeList selectedshapeList;
	private group groupshape; //this is the groupshape
	private Point startPoint, endPoint;
	private int x, y;
	
	public groupCommand(ApplicationState appState, PaintCanvas paintCanvas, ShapeList shapeList, Point startPoint, Point endPoint) {
		this.appState = appState;
		this.paintCanvas = paintCanvas;
		this.shapeList = shapeList;
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}
	
	@Override
	public void run() {
		CommandHistory.add(this);
		for(IShape shape : shapeList.selectedshapeList()) { //dont necessarily need the for loop
			templist.add(shape); //getting selected shapes
			shapeList.remove(templist); //getting the shapes removed from the list
		}
		groupshape = new group(templist, startPoint, endPoint); //creating new group with selected shapes
		shapeList.add(groupshape); //adding the grouped shapes into a list
		paintCanvas.repaint();
	}

	@Override
	public void redo() {
		for(IShape shape : templist) {			
		}
		shapeList.remove(templist);
		shapeList.add(groupshape);
		paintCanvas.repaint();
	}

	@Override
	public void undo() {
		for(IShape shape : templist) {
		}
		shapeList.add(templist);
		shapeList.remove(groupshape);
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
