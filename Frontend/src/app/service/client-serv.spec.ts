import { TestBed } from '@angular/core/testing';

import { ClientServ } from './client-serv';

describe('ClientServ', () => {
  let service: ClientServ;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ClientServ);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
