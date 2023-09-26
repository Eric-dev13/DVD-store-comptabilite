import { TestBed } from '@angular/core/testing';

import { DvdServiceService } from './dvd-service.service';

describe('DvdServiceService', () => {
  let service: DvdServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DvdServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
