import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Ejercicio5 } from './ejercicio5';

describe('Ejercicio5', () => {
  let component: Ejercicio5;
  let fixture: ComponentFixture<Ejercicio5>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Ejercicio5]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Ejercicio5);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
