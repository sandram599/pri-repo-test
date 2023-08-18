package model.interfaces;

import java.util.List;

import controller.createshapeCommand;

public interface IShapeSubject {
	
	void registerObservers(IShapeObserver observer); //observer pattern (4)
	void notifyObservers();
	void add(IShape shape);
	void remove(IShape shape);
	public List<IShape> getshapelist();
	public List<IShape> getselectedshapeList();
	public List<IShape> getClipBoard();

}
