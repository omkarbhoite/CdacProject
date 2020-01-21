import { Injectable } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot,RouterStateSnapshot } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService implements CanActivate{
  constructor(private router:Router) { }
  setStudentSession(studResult)
  {
    console.log(studResult);
    window.sessionStorage.setItem("studDetails",JSON.stringify(studResult));
    window.sessionStorage.setItem("isStudentActive","12345stud");
  }
  
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot){
    if(this.IsStudentLoggedIn())
   {
     console.log("User Has Logged in");
     return true;
   }
   else
   {
     console.log("User Has not Logged in");
     this.router.navigate(['/CheckStudent']);
     return false;  
   }

  }
  IsStudentLoggedIn()
  {
    if(window.sessionStorage.getItem("isStudentActive")!=null 
    && window.sessionStorage.getItem("isStudentActive") == "12345stud")
    {
      return true;
    }
    else{
      return false;
    }
  }
  setSession(result)
  {
    window.sessionStorage.setItem("userdetails",JSON.stringify(result));
    window.sessionStorage.setItem("isActive","12345ad");
        
    return true;
  }
  
  setCollegeSession(collegeresult)
  {
    console.log(collegeresult);
    window.sessionStorage.setItem("CollegeDetails",JSON.stringify(collegeresult));
    window.sessionStorage.setItem("isCollegeActive","12345college");
  }

  setLocationId(locId)
  {
    window.sessionStorage.setItem("locationId",JSON.stringify(locId));
    
  }
  setCourseId(courseId)
  {
    window.sessionStorage.setItem("CrsId",JSON.stringify(courseId));
  }

  setCollegeId(collegeId)
  {
    window.sessionStorage.setItem("CollegeId",JSON.stringify(collegeId));
  }

  IsBothLoggedIn()
  {
    if(window.sessionStorage.getItem("isActive")!=null 
    && window.sessionStorage.getItem("isActive") == "12345ad")
    {
      return true;
    }
    else if(window.sessionStorage.getItem("isCollegeActive")!=null 
    && window.sessionStorage.getItem("isCollegeActive") == "12345college")
    {
      return true;
    }
    else{
      return false;
    }
  }
  
  
  IsLoggedIn()
  {
    if(window.sessionStorage.getItem("isActive")!=null 
    && window.sessionStorage.getItem("isActive") == "12345ad")
    {
      return true;
    }
    else{
      return false;
    }
    
  }
  
  IsCollegeLoggedIn()
  {
    if(window.sessionStorage.getItem("isCollegeActive")!=null 
    && window.sessionStorage.getItem("isCollegeActive") == "12345college")
    {
      return true;
    }
    else{
      return false;
    }
    
  }

  StudentSignOut()
  {
    window.sessionStorage.setItem("studDetails", "0");
    window.sessionStorage.setItem("isStudentActive", "0");
    this.router.navigate(["/home"]);

  }
 
  CollegeSignOut()
  {
    window.sessionStorage.setItem("CollegeDetails", "0");
    window.sessionStorage.setItem("isCollegeActive", "0");
    this.router.navigate(["/home"]);
  }
 
  Logout()
  {
    window.sessionStorage.setItem("userdetails", "0");
    window.sessionStorage.setItem("isActive", "0");
    this.router.navigate(["/collegeLogin"]);
  }
}
