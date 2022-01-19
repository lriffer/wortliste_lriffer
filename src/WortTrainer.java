package lriffer;

/**
 * WortTrainer
 * @author Lili Riffer
 * @version 2022-1-11
 */
public class WortTrainer {
	private WortListe liste;
	private WortEintrag aktuell;
	private int abgefragtC, abgefragt, richtigC, richtig;

	/**
	 * Konstruktor
	 * @param liste Wortliste
	 */
	public WortTrainer (WortListe liste) {
		this.liste = liste;
		this.abgefragt = 0;
		this.richtig = 0;
	}

	/**
	 * W�hlt ein zufälliges Wort aus
	 * @return zufälliges Wort
	 */
	public WortEintrag zufaelligesWort () {

		int laenge = this.liste.getEintraegeLenght();
		int i = (int)(Math.random() * laenge);

		this.aktuell = this.liste.getWortEintrag(i);

		return this.aktuell;
	}

	/**
	 * Gibt dem WortTrainer eine neue WortListe
	 * @param l neue Liste
	 */
	public void neueListe (WortListe l) {
		this.liste = l;
	}

	/**
	 * Getter-Methode:aktuell
	 * @return aktueller eintrag
	 */
	public WortEintrag getAktuell() {
		return this.aktuell;
	}

	/**
	 * Getter-Methode: Liste
	 * @return liste
	 */
	public WortListe getListe () {
		return this.liste;
	}

	/**
	 * überprüft das Wort, beachtet Groß-/Kleinschreibung
	 * @param wort wort
	 * @return true/false
	 */
	public boolean check (String wort) {
		boolean wf = false;
		this.abgefragt++;
		if (this.aktuell.getWort().equals(wort) == true) {
			wf = true;
			this.richtig++;
		}

		return wf;
	}

	/**
	 * überprüft das Wort, beachtet Groß-/Kleinschreibung nicht
	 * @param wort wort
	 * @return true/false
	 */
	public boolean checkIgnoreCase (String wort) {
		boolean wf = false;
		this.abgefragtC++;
		if (this.aktuell.getWort().toLowerCase().equals(wort.toLowerCase()) == true) {
			wf = true;
			this.richtigC++;
		}

		return wf;
	}

	/**
	 * Setter-Methode für abgefragt
	 * @param x neuer Wert
	 */
	public void setAbgefragt (int x) {
		this.abgefragt = x;
	}

	/**
	 * Setter-Methode für richtig
	 * @param x neuer Wert
	 */
	public void setRichtig (int x) {
		this.richtig = x;
	}

	/**
	 * Getter-Methode für abgefragt
	 * @return abgefragt
	 */
	public int getAbgefragt () {
		return this.abgefragt;
	}

	/**
	 * Getter-Methode für richtig
	 * @return richtig
	 */
	public int getRichtig () {
		return this.richtig;
	}

	public String statistik () {
		String statistik = "Abgefragt mit Groß-/Kleinschreibung: " + this.abgefragt + "\n Korrekte Rechtschreibung: " + this.richtig +
				"\n \n Abgefragt ohne Groß-/Kleinschreibung: " + this.abgefragtC + "\n Korrekte Rechtschreibung: " + this.richtigC;

		return statistik;
	}


}
