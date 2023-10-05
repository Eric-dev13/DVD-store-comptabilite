import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AuthenticationService } from 'src/app/services/authentication.service';

export interface CurrentUser {
  username: string,
  password: string
}

export interface Token {
  token:string
}

export interface User {
  username:string,
  password: string
}

export interface IsAuth {
  user: User,
  token: Token
}



@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  constructor(private authenticationService: AuthenticationService){}

  user!: User;
  token!: Token;

  ngOnInit(): void {
    
  }

  send = (form: NgForm) => {
    this.authenticationService.register(form).subscribe({
      next: (data) => {
        //console.log(data),
        this.token = data.token,
        this.user = data.user
      },
      error: (err) => console.log('Observer got an error: ' + err),
      complete: () => console.log('Liste des DVDs récupèrée')
    })
  }

}
