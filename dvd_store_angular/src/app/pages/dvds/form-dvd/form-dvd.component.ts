import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { DvdModel } from 'src/app/services/dvd-model.interface';
import { GenreEnum } from 'src/app/utils/enum/genre-enum';
import { DvdService } from 'src/app/services/dvd.service';
import { Router, ActivatedRoute } from '@angular/router';
import { environment } from 'src/environments/environment.development';



// export interface MediaInterface {
//   file: File | null;
// }

@Component({
  selector: 'app-form-dvd',
  templateUrl: './form-dvd.component.html',
  styleUrls: ['./form-dvd.component.scss']
})
export class FormDvdComponent implements OnInit {

  constructor(private dvdService: DvdService, private router: Router, private route: ActivatedRoute) { }

  PUBLIC_URL_UPLOAD = environment.PUBLIC_URL_UPLOAD;

  dvd: DvdModel = {
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

  id: any;

  genreEnum = GenreEnum;
  genres: Array<string> = [];

  // media!: MediaInterface;

  selectedFile!: File;
  selectedImage: any;


  ngOnInit(): void {
    this.genres = Object.values(this.genreEnum);
    console.log(this.genres);

    this.id = this.route.snapshot.paramMap.get("id");
    if (this.id != null) {
      this.dvdService.findById(this.id).subscribe({
        next: (data_dvd) => {
          console.log(data_dvd),
            this.dvd = data_dvd
        },
        error: (err) => console.log('Observer got an error: ' + err),
        complete: () => console.log('Dvd récupèré')
      })
    }
  }

  onFileSelected(event: any) {
    this.selectedFile = event.target.files[0];
    this.selectedImage = URL.createObjectURL(this.selectedFile); // Crée l'URL pour l'image sélectionnée
  }

  send = (form: NgForm) => {
    // CREE UNE INSTANCE DE FORM DATA POUR PREPARER LA REQUETE MULTIPART
    console.log(form.value)

    const formData: FormData = new FormData();
    formData.append('mediaFile', this.selectedFile);
    formData.append('name', form.value.name);
    formData.append('genre', form.value.genre);
    formData.append('realisateur', form.value.realisateur);
    formData.append('acteur', form.value.acteur);
    formData.append('quantity', form.value.quantity);
    formData.append('price', form.value.price);
    formData.append('filename', form.value.filename);
    formData.append('synopsis', form.value.synopsis);

    this.id = this.route.snapshot.paramMap.get("id");
    console.log(this.id)
    if (this.id != null) {
      // mode Update
      console.log("Update")
      this.dvdService.update(this.id, formData).subscribe((response) => {
        console.log(response)
        this.router.navigate(["/"]);
      });
    } else {
      // Mode Add
      console.log("Add")
      this.dvdService.add(formData).subscribe((response) => {
        console.log(response)
        this.router.navigate(["/"]);
      });
    }

  }


}
