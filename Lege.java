public class Lege implements Comparable<Lege> {
	protected String navn;

	// Liste som lagrer alle resepter en lege har utskrevet
	IndeksertListe<Resept> utskrevneResepter = new IndeksertListe<>();

	// Konstruktoren for klassen Lege
	public Lege(String navn) {
		this.navn = navn;
	}

	// Metode for aa skrive ut navn paa lege
	public String hentNavn() {
		return navn;
	}

	// Metode for aa returnere kontrollID, hvis "0" betyr det at legen ikke er
	// spesialist
	public String hentKontrollID() {
		return "0";
	}

	// Metode for aa skrive ut en hvit resept fra en lege
	public Resept skrivHvitResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
		if (legemiddel instanceof Narkotisk) {
			throw new UlovligUtskrift(this, legemiddel);
		}
		Resept resept = new HvitResept(legemiddel, this, pasient, reit);
		pasient.leggResept(resept);
		return resept;
	}

	// Metode for aa skrive ut en militaer resept fra en lege
	public Resept skrivMilResept(Legemiddel legemiddel, Pasient pasient) throws UlovligUtskrift {
		if (legemiddel instanceof Narkotisk) {
			throw new UlovligUtskrift(this, legemiddel);
		}
		Resept resept = new MilResept(legemiddel, this, pasient);
		pasient.leggResept(resept);
		return resept;
	}

	// Metode for aa skrive ut en P-resept fra en lege
	public Resept skrivPResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
		if (legemiddel instanceof Narkotisk) {
			throw new UlovligUtskrift(this, legemiddel);
		}
		Resept resept = new PResept(legemiddel, this, pasient, reit);
		pasient.leggResept(resept);
		return resept;
	}

	// Metode for aa skrive ut en blaa resept fra en lege
	public Resept skrivBlaaResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
		if (legemiddel instanceof Narkotisk && !(this instanceof Spesialist)) {
			throw new UlovligUtskrift(this, legemiddel);
		}
		Resept resept = new BlaaResept(legemiddel, this, pasient, reit);
		pasient.leggResept(resept);
		return resept;
	}

	// Metode for aa vise alle resepter en lege har utskrevet
	public void visResepter() {
		for (Resept r : utskrevneResepter) {
			System.out.println(r);
		}
	}

	// Metode for aa hente ut all relevant informasjon om en lege
	public String toString() {
		return "Navn: " + hentNavn();
	}

	// Metode for aa sammenligne to leger basert paa navn
	@Override
	public int compareTo(Lege lege) {
		return this.hentNavn().compareTo(lege.hentNavn());
	}
}