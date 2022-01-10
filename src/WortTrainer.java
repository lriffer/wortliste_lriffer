package lriffer;
import java.util.*;
/**
 * Klasse für ein worttrainer
 * @author Lili Riffer
 * @version 08-11-2021
 */
public class WortTrainer {
	//Attribute
	private WortListe list;
	private WortEintrag wort;
	private int abfrage, richtig;
	/**
	 * konstruktor 
	 * @param l die liste die man trainieren will
	 */
	public WortTrainer(WortListe l) {
		this.list = l;
	}
	
	
	/**
	 * Zufälliger Worteintrag wird ausgewählt
	 * @return zufälliger worteintrag
	 */
	public WortEintrag zufallsWort() {
		this.wort = this.list.findEintrag(new Random().nextInt(this.list.laenge()));
		return this.wort;
	}
	/**
	 * schaut welcher Worteintrag gerade benutzt wird
	 * @return aktueller worteintrag 
	 */
	public WortEintrag aktuellWort() {
		return wort;
	}
	/**
	 * schaut ob die zwei wörter übereinstimmen
	 * @param w wort welches mit dem aktuellen verglichen wird 
	 * @return ob übereinstimmt oder nicht
	 */
	public boolean check(String w) {
		if(String.valueOf(this.wort).equals(w)) {
			return true;
		}
		return false;
	}
	/**
	 * schaut ob zwei wörter übereinstimmen wobei
	 * groß/kleinschreibung ignoriert wird
	 * @param w das verglichen wird
	 * @return ob übereinstimmt oder nicht
	 */
	public boolean checkIgnoreCase(String w) {
		if(String.valueOf(this.wort).toLowerCase().equals(String.valueOf(w).toLowerCase())) {
			return true;
		}
		return false;
	}
	public void newList(WortListe l){
		this.list = l;
	}
	public void setAbfrage(int x){
		this.abfrage = x;
	}
	public void setRichtig(int x){
		this.richtig = x;
	}
}
