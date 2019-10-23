import { Compte } from './compte.models';

export class Client{
    id: number;
    nom: string;
    prenom: string;
    email?: string;
    adresse: string;
    listeCompte : Compte[];
}