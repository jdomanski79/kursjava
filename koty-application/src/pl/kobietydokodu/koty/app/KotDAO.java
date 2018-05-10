package pl.kobietydokodu.koty.app;


import java.util.ArrayList;
import java.util.List;

import pl.kobietydokodu.koty.domain.Kot;


public class KotDAO {
	List<Kot> kotDAO = new ArrayList<Kot>();
	
	public void dodajKota(Kot kot) {
		kotDAO.add(kot);
		System.out.println("Kot dodany do kolekcji\n");
	}
	
	public Kot pobierzKota(int id) {
		return kotDAO.get(id);
	}
	
	public int iloscKotow() {
		return kotDAO.size();
	}
	
	public void drukujKoty() {
		System.out.println("Lista kot�w:");
		
		if (kotDAO.isEmpty()) {
			System.out.println("Kot�w brak.. :(");
			return;
		}
		
		for (int i = 0; i < kotDAO.size(); i++) {
			System.out.println((i+1) + ". " + kotDAO.get(i).getImie());
		}
	}
}
