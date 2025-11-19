import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NumeroAleatorio } from './numero-aleatorio';

describe('NumeroAleatorio', () => {
  let component: NumeroAleatorio;
  let fixture: ComponentFixture<NumeroAleatorio>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NumeroAleatorio]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NumeroAleatorio);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
