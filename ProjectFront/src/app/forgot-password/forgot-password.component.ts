import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';
import { DataAdminService } from '../data-admin.service';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent implements OnInit {

  Student:any;
  StudentId:any;
  StudentEmail:any;
  message:any;
  constructor(private service:DataService, private router:Router,private authService:AuthService,
              private adminservice:DataAdminService) { }

  ngOnInit() {
    // this.Student=JSON.parse(window.sessionStorage.getItem("studDetails"));
    // this.StudentId=this.Student.studentId;
    // this.StudentEmail=this.Student.studEmail;
  }
  OnUpdatingPassword(myForm)
  {
    let studentobj=myForm.form.value;
    //console.log(this.courseid);
    console.log(studentobj)
    let observableResult=this.service.CheckEmailAgeExists(studentobj)
    observableResult.subscribe((record)=>{
      console.log(record);
      console.log("Outside if");
      if(record != null)
      {
        console.log("inside if");
        this.Student=record;
        console.log(this.Student.studentId);
        this.StudentId=this.Student.studentId;
        console.log(this.StudentId);
        let observable=this.adminservice.UpdateStudentPassword(this.StudentId,studentobj);
        observable.subscribe((result)=>{

        })
        this.message="Updated successfully";
       
        
      //  this.authservice.setStudentSession(result);
  
        //this.router.navigate(['/collegeInfo/'+this.Students.studentId]);
        // this.router.navigate(['/collegeInfo']);

      }
      else{
        this.message="Invalid Email/Age";
      }

    })
  }

}
