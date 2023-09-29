import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DvdsComponent } from './pages/dvds/dvds/dvds.component';
import { DvdComponent } from './pages/dvds/dvd/dvd.component';
import { FormDvdComponent } from './pages/dvds/form-dvd/form-dvd.component';
import { VentesComponent } from './pages/ventes/ventes/ventes.component';
import { VenteComponent } from './pages/ventes/vente/vente.component';
import { ClientsComponent } from './pages/clients/clients/clients.component';
import { ClientComponent } from './pages/clients/client/client.component';
import { FormClientComponent } from './pages/clients/form-client/form-client.component';


const routes: Routes = [
  { path: "", component: DvdsComponent }, // DVDS
  { path: "dvd/nouveau", component: FormDvdComponent }, // add-post
  { path: "dvd/update/:id", component: FormDvdComponent }, // put-update
  { path: "dvd/:id", component: DvdComponent }, // DVD

  { path: "clients", component: ClientsComponent }, // CLIENTS
  { path: "client/nouveau", component: FormClientComponent }, // add-post
  { path: "client/update/:id", component: FormClientComponent }, // put-update
  { path: "client/:id", component: ClientComponent }, // CLIENTS

  { path: "ventes", component: VentesComponent }, // DVDS
  // { path: "vente", component: VenteComponent }, // DVD
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
