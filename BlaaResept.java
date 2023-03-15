public class BlaaResept extends Resept {
	private String farge = "blaa";
	private int pris;

	// Konstroktoren i subklassen BlaaResept som delvis arver fra superklassen
	// Resept
	public BlaaResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit) {
		super(legemiddel, utskrivendeLege, pasient, reit);
	}

	// Metode for aa returnere type farge paa resept
	@Override
	public String farge() {
		return farge;
	}

	// Metode for aa returnere prisen paa resepten
	@Override
	public int prisAaBetale() {
		pris = legemiddel.hentPris();
		pris = Math.round((int) (0.25 * pris));
		return pris;
	}

	// Metode for aa returnere hvilke type resept det er
	@Override
	public String hentType() {
		return farge();
	}

	// Metode for aa hente ut all relevant informasjon om et blaa resept
	@Override
	public String toString() {
		return "Resept ID: " + hentId() + '\n' + "Type resept: " + farge() + " resept" + '\n' + "Legemiddel navn: "
				+ hentLegemiddel() + '\n' + "Utskrevet av: " + hentLege() + '\n' + "Pasient ID: " + hentPasientId()
				+ '\n' + "Antall Re-it: " + hentReit() + '\n' + "Pris: " + prisAaBetale() + " kr";
	}
}