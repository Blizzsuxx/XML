import { toBase64String } from '@angular/compiler/src/output/source_map';
import { Component, OnInit } from '@angular/core';
import {FormControl, Validators} from '@angular/forms';
import { TIzbor, TVakcina, Vakcine } from 'src/app/model/Interesovanje';
import { DokumentiService } from 'src/app/services/dokumenti/dokumenti.service';


export interface Task {
  name: string;
  completed: boolean;
  color: string;
  subtasks?: Task[];
}


@Component({
  selector: 'app-interesovanje',
  templateUrl: './interesovanje.component.html',
  styleUrls: ['./interesovanje.component.css']
})
export class InteresovanjeComponent implements OnInit {


  constructor(private dokumentiService : DokumentiService) { }

  ngOnInit(): void {
  }

  email = new FormControl('', [Validators.required, Validators.email]);
  jmbg = new FormControl('', [Validators.required, Validators.pattern("[0-9]{13}")]);
  ime = new FormControl('', [Validators.required]);
  prezime = new FormControl('', [Validators.required]);
  mobilni = new FormControl('', [Validators.required, Validators.pattern("[0-9]{10}")]);
  fiksni = new FormControl('', [Validators.pattern("[0-9]{9}")]);
  opstina = new FormControl('', [Validators.required]);
  drzavljanstvo = new FormControl('', [Validators.required]);
  davalac : boolean = false;

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
    var vakcine = new Vakcine();
    console.log(this.task);
    if(this.allComplete){
      vakcine.biloSta.izabran = true;
    } else {
      vakcine.izabraneVakcine.izabran = true;
      vakcine.izabraneVakcine.vakcina = new TVakcina();

      if(this.task.subtasks != null && this.task.subtasks[0].completed){
        vakcine.izabraneVakcine.vakcina.pfizer = "Pfizer";
      }
      if(this.task.subtasks != null && this.task.subtasks[1].completed){
        vakcine.izabraneVakcine.vakcina.sputnik = "Sputnik";
      }
      if(this.task.subtasks != null && this.task.subtasks[2].completed){
        vakcine.izabraneVakcine.vakcina.sinopharm = "Sinopharm";
      }
      if(this.task.subtasks != null && this.task.subtasks[3].completed){
        vakcine.izabraneVakcine.vakcina.astraZeneca = "AstraZeneca";
      }
      if(this.task.subtasks != null && this.task.subtasks[4].completed){
        vakcine.izabraneVakcine.vakcina.moderna = "Moderna";
      }
    }
    
    console.log(this.drzavljanstvo.value)
    this.dokumentiService.sacuvajInteresovanje2(this.drzavljanstvo.value, this.email.value, this.jmbg.value, this.ime.value, this.prezime.value, this.mobilni.value, this.fiksni.value, this.opstina.value, vakcine, this.ime.value + " " + this.prezime.value, this.davalac);
  }

}
