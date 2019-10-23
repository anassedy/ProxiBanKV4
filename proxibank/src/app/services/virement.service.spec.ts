import { TestBed } from '@angular/core/testing';

import { VirementService } from './virement.service';

describe('VirementService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: VirementService = TestBed.get(VirementService);
    expect(service).toBeTruthy();
  });
});
