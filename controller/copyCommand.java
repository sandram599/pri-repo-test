package controller;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import model.Point;
import model.ShapeColor;
import model.ShapeList;
import model.ShapeShadingType;
import model.ShapeType;
import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.interfaces.IShapeObserver;
import model.interfaces.IUndoable;
import model.interfaces.Shape;
import model.persistence.ApplicationState;
import view.gui.PaintCanvas;

public class copyCommand implements ICommand, IShapeObserver {

	private PaintCanvas paintCanvas; 
	private ShapeList shapeList;
	private ApplicationState appState;
	Point startPoint, endPoint;
	private ShapeType shapetype;
	private shapeBuilder shapebuilder;
	private ShapeColor primary;
	private ShapeColor secondary;
	private ShapeShadingType shade;
	private int height, width;
	private IShape shapeCopy;
	private ShapeShadingType shadeType;
	private ShapeType shapeType;

	
	public copyCommand(PaintCanvas paintCanvas, ShapeList shapeList, Point endPoint, Point startPoint, ShapeList clipBoard, ApplicationState appState, ShapeType shapetype) {
		this.paintCanvas = paintCanvas;
		this.shapeList = shapeList;	
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.appState = appState;
		this.shapetype = shapetype;
	}

	@Override
	public void run() {
		for(IShape shape : shapeList.selectedshapeList()) {

			if(shape.getShapeType().equals(ShapeType.ELLIPSE)) {
				shapeCopy = new drawEllipse(shape.getStartPoint(), shape.getEndPoint(), shape.getPrimary(), shape.getSecondary(), 
						shape.getShadeType(), shape.getShapeType(), shape.getHeight(),shape.getWidth());
			}
			else if(shape.getShapeType().equals(ShapeType.RECTANGLE)) {
				shapeCopy = new drawRectangle(shape.getStartPoint(), shape.getEndPoint(), shape.getPrimary(), shape.getSecondary(),
						shape.getShadeType(), shape.getShapeType(), shape.getHeight(), shape.getWidth());
			}
			else if(shape.getShapeType().equals(ShapeType.TRIANGLE)) {
				shapeCopy =  new drawTriangle(shape.getStartPoint(), shape.getEndPoint(), shape.getPrimary(), shape.getSecondary(),
						shape.getShadeType(), shape.getShapeType(), shape.getHeight(), shape.getWidth());
			}
			shapeList.clipBoard().add(shapeCopy);
		}
		paintCanvas.repaint();
	}		

	
	@Override
	public void update() {
		Graphics2D graphics2d = (Graphics2D) paintCanvas.getGraphics();
		graphics2d.setColor(Color.WHITE);
		graphics2d.fillRect(0, 0, paintCanvas.getWidth(), paintCanvas.getHeight());
		paintCanvas.repaint();
	}
}
