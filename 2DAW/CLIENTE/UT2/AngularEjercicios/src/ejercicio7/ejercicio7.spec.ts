import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Ejercicio7 } from './ejercicio7';

describe('Ejercicio7', () => {
  let component: Ejercicio7;
  let fixture: ComponentFixture<Ejercicio7>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Ejercicio7]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Ejercicio7);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
