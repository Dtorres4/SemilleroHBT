package com.hbt.semillero.servicios.dto;

import java.io.Serializable;

public class MarcaDTO implements Serializable {
	
	private static final long serialVersionUID = 1;
	
	private Long idMarca;
	
	private String nombre;

	/**
	 * Metodo que obtiene el valor de la propiedad idMarca
	 * @return the idMarca
	 */
	public Long getIdMarca() {
		return idMarca;
	}

	/**
	 * Metodo que asigna el valor de la propiedad idMarca
	 * @param idMarca the idMarca to set
	 */
	public void setIdMarca(Long idMarca) {
		this.idMarca = idMarca;
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
	 * Metodo que obtiene el valor de la propiedad serialversionuid
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
