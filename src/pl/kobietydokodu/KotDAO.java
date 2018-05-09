package pl.kobietydokodu;

import java.util.ArrayList;
import java.util.List;

public class KotDAO {
	List<Kot> koty = new ArrayList<Kot>();
	
	public void dodajKota(Kot kot) {
		koty.add(kot);
		System.out.println("Kot dodany do kolekcji");
	}
}
