import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DvdsComponent } from './pages/dvds/dvds/dvds.component';
import { DvdComponent } from './pages/dvds/dvd/dvd.component';
import { VentesComponent } from './pages/ventes/ventes.component';
import { VenteComponent } from './pages/vente/vente.component';
import { ClientsComponent } from './pages/clients/clients/clients.component';
import { ClientComponent } from './pages/clients/client/client.component';
import { FormDvdComponent } from './pages/dvds/form-dvd/form-dvd.component';


const routes: Routes = [
  { path: "", component: DvdsComponent }, // DVDS
  { path: "dvd/nouveau", component: FormDvdComponent }, // Ajouter
  { path: "dvd/:id", component: DvdComponent }, // DVD

  { path: "clients", component: ClientsComponent }, // DVDS
  // { path: "client", component: ClientComponent }, // DVD

  { path: "ventes", component: VentesComponent }, // DVDS
  // { path: "vente", component: VenteComponent }, // DVD
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
