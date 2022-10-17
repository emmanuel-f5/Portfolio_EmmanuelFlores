import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-ap-logo',
  templateUrl: './ap-logo.component.html',
  styleUrls: ['./ap-logo.component.css']
})
export class ApLogoComponent implements OnInit {
  isLogged = false;


  constructor(private router:Router, private tokenService: TokenService) { }

  ngOnInit(): void {
    if(this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
  }

  onLogout(): void {
    this.tokenService.logOut();
    window.location.reload();
  }

  login() {
    this.router.navigate(["/login"])
  }
}
