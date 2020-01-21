import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteAllFeedbackComponent } from './delete-all-feedback.component';

describe('DeleteAllFeedbackComponent', () => {
  let component: DeleteAllFeedbackComponent;
  let fixture: ComponentFixture<DeleteAllFeedbackComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DeleteAllFeedbackComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleteAllFeedbackComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
