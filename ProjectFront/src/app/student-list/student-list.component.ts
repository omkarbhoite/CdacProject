import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DataService } from '../data.service';
import { AuthService } from '../auth.service';
import { DataAdminService } from '../data-admin.service';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {

  // Courses:any;
  // CourseId:any;
  StudenList:any;
  constructor(private route:ActivatedRoute, private adminservice:DataAdminService,
    private router:Router, private authservice:AuthService) { }

  ngOnInit() {
    // this.route.paramMap.subscribe((result)=>{
    //   let courseId=result.get("courseId");
    //   console.log(courseId)
    //   this.CourseId=courseId;

      let observableResult=this.adminservice.SelectStudentList();
      observableResult.subscribe((records)=>{
        console.log(records);
        //this.Courses=records;
        this.StudenList=records;
        //this.locationLid=this.location.lid;
        //this.authservice.setLocationId(this.location.lid);
       


      })

    // })
  }
  GoBackHome()
  {
    this.router.navigate(['/home']);
  }

}
