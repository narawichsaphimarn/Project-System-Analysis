import { TestBed, inject } from '@angular/core/testing';

import { ElderService } from './elder.service';

describe('ElderService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ElderService]
    });
  });

  it('should be created', inject([ElderService], (service: ElderService) => {
    expect(service).toBeTruthy();
  }));
});
