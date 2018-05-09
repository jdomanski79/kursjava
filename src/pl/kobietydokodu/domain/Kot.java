package pl.kobietydokodu.domain;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Kot {
	private String imie;
	private Date dataUrodzenia;
	private Float waga;
	private String opiekun;
	
	
	public Kot() {}
	
	public Kot(String imie, String opiekun) {
		Random r = new Random();
		this.imie = imie;
		this.dataUrodzenia = new Date();
		this.waga = r.nextFloat()*5 + 2;
		this.opiekun = opiekun;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getDataUrodzenia() {
		return DateFormat.getDateInstance(DateFormat.LONG).format(dataUrodzenia);
	}

	public void setDataUrodzenia(Date dataUrodzenia) {
		this.dataUrodzenia = dataUrodzenia;
	}

	public Float getWaga() {
		return waga;
	}

	public void setWaga(Float waga) {
		this.waga = waga;
	}

	public String getOpiekun() {
		return opiekun;
	}

	public void setOpiekun(String opiekun) {
		this.opiekun = opiekun;
	}

	public String przedstawSie() {
		String przedstawienie = "Nazywam siê " + 
				this.imie + ", urodzony " + 
				this.getDataUrodzenia() + 
				"\nMój opiekun to " + this.opiekun +
				"\nWa¿ê " + this.waga + "kg.";
		return przedstawienie;
	}
	
	public static void main(String[] args) {
		Kot kot = new Kot();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		try {
			kot.setDataUrodzenia(sdf.parse("1980.12.11"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Data urodzenia: " + kot.getDataUrodzenia());
	}
	
}

