package br.com.ps.missoes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Missoes {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String dataTerra;
	private int diasMarte;
	private Long longSolar;
	private int mesMarte;
	private Long minTemp;
	private Long maxTemp;
	private Long pressaoAtm;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDataTerra() {
		return dataTerra;
	}
	public void setDataTerra(String dataTerra) {
		this.dataTerra = dataTerra;
	}
	public int getDiasMarte() {
		return diasMarte;
	}
	public void setDiasMarte(int diasMarte) {
		this.diasMarte = diasMarte;
	}
	public Long getLongSolar() {
		return longSolar;
	}
	public void setLongSolar(Long longSolar) {
		this.longSolar = longSolar;
	}
	public int getMesMarte() {
		return mesMarte;
	}
	public void setMesMarte(int mesMarte) {
		this.mesMarte = mesMarte;
	}
	public Long getMinTemp() {
		return minTemp;
	}
	public void setMinTemp(Long minTemp) {
		this.minTemp = minTemp;
	}
	public Long getMaxTemp() {
		return maxTemp;
	}
	public void setMaxTemp(Long maxTemp) {
		this.maxTemp = maxTemp;
	}
	public Long getPressaoAtm() {
		return pressaoAtm;
	}
	public void setPressaoAtm(Long pressaoAtm) {
		this.pressaoAtm = pressaoAtm;
	}
}
