package pl.kobietydokodu.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import pl.kobietydokodu.domain.Kot;

public class Interfejs {
	static Scanner input = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		KotDAO kotDAO = new KotDAO();
		// zape³nienie listy
		
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
		} while(wybor != "x");
		
	}
	
	public static void obsluzListeKotow(KotDAO kotDAO) {
		if (kotDAO.iloscKotow() == 0) {
			System.out.println("Brak kotów.. :(");
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
	 * drukuje g³ówne menu programu
	 */
	public static void printMenu() {
		System.out.println("\nWybierz opcjê:");
		System.out.println("");
		System.out.println("1. Dodaj kota");
		System.out.println("2. Lista kotów");
		System.out.println("x - zakoñcz");
	}
	
	public static void printCatList(KotDAO kotDAO) {
		kotDAO.drukujKoty();
	}
	
	/**
	 * Tworzy i zwraca nowy obiekt kota na podstawie danych wpisanych przez u¿ytkownika
	 * @return Kot
	 */
	public static Kot getKot() {
		
		Kot kot = new Kot();
		
		//imiê
		System.out.println("Podaj imiê:");
		kot.setImie(getUserInput());

		//w³aœciciel
		System.out.println("Podaj w³aœciciela:");
		kot.setOpiekun(getUserInput());

		//data urodzenia
		Date dataUrodzenia = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");

		do {
			System.out.println("Podaj datê urodzenia:");
			try {
				dataUrodzenia = sdf.parse(getUserInput());
				kot.setDataUrodzenia(dataUrodzenia);
			} catch(ParseException pe){
				System.out.println("Podaj prawid³ow¹ datê w formacie yyyy.MM.dd: ");
			} 
		}
		while (kot.getDataUrodzenia() == null);
		
		//waga
		Float waga = 0.0f;

		do {
			System.out.println("Podaj wagê kota:");
			try {
				waga = Float.valueOf(getUserInput());
				kot.setWaga(waga);
			} 
			catch (NumberFormatException e) {
				System.out.println("Coœ nie tak z formatem liczby..");
			}

		} while(kot.getWaga() == null);
		
		
		return kot;
	}
	
	public static String getUserInput() {
		return input.nextLine().trim();
	}

}
