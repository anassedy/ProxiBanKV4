import { TestBed } from '@angular/core/testing';

import { ErreurService } from './erreur.service';

describe('ErreurService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ErreurService = TestBed.get(ErreurService);
    expect(service).toBeTruthy();
  });
});
