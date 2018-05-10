package pl.kobietydokodu.koty.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import pl.kobietydokodu.koty.domain.*;
public class Interfejs {
	static Scanner input = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		KotDAO kotDAO = new KotDAO();
		// zape�nienie listy
		
		kotDAO.dodajKota(new Kot("Balbina", "Jarek"));
		kotDAO.dodajKota(new Kot("Rychu", "Agnieszka"));
		
		String wybor;
		
		
		do {
			printMenu();
			wybor = getUserInput();
			switch (wybor) {
				case "1": 
					kotDAO.dodajKota(getKot());
					break;
				case "2":
					obsluzListeKotow(kotDAO);
					
					break;
			}
		} while(!wybor.equals("x"));
		
	}
	
	public static void obsluzListeKotow(KotDAO kotDAO) {
		if (kotDAO.iloscKotow() == 0) {
			System.out.println("Brak kot�w.. :(");
			return;
		}
		
		Kot kot = null;
		String wybor;
		int id;
		do {
			printCatList(kotDAO);
			wybor = getUserInput();
			
			if (Pattern.matches("\\d", wybor)) {
				id = Integer.valueOf(wybor) - 1;
				
				if (id > kotDAO.iloscKotow() - 1 || id < 0) {
					System.out.println("Brak kota o takim ID!");
					return;
				}
				
				System.out.println("ID kota to: " + id);
				kot = kotDAO.pobierzKota(id);
				System.out.println(kot.przedstawSie());
			}
			
		} while (kot == null); 
	}

	/**
	 * drukuje g��wne menu programu
	 */
	public static void printMenu() {
		System.out.println("\nWybierz opcj�:");
		System.out.println("");
		System.out.println("1. Dodaj kota");
		System.out.println("2. Lista kot�w");
		System.out.println("x - zako�cz");
	}
	
	public static void printCatList(KotDAO kotDAO) {
		kotDAO.drukujKoty();
	}
	
	/**
	 * Tworzy i zwraca nowy obiekt kota na podstawie danych wpisanych przez u�ytkownika
	 * @return Kot
	 */
	public static Kot getKot() {
		
		Kot kot = new Kot();
		
		//imi�
		System.out.println("Podaj imi�:");
		kot.setImie(getUserInput());

		//w�a�ciciel
		System.out.println("Podaj w�a�ciciela:");
		kot.setOpiekun(getUserInput());

		//data urodzenia
		Date dataUrodzenia = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");

		do {
			System.out.println("Podaj dat� urodzenia:");
			try {
				dataUrodzenia = sdf.parse(getUserInput());
				kot.setDataUrodzenia(dataUrodzenia);
			} catch(ParseException pe){
				System.out.println("Podaj prawid�ow� dat� w formacie yyyy.MM.dd: ");
			} 
		}
		while (kot.getDataUrodzenia() == null);
		
		//waga
		Float waga = 0.0f;

		do {
			System.out.println("Podaj wag� kota:");
			try {
				waga = Float.valueOf(getUserInput());
				kot.setWaga(waga);
			} 
			catch (NumberFormatException e) {
				System.out.println("Co� nie tak z formatem liczby..");
			}

		} while(kot.getWaga() == null);
		
		
		return kot;
	}
	
	public static String getUserInput() {
		return input.nextLine().trim();
	}

}
