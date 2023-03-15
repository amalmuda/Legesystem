public class Spesialist extends Lege implements Godkjenningsfritak {
	private String kontrollID;

	// Konstroktoren i subklassen Spesialist som delvis arver fra superklassen Lege
	public Spesialist(String navn, String kontrollID) {
		super(navn);
		this.kontrollID = kontrollID;
	}

	// Metode for aa skrive ut kontroll ID for godkjenningsfritak
	@Override
	public String hentKontrollID() {
		return kontrollID;
	}

	// Metode for aa hente ut all relevant informasjon om en spesialist lege
	@Override
	public String toString() {
		return "Navn: " + hentNavn() + " (spesialist)" + '\n' + "Kontroll ID for godkjenningsfritak: "
				+ hentKontrollID();
	}
}