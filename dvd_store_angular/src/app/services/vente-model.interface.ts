import { ClientModel } from "./client-model.interface";
import { DvdModel } from "./dvd-model.interface";

export interface VenteModel {
    id?:number;
    dateAchat?:Date;
    quantity:number;
    price:number;
    client?:ClientModel;
    dvd?:DvdModel;
    dvd_id: number;
    client_id:number;
}
