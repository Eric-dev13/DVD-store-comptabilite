import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface DvdService {
  id?: number,
  name: string,
  genre: string,
  quantity: number,
  price: number,
  filename: string
}

@Injectable({
  providedIn: 'root'
})
export class DvdService {

  dvds: Array<DvdService> = [];

  constructor(private http: HttpClient) { }

  findAllDvds = (): Observable<any> => {
    return this.http.get<Array<DvdService>>("http://localhost:9000/api/dvd/with-id");
  }

  findById = (id:number) => {
    return this.http.get<DvdService>("http://localhost:9000/api/dvd/"+ id);
  }
}
