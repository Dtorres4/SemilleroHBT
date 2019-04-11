package com.hbt.semillero.servicios.interfaces;

import java.util.List;

import javax.ejb.Local;

import com.hbt.semillero.entidades.Linea;
import com.hbt.semillero.entidades.Marca;
import com.hbt.semillero.entidades.Persona;
import com.hbt.semillero.servicios.dto.LineaDTO;
import com.hbt.semillero.servicios.dto.MarcaDTO;
import com.hbt.semillero.servicios.dto.PersonaDTO;

@Local
public interface IConsultasBeanLocal {
	
	public List<Marca> consultarMarcas();
	
	public List<Linea> consultarLineas(Long idMarca);
	
	public void crearPersona(PersonaDTO personaDTO);
	
	public List<Persona> consultarPersona(String numeroIdentificacion, String tipoId);
	
	public void editarPersona(PersonaDTO personaDTO);

}
