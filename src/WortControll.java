package lriffer;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;

/**
 * Controller
 * @author lili Riffer
 * @version 2022-1-11
 */
public class Controller implements ActionListener {
    private Frame frame;
    private Layout layout;
    private WortTrainer wortTrainer;
    private WortListe wortListe;
    private WortEintrag aktuellerEintrag;
    public Controller () throws MalformedURLException {
        this.layout = new Layout(this);
        this.wortListe = new WortListe();

        this.wortTrainer = new WortTrainer(wortListe);
        this.frame = new Frame("WortTrainer", this.layout, this);
        this.aktuellerEintrag = new WortEintrag();

        this.layout.enableTextfeld(false);
    }
    /**
     * ActionHandler
     * @param e ActionEvent
     */
    @Override
    public void actionPerformed (ActionEvent e) {
        String ac = e.getActionCommand();
        String wort, url;
        if (ac.equals("Zuruecksetzen")) {
            for (int i = 0 ; i < this.wortListe.getEintraegeLenght() ; i++) {
                this.wortListe.deleteWortEintrag(i);
            }
            this.wortTrainer.neueListe(this.wortListe);

            this.wortTrainer.setAbgefragt(0);
            this.wortTrainer.setRichtig(0);
            this.layout.statistik(0, 0);
            this.layout.enableTextfeld(false);

        } else if (ac.equals("Wort hinzufuegen")) {
            try {
                wort = JOptionPane.showInputDialog(null, "Das neue Wort");
                url = JOptionPane.showInputDialog(null, "Die URL für das neue Wort");

                this.wortListe.neuesWort(wort, url);
                this.wortTrainer.neueListe(this.wortListe);

                this.layout.enableTextfeld(true);

                if (this.wortListe.getEintraegeLenght() == 1) {
                    this.aktuellerEintrag = this.wortTrainer.zufaelligesWort();
                    this.layout.changePic(this.aktuellerEintrag.getUrl());
                }
                System.out.println(this.wortListe.getEintraegeLenght());
            } catch (NullPointerException m) {
                m = new NullPointerException();
                System.err.println("Fenster geschlossen: " + m.getMessage());
            } catch (MalformedURLException m) {
                m = new MalformedURLException();
                JOptionPane.showMessageDialog(null, "Fehler vom URL: " + m);
            }

        } else if (ac.equals("textfeld")) {
            this.wortTrainer.check(this.layout.getTf());
            this.layout.statistik(this.wortTrainer.getRichtig(), this.wortTrainer.getAbgefragt());

            this.aktuellerEintrag = this.wortTrainer.zufaelligesWort();
            try {
                this.layout.changePic(this.aktuellerEintrag.getUrl());
            } catch (MalformedURLException m) {
                m = new MalformedURLException();
                JOptionPane.showMessageDialog(null, "Fehler vom URl: " + m);
            }

            this.layout.clearTextFeld();

        } else if (ac.equals("laden")) {
            try {
                String input = JOptionPane.showInputDialog(null, "Pfad eingeben");
                this.wortTrainer = SpeichernUndLaden.laden(input);

                this.wortTrainer.setRichtig(0);
                this.wortTrainer.setAbgefragt(0);
                this.layout.statistik(this.wortTrainer.getRichtig(), this.wortTrainer.getAbgefragt());
                if (this.wortTrainer.getListe().getEintraegeLenght() > 0) {
                    this.aktuellerEintrag = this.wortTrainer.zufaelligesWort();
                    this.layout.changePic(this.aktuellerEintrag.getUrl());
                }
                this.layout.enableTextfeld(true);
            } catch (IOException m) {
                m = new IOException();
                System.err.println("IOE-Exception: " + m.getMessage());
            }
        } else  if(ac.equals("speichern")) {
            try {
                String input = JOptionPane.showInputDialog(null, "Pfad eingeben");
                SpeichernUndLaden.speichern(input, this.wortTrainer, this.wortListe);
            } catch (IOException mg) {
                mg = new IOException();
                System.err.println("IOE-Exception: " + mg.getMessage());
            }
        }
    }

    public static void main (String[] args) {
        try {
            new Controller();
        } catch (MalformedURLException m) {
            String message = m.getMessage();
            JOptionPane.showMessageDialog(null, "Falsche URL: " + message + "\n");
        }

    }
}
