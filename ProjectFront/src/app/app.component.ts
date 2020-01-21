import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from './auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ProjectFront';
  constructor(private router:Router,private authservice:AuthService)
  {
    console.log("App Component Created");
  }
  StudentLogin()
  {
    this.router.navigate(["/CheckStudent"]);
  }
  StudentDetails()
  {
    this.router.navigate(["/collegeInfo"]);
  }
  StudentLogOut()
  {
    this.authservice.StudentSignOut();
  }
  GoToLogin()
  {
    this.router.navigate(['/login']);
  }
  GoToLogOut()
  {
    if(this.authservice.IsLoggedIn())
    {
      this.authservice.Logout();
    }
    else if(this.authservice.IsCollegeLoggedIn())
    {
      this.authservice.CollegeSignOut();
    }

  }
  // CollegeLogOut()
  // {
  //   this.authservice.CollegeSignOut();
  // }
  

  
}
