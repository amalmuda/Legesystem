public class Pasient {
	String navn;
	String fodselsnummer;
	static int pasientId = 0;
	int id;

	// Liste som lagrer alle resepter en pasient har faat utskrevet
	IndeksertListe<Resept> pasientResepter = new IndeksertListe<>();

	// Konstruktoren for klassen Pasient
	public Pasient(String navn, String fodselsnummer) {
		this.navn = navn;
		this.fodselsnummer = fodselsnummer;
		pasientId++;
		id = pasientId;
	}

	// Metode som lar oss utskrive en ny resept til pasienten
	public void leggResept(Resept resept) {
		pasientResepter.leggTil(resept);
	}

	// Metode som viser alle resepter en pasient har faat utskrevet
	public void visResepter() {
		for (Resept r : pasientResepter) {
			System.out.println(r);
		}
	}
}