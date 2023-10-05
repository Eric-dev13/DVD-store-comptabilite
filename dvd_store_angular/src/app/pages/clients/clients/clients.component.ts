import { Component, OnInit } from '@angular/core';
import {environment} from 'src/environments/environment.development';
import { faEdit, faTrash, faCircleInfo, faSquarePlus } from '@fortawesome/free-solid-svg-icons';
import { ClientService } from 'src/app/services/client.service';
import { ClientModel } from 'src/app/services/client-model.interface';

@Component({
  selector: 'app-clients',
  templateUrl: './clients.component.html',
  styleUrls: ['./clients.component.scss']
})
export class ClientsComponent implements OnInit {

  constructor(private clientService: ClientService){}

  faSquarePlus=faSquarePlus;
  faTrash=faTrash;
  faEdit=faEdit;
  faCircleInfo=faCircleInfo;

  readonly PUBLIC_URL_UPLOAD = environment.PUBLIC_URL_UPLOAD;

  clientModel: Array<ClientModel> = [];

  ngOnInit(): void {
   this.findAll();
  }

  delete = (id: any) => {
    this.clientService.delete(id).subscribe((res) => {
      //console.log(res); 
      this.findAll();
    })
  }

  findAll = () => {
     this.clientService.findAll().subscribe({
      next: (data) => {
        // console.table(data),
        this.clientModel = data
      },
      error: (err) => console.log('Observer got an error: ' + err),
      complete: () => console.log('Liste des clients récupèrés')
    })
  }



}
