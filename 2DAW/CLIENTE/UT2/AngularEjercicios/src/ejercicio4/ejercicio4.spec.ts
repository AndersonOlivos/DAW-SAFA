import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Ejercicio4 } from './ejercicio4';

describe('Ejercicio4', () => {
  let component: Ejercicio4;
  let fixture: ComponentFixture<Ejercicio4>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Ejercicio4]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Ejercicio4);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
