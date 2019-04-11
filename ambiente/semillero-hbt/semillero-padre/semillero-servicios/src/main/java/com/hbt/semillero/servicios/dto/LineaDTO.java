package com.hbt.semillero.servicios.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hbt.semillero.entidades.Marca;

/**
 *
 * Linea de un vehiculo
 *
 */

public class LineaDTO {

	
	private Long idLinea;

	private String nombre;

	private int cilindraje;

	private MarcaDTO marca;

	/**
	 * Metodo que obtiene el valor de la propiedad idLinea
	 * @return the idLinea
	 */
	public Long getIdLinea() {
		return idLinea;
	}

	/**
	 * Metodo que asigna el valor de la propiedad idLinea
	 * @param idLinea the idLinea to set
	 */
	public void setIdLinea(Long idLinea) {
		this.idLinea = idLinea;
	}

	/**
	 * Metodo que obtiene el valor de la propiedad nombre
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo que asigna el valor de la propiedad nombre
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo que obtiene el valor de la propiedad cilindraje
	 * @return the cilindraje
	 */
	public int getCilindraje() {
		return cilindraje;
	}

	/**
	 * Metodo que asigna el valor de la propiedad cilindraje
	 * @param cilindraje the cilindraje to set
	 */
	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}

	/**
	 * Metodo que obtiene el valor de la propiedad marca
	 * @return the marca
	 */
	public MarcaDTO getMarca() {
		return marca;
	}

	/**
	 * Metodo que asigna el valor de la propiedad marca
	 * @param marca the marca to set
	 */
	public void setMarca(MarcaDTO marca) {
		this.marca = marca;
	}
	
}
