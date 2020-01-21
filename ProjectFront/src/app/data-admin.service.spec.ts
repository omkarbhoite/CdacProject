import { TestBed } from '@angular/core/testing';

import { DataAdminService } from './data-admin.service';

describe('DataAdminService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: DataAdminService = TestBed.get(DataAdminService);
    expect(service).toBeTruthy();
  });
});
