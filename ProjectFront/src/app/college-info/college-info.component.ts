import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DataService } from '../data.service';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-college-info',
  templateUrl: './college-info.component.html',
  styleUrls: ['./college-info.component.css']
})
export class CollegeInfoComponent implements OnInit {

  
  Course:any;
  Student:any;
  StudentId:any;
  Studentname:any;
  StudentEmail:any;
  StudentLocation:any;
  StudentAge:any;
  StudentMarks:any;
  StudentRequest:any;

 
  constructor(private service:DataService,
    private router:Router,private authservice:AuthService,private route:ActivatedRoute) { }

  ngOnInit() {
    // this.route.paramMap.subscribe((result)=>{
    //   let studentId=result.get("studentId");
    //   console.log(studentId)
    //   let observableResult=this.service.SelectStudentById(studentId);
    //   observableResult.subscribe((studentRecord)=>{
    //     console.log(studentRecord);
    //     this.Student=studentRecord;
    //     this.StudentId=this.Student.studentId;
    //     this.Studentname=this.Student.studName;
    //     this.StudentEmail=this.Student.studEmail;
    //     this.StudentLocation=this.Student.studLocation;
    //     this.StudentAge=this.Student.age;
    //     this.StudentMarks=this.Student.marks;
        
    //     console.log(this.Student.studentId);
    //   })
    //  this.locationLid=lid;
    this.Student=JSON.parse(window.sessionStorage.getItem("studDetails"));
    this.StudentId=this.Student.studentId;
        this.Studentname=this.Student.studName;
        this.StudentEmail=this.Student.studEmail;
        this.StudentLocation=this.Student.studLocation;
        this.StudentAge=this.Student.age;
        this.StudentMarks=this.Student.marks;
        this.StudentRequest=this.Student.requeststatus

    
    
  //})
}
StudentLogin()
{
    this.router.navigate(["/CheckStudent"]);
}

}
