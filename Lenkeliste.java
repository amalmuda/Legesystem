import java.util.Iterator;

abstract class Lenkeliste<T> implements Liste<T> {

	// Variabler for aa holde styr paa hvor mange ganger elementer har blitt lagt
	// til, fjernet og overskrevet
	protected int lagtTil;
	protected int fjernetFraListe;
	protected int overskrevet;
	protected T sistFjernet;

	// Noder for aa definere hva som er start og slutt av listen
	protected Node start;
	protected Node slutt;

	// Nested klasse for aa holde styr paa elementene som blir lagt inn i listen
	class Node {
		Node neste;
		Node forrige;
		T data;

		Node(T x) {
			this.data = x;
		}
	}

	// Iterator som kan iterere gjennom en liste-objekt
	class LenkelisteIterator implements Iterator<T> {
		Node peker;

		public LenkelisteIterator() {
			peker = start;
		}

		public T next() {
			Node k = peker;
			peker = peker.neste;
			return k.data;
		}

		public boolean hasNext() {
			return peker != null;
		}
	}

	// Metode for aa legge til et element i listen. Elementene blir lagt til sist i
	// listen
	public void leggTil(T x) {
		Node nyNode = new Node(x);
		if (start == null) {
			start = nyNode;
			slutt = nyNode;
		} else {
			nyNode.forrige = slutt;
			slutt.neste = nyNode;
			slutt = nyNode;
		}
		lagtTil++;
	}

	// Metode som forteller oss hvor mange elementer det er i listen
	public int stoerrelse() {
		int antall = 0;
		Node peker = start;
		while (peker != null) {
			antall++;
			peker = peker.neste;
		}
		return antall;
	}

	// Metode som gir oss det forste elementet i listen
	public T hent() {
		return start.data;
	}

	// Metode som fjerner det forste elementet i listen, samtidig som den forteller
	// oss hvilke data det er i elementet som ble fjernet
	public T fjern() {
		fjernetFraListe++;
		if (start == null) {
			throw new UgyldigListeindeks(-1);
		} else {
			T sistFjernet = start.data;
			start = start.neste;
			return sistFjernet;
		}
	}

	// Metode som oppretter en ny liste-iterator
	public Iterator<T> iterator() {
		return new LenkelisteIterator();
	}

	// Metode som gir oss en liste om hvilke elementer det er i enhver indeks i
	// listen og samtidig hvor mange elementer det er totalt
	// I tilegg ogsaa hvor mange elementer som har blitt lagt til og fjernet i
	// listen
	public String toString() {
		T d;
		int i = 0;
		String s = "";
		String p = "";
		Node k = start;
		while (i < stoerrelse()) {
			d = k.data;
			k = k.neste;
			s = s + " " + d;
			p = p + " " + i;
			i++;
		}
		return "Indeks:" + p + '\n' + "Data:  " + s + '\n' + '\n' + "Totalt antall elementer: " + stoerrelse() + '\n'
				+ '\n' + "Antall elementer lagt til: " + lagtTil + '\n' + "Antall elementer fjernet: " + fjernetFraListe
				+ '\n' + "Antall elementer overskrevet: " + overskrevet;
	}
}