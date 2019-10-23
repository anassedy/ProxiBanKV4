import { Compte } from './compte.models';

export class Operation{
    numero : number;
    dateOperation : Date;
    montant : number;
    compteEmetteur : Compte;
    compteRecepteur : Compte;
}