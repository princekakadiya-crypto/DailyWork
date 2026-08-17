import { NgClass } from '@angular/common';
import { Component } from '@angular/core';
import { AdminComponent } from '../admin/admin.component';
import { MemberComponent } from '../member/member.component';

@Component({
  selector: 'app-home',
  imports: [NgClass, AdminComponent, MemberComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {
  // boolean chek variable for the role
  isAdmin:boolean = true;

  constructor()
  {
    console.log(`isAdmin : ${this.isAdmin}`);
  }

  switchRole(role:string)
  {
    if(role == 'Member')
      this.isAdmin=false;
    else
      this.isAdmin = true;
  }
}
