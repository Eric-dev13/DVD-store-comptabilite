import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { environment } from 'src/environments/environment.development';

@Component({
  selector: 'app-panier',
  templateUrl: './panier.component.html',
  styleUrls: ['./panier.component.scss']
})
export class PanierComponent {
  constructor(private http: HttpClient, private route: ActivatedRoute) { }

  id!:any;
  panier!: any;

  readonly PUBLIC_URL_UPLOAD: string = environment.PUBLIC_URL_UPLOAD;

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get("id");
    if (this.id != null) {
      this.findById(this.id);
    }
  }

  findById = (id: string|number) => {
    this.http.get<any>(`http://localhost:9000/api/paniers/${id}`, {
      headers: new HttpHeaders({
        'Authorization': `Bearer ${sessionStorage.getItem('token')}`,
        'Content-Type': 'application/json'
      })
    }).subscribe({
      next: (data) => {
        this.panier = data;
        console.table("panier",this.panier);
      },
      error: (err) => console.log(err),
      complete: () => console.log("ok")
    });
  }
}
