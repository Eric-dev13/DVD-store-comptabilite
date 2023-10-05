import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { User } from '../register/register.component';
import { Token } from '@angular/compiler';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {

  constructor(private authenticationService: AuthenticationService){}


  send = (form: NgForm) => {
    this.authenticationService.login(form).subscribe({
      next: (data) => {
        //console.log(data),
        this.authenticationService.setToken(data.token);
        this.authenticationService.setUser(data.user);
        

      },
      error: (err) => console.log('Observer got an error: ' + err),
      complete: () => console.log('Liste des DVDs récupèrée')
    })
  }

}
