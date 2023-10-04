import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DvdService } from 'src/app/services/dvd.service';
import {environment} from 'src/environments/environment.development';
import { DvdModel } from 'src/app/services/dvd-model.interface';
import { faEdit, faTrash, faCircleInfo, faSquarePlus } from '@fortawesome/free-solid-svg-icons';


@Component({
  selector: 'app-dvd',
  templateUrl: './dvd.component.html',
  styleUrls: ['./dvd.component.scss']
})
export class DvdComponent implements OnInit {

  constructor(private route: ActivatedRoute, private dvdService: DvdService){}

  readonly PUBLIC_URL_UPLOAD = environment.PUBLIC_URL_UPLOAD;

  faSquarePlus=faSquarePlus;
  faTrash=faTrash;
  faEdit=faEdit;
  faCircleInfo=faCircleInfo;

  dvd!: DvdModel;

  id_dvd: any;

  ngOnInit(): void {
    this.id_dvd = this.route.snapshot.paramMap.get('id');

    this.dvdService.findById(this.id_dvd).subscribe({
      next: (data_dvd) => {
        console.log(data_dvd),
        this.dvd = data_dvd
      },
      error: (err) => console.log('Observer got an error: ' + err),
      complete: () => console.log('Liste des DVDs récupèrée')
    })
  }

  delete = (id: any) => {
    this.dvdService.delete(id).subscribe((res) => {
      console.log(res); 
    })
  }
  
}
