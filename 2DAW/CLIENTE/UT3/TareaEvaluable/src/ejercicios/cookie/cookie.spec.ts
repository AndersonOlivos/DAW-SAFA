import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Cookie } from './cookie';

describe('Cookie', () => {
  let component: Cookie;
  let fixture: ComponentFixture<Cookie>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Cookie]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Cookie);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
