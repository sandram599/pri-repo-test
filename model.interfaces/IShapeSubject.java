package model.interfaces;

import java.util.List;

import controller.CreateShape;

public interface IShapeSubject {
	
	void registerObservers(IShapeObserver observer);
	void notifyObservers();
	void add(CreateShape shape);
	void remove(CreateShape shape);
	public List<CreateShape> getshapelist();
	boolean isIn();
	void addSelectShape(CreateShape shape);
	public List<CreateShape> getselectedshapes();

}
