/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.eni.gui;

import com.alee.laf.WebLookAndFeel;
import java.awt.Dimension;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author User
 */
public class App {
 
    public static void main(String[] args) {

        // Set cross-platform Java L&F (also called "Metal")
        WebLookAndFeel.install();
        
        JFrame frame = new JFrame(); 
        
        frame.setMinimumSize(new Dimension(800, 600));

        CSVPanel panel = new CSVPanel();
        panel.setVisible(true);

        frame.add(panel);
        frame.setTitle("Démonstration Java Swing - Java avec NetBeans (Éditions ENI)");
        frame.setVisible(true);
        final URL icon = App.class.getResource("/fr/eni/gui/eni-icon.png");
        frame.setIconImage(new ImageIcon(icon).getImage());

    }

}
