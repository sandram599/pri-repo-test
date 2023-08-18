package model;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import controller.createshapeCommand;
import model.interfaces.IShape;
import model.interfaces.IShapeObserver;
import model.interfaces.IShapeSubject;
import model.interfaces.Shape;
import view.gui.PaintCanvas;


public class ShapeList implements IShapeSubject {
	
	private List<IShapeObserver> shapeObservers = new ArrayList<IShapeObserver>();
	private List<IShape> shapeList  = new ArrayList<IShape>(); 
	private List<IShape> selectedshapeList = new ArrayList<IShape>();
	private List<IShape> clipBoard = new ArrayList<IShape>(); 
	private List<IShape> groupList = new ArrayList<IShape>();
	private static ShapeList instance = new ShapeList(); //design pattern - singleton pattern (3)
	
	private PaintCanvas paintCanvas;
	

	private ShapeList() { 
		
	}
	
	@Override
	public void registerObservers(IShapeObserver observer) {
		shapeObservers.add(observer);
	}

	@Override
	public void add(IShape shape) {
		shapeList.add(shape);
		notifyObservers();		
	}

	@Override
	public void notifyObservers() {
		for(var shapeObserver : shapeObservers) {
			shapeObserver.update();			
		}		
	}

	@Override
	public void remove(IShape shape) {
		shapeList.remove(shape);
		notifyObservers();
	}

	public List<IShape> getshapelist() {
		return shapeList;
	}
	
	public List<IShape> getselectedshapeList() {
		return getSelectedshapeList();
	}
	
	public List<IShape> selectedshapeList(){
		return getSelectedshapeList();
	}
	
	@Override
	public List<IShape> getClipBoard() {
		return clipBoard;		
	}

	public List<IShape> clipBoard() {
		return clipBoard;
	}
	public List<IShape> getSelectedshapeList() {
		return selectedshapeList;
	}
	
	public static ShapeList getInstance() { //design pattern - part of singleton pattern (3)
		return instance;
	}

	public void remove(ArrayList<IShape> templist) {
		shapeList.removeAll(templist);
	}
	
	public void add(ArrayList<IShape> templist) {
		shapeList.addAll(templist);
		
	}
}
