//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: DraggableObject.java
// Course: CS 300 Fall 2020
//
// Author: Huong Nguyen
// Email: htnguyen23@wisc.edu
// Lecturer: Hobbes LeGault
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: (identify each by name and describe how they helped)
// Online Sources: (identify each by URL and describe how it helped)
//
///////////////////////////////////////////////////////////////////////////////

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import processing.core.PApplet;
import processing.core.PImage;

public class DraggableObject extends VisibleObject {
  private boolean mouseWasPressed = false; // similar to use in ClickableObject
  private boolean isDragging = false; // true when this object is being dragged by the user
  private int oldMouseX; // horizontal position of mouse during last update
  private int oldMouseY; // vertical position of mouse during last update

  // constructor - initializes new draggable object
  public DraggableObject(String name, int x, int y) {
    super(name, x, y);
  }

  // calls VisibleObject update() first, then moves according to mouse drag
  // each time isDragging changes from true to false, the drop() method below will be
  // called once and any action objects returned from that method should then be
  // returned from update()
  @Override
  public Action update() {
    super.update();
    if (getProcessing().mousePressed && !mouseWasPressed
      && isOver(getProcessing().mouseX, getProcessing().mouseY)) {
      oldMouseX = getProcessing().mouseX;
      oldMouseY = getProcessing().mouseY;
      mouseWasPressed = true;
      isDragging = true;
    }
    if (isDragging) {
      this.move(getProcessing().mouseX - oldMouseX, getProcessing().mouseY - oldMouseY);
      oldMouseX = getProcessing().mouseX;
      oldMouseY = getProcessing().mouseY;
      if (!getProcessing().mousePressed) {
        isDragging = false;
        mouseWasPressed = false;
        return drop();
      }
    }
    return null;
  }

  // this method returns null.
  // subclass types will override this drop() method to perform more interesting behavior
  protected Action drop() {
    return null;
  }

}
