import { Component } from '@angular/core';
import {MatIcon} from "@angular/material/icon";
import {MatIconButton} from "@angular/material/button";
import {SideNavService} from "../../services/side-nav.service";

@Component({
  selector: 'app-administrator',
  standalone: true,
    imports: [
        MatIcon,
        MatIconButton
    ],
  templateUrl: './administrator.component.html',
  styleUrl: './administrator.component.scss'
})
export class AdministratorComponent {

  constructor(
    public sideNavService: SideNavService,
  ) {
  }

}
