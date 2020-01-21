import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DataService } from '../data.service';
import { DataAdminService } from '../data-admin.service';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-update-student',
  templateUrl: './update-student.component.html',
  styleUrls: ['./update-student.component.css']
})
export class UpdateStudentComponent implements OnInit {

  Student:any;
  StudentId:any;
 // Students:any;
  // Student:any;
  // StudentId:any;
  Studentname:any;
  StudentEmail:any;
  StudentPassword:any;
  StudentLocation:any;
  StudentAge:any;
  StudentMarks:any;
  constructor(private route:ActivatedRoute, private service:DataService,
    private router:Router,private adminservice:DataAdminService,private authservice:AuthService) { }

  ngOnInit() {
    this.route.paramMap.subscribe((result)=>{
      let studentId=result.get("studentId");
      console.log(studentId);
     // this.StudentId=studentId;
      let observableResult=this.service.SelectStudentById(studentId);
      observableResult.subscribe((records)=>{
        console.log(records);
        this.Student=records;
        //this.StudentId=this.Student.studentId;
        this.StudentId=this.Student.studentId;
        this.Studentname=this.Student.studName;
        this.StudentEmail=this.Student.studEmail;
        this.StudentPassword=this.Student.studPassword;
        this.StudentLocation=this.Student.studLocation;
        this.StudentAge=this.Student.age;
        this.StudentMarks=this.Student.marks;

      })
    })
  }
  OnStudentUpdate(myForm)
  {
    let studentObj=myForm.form.value;
    console.log(studentObj);
    let observableResult=this.adminservice.UpdateStudent(this.StudentId,studentObj)
    observableResult.subscribe((StudentResult)=>{
      console.log(StudentResult);
      //this.Students=StudentResult;
      //this.authservice.setStudentSession(StudentResult);
      this.authservice.StudentSignOut();
     // let locationId=JSON.parse(window.sessionStorage.getItem("locationId"));
      //this.router.navigate(['/collegeInfo']);

    })
  }

}
