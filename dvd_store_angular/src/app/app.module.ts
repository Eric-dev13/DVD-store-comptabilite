import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { TokenInterceptor } from './services/token.interceptor';


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
import { RegisterComponent } from './pages/auth/register/register.component';
import { LoginComponent } from './pages/auth/login/login.component';
import { UnauthorizedComponent } from './error/unauthorized/unauthorized.component';
import { NotFoundComponent } from './error/not-found/not-found.component';
import { PaniersComponent } from './pages/paniers/paniers/paniers.component';
import { AddPanierComponent } from './pages/paniers/add-panier/add-panier.component';
import { PanierComponent } from './pages/paniers/panier/panier.component';
import { IonicModule, IonicRouteStrategy } from '@ionic/angular';
import { RouteReuseStrategy } from '@angular/router';


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
    FormVenteComponent,
    RegisterComponent,
    LoginComponent,
    UnauthorizedComponent,
    NotFoundComponent,
    PaniersComponent,
    AddPanierComponent,
    PanierComponent
  ],
  imports: [
    FormsModule,
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    FontAwesomeModule,
    HttpClientModule,
    IonicModule.forRoot()
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptor,
      multi: true
    },
    {
      provide: RouteReuseStrategy, 
      useClass: IonicRouteStrategy 
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
