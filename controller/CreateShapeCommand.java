package controller;

import model.ShapesList;
import model.Point;
import model.ShapeShadingType;
import model.ShapeType;
import model.interfaces.ICommand;
import model.interfaces.IShapeDraw;
import model.interfaces.IShapeObserver;
import model.interfaces.IUndoable;
import model.persistence.ApplicationState;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import view.gui.PaintCanvas;


public class CreateShape implements ICommand, IUndoable, IShapeObserver {
	
	private CreateShape shape;
	Point startPoint, endPoint;
	PaintCanvas paintCanvas;
	private ApplicationState appState;
	ArrayList<CreateShape> shapeList = new ArrayList<CreateShape>();
	private ShapeType shapetype;
	private ShapeShadingType shapeshadingtype;
	private Color primaryC, secondaryC;
	private int x, y;
	private int width, height;


	//constructor declare it in main and pass into paint canvas & createshape constructor
	//the run/execute method in createShape takes parameters, startpoint and endpoint, from
	//the mousepressed and released.
	//the run/execute method is also meant to instantiate a new shape object.
	//the new shape object is to be added to the shapelist class
	//undo and redo on every shape
	
	
	 public CreateShape(Point startPoint, Point endPoint, PaintCanvas paintCanvas, ApplicationState appState, ShapeType shapetype, Color primaryC, ShapeShadingType shapeshadingtype, Color secondaryC) {
		this.paintCanvas = paintCanvas;
		this.appState = appState;
		this.shapetype = shapetype;
		this.shapeshadingtype = shapeshadingtype;
		this.primaryC = primaryC;
		this.secondaryC = secondaryC;
		this.endPoint = endPoint;
		this.startPoint = startPoint;
		
		this.width = startPoint.x - endPoint.x;
		this.height = startPoint.y - endPoint.y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
	 

	@Override
	public void run() {  
		CommandHistory.add(this);
		shape = new buildShape().startPoint(startPoint).endPoint(endPoint).shapeshadingtype(appState.getActiveShapeShadingType())
				.shapetype(appState.getActiveShapeType()).primaryC(appState.getActivePrimaryColor().getShapeColor())
				.secondaryC(appState.getActiveSecondaryColor().getShapeColor()).toBuild();
		shapeList.add(shape);
	}

	@Override
	public void redo() {
		shapeList.add(shape);
	}

	@Override
	public void undo() {
		shapeList.remove(shape);	
	}
	
	public ShapeType getShape() {
		return shapetype;
	}

	public ShapeShadingType getShapeshadingtype() { 
		return shapeshadingtype;
	}

	public boolean isIn(Point startPoint) {
		return true;
	}

	public Point grabStart() {
		return startPoint;
	}

	public void moved(int x, int y) {
		startPoint = new Point(startPoint.getX() + x, startPoint.getY() + y );
		endPoint = new Point(endPoint.getX() + x,  endPoint.getY() + y);
	}
	
	public CreateShape(PaintCanvas paintCanvas) {
		Graphics2D g2d = (Graphics2D) paintCanvas.getGraphics();
	}

	public void makeShape(CreateShape shape) {
		IShapeDraw todraw = null; 
		
		switch(shape.getShape()) {
		
		case ELLIPSE: 
			todraw = new drawEllipse(startPoint, endPoint, paintCanvas, primaryC, secondaryC, shapeshadingtype);
			break;
		case RECTANGLE:
			todraw = new drawRectangle(paintCanvas, endPoint, startPoint, primaryC, secondaryC, shapeshadingtype);
			break;
		case TRIANGLE:
			todraw = new drawTriangle(startPoint, endPoint, paintCanvas, primaryC, secondaryC, shapeshadingtype);
			break;
		default:
				System.out.println("Please choose a shape.");			
		}
	todraw.designShape(shape); //remember to do for loop for each shape to be drawn
	}

	@Override
	public void update() {
		//Graphics2D graphics2d = (Graphics2D) paintCanvas.getGraphics();
		//graphics2d.setColor(Color.WHITE);
		//graphics2d.fillRect(0, 0, paintCanvas.getWidth(), paintCanvas.getHeight());
		paintCanvas.repaint();					
	} 
}

	
		
	
	
