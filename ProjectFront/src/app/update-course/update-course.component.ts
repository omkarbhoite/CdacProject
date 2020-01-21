import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DataService } from '../data.service';
import { DataAdminService } from '../data-admin.service';

@Component({
  selector: 'app-update-course',
  templateUrl: './update-course.component.html',
  styleUrls: ['./update-course.component.css']
})
export class UpdateCourseComponent implements OnInit {

  courses:any;
  CourseID:any;
  CourseName:any;
  CutOff:any;
  Fees:any;
  Intake:any;
  StrYear:any;
  CollegeId:any;
  // courseId | courseName| cutOff | fees  | intake | strYear | collegeId 

  constructor(private route:ActivatedRoute, private service:DataService,
    private router:Router,private adminservice:DataAdminService) { }

  ngOnInit() {
    this.route.paramMap.subscribe((result)=>{
      let courseId=result.get("courseId");
      console.log(courseId);
      this.CourseID=courseId;
      let observableResult=this.service.SelectCourseById(courseId);
      observableResult.subscribe((records)=>{
        console.log(records);
        this.courses=records;
        this.CourseName=this.courses.courseName;
        this.CutOff=this.courses.cutOff;
        this.Fees=this.courses.fees;
        this.Intake=this.courses.intake;
        this.StrYear=this.courses.strYear;
        this.CollegeId=this.courses.collegeId;

      })
    })
  }
  OnCourseUpdate(myForm)
  {
    let courseObj=myForm.form.value;
    console.log(courseObj);
    let observableResult=this.adminservice.UpdateCourse(this.CourseID,courseObj);
    observableResult.subscribe((courseResult)=>{
      console.log(courseResult);
      let collegeId=JSON.parse(window.sessionStorage.getItem("CollegeId"));
      this.router.navigate(['/courses/'+collegeId]);

    })
  }

}
