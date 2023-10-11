import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { DvdModel } from './dvd-model.interface';
import {environment} from 'src/environments/environment.development';


@Injectable({
  providedIn: 'root'
})
export class DvdService {

  constructor(private http: HttpClient) { }

  readonly BASE_URL = environment.BASE_URL;

  findAll = (): Observable<Array<DvdModel>> => {
    return this.http.get<Array<DvdModel>>(this.BASE_URL + 'dvd');
  }

  findById = (id:number): Observable<DvdModel> => {
    return this.http.get<DvdModel>(this.BASE_URL + 'dvd/' + id);
  }

  add = (formData: FormData): Observable<boolean> => {
    return this.http.post<boolean>(this.BASE_URL + 'dvd', formData);
  }

  update = (id:number, formData: FormData): Observable<boolean> => {
    return this.http.put<boolean>(this.BASE_URL + 'dvd/' + id, formData);
  }

  delete = (id:number): Observable<boolean> => {
    return this.http.delete<boolean>(this.BASE_URL + 'dvd' + id);
  }
}
