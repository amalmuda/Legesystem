public class Vanedannende extends Legemiddel {
	private int styrke;
	protected String type = "vanedannende";

	// Konstroktoren i subklassen Vanedannende som delvis arver fra superklassen
	// Legemiddel
	public Vanedannende(String navn, int pris, double virkestoff, int styrke) {
		super(navn, pris, virkestoff);
		this.styrke = styrke;
	}

	// Metode for aa hente ut vanedannende styrke
	@Override
	public int hentStyrke() {
		return styrke;
	}

	// Metode for aa se hvilke type legemiddel det er
	@Override
	public String hentType() {
		return type;
	}

	// Metode for aa hente ut all relevant informasjon om et vanedannende legemiddel
	@Override
	public String toString() {
		return "Legemiddel ID: " + hentId() + '\n' + "Legemiddel navn: " + hentNavn() + '\n' + "Pris: " + hentPris()
				+ " kr" + '\n' + "Virkestoff: " + hentVirkestoff() + '\n' + "Styrke: " + hentStyrke();
	}
}