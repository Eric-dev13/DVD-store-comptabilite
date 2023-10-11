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
import { RegisterComponent } from './pages/auth/register/register.component';
import { LoginComponent } from './pages/auth/login/login.component';
import { authenticationGuard } from './helpers/authentication.guard';

const routes: Routes = [
  { path: "admin", component: DvdsComponent, canActivate: [authenticationGuard] }, // DVDS
  { path: "admin/dvd/nouveau", component: FormDvdComponent, canActivate: [authenticationGuard] }, // post
  { path: "admin/dvd/update/:id", component: FormDvdComponent, canActivate: [authenticationGuard] }, // put-update
  { path: "admin/dvd/:id", component: DvdComponent, canActivate: [authenticationGuard] }, // // get by id

  { path: "admin/clients", component: ClientsComponent, canActivate: [authenticationGuard] }, // CLIENTS
  { path: "admin/client/nouveau", component: FormClientComponent, canActivate: [authenticationGuard] }, // post
  { path: "admin/client/update/:id", component: FormClientComponent, canActivate: [authenticationGuard] }, // put-update
  { path: "admin/client/:id", component: ClientComponent, canActivate: [authenticationGuard] }, // // get by id

  { path: "admin/ventes", component: VentesComponent, canActivate: [authenticationGuard] }, // VENTES
  { path: "admin/vente/nouveau", component: FormVenteComponent, canActivate: [authenticationGuard] }, // post
  { path: "admin/vente/update/:id", component: FormVenteComponent, canActivate: [authenticationGuard] }, // put-update

  { path: "inscription", component: RegisterComponent },
  { path: "login", component: LoginComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
