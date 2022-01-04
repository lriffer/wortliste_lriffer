/**
 * 
 */
package lriffer;
import javax.swing.*;
import java.io.IOException;

/**
 * Testet alle Worttrainer Methoden
 * @author Lili Riffer
 * @version 08-11-2021
 */
public class WortTrainerMain{
	public static void main(String[] args) throws IOException {
		String url ="https://elearning.tgm.ac.at";
		WortListe l = new WortListe();
		WortEintrag e = new WortEintrag("Elearning", url);
		WortEintrag ei = new WortEintrag("Hund", "https://img.welt.de");
		WortEintrag e1 = new WortEintrag("elearning", url);
		WortEintrag ei1 = new WortEintrag("Hase", "https://img.welt.de");
		WortEintrag e2 = new WortEintrag("hallo", url);
		WortEintrag ei2 = new WortEintrag("Katze", "https://img.welt.de");
		l.addWort(e);
		l.addWort(ei);
		l.addWort(e1);
		l.addWort(ei1);
		l.addWort(e2);
		l.addWort(ei2);
		if(e.checkURL(url)==false) {
			System.out.println("URL ist nicht sinnvoll");
		}else {
			System.out.println(e.toString());
		}
		WortTrainer t = new WortTrainer(l);
		boolean a = l.WortDelete("vlt");
		boolean b = t.check("hund");
		boolean c = t.checkIgnoreCase("ELEarNinG");
		int versuch = Integer.parseInt(JOptionPane.showInputDialog(null, "Wie viele Versuche soll man haben?"));
		int richtig = 0;
		SpeichernLaden sl = new SpeichernLaden(l, versuch, richtig);
		sl.update(versuch, richtig);
		sl.speichern();
		System.out.println("WortListe, GesuchtesWort: "+l.findEintrag(0)+"\nKonnt ich das wort \"vlt\" löschen? "+a+"\nWorttrainer; zufälliges Wort: "+t.zufallsWort()+"\nAktuelles Wort: "+t.aktuellWort()+"\nIst dieses Wort in der Liste? "+b+"\nDasselbe, es ignoriert aber die groß/kleinschreibung: "+c );
	}
}
