import { ClientModel } from "./client-model.interface";
import { DvdModel } from "./dvd-model.interface";

export interface VenteModel {
    id:number;
    dateAchat:Date;
    quantity:number;
    price:number;
    clientModel:ClientModel;
    dvdModel:DvdModel;
}
