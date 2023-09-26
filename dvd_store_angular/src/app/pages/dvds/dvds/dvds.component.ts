import { Component, OnInit } from '@angular/core';
import { DvdService } from 'src/app/services/dvd.service';
import { DvdDTO } from 'src/app/pages/dvds/dvdDTO.interface';


@Component({
  selector: 'app-dvds',
  templateUrl: './dvds.component.html',
  styleUrls: ['./dvds.component.scss']
})
export class DvdsComponent implements OnInit {

  constructor(private dvdService: DvdService){}

  readonly PUBLIC_API_URL = 'http://localhost:9000/upload/';

  dvdDTO: Array<DvdDTO> = [];

  ngOnInit(): void {
    this.dvdService.findAllDvds().subscribe({
      next: (data_dvds) => {
        console.table(data_dvds),
        this.dvdDTO = data_dvds
      },
      error: (err) => console.log('Observer got an error: ' + err),
      complete: () => console.log('Liste des DVDs récupèrée')
    })
  }


}
