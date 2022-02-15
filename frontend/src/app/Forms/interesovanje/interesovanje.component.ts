import { Component, OnInit } from '@angular/core';
import {FormControl, Validators} from '@angular/forms';
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
    this.dokumentiService.sacuvajInteresovanje2(this.drzavljanstvo.value, this.email.value, this.jmbg.value, this.ime.value, this.prezime.value, this.mobilni.value, this.fiksni.value, this.opstina.value, "biloKoju", this.ime.value + " " + this.prezime.value, this.davalac);
  }

}
