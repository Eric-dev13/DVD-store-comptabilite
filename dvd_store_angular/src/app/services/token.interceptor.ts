import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
  HttpHeaders,
  HttpErrorResponse
} from '@angular/common/http';
import { Observable, catchError, throwError } from 'rxjs';
import { Router } from '@angular/router';

@Injectable()
export class TokenInterceptor implements HttpInterceptor {

  constructor(private router: Router) { }

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
     // Récupérez l'URL actuelle
     const currentUrl: string = this.router.url;

     // Vérifiez si l'URL contient le segment "admin"
     if (currentUrl.includes('/admin')) {

     // Récupération du token d'authentification depuis la session storage
     const token: string|null = sessionStorage.getItem('token');

       // Ajout du token dans les entêtes de la requête
       request = request.clone({
         headers: new HttpHeaders({
           'Authorization': `Bearer ${token}`,
           'Content-Type': 'application/json'
         })
       });
     }
     
     // Envoi de la requête avec les nouvelles entêtes
    return next.handle(request).pipe(
      catchError((error: HttpErrorResponse) => {
        const errorCode = error.status; // Récupérer le code d'erreur HTTP

        // Gestion du code d'erreur
        console.log(`Code d'erreur HTTP : ${errorCode}`);

        // 
        if(errorCode === 403 ) {
          this.router.navigate(["/login"]);
        }

        // Vous pouvez également propager l'erreur pour qu'elle soit gérée ailleurs dans l'application
        return  throwError(() => error);
      })
    );
  }
}
