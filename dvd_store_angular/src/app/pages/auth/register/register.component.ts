import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { ActivatedRoute, Router } from '@angular/router';

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

  constructor(private authenticationService: AuthenticationService, private router: Router){}

  user!: User;
  token!: Token;

  ngOnInit(): void {
    
  }

  send = (form: NgForm) => {
    this.authenticationService.register(form).subscribe({
      next: (data) => {
        console.log("auth", data),
        this.token = data.token,
        this.user = data.user,
        this.router.navigate(["/"]);
      },
      error: (err) => console.log('Observer got an error: ' + err),
      complete: () => console.log('S\'authentifier')
    })
  }

}
