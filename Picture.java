/* Filename: Picture.java 
* Created by: Nick Lin, cs8a and Robert Tso, cs8a
* Date: 11/3/16
*/

/*----------- Program Description: ------------
 * chromakeyBackgroundChange: changes the background greenscreen to a picture we choose.
 * chromakeyShirtChange: changes the shirt(or a box) to a picture we choose.
 */

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List;
import java.lang.*;
import java.awt.Color;// resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * Copyright Georgia Institute of Technology 2004-2005
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param width the width of the desired picture
   * @param height the height of the desired picture
   */
  public Picture(int width, int height)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output; 
  }
  /**
   * Replaces the monocolored background of the original picture with the sample picture
   */
  public Picture chromakeyBackgroundChange(Picture background, Color replaceColor)
  {
   Picture modified = this;
   Pixel sourcePixel = null;
   Pixel targetPixel = null;
   int targetx=0;
   int targety=0;
   sourcePixel = background.getPixel(targetx, targety);
   for(targetx = 0; targetx < this.getWidth(); targetx++)
   {
    for(targety = 0; targety < this.getHeight(); targety++)
    {
     targetPixel = this.getPixel(targetx, targety);
     if(Math.abs(targetPixel.getRed()-replaceColor.getRed())<65)
     {
      if(Math.abs(targetPixel.getGreen()-replaceColor.getGreen())<60)
      {
       if(Math.abs(targetPixel.getBlue()-replaceColor.getBlue())<90)
       sourcePixel = background.getPixel(targetx, targety);
       targetPixel.setColor(sourcePixel.getColor());
      }
     }
    }
   }
  return modified;
  }


  /**
   * changes the given shirt color into the given sample
   */
  public Picture chromakeyShirtChange(Picture shirt, Picture original, Color oldShirtColor, int startX, int startY, int width, int height) 
  {
   Picture modified = this;
   Pixel sourcePixel = null;
   Pixel targetPixel = null;
   Pixel referencePixel = null;
   for(int targetx = startX; targetx < startX+width; targetx++)
   {
    for(int targety = startY; targety < startY+height; targety++)
    {
     targetPixel = this.getPixel(targetx, targety);
     referencePixel = original.getPixel(targetx, targety);
     sourcePixel = shirt.getPixel(targetx, targety);
     if (targetPixel.colorDistance(oldShirtColor)<100) 
     {   
      if(referencePixel.getRed() == targetPixel.getRed())
      {
       if(referencePixel.getGreen() == targetPixel.getGreen())
       {
        if(referencePixel.getBlue() == targetPixel.getBlue())
        sourcePixel = shirt.getPixel(targetx, targety);
        targetPixel.setColor(sourcePixel.getColor());
       }
      }    
     }
    }
   }
  return modified;
  }
 }
 // this } is the end of class Picture, put all new methods before this
 
