/*
 *TCSS 305 - Winter 2016
 *Assignment 5 - PowerPaint
 */

package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import model.Drawing;
import model.Line;

import model.Tool;

/**
 *This panel represents the canvas that the user will draw upon while using PowerPaint.
 *
 *@author singhp5
 *@version 2/12/16
 */
public class PaintDrawPanel extends JPanel {

    /**
     *Stores the serial number.
     */
    private static final long serialVersionUID = -3321610113539949158L;

    /**
     *The background color of the panel.
     */
    private static final Color BACKGROUND_COLOR = Color.WHITE;


    /**
     *Stores the preferred width of the panel.
     */
    private static final int WIDTH = 500;

    /**
     *Stores the preferred height of the panel.
     */
    private static final int HEIGHT = 400;

    /**
     *Stores the string that the PropertyChange listeners will set as the new event.
     */
    private static final String NOT_EMPTY_STRING = "notEmpty";

    /**
     *Stores the string that the PropertyChange listeners will set as the new event.
     */
    private static final String EMPTY_STRING = "empty";

    /**
     *Stores the string that the PropertyChange listeners will set as the new event.
     */
    private static final String ARRAY_STRING = "shapeArray";

    /**
     *This represents the current tool being used to paint on the panel.
     */
    private Tool myCurrentTool;

    /**
     *Stores the current color being used.
     */
    private Color myColor;

    /**
     *Stores the current width used to draw.
     */
    private int myWidth;

    /**
     *Stores all the shapes that are created by the user.
     */
    private final List<Drawing> myDrawingArray;
    
    /**
     * create a custom color.
     */
    private Color myPurple = new Color(51, 0, 111);

    
    /**
     *Keeps track of all the shapes that are undone.
     */
    private final ArrayDeque<Drawing> myUndoStack;

    /**
     *Stores the current shape before the mouse is released.
     */
    private Drawing myCurrentShape;

    /**
     *Create the panel.
     */
    public PaintDrawPanel() {

        super();
        setTool(new Line(this));

        myColor = Color.BLACK;
        myWidth = 5;
        myUndoStack = new ArrayDeque<Drawing>();
        myDrawingArray = new ArrayList<Drawing>();
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(BACKGROUND_COLOR);
        setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));

    }

    /**
     * Paints the current path.
     * 
     * @param theGraphics The graphics context to use for painting.
     */
    @Override
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        final Graphics2D g2d = (Graphics2D) theGraphics;

        for (int i = 0; i < myDrawingArray.size(); i++) {
            final Drawing drawing = myDrawingArray.get(i);
            g2d.setPaint(myPurple);
            g2d.setStroke(new BasicStroke(drawing.getWidth()));
            g2d.draw(drawing.getShape());
        }

        if (myCurrentShape != null) {
      
            g2d.setPaint(myPurple);
            g2d.setStroke(new BasicStroke(myCurrentShape.getWidth()));
            g2d.draw(myCurrentShape.getShape());
        }


    }

    /**
     *This method will set the current tool.
     *
     *@param theTool the newly selected tool.
     */
    public void setTool(final Tool theTool) {
        removeMouseListener(myCurrentTool);
        removeMouseMotionListener(myCurrentTool);
        myCurrentTool = theTool;
        addMouseListener(myCurrentTool);
        addMouseMotionListener(myCurrentTool);
    }

    /**
     *This method will allow the user to set the color used to paint on this panel.
     *
     *@param theColor This is the new color used.
     */
    public void setColor(final Color theColor) {
        myColor = theColor;
    }

    /**
     *This method will allow the menuBar to change the current width.
     *
     *@param theWidth the new width used to draw shapes.
     */
    public void setWidth(final int theWidth) {
        myWidth = theWidth;
    }

    /**
     *Allows the tool objects to change the current path drawn.
     *
     *@param theShape The new shape created.
     */
    public void addShape(final Shape theShape) {
        if (myWidth > 0) {
            final Drawing newDrawing = new Drawing(theShape, myColor, myWidth);
            if (myDrawingArray.isEmpty()) {
                firePropertyChange(ARRAY_STRING, null, NOT_EMPTY_STRING);
            }
            myDrawingArray.add(newDrawing);
            repaint();
        } 
    }

    /**
     *Allows the tool objects to render a shape temporarily but not save it permanently.
     *
     *@param theShape The shape being displayed.
     */
    public void renderShape(final Shape theShape) {
        if (myWidth > 0) {
            final Drawing newDrawing = new Drawing(theShape, myColor, myWidth);
            myCurrentShape = newDrawing;
            repaint();
        }        
    }

    /**
     *This method will allow the undo all button to clear everything off the drawing panel.
     */
    public void undoAll() {
        firePropertyChange("array", null, EMPTY_STRING);
        myDrawingArray.clear();
        myUndoStack.clear();
        myCurrentShape = new Drawing(new Line2D.Double(), Color.WHITE, 0);
        repaint();
    }

}