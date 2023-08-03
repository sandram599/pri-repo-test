package view.gui;

import javax.swing.JComponent;

import controller.createshapeCommand;
import model.ShapeList;
import model.interfaces.IShape;
import model.interfaces.IShapeSubject;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class PaintCanvas extends JComponent {
	
	private ShapeList shapeList;

	public Graphics2D getGraphics2D() {
		return (Graphics2D) getGraphics();
	}
	
	public PaintCanvas(ShapeList shapeList) {
		this.shapeList = shapeList;
		
	}
	@Override
	public void paint(Graphics g) { 
		
		Graphics2D g2d = (Graphics2D) g;
		
		for(IShape shape : shapeList.getshapelist()) { 
		shape.draw(g2d);
		}
	}
}	





      // Graphics2D graphics2d = (Graphics2D) g;
       

        // Draw all shapes here

        /* For example purposes only; remove all lines below from your final project.
       // graphics2d.setColor(Color.GREEN);
        //graphics2d.fillRect(12, 13, 200, 400);
        graphics2d.fillRect(0, 0, getHeight(), getWidth());
		graphics2d.drawRect(0, 0, getHeight(), getWidth());
		//graphics2d.drawRect(12, 13, 200, 400);


        // Outlined rectangle
        graphics2d.setStroke(new BasicStroke(5));
        graphics2d.setColor(Color.BLUE);
        graphics2d.drawRect(12, 13, 200, 400);

        // Selected Shape
        Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
        graphics2d.setStroke(stroke);
        graphics2d.setColor(Color.BLACK);
        graphics2d.drawRect(7, 8, 210, 410);*/
    

