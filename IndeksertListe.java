
//Subklasse som arver fra superklassen Lenkeliste
class IndeksertListe<T> extends Lenkeliste<T> {

	// Metode som legger et element i en liste ved aa oppgi onsket posisjon
	// Elementer lenger ut i listen forskyves til hoyre og faar en hoyere indeks
	public void leggTil(int pos, T x) {
		Node nyNode = new Node(x);
		if (start == null && pos == 0) {
			super.leggTil(x);
		} else if (pos == 0) {
			nyNode.neste = start;
			start.forrige = nyNode;
			start = nyNode;
		} else if (pos == stoerrelse()) {
			super.leggTil(x);
		} else if (pos < stoerrelse() && pos > 0) {
			int t = 0;
			while (t < 2) {
				Node tmp = start;
				Node k = new Node(start.data);
				int i = 1;
				while (i < stoerrelse()) {
					i++;
					tmp = tmp.neste;
					Node s = new Node(tmp.data);
					if (i == pos + 1 && t < 1) {
						k.forrige = nyNode;
						nyNode.neste = k;
						k = nyNode;
					}
					k.forrige = s;
					s.neste = k;
					k = s;
				}
				t++;
				start = k;
			}
		}
		lagtTil++;
	}

	// Metode som legger et element i en liste ved aa oppgi onsket posisjon
	// Elementet i den oppgitte posisjonen blir erstattet av den nye
	public void sett(int pos, T x) {
		overskrevet++;
		Node nyNode = new Node(x);
		if (pos >= stoerrelse()) {
			throw new UgyldigListeindeks(pos);
		}
		if (start == null && pos == 0) {
			super.leggTil(x);
		} else if (pos == 0) {
			start = start.neste;
			nyNode.neste = start;
			start.forrige = nyNode;
			start = nyNode;
		} else if (pos < stoerrelse() && pos >= 0) {
			int t = 0;
			while (t < 2) {
				Node tmp = start;
				int r = stoerrelse();
				Node k = new Node(start.data);
				int i = 1;
				while (i < r) {
					i++;
					tmp = tmp.neste;
					Node s = new Node(tmp.data);
					if (i == pos + 1 && t < 1) {
						k.forrige = nyNode;
						nyNode.neste = k;
						k = nyNode;
					} else {
						k.forrige = s;
						s.neste = k;
						k = s;
					}
				}
				t++;
				start = k;
			}
		}
	}

	// Metode som henter ut et element i en liste ved aa oppgi onsket posisjon
	public T hent(int pos) {
		Node peker = start;
		for (int i = 0; i < pos; i++) {
			peker = peker.neste;
		}
		return peker.data;
	}

	// Metode som fjerner et element i en liste ved aa oppgi onsket posisjon
	// Elementer lenger ut i listen forskyves til venstre og faar en lavere indeks
	// Metoden forteller oss ogsaa hvilke element som ble fjernet
	public T fjern(int pos) {
		fjernetFraListe++;
		if (pos >= stoerrelse()) {
			throw new UgyldigListeindeks(pos);
		}
		if (pos < stoerrelse() && pos >= 0) {
			int t = 0;
			while (t < 2) {
				Node tmp = start;
				int r = stoerrelse();
				Node k = new Node(start.data);
				int i = 1;
				while (i < r) {
					i++;
					tmp = tmp.neste;
					Node s = new Node(tmp.data);
					if (i == pos + 1 && t < 1) {
						sistFjernet = s.data;
					} else {
						k.forrige = s;
						s.neste = k;
						k = s;
					}
				}
				t++;
				start = k;
			}
		}
		return sistFjernet;
	}
}