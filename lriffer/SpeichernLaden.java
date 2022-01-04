/**
 * 
 */
package lriffer;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;
/**
 * Speichert und Lädt Worttrainer
 * @author Lili Riffer
 * @version 2021-11-29
 */
public class SpeichernLaden {
	private WortListe liste;
	private int versuch;
	private int wvRichtig;
	
	
	/**
	 * Konstruktor mit parameter
	 * @param l liste
	 * @param v versuche
	 * @param wvr wie viele richtig sind
	 */
	public SpeichernLaden(WortListe l, int v, int wvr) {
		this.liste = l;
		this.versuch= v;
		this.wvRichtig = wvr;
	}
	
	
	/**
	 * getter methode für versuch
	 * @return wie viele versuche man noch hat
	 */
	public int getVersuch() {
		return this.versuch;
	}
	/**
	 * getter methode für richtig
	 * @return wie viele antworten richtig sind
	 */
	public int getWvRichtig() {
		return this.wvRichtig;
	}
	
	
	/**
	 * speichert das ergebnis in einem file, wessen name angegeben werden kann
	 * @param filename wie der file heißen soll
	 * @throws IOException falls etwas nicht gespeichert werden kann
	 */
	public void speichern(String filename) throws IOException{
		File f = new File(filename);
		FileWriter outputstream = null;
		try {
			outputstream = new FileWriter(f);
			outputstream.write("Versuche: "+this.versuch);
			outputstream.write(System.lineSeparator());
			outputstream.write("Anzahl der richtigen Antworten: "+this.wvRichtig);
			outputstream.write(System.lineSeparator());
			outputstream.write(liste.toString());
		}
		catch (IOException e){
			JOptionPane.showMessageDialog(null, "Fehler beim Speichern von: "+e);
		}
		finally {
			if(outputstream != null) {
				outputstream.close();
			}
		}
	}
	/**
	 * speichert das ergebnis in einem file, hat aber schon einen namen und kann nicht angegeben werden
	 * @throws IOException falls etwas nicht gespeichert werden kann
	 */
	public void speichern() throws IOException{
		File f = new File("C:\\Users\\Win10\\Desktop\\Schule\\3. Jahrgang\\1. Sem\\sew\\Worttrainer.txt");
		FileWriter outputstream = null;
		try {
			outputstream = new FileWriter(f);
			outputstream.write("Versuche: "+this.versuch);
			outputstream.write(System.lineSeparator());
			outputstream.write("Anzahl der richtigen Antworten: "+this.wvRichtig);
			outputstream.write(System.lineSeparator());
			outputstream.write(liste.toString());
		}
		catch (IOException e){
			JOptionPane.showMessageDialog(null, "Fehler beim Speichern von: "+e);
		}
		finally {
			if(outputstream != null) {
				outputstream.close();
			}
		}
	}
	
	
	/**
	 * Lädt die datei mit einem übernommenen speicherort
	 * @param filename Filename wird übergeben
	 * @throws IOException
	 */
	public void laden(String filename) throws IOException {
		if(new File(filename).exists()) {
			try(Scanner scan = new Scanner(new BufferedReader(new FileReader(filename)))) {
				if(scan.hasNext()) {
					this.versuch = Integer.parseInt(scan.next());
				}
				if(scan.hasNext()) {
					this.wvRichtig = Integer.parseInt(scan.next());
				}
			}
			catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Fehler beim Lesen: " + e.toString());
			}
		}
	}
	/**
	 * Lädt die datei mit einem angegebenen speicherort
	 * @throws IOException
	 */
	public void laden() throws IOException {
		if(new File("C:\\Users\\Win10\\Desktop\\Schule\\3. Jahrgang\\1. Sem\\sew\\Worttrainer.txt").exists()) {
			try(Scanner scan = new Scanner(new BufferedReader(new FileReader("C:\\Users\\Win10\\Desktop\\Schule\\3. Jahrgang\\1. Sem\\sew\\Worttrainer.txt")))) {
				if(scan.hasNext()) {
					this.versuch = Integer.parseInt(scan.next());
				}
				if(scan.hasNext()) {
					this.wvRichtig = Integer.parseInt(scan.next());
				}
			}
			catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Fehler beim Lesen: " + e.toString());
			}
		}
	}
	/**
	 * Hier werden die Versuche und die Anzahl der Richtigen Antworten zurückgegeben.
	 * @param dieVersuche
	 * @param wievieleRichtig
	 */
	public void update(int dieVersuche, int wievieleRichtig) {
		this.versuch = dieVersuche;
		this.wvRichtig = wievieleRichtig;
	}
}
