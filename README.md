FINAL PROJECT
SE450 - OBJ-ORIENTED SOFTWARE DEV
JPaint Application - A 'paint' - like application that allows one to:
  - Select a shape
  - Select primary, secondary colors including shading types for the shapes
  - Click and draw the shapes on a canvas
  - Paste, delete, undo, redo, groups, and ungroups the shapes drawn on the canvas.

Developing the code for the project focuses on implementing the 5 SOLID princples to graps the concepts of the principles.
The features of the project are completed in Sprints, each lasting 2 weeks. 

Sprint 1: First features -
Drawn a filled-in Rectangle that displays after the mouse is released after clicking and dragging on the mouse.
Implement Undo/Redo for the shapes.

//the undo/redo methods code is written, but isn't working in the application. I attempted to pass in the commands in the
//clickhandler to implement Undo/Redo but it doesn't show on the canvas.

Sprint 2: Second features - 
Draw rectangles, triangles, and ellipses with various colors and shading types onto the canvas. Two additional design patterns included. 
Implement Select option, includes a collision detection algorithm to moved by the user.
Implement Move option, move option allows for shapes to be move by simply clicking and dragging on the canvas. 

//unable to have graphics show up on canvas, wrote loop to call draw method for each shape in paintCanvas, but nothing showing up. Unsure where all the errors are. 
//implemented design patterns - shapebuilder and observer pattern in week 2 sprint.

Sprint 3: Third features - 
Copy, Paste, Delete, Outline Selected Shape and Undo/Redo. Have at least 4 design patterns implemented in code. From week 2 sprint, multiple shapes are able to drawn, outline and/or filled with different colors, and shapes are able to move around the canvas when selected. 
4 Design patterns implemented so far - IShapeObserver pattern in Model.Interfaces, ShapeBuilder pattern and Null Object pattern in Controller folder. Attemped Singleton pattern in SelectCommand, instance - if shape is null or no shapes, nullobject will be called. 


//Sprint 3 BUGS - Have code written for all 3 features, however I am continuously getting 'shapeList is null' error for Delete/Copy/Paste. I am able to use select on the canvas for my Move Command and run the move command just fine, and my run method for my delete command is very similar to my move method, but shapelist appears null for copy/delete/paste. 
Missing Features - For outline selected shape, code written for each shape outline and wrote the ShapeUutline code in paintcanvas to run when shape is selected, but is commented out in paintcanvas.
