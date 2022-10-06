import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-ap-logo',
  templateUrl: './ap-logo.component.html',
  styleUrls: ['./ap-logo.component.css']
})
export class ApLogoComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
  }

  login() {
    this.router.navigate(["/login"])
  }
}
