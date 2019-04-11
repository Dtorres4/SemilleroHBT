package com.hbt.semillero.servicios.dto;

import java.io.Serializable;

public class ResultadoDTO implements Serializable {
	
	private boolean exitoso;
	
	private String mensajeError;

	/**
	 * Metodo que obtiene el valor de la propiedad exitoso
	 * @return the exitoso
	 */
	public boolean isExitoso() {
		return exitoso;
	}

	/**
	 * Metodo que asigna el valor de la propiedad exitoso
	 * @param exitoso the exitoso to set
	 */
	public void setExitoso(boolean exitoso) {
		this.exitoso = exitoso;
	}

	/**
	 * Metodo que obtiene el valor de la propiedad mensajeError
	 * @return the mensajeError
	 */
	public String getMensajeError() {
		return mensajeError;
	}

	/**
	 * Metodo que asigna el valor de la propiedad mensajeError
	 * @param mensajeError the mensajeError to set
	 */
	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}
	
	

}
