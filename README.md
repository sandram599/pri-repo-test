FINAL PROJECT
SE450 - OBJ-ORIENTED SOFTWARE DEV
JPaint Application - A 'paint' - like application that allows one to:
  - Select a shape
  - Select primary, secondary colors including shading types for the shapes
  - Click and draw the shapes on a canvas
  - Paste, delete, undo, redo, groups, and ungroups the shapes drawn on the canvas.

Developing the code for the project focuses on implementing the 5 SOLID princples to graps the concepts of the principles.
The features of the project are completed in Sprints, each lasting 2 weeks. 

Check-in 1: First features -
Drawn a filled-in Rectangle that displays after the mouse is released after clicking and dragging on the mouse.
Implement Undo/Redo for the shapes.

// Check-in 1: BUGS the undo/redo methods code is written, but isn't working in the application. I attempted to pass in the commands in the clickhandler to implement Undo/Redo but it doesn't show on the canvas.

Check-in 2: Second features - 
Draw rectangles, triangles, and ellipses with various colors and shading types onto the canvas. Two additional design patterns included. 
Implement Select option, includes a collision detection algorithm to moved by the user.
Implement Move option, move option allows for shapes to be move by simply clicking and dragging on the canvas. 

//Check - in 2: BUGS unable to have graphics show up on canvas, wrote loop to call draw method for each shape in paintCanvas, but nothing showing up. Unsure where all the errors are. Implemented design patterns - shapebuilder and observer pattern in week 2 sprint.

Check-in 3: Third features - 
Copy, Paste, Delete, Outline Selected Shape and Undo/Redo. Have at least 4 design patterns implemented in code. From week 2 sprint, multiple shapes are able to drawn, outline and/or filled with different colors, and shapes are able to move around the canvas when selected. 
4 Design patterns implemented so far - IShapeObserver pattern in Model.Interfaces, ShapeBuilder pattern and Null Object pattern in Controller folder. Attemped Singleton pattern in SelectCommand, instance - if shape is null or no shapes, nullobject will be called. 


//Check-in 3 BUGS : Have code written for all 3 features, however I am continuously getting 'shapeList is null' error for Delete/Copy/Paste. I am able to use select on the canvas for my Move Command and run the move command just fine, and my run method for my delete command is very similar to my move method, but shapelist appears null for copy/delete/paste. 
Missing Features - For outline selected shape, code written for each shape outline and wrote the ShapeOutline code in paintcanvas to run when shape is selected, but is commented out in paintcanvas.

Check-in 4: Fourth features - 
Group and Ungroup selected shapes. Grouped selected shapes should operate as if it were one shape, to be moved, deleted, copeid, and pasted. Selected shapes to be grouped should have dashed outline around the selected shapes. Ungrouping selected shapes will ungrouped. Ungroup should also have undo/redo method. Added fifth design pattern - folder pattern in group.java.

//Check-4 BUGS: ungroup and group code is written but doesn't seem to have any effect on the shapes, unless they are overlapping each other. (continual issues with the select command, collision detection code). Was able to draw dashed box on selected shapes, however the box would affect the size of the shapes selected.(So it may be a miss when trying to outline selected group shapes, just click on an overlapping point to group the shapes) The box did not follow the outline of the shapes. When shapes are overlapped, I am able to copy, paste and delete, as needed but only if overlapping. 

//https://github.com/sandram599/pri-repo-test.git

Final Updates
  - Functionality
      - Able to draw filled-in rectangle on screen based on the mouse movement from clicking and dragging.(Check-In 1)
      - Implemented undo/redo draw for the draw rectangle.(Check-In 1)
      - Able to draw shapes with different colors and various shading types.(Check-In 2)
      - Implemented 'select' for shapes including collision detected algorithm, and implemented move for all shapes based on mouse movement across the canvas.(Check-In 2)
      - Implemented undo/redo for moved shapes.(Check-In 2)
      - Implemented copy to clipboard, deleted, and paste method for the selected shapes. Shapes are outlined when selected on the canvas(undo/redo) (Check-In 3)
   
Design Patterns (5)
  - (1) Observer pattern implemented in IShapeObserver (Model.Interfaces package)
  - (2) Null Object pattern implemented in controller package
  - (3) ShapeBuilder pattern implemented in controller package
  - (4) Singleton pattern implememted in main package on ShapeList.
  - (5) Folder pattern implemented in group in controller package
