import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { Router, ActivatedRoute } from '@angular/router';
import { AuthService } from '../auth.service';
import { JsonPipe } from '@angular/common';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  message="";
  //message1="";
  // courses:any;
  // courseid:any;
  Students:any;
  StudentsObj:any;
  constructor(private service:DataService, private router:Router,
    private route:ActivatedRoute, private authservice:AuthService) { }

  ngOnInit() {
    // this.route.paramMap.subscribe((result)=>{
    //   let courseId=result.get("courseId");
    //   console.log(courseId);
    //   this.courseid=courseId;
    // })


  }
  OnAddCallMe(myForm)
  {
    let studentobj=myForm.form.value;
    //console.log(this.courseid);
    if(studentobj.studEmail == null || studentobj.studPassword==null || this.StudentsObj.age==null || studentobj.studName==null)
    {
      this.message="Please enter mandatory fields";

    }
    else{

    console.log(studentobj)
    let checkStudent=this.service.CheckEmailExists(studentobj);
    console.log(checkStudent);
    checkStudent.subscribe((records)=>{
        console.log("outside if");
        console.log(records)
        
        if(records == null)
        {
          console.log("inside if");
          this.StudentsObj=records;
          //this.StudentsObj.requeststatus = 'NOREQUEST';
          let observableResult=this.service.InsertStudentDataWithEmailApi(studentobj);
          observableResult.subscribe((result)=>{
          console.log(result);
          this.Students=result;
          console.log(this.Students.studentId);
         // let collegeID=JSON.parse(window.sessionStorage.getItem("CollegeId"));
        
          this.message="Registered successfully";

          
       
         
        
          });
  
        }
        else{
          
          this.message="Email already exists";
        }
      })
    }
    
  }
  // StudentDetails()
  // {
  //   this.router.navigate(["/CheckStudent"]);
  // }


  // GoBackHome()
  // {
  //   this.router.navigate(["/home"]);
  // }

  


}
// checkStudent.subscribe((record)=>{
    //   console.log("outside if");
    //   console.log(record)
    //   if(record == null)
    //   {
    //     console.log("inside if");
    //     let observableResult=this.service.InsertData(this.courseid,studentobj);
    //     observableResult.subscribe((result)=>{
    //     console.log(result);
    //     this.Students=result;
    //     console.log(this.Students.studentId);
     
    //     this.router.navigate(["/register"]);
      
    //     });

    //   }
    //   else{
        
    //     this.message="You already registered";
    //   }
    // })
    
    // let observableResult=this.service.InsertData(this.courseid,studentobj);
    // observableResult.subscribe((result)=>{
    // console.log(result);
    // this.Students=result;
    // console.log(this.Students.studentId);
     
    //   this.router.navigate(["/register"]);
      
    // })