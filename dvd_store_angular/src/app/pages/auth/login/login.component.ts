import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { User } from '../register/register.component';
import { Token } from '@angular/compiler';
import { JwtTokenService } from 'src/app/services/jwt-token.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {

  constructor(
    private authenticationService: AuthenticationService, 
    private jwtTokenService: JwtTokenService, 
    private router: Router
    ){}


  send = (form: NgForm) => {
    this.authenticationService.login(form).subscribe({
      next: (data) => {
        //console.log(data),
        this.authenticationService.setToken(data.token);
        this.authenticationService.setUser(data.user);
        this.router.navigate(["/"]);

        // this.jwtTokenService.setToken(data.token)
        // const token = this.jwtTokenService.getDecodeToken();
        // console.table(token);
        // const is_token_expired = this.jwtTokenService.isTokenExpired();
        // console.log("date",is_token_expired);
        // const user = this.jwtTokenService.getUser();
        // console.log("date",user);
      },
      error: (err) => console.log('Observer got an error: ' + err),
      complete: () => console.log('Authentification réussie')
    })
  }

}
