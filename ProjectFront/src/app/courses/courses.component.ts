import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DataService } from '../data.service';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.css']
})
export class CoursesComponent implements OnInit {

  colleges:any;
  // collgename:any;
  // startingYear:any;
  // HostelInfo:any;
  // HostelFee:any;

  // collegerating:any;
  // Accredation:any;
  // universityOfCollege:any;
  collegeId:any;
  CourseList:any;
  message="";
  constructor(private route:ActivatedRoute, private service:DataService,
    private router:Router, private authservice:AuthService) { }

  ngOnInit() {
    this.route.paramMap.subscribe((result)=>{
      let cid=result.get("cid");
      console.log(cid);
      this.collegeId=cid;

      let observableResult=this.service.SelectCollegeById(cid);
      observableResult.subscribe((records)=>{
        console.log(records);
        this.colleges=records;
        // this.collgename=this.colleges.collageName;
        // this.startingYear=this.colleges.establishmentYear;
        // this.HostelInfo=this.colleges.hostelInfo;
        // this.HostelFee=this.colleges.hostelFee;
        // this.collegerating=this.colleges.rating;
        // this.Accredation=this.colleges.accredation;
        // this.universityOfCollege=this.colleges.university;
        this.CourseList=this.colleges.courseList;
        this.authservice.setCollegeId(this.colleges.cid);

        //console.log(this.collgename);
       


      })
     

    })
  }
  ViewCollegeInfo()
  {
    this.router.navigate(['/viewCollegeInfo'])
  }
  

 

}
