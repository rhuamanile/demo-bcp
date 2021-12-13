import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AlumnosComponent } from './components/alumnos/alumnos.component';


const routes: Routes = [
  {path: '', pathMatch: 'full', redirectTo: 'tipocambio'},
  {path: 'tipocambio', component: AlumnosComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
