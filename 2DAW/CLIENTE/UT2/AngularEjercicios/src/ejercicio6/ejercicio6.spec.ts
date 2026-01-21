import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Ejercicio6 } from './ejercicio6';

describe('Ejercicio6', () => {
  let component: Ejercicio6;
  let fixture: ComponentFixture<Ejercicio6>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Ejercicio6]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Ejercicio6);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
