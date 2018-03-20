/*
 *TCSS 305 - Winter 2016
 *Assignment 5 - PowerPaint
 */

package view;

import java.awt.EventQueue;

/**
 *Starts the GUI.
 *
 *@author singhp5
 *@version 1.0
 */
public final class PowerPaintMain {

    /**
     *Protects this class from instantiation.
     */
    private PowerPaintMain() {

    }

    /**
     *Constructs the main GUI window frame.
     * 
     *@param theArgs is used for command line arguments.
     */
    public static void main(final String... theArgs) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PowerPaintGUI();     
            }
        });
    }
}