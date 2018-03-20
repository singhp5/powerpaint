/*
 *TCSS 305 - Winter 2016
 *Assignment 5 - PowerPaint
 */

package model;



import java.awt.event.MouseEvent;
import java.awt.geom.Path2D;

import javax.swing.JPanel;

/**
 *This class will draw a line wherever the users mouse is dragged.
 *
 *@author singhp5
 *@version 1.0
 */
public class Pencil extends AbstractTool {   

    /**
     * Path this tool will draw.
     */    
    private Path2D myPath;

    /**
     *This creates a pencil tool.
     *
     *@param thePanel The panel this tool will draw on.
     */
    public Pencil(final JPanel thePanel) {
        super(thePanel);
    }

    @Override
    public void mousePressed(final MouseEvent theEvent) {
        myPath = new Path2D.Double();
        myPath.moveTo(theEvent.getX(), theEvent.getY());
        myPanel.renderShape(myPath);        
    }

    @Override 
    public void mouseDragged(final MouseEvent theEvent) {
        myPath.lineTo(theEvent.getX(), theEvent.getY());
        myPanel.renderShape(myPath);
    }

    @Override
    public void mouseReleased(final MouseEvent theEvent) {
        myPath.moveTo(theEvent.getX(), theEvent.getY());
        myPath.closePath();
        myPanel.addShape(myPath);   
    }
}