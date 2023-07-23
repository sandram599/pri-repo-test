package model;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import controller.CreateShape;
import controller.selectShapes;
import model.interfaces.IShapeObserver;
import model.interfaces.IShapeSubject;


public class ShapesList implements IShapeSubject {
	
	private List<IShapeObserver> shapeObservers = new ArrayList<IShapeObserver>();
	private ArrayList<CreateShape> shapeList  = new ArrayList<CreateShape>(); ;
	ArrayList<CreateShape> selectedshapes = new ArrayList<CreateShape>();

	
	public ShapesList(List<CreateShape> list) {
		//ArrayList<createShape> selectedshapes = new ArrayList<createShape>();
		//ArrayList<IShapeObserver> observers = new ArrayList<IShapeObserver>();
		//ArrayList<createShape> shapeList = new ArrayList<createShape>();
		
	}
	@Override
	public void registerObservers(IShapeObserver observer) {
		shapeObservers.add(observer);
		
	}

	@Override
	public void add(CreateShape shape) {
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
	public void remove(CreateShape shape) {
		shapeList.remove(shape);
		notifyObservers();
	}

	public List<CreateShape> getshapelist() {
		return shapeList;
	}

	@Override
	public boolean isIn() {
		return false;
	}
	
	public void addSelectShape(CreateShape shape) 	{
		selectedshapes.add(shape);
	}
	
	public List<CreateShape> getselectedshapes() {
		return selectedshapes;
	}
	public void draw(CreateShape shape) {
		for(CreateShape s : shapeList) {
			s.makeShape(s);
			
		}
	}
}

