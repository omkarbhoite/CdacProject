import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DataService } from '../data.service';
import { AuthService } from '../auth.service';
import { DataAdminService } from '../data-admin.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  UserRole:any;
  message:any;
  constructor(private route:ActivatedRoute, private service:DataService,
    private router:Router,private authservice:AuthService, private adminservice:DataAdminService) { }

  ngOnInit() {
  }
  SignIn(loginForm)
  {
    let adminObj=loginForm.form.value;
     console.log(adminObj);

    let observableResult=this.service.CheckUser(adminObj);
    observableResult.subscribe((result)=>{
      console.log(result);
     
     
      if(result != null)
      {
        this.authservice.setSession(result);
         this.UserRole=result;
        if(this.UserRole.role == 'ADMIN')
        {
          console.log(this.UserRole.role)
          this.router.navigate(["/home"]);
        }
      // else{
      //   this.message="Invalid username/password";
      //   this.router.navigate(["/login"]);
      // }s
      }
        else if(result == null)
        {
          
          console.log(adminObj);
          let observableRecord=this.adminservice.CheckRegisteredCollege(adminObj);
          observableRecord.subscribe((record)=>{
          console.log(record);
          if(record != null)
          {
            console.log("Inside if")
            //this.collegeObj=result;
            //console.log(this.collegeObj.cid);
          
            
            this.authservice.setCollegeSession(record);
      
            //this.router.navigate(['/collegeInfo/'+this.Students.studentId]);
            this.router.navigate(['/home']);

          }
      // else{
      //   this.message="Invalid username/password";
      // }
      

            })
              

          }
          else{
            this.message="Invalid username/password";
          }


    })
    

  }
  

}
