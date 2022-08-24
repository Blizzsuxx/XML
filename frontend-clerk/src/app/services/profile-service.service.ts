import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Evidencija } from '../model/kolona';
import { js2xml } from "node_modules/xml-js"

@Injectable({
  providedIn: 'root'
})
export class ProfileServiceService {

  constructor(private http: HttpClient) { }

  public findAllRequests() {
    const headers = new HttpHeaders({ 'Content-Type': 'application/xml' });
    headers.append('Accept', 'application/xml');
    headers.append('Content-Type', 'application/xml');
    return this.http.get(`${environment.apiUrl}/cert/requests`, {responseType: 'text', headers: headers});
  }

  public findAllCitizenDocuments(citizenId: string){
    const headers = new HttpHeaders({ 'Content-Type': 'application/xml' });
    headers.append('Accept', 'application/xml');
    headers.append('Content-Type', 'application/xml');
    return this.http.get(`${environment.apiUrl}/cert/all-citizen/${citizenId}`, {responseType: 'text', headers: headers});
  }

  public acceptCertificateRequest(citizenId: string){
    const headers = new HttpHeaders({ 'Content-Type': 'application/xml' });
    headers.append('Accept', 'application/xml');
    headers.append('Content-Type', 'application/xml');
    return this.http.post(`${environment.apiUrl}/cert/approve/${citizenId}`, {}, {responseType: 'text', headers: headers});
  }

  public declineCertificateRequest(citizenId: string, reason: string){
    const headers = new HttpHeaders({ 'Content-Type': 'application/xml' });
    headers.append('Accept', 'application/xml');
    headers.append('Content-Type', 'application/xml');
    return this.http.post(`${environment.apiUrl}/cert/decline/${citizenId}/${reason}`, {responseType: 'text', headers: headers});
  }

  public showDocument(type: string, documentId: string){
    const headers = new HttpHeaders({ 'Content-Type': 'application/xml' });
    headers.append('Accept', 'application/xml');
    headers.append('Content-Type', 'application/xml');
    return this.http.get(`${environment.apiUrl}/cert/transform-${type}/${documentId}`, {responseType: 'text', headers: headers});
  }

  public createReport(start:string, end:string){
    const headers = new HttpHeaders({ 'Content-Type': 'application/xml' });
    headers.append('Accept', 'application/xml');
    headers.append('Content-Type', 'application/xml');
    return this.http.get(`${environment.apiUrl}/immunization/report/${start}/${end}`, {responseType: 'text', headers: headers});
  }

  public simpleSearch(search: string){
    const headers = new HttpHeaders({ 'Content-Type': 'application/xml' });
    headers.append('Accept', 'application/xml');
    headers.append('Content-Type', 'application/xml');
    return this.http.get(`${environment.apiUrl}/search/simple/${search}`, {responseType: 'text', headers: headers});
  }

  public getSaglasnostDokument(documentId: string){
    const headers = new HttpHeaders({ 'Content-Type': 'application/xml' });
    headers.append('Accept', 'application/xml');
    headers.append('Content-Type', 'application/xml');
    return this.http.get(`${environment.apiUrl}/cert/get-saglasnost/${documentId}`, {responseType: 'text', headers: headers});
  }

  public sendEvidencija(evidencija : Evidencija, jmbg : string){
    const headers = new HttpHeaders({ 'Content-Type': 'application/xml' });
    headers.append('Accept', 'application/xml');
    headers.append('Content-Type', 'application/xml');
    const evidencijaXML =  js2xml(evidencija, {compact:true});
    console.log(evidencijaXML);
    return this.http.post(`${environment.apiUrl}/cert/send-evidencija/${jmbg}`, "<evidencija_o_vakcinaciji>" + evidencijaXML + "</evidencija_o_vakcinaciji>", {responseType: 'text', headers: headers});


  }
}
