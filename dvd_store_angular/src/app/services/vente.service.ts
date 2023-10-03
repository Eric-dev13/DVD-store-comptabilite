import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {environment} from 'src/environments/environment.development';
import { VenteModel } from './vente-model.interface';

@Injectable({
  providedIn: 'root'
})
export class VenteService {

  constructor(private http: HttpClient) { }

  readonly BASE_URL = environment.BASE_URL;

  findAll = (): Observable<Array<VenteModel>> => {
    return this.http.get<Array<VenteModel>>(this.BASE_URL + 'vente');
  }

  findById = (id:number): Observable<VenteModel> => {
    return this.http.get<VenteModel>(this.BASE_URL + 'vente/' + id);
  }

  add = (formData: FormData): Observable<boolean> => {
    return this.http.post<boolean>(this.BASE_URL + 'vente', formData);
  }

  update = (id:number, formData: FormData): Observable<boolean> => {
    return this.http.put<boolean>(this.BASE_URL + 'vente/' + id, formData);
  }

  delete = (id:number): Observable<boolean> => {
    return this.http.delete<boolean>(this.BASE_URL + 'vente/' + id);
  }

  findAllVenteByClient = (id:number): Observable<any> => {
    return this.http.get<Array<VenteModel>>(this.BASE_URL + 'vente/client/' + id);
  }

}
