public abstract class Resept {
	protected Lege utskrivendeLege;
	protected Legemiddel legemiddel;
	static int reseptTeller = 0;
	int reseptId;
	protected Pasient pasient;
	protected int reit;

	// Abtract metoder for aa kreve at alle subklasser av abstract superklassen
	// Resept har disse metodene
	abstract public String farge();

	abstract public int prisAaBetale();

	// Konstruktoren for klassen Resept
	public Resept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit) {
		this.legemiddel = legemiddel;
		this.utskrivendeLege = utskrivendeLege;
		this.pasient = pasient;
		this.reit = reit;
		reseptTeller++;
		reseptId = reseptTeller;
		utskrivendeLege.utskrevneResepter.leggTil(this);
	}

	// Metode for aa hente ut resept ID
	public int hentId() {
		return reseptId;
	}

	// Metode for aa hente ut resept legemiddel
	public String hentLegemiddel() {
		return legemiddel.navn;
	}

	// Metode for aa hente ut navn paa utskrivende lege
	public String hentLege() {
		return utskrivendeLege.hentNavn();
	}

	// Metode for aa hente ut resept pasient ID
	public int hentPasientId() {
		return pasient.id;
	}

	// Metode for aa hente ut antall resept re-it
	public int hentReit() {
		return reit;
	}

	// Metode for aa ta i bruk resept, det vil redusere antall re-it til den er 0 og
	// ugyldig
	public boolean bruk() {
		if (reit != 0) {
			reit--;
			return true;
		} else {
			return false;
		}
	}

	// Metode for aa returnere hvilke type resept det er
	public String hentType() {
		return "0";
	}

	// Metode for aa hente ut all relevant informasjon om et resept
	@Override
	public String toString() {
		return "Resept ID: " + hentId() + '\n' + "Legemiddel navn: " + hentLegemiddel() + '\n' + "Utskrevet av: "
				+ hentLege() + '\n' + "Pasient ID: " + hentPasientId() + '\n' + "Antall Re-it: " + hentReit();
	}
}