package com.hbt.semillero.servicios.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.entidades.Linea;
import com.hbt.semillero.entidades.Marca;
import com.hbt.semillero.entidades.Persona;
import com.hbt.semillero.servicios.dto.LineaDTO;
import com.hbt.semillero.servicios.dto.MarcaDTO;
import com.hbt.semillero.servicios.dto.PersonaDTO;
import com.hbt.semillero.servicios.dto.ResultadoDTO;
import com.hbt.semillero.servicios.interfaces.IConsultasBeanLocal;

@Path("/ServiciosRest")
public class ServiciosRest {
	
	@EJB
	private IConsultasBeanLocal consultasBean;
	
	/**
	 * este servicio nos permite consultar las marcas existentes	
	 * @return el arreglo de todas las marcas
	 */
	@GET
	@Path("/consultarMarcas")
	@Produces(MediaType.APPLICATION_JSON)
	public List<MarcaDTO> consultarMarcas(){
		List<Marca> marcas = consultasBean.consultarMarcas();
		List<MarcaDTO> retorno = new ArrayList<>();
		for (Marca marca : marcas) {
			MarcaDTO marcaDTO = construirMarcaDTO(marca);
			retorno.add(marcaDTO);
		}
		
		return retorno;
		
	}
	
	/**
	 * este servicio nos permite consultar todas las lineas asociadas a una marca
	 * @param idMarca
	 * @return lineas
	 */
	
	@GET
	@Path("/consultarLineas")
	@Produces(MediaType.APPLICATION_JSON)
	public List<LineaDTO> consultarLineas(@QueryParam(value = "idMarca") Long idMarca){
		List<Linea> lineas = consultasBean.consultarLineas(idMarca);
		List<LineaDTO> retorno = new ArrayList<>();
		for (Linea linea : lineas) {
			LineaDTO lineaDTO = new LineaDTO();
			lineaDTO.setIdLinea(linea.getIdLinea());
			lineaDTO.setCilindraje(linea.getCilindraje());
			lineaDTO.setNombre(linea.getNombre());
			MarcaDTO marcaDTO = construirMarcaDTO(linea.getMarca());
			lineaDTO.setMarca(marcaDTO);			
			retorno.add(lineaDTO);
		}
		
		return retorno;	
	}
	
	/**
	 * servicio que nos permite crear una nueva persona
	 * @param personaDTO
	 * @return
	 */
	@POST
	@Path("/crearPersona")
	@Produces(MediaType.APPLICATION_JSON)
	public ResultadoDTO crearPersona(PersonaDTO personaDTO){
		ResultadoDTO retorno = new ResultadoDTO();
		retorno.setExitoso(true);
		try {
			consultasBean.crearPersona(personaDTO);
		} catch (Exception e) {
			retorno.setExitoso(true);
			retorno.setMensajeError("No se pudo ingresar la persona");
		}
		return retorno;	
	}
	
	/**
	 * servicio nos permite consultar una persona existente
	 * a partir de un numero de identificacion y un tipo de identificacion
	 * @param numeroIdentificacion
	 * @param tipoIdentificacion
	 * @return
	 */
	@GET
	@Path("/consultarPersonas")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PersonaDTO> consultarPersonas(@QueryParam(value = "numeroIdentificacion") String numeroIdentificacion ,@QueryParam(value = "tipoIdentificacion") String tipoIdentificacion){
		List<Persona> personas = consultasBean.consultarPersona(numeroIdentificacion,tipoIdentificacion);
		List<PersonaDTO> retorno = new ArrayList<>();
		for (Persona persona : personas) {
			PersonaDTO personaDTO = new PersonaDTO();
			personaDTO.setNombres(persona.getNombres());
			personaDTO.setApellidos(persona.getApellidos());
			personaDTO.setNumeroIdentificacion(persona.getNumeroIdentificacion());
			personaDTO.setTipoIdentificacion(persona.getTipoIdentificacion());
			personaDTO.setNumeroTelefonico(persona.getNumeroTelefonico());
			personaDTO.setEdad(persona.getEdad());
			retorno.add(personaDTO);
		}
		
		return retorno;	
	}
	
	/**
	 * este servicio nos permite editar una persona existente
	 * @param personaDTO
	 * @return
	 */
	@PUT
	@Path("/editarPersona")
	@Produces(MediaType.APPLICATION_JSON)
	public ResultadoDTO editarPersona(PersonaDTO personaDTO){
		ResultadoDTO retorno = new ResultadoDTO();
		retorno.setExitoso(true);
		try {
			consultasBean.crearPersona(personaDTO);
		} catch (Exception e) {
			retorno.setExitoso(true);
			retorno.setMensajeError("No se pudo editar la persona");
		}
		return retorno;	
	}
			
	
	private MarcaDTO construirMarcaDTO(Marca marca) {
		MarcaDTO marcaDTO = new MarcaDTO();
		marcaDTO.setIdMarca(marca.getIdMarca());
		marcaDTO.setNombre(marca.getNombre());
		return marcaDTO;
	}
	

}
