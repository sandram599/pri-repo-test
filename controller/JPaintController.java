package controller;

import model.Point;
import model.ShapeList;
import model.ShapeType;
import model.interfaces.IApplicationState;
import model.interfaces.IJPaintController;
import model.interfaces.IShape;
import model.persistence.ApplicationState;
import view.EventName;
import view.gui.PaintCanvas;
import view.interfaces.IUiModule;
import controller.redoCommand;
import controller.undoCommand;

public class JPaintController implements IJPaintController {
    private final IUiModule uiModule;
    private final IApplicationState applicationState;
	private PaintCanvas paintCanvas;
	private ShapeList shapeList, clipBoard;
	private ApplicationState appState;
	private shapeBuilder shapebuilder;
	private Point startPoint;
	private Point endPoint;
	private ShapeType shapetype;

	
    public JPaintController(IUiModule uiModule, IApplicationState applicationState, ShapeList shapeList, PaintCanvas paintCanvas, ShapeList clipBoard, ApplicationState appState, shapeBuilder shapebuilder) {
        this.uiModule = uiModule;
        this.applicationState = applicationState;
        this.shapeList = shapeList;
        this.paintCanvas = paintCanvas;
        this.clipBoard = clipBoard;
        this.appState = appState;
        this.shapebuilder = shapebuilder;
        setupEvents();
    }

    private void setupEvents() {
        uiModule.addEvent(EventName.CHOOSE_SHAPE, applicationState::setActiveShape);
        uiModule.addEvent(EventName.CHOOSE_PRIMARY_COLOR, applicationState::setActivePrimaryColor);
        uiModule.addEvent(EventName.CHOOSE_SECONDARY_COLOR, applicationState::setActiveSecondaryColor);
        uiModule.addEvent(EventName.CHOOSE_SHADING_TYPE, applicationState::setActiveShadingType);
        uiModule.addEvent(EventName.CHOOSE_MOUSE_MODE, applicationState::setActiveStartAndEndPointMode);
        uiModule.addEvent(EventName.UNDO, this::undo);
        uiModule.addEvent(EventName.REDO, this::redo);
        uiModule.addEvent(EventName.COPY, this::copy);
        uiModule.addEvent(EventName.PASTE, this::paste);
        uiModule.addEvent(EventName.DELETE, this::delete);
        uiModule.addEvent(EventName.GROUP, this::group);
        uiModule.addEvent(EventName.UNGROUP, this::ungroup);
    }

    private void undo() { 
    	undoCommand u = new undoCommand();
    	u.run();
    }

    private void redo() {
    	redoCommand r = new redoCommand();
    	r.run();
    }

    private void copy() { 
    	copyCommand c = new copyCommand(paintCanvas, shapeList, endPoint, startPoint, shapeList, appState, shapetype);
    	c.run();
    }

    private void paste() {
    	pasteCommand p = new pasteCommand(paintCanvas, appState, shapeList, startPoint, endPoint);
    	p.run();
    }

    private void delete() { 
    	deleteCommand d = new deleteCommand(paintCanvas, shapeList, startPoint, endPoint, appState);
    	d.run();
    }

    private void group() {
    	groupCommand g = new groupCommand(appState, paintCanvas, shapeList, startPoint, endPoint);
    	g.run();
    }

    private void ungroup() {
    	ungroupCommand ug = new ungroupCommand(paintCanvas, appState, shapeList, startPoint, endPoint);
    	ug.run();
    }
}
