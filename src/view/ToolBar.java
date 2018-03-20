/*
 *TCSS 305 - Winter 2016
 *Assignment 5 - PowerPaint
 */

package view;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

/**
 *The JToolBar that PowerPaint uses to select drawing tools.
 *
 *@author singhp5
 *@version 1.0
 */
public class ToolBar extends JToolBar {

    /**
     *Stores the serial number for this ToolBar.
     */
    private static final long serialVersionUID = 8468360550491997277L;
    
    /**
     *Stores the button group for this ToolBar.
     */
    private final ButtonGroup myButtonGroup;
    
    /**
     * Construct the ToolBar.
     */
    public ToolBar() {
        super();
        myButtonGroup = new ButtonGroup();
    }
    
    /**
     * Create a JToggleButton for the ToolBar.
     * 
     * @param theAction to associate with the created JToggleButton
     */
    public void createToolBarButton(final Action theAction) {
        final JToggleButton toggleButton = new JToggleButton(theAction);
        toggleButton.setMnemonic(theAction.toString().charAt(0));
        myButtonGroup.add(toggleButton);

        add(toggleButton);
        
    }
}