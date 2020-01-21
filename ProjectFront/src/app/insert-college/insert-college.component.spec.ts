import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InsertCollegeComponent } from './insert-college.component';

describe('InsertCollegeComponent', () => {
  let component: InsertCollegeComponent;
  let fixture: ComponentFixture<InsertCollegeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InsertCollegeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InsertCollegeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
