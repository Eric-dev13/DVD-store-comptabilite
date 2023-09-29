import { Component, OnInit } from '@angular/core';
import { DvdService } from 'src/app/services/dvd.service';
import { DvdModel } from 'src/app/services/dvd-model.interface';
import { environment } from 'src/environments/environment.development';
import { faEdit, faTrash, faCircleInfo, faRotateLeft, faSquarePlus } from '@fortawesome/free-solid-svg-icons';
import { Router } from '@angular/router';


@Component({
  selector: 'app-dvds',
  templateUrl: './dvds.component.html',
  styleUrls: ['./dvds.component.scss']
})
export class DvdsComponent implements OnInit {

  constructor(private dvdService: DvdService, private router: Router) { }

  faSquarePlus = faSquarePlus;
  faTrash = faTrash;
  faEdit = faEdit;
  faCircleInfo = faCircleInfo;

  readonly PUBLIC_URL_UPLOAD: string = environment.PUBLIC_URL_UPLOAD;

  dvdModel: Array<DvdModel> = [];

  ngOnInit(): void {
    this.findAll();
  }

  delete = (id: any) => {
    this.dvdService.delete(id).subscribe((res) => {
      this.findAll();
      console.log('delete', res)
    })
  }

  findAll = () => {
    this.dvdService.findAll().subscribe({
      next: (data) => {
        console.table(data),
          this.dvdModel = data
      },
      error: (err) => console.log('Observer got an error: ' + err),
      complete: () => console.log('Liste des DVDs récupèrée')
    })
  }
}
