package com.hbt.semillero.servicios.ejb;

import java.util.Calendar;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.hbt.semillero.entidades.Comprador;
import com.hbt.semillero.entidades.Linea;
import com.hbt.semillero.entidades.Marca;
import com.hbt.semillero.entidades.Persona;
import com.hbt.semillero.entidades.Vendedor;
import com.hbt.semillero.servicios.dto.PersonaDTO;
import com.hbt.semillero.servicios.interfaces.IConsultasBeanLocal;

@Stateless
public class ConsultasBean implements IConsultasBeanLocal{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	/**
	 * Este metodo Consulta todas las marcas
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Marca> consultarMarcas() {
		 return entityManager.createQuery("Select ma FROM Marca ma").getResultList();
		
	}
	
	/**
	 * Este metodo Consulta todas las lineas asociadas a una marca
	 */
	public List<Linea> consultarLineas(Long idMarca){
		Query consulta = entityManager.createQuery("Select ln from Linea ln JOIN FETCH ln.marca where ln.marca.idMarca=:idMarca");
		consulta.setParameter("idMarca", idMarca);
		return consulta.getResultList();
	}
	
	/**
	 * Este metodo nos permite crear una nueva persona
	 */	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void crearPersona(PersonaDTO personaDTO) {
				
		Persona persona = new Persona();
		persona.setNombres(personaDTO.getNombres());
		persona.setApellidos(personaDTO.getApellidos());
		persona.setNumeroIdentificacion(personaDTO.getNumeroIdentificacion());
		persona.setTipoIdentificacion(personaDTO.getTipoIdentificacion());
		persona.setNumeroTelefonico(personaDTO.getNumeroTelefonico());
		persona.setEdad(personaDTO.getEdad());
		
		entityManager.persist(persona);
		
		if (personaDTO.isComprador()) {
			Comprador comprador = new Comprador();
			comprador.setFechaAfiliacion(Calendar.getInstance());
			comprador.setPersona(persona);
			entityManager.persist(comprador);			
		}
		if (personaDTO.isVendedor()) {
			Vendedor vendedor = new Vendedor();
			vendedor.setFechaIngreso(Calendar.getInstance());
			vendedor.setPersona(persona);
			entityManager.persist(vendedor);
			
		}
		
	}
	
	/**
	 * Metodo ConsultarPersona
	 * este metodo nos retorna un arreglo de persona
	 * consultadolo a partir de su numero de identificacion y su tipo de dentificacion
	 */

	public List<Persona> consultarPersona(String numeroIdentificacion,String tipoIdentificacion) {
		return entityManager.createQuery("Select per FROM Persona per where per.numeroIdentificacion=:numeroIdentificacion and per.tipoIdentificacion=:tipoIdentificacion")
				.setParameter("numeroIdentificacion", numeroIdentificacion).setParameter("tipoIdentificacion", tipoIdentificacion).getResultList();
	}
	
	
	/**
	 * este metodo nos permite editar una persona
	 * a partir de su Id
	 * 
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void editarPersona(PersonaDTO personaDTO) {		
					
		
		Persona persona= entityManager.find(Persona.class, personaDTO.getIdPersona());
		
		persona.setNombres(personaDTO.getNombres());
		persona.setApellidos(personaDTO.getApellidos());
		persona.setNumeroIdentificacion(personaDTO.getNumeroIdentificacion());
		persona.setTipoIdentificacion(personaDTO.getTipoIdentificacion());
		persona.setNumeroTelefonico(personaDTO.getNumeroTelefonico());
		persona.setEdad(personaDTO.getEdad());
		
		entityManager.merge(persona);
		
		if (personaDTO.isComprador()) {
			Comprador comprador = new Comprador();
			comprador.setFechaAfiliacion(Calendar.getInstance());
			comprador.setPersona(persona);
			entityManager.persist(comprador);			
		}
		if (personaDTO.isVendedor()) {
			Vendedor vendedor = new Vendedor();
			vendedor.setFechaIngreso(Calendar.getInstance());
			vendedor.setPersona(persona);
			entityManager.persist(vendedor);
			
		}
		
	}
	

}
