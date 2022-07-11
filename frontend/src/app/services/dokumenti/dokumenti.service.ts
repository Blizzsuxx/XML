import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Drzavljanstvo, Interesovanje, TIzbor, TOsoba, TVakcina, Vakcine } from 'src/app/model/Interesovanje';
import { js2xml } from "node_modules/xml-js"
import { Saglasnost } from 'src/app/model/saglasnost';


export class TestXML{
  public a : string;
  public b : string;
}


@Injectable({
  providedIn: 'root'
})
export class DokumentiService {

  constructor(private http: HttpClient, private router: Router) {}


  sacuvajSaglasnost(saglasnost: Saglasnost){
    


    const headers = new HttpHeaders({ 'Content-Type': 'application/xml' });
    headers.append('Accept', 'application/xml');
    headers.append('Content-Type', 'application/xml');
    console.log(js2xml(saglasnost, {compact:true}))
    console.log(saglasnost)
    this.http.post("http://localhost:8080/api/xml/podnesiSaglasnost", "<saglasnost_za_sprovodjenje_imunizacije>" + js2xml(saglasnost, {compact:true}) + "</saglasnost_za_sprovodjenje_imunizacije>", {headers: headers, responseType: "text"}).subscribe();
    


  }

  sacuvajInteresovanje(interesovanje : Interesovanje){
    const headers = new HttpHeaders({ 'Content-Type': 'application/xml' });
    headers.append('Accept', 'application/xml');
    headers.append('Content-Type', 'application/xml');
    console.log(js2xml(interesovanje, {compact:true}))
    console.log(interesovanje)
    this.http.post("http://localhost:8080/api/xml/podnesiZahtevZaSaglasnost", "<interesovanje_za_vakcinisanje>" + js2xml(interesovanje, {compact:true}) + "</interesovanje_za_vakcinisanje>", {headers: headers, responseType: "text"}).subscribe();
    
    // this.http.post("http://localhost:8080/api/xml/podnesiZahtevZaSaglasnost", js2xml(interesovanje), {headers: headers, responseType: "text"}).subscribe();
  }

  sacuvajInteresovanje2(drzavljanstvo : string, email : string, jmbg : string, ime : string, prezime : string, mobilni : string, fiksni : string, opstina : string, vakcine : Vakcine, potpis : string, davalac : boolean){
    let interesovanje : Interesovanje = new Interesovanje();
    console.log("AAAAAAAAAAA")
    interesovanje.osoba = new TOsoba();
    interesovanje.osoba.ime = ime;
    interesovanje.osoba.prezime = prezime;
    interesovanje.osoba.eadresa = email;
    interesovanje.osoba.jmbg = jmbg;
    interesovanje.osoba.mobilni = mobilni;
    interesovanje.osoba.fiksni = fiksni;
    let davalacT = new TIzbor();
    davalacT.izabran = davalac
    interesovanje.davalacKrvi = davalacT;
    interesovanje.drzavljanstvo = new Drzavljanstvo();
    if(drzavljanstvo === "drzavljanstvoRepublikeSrbije"){
      interesovanje.drzavljanstvo.drzavljanstvoRepublikeSrbije = drzavljanstvo;
    } else if(drzavljanstvo === "straniSaBroravkom"){
      interesovanje.drzavljanstvo.straniSaBroravkom = drzavljanstvo;

    } else{
      interesovanje.drzavljanstvo.straniBezBoravka = drzavljanstvo;

    }
    
    interesovanje.lokacija = opstina;
    interesovanje.potpis = potpis;
    interesovanje.vakcine = vakcine;

    this.sacuvajInteresovanje(interesovanje);
  }


}
