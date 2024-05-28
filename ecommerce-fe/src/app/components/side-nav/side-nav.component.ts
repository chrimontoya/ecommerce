import { Component, OnInit } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatSidenavModule } from '@angular/material/sidenav';
import { Router, RouterOutlet } from '@angular/router';
import { SideNavService } from '../../services/side-nav.service';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-side-nav',
  standalone: true,
  imports: [
    MatButtonModule,
    MatSidenavModule,
    RouterOutlet,
    MatIconModule,
    MatListModule,
  ],
  templateUrl: './side-nav.component.html',
  styleUrl: './side-nav.component.scss',
})
export class SideNavComponent implements OnInit {
  show: boolean = false;
  items: any = [
    { id: 1, label: 'Products', path: 'ecommerce/productos', order: 1, icon: 'home', color: 'primary', navigate: (path: string)=> this.router.navigate([path])},
    { id: 2, label: 'Categorias', path: 'ecommerce/categorias', order: 2, icon: 'home', color: 'primary', navigate: (path: string)=> this.router.navigate([path]) },
    { id: 3, label: 'Marcas', path: 'ecommerce/marcas', order: 3, icon: 'home', color: 'primary', navigate: (path: string)=> this.router.navigate([path]) },
  ];

  constructor(
    private sideNavService: SideNavService,
    private authService: AuthService,
    private router: Router,
  ) {}

  ngOnInit(): void {
    this.sideNavService.subscription.asObservable().subscribe({
      next: (state) => {
        this.show = state;
      },
    });
  }

  logOut() {
    this.authService.logOut();
  }
}
