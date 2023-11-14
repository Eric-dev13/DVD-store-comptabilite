import { Component, OnInit } from '@angular/core';
import { Platform } from '@ionic/angular';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {

  constructor(public platform: Platform){} 

  desktop: boolean = false;

  ngOnInit(): void {
    if(this.platform.is('desktop')){
      this.desktop = true;
    }
  }



  title = 'dvd_store';
}
