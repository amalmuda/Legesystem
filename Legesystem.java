import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Legesystem {

	// Lister som holder oversikt over de ulike elementene i systemet
	static Liste<Lege> legeListe = new Prioritetskoe<>();
	static IndeksertListe<Legemiddel> legemiddelListe = new IndeksertListe<>();
	static IndeksertListe<Pasient> pasientListe = new IndeksertListe<>();
	static IndeksertListe<Resept> reseptListe = new IndeksertListe<>();

	// Main metode som starter opp naar hovedprogrammet kjorer
	public static void main(String[] args) throws UlovligUtskrift {
		System.out.println();
		System.out.println("********************************");
		System.out.println("  Velkommen til Legesystem 1.0");
		System.out.println("********************************");
		System.out.println();

		// Loop som alltid kjorer saa lenge brukeren ikke avslutter programmet
		while (true) {
			Scanner obj0 = new Scanner(System.in);

			// Alternativer brukeren faar naar programmet starter
			System.out.println("           Hovedmeny");
			System.out.println("********************************");
			System.out.println("________________________________");
			System.out.println("1. Vis alle elementer i systemet");
			System.out.println("________________________________");
			System.out.println("2. Legg til elementer i systemet");
			System.out.println("________________________________");
			System.out.println("3. Fjern elementer fra systemet");
			System.out.println("________________________________");
			System.out.println("4. Se pasient-resepter");
			System.out.println("________________________________");
			System.out.println("5. Vis statistikk");
			System.out.println("________________________________");
			System.out.println("6. Les fra fil");
			System.out.println("________________________________");
			System.out.println("7. Skriv data paa fil");
			System.out.println("________________________________");
			System.out.println("8. Avslutt programmet");
			System.out.println("________________________________");
			System.out.println("");
			System.out.println("Velg alternativ: ");
			String a = obj0.nextLine();
			System.out.println();

			// Alternativ som lar brukeren se oversikt over alle elementer i systemet
			if (a.equals("1")) {
				skrivUtInfo();
				System.out.println();
				System.out.println("Trykk Enter for aa gaa tilbake til Hovedmeny");
				System.out.println();
				Scanner k = new Scanner(System.in);
				k.nextLine();
				continue;
			}

			// Alternativ som lar brukeren legge til nye elementer i systemet
			else if (a.equals("2")) {
				System.out.println(" Legg til ny:");
				System.out.println("**************");
				Scanner obj1 = new Scanner(System.in);
				System.out.println("1. Lege");
				System.out.println("_____________");
				System.out.println("2. Pasient");
				System.out.println("_____________");
				System.out.println("3. Legemiddel");
				System.out.println("_____________");
				System.out.println("4. Resept");
				System.out.println("_____________");
				System.out.println("");
				System.out.println("Velg alternativ: ");
				String b = obj1.nextLine();
				System.out.println();

				// Alternativ fra undermeny som lar brukeren legge til en ny lege i systemet
				if (b.equals("1")) {
					Scanner obj2 = new Scanner(System.in);
					System.out.println("Er legen en spesialist? ja/nei");
					String s = obj2.nextLine();
					if (s.equals("ja")) {
						Scanner obj3 = new Scanner(System.in);
						System.out.println("Navn paa lege: ");
						String navn = obj3.nextLine();
						while (!navn.matches("[a-zA-Z -]+")) {
							System.out.println("Ugyldig navn tastet inn, prov igjen");
							System.out.println();
							System.out.println("Navn paa lege: ");
							navn = obj3.nextLine();
						}
						Scanner obj4 = new Scanner(System.in);
						System.out.println("Kontroll ID: ");
						String kontrollID = obj4.nextLine();
						while (kontrollID.length() != 5) {
							System.out.println("Ugyldig kontroll ID valgt, maa vaere 5 siffer, prov igjen");
							System.out.println();
							System.out.println("Kontroll ID: ");
							System.out.println();
							kontrollID = obj4.nextLine();
						}
						leggTilLege(navn, kontrollID);
						System.out.println("Ny lege lagt til i systemet!");
						System.out.println();
						System.out.println("Trykk Enter for aa gaa tilbake til Hovedmeny");
						System.out.println();
						Scanner k = new Scanner(System.in);
						k.nextLine();
						continue;
					} else if (s.equals("nei")) {
						Scanner obj3 = new Scanner(System.in);
						System.out.println("Navn paa lege: ");
						String navn = obj3.nextLine();
						while (!navn.matches("[a-zA-Z -]+")) {
							System.out.println("Ugyldig navn valgt, prov igjen");
							System.out.println();
							System.out.println("Navn paa lege: ");
							navn = obj3.nextLine();
						}
						String kontrollID = "ingen";
						leggTilLege(navn, kontrollID);
						System.out.println("Ny lege lagt til i systemet!");
						System.out.println();
						System.out.println("Trykk Enter for aa gaa tilbake til Hovedmeny");
						System.out.println();
						Scanner k = new Scanner(System.in);
						k.nextLine();
						continue;
					} else {
						System.out.println("Ugyldig valg");
						System.out.println();
						System.out.println("Trykk Enter for aa gaa tilbake til Hovedmeny");
						System.out.println();
						Scanner k = new Scanner(System.in);
						k.nextLine();
						continue;
					}

					// Alternativ fra undermeny som lar brukeren legge til en ny pasient i systemet
				} else if (b.equals("2")) {
					Scanner obj2 = new Scanner(System.in);
					System.out.println("Navn paa pasient: ");
					String navn = obj2.nextLine();
					while (!navn.matches("[a-zA-Z -]+")) {
						System.out.println("Ugyldig navn tastet inn, prov igjen");
						System.out.println();
						System.out.println("Navn paa pasient: ");
						navn = obj2.nextLine();
					}
					Scanner obj3 = new Scanner(System.in);
					System.out.println("Fodselsnummer: ");
					String fodselsnummer = obj3.nextLine();
					while (fodselsnummer.length() != 11 || !fodselsnummer.matches("[0-9]+")) {
						System.out.println("Ugyldig fodselsnummer valgt, maa vaere 11 siffer, prov igjen");
						System.out.println();
						System.out.println("Fodselsnummer: ");
						fodselsnummer = obj3.nextLine();
					}
					leggTilPasient(navn, fodselsnummer);
					System.out.println("Ny pasient lagt til i systemet!");
					System.out.println();
					System.out.println("Trykk Enter for aa gaa tilbake til Hovedmeny");
					System.out.println();
					Scanner k = new Scanner(System.in);
					k.nextLine();
					continue;

					// Alternativ fra undermeny som lar brukeren legge til en ny legemiddel i
					// systemet
				} else if (b.equals("3")) {
					Scanner obj2 = new Scanner(System.in);
					System.out.println("Hvilke type legemiddel ønsker du å legge til?");
					System.out.println("*********************************************");
					System.out.println("1. Vanlig");
					System.out.println("_______________");
					System.out.println("2. Narkotisk");
					System.out.println("_______________");
					System.out.println("3. Vanedannende");
					System.out.println("_______________");
					System.out.println("");
					System.out.println("Velg alternativ: ");
					String s = obj2.nextLine();
					System.out.println();
					String type = null;
					int styrke = 0;
					if (s.equals("1")) {
						type = "vanlig";
						styrke = 0;
					} else if (s.equals("2")) {
						type = "narkotisk";
					} else if (s.equals("3")) {
						type = "vanedannende";
					} else {
						System.out.println();
						System.out.println("Ugyldig valg av alternativ");
						System.out.println();
						System.out.println("Trykk Enter for aa gaa tilbake til Hovedmeny");
						System.out.println();
						Scanner k = new Scanner(System.in);
						k.nextLine();
						continue;
					}
					Scanner obj3 = new Scanner(System.in);
					System.out.println("Navn paa legemiddel: ");
					String navn = obj3.nextLine();
					Scanner obj4 = new Scanner(System.in);
					System.out.println("Pris: ");
					String p = obj4.nextLine();
					while (!p.matches("[0-9]+")) {
						System.out.println("Ugyldig pris oppgitt, maa vaere heltall, prov igjen");
						System.out.println();
						System.out.println("Pris: ");
						p = obj4.nextLine();
					}
					int pris = Integer.parseInt(p);
					Scanner obj5 = new Scanner(System.in);
					System.out.println("Virkestoff: ");
					String v = obj5.nextLine();
					while (!v.matches("[0-9.]+")) {
						System.out.println("Ugyldig virkestoff oppgitt, maa vaere tall, prov igjen");
						System.out.println();
						System.out.println("Virkestoff: ");
						v = obj5.nextLine();
					}
					double virkestoff = Double.parseDouble(v);
					if (s.equals("2") || s.equals("3")) {
						Scanner obj6 = new Scanner(System.in);
						System.out.println("Styrke: ");
						String w = obj6.nextLine();
						while (!w.matches("[0-9]+")) {
							System.out.println("Ugyldig styrke oppgitt, maa vaere heltall, prov igjen");
							System.out.println();
							System.out.println("Styrke: ");
							w = obj6.nextLine();
						}
						styrke = Integer.parseInt(w);
					}
					leggTilLegemiddel(navn, pris, virkestoff, styrke, type);
					System.out.println("Ny legemiddel lagt til i systemet!");
					System.out.println();
					System.out.println("Trykk Enter for aa gaa tilbake til Hovedmeny");
					System.out.println();
					Scanner k = new Scanner(System.in);
					k.nextLine();
					continue;

					// Alternativ fra undermeny som lar brukeren legge til en ny resept i systemet
				} else if (b.equals("4")) {
					String type = null;
					Scanner obj3 = new Scanner(System.in);
					if (legeListe.stoerrelse() == 0) {
						System.out.println(
								"Ingen leger er registrert i dette systemet, venligst legg til en ny lege fra Hovedmenyen");
						System.out.println("Kan ikke lage ny resept");
						System.out.println();
						System.out.println("Trykk Enter for aa gaa tilbake til Hovedmeny");
						System.out.println();
						Scanner k = new Scanner(System.in);
						k.nextLine();
						continue;
					}
					if (legemiddelListe.stoerrelse() == 0) {
						System.out.println(
								"Ingen legemidler er registrert i dette systemet, venligst legg til en ny legemiddel fra Hovedmenyen");
						System.out.println("Kan ikke lage ny resept");
						System.out.println();
						System.out.println("Trykk Enter for aa gaa tilbake til Hovedmeny");
						System.out.println();
						Scanner k = new Scanner(System.in);
						k.nextLine();
						continue;
					}
					if (pasientListe.stoerrelse() == 0) {
						System.out.println(
								"Ingen pasienter er registrert i dette systemet, venligst legg til en ny pasient fra Hovedmenyen");
						System.out.println("Kan ikke lage ny resept");
						System.out.println();
						System.out.println("Trykk Enter for aa gaa tilbake til Hovedmeny");
						System.out.println();
						Scanner k = new Scanner(System.in);
						k.nextLine();
						continue;
					}
					System.out.println("Hvilke type resept?");
					System.out.println("*******************");
					System.out.println("1. Hvit-resept");
					System.out.println("__________________");
					System.out.println("2. Militaer-resept");
					System.out.println("__________________");
					System.out.println("3. P-resept");
					System.out.println("__________________");
					System.out.println("4. Blaa-resept");
					System.out.println("__________________");
					System.out.println("");
					System.out.println("Velg alternativ: ");
					String z = obj3.nextLine();
					System.out.println();
					if (z.equals("1")) {
						type = "hvit";
					} else if (z.equals("2")) {
						type = "militaer";
					} else if (z.equals("3")) {
						type = "p";
					} else if (z.equals("4")) {
						type = "blaa";
					} else {
						System.out.println();
						System.out.println("Ugyldig alternativ valgt fra meny");
						System.out.println();
						System.out.println("Trykk Enter for aa gaa tilbake til Hovedmeny");
						System.out.println();
						Scanner k = new Scanner(System.in);
						k.nextLine();
						continue;
					}
					Scanner obj4 = new Scanner(System.in);
					System.out.println("Hvilke lege skal skrive resepten?");
					System.out.println("Velg eksisterende lege fra systemet");
					System.out.println("___________________________________");
					int t = 0;
					IndeksertListe<Lege> midlertidig = new IndeksertListe<>();
					for (Lege r : legeListe) {
						t++;
						System.out.println(t + ". " + r.navn);
						midlertidig.leggTil(r);
					}
					System.out.println("___________________________________");
					System.out.println("");
					System.out.println("Velg alternativ: ");
					Scanner obj5 = new Scanner(System.in);
					int posLege = 0;
					try {
						posLege = Integer.parseInt(obj5.nextLine());
					} catch (Exception e) {
						posLege = 0;
					}
					if (posLege > legeListe.stoerrelse() || posLege <= 0) {
						System.out.println();
						System.out.println("Ugyldig alternativ valgt fra meny");
						System.out.println();
						System.out.println("Trykk Enter for aa gaa tilbake til Hovedmeny");
						System.out.println();
						Scanner k = new Scanner(System.in);
						k.nextLine();
						continue;
					}
					System.out.println();
					Lege lege = midlertidig.hent(posLege - 1);
					System.out.println("Hvilke legemiddel skal skrives i denne resepten?");
					System.out.println("Velg eksisterende legemiddel fra systemet");
					System.out.println("_________________________________________________");
					int s = 0;
					for (Legemiddel r : legemiddelListe) {
						s++;
						System.out.println(s + ". " + r.navn);
					}
					System.out.println("_________________________________________________");
					System.out.println("");
					System.out.println("Velg alternativ: ");
					Scanner obj6 = new Scanner(System.in);
					int posLegemiddel = 0;
					try {
						posLegemiddel = Integer.parseInt(obj6.nextLine());
					} catch (Exception e) {
						posLegemiddel = 0;
					}
					if (posLegemiddel > legemiddelListe.stoerrelse() || posLegemiddel <= 0) {
						System.out.println();
						System.out.println("Ugyldig alternativ valgt fra meny");
						System.out.println();
						System.out.println("Trykk Enter for aa gaa tilbake til Hovedmeny");
						System.out.println();
						Scanner k = new Scanner(System.in);
						k.nextLine();
						continue;
					}
					System.out.println();
					Legemiddel legemiddel = legemiddelListe.hent(posLegemiddel - 1);
					System.out.println("Hvilke pasient skal denne resepten skrives for?");
					System.out.println("Velg eksisterende pasient fra systemet");
					System.out.println("_________________________________________________");
					int k = 0;
					for (Pasient r : pasientListe) {
						k++;
						System.out.println(k + ". " + r.navn);
					}
					System.out.println("_________________________________________________");
					System.out.println("");
					System.out.println("Velg alternativ: ");
					Scanner obj7 = new Scanner(System.in);
					int posPasient = 0;
					try {
						posPasient = Integer.parseInt(obj7.nextLine());
					} catch (Exception e) {
						posPasient = 0;
					}
					if (posPasient > pasientListe.stoerrelse() || posPasient <= 0) {
						System.out.println();
						System.out.println("Ugyldig alternativ valgt fra meny");
						System.out.println();
						System.out.println("Trykk Enter for aa gaa tilbake til Hovedmeny");
						System.out.println();
						Scanner k1 = new Scanner(System.in);
						k1.nextLine();
						continue;
					}
					System.out.println();
					Pasient pasient = pasientListe.hent(posPasient - 1);
					int reit = 0;
					if (!type.equals("militaer")) {
						Scanner obj8 = new Scanner(System.in);
						System.out.println("Hvor mange re-it skal skrives for denne resepten?");
						System.out.println();
						System.out.println("Velg antall: ");
						String e = obj8.nextLine();
						while (!e.matches("[0-9]+")) {
							System.out.println("Ugyldig antall re-it oppgitt, maa vaere et heltall, prov igjen");
							System.out.println();
							System.out.println("Velg antall: ");
							e = obj8.nextLine();
						}
						reit = Integer.parseInt(e);
					}
					leggTilResept(legemiddel, lege, pasient, reit, type);
					System.out.println("Ny resept lagt til i systemet!");
					System.out.println();
					System.out.println("Trykk Enter for aa gaa tilbake til Hovedmeny");
					System.out.println();
					Scanner k1 = new Scanner(System.in);
					k1.nextLine();
					continue;
				} else {
					System.out.println("Ugyldig valg");
					System.out.println();
					System.out.println("Trykk Enter for aa gaa tilbake til Hovedmeny");
					System.out.println();
					Scanner k = new Scanner(System.in);
					k.nextLine();
					continue;
				}

				// Alternativ som lar brukeren fjerne elementer i systemet
			} else if (a.equals("3")) {
				System.out.println("   Fjern:");
				System.out.println("************");
				Scanner obj1 = new Scanner(System.in);
				System.out.println("1. Lege");
				System.out.println("_____________");
				System.out.println("2. Pasient");
				System.out.println("_____________");
				System.out.println("3. Legemiddel");
				System.out.println("_____________");
				System.out.println("4. Resept");
				System.out.println("_____________");
				System.out.println("");
				System.out.println("Velg alternativ: ");
				String b = obj1.nextLine();
				System.out.println();

				// Alternativ fra undermeny som lar brukeren fjerne en lege fra systemet
				if (b.equals("1")) {
					if (legeListe.stoerrelse() == 0) {
						System.out.println("Ingen leger er registrert i dette systemet");
						System.out.println();
						System.out.println("Trykk Enter for aa gaa tilbake til Hovedmeny");
						System.out.println();
						Scanner k = new Scanner(System.in);
						k.nextLine();
						continue;
					}
					System.out.println("Hvilke lege onsker du aa fjerne fra systemet?");
					System.out.println("_________________________________________________");
					int t = 0;
					IndeksertListe<Lege> midlertidig = new IndeksertListe<>();
					for (Lege r : legeListe) {
						t++;
						System.out.println(t + ". " + r.navn);
						midlertidig.leggTil(r);
					}
					System.out.println("_________________________________________________");
					System.out.println("");
					System.out.println("Velg alternativ: ");
					Scanner obj5 = new Scanner(System.in);
					int posLege = 0;
					try {
						posLege = Integer.parseInt(obj5.nextLine());
					} catch (Exception e) {
						posLege = 0;
					}
					if (posLege > legeListe.stoerrelse() || posLege <= 0) {
						System.out.println();
						System.out.println("Ugyldig alternativ valgt fra meny");
						System.out.println();
						System.out.println("Trykk Enter for aa gaa tilbake til Hovedmeny");
						System.out.println();
						Scanner k = new Scanner(System.in);
						k.nextLine();
						continue;
					}
					System.out.println();
					Lege fjernet;
					if (posLege == 1) {
						fjernet = midlertidig.hent();
						midlertidig.fjern();
					} else {
						fjernet = midlertidig.hent(posLege - 1);
						midlertidig.fjern(posLege - 1);
					}
					Liste<Lege> tmp = new Prioritetskoe<>();
					for (Lege r : midlertidig) {
						tmp.leggTil(r);
					}
					legeListe = tmp;
					System.out.println("Lege " + fjernet.hentNavn() + " fjernet fra systemet");
					System.out.println();
					System.out.println("Trykk Enter for aa gaa tilbake til Hovedmeny");
					System.out.println();
					Scanner k = new Scanner(System.in);
					k.nextLine();
					continue;

					// Alternativ fra undermeny som lar brukeren fjerne en pasient fra systemet
				} else if (b.equals("2")) {
					if (pasientListe.stoerrelse() == 0) {
						System.out.println("Ingen pasienter er registrert i dette systemet");
						System.out.println();
						System.out.println("Trykk Enter for aa gaa tilbake til Hovedmeny");
						System.out.println();
						Scanner k = new Scanner(System.in);
						k.nextLine();
						continue;
					}
					System.out.println("Hvilke pasient onsker du aa fjerne fra systemet?");
					System.out.println("_________________________________________________");
					int k = 0;
					for (Pasient r : pasientListe) {
						k++;
						System.out.println(k + ". " + r.navn);
					}
					System.out.println("_________________________________________________");
					System.out.println("");
					System.out.println("Velg alternativ: ");
					Scanner obj7 = new Scanner(System.in);
					int posPasient = 0;
					try {
						posPasient = Integer.parseInt(obj7.nextLine());
					} catch (Exception e) {
						posPasient = 0;
					}
					if (posPasient > pasientListe.stoerrelse() || posPasient <= 0) {
						System.out.println();
						System.out.println("Ugyldig alternativ valgt fra meny");
						System.out.println();
						System.out.println("Trykk Enter for aa gaa tilbake til Hovedmeny");
						System.out.println();
						Scanner k1 = new Scanner(System.in);
						k1.nextLine();
						continue;
					}
					System.out.println();
					Pasient fjernet;
					if (posPasient == 1) {
						fjernet = pasientListe.hent();
						pasientListe.fjern();
					} else {
						fjernet = pasientListe.hent(posPasient - 1);
						pasientListe.fjern(posPasient - 1);
					}
					System.out.println("Pasient " + fjernet.navn + " fjernet fra systemet");
					System.out.println();
					System.out.println("Trykk Enter for aa gaa tilbake til Hovedmeny");
					System.out.println();
					Scanner k1 = new Scanner(System.in);
					k1.nextLine();
					continue;

					// Alternativ fra undermeny som lar brukeren fjerne en legemiddel fra systemet
				} else if (b.equals("3")) {
					if (legemiddelListe.stoerrelse() == 0) {
						System.out.println("Ingen legemidler er registrert i dette systemet");
						System.out.println();
						System.out.println("Trykk Enter for aa gaa tilbake til Hovedmeny");
						System.out.println();
						Scanner k = new Scanner(System.in);
						k.nextLine();
						continue;
					}
					System.out.println("Hvilke legemiddel onsker du aa fjerne fra systemet?");
					System.out.println("___________________________________________________");
					int s = 0;
					for (Legemiddel r : legemiddelListe) {
						s++;
						System.out.println(s + ". " + r.navn);
					}
					System.out.println("___________________________________________________");
					System.out.println("");
					System.out.println("Velg alternativ: ");
					Scanner obj6 = new Scanner(System.in);
					int posLegemiddel = 0;
					try {
						posLegemiddel = Integer.parseInt(obj6.nextLine());
					} catch (Exception e) {
						posLegemiddel = 0;
					}
					if (posLegemiddel > legemiddelListe.stoerrelse() || posLegemiddel <= 0) {
						System.out.println();
						System.out.println("Ugyldig alternativ valgt fra meny");
						System.out.println();
						System.out.println("Trykk Enter for aa gaa tilbake til Hovedmeny");
						System.out.println();
						Scanner k = new Scanner(System.in);
						k.nextLine();
						continue;
					}
					System.out.println();
					Legemiddel fjernet;
					if (posLegemiddel == 1) {
						fjernet = legemiddelListe.hent();
						legemiddelListe.fjern();
					} else {
						fjernet = legemiddelListe.hent(posLegemiddel - 1);
						legemiddelListe.fjern(posLegemiddel - 1);
					}
					System.out.println("Legemiddel " + fjernet.navn + " fjernet fra systemet");
					System.out.println();
					System.out.println("Trykk Enter for aa gaa tilbake til Hovedmeny");
					System.out.println();
					Scanner k1 = new Scanner(System.in);
					k1.nextLine();
					continue;

					// Alternativ fra undermeny som lar brukeren fjerne en resept fra systemet
				} else if (b.equals("4")) {
					if (reseptListe.stoerrelse() == 0) {
						System.out.println("Ingen resepter er registrert i dette systemet");
						System.out.println();
						System.out.println("Trykk Enter for aa gaa tilbake til Hovedmeny");
						System.out.println();
						Scanner k = new Scanner(System.in);
						k.nextLine();
						continue;
					}
					System.out.println("Hvilke resept onsker du aa fjerne fra systemet?");
					System.out.println("_________________________________________________");
					int s = 0;
					for (Resept r : reseptListe) {
						s++;
						System.out.println(s + ". " + r.toString());
						System.out.println();
					}
					System.out.println("_________________________________________________");
					System.out.println("");
					System.out.println("Velg alternativ: ");
					Scanner obj6 = new Scanner(System.in);
					int posResept = 0;
					try {
						posResept = Integer.parseInt(obj6.nextLine());
					} catch (Exception e) {
						posResept = 0;
					}
					if (posResept > legemiddelListe.stoerrelse() || posResept <= 0) {
						System.out.println();
						System.out.println("Ugyldig alternativ valgt fra meny");
						System.out.println();
						System.out.println("Trykk Enter for aa gaa tilbake til Hovedmeny");
						System.out.println();
						Scanner k = new Scanner(System.in);
						k.nextLine();
						continue;
					}
					System.out.println();
					Resept fjernet;
					if (posResept == 1) {
						fjernet = reseptListe.hent();
						reseptListe.fjern();
					} else {
						fjernet = reseptListe.hent(posResept - 1);
						reseptListe.fjern(posResept - 1);
					}
					System.out.println("Resept med ID-nummer " + fjernet.hentId() + " fjernet fra systemet");
					System.out.println();
					System.out.println("Trykk Enter for aa gaa tilbake til Hovedmeny");
					System.out.println();
					Scanner k1 = new Scanner(System.in);
					k1.nextLine();
					continue;
				} else {
					System.out.println("Ugyldig valg");
					System.out.println();
					System.out.println("Trykk Enter for aa gaa tilbake til Hovedmeny");
					System.out.println();
					Scanner k = new Scanner(System.in);
					k.nextLine();
					continue;
				}

				// Alternativ som gir brukeren oversikt over alle pasienter, utskrevne resepter
				// pr pasient og samtidig mulighet til aa bruke en resept
			} else if (a.equals("4")) {
				if (pasientListe.stoerrelse() == 0) {
					System.out.println("Ingen pasienter er registrert i dette systemet");
					System.out.println();
					System.out.println("Trykk Enter for aa gaa tilbake til Hovedmeny");
					System.out.println();
					Scanner k = new Scanner(System.in);
					k.nextLine();
					continue;
				}
				System.out.println("Hvilke pasient vil du se resepter for?");
				System.out.println("Velg eksisterende pasient fra systemet");
				System.out.println("_____________________________________________________");
				int k = 0;
				for (Pasient r : pasientListe) {
					k++;
					System.out.println(k + ". " + r.navn + " (Fodselsnummer: " + r.fodselsnummer + ")");
				}
				System.out.println("_____________________________________________________");
				System.out.println("");
				System.out.println("Velg alternativ: ");
				Scanner obj7 = new Scanner(System.in);
				int posPasient = 0;
				try {
					posPasient = Integer.parseInt(obj7.nextLine());
				} catch (Exception e) {
					posPasient = 0;
				}
				if (posPasient > pasientListe.stoerrelse() || posPasient <= 0) {
					System.out.println();
					System.out.println("Ugyldig alternativ valgt fra meny");
					System.out.println();
					System.out.println("Trykk Enter for aa gaa tilbake til Hovedmeny");
					System.out.println();
					Scanner k1 = new Scanner(System.in);
					k1.nextLine();
					continue;
				}
				System.out.println();
				if (pasientListe.hent(posPasient - 1).pasientResepter.stoerrelse() == 0) {
					System.out.println("Pasienten har ingen utskrevne resepter");
					System.out.println();
					System.out.println("Trykk Enter for aa gaa tilbake til Hovedmeny");
					System.out.println();
					Scanner k1 = new Scanner(System.in);
					k1.nextLine();
					continue;
				}
				System.out.println("Pasienten har faatt utskrevet reseptene: ");
				System.out.println("_______________________________________________________");
				int s = 0;
				for (Resept r : pasientListe.hent(posPasient - 1).pasientResepter) {
					s++;
					System.out.println(s + ". " + r.hentLegemiddel() + " (Resept ID: " + r.hentId()
							+ ", gjenstaaende re-it: " + r.hentReit() + ")");
					System.out.println();
				}
				System.out.println("_______________________________________________________");
				Scanner obj8 = new Scanner(System.in);
				System.out.println("Onsker du aa bruke en resept? ja/nei");
				String v = obj8.nextLine();
				if (v.equals("ja")) {
					System.out.println("");
					System.out.println("Velg resepten du vil bruke fra listen over");
					Scanner obj9 = new Scanner(System.in);
					int posResept = 0;
					try {
						posResept = Integer.parseInt(obj9.nextLine());
					} catch (Exception e) {
						posResept = 0;
					}
					if (posResept > pasientListe.hent(posPasient - 1).pasientResepter.stoerrelse() || posResept <= 0) {
						System.out.println();
						System.out.println("Ugyldig alternativ valgt fra meny");
						System.out.println();
						System.out.println("Trykk Enter for aa gaa tilbake til Hovedmeny");
						System.out.println();
						Scanner k1 = new Scanner(System.in);
						k1.nextLine();
						continue;
					}
					System.out.println();
					pasientListe.hent(posPasient - 1).pasientResepter.hent(posResept - 1).bruk();
					if (pasientListe.hent(posPasient - 1).pasientResepter.hent(posResept - 1).hentReit() == 0) {
						System.out.println("Kunne ikke bruke resept, ingen gjenvaerende re-it");
						System.out.println();
						System.out.println("Trykk Enter for aa gaa tilbake til Hovedmeny");
						System.out.println();
						Scanner k1 = new Scanner(System.in);
						k1.nextLine();
						continue;
					} else {
						System.out.println("1 re-it av denne resepten brukt, "
								+ pasientListe.hent(posPasient - 1).pasientResepter.hent(posResept - 1).hentReit()
								+ " gjenstaar");
						System.out.println();
						System.out.println("Trykk Enter for aa gaa tilbake til Hovedmeny");
						System.out.println();
						Scanner k1 = new Scanner(System.in);
						k1.nextLine();
						continue;
					}
				} else if (v.equals("nei")) {
					System.out.println();
					System.out.println("Trykk Enter for aa gaa tilbake til Hovedmeny");
					System.out.println();
					Scanner k1 = new Scanner(System.in);
					k1.nextLine();
					continue;
				}

				// Alternativ gir brukeren oversikt over utskrevne resepter paa narkotiske og
				// vanedannende legemidler, og oversikt over hvilke leger og pasienter som har
				// skrevet og faat utskrevet narkotiske resepter
			} else if (a.equals("5")) {
				int antVanedannende = 0;
				int antNarkotisk = 0;
				for (Resept r : reseptListe) {
					if (r.legemiddel.hentType().equals("vanedannende")) {
						antVanedannende++;
					} else if (r.legemiddel.hentType().equals("narkotisk")) {
						antNarkotisk++;
					}
				}
				System.out.println("________________________________________________________________");
				System.out.println("Totalt antall utskrevne resepter på vanedannende legemidler: " + antVanedannende);
				System.out.println("Totalt antall utskrevne resepter på narkotiske legemidler: " + antNarkotisk);
				int antLegeResept = 0;
				System.out.println("________________________________________________________________");
				System.out.println("Leger som har skrevet ut narkotiske resepter:");
				for (Lege r : legeListe) {
					for (Resept s : r.utskrevneResepter) {
						if (s.legemiddel.hentType().equals("narkotisk")) {
							antLegeResept++;
							System.out.println(r.navn + ": " + antLegeResept + " resepter");
						}
					}
				}
				if (antLegeResept == 0) {
					System.out.println("Ingen leger");
				}
				System.out.println("________________________________________________________________");
				int antPasientResept = 0;
				System.out.println("Pasienter som har fått skrevet ut narkotiske resepter:");
				for (Pasient r : pasientListe) {
					for (Resept s : r.pasientResepter) {
						if (s.legemiddel.hentType().equals("narkotisk")) {
							antPasientResept++;
							System.out.println(r.navn + ": " + antLegeResept + " resepter");
						}
					}
				}
				if (antPasientResept == 0) {
					System.out.println("Ingen pasienter");
				}
				System.out.println("________________________________________________________________");
				System.out.println();
				System.out.println("Trykk Enter for aa gaa tilbake til Hovedmeny");
				System.out.println();
				Scanner k = new Scanner(System.in);
				k.nextLine();
				continue;

				// Alternativ som lar brukeren lese inn data fra en .txt fil som er i samme
				// mappe som resten av programmet
			} else if (a.equals("6")) {
				lesFil();
				System.out.println();
				System.out.println("Trykk Enter for aa gaa tilbake til Hovedmeny");
				System.out.println();
				Scanner k = new Scanner(System.in);
				k.nextLine();
				continue;

				// Alternativ som lar brukeren skrive ut eksisterende elementer og data til en
				// ny .txt fil med valgfritt navn. Om navnet eksister fra for av, overskrives
				// den gamle filen
			} else if (a.equals("7")) {
				skrivUtFil();
				System.out.println();
				System.out.println("Trykk Enter for aa gaa tilbake til Hovedmeny");
				System.out.println();
				Scanner k = new Scanner(System.in);
				k.nextLine();
				continue;

				// Alternativ som lar brukeren avslutte programmet. Brukeren vil ogsaa bli spurt
				// om det er onskelig aa skrive ut data fra systemet til en ny fil for
				// programmet avsluttes
			} else if (a.equals("8")) {
				System.out.println("Onsker du aa skrive dataene til en fil for du avslutter programmet? ja/nei");
				Scanner s = new Scanner(System.in);
				String k = s.nextLine();
				if (k.equals("ja")) {
					skrivUtFil();
					System.out.println();
					System.out.println("*****************");
					System.out.println("Program avsluttet");
					System.out.println("*****************");
					break;
				} else if (k.equals("nei")) {
					System.out.println();
					System.out.println("*****************");
					System.out.println("Program avsluttet");
					System.out.println("*****************");
					break;
				} else {
					System.out.println("Ugyldig valg");
					System.out.println();
					System.out.println("Trykk Enter for aa gaa tilbake til Hovedmeny");
					System.out.println();
					Scanner k1 = new Scanner(System.in);
					k1.nextLine();
					continue;
				}
			} else {
				System.out.println();
				System.out.println("Ugyldig alternativ valgt fra hovedmeny, trykk Enter for aa prove igjen");
				System.out.println();
				Scanner k = new Scanner(System.in);
				k.nextLine();
				continue;
			}
		}
	}

	// Metode for aa legge til en ny lege i systemet
	public static void leggTilLege(String navn, String kontrollID) {
		if (kontrollID.equals("0")) {
			Lege lege = new Lege(navn);
			legeListe.leggTil(lege);
		} else {
			Lege lege = new Spesialist(navn, kontrollID);
			legeListe.leggTil(lege);
		}
	}

	// Metode for aa legge til en ny pasient i systemet
	public static void leggTilPasient(String navn, String fodselsnummer) {
		Pasient pasient = new Pasient(navn, fodselsnummer);
		pasientListe.leggTil(pasient);
	}

	// Metode for aa legge til en ny legemiddel i systemet
	public static void leggTilLegemiddel(String navn, int pris, double virkestoff, int styrke, String type) {
		if (type.equals("vanlig")) {
			Legemiddel legemiddel = new Vanlig(navn, pris, virkestoff);
			legemiddelListe.leggTil(legemiddel);
		} else if (type.equals("narkotisk")) {
			Legemiddel legemiddel = new Narkotisk(navn, pris, virkestoff, styrke);
			legemiddelListe.leggTil(legemiddel);
		} else if (type.equals("vanedannende")) {
			Legemiddel legemiddel = new Vanedannende(navn, pris, virkestoff, styrke);
			legemiddelListe.leggTil(legemiddel);
		}
	}

	// Metode for aa legge til en ny resept i systemet
	public static void leggTilResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit,
			String type) throws UlovligUtskrift {
		if (type.equals("hvit")) {
			reseptListe.leggTil(utskrivendeLege.skrivHvitResept(legemiddel, pasient, reit));
		} else if (type.equals("blaa")) {
			reseptListe.leggTil(utskrivendeLege.skrivBlaaResept(legemiddel, pasient, reit));
		} else if (type.equals("militaer")) {
			reseptListe.leggTil(utskrivendeLege.skrivMilResept(legemiddel, pasient));
		} else if (type.equals("p")) {
			reseptListe.leggTil(utskrivendeLege.skrivPResept(legemiddel, pasient, reit));
		}
	}

	// Metode for aa skrive ut komplett informasjon om alle elementene i systemet
	public static void skrivUtInfo() {
		System.out.println("_______________________________________");
		System.out.println("Leger i systemet:");
		System.out.println();
		if (legeListe.stoerrelse() == 0) {
			System.out.println("Ingen leger registrert i systemet");
			System.out.println();
		} else {
			for (Lege r : legeListe) {
				System.out.println(r.toString());
				System.out.println();
			}
		}
		System.out.println("_______________________________________");
		System.out.println();
		System.out.println("Legemidler i systemet:");
		System.out.println();
		if (legemiddelListe.stoerrelse() == 0) {
			System.out.println("Ingen legemidler registrert i systemet");
			System.out.println();
		} else {
			for (Legemiddel r : legemiddelListe) {
				System.out.println(r.toString());
				System.out.println();
			}
		}
		System.out.println("_______________________________________");
		System.out.println();
		System.out.println("Pasienter i systemet:");
		System.out.println();
		if (pasientListe.stoerrelse() == 0) {
			System.out.println("Ingen pasienter registrert i systemet");
			System.out.println();
		} else {
			for (Pasient r : pasientListe) {
				System.out.println(r.navn);
				System.out.println();
			}
		}
		System.out.println("_______________________________________");
		System.out.println();
		System.out.println("Resepter i systemet:");
		System.out.println();
		if (reseptListe.stoerrelse() == 0) {
			System.out.println("Ingen resepter registrert i systemet");
			System.out.println();
		} else {
			for (Resept r : reseptListe) {
				System.out.println(r.toString());
				System.out.println();
			}
		}
		System.out.println("_______________________________________");
	}

	// Metode for aa lese inn data fra en .txt fil
	public static void lesFil() throws UlovligUtskrift {
		Scanner s = new Scanner(System.in);
		System.out.println("Skriv inn filnavn. Filen maa vaere en .txt fil og i samme mappe som programmet");
		String filnavn = s.nextLine() + ".txt";
		try {
			File fil = new File(filnavn);
			Scanner scanner = new Scanner(fil);

			while (scanner.hasNext()) {
				if (scanner.hasNext("#")) {
					scanner.next();
					if (scanner.hasNext("Pasienter")) {
						scanner.nextLine();
						while (scanner.hasNext() && !scanner.hasNext("#")) {
							String[] k = scanner.nextLine().split(",");
							String navn = k[0];
							String fnr = k[1];
							Pasient pasient = new Pasient(navn, fnr);
							pasientListe.leggTil(pasient);
						}
					}

					else if (scanner.hasNext("Legemidler")) {
						scanner.nextLine();
						while (scanner.hasNext() && !scanner.hasNext("#")) {
							try {
								String[] k = scanner.nextLine().split(",");
								String navn = k[0];
								String type = k[1];
								int pris = Integer.parseInt(k[2]);
								double virkestoff = Double.parseDouble(k[3]);
								if (type.equals("vanlig")) {
									Legemiddel legemiddel = new Vanlig(navn, pris, virkestoff);
									legemiddelListe.leggTil(legemiddel);
								} else if (type.equals("narkotisk")) {
									int styrke = Integer.parseInt(k[4]);
									Legemiddel legemiddel = new Narkotisk(navn, pris, virkestoff, styrke);
									legemiddelListe.leggTil(legemiddel);
								} else if (type.equals("vanedannende")) {
									int styrke = Integer.parseInt(k[4]);
									Legemiddel legemiddel = new Vanedannende(navn, pris, virkestoff, styrke);
									legemiddelListe.leggTil(legemiddel);
								}
							} catch (NumberFormatException x) {
								scanner.nextLine();
							}
						}
					}

					else if (scanner.hasNext("Leger")) {
						scanner.nextLine();
						while (scanner.hasNext() && !scanner.hasNext("#")) {
							String[] k = scanner.nextLine().split(",");
							String navn = k[0];
							String kontrollid = k[1];
							if (kontrollid.equals("0")) {
								Lege lege = new Lege(navn);
								legeListe.leggTil(lege);
							} else {
								Lege lege = new Spesialist(navn, kontrollid);
								legeListe.leggTil(lege);
							}
						}
					}

					else if (scanner.hasNext("Resepter")) {
						scanner.nextLine();
						while (scanner.hasNext() && !scanner.hasNext("#")) {
							String[] k = scanner.nextLine().split(",");
							int legemiddelNummer = Integer.parseInt(k[0]);
							String legeNavn = k[1];
							int pasientID = Integer.parseInt(k[2]);
							String type = k[3];

							Lege lege = null;
							Legemiddel legemiddel = null;
							Pasient pasient = null;

							for (Lege i : legeListe) {
								if (i.navn.equals(legeNavn)) {
									lege = i;
								}
							}
							for (Legemiddel i : legemiddelListe) {
								if (i.id == legemiddelNummer) {
									legemiddel = i;
								}
							}
							for (Pasient i : pasientListe) {
								if (i.id == pasientID) {
									pasient = i;
								}
							}
							if (legemiddel == null) {
								scanner.nextLine();
								continue;
							}

							else if (type.equals("hvit")) {
								int reit = Integer.parseInt(k[4]);
								leggTilResept(legemiddel, lege, pasient, reit, type);
							} else if (type.equals("militaer")) {
								leggTilResept(legemiddel, lege, pasient, 0, type);
							} else if (type.equals("p")) {
								int reit = Integer.parseInt(k[4]);
								leggTilResept(legemiddel, lege, pasient, reit, type);
							} else if (type.equals("blaa")) {
								int reit = Integer.parseInt(k[4]);
								leggTilResept(legemiddel, lege, pasient, reit, type);
							}
						}
					}
				}
			}
			System.out.println("Lesing av fil velykket!");
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("Fil ikke funnet");
			e.printStackTrace();
		} catch (NumberFormatException f) {
			System.out.println("Feil i filen");
			f.printStackTrace();
		}
	}

	// Metode for aa skrive ut data fra systemet til en ny eller eksisterende .txt
	// fil
	public static void skrivUtFil() {
		Scanner s = new Scanner(System.in);
		System.out.println("Skriv inn onsket filnavn. Filen blir lagret som en .txt fil i samme mappe som programmet");
		String filnavn = s.nextLine() + ".txt";
		try {
			FileWriter myWriter = new FileWriter(filnavn);
			String pasienter = "# Pasienter (navn, fnr)";
			for (Pasient r : pasientListe) {
				String navn = r.navn;
				String fnr = r.fodselsnummer;
				String p = navn + "," + fnr;
				pasienter = pasienter + '\n' + p;
			}
			String legemidler = "# Legemidler (navn,type,pris,virkestoff,[styrke])";
			for (Legemiddel r : legemiddelListe) {
				String navn = r.hentNavn();
				String type = r.hentType();
				int pris = r.hentPris();
				double virkestoff = r.hentVirkestoff();
				if (type.equals("vanlig")) {
					String l = navn + "," + type + "," + pris + "," + virkestoff;
					legemidler = legemidler + '\n' + l;
				} else {
					int styrke = r.hentStyrke();
					String l = navn + "," + type + "," + pris + "," + virkestoff + "," + styrke;
					legemidler = legemidler + '\n' + l;
				}
			}
			String leger = "# Leger (navn,kontrollid / 0 hvis vanlig lege)";
			for (Lege r : legeListe) {
				String navn = r.navn;
				String kontrollID;
				if (!r.hentKontrollID().equals("0")) {
					kontrollID = r.hentKontrollID();
				} else {
					kontrollID = "0";
				}
				String le = navn + "," + kontrollID;
				leger = leger + '\n' + le;
			}
			String resepter = "# Resepter (legemiddelNummer,legeNavn,pasientID,type,[reit])";
			for (Resept r : reseptListe) {
				int legemiddelNummer = r.legemiddel.id;
				String navn = r.utskrivendeLege.hentNavn();
				int pasientID = r.hentPasientId();
				String type = r.hentType();
				String m;
				if (type.equals("militaer")) {
					m = legemiddelNummer + "," + navn + "," + pasientID + "," + type;
				} else {
					int reit = r.reit;
					m = legemiddelNummer + "," + navn + "," + pasientID + "," + type + "," + reit;
				}
				resepter = resepter + '\n' + m;
			}
			String skrivUt = pasienter + '\n' + legemidler + '\n' + leger + '\n' + resepter;
			myWriter.write(skrivUt);
			myWriter.close();
			System.out.println();
			System.out.println("Fil lagret!");
		} catch (IOException e) {
			System.out.println("En feil har skjedd");
			e.printStackTrace();
		}
	}
}