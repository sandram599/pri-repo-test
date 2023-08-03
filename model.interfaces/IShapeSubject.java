package model.interfaces;

import java.util.List;

import controller.createshapeCommand;

public interface IShapeSubject {
	
	void registerObservers(IShapeObserver observer);
	void notifyObservers();
	void add(IShape shape);
	void remove(IShape shape);
	public List<IShape> getshapelist();
	public List<IShape> getselectedshapesList();
	public List<IShape> getClipBoard();

}
