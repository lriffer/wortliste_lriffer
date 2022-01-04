package lriffer;
import java.util.Arrays;

/**
 * Klasse für eine wortliste
 * @author Lili Riffer
 * @version 08-11-2021
 */
public class WortListe {
	private WortEintrag[] wort;
	/**
	 * Konstruktor ohne parameter
	 */
	public WortListe() {
		this.wort = new WortEintrag[0];
	}
	/**
	 * Konstruktor mit parameter
	 * @param maxWoerter maximale 
	 * wörter die gespeichert werden können
	 */
	public WortListe(int maxWoerter) {
		this.wort= new WortEintrag[maxWoerter];
	}
	/**
	 * fügt ein worteintrag dazu
	 * @param a das neue wort
	 * @return true/false, ob es zugefügt wurde
	 */
	public boolean addWort(WortEintrag a) {
		boolean ja = false;
		for(int i = 0; i<wort.length && ja==false; i++) {
			if(this.wort[i] == null) {
				this.wort[i] = a;
				ja = true;
			}
		}
		if(ja==false) {
			this.wort= Arrays.copyOf(this.wort, this.wort.length+1);
			this.wort[this.wort.length-1] = a; 
		}
		return ja;
	}
	/**
	 * gibt den entsprechenden worteintrag zur�ck
	 * @param index index der übernommen wird um
	 * den worteintrag auszugeben
	 * @return den entsprechenden worteintrag 
	 */
	public WortEintrag findEintrag(int index) {
		for(int i=0; i<wort.length ; i++) {
			if(wort[i]!=null) {
				if(i == index) {
					return this.wort[i];
				}
			}
		}
		return this.wort[0];
		
	}
	/**
	 * toString methode, sodass der WortEintrag
	 * als eigene Zeile ausgegeben wird
	 * @return zeile
	 */
	@Override
	public String toString() {
		String list="";
		for(int i = 0 ; i<wort.length ; i++) {
			list= list+ "\n" + this.wort[i];
		}
		return list;
	}
	/**
	 * löscht ein wort
	 * @param w das gelöscht wird
	 * @return ob funktioniert hat
	 */
	public boolean WortDelete(String w) {
		for(int i = 0 ; i<wort.length; i++) {
			if(wort[i]!=null) {
				if(wort[i].equals(w)) {
					wort[i] = null;
					return true;
				}
			}
		}
		return false;
	}
	/**
	 * zeigt die länge
	 * @return länge des arrays
	 */
	public int laenge() {
		return wort.length;
	}
}
