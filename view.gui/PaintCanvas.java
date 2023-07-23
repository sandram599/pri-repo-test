package view.gui;

import javax.swing.JComponent;

import controller.CreateShape;
import model.ShapesList;
import model.interfaces.IShapeDraw;
import model.interfaces.IShapeSubject;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class PaintCanvas extends JComponent {
	
	public Graphics2D getGraphics2D() {
		return (Graphics2D) getGraphics();
	}

	private ShapesList shapeList;
	private CreateShape newshape;
	
	public void paint(Graphics2D g) {
		//super.paint(g);
		Graphics2D g2d = (Graphics2D) g.create();
		for(CreateShape shape : shapeList.getshapelist()) {
		shape.makeShape(newshape);
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
    

