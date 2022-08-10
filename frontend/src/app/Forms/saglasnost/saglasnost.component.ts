import { toBase64String } from '@angular/compiler/src/output/source_map';
import { Component, OnInit } from '@angular/core';
import {FormControl, Validators} from '@angular/forms';
import { TIzbor, TVakcina, Vakcine } from 'src/app/model/Interesovanje';
import { Saglasnost } from 'src/app/model/saglasnost';
import { AuthentitacionService } from 'src/app/services/autentication/authentitacion.service';
import { DokumentiService } from 'src/app/services/dokumenti/dokumenti.service';


export interface Task {
  name: string;
  completed: boolean;
  color: string;
  subtasks?: Task[];
}


@Component({
  selector: 'app-saglasnost',
  templateUrl: './saglasnost.component.html',
  styleUrls: ['./saglasnost.component.css']
})
export class SaglasnostComponent implements OnInit {

  

  constructor(private dokumentiService : DokumentiService, private authService: AuthentitacionService,) { }

  ngOnInit(): void {
    const token = this.authService.getAuthorizationToken();
    this.email.setValue(token.user.email);
    this.ime.setValue(token.user.ime);
    this.prezime.setValue(token.user.prezime);
    this.rodjendan.setValue(token.user.rodjendan);
    this.drzavljanstvoDugme = "Srpsko"
    this.pol = "Muski"
    this.radniStatus = "Zaposlen";
    this.zanimanje = "ZdravstvenaZastita";
    this.saglasnost = "Da"
    this.vakcina = "Pfizer-BioNTech"
  }

  email = new FormControl('', [Validators.required, Validators.email]);
  jmbg = new FormControl('', [Validators.required, Validators.pattern("[0-9]{13}")]);
  ime = new FormControl('', [Validators.required]);
  prezime = new FormControl('', [Validators.required]);
  mobilni = new FormControl('', [Validators.required, Validators.pattern("[0-9]{10,10}")]);
  fiksni = new FormControl('', [Validators.pattern("[0-9]{9}")]);
  opstina = new FormControl('', [Validators.required]);
  drzavljanstvoDugme = ""
  mesto = new FormControl('', [Validators.required]);
  naselje = new FormControl('', [Validators.required]);
  pol = ""
  adresa = new FormControl('', [Validators.required]);
  roditelj = new FormControl('', [Validators.required]);
  stranac = new FormControl('', [Validators.required]);
  rodjendan = new FormControl('', [Validators.required]);
  radniStatus = ""
  zanimanje = ""
  socijalnaZastita = ""
  saglasnost = ""
  vakcina = ""
  opstinaSocijala = new FormControl('', [Validators.required]);
  

  task: Task = {
    name: 'Bilo Koju',
    completed: false,
    color: 'accent',
    subtasks: [
      {name: 'Pfizer-BioNTech', completed: false, color: 'primary'},
      {name: 'Sputnik V', completed: false, color: 'primary'},
      {name: 'Sinopharm', completed: false, color: 'primary'},
      {name: 'AstraZeneca', completed: false, color: 'primary'},
      {name: 'Moderna', completed: false, color: 'primary'},
    ],
  };

  allComplete: boolean = false;

  getErrorMessage() {
    if (this.email.hasError('required')) {
      return 'Morate da uneste email';
    }

    return this.email.hasError('email') ? 'nije validan email' : '';
  }



  updateAllComplete() {
    this.allComplete = this.task.subtasks != null && this.task.subtasks.every(t => t.completed);
  }

  someComplete(): boolean {
    if (this.task.subtasks == null) {
      return false;
    }
    return this.task.subtasks.filter(t => t.completed).length > 0 && !this.allComplete;
  }

  setAll(completed: boolean) {
    this.allComplete = completed;
    if (this.task.subtasks == null) {
      return;
    }
    this.task.subtasks.forEach(t => (t.completed = completed));
  }

  submit(){
    let drzavljanstvo = "Srpsko"
    if(this.drzavljanstvoDugme == "Strano"){
      drzavljanstvo = this.stranac.value;
    }
    const saglasnost = new Saglasnost(drzavljanstvo, this.jmbg.value, this.ime.value, this.prezime.value, this.roditelj.value, this.pol, this.rodjendan.value, this.mesto.value, this.adresa.value, this.naselje.value, this.mobilni.value, this.fiksni.value, this.email.value, this.radniStatus, this.zanimanje, this.socijalnaZastita, this.saglasnost, this.vakcina, this.opstinaSocijala.value, this.opstina.value);
    console.log(saglasnost)

    this.dokumentiService.sacuvajSaglasnost(saglasnost);
  }

}
