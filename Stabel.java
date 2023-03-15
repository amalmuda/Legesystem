
//Subklasse som arver fra superklassen Lenkeliste
public class Stabel<T> extends Lenkeliste<T> {

	// Metode som overskriver leggTil()-metoden fra superklassen Lenkeliste
	// Metoden legger elementene forst i listen
	@Override
	public void leggTil(T x) {
		Node nyNode = new Node(x);
		if (start == null) {
			super.leggTil(x);
		} else {
			nyNode.neste = start;
			slutt.forrige = nyNode;
			start = nyNode;
		}
		lagtTil++;
	}
}