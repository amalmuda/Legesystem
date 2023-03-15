public class Narkotisk extends Legemiddel {
	private int styrke;
	String type = "narkotisk";

	// Konstroktoren i subklassen Narkotisk som delvis arver fra superklassen
	// Legemiddel
	public Narkotisk(String navn, int pris, double virkestoff, int styrke) {
		super(navn, pris, virkestoff);
		this.styrke = styrke;
	}

	// Metode for aa hente ut narkotisk styrke
	@Override
	public int hentStyrke() {
		return styrke;
	}

	// Metode for aa se hvilke type legemiddel det er
	@Override
	public String hentType() {
		return type;
	}

	// Metode for aa hente ut all relevant informasjon om et narkotisk legemiddel
	@Override
	public String toString() {
		return "Legemiddel ID: " + hentId() + '\n' + "Legemiddel navn: " + hentNavn() + '\n' + "Pris: " + hentPris()
				+ " kr" + '\n' + "Virkestoff: " + hentVirkestoff() + '\n' + "Styrke: " + hentStyrke();
	}
}