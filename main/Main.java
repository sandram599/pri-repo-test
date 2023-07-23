package main;

import controller.JPaintController;
import model.persistence.ApplicationState;
import view.ClickHandler;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;
import java.awt.event.MouseListener;

public class Main {
    public static void main(String[] args){
        PaintCanvas paintCanvas = new PaintCanvas();

        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);

        ApplicationState appState = new ApplicationState(uiModule); 

        new JPaintController(uiModule, appState);
        
        paintCanvas.addMouseListener(new ClickHandler(paintCanvas));

        final List<CreateShape> list = new ArrayList<CreateShape>();
        IShapeSubject sList = new ShapesList(list);
        
        IShapeObserver observers = new CreateShape(paintCanvas);
        sList.registerObservers(observers);
        
        }        
}

    }
}
