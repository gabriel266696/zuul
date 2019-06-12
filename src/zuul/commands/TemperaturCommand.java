package zuul.commands;
import zuul.Befehl;
import zuul.Spieler;

public class TemperaturCommand  implements CommandFunction{
	
	    private Spieler spieler;

	    public TemperaturCommand(Spieler spieler) {
	        this.spieler = spieler;
	    }
	    public void execute(Befehl befehl) {
	    	this.spieler.getAktuellerRaum().gibTemperaturAus();
	}
}
