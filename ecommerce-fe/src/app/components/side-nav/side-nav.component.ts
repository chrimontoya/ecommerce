import {Component} from '@angular/core';
import {MatSidenavModule} from "@angular/material/sidenav";
import {MatExpansionModule} from "@angular/material/expansion";
import {NavComponent} from "../nav/nav.component";
import {SideNavService} from "../../services/side-nav.service";
import {NgForOf} from "@angular/common";
import {MatButton} from "@angular/material/button";

@Component({
  selector: 'app-side-nav',
  standalone: true,
  imports: [MatSidenavModule, MatExpansionModule, NavComponent, NgForOf, MatButton],
  templateUrl: './side-nav.component.html',
  styleUrl: './side-nav.component.scss'
})
export class SideNavComponent {
  panelOpenState: boolean = false;
  list = ['Pan', 'Bebidas', 'Embutidos']

  constructor(
    public sideNavService: SideNavService,
  ) {
  this.sideNavService.openedState.subscribe({
    next: (state: boolean) => {
      this.panelOpenState = state;
    }
  })
  }
}
