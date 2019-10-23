import { Client } from './client.models';

export abstract class Compte{
    solde:number;
    numCompte : number;
    dateCreation: string;
    idClient: Client;
}
export class CompteCourant extends Compte {
    decouverte: number = 1000;
}
export class CompteEpargne extends Compte {
    taux: number = 3;
}