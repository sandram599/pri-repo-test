package controller;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import model.Point;
import model.ShapeList;
import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.interfaces.IShapeObserver;
import model.interfaces.IUndoable;
import model.persistence.ApplicationState;
import view.gui.PaintCanvas;

public class deleteCommand implements ICommand, IUndoable, IShapeObserver {

	PaintCanvas paintCanvas;
	private ApplicationState appState;
	private ArrayList<IShape> tempshapelist;
	private Point startPoint, endPoint;
	private ShapeList shapeList;

	
	public deleteCommand(PaintCanvas paintCanvas, ShapeList shapeList, Point startPoint, Point endPoint, ApplicationState appState) {
		this.paintCanvas = paintCanvas;
		this.shapeList = shapeList;
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.appState = appState;
	
		tempshapelist = new ArrayList<IShape>();
	}

	@Override
	public void redo() { 
		for(IShape shape : tempshapelist) {
				shapeList.remove(shape);
				paintCanvas.repaint();
			}
		}

	@Override
	public void undo() { 
		for(IShape shape : tempshapelist) {
			shapeList.add(shape);
			paintCanvas.repaint();
		}
	}

	@Override
	public void run() {
		CommandHistory.add(this);
		for(IShape shape : shapeList.selectedshapeList()) { 
			tempshapelist.add(shape);
			shapeList.remove(shape);
		}
		shapeList.selectedshapeList().clear();			
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
