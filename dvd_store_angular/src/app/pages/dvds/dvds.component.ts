import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Dvds} from './dvds.interface';


@Component({
  selector: 'app-dvds',
  templateUrl: './dvds.component.html',
  styleUrls: ['./dvds.component.scss']
})
export class DvdsComponent implements OnInit {

  constructor(private http: HttpClient){}

  dvds: Array<Dvds> = [];

  ngOnInit(): void {
    
    this.http.get<Array<Dvds>>("http://localhost:9000/api/dvd").subscribe({
      next: (data) => {
        this.dvds = data,
        console.table(data)
      },
      error: (err) => console.log('Observer got an error: ' + err),
      complete: () => console.log('Medias ajoutés!')
    })
  }

}
