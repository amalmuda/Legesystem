public class MilResept extends HvitResept {
	private int pris;
	String type = "militaer";

	// Konstroktoren i subklassen MilResept som delvis arver fra superklassen
	// HvitResept
	public MilResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient) {
		super(legemiddel, utskrivendeLege, pasient, 3);
	}

	// Metode for aa returnere prisen paa resepten
	public int prisAaBetale() {
		pris = legemiddel.hentPris();
		pris = Math.round(pris - pris);
		return pris;
	}

	// Metode for aa returnere type farge paa resept
	@Override
	public String hentType() {
		return type;
	}

	// Metode for aa hente ut all relevant informasjon om et militaer resept
	@Override
	public String toString() {
		return "Resept ID: " + hentId() + '\n' + "Type resept: " + farge() + " resept" + '\n' + "Legemiddel navn: "
				+ hentLegemiddel() + '\n' + "Utskrevet av: " + hentLege() + '\n' + "Pasient ID: " + hentPasientId()
				+ '\n' + "Antall Re-it: " + hentReit() + '\n' + "Pris: " + prisAaBetale() + " kr";
	}
}