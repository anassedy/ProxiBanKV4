import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AffectationClientConseillerComponent } from './affectation-client-conseiller.component';

describe('AffectationClientConseillerComponent', () => {
  let component: AffectationClientConseillerComponent;
  let fixture: ComponentFixture<AffectationClientConseillerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AffectationClientConseillerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AffectationClientConseillerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
