package lriffer;
import java.awt.*;
import javax.swing.*;
import java.net.*;
import javax.swing.text.Document;

/**
 * Layout Klasse
 * @author Lili Riffer
 * @version 09-01-2022
 */
public class WortLayout extends JPanel{
    //Attribute
    private JButton[] buttons;
    private Controller control;
    private JLabel[] labels;
    private JTectField field;
    private JLabel img;

    /**
     * Konstruktor
     * @param c Controller vom MVC
     * @throws MalformedURLException falls fehlerhafter URL vorkommt
     */
    public WortLayout(WortControll c) throws MalformedURLException{
        this.control = c;
        this.setLayout(new BorderLayout());

        this.labels = new JLabel[6];
        this.buttons = new JButton[2];

        ImageIcon icon = new ImageIcon(new URL("https://d34ip4tojxno3w.cloudfront.net/app/uploads/placeholder.jpg"));
        Image image = icon.getImage();
        image = image.getScaledInstance(250,250, Image.Scale_SMOOTH);
        this.img = new JLabel(new ImageIcon(image));
        this.add(this.img);

        JPanel u = new JPanel(new GridLayout(2,3));
        this.labels[0] = new JLabel();
        this.labels[1] = new JLabel();
        this.labels[2] = new JLabel();
        this.labels[3] = new JLabel();

        this.labels[0].setText("Richtige Wörter: ");
        this.labels[1].setText("Anzahl Wörter: ");
        this.labels[2].setText("0");
        this.labels[3].setText("0");

        this.button[0] = new JButton("Zurücksetzen");
        this.button[0] = new JButton("Wort hinzufügen");

        u.add(this.labels[0]);
        u.add(this.labels[2]);
        u.add(this.buttons[0]);
        u.add(this.labels[1]);
        u.add(this.labels[3]);
        u.add(this.buttons[1]);
        this.add(u, BorderLayout.PAGE_END);

        JPanel o = new JPanel(new GridLayout(2,1));
        this.labels[4] = new JLabel();
        this.labels[4].setText("Welches Wort wird hier dargestellt?");
        this.field = new JTextField();
        this.field.setActionCommand("field");
        o.add(this.labels[4]);
        o.add(this.field);
        this.add(o, BorderLayout.PAGE_START);

        this.buttons[0].addActionListener(this.control);
        this.buttons[1].addActionListener(this.control);
        this.field.addActionListener(this.control);
    }

    /**
     * Deaktiviert/aktiviert das feld
     * @param f true/false ob enabled oder disabled sein soll
     */
    public void enableFeld(boolean f){
        this.field.setEnabled(f);
    }

    /**
     * zeigt die punkte an
     * @param x richtige wörter
     * @param y anzahl wörter
     */
    public void statistik (int x, int y){
        this.labels[2].setText(String.valueOf(x));
        this.labels[3].setText(String.valueOf(x));
    }

    /**
     * getter für inhalt des feldes
     * @return inhalt
     */
    public String getField(){
        return this.field.getText();
    }

    /**
     * Ändert image
     * @param url des images
     * @throws MalformedURLException bei falschen url
     */
    public void changeIMG(String url) throws MalformedURLException{
        ImageIcon icon = new ImageIcon(new URL(url));
        Image i = icon.getImage();
        i = i.getScaledInstance(250,250, Image.SCALE_SMOOTH);
        this.img.setIcon(new ImageIcon(i));
        this.add(this.img);
    }

    /**
     * löscht inhalt des feldes
     */
    public void clearField(){
        this.field.setText("");
    }
}