package view;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import controller.CreateShape;
import controller.moveCommand;
import controller.selectCommand;
import model.MouseMode;
import model.Point;
import model.ShapeShadingType;
import model.ShapeType;
import model.ShapesList;
import model.interfaces.IBB;
import model.persistence.ApplicationState;
import view.gui.PaintCanvas;


public class ClickHandler extends MouseAdapter { 
	
		Point startPoint, endPoint;
		private PaintCanvas paintCanvas;
		private ApplicationState appState;
		private Color primaryC, secondaryC;
		private ShapeShadingType shapeshadingtype;
		public ShapeType shapetype;
		private ShapesList shapeList;


		public ClickHandler(PaintCanvas paintCanvas, ApplicationState appState) {
			this.paintCanvas = paintCanvas; 
			this.appState = appState;
		}
		
		@Override
		public void mousePressed(MouseEvent e) { 
			startPoint = new Point(e.getX(), e.getY());
		}
			
		@Override		
		public void mouseReleased(MouseEvent e) { 		
			endPoint = new Point(e.getX(),e.getY());
			
			switch(appState.getActiveMouseMode()) {
			
			case DRAW:
				CreateShape shape = new CreateShape(startPoint,endPoint, paintCanvas, appState, shapetype, secondaryC, shapeshadingtype, primaryC);
				shape.run();
				break;
			case MOVE: 
				moveCommand movedshape = new moveCommand (paintCanvas, shapeList);
				movedshape.run();
				break;
			case SELECT:
				selectCommand selectedShape = new selectCommand(shapeList, paintCanvas);
				selectedShape.run();
				break;
			default:
				System.out.println("Please choose to draw, move, or select the shape.");
				break;

		}
	}
}
