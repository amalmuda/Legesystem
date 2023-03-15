
//Subklasse som arver fra superklassen Lenkeliste
public class Prioritetskoe<T extends Comparable<T>> extends Lenkeliste<T> {

	// Metode som legger et element i en liste sortert etter lavest til hoyest verdi
	@Override
	public void leggTil(T x) {
		Node nyNode = new Node(x);
		if (start == null) {
			super.leggTil(x);
		} else {
			Node tmp = start;
			if (nyNode.data.compareTo(start.data) <= 0) {
				nyNode.neste = start;
				start.forrige = nyNode;
				start = nyNode;
			} else if (nyNode.data.compareTo(slutt.data) >= 0) {
				slutt.neste = nyNode;
				nyNode.forrige = slutt;
				slutt = nyNode;
			} else {
				int t = 0;
				int i = 1;
				Node k = new Node(tmp.data);
				while (i < stoerrelse()) {
					i++;
					tmp = tmp.neste;
					Node s = new Node(tmp.data);
					if (nyNode.data.compareTo(s.data) >= 0 || t == 1) {
						k.neste = s;
						s.forrige = k;
						k = s;
					}
					if (nyNode.data.compareTo(s.data) <= 0 && t == 0) {
						k.neste = nyNode;
						nyNode.forrige = k;
						k = nyNode;
						k.neste = s;
						s.forrige = k;
						k = s;
						t = 1;
					}
				}
				int z = stoerrelse();
				start = null;
				slutt = null;
				int r = 0;
				Node c = k;
				while (r < z + 1) {
					r++;
					leggTil(c.data);
					c = c.forrige;
				}
			}
		}
		lagtTil++;
	}
}