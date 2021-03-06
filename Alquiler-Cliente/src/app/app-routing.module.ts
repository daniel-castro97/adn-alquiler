import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CrearClienteComponent } from './feature/crear-cliente/crear-cliente.component';
import { CrearMotoComponent } from './feature/crear-moto/crear-moto.component';
import { ListarMotosComponent } from './feature/listar-motos/listar-motos.component';
import { CrearReservaComponent } from './feature/crear-reserva/crear-reserva.component';
import { ListarReservaComponent } from './feature/listar-reserva/listar-reserva.component';
import { HomeComponent } from './feature/home/home.component';
import { ActualizarMotoComponent } from './feature/actualizar-moto/actualizar-moto.component';

const routes: Routes = [
  { path: "home", component: HomeComponent },
  {
    path: "",
    children: [
      {path: "cliente", component:CrearClienteComponent},
      {path: "moto", component :CrearMotoComponent},
      {path: "listar-motos", component : ListarMotosComponent},
      {path: "reserva", component: CrearReservaComponent},
      {path: "listar-reservas", component: ListarReservaComponent},
      {path: "actualizar", component: ActualizarMotoComponent}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
