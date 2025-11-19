import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NavegacionHistorial } from './navegacion-historial';

describe('NavegacionHistorial', () => {
  let component: NavegacionHistorial;
  let fixture: ComponentFixture<NavegacionHistorial>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NavegacionHistorial]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NavegacionHistorial);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
