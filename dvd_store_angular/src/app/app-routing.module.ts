import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DvdsComponent } from './pages/dvds/dvds.component';
import { DvdComponent } from './pages/dvd/dvd.component';
import { VentesComponent } from './pages/ventes/ventes.component';
import { VenteComponent } from './pages/vente/vente.component';
import { ClientsComponent } from './pages/clients/clients.component';
import { ClientComponent } from './pages/client/client.component';


const routes: Routes = [
  { path: "dvds", component: DvdsComponent }, // DVDS
  { path: "dvd", component: DvdComponent }, // DVD

  { path: "clients", component: ClientsComponent }, // DVDS
  { path: "client", component: ClientComponent }, // DVD

  { path: "ventes", component: VentesComponent }, // DVDS
  { path: "vente", component: VenteComponent }, // DVD
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
