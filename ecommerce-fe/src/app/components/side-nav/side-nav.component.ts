import {Component} from '@angular/core';
import {MatSidenavModule} from "@angular/material/sidenav";
import {MatExpansionModule} from "@angular/material/expansion";
import {NavComponent} from "../nav/nav.component";
import {SideNavService} from "../../services/side-nav.service";
import {NgForOf, NgIf} from "@angular/common";
import {MatButton} from "@angular/material/button";
import {LocalService} from "../../services/local.service";
import {AdministratorComponent} from "../../pages/administrator/administrator.component";
import {LoginDTO} from "../../models/dto/loginDTO";
import {MatListModule} from "@angular/material/list";
import {MatMenuItem} from "@angular/material/menu";

@Component({
  selector: 'app-side-nav',
  standalone: true,
  imports: [MatSidenavModule, MatExpansionModule, NavComponent, NgForOf, MatButton, NgIf, AdministratorComponent, MatListModule, MatMenuItem],
  templateUrl: './side-nav.component.html',
  styleUrl: './side-nav.component.scss'
})
export class SideNavComponent {
  panelOpenState: boolean = false;
  list = ['Pan', 'Bebidas', 'Embutidos'];
  adminList: string[] = ['Usuarios'];
  mantainerList: string[] = ['Categorias', 'Productos', 'Marcas'];
  isAdmin: boolean = false;
  isLogguedIn: boolean = false;

  constructor(
    public sideNavService: SideNavService,
    private localService: LocalService,
  ) {
    this.isAdmin = this.localService.hasRoleAdmin();
    this.isLogguedIn = this.localService.isLoggedIn();
    this.sideNavService.openedState.subscribe({
      next: (state: boolean) => {
        this.panelOpenState = state;
      }
    });
  }

  logOut() {
    this.localService.logOut();
  }
}
