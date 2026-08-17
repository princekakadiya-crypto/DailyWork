import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GenreDemoComponent } from './gener-demo';

describe('GenreDemoComponent', () => {
  let component: GenreDemoComponent;
  let fixture: ComponentFixture<GenreDemoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GenreDemoComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(GenreDemoComponent as any);
    component = fixture.componentInstance as GenreDemoComponent;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
