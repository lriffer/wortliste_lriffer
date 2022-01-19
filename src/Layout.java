package lriffer;
import javax.swing.*;
import javax.swing.text.Document;
import java.awt.*;
import java.net.*;

/**
 * Layout
 * @author Lili Riffer
 * @version 2022-1-11
 */
public class Layout extends JPanel {
    // Attribute
    private JButton[] button;
    private Controller control;
    private JLabel[] label;
    private JTextField textfeld;
    private JLabel imageLabel;


    /**
     * Konstruktor Layout
     * @param control die Control
     * @throws MalformedURLException Fehler der URL
     */
    public Layout (Controller control) throws MalformedURLException {
        this.control = control;
        this.setLayout(new BorderLayout());

        this.label = new JLabel[6];
        this.button = new JButton[2];

        ImageIcon icon = new ImageIcon(new URL("https://via.placeholder.com/150C/O%20"));
        Image image = icon.getImage();
        image = image.getScaledInstance(250, 250,  Image.SCALE_SMOOTH);
        this.imageLabel = new JLabel(new ImageIcon(image));
        this.add(this.imageLabel);

        JPanel unten = new JPanel(new GridLayout(2, 3));
        this.label[0] = new JLabel();
        this.label[0].setText("Richtige Woerter: ");
        this.label[1] = new JLabel();
        this.label[1].setText("Anzahl Woerter: ");
        this.label[2] = new JLabel();
        this.label[2].setText("0");
        this.label[3] = new JLabel();
        this.label[3].setText("0");
        this.button[0] = new JButton("Zuruecksetzen");
        this.button[1] = new JButton("Wort hinzufuegen");
        unten.add(this.label[0]);
        unten.add(this.label[2]);
        unten.add(this.button[0]);
        unten.add(this.label[1]);
        unten.add(this.label[3]);
        unten.add(this.button[1]);
        this.add(unten, BorderLayout.PAGE_END);

        JPanel oben = new JPanel(new GridLayout(2, 1));
        this.label[4] = new JLabel();
        this.label[4].setText("Welches Wort wird hier dargestellt?");
        this.textfeld = new JTextField();
        this.textfeld.setActionCommand("textfeld");
        oben.add(this.label[4]);
        oben.add(this.textfeld);
        this.add(oben, BorderLayout.PAGE_START);

        this.button[0].addActionListener(this.control);
        this.button[1].addActionListener(this.control);
        this.textfeld.addActionListener(this.control);


    }

    /**
     * (De)aktiviert das Textfeld
     * @param feld das Feld(true oder false)
     */
    public void enableTextfeld(boolean feld) {
        this.textfeld.setEnabled(feld);
    }

    /**
     * Zeit die Statistik an
     * @param x Statistik1
     * @param y Statistik2
     */
    public void statistik (int x, int y) {
        this.label[2].setText(String.valueOf(x));
        this.label[3].setText(String.valueOf(y));
    }

    /**
     * Getter-Methode vom Inhalt des Textfelds
     * @return Inhalt des Textfeld
     */
    public String getTf () {
        return this.textfeld.getText();
    }

    /**
     * Ändert das Bild
     * @param url url vom Bild
     * @throws MalformedURLException bei url fehler
     */
    public void changePic (String url) throws MalformedURLException {
        ImageIcon icon = new ImageIcon(new URL(url));
        Image image = icon.getImage();
        image = image.getScaledInstance(250, 250,  Image.SCALE_SMOOTH);
        this.imageLabel.setIcon(new ImageIcon(image));
        this.add(this.imageLabel);

    }


    /**
     * Cleared das Textfeld
     */
    public void clearTextFeld () {
        this.textfeld.setText("");
    }
}