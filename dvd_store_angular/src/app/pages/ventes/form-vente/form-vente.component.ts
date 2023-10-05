import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { environment } from 'src/environments/environment.development';
import { VenteService } from 'src/app/services/vente.service';
import { VenteModel } from 'src/app/services/vente-model.interface';
import { faEdit, faTrash, faCircleInfo } from '@fortawesome/free-solid-svg-icons';
import { DvdService } from 'src/app/services/dvd.service';
import { ClientService } from 'src/app/services/client.service';
import { DvdModel } from 'src/app/services/dvd-model.interface';
import { ClientModel } from 'src/app/services/client-model.interface';



@Component({
  selector: 'app-form-vente',
  templateUrl: './form-vente.component.html',
  styleUrls: ['./form-vente.component.scss']
})
export class FormVenteComponent implements OnInit {

  constructor(
    private dvdService: DvdService,
    private clientService: ClientService,
    private venteService: VenteService, 
    private router: Router, 
    private route: ActivatedRoute) { }

  PUBLIC_URL_UPLOAD = environment.PUBLIC_URL_UPLOAD;


  dvds: Array<DvdModel> = [];
  clients: Array<ClientModel> = [];

  vente: VenteModel = {
    quantity: 0,
    price: 0,
    dvd_id: 0,
    client_id: 0
  }


  faTrash=faTrash;
  faEdit=faEdit;
  faCircleInfo=faCircleInfo;

  id: any;

  ngOnInit(): void {
    // liste dvd
    this.dvdService.findAll().subscribe({
      next: (data) => {
        // console.log("dvd");
        // console.table(data),
          this.dvds = data
      },
      error: (err) => console.log('Observer got an error: ' + err),
      complete: () => console.log('Liste des DVDs récupèrée')
    })

    // liste clients
    this.clientService.findAll().subscribe({
      next: (data) => {
        // console.log("clients");
        // console.table(data),
        this.clients = data
      },
      error: (err) => console.log('Observer got an error: ' + err),
      complete: () => console.log('Liste des clients récupèrés')
    })

    // Modification vente
    this.id = this.route.snapshot.paramMap.get("id");
    if (this.id != null) {
      this.venteService.findById(this.id).subscribe({
        next: (data) => {
          console.log("update vente client", data.client),
          this.vente = data
        },
        error: (err) => console.log('Observer got an error: ' + err),
        complete: () => console.log('Dvd récupèré')
      })
    }
  }

  send = (form: NgForm) => {
    //console.log("form",form.value)
    this.id = this.route.snapshot.paramMap.get("id");

    if (this.id != null){
      // mode Update
      //console.log("Update")
      this.venteService.update(this.id, form.value).subscribe((response) => {
        this.router.navigate(["/ventes"]);
        //console.log(response)
      });
    } else {
      // Mode Add
      //console.log("Add")
      this.venteService.add(form.value).subscribe((response) => {
        this.router.navigate(["/ventes"]);
        //console.log(response)
      });
    }
  }

  // calculStocke = (event: any) => {
  //   console.log("test",this.vente.dvd)
    
  // }

  // dvdStocke:any;
  // getStocke = (event:any) => {
  //   //  console.log(event.target.value);
  //   console.table(event.target.value) 
  // }

}
