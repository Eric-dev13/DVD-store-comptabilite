import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';

import { NavbarComponent } from './components/navbar/navbar.component';
import { FooterComponent } from './components/footer/footer.component';
import { HomeComponent } from './pages/home/home.component';
import { DvdsComponent } from './pages/dvds/dvds/dvds.component';
import { DvdComponent } from './pages/dvds/dvd/dvd.component';
import { ClientsComponent } from './pages/clients/clients/clients.component';
import { ClientComponent } from './pages/clients/client/client.component';
import { VentesComponent } from './pages/ventes/ventes/ventes.component';
import { FormDvdComponent } from './pages/dvds/form-dvd/form-dvd.component';
import { FormsModule } from '@angular/forms';
import { FormClientComponent } from './pages/clients/form-client/form-client.component';
import { FormVenteComponent } from './pages/ventes/form-vente/form-vente.component';




@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    FooterComponent,
    HomeComponent,
    DvdsComponent,
    DvdComponent,
    ClientsComponent,
    ClientComponent,
    VentesComponent,
    FormDvdComponent,
    FormClientComponent,
    FormVenteComponent
  ],
  imports: [
    FormsModule,
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    FontAwesomeModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
