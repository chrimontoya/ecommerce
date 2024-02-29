import {Component} from '@angular/core';
import {MatButtonModule} from "@angular/material/button";
import {MatIconModule} from "@angular/material/icon";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import {FormControl, FormGroup, FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MatMenuModule} from "@angular/material/menu";
import {LocalService} from "../../services/local.service";
import {LoginDTO} from "../../models/dto/loginDTO";
import {NgForOf} from "@angular/common";
import {SideNavService} from "../../services/side-nav.service";
import {RouterLink} from "@angular/router";

@Component({
  selector: 'app-nav',
  standalone: true,
  imports: [MatButtonModule, MatIconModule, MatFormFieldModule, MatInputModule, FormsModule, ReactiveFormsModule, MatMenuModule, NgForOf, RouterLink],
  templateUrl: './nav.component.html',
  styleUrl: './nav.component.scss',
})
export class NavComponent {
  formGroup: FormGroup = new FormGroup<any>(
    {
      searchInput: new FormControl(),
    });
  menuUser = [
    {id: 1, description: "Mis compras", order: 1},
    {id: 2, description: "Cerrar sesión", order: 2},
  ];
  menuInicio = [
    {id: 1, description: "Categorias", order: 1},
    {id: 2, description: "Ofertas", order: 2},
    {id: 3, description: "Envíos rápidos", order: 3},
  ]

  user: LoginDTO | null = null;

  constructor(
    private localService: LocalService,
    public sideNavService: SideNavService,
  ) {
    this.user = this.localService.user;
  }

  menuAction(id: number) {
    switch (id) {
      case 1:
        return this.misCompras();
      case 2:
        return this.localService.logOut();
    }
  }

  misCompras() {
    console.log("mis compras")
  }

}
