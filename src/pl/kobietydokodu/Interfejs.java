package pl.kobietydokodu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Interfejs {
	static Scanner input = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Kot kot = new Kot();
		
		
		
		
		System.out.println("Podaj imi�:");
		kot.setImie(getUserInput());
		
		System.out.println("Podaj w�a�ciciela:");
		kot.setOpiekun(getUserInput());
		
		
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
		
		System.out.println(kot.przedstawSie());
	}
	
	
	
	public static String getUserInput() {
		return input.nextLine().trim();
	}

}
