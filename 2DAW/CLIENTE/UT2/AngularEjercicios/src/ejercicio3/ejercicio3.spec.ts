import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Ejercicio3 } from './ejercicio3';

describe('Ejercicio3', () => {
  let component: Ejercicio3;
  let fixture: ComponentFixture<Ejercicio3>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Ejercicio3]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Ejercicio3);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
