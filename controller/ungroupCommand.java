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

public class ungroupCommand implements ICommand, IUndoable, IShapeObserver {

	private ArrayList<IShape> templist = new ArrayList<IShape>();
	private PaintCanvas paintCanvas;
	private ApplicationState appState;
	private ShapeList shapeList;
	private Point startPoint, endPoint;
	private group groupshape;
	
	public ungroupCommand(PaintCanvas paintCanvas, ApplicationState appState, ShapeList shapeList, Point startPoint, Point endPoint) {
		this.paintCanvas = paintCanvas;
		this.appState = appState;
		this.shapeList = shapeList;
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}

	@Override
	public void run() { //split the group into individual shapes
		for(IShape s : templist) {
		}
		shapeList.add(templist);
		shapeList.remove(groupshape);
		paintCanvas.repaint();
	}

	@Override
	public void redo() { //put back into group shape
		for(IShape s : templist) {
		}
		shapeList.remove(templist);
		shapeList.add(groupshape);
		paintCanvas.repaint();
	}

	@Override
	public void undo() { //split the shapes back up
		for(IShape s : templist) {
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
