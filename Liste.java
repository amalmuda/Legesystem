
//Interface med nodvendige metoder for klasser som implementerer
public interface Liste<T> extends Iterable<T> {
	int stoerrelse();

	void leggTil(T x);

	T hent();

	T fjern();
}