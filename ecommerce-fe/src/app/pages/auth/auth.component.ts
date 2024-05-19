import { Component } from '@angular/core';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { AuthService } from '../../services/auth.service';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  ReactiveFormsModule,
} from '@angular/forms';

@Component({
  selector: 'app-auth',
  standalone: true,
  imports: [MatInputModule, MatButtonModule, ReactiveFormsModule],
  templateUrl: './auth.component.html',
  styleUrl: './auth.component.scss',
})
export class AuthComponent {
  form!: FormGroup;
  constructor(private authService: AuthService, private fb: FormBuilder) {
    this.form = this.fb.group({
      username: new FormControl(),
      password: new FormControl(),
    });
  }

  logIn() {
    this.authService
      .logIn(this.form.get('username')?.value, this.form.get('password')?.value)
      .subscribe({
        next: (res) => {
          console.log(res);
        },
      });
  }
}
