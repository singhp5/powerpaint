/*
 *TCSS 305 - Winter 2016
 *Assignment 5 - PowerPaint
 */


package model;

import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

import view.PaintDrawPanel;

/**
 *This class will control all methods that the tools share.
 *
 *@author Singhp5
 *@version 1.0
 */
public abstract class AbstractTool extends MouseInputAdapter implements Tool  {
    
    /**
     *Stores the panel this tool draws on.
     */
    protected PaintDrawPanel myPanel;
    
    /**
     *This method will construct a new tool object.
     *
     *@param thePanel The panel this tool will draw on.
     */
    protected AbstractTool(final JPanel thePanel) {
        super();
        myPanel = (PaintDrawPanel) thePanel;
    }
    
    /**
     *Returns the name of this drawing tool.
     *
     *@return Name of the class.
     */
    public String getName() {
        return getClass().getSimpleName();
    }
    
    /**
     *Gives the file name for this tool's image.
     *
     *@return File name of this tool.
     */
    public String getImageFile() {
        return getClass().getSimpleName().toLowerCase() + "_bw.gif";
    }
}