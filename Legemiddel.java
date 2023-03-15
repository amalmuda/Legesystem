abstract class Legemiddel {
	protected String navn;
	protected int pris;
	protected double virkestoff;
	static int teller = 0;
	protected int id;
	protected String type;

	// Konstruktoren for klassen Legemiddel
	public Legemiddel(String navn, int pris, double virkestoff) {
		this.navn = navn;
		this.pris = pris;
		this.virkestoff = virkestoff;
		teller++;
		id = teller;
	}

	// Metode for aa hente ut legemiddel ID
	public int hentId() {
		return id;
	}

	// Metode for aa hente ut legemiddel navn
	public String hentNavn() {
		return navn;
	}

	// Metode for aa hente ut legemiddel pris
	public int hentPris() {
		return pris;
	}

	// Metode for aa hente ut legemiddel virkestoff
	public double hentVirkestoff() {
		return virkestoff;
	}

	// Metode for aa sette ny pris paa legemiddel
	public void settNypris(int pris) {
		this.pris = pris;
	}

	// Metode for aa se hvilke type legemiddel det er
	public String hentType() {
		return type;
	}

	// Metode for aa hente styrke paa legemiddel
	public int hentStyrke() {
		return 0;
	}

	// Metode for aa hente ut all relevant informasjon om et legemiddel
	@Override
	public String toString() {
		return "Legemiddel ID: " + hentId() + '\n' + "Legemiddel navn: " + hentNavn() + '\n' + "Pris: " + hentPris()
				+ " kr" + '\n' + "Virkestoff: " + hentVirkestoff();
	}
}