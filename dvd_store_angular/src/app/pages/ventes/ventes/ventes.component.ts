import { Component, OnInit } from '@angular/core';
import { environment } from 'src/environments/environment.development';
import { faEdit, faTrash, faCircleInfo, faSquarePlus } from '@fortawesome/free-solid-svg-icons';
import { Router } from '@angular/router';
import { VenteService } from 'src/app/services/vente.service';
import { VenteModel } from 'src/app/services/vente-model.interface';

@Component({
  selector: 'app-ventes',
  templateUrl: './ventes.component.html',
  styleUrls: ['./ventes.component.scss']
})
export class VentesComponent implements OnInit {

  constructor(private venteService: VenteService, private router: Router) { }

  readonly PUBLIC_URL_UPLOAD: string = environment.PUBLIC_URL_UPLOAD;


  venteModel: Array<VenteModel> = [];

  faTrash=faTrash;
  faEdit=faEdit;
  faCircleInfo=faCircleInfo;
  faSquarePlus=faSquarePlus;

  ngOnInit(): void {
    this.findAll();
  }

  findAll = () => {
    this.venteService.findAll().subscribe({
      next: (data) => {
        console.table(data),
          this.venteModel = data
      },
      error: (err) => console.log('Observer got an error: ' + err),
      complete: () => console.log('Liste des DVDs récupèrée')
    })
  }

  delete = (id: any) => {
    console.log("delete", id);
    
    this.venteService.delete(id).subscribe((res) => {
      this.findAll();
      console.log('delete', res)
    })
  }

}
