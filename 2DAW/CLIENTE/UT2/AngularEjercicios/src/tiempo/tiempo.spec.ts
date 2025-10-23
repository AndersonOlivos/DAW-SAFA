import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Tiempo } from './tiempo';

describe('Tiempo', () => {
  let component: Tiempo;
  let fixture: ComponentFixture<Tiempo>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Tiempo]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Tiempo);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
