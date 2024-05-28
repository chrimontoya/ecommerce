import { Routes } from '@angular/router';
import { AuthComponent } from './pages/auth/auth.component';
import { HomeComponent } from './pages/home/home.component';
import { authGuard } from './guards/auth.guard';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { SideNavComponent } from './components/side-nav/side-nav.component';
import { CategoryMaintainerComponent } from './pages/category-maintainer/category-maintainer.component';
import { MarkMaintainerComponent } from './pages/mark-maintainer/mark-maintainer.component';
import { ProductMaintainerComponent } from './pages/product-maintainer/product-maintainer.component';

export const routes: Routes = [
  { path: 'iniciar-sesion', component: AuthComponent },
  {
    path: 'ecommerce',
    component: SideNavComponent,
    canActivate: [authGuard],
    children: [
      {
        path: '',
        component: HomeComponent,
        children: [
          { path: 'categorias', component: CategoryMaintainerComponent },
          { path: 'marcas', component: MarkMaintainerComponent },
          { path: 'productos', component: ProductMaintainerComponent },
        ],
      },
    ],
  },
];
