import { HttpClient } from '@angular/common/http';
import { Token } from '@angular/compiler';
import { Injectable } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.development';
import { JwtTokenService } from './jwt-token.service';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private http: HttpClient, private jwtTokenService: JwtTokenService) { }

  readonly BASE_URL_AUTH = environment.BASE_URL_AUTH;

    // Méthode pour vérifier si un utilisateur est authentifié
    public isAuth = ():boolean => {
      const token = sessionStorage.getItem('token');
      if(token){
        this.jwtTokenService.setToken(token)
        console.log(this.jwtTokenService.isTokenExpired());
        
        return !this.jwtTokenService.isTokenExpired();
      }
      return false;
     
      // Si le token est présent, l'utilisateur est authentifié, sinon il ne l'est pas
      // return token !== null ? true : false;
    }

    public setToken = (token:string) => {
      sessionStorage.setItem("token", token);
    }

    public getToken = ():string | null => {
      return sessionStorage.getItem('token');
    }

    public getUser = ():string | null => {
      return sessionStorage.getItem('user');
    }

    public setUser = (user: any) => {
      sessionStorage.setItem("user", JSON.stringify(user));
    }

    public logout = ():void => {
      sessionStorage.removeItem("token");
      sessionStorage.removeItem("user");
    }


  register = (form: NgForm): Observable<any> => {
    return this.http.post<any>(this.BASE_URL_AUTH + 'register', form.value);
  }

  login = (form: NgForm): Observable<any> => {
    return this.http.post<any>(this.BASE_URL_AUTH + 'authorize', form.value);
  }

}
