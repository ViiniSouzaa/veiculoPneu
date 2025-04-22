import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {
  username = '';
  password = '';

  constructor(private router: Router) {}

  onSubmit() {
    // aqui você vai chamar o serviço de autenticação
    console.log('Usuário:', this.username);
    console.log('Senha:', this.password);

    // simular login
    if (this.username === 'admin' && this.password === '123') {
      // aqui você guardaria o token, etc
      this.router.navigate(['/dashboard']);
    } else {
      alert('Usuário ou senha inválidos');
    }
  }
}