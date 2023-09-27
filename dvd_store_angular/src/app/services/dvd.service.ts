import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { DvdServiceModel } from './dvd-service-model.interface';
import { NgForm } from '@angular/forms';


// export interface DvdService {
//   id?: number,
//   name: string,
//   genre: string,
//   realisateur: string,
//   quantity: number,
//   price: number,
//   filename: string,
//   synopsis:string
// }

@Injectable({
  providedIn: 'root'
})
export class DvdService {

  dvds: Array<DvdServiceModel> = [];

  constructor(private http: HttpClient) { }

  findAllDvds = (): Observable<Array<DvdServiceModel>> => {
    return this.http.get<Array<DvdServiceModel>>("http://localhost:9000/api/dvd");
  }

  findById = (id:number): Observable<DvdServiceModel> => {
    return this.http.get<DvdServiceModel>("http://localhost:9000/api/dvd/"+ id);
  }

  add = (form: NgForm): Observable<any> => {
    return this.http.post("http://localhost:9000/api/dvd", form.value);
  }
}
