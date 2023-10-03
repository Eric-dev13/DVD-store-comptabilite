import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { DvdsComponent } from './pages/dvds/dvds/dvds.component';
import { DvdComponent } from './pages/dvds/dvd/dvd.component';
import { FormDvdComponent } from './pages/dvds/form-dvd/form-dvd.component';

import { ClientsComponent } from './pages/clients/clients/clients.component';
import { ClientComponent } from './pages/clients/client/client.component';
import { FormClientComponent } from './pages/clients/form-client/form-client.component';

import { VentesComponent } from './pages/ventes/ventes/ventes.component';
import { FormVenteComponent } from './pages/ventes/form-vente/form-vente.component';

const routes: Routes = [
  { path: "", component: DvdsComponent }, // DVDS
  { path: "dvd/nouveau", component: FormDvdComponent }, // post
  { path: "dvd/update/:id", component: FormDvdComponent }, // put-update
  { path: "dvd/:id", component: DvdComponent }, // // get by id

  { path: "clients", component: ClientsComponent }, // CLIENTS
  { path: "client/nouveau", component: FormClientComponent }, // post
  { path: "client/update/:id", component: FormClientComponent }, // put-update
  { path: "client/:id", component: ClientComponent }, // // get by id

  { path: "ventes", component: VentesComponent }, // VENTES
  { path: "vente/nouveau", component: FormVenteComponent }, // post
  { path: "vente/update/:id", component: FormVenteComponent }, // put-update
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
