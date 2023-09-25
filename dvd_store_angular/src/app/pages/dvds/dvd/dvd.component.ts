import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { DvdDTO } from 'src/app/pages/dvds/dvdDTO.interface';
import { DvdService } from 'src/app/services/dvd.service';



@Component({
  selector: 'app-dvd',
  templateUrl: './dvd.component.html',
  styleUrls: ['./dvd.component.scss']
})
export class DvdComponent implements OnInit {

  constructor(private route: ActivatedRoute, private dvdService: DvdService){}

  dvd!: DvdDTO;

  id_dvd: any;

  ngOnInit(): void {
    this.id_dvd = this.route.snapshot.paramMap.get('id');
    console.log(this.id_dvd);

    this.dvdService.findById(this.id_dvd).subscribe({
      next: (data_dvd) => {
        console.log(data_dvd),
        this.dvd = data_dvd
      },
      error: (err) => console.log('Observer got an error: ' + err),
      complete: () => console.log('Liste des DVDs récupèrée')
    })

  }
  
}
