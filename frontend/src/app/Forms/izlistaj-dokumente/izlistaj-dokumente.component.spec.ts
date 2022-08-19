import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IzlistajDokumenteComponent } from './izlistaj-dokumente.component';

describe('IzlistajDokumenteComponent', () => {
  let component: IzlistajDokumenteComponent;
  let fixture: ComponentFixture<IzlistajDokumenteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ IzlistajDokumenteComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(IzlistajDokumenteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
