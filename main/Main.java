package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import controller.JPaintController;
import controller.shapeBuilder;
import controller.createshapeCommand;
import controller.selectCommand;
import model.Point;
import model.ShapeColor;
import model.ShapeList;
import model.ShapeType;
import model.interfaces.IApplicationState;
import model.interfaces.IShape;
import model.interfaces.IShapeObserver;
import model.interfaces.IShapeSubject;
import model.interfaces.Shape;
import model.persistence.ApplicationState;
import view.ClickHandler;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;

public class Main {


	public static void main(String[] args){
				
		shapeBuilder shapebuilder = new shapeBuilder();
        PaintCanvas paintCanvas = new PaintCanvas(ShapeList.getInstance()); //design pattern - singleton pattern 
        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);


        ApplicationState appState = new ApplicationState(uiModule);

		new JPaintController(uiModule, appState, ShapeList.getInstance(), paintCanvas, ShapeList.getInstance(), appState, shapebuilder);
        
        paintCanvas.addMouseListener(new ClickHandler(paintCanvas, appState, ShapeList.getInstance()));
        
        IShapeObserver observers = new createshapeCommand(appState, paintCanvas, ShapeList.getInstance(), shapebuilder);
        ShapeList.getInstance().registerObservers(observers);        
        }        
}
