import { CanActivateFn, Router } from '@angular/router';
import { AuthenticationService } from '../services/authentication.service';
import { inject } from '@angular/core';


export const authenticationGuard: CanActivateFn = (route, state) => {

  console.log("Authentication Guard")
  if(inject(AuthenticationService).isAuth()){
    return true;
  }
  inject(Router).navigate(["/login"]);
  return false;

};
