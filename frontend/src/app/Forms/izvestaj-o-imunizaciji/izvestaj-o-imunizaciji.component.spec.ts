import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IzvestajOImunizacijiComponent } from './izvestaj-o-imunizaciji.component';

describe('IzvestajOImunizacijiComponent', () => {
  let component: IzvestajOImunizacijiComponent;
  let fixture: ComponentFixture<IzvestajOImunizacijiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ IzvestajOImunizacijiComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(IzvestajOImunizacijiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
