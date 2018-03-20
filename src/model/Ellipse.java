/*
 *TCSS 305 - Winter 2016
 *Assignment 5 - PowerPaint
 */
package model;



import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

import javax.swing.JPanel;

/**
 *This class will draw an ellipse.
 *
 *@author singhp5
 *@version 1.0
 */
public class Ellipse extends AbstractTool {
    
    /**
     * Ellipse that Ellipse2D tool will create.
     */
    private Ellipse2D myEllipse;
    
    /**
     *  Stores the path created by this tool.
     */
    private Point2D myStartPoint;
    
    /**
     *This creates an ellipse tool.
     *
     *@param thePanel The panel this tool will draw on.
     */
    public Ellipse(final JPanel thePanel) {
        super(thePanel);
    }
    

    @Override
    public void mousePressed(final MouseEvent theEvent) {
        myEllipse = new Ellipse2D.Double(theEvent.getX(), theEvent.getY(),
                                         theEvent.getX() - theEvent.getX(),
                                          theEvent.getY() - theEvent.getY());
        
        myStartPoint = new Point2D.Double(theEvent.getX(), theEvent.getY());
        myPanel.renderShape(myEllipse);
        
        
    }
    
    @Override
    public void mouseDragged(final MouseEvent theEvent) {
        myEllipse.setFrameFromDiagonal(myStartPoint, theEvent.getPoint());
        myPanel.renderShape(myEllipse);
    }
    
    @Override
    public void mouseReleased(final MouseEvent theEvent) {
        myEllipse.setFrameFromDiagonal(myStartPoint, theEvent.getPoint());
        myPanel.renderShape(myEllipse);
        myPanel.addShape(myEllipse);
    }
}