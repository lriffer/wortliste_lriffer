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
	/**
	 * konstruktor 
	 * @param l die liste die man trainieren will
	 */
	public WortTrainer(WortListe l) {
		this.list = l;
	}
	
	
	/**
	 * Zuf�lliger Worteintrag wird ausgew�hlt
	 * @return zuf�lliger worteintrag 
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
	 * schaut ob die zwei w�rter �bereinstimmen
	 * @param w wort welches mit dem aktuellen verglichen wird 
	 * @return ob �bereinstimmt oder nicht
	 */
	public boolean check(String w) {
		if(String.valueOf(this.wort).equals(w)) {
			return true;
		}
		return false;
	}
	/**
	 * schaut ob zwei w�rter �bereinstimmen wobei 
	 * gro�/kleinschreibung ignoriert wird
	 * @param w das verglichen wird
	 * @return ob �bereinstimmt oder nicht
	 */
	public boolean checkIgnoreCase(String w) {
		if(String.valueOf(this.wort).toLowerCase().equals(String.valueOf(w).toLowerCase())) {
			return true;
		}
		return false;
	}
}
