import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ClientModel } from 'src/app/services/client-model.interface';
import { ClientService } from 'src/app/services/client.service';
import {environment} from 'src/environments/environment.development';
import { faEdit, faTrash, faCircleInfo, faRotateLeft, faSquarePlus } from '@fortawesome/free-solid-svg-icons';


@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.scss']
})
export class ClientComponent implements OnInit {

  constructor(private route: ActivatedRoute, private clientService: ClientService){}

  faSquarePlus=faSquarePlus;
  faTrash=faTrash;
  faEdit=faEdit;
  faCircleInfo=faCircleInfo;

  readonly PUBLIC_URL_UPLOAD = environment.PUBLIC_URL_UPLOAD;

  client!: ClientModel;

  id_client: any;

  ngOnInit(): void {
    this.id_client = this.route.snapshot.paramMap.get('id');
    console.log(this.id_client);

    this.clientService.findById(this.id_client).subscribe({
      next: (data) => {
        console.log(data),
        this.client = data
      },
      error: (err) => console.log('Observer got an error: ' + err),
      complete: () => console.log('Client récupèrée')
    })
  }

  delete = (id: any) => {
    this.clientService.delete(id).subscribe((res) => {
      console.log(res); 
    })
  }

}
