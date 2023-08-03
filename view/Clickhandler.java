package view;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import controller.createshapeCommand;
import controller.ShapeBuilder;
import controller.drawEllipse;
import controller.moveCommand;
import controller.nullObject;
import controller.selectCommand;
import model.MouseMode;
import model.Point;
import model.ShapeShadingType;
import model.ShapeType;
import model.ShapeList;
import model.interfaces.IShape;
import model.persistence.ApplicationState;
import view.gui.PaintCanvas;


public class ClickHandler extends MouseAdapter { 
	
		Point startPoint, endPoint;
		private PaintCanvas paintCanvas;
		private ApplicationState appState;
		private Color primary, secondary;
		private ShapeShadingType shade;
		private ShapeType shapetype;
		private ShapeList shapeList;
		private ShapeBuilder shapebuilder;
		private int width, height;
		

		public ClickHandler(PaintCanvas paintCanvas, ApplicationState appState, ShapeList shapeList) {
			this.paintCanvas = paintCanvas; 
			this.appState = appState;
			//this.shapebuilder = shapebuilder;
			this.shapeList = shapeList;
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
				ShapeBuilder shapebuilder = new ShapeBuilder();
				shapebuilder.Start(startPoint);
				shapebuilder.End(endPoint); 
				shapebuilder.getShadingType(appState.getActiveShapeShadingType());
				shapebuilder.getShapeType(appState.getActiveShapeType());
				shapebuilder.primary(appState.getActivePrimaryColor());
				shapebuilder.secondary(appState.getActiveSecondaryColor());
				createshapeCommand shape = new createshapeCommand(appState, paintCanvas, shapeList, shapebuilder);
				shape.run();
				break;
			case MOVE: 
				moveCommand move = new moveCommand(startPoint, endPoint, paintCanvas, shapeList);
				move.run();
				break;
			case SELECT:
				selectCommand select = new selectCommand(startPoint, endPoint, paintCanvas, shapeList);
				select.run();
				break;
			default:
				break;
		}
	}
}
	
