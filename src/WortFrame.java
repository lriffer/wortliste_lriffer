package lriffer;
import java.awt.*;
import javax.swing.*;

/**
 * Frame Klasse
 * @author Lili Riffer
 * @version 09-01-2022
 */
public class WortFrame extends JFrame {
    /**
     * Konstruktor
     * @param t Titel
     * @param l Layout das verwendet wird
     * @param c Controller welches verwendet wird
     */
    public WortFrame (String t, JPanel l, WortControll c){
        super(t);
        this.add(l);

        JMenuBar menuBar = new JMenuBar();
        JMenu m = new JMenu("Datei:");
        JMenuItem speicher = new JMenuItem("speichern");
        JMenuItem lade = new JMenuItem("laden");
        WortControll controll = c;

        menu.add(speicher);
        menu.add(lade);
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