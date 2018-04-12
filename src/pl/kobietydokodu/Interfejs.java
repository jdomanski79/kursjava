package pl.kobietydokodu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Interfejs {
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Kot kotek = new Kot();
		
		
		
		
		System.out.println("Podaj imiê:");
		kotek.setImie(getUserInput());
		
		System.out.println("Podaj w³aœciciela:");
		kotek.setOpiekun(getUserInput());
		
		System.out.println("Podaj datê urodzenia:");
		Date dataUrodzenia = null;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		Boolean niepoprawnaData = false;
		
		do {
			try {
				niepoprawnaData = false;
				dataUrodzenia = sdf.parse(getUserInput());
			} catch(ParseException pe){
				System.out.println("Podaj prawid³ow¹ datê:");
				niepoprawnaData = true;
			} 
		}
		while (niepoprawnaData);
		kotek.setDataUrodzenia(dataUrodzenia);
		
		System.out.println(kotek.przedstawSie());
	}
	
	
	
	public static String getUserInput() {
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}

}
