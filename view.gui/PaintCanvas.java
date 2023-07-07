package view.gui;

import javax.swing.JComponent;
import java.awt.*;
import java.awt.event.MouseEvent;

public class PaintCanvas extends JComponent {

    Point startPoint = new Point();
	Point endPoint = new Point();
	private int width;
	private int height;

	@Override
    public void paint(Graphics g) {
    	
    	Graphics2D graphics2d = (Graphics2D)g;

        // Draw all shapes here

        // For example purposes only; remove all lines below from your final project.
		width = endPoint.x - startPoint.x;
		height = endPoint.x - startPoint.y;
        graphics2d.setColor(Color.GREEN);
		graphics2d.fillRect(startPoint.x, endPoint.y, width, height); 
		graphics2d.drawRect(startPoint.x, endPoint.y, width, height); 

        // Outlined rectangle
        //graphics2d.setStroke(new BasicStroke(5));
        //graphics2d.setColor(Color.BLUE);
        //graphics2d.drawRect(12, 13, 200, 400);

        // Selected Shape
        //Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
        //graphics2d.setStroke(stroke);
        //graphics2d.setColor(Color.BLACK);
        //graphics2d.drawRect(7, 8, 210, 410); //unsure what this will be here the values
    }
}
