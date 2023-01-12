//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: VisibleObject.java
// Course: CS 300 Fall 2020
//
// Author: Huong Nguyen
// Email: htnguyen23@wisc.edu
// Lecturer: Hobbes LeGault
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: 
// Online Sources:
// URL: https://www.geeksforgeeks.org/find-two-rectangles-overlap/ - helped with method to find out
//      if two rectangles were overlapping
//
///////////////////////////////////////////////////////////////////////////////

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import processing.core.PApplet;
import processing.core.PImage;

public class VisibleObject extends InteractiveObject {

  private PImage image; // the graphical representation of this object
  private int x; // the horizontal position (in pixels of this object’s left side)
  private int y; // the vertical position (in pixels of this object’s top side)

  // constructor - initialize this new VisibleObject the image for this visible object should be
  // loaded from : "images"+File.separator+ name +".png"
  public VisibleObject(String name, int x, int y) {
    super(name); // why do I need to call the parent constructor? what happens when I call it?
    PApplet thisProcessing = getProcessing();
    image = thisProcessing.loadImage("images" + File.separator + name + ".png");
    this.x = x;
    this.y = y;
  }

  // draws image at its position before returning null
  @Override
  public Action update() {
    InteractiveObject.getProcessing().image(image, (float) x, (float) y); //why shouldn't I use "this."
    return null;
  }

  // changes x by adding dx to it (and y by dy)
  public void move(int dx, int dy) {
    this.x += dx;
    this.y += dy;
  }

  // return true only when point x,y is over image
  public boolean isOver(int x, int y) {
    int width = image.width;
    int height = image.height;
    if (x >= this.x && x <= this.x + width) {
      if (y >= this.y && y <= this.y + height)
        return true;
    }
    return false;
  }

  // return true only when other’s image overlaps this one’s
  public boolean isOver(VisibleObject other) {
    int xLeft2 = other.x;
    int xRight2 = xLeft2 + other.image.width;
    int yTop2 = other.y;
    int yBottom2 = yTop2 + other.image.height;
    int xLeft1 = this.x;
    int xRight1 = xLeft1 + this.image.width;
    int yTop1 = this.y;
    int yBottom1 = yTop1 + this.image.height;
    // if one rectangle is on left side of other
    if (xLeft1 >= xRight2 || xLeft2 >= xRight1)
      return false;
    // if one rectangle is above other
    if (yTop1 >= yBottom2 || yTop2 >= yBottom1)
      return false;
    return true;
  }

}
