/*
 *TCSS 305 - Winter 2016
 *Assignment 5 - PowerPaint
 */

package model;

import java.awt.Color;
import java.awt.Shape;

/**
 *This class will store a complete drawing that will contain its own color and width.
 *
 *@author singhp5
 *@version 1.0
 */
public class Drawing {

    /**
     *Holds the shape that this drawing represents.
     */
    private final Shape myShape;
    
    /**
     *Holds the Color this drawing will be drawn in.
     */
    private final Color myColor;
    
    /**
     *The width of this drawing.
     */
    private final int myWidth;
    
    /**
     *Constructs a new drawing with a color width and shape.
     *
     *@param theShape The shape this drawing will contain.
     *@param theColor The Color this drawing will be drawn in.
     *@param theWidth The width of this shape's outline.
     */
    public Drawing(final Shape theShape, final Color theColor, final int theWidth) {
        myShape = theShape;
        myColor = theColor;
        myWidth = theWidth;
    }
    
    /**
     *Gives the shape this drawing represents.
     *
     *@return the contained shape.
     */
    public Shape getShape() {
        return myShape;
    }
    
    /**
     *Gives the color this drawing represents.
     *
     *@return the contained color.
     */
    public Color getColor() {
        return myColor;
    }
    
    /**
     *Gives the width this drawing represents.
     *
     *@return the contained width.
     */
    public int getWidth() {
        return myWidth;
    }
}