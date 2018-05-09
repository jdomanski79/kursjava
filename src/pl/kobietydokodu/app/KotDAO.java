package pl.kobietydokodu.app;

import java.util.ArrayList;
import java.util.List;

import pl.kobietydokodu.domain.Kot;

public class KotDAO {
	List<Kot> koty = new ArrayList<Kot>();
	
	public void dodajKota(Kot kot) {
		koty.add(kot);
		System.out.println("Kot dodany do kolekcji\n");
	}
	
	public Kot pobierzKota(int id) {
		return koty.get(id);
	}
	
	public int iloscKotow() {
		return koty.size();
	}
	
	public void drukujKoty() {
		System.out.println("Lista kotów:");
		
		if (koty.isEmpty()) {
			System.out.println("Kotów brak.. :(");
			return;
		}
		
		for (int i = 0; i < koty.size(); i++) {
			System.out.println((i+1) + ". " + koty.get(i).getImie());
		}
	}
}
