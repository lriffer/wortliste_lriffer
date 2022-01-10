package lriffer;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
/**
 * Klasse für ein einziges wort
 * @author Lili Riffer
 * @version 08-11-2021
 */
public class WortEintrag {
	//Attribute
	private String wort;
	private String url;
	/**
	 * konstruktor mit parameter
	 * @param w wort
	 * @param u url
	 */
	public WortEintrag(String w, String u) {
		this.wort = w;
		if(WortEintrag.checkURL(u)==true) {
			this.url = u;	
		}
	}
	/**
	 * setter methode für das wort
	 * @param w wort das übernommen werden soll
	 */
	public void setWort(String w) {
		try {
			if(wort.length() >= 2) {
				this.wort = w;
			}
			else {
				throw new IllegalArgumentException("Das Wort ist zu kurz!");
			}
		}
		catch(IllegalArgumentException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}
	/**
	 * getter methode für wort
	 * @return aktuelles wort
	 */
	public String getWort() {
		return this.wort;
	}
	/**
	 * setter methode für die url
	 * @param u url das übernommen wird
	 */
	public void setUrl(String u) {
		if(checkURL(u) == true) {
			this.url = u;
		}
		else {
			JOptionPane.showMessageDialog(null, "Die dieUrl ist ungültig!");
		}
	}
	/**
	 * getter methode für url
	 * @return aktuelles url
	 */
	public String getUrl() {
		return this.url;
	}
	/**
	 * überschriebene toString methode, sodass
	 * wort und url mit einem semikolon getrennt
	 * werden
	 * @return das fertig zusammengestellte string
	 */
	@Override
	public String toString() {
		return this.wort + ";" + this.url;
	}
	/**
	 * überprüft, ob es eine sinnvolle url ist, wenn
	 * ja, wird true zurückgegeben wenn nicht false
	 * @return ob es sinnvoll ist
	 */
	public static boolean checkURL(String u) {
		if(u==null) {
			NullPointerException exc = new NullPointerException("URL hat nichts drinnen");
			return false;
		}
		else {
			try {
				URL web = new URL(u);
				web.toURI();
				return true;
			} catch(MalformedURLException e) {
				return false;
			} catch(URISyntaxException e) {
				return false;
			}
		}
	}
}
