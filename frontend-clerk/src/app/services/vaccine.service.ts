import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class VaccineService {

  constructor(private http: HttpClient) { }

  public saveVaccineXml(id : number, manufacturer: string, quantity: number){
    const headers = new HttpHeaders({ 'Content-Type': 'application/xml' });
    headers.append('Accept', 'application/xml');
    headers.append('Content-Type', 'application/xml');
    // headers = headers.append('Accept', 'text/xml');
    let body = `<vaccine>
                  <id>${id}</id>
                  <manufacturer>${manufacturer}</manufacturer>
                  <quantity>${quantity}</quantity>
                </vaccine>`;
    return this.http.post(`${environment.apiUrl}/immunization/save-vaccine`, body, { headers: headers, responseType: 'text'});
  }

  public findAllVaccines(){
    const headers = new HttpHeaders({ 'Content-Type': 'application/xml' });
    headers.append('Accept', 'application/xml');
    headers.append('Content-Type', 'application/xml');
    return this.http.get(`${environment.apiUrl}/immunization/get-all-vaccines`, {headers: headers,responseType: 'text'});
  }

  public updateQuantity(vaccineId: number, quantity: number){
    const headers = new HttpHeaders({ 'Content-Type': 'application/xml' });
    headers.append('Accept', 'application/xml');
    headers.append('Content-Type', 'application/xml');
    return this.http.get(`${environment.apiUrl}/immunization/update-quantity/${vaccineId}/${quantity}`, {headers: headers,responseType: 'text'});
  }
}
