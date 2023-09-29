import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { NgForm } from '@angular/forms';
import {environment} from 'src/environments/environment.development';
import { ClientModel } from './client-model.interface';

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  constructor(private http: HttpClient) { }

  readonly BASE_URL = environment.BASE_URL;

  findAll = (): Observable<Array<ClientModel>> => {
    return this.http.get<Array<ClientModel>>(this.BASE_URL + 'clients');
  }

  findById = (id:number): Observable<ClientModel> => {
    return this.http.get<ClientModel>(this.BASE_URL + 'clients/' + id);
  }

  add = (form: NgForm): Observable<boolean> => {
    return this.http.post<boolean>(this.BASE_URL + 'clients', form);
  }

  update = (id:number, form: NgForm): Observable<boolean> => {
    return this.http.put<boolean>(this.BASE_URL + 'clients/' + id, form);
  }

  delete = (id:number): Observable<boolean> => {
    return this.http.delete<boolean>(this.BASE_URL + 'clients/' + id);
  }
}
