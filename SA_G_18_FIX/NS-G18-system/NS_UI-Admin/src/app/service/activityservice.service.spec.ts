import { TestBed, inject } from '@angular/core/testing';

import { ActivityserviceService } from './activityservice.service';

describe('ActivityserviceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ActivityserviceService]
    });
  });

  it('should be created', inject([ActivityserviceService], (service: ActivityserviceService) => {
    expect(service).toBeTruthy();
  }));
});
