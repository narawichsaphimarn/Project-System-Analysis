import { TestBed, inject } from '@angular/core/testing';

import { RelatedInformationService } from './related-information.service';

describe('RelatedInformationService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [RelatedInformationService]
    });
  });

  it('should be created', inject([RelatedInformationService], (service: RelatedInformationService) => {
    expect(service).toBeTruthy();
  }));
});
