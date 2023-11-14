import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router, ActivatedRoute } from '@angular/router';
import { environment } from 'src/environments/environment.development'; 

@Component({
  selector: 'app-panier',
  templateUrl: './paniers.component.html',
  styleUrls: ['./paniers.component.scss']
})
export class PaniersComponent implements OnInit {
  constructor(private http: HttpClient, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.findAllCart();
  }

  readonly PUBLIC_URL_UPLOAD: string = environment.PUBLIC_URL_UPLOAD;

  paniers:any

  findAllCart = () => {
    this.http.get<any>(`http://localhost:9000/api/paniers`, {
      headers: new HttpHeaders({
        'Authorization': `Bearer ${sessionStorage.getItem('token')}`,
        'Content-Type': 'application/json'
      })
    }).subscribe({
      next: (datas) => {
        console.table(datas);
        this.paniers = datas
      },
      error: (err) => console.log(err),
      complete: () => console.log("ok")
    });
  }

  findById = (id: number) => {
  }


  // api2 = () => {
  //   this.http.get<any>(`http://localhost:9001/paniers`).subscribe({
  //     next: (data) => {
  //       console.table(data);
  //     },
  //     error: (err) => console.log(err),
  //     complete: () => console.log("ok")
  //   });

  // }


}
