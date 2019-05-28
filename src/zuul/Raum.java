/**
 * Diese Klasse modelliert R�ume in der Welt von Zuul.
 *
 * Ein "Raum" repr�sentiert einen Ort in der virtuellen Landschaft des
 * Spiels. Ein Raum ist mit anderen R�umen �ber Ausg�nge verbunden.
 * M�gliche Ausg�nge liegen im Norden, Osten, S�den und Westen.
 * F�r jede Richtung h�lt ein Raum eine Referenz auf den 
 * benachbarten Raum.
 *
 * @author  Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */
package zuul;

import java.util.ArrayList;
import java.util.HashMap;

public class Raum
{
	private String beschreibung;
	private HashMap<String, Raum> ausgaenge;
	private ArrayList<Gegenstand> gegenstaende;
	private int temperatur;


	/**
	 * Erzeuge einen Raum mit einer Beschreibung. Ein Raum
	 * hat anfangs keine Ausg�nge.
	 * @param beschreibung enth�lt eine Beschreibung in der Form
	 *        "in einer K�che" oder "auf einem Sportplatz".
	 */
	public Raum(String beschreibung, int temperatur)
	{
		this.gegenstaende=new ArrayList<>();
		this.ausgaenge=new HashMap<>();
		this.beschreibung = beschreibung;
		this.temperatur = temperatur;
	}


	public void gegenstandAblegen(Gegenstand neuerGegenstand) {
		this.gegenstaende.add(neuerGegenstand);
	}

	public void setAusgang(String richtung, Raum nachbar) {
		this.ausgaenge.put(richtung, nachbar);
	}

	public Raum getAusgang(String name) {
		return this.ausgaenge.get(name);
	}

	public String getLangeBeschreibung() {
		String erg=  "Sie sind " + this.beschreibung + "\nAusg�nge: " + this.ausgaengeToString();
		if(this.gegenstaende.size()>0) {
			erg+="\nGegenst�nde in diesem Raum:\n";
			for(Gegenstand g: this.gegenstaende) {
				erg+=" - " + g.toString() + "\n";
			}
		}
		return erg;
	}

	public String ausgaengeToString() {
		String erg="";
		for(String richtung: ausgaenge.keySet()) {
			erg+=richtung + " ";
		}
		return erg;
	}

	/**
	 * @return Die Beschreibung dieses Raums.
	 */
	public String gibBeschreibung()
	{
		return beschreibung;
	}

	public void entferneGegenstand(Gegenstand gesucht) {
		this.gegenstaende.remove(gesucht);
	}

	public Gegenstand sucheGegenstand(String name) {
		for(Gegenstand g: this.gegenstaende) {
			// if(g.getName() == name) --> funktioniert nicht,
			// da hier nur die Referenz auf Gleichheit geprüft wird
			// d.h. ob die im gleichen Speicher stehen
			if(g.getName().equalsIgnoreCase(name)) {
				return g;
				// Dieses return beendet die Methode
			}
		}
		// Falls diese Stelle erreicht wird, wurde kein
		// Gegenstand gefunden
		return null;
	}

	public void gibTemperaturAus() {
		this.W�rme();
		this.K�lte();
		this.Hitze();
		this.zuKalt();
		this.neunzehngrad();
		this.sechsgrad();
		this.zw�lfgrad();
		this.vierundzwanziggrad();
		this.vierundzwanziggrad();
	}

	private void f�nfundzwanziggrad() {
		if(temperatur==25) {
			System.out.println("Es ist sehr Warm hier drin(25C�)");
		}
	}

	private void K�lte() {
		if(temperatur==13) {
			System.out.println("Es ist etwas K�hl hier(13C�)");
		}
	}
	private void neunzehngrad() {
		if(temperatur==19) {
			System.out.println("joa geht ist nicht zu warm(19C�)");
		}
	}

	private void sechsgrad() {
		if(temperatur== 6) {
			System.out.println("Es ist echt zu kalt hier...ich erfreiere(6C�)");
		}
	}
	private void zw�lfgrad() {
		if(temperatur== 12) {
			System.out.println("Es ist echt k�hl(12C�)");
		}
	}
	private void vierundzwanziggrad() {
		if(temperatur== 24) {
			System.out.println("Es ist echt warm hier bro(24C�)");
		}
	}
	private void zuKalt() {
		if(temperatur== 3) {
			System.out.println("omg zu kalt hier ich erfriere(3C�)");
		}
	}
	private void Hitze() {
		if(temperatur== 31) {
			System.out.println("es ist so krass warm hier ...ich schwitze so hart(31C�)");
		}
	}
	private void W�rme() {
		if(temperatur== 23) {
			System.out.println("es ist echt warm hier(23C�)");
		}
	}
}

