import { Component, OnInit } from '@angular/core';
import {MatButtonModule} from '@angular/material/button';
import {MatSidenavModule} from '@angular/material/sidenav';
import { RouterOutlet } from '@angular/router';
import { SideNavService } from '../../services/side-nav.service';

@Component({
  selector: 'app-side-nav',
  standalone: true,
  imports: [MatButtonModule, MatSidenavModule, RouterOutlet],
  templateUrl: './side-nav.component.html',
  styleUrl: './side-nav.component.scss'
})
export class SideNavComponent implements OnInit {
  show: boolean = false;

  constructor(private sideNavService: SideNavService){}
  
  ngOnInit(): void {
    this.sideNavService.subscription.asObservable().subscribe({
      next: (state) => {
        this.show = state;
      }
    });
  }

}
