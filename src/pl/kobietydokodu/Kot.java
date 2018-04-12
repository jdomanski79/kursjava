package pl.kobietydokodu;

import java.util.Date;

public class Kot {
	private String imie;
	private Date dataUrodzenia;
	private Float waga;
	private String opiekun;
	
	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public Date getDataUrodzenia() {
		return dataUrodzenia;
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
				this.dataUrodzenia + " a mój opiekun to " +
				this.opiekun;
		return przedstawienie;
	}
	
	
	
}

