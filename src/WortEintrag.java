package lriffer;
/**
 * Worteintrag
 * @author Lili Riffer
 * @version 2022-1-11
 */
public class WortEintrag {
	private String wort;
	private String url;

	/**
	 * Kontruktor
	 * @param wort Wort
	 * @param url Url
	 * @throws IllegalArgumentExceptio Falls Url ungültig ist
	 */
	public WortEintrag (String wort, String url) throws IllegalArgumentException {
		this.wort = wort;
		if (WortEintrag.checkURL(url) == false) {
			IllegalArgumentException exc = new IllegalArgumentException();
			throw exc;
		} else {
			this.url = url;
		}

	}

	/**
	 * Konstruktor ohne Parameter
	 */
	public WortEintrag() {

	}

	/**
	 * überprüft, ob eine Url gültig ist (nur das Format wird getestet)
	 * @param urlTmp Url mit groß/klein schreibung
	 * @return true/false
	 */
	public static boolean checkURL (String urlTmp) {
		boolean wf = false;
		boolean wf2 = false;
		String url = urlTmp.toLowerCase();
		String tmp = "", tmp2 = "";
		char b1, b2, b3, b4;
		int index1 = 0, index2 = 0;

		// �berpr�fen auf http:// oder https://
		if(url.substring(0, 7).equals("http://") || url.substring(0, 8).equals("https://")) {
			// Case https: Buchstaben vom 1. - 2. Punkt als Substring speichern
			for (int i = 9 ; url.charAt(i) != '.' ; i++) {
				tmp = tmp + url.charAt(i);
			}
			// Case http: Buchstaben vom 1. - 2. Punkt als Substring speichern
			for (int i = 8 ; url.charAt(i) != '.' ; i++) {
				tmp2 = tmp2 + url.charAt(i);
			}

			// �berpr�fen, ob der substring danach aus mehreren buchstaben besteht
			if (tmp.length() > 3 || tmp2.length() > 3) {
			}

			for (int i = 0 ; i < url.length() ; i++) {
				if (url.charAt(i) == '.') {
					wf = true;
					break;
				}
			}

		}

		return wf;
	}

	/**
	 * Setter-Methode: Wort
	 * @param wort Wort
	 */
	public void setWort (String wort) {
		this.wort = wort;
	}

	/**
	 * Setter-Methode: Url
	 * @param url url
	 * @throws WrongStringException Falls die url ungültig ist
	 */
	public void setUrl (String url) throws WrongStringException {
		if (WortEintrag.checkURL(url) == false) {
			WrongStringException exc = new WrongStringException("Keine g�ltige URL!");
			throw exc;
		} else {
			this.url = url;
		}

	}

	/**
	 * Getter-Methode: Wort
	 * @return wort
	 */
	public String getWort() {
		return this.wort;
	}

	/**
	 * Getter-Methode: url
	 * @return url
	 */
	public String getUrl() {
		return this.url;
	}

	/**
	 * toString methode
	 * @return Worteinträge als String
	 */
	@Override
	public String toString () {
		return new String(this.wort + "\n" + this.url);
	}
}
