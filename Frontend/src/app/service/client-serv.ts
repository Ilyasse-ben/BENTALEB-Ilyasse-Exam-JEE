import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ClientDATA } from '../../model/client';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ClientServ {
  api: string = "http://localhost:8080/api/client";
  constructor(private http: HttpClient) { }

  // méthode pour obtuner tous les utilisateur 
  getAllclient(): Observable<Array<ClientDATA>> {
    return this.http.get<Array<ClientDATA>>(this.api);
  }
  // méthode qui ajoute client
  addclient(clt: ClientDATA): Observable<ClientDATA> {
    return this.http.post<ClientDATA>(this.api, clt)
  }
  // méthode qui supprime un client
  deleteClient(id: number): Observable<any> {
    console.log(this.http.delete(this.api + "/" + id))
    console.log(this.api + "/" + id)
    return of(this.http.delete(this.api + "/" + id));
  }
}
