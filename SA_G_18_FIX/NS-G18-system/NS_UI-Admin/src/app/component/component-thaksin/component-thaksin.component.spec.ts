import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ComponentThaksinComponent } from './component-thaksin.component';

describe('ComponentThaksinComponent', () => {
  let component: ComponentThaksinComponent;
  let fixture: ComponentFixture<ComponentThaksinComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ComponentThaksinComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ComponentThaksinComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
