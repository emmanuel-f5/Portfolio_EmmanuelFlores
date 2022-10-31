import { Component, OnInit } from '@angular/core';
import { Experiencia } from 'src/app/model/experiencia';
import { ExperienciaServiceService } from 'src/app/service/experiencia-service.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-experiencia',
  templateUrl: './experiencia.component.html',
  styleUrls: ['./experiencia.component.css']
})
export class ExperienciaComponent implements OnInit {
  experiencia: Experiencia[] = [];

  constructor(private experienciaService: ExperienciaServiceService, private tokenService: TokenService) { }

  isLogged = false;

  ngOnInit(): void {
    this.cargarExperiencia();
    if(this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }

  }
  
  cargarExperiencia(): void {
    this.experienciaService.lista().subscribe(data => {this.experiencia = data;})
  }

  delete(id?: number) {
    if(confirm('¿Está seguro que desea eliminar el registro?')) {
      this.experienciaService.delete(id).subscribe((
        data) => {
          this.cargarExperiencia();
        },(error) => {
          alert("No se pudo borrar la experiencia");
        }
      )
    }
  }
}