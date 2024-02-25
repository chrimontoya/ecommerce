import { Component } from '@angular/core';
import {NavComponent} from "../../components/nav/nav.component";
import {SideNavComponent} from "../../components/side-nav/side-nav.component";

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    NavComponent,
    SideNavComponent
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent {

}
