public class Vanlig extends Legemiddel {
	protected String type = "vanlig";

	// Konstroktoren i subklassen Vanlig som delvis arver fra superklassen
	// Legemiddel
	public Vanlig(String navn, int pris, double virkestoff) {
		super(navn, pris, virkestoff);
	}

	// Metode for aa se hvilke type legemiddel det er
	@Override
	public String hentType() {
		return type;
	}

	// Metode for aa hente ut all relevant informasjon om et vanlig legemiddel
	@Override
	public String toString() {
		return "Legemiddel ID: " + hentId() + '\n' + "Legemiddel navn: " + hentNavn() + '\n' + "Pris: " + hentPris()
				+ " kr" + '\n' + "Virkestoff: " + hentVirkestoff();
	}
}