import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewCollegeInfoComponent } from './view-college-info.component';

describe('ViewCollegeInfoComponent', () => {
  let component: ViewCollegeInfoComponent;
  let fixture: ComponentFixture<ViewCollegeInfoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewCollegeInfoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewCollegeInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
