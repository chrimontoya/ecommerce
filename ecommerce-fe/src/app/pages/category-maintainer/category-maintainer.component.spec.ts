import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CategoryMaintainerComponent } from './category-maintainer.component';

describe('CategoryMaintainerComponent', () => {
  let component: CategoryMaintainerComponent;
  let fixture: ComponentFixture<CategoryMaintainerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CategoryMaintainerComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CategoryMaintainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
