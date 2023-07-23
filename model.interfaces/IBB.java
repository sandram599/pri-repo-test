package model.interfaces;

import controller.boundingBox;
import model.Point;

public interface IBB {

	Point grabStart();
	Point grabEnd();
	boolean CollisionDetection(IBB b);

}
