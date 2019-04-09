import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-creacion-persona',
  templateUrl: './creacion-persona.component.html',
  styleUrls: ['./creacion-persona.component.css']
})
export class CreacionPersonaComponent implements OnInit {

  id: number = 12345;
  tipoid: string = "";
  nombre: string ="Daniel";
  apellio: string = "Torres";
 
  constructor() { }

  ngOnInit() {
  }

}
