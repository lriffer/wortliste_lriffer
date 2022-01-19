package lriffer;
import java.awt.*;
import javax.swing.*;

/**
 * Frame
 * @author Lili Riffer
 * @version 2022-1-11
 */
public class Frame extends JFrame {
    /**
     * KOnstruktor vom Frame
     * @param titel der Titel
     * @param layoutPanel das Layout
     * @param control das Control
     */
    public Frame (String titel, JPanel layoutPanel, Controller control) {
        super(titel);
        this.add(layoutPanel);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Datei");
        JMenuItem speichern = new JMenuItem("speichern");
        JMenuItem laden = new JMenuItem("laden");
        Controller controller = control;

        menu.add(speichern);
        menu.add(laden);
        menuBar.add(menu);

        speichern.setActionCommand("speichern");
        speichern.addActionListener(controller);
        laden.setActionCommand("laden");
        laden.addActionListener(controller);

        this.setJMenuBar(menuBar);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
}
