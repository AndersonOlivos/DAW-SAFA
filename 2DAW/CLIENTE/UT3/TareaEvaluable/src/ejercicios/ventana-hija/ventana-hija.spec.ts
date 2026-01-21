import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VentanaHija } from './ventana-hija';

describe('VentanaHija', () => {
  let component: VentanaHija;
  let fixture: ComponentFixture<VentanaHija>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VentanaHija]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VentanaHija);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
