import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FechaHora } from './fecha-hora';

describe('FechaHora', () => {
  let component: FechaHora;
  let fixture: ComponentFixture<FechaHora>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FechaHora]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FechaHora);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
