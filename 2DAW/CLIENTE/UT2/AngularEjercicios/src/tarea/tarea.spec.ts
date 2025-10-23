import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Tarea } from './tarea';

describe('Tarea', () => {
  let component: Tarea;
  let fixture: ComponentFixture<Tarea>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Tarea]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Tarea);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
