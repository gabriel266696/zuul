package zuul;

public class WorldGenerator {
    private Raum lichtung, waldstueck, taverne, hexenhaus, dorfplatz, kellerDerTaverne, geheimgang, taverneErsterStock, piratenHoehle,Imbiss;

    public WorldGenerator() {
        this.raeumeAnlegen();
        this.setzeAusgaenge();
        this.addGegenstaende();
    }
 // nach der beschreibung sind die gradzahlen jeweils f�r einen Raum.
    
    private void raeumeAnlegen() {
        lichtung = new Raum("auf einer Lichtung, umgeben von dunklen Tannen", 25);
        waldstueck = new Raum("im dunklen Wald",13);
        taverne = new Raum("in der Taverne, mit zwielichten Gestalten an der Theke",19);
        hexenhaus = new Raum("im Hexenhaus",6);
        dorfplatz = new Raum("auf dem Dorfplatz",12);
        piratenHoehle = new Raum("in einer alten Piratenh�hle",24);
        kellerDerTaverne = new Raum("im Keller der Taverne",3);
        geheimgang = new Raum("in einem schmalen modrigen Geheimgang",31);
        taverneErsterStock=new Raum("bei den den G�stezimmern im ersten Stock der Taverne",23);
        Imbiss = new Raum("in einem Imbiss",19);
    }

    private void setzeAusgaenge() {
/**
 * Imbiss ein und ausg�nge eingebaut 
 * Imbiss �ber Lichtung
 * wenn man von lichtung "up" geht dann ist man im Imbiss,
 */
        // die Ausg�nge initialisieren
        lichtung.setAusgang("down", piratenHoehle);
        lichtung.setAusgang("east", waldstueck);
        lichtung.setAusgang("up", Imbiss);
        waldstueck.setAusgang("west", lichtung);
        waldstueck.setAusgang("south", dorfplatz);
        dorfplatz.setAusgang("west", hexenhaus);
        dorfplatz.setAusgang("north", waldstueck);
        dorfplatz.setAusgang("south", taverne);
        hexenhaus.setAusgang("east", dorfplatz);
        taverne.setAusgang("north", dorfplatz);
        taverne.setAusgang("up", taverneErsterStock);
        taverne.setAusgang("down", kellerDerTaverne);
        taverneErsterStock.setAusgang("down", taverne);
        taverneErsterStock.setAusgang("window", dorfplatz);
        kellerDerTaverne.setAusgang("up", taverne);
        kellerDerTaverne.setAusgang("north", geheimgang);
        geheimgang.setAusgang("south", kellerDerTaverne);
        geheimgang.setAusgang("east", piratenHoehle);
        piratenHoehle.setAusgang("west", geheimgang);
        piratenHoehle.setAusgang("up", lichtung);
        Imbiss.setAusgang("down",lichtung);

    }

//*wir haben Pommes im Imbess hinterlegt
    private void addGegenstaende() {
    	
        taverne.gegenstandAblegen(new Gegenstand("Bierkrug", "ein leckeres dunkles Pils in einem edlen Krug", 2));
        taverne.gegenstandAblegen(new Gegenstand("Teller", "ein Teller mit deftigem Wildschweinfleisch mit So�e", 5 ));
        piratenHoehle.gegenstandAblegen(new Gegenstand("Schatztruhe", "eine mit Golf gef�llte Holzkiste", 40));
        piratenHoehle.gegenstandAblegen(new Gegenstand("Schwert", "das Schwert des alten Piratenkapit�ns", 10));
        piratenHoehle.gegenstandAblegen(new Essen("Torte", "eine leckere Torte", 5, 5));
        waldstueck.gegenstandAblegen(new Essen("Pilz", "ein seltsam aussehender Pilz", 1, 20));
        waldstueck.gegenstandAblegen(new Essen("Fr�chte", "leckere Fr�chte", 2, 3));
        waldstueck.gegenstandAblegen(new Essen("Fisch", "leckere Fischst�bchen", 1, 3));
        lichtung.gegenstandAblegen(new Gegenstand("Korb", "ein Weidenkorb gef�llt mit Brot", 4));
        lichtung.gegenstandAblegen(new Essen("Muffin", "lecker lecker", 1, 5));
        Imbiss.gegenstandAblegen(new Essen("Pommes", "Energie gebende  Pommes", 1, 3));
    }
    
   

    public Raum getStartRaum() {
        return this.lichtung;
    }
               

}
