import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ActualizarMotoComponent } from './actualizar-moto.component';

describe('ActualizarMotoComponent', () => {
  let component: ActualizarMotoComponent;
  let fixture: ComponentFixture<ActualizarMotoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ActualizarMotoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ActualizarMotoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
