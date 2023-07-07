package controller;

import java.util.ArrayList;

import view.gui.PaintCanvas;

public class ShapeList implements IShapeList {

	private ArrayList<IShape> shapeList;
	
	public ShapeList(ArrayList<IShape> shapeList) {
		this.shapeList = shapeList;
	}
	
	private PaintCanvas paintCanvas;
	
	public void add(IShape shape) {
		shapeList.add(shape);
		paintCanvas.repaint();
	}
	
	public void remove(IShape shape) {
		shapeList.remove(shape);
		paintCanvas.repaint();

	}
	
	public ArrayList<IShape> getShapeList() {
		return shapeList;
	}
}
