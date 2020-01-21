import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AcceptOrrejectRequestComponent } from './accept-orreject-request.component';

describe('AcceptOrrejectRequestComponent', () => {
  let component: AcceptOrrejectRequestComponent;
  let fixture: ComponentFixture<AcceptOrrejectRequestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AcceptOrrejectRequestComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AcceptOrrejectRequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
