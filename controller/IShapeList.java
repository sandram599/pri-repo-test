package controller;

import java.util.ArrayList;

public interface IShapeList {
	
	public void add(IShape shape); 
	
	public void remove(IShape shape);
	
	public ArrayList<IShape> getShapeList();


}
