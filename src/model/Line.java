/*
 *TCSS 305 - Winter 2016
 *Assignment 5 - PowerPaint
 */

package model;

import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;

import javax.swing.JPanel;

/**
 *This class will draw a line.
 *
 *@author Prabhjot Singh
 *@version 2/12/16
 */
public class Line extends AbstractTool {
    
    /**
     *Stores the path created by this tool.
     */
    private Line2D myLine;
    
    /**
     *Constructs the line tool.
     *
     *@param thePanel The panel this tool will draw on.
     */
    public Line(final JPanel thePanel) {
        super(thePanel);
    }

    @Override 
    public void mousePressed(final MouseEvent theEvent) {
        myLine = new Line2D.Double(theEvent.getPoint(), theEvent.getPoint());

        myPanel.renderShape(myLine);
    }
    
    @Override
    public void mouseDragged(final MouseEvent theEvent) {
        myLine.setLine(myLine.getX1(), myLine.getY1(), theEvent.getX(), theEvent.getY());

        myPanel.renderShape(myLine);

    }
    
    @Override
    public void mouseReleased(final MouseEvent theEvent) {
        myLine.setLine(myLine.getX1(), myLine.getY1(), theEvent.getX(), theEvent.getY());
        myPanel.renderShape(myLine);
        myPanel.addShape(myLine);
    }
}