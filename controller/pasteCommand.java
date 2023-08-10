package controller;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import model.Point;
import model.ShapeColor;
import model.ShapeList;
import model.ShapeShadingType;
import model.ShapeType;
import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.interfaces.IShapeObserver;
import model.interfaces.IUndoable;
import model.interfaces.Shape;
import model.persistence.ApplicationState;
import view.gui.PaintCanvas;

public class pasteCommand implements ICommand, IUndoable, IShapeObserver, Cloneable { //attempting a deep copy

	PaintCanvas paintCanvas;
	private ShapeList shapeList;
	private ApplicationState appState;
	private ArrayList<IShape> templist = new ArrayList<IShape>();
	private int offset = 30;
	private IShape shape;
	private Point startPoint, endPoint;
	private ShapeColor primary;
	private ShapeColor secondary;
	private ShapeType shapeType;
	private ShapeShadingType shadeType;
	private int height;
	private int width;
	private IShape shapeCopy;

	
	public pasteCommand(PaintCanvas paintCanvas, ApplicationState appState, ShapeList shapeList, Point startPoint, Point endPoint) {
		this.paintCanvas = paintCanvas;
		this.appState = appState;
		this.shapeList = shapeList;
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}


	@Override
	public void redo() {
		for(IShape shape : templist) {
			shapeList.add(shape);
		}
		paintCanvas.repaint();
	}

	@Override
	public void undo() { 
		for(IShape shape : templist) {
			shapeList.remove(shape);
		}
		paintCanvas.repaint();
	}

	
	@Override 
	public void run() {  				
		CommandHistory.add(this); 
		for(IShape shape : shapeList.clipBoard()) {
			templist.add(shape);
			shapeList.remove(shape);
		}

		for(IShape temp : shapeList.pasteList()) {
			temp.move(offset, offset);
			templist.add(temp);
			shapeList.remove(temp);
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
