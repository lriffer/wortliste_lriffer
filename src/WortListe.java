package lriffer;

/**
 * WortListe
 * @auhtor Lili Riffer
 * @version 2022-1-11
 */
public class WortListe {
	private WortEintrag[] eintraege;

	/**
	 * Konstruktor
	 */
	public WortListe() {
		this.eintraege = new WortEintrag[0];
	}

	/**
	 * Fügt ein neues Wort hinzu, Array wird jedes mal um 1 vergrößert
	 * @param wort wort
	 * @param url url
	 */
	public void neuesWort (String wort, String url) {
		WortEintrag[] tmp = new WortEintrag[this.eintraege.length + 1];         // Temp. array erstellen und um 1 vergr��ern

		// Wenn länge 0 ist dann direkt hinzufügen
		if (this.eintraege.length == 0) {
			tmp[0] = new WortEintrag();
			tmp[0].setWort(wort);
			// Exception handeln...
			try {
				tmp[0].setUrl(url);
			} catch (WrongStringException exc) {
				String msg = exc.getMessage();
				System.err.println("WrongStringException: " + msg + "\n");
			}
		} else {
			// Das array kopieren und in tmp speichern
			for(int i = 0; i < this.eintraege.length; i++) {
				if (this.eintraege[i] != null) {
					tmp[i] = this.eintraege[i];
				}
			}
			// Mit den Werten bef�llen
			tmp[this.eintraege.length] = new WortEintrag();
			tmp[this.eintraege.length].setWort(wort);
			// Exception handeln...
			try {
				tmp[this.eintraege.length].setUrl(url);
			} catch (WrongStringException exc) {
				String msg = exc.getMessage();
				System.err.println("WrongStringException: " + msg + "\n");
			}
		}
		this.eintraege = tmp;
	}

	/**
	 * Löscht einen Eintrag
	 * @param index index
	 * @throws IndexOutOfBoundsException Falls Index nicht gültig ist
	 */
	public void deleteWortEintrag (int index) throws IndexOutOfBoundsException {
		if (index < 0 || index > this.eintraege.length -1) {
			IndexOutOfBoundsException exc = new IndexOutOfBoundsException();
			throw exc;
		} else {
			this.eintraege[index] = null;
		}
	}

	/**
	 * Gibt einen Worteintrag zurück
	 * @param index index vom worteintrag
	 * @return worteintrag
	 * @throws IndexOutOfBoundsException Index falsch
	 */
	public WortEintrag getWortEintrag (int index) throws IndexOutOfBoundsException {
		if (index < 0 || index > this.eintraege.length - 1) {
			IndexOutOfBoundsException exc = new IndexOutOfBoundsException();
			throw exc;
		} else {
			return this.eintraege[index];
		}
	}

	/**
	 * Gibt Länge von den Worteinträgen zurück
	 * @return l�nge
	 */
	public int getEintraegeLenght () {
		return this.eintraege.length;
	}

	/**
	 * Worteinträge als String
	 * @return String-Literal
	 */
	@Override
	public String toString () {
		String woerter = "";
		for (int i = 0 ; i < this.eintraege.length ; i++) {
			if (this.eintraege[i] != null) {
				woerter = woerter + this.eintraege[i].toString() + "\n";
			}
		}

		return woerter;
	}
}
