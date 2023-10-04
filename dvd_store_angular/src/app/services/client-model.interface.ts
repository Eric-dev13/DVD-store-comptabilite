import { VenteModel } from "./vente-model.interface";


export interface ClientModel {
    id?:number;
    firstname:string;
    lastname:string;
    address:string;
    //achats?: Array<VenteModel>;
}
