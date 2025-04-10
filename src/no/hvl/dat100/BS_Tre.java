package no.hvl.dat100;

import java.util.Iterator;

public class BS_Tre<T extends Comparable<? super T>> implements SoektreInterface<T> {

	private BinaerTreNode<T> rot;

	public BS_Tre() {
		rot = null;
	}

	public BS_Tre(T element) {
		rot = new BinaerTreNode<T>(element);
	}

	/**
	 * S�ker etter et gitt element i treet.
	 * 
	 * @param element elementet vi s�ker etter.
	 * @return true om elementet finst, false elles.
	 */
	public boolean inneholder(T element) {
		return false;
	}

	/**
	 * Henter et element i treet.
	 * 
	 * @param element elementet vi leter etter.
	 * @return Elementet dersom det finst, elles null.
	 */
	public T finn(T element) {
		return finn(element, rot);
	}

	private T finn(T element, BinaerTreNode<T> p) {
		T svar = null;

		// p == null -> tomt tre som er basistillfelle og svar blir null
		if (p != null) {
			int sml = element.compareTo(p.getElement());
			if (sml == 0) {
				svar = p.getElement();
			} else if (sml < 0) {
				svar = finn(element, p.getVenstre());
			} else {
				svar = finn(element, p.getHogre());
			}
		}
		return svar;
	}

	/**
	 * Legg et element til treet dersom det ikke finst fr� f�r. Elles ertstatter
	 * blir det gamle elementet erstattet med det nye.
	 * 
	 * @param nyElement elementet som skal legges til
	 * @return null om elementet ikke finst fr� f�r. Ellers det element som var i
	 *         treet fr� f�r.
	 */
	public T leggTil(T nyElement) {
		return leggTil(rot, nyElement).getElement();
	}

	private BinaerTreNode<T> leggTil(BinaerTreNode<T> p, T element) {
		if (p == null) {
			return new BinaerTreNode<T>(element);
		} else {
			if (element.compareTo(p.getElement()) < 0) {
				p.setVenstre(leggTil(p.getVenstre(), element));
			} else {
				// Alternativ med to kodelinjer
				BinaerTreNode<T> q = leggTil(p.getHogre(), element);
				p.setHogre(q);
			}
		}
		return p;
	}

	/**
	 * Fjernar et element fr� treet.
	 * 
	 * @param element elementet som skal fjernes.
	 * @return elementet som ble fjernet eller null om det ikke finst.
	 */
	public T fjern(T element) {
		return null;
	}

	/**
	 * Lager en iterator som g�r gjennom alle elementer i treet i inorden.
	 * 
	 * @return en iterator som elementene i sortert rekkef�lge.
	 */
	public Iterator<T> getInordenIterator() {
		return null;
	}

	public int hoyde() {
		return hoyde(rot);
	}
	

	private int hoyde(BinaerTreNode<T> p) {
		int svar = -1;
		// p == null -> tomt tre som er basistillfelle og svaret blir null

		if (p != null) {
			svar++;
			if (p.getHogre() != null || p.getVenstre() != null) {
				svar++;
				
				int hogre = hoyde(p.getHogre());
				int venstre = hoyde(p.getVenstre());
				if (hogre >= venstre) {
					svar += hogre;
				} else
					svar += venstre;
			}
		}
		return svar;
	}
	public int antNoder() {
		return antNoder(rot);
	}
	
	private int antNoder(BinaerTreNode<T> p) {
		int antall = 0;
		if (p != null) {
			antall++;
			antall += antNoder(p.getHogre());
			antall += antNoder(p.getVenstre());
		}
		return antall;
	}
		
	public static int minimumHoyde(int N) {
		if (N == 0) {
		return -1;
		}
		 int resultat = (int)(Math.log(N) / Math.log(2));
		return resultat;
	}
	public static int maksimumHoyde(int N) {
		return N-1;
	}
	
	
}
