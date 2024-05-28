import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductMaintainerComponent } from './product-maintainer.component';

describe('ProductMaintainerComponent', () => {
  let component: ProductMaintainerComponent;
  let fixture: ComponentFixture<ProductMaintainerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ProductMaintainerComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ProductMaintainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
