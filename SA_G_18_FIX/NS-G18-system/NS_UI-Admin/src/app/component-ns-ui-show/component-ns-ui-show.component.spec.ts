import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ComponentNsUiShowComponent } from './component-ns-ui-show.component';

describe('ComponentNsUiShowComponent', () => {
  let component: ComponentNsUiShowComponent;
  let fixture: ComponentFixture<ComponentNsUiShowComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ComponentNsUiShowComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ComponentNsUiShowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
