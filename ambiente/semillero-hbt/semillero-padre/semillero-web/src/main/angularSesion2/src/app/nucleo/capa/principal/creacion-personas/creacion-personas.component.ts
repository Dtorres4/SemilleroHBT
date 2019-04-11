import { Component, OnInit } from '@angular/core';

// importando modelo de datos
import { PersonaDTO } from './modelo/personaDTO';


@Component({
	selector: 'app-creacion-personas',
  templateUrl: './creacion-personas.component.html'
})

export class CreacionPersonasComponent implements OnInit {

	public persona: PersonaDTO;
	public personas: PersonaDTO[];

	public mostrarForm: boolean = false;
	public buttonName: any = 'Crear Persona';
	public mostrarTab: boolean = false;
  public buttonTab: any = 'Gestionar Personas';
  
  public persona2:PersonaDTO;
  public posActualizar:number;
  public actualizarPersona:boolean=false;

	constructor() { }

	ngOnInit() {

		this.personas = [];

	}

	public mostrarFormulario() {
    this.actualizarPersona=false;
		this.mostrarForm = !this.mostrarForm;		
	}

	public mostrarTabla() {
		this.mostrarTab = !this.mostrarTab;
		
	}

	

	public guardar() {
		this.persona = {
			id: '0',
			numeroIdentificacion: '',
			tipoIdentificacion: '',
			nombre: '',
			apellido: '',
			numeroTelefono: '',
      edad: '',
      mayorEdad : false, //checkbox
			sexo: '', //radiobutton
      estado:'',
      fechaNacimiento:'',
			roles:''
		};
		this.personas.push(this.persona);

	}

	/**
   	 * 
     * El metodo recibe como parametro una persona y la elimina del arreglo
     */
	private borrar(per: PersonaDTO) {
		this.personas.splice(this.personas.indexOf(per), 1);
	}


	/**
     * Este metodo recibe como parametro la persona que se va a modificar y la guarda en un objeto persona2 de tipo persona
     * y desde el formulario se trabaja con persona2 para modificar sus valores
     * se almacena su posicion en el arreglo en el metodo update para realizar la modificacion
     */
	public editar(per:PersonaDTO){
    this.mostrarForm=false;
    this.actualizarPersona=true;
    this.posActualizar=this.personas.indexOf(per);
    this.persona2=this.personas[this.posActualizar];
    
  	}
  
  public Actualizar(){
    this.personas[this.posActualizar]=this.persona2;
    this.actualizarPersona=false;		
	}

}

