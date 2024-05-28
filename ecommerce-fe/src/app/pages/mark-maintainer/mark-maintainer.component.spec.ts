import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MarkMaintainerComponent } from './mark-maintainer.component';

describe('MarkMaintainerComponent', () => {
  let component: MarkMaintainerComponent;
  let fixture: ComponentFixture<MarkMaintainerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MarkMaintainerComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(MarkMaintainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
