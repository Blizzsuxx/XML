import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ProfileServiceService {

  constructor(private http: HttpClient) { }

  public findAllRequests() {
    return this.http.get(`${environment.apiUrl}/cert/requests`, {responseType: 'text'});
  }

  public findAllCitizenDocuments(citizenId: string){
    return this.http.get(`${environment.apiUrl}/cert/all-citizen/${citizenId}`, {responseType: 'text'});
  }

  public acceptCertificateRequest(citizenId: string){
    return this.http.post(`${environment.apiUrl}/cert/approve/${citizenId}`, {}, {responseType: 'text'});
  }

  public declineCertificateRequest(citizenId: string, reason: string){
    return this.http.post(`${environment.apiUrl}/cert/decline/${citizenId}/${reason}`, {});
  }

  public showDocument(type: string, documentId: string){
    return this.http.get(`${environment.apiUrl}/cert/transform-${type}/${documentId}`, {responseType: 'text'});
  }

  public createReport(start:string, end:string){
    return this.http.get(`${environment.apiUrl}/immunization/report/${start}/${end}`, {responseType: 'text'});
  }

  public simpleSearch(search: string){
    return this.http.get(`${environment.apiUrl}/search/simple/${search}`, {responseType: 'text'});
  }
}
