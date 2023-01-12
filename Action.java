//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Action.java
// Course:   CS 300 Fall 2020
//
// Author:   Huong Nguyen
// Email:    htnguyen23@wisc.edu
// Lecturer: Hobbes LeGault
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         (identify each by name and describe how they helped)
// Online Sources:  (identify each by URL and describe how it helped)
//
///////////////////////////////////////////////////////////////////////////////

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import processing.core.PApplet;
import processing.core.PImage;

public class Action {

  private String message; // message printed by this action (or null to do nothing)
  private InteractiveObject object;
  
  //constructor - create and initialize this new action
  public Action(String message) {
    this.message = message;
  } 
  
  public Action(InteractiveObject object) {
    this.object = object;
  }
  
  public Action(String message, InteractiveObject object) {
    this.message = message;
    this.object = object;
  }
  
  public void act(ArrayList<InteractiveObject> gameObjects) {
    if (message != null)
      System.out.println(message);
    if (object != null) {
      object.activate();
      gameObjects.add(object);
      this.object = null;
    }
      
  } 

}
