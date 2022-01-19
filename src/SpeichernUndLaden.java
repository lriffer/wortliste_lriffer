package lriffer;
import java.io.*;
import java.util.Arrays;

/**
 * Speichern und Laden
 * @author Lili Riffer
 * @version 2022-1-11
 */
public class SpeichernUndLaden {


	/**
	 * Kann den WortTrainer in einer txt-Datei speichern, Pfad wird als Parameter angegeben
	 *
	 * @param filename filepfad
	 * @param wt       WortTrainer
	 * @param wl       WortListe
	 * @throws IOException Falls pfad falsch ist
	 */
	public static void speichern(String filename, WortTrainer wt, WortListe wl) throws IOException {
		File f = new File(filename);
		FileWriter outputStream = null;
		WortTrainer trainer = wt;
		WortListe liste = wl;
		try {
			outputStream = new FileWriter(f);

			outputStream.write("Worttrainer");
			outputStream.write(System.lineSeparator());
			outputStream.write("-----------");
			outputStream.write(System.lineSeparator());
			outputStream.write("WortListe");
			outputStream.write(System.lineSeparator());
			outputStream.write("-----------");
			outputStream.write(System.lineSeparator());
			outputStream.write(String.valueOf(wl.getEintraegeLenght()));
			outputStream.write(System.lineSeparator());

			for (int i = 0; i < wl.getEintraegeLenght(); i++) {
				outputStream.write("WortEintrag");
				outputStream.write(System.lineSeparator());
				outputStream.write("-----------");
				outputStream.write(System.lineSeparator());
				outputStream.write(wl.getWortEintrag(i).toString());
				outputStream.write(System.lineSeparator());
			}

		} finally {
			if (outputStream != null) {
				outputStream.close();
			}
		}
	}


	/**
	 * Speichert WortTrainer in txt-Datei; Pfad ist vorgegeben
	 *
	 * @param wt WortTrainer
	 * @param wl WortListe
	 * @throws IOException Falls Pfad falsch ist
	 */
	public static void speichern(WortTrainer wt, WortListe wl) throws IOException {
		File f = new File("C:\\Users\\asus\\Desktop\\TGM 5 Semester\\SEW\\5a.3\\Text\\x.txt");
		FileWriter outputStream = null;
		WortTrainer trainer = wt;
		WortListe liste = wl;
		try {
			outputStream = new FileWriter(f);

			outputStream.write("[WortTrainer]");
			outputStream.write(System.lineSeparator());
			outputStream.write("[WortListe]");
			outputStream.write(System.lineSeparator());
			outputStream.write(String.valueOf(wl.getEintraegeLenght()));
			outputStream.write(System.lineSeparator());
			for (int i = 0; i < wl.getEintraegeLenght(); i++) {
				outputStream.write("[WortEintrag]");
				outputStream.write(System.lineSeparator());
				outputStream.write(wl.getWortEintrag(i).toString());
				outputStream.write(System.lineSeparator());
			}

		} finally {
			if (outputStream != null) {
				outputStream.close();
			}
		}
	}


	/**
	 * Kann einen WortTrainer Laden, Pfad wird als Parameter �bergeben
	 *
	 * @param filename Dateipfad
	 * @return WortTrainer
	 * @throws IOException Falls Pfad falsch ist
	 */
	public static WortTrainer laden(String filename) throws IOException {
		WortListe wl = new WortListe();
		String[] wtA = new String[0];
		String x;

		// BufferedReader erstellen
		try (BufferedReader inputStream = new BufferedReader(new FileReader(filename))) {
			int i = 0;
			// Solange die Zeile nicht null ist, Zeile in wt speichern
			while ((x = inputStream.readLine()) != null) {
				wtA = Arrays.copyOf(wtA, wtA.length + 1);
				wtA[i] = x;
				i++;

			}
		}

		for (int j = 0; j < wtA.length; j++) {
			if (wtA[j].equals("[WortEintrag]")) {
				wl.neuesWort(wtA[j + 1], wtA[j + 2]);
			}
		}

		WortTrainer wt = new WortTrainer(wl);

		return wt;
	}

	/**
	 * L�dt den WortTrainer; Pfad ist vorgegeben
	 *
	 * @return WortTrainer
	 * @throws IOException Falls Pfad falsch ist
	 */
	public static WortTrainer laden() throws IOException {
		WortListe wl = new WortListe();
		String[] wtA = new String[0];
		String x;

		try (BufferedReader inputStream = new BufferedReader(new FileReader("C:\\Users\\asus\\Desktop\\TGM 5 Semester\\SEW\\5a.3\\Text\\x.txt"))) {
			int i = 0;
			// Solange die Zeile nicht null ist, Zeile in wt speichern
			while ((x = inputStream.readLine()) != null) {
				wtA = Arrays.copyOf(wtA, wtA.length + 1);
				wtA[i] = x;
				i++;

			}
		}

		for (int j = 0; j < wtA.length; j++) {
			if (wtA[j].equals("[WortEintrag]")) {
				wl.neuesWort(wtA[j + 1], wtA[j + 2]);
			}
		}

		WortTrainer wt = new WortTrainer(wl);

		return wt;
	}
}
