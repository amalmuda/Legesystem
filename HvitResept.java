public class HvitResept extends Resept {
	private String farge = "hvit";

	// Konstroktoren i subklassen HvitResept som delvis arver fra superklassen
	// Resept
	public HvitResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit) {
		super(legemiddel, utskrivendeLege, pasient, reit);
	}

	// Metode for aa returnere type farge paa resept
	@Override
	public String farge() {
		return farge;
	}

	// Metode for aa returnere hvilke type resept det er
	@Override
	public String hentType() {
		return farge();
	}

	// Metode for aa returnere prisen paa resepten
	@Override
	public int prisAaBetale() {
		return legemiddel.pris;
	}
}