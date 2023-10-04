
import { GenreEnum } from '../utils/enum/GenreEnum';
import { DvdServiceService } from './../dvd-service.service';
import { Component, OnInit } from '@angular/core';

export interface Dvd {
  name: string,
  genre: GenreEnum,
  imgPath: string
}

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit{

  //TODO avoir un composant qui en fonction de l'id que j'ai dans l'url affiche le bon dvd
  dvds : Array<Dvd>  = [
    {
      name: 'INTO THE WILD',
      genre: GenreEnum.DRAMA,
      imgPath :'assets/images/IntoTheWildCover.png'
    },
    {
      name: 'MARTYRS',
      genre: GenreEnum.HORROR,
      imgPath :'assets/images/MartyrsCover.png'
    },

    {
      name: 'ONLY GOD FORGIVES',
      genre: GenreEnum.THRILLER,
      imgPath :'assets/images/OnlyGodForgivesCover.png'
    },

    {
      name: 'CLOUD ATLAS',
      genre: GenreEnum.SCIENCE_FICTION,
      imgPath :'assets/images/CloudAtlasCover.png'
    }
  ]

  dvdToShow : Array<Dvd> = []

  genreFilter: string = ''

  //private dvdServiceService : DvdServiceService
  constructor() {

  }

  handleGenreClickButton = (genre : string) => {
    this.dvdToShow = this.dvds.filter((value) => {
      return value.genre === genre
    })
  }


  ngOnInit() {
    this.dvdToShow = this.dvds
  }
  /*async ngOnInit() {
    //chercher les données
    //Si je n'arrive pas à recuperer les données je dois surement mapper
    const dvdGetAlldtos = await this.dvdServiceService.getAllDvd()

    /* meme chose que :
    for (let x of dvdGetAlldtos) {
      const dvd : Dvd = {
        name: x.name,
        genre: x.genre,
        imgPath: x.imgPath
      }
      this.dvds.push(dvd);
    }

    recherche par nom :
     dvdGetAlldtos.filter((value) => {
      return value.name === 'matrix'
    })


    dvdGetAlldtos.map((value) => {
      const dvd : Dvd = {
        name: value.name,
        genre: value.genre,
        imgPath: value.imgPath
      }
      this.dvds.push(dvd);
    })
  }*/
}
