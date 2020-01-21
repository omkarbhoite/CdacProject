import { Component, OnInit } from '@angular/core';
import { DataAdminService } from '../data-admin.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-insert-course',
  templateUrl: './insert-course.component.html',
  styleUrls: ['./insert-course.component.css']
})
export class InsertCourseComponent implements OnInit {

  collegeId:any;
  message:any;
  constructor(private adminservice:DataAdminService, 
    private router:Router,private route:ActivatedRoute) { }

  ngOnInit() {
    this.route.paramMap.subscribe((result)=>{
      let cid=result.get("cid");
      console.log(cid);
      // this.courseid=courseId;
      this.collegeId=cid;
      
    })
  }
  OnCourseInsert(myForm)
  {
    let courseObj=myForm.form.value;
    //console.log(this.courseid);
    console.log(courseObj);
    let observableResult=this.adminservice.InsertCourse(this.collegeId,courseObj);
    observableResult.subscribe((result)=>{
      console.log(result);
      this.message="Course Added succsesFully";
      
      this.router.navigate(['/courses/'+this.collegeId]);
    })
  }

}
