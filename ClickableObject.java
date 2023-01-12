//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: ClickableObject.java
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

public class ClickableObject extends VisibleObject {
  private Action action; // action returned from update when this object is clicked
  private boolean mouseWasPressed = false; // tracks whether the mouse was pressed during the last update()

  // constructor
  public ClickableObject(String name, int x, int y, Action action) {
    super(name, x, y);
    this.action = action;
  }

  // calls VisibleObject update, then returns action only when mouse is first clicked on this object
  @Override
  public Action update() {
    super.update();
    if (!mouseWasPressed && getProcessing().mousePressed && isOver(getProcessing().mouseX, getProcessing().mouseY)) {
          this.mouseWasPressed = true;
          return this.action;
    }
    if (!getProcessing().mousePressed)
      mouseWasPressed = false;
    return null;
  }
}
