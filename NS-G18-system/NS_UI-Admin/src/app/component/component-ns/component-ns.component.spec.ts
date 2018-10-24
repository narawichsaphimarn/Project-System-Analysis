import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ComponentNsComponent } from './component-ns.component';

describe('ComponentNsComponent', () => {
  let component: ComponentNsComponent;
  let fixture: ComponentFixture<ComponentNsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ComponentNsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ComponentNsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

