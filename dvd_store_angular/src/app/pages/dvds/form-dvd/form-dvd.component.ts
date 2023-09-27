import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { DvdDTO } from '../dvdDTO.interface';
import { GenreEnum } from 'src/app/utils/enum/genre-enum'; 
import { DvdService } from 'src/app/services/dvd.service';

export interface MediaInterface{
  file: File | null;
}

@Component({
  selector: 'app-form-dvd',
  templateUrl: './form-dvd.component.html',
  styleUrls: ['./form-dvd.component.scss']
})
export class FormDvdComponent implements OnInit {

  constructor(private dvdService: DvdService){}

  dvd: DvdDTO = {
    id: 0,
    name: '',
    genre: '',
    realisateur: '',
    acteur: '',
    quantity: 0,
    price: 0,
    filename: '',
    synopsis: ''
  }

  genreEnum = GenreEnum;
  genres: Array<string> = [];

  media!: MediaInterface;

  selectedFile!: File;
  selectedImage: any;

  // Long id, String name, String genre, String realisateur, String acteur, int quantity, float price, String filename, String synopsis

  ngOnInit(): void {
    this.genres = Object.values(this.genreEnum);


    console.log(this.genres);
  }
  
  send = (form: NgForm) => {
    // CREE UNE INSTANCE DE FORM DATA POUR PREPARER LA REQUETE MULTIPART
    const formData: FormData = new FormData();
    formData.append('mediaFile', this.selectedFile)


    this.dvdService.add(form).subscribe((state) => {

    })
  }

  onFileSelected(event: any) {
    this.selectedFile = event.target.files[0];
    this.selectedImage = URL.createObjectURL(this.selectedFile); // Crée l'URL pour l'image sélectionnée
  }
}
