package model;

public class Auto {

	Long id;
	String modelo;
	String marca;
	String color;
	Integer anio;
	String propietario;
	Double costo;
	Boolean primeraMano;

	public Auto() {
	}

	public Auto(Long id, String modelo, String marca, String color, Integer anio, String propietario, Double costo,
			Boolean primeraMano) {
		this.id = id;
		this.modelo = modelo;
		this.marca = marca;
		this.color = color;
		this.anio = anio;
		this.propietario = propietario;
		this.costo = costo;
		this.primeraMano = primeraMano;

	}
	
	//Getters y Setters

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}

	public Boolean getPrimeraMano() {
		return primeraMano;
	}

	public void setPrimeraMano(Boolean primeraMano) {
		this.primeraMano = primeraMano;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Auto [id=" + id + ", modelo=" + modelo + ", marca=" + marca + ", color=" + color + ", anio=" + anio
				+ ", propietario=" + propietario + ", costo=" + costo + ", primeraMano=" + primeraMano + "]";
	}

}
