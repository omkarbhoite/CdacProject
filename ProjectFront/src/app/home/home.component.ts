import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { Router } from "@angular/router";
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  location:any;
  user:any;
  constructor(private service:DataService, private router:Router,private authService:AuthService) { 
    console.log("In home ctor")
  }

  ngOnInit() {
    let observableResult=this.service.Select();
    observableResult.subscribe((result)=>{
      console.log(result);
      this.location=result;
      
    })

    if(this.authService.IsLoggedIn())
    {
      this.user=JSON.parse(window.sessionStorage.getItem("userdetails"));
      console.log(this.user)
    }
    
    
  }
  // GoToLogin()
  // {
  //   this.router.navigate(['/login']);
  // }
  // GoToLogOut()
  // {
  //   this.authService.Logout();

  // }

  
  




}
