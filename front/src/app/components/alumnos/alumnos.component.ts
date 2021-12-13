import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2'
import { AlumnoService } from 'src/app/services/alumno.service';
import { TipoCambio } from 'src/app/models/tipocambio';

@Component({
  selector: 'app-alumnos',
  templateUrl: './alumnos.component.html',
  styleUrls: ['./alumnos.component.css']
})
export class AlumnosComponent implements OnInit {

  titulo = 'Listado de Tipos de cambio';
  alumnos: TipoCambio[];

  constructor(private service: AlumnoService) { }

  ngOnInit() {
    this.service.listar().subscribe(alumnos => this.alumnos = alumnos);
  }

  public eliminar(alumno: TipoCambio): void{

    Swal.fire({
      title: 'Cuidado:',
      text: `¿Seguro que desea eliminar el registro ${alumno.codigo} ?`,
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Si, eliminar!'
    }).then((result) => {
      if (result.value) {
        this.service.eliminar(alumno.codigo).subscribe(() => {
          this.alumnos = this.alumnos.filter(a => a !== alumno);
          Swal.fire('Eliminado:', `Alumno ${alumno.codigo} eliminado con éxito`, 'success');
        });
      }
    });

  }

}
