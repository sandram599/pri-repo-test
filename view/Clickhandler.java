package view;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import controller.createShapeCommand;
import view.gui.PaintCanvas;


public class ClickHandler extends MouseAdapter {
	
		Point startPoint = new Point();
		Point endPoint = new Point();
		
		//instantiate createShape class
		
		//constructor for clickhandler
		private int height;
		private int width;
		private PaintCanvas paintCanvas;
		private createShapeCommand createShape;
				
		//the algorithm for mouseRelease is:
		//endPoint.x - startPoint.x
		//endPoint.y - endPoint.y
		//fillRect(x,y,w,h)
		//then call -> paintCanvas.repaint()


		public ClickHandler(PaintCanvas paintCanvas) {
			this.paintCanvas = paintCanvas; //passing the reference into the clickhandler
		}
		
		public ClickHandler(createShapeCommand createShape, PaintCanvas paintCanvas) { //trying passing undo and redo methods??
			this.createShape = createShape;
			this.paintCanvas = paintCanvas;
		}


		@Override
		public void mousePressed(MouseEvent e) { 
			startPoint.x = e.getX();
			startPoint.y = e.getY();
		}
			
		@Override		
		public void mouseReleased(MouseEvent e) { 
			
			Graphics2D graphics2d = (Graphics2D) paintCanvas.getGraphics();
			endPoint.x = e.getX();
			endPoint.y = e.getY();
			
			width = endPoint.x - startPoint.x;
			height = endPoint.x - startPoint.y;
			graphics2d.setColor(Color.GREEN); 
			graphics2d.fillRect(startPoint.x, startPoint.y, width, height); 
			graphics2d.drawRect(startPoint.x, startPoint.y, width, height);
			
			//paintCanvas.repaint();
			//call PaintCanvas somehow
	}
		
}

