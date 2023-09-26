
import { Injectable } from '@angular/core';
import { Axios } from 'axios';
import { GenreEnum } from './utils/enum/GenreEnum';

export interface DvdGetAllDTO {
  name: string,
  genre: GenreEnum,
  imgPath: string
}

@Injectable({
  providedIn: 'root'
})
export class DvdServiceService {

  constructor(private axios: Axios) { }

   getAllDvd = async () : Promise<Array<DvdGetAllDTO>> => {
    return this.axios.get('localhost:80/dvds/');
  }

  getOneDvd =async (id:number) : Promise<DvdGetAllDTO> => {
    return this.axios.get('localhost:80/dvds/'+ id);
  }
}
