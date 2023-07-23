package controller;


import model.Point;
import model.interfaces.IBB;

public class boundingBox implements IBB {
	
	private Point startPoint, endPoint;
	int xPoint1, xPoint2, yPoint1, width, height;
	private Object xDelta;
	//static boolean CollisionDetection = false;
	private Object yDelta;
	private int yPoint2;
	
	public boundingBox(Point startPoint, Point endPoint) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		
		int xPoint1 = endPoint.getX() - startPoint.getX();
		int xPoint2 = endPoint.getX() - startPoint.getX();
		int yPoint1 = endPoint.getY() - startPoint.getY();
		int yPoint2 = endPoint.getY() - startPoint.getY();
		
		startPoint = new Point(xPoint1, yPoint1);
		endPoint = new Point(xPoint2, yPoint2);
		
	}
	
	public Point grabStart() {
		return startPoint;
	}
	
	public Point grabEnd() {
		return endPoint;

	}

	public boolean CollisionDetection(IBB b) {
		return this.grabStart().getX() < b.grabEnd().getX() && this.grabEnd().getX() 
				> b.grabStart().getX() && this.grabStart().getY() < b.grabEnd().getY() 
				&& this.grabEnd().getY() > b.grabStart().getY();
		
	}
}
