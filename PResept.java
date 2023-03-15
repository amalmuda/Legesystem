public class PResept extends HvitResept {
	private int pris;
	String type = "p";

	// Konstroktoren i subklassen Presept som delvis arver fra superklassen
	// HvitResept
	public PResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit) {
		super(legemiddel, utskrivendeLege, pasient, reit);
	}

	// Metode for aa returnere prisen paa resepten
	public int prisAaBetale() {
		pris = legemiddel.hentPris();
		if (pris < 108) {
			return 0;
		} else {
			pris = Math.round(pris - 108);
			return pris;
		}
	}

	// Metode for aa returnere hvilke type resept det er
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