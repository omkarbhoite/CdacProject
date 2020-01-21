import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DataService } from '../data.service';
import { AuthService } from '../auth.service';
import { DataAdminService } from '../data-admin.service';

@Component({
  selector: 'app-view-college-info',
  templateUrl: './view-college-info.component.html',
  styleUrls: ['./view-college-info.component.css']
})
export class ViewCollegeInfoComponent implements OnInit {

  
  colleges:any;
  collgename:any;
  startingYear:any;
  HostelInfo:any;
  HostelFee:any;
  CollegePlacement:any;
  collegerating:any;
  Accredation:any;
  universityOfCollege:any;
  collegeId:any;
  message:any;
  StudentObj:any;
  constructor(private route:ActivatedRoute, private service:DataService,
    private router:Router, private authservice:AuthService,private adminservice:DataAdminService) { }

  ngOnInit() {
    let cid=JSON.parse(window.sessionStorage.getItem("CollegeId"));
    this.collegeId=cid;
    let observableResult=this.service.SelectCollegeById(cid);
    observableResult.subscribe((records)=>{
      console.log(records);
      this.colleges=records;
      this.collgename=this.colleges.collageName;
      this.startingYear=this.colleges.establishmentYear;
      this.HostelInfo=this.colleges.hostelInfo;
      this.HostelFee=this.colleges.hostelFee;
      this.collegerating=this.colleges.rating;
      this.CollegePlacement=this.colleges.placement;
      this.Accredation=this.colleges.accredation;
      this.universityOfCollege=this.colleges.university;
    })
  }
  VisitPermiision()
  {
    let studentObj=JSON.parse(window.sessionStorage.getItem("studDetails"));
    console.log(studentObj);
    this.StudentObj=studentObj;
    if(this.StudentObj.requeststatus == 'NOREQUEST' || this.StudentObj.requeststatus == 'ACCEPTED' || this.StudentObj.requeststatus == 'REJECTED')
    {
      console.log(this.StudentObj);

      //this.StudentObj.requeststatus = 'PENDING';
      //this.StudentObj.collegeId=this.collegeId;
      console.log(this.StudentObj);
     
      let observable=this.adminservice.UpdateRequestStatus(this.collegeId,this.StudentObj);
      observable.subscribe((result)=>{
        let observablereult=this.service.SelectStudentById(this.StudentObj.studentId);
      observablereult.subscribe((record)=>{
        console.log(record);
        this.authservice.setStudentSession(record);

      })
        
      });
      // let observablereult=this.service.SelectStudentById(this.StudentObj.studentId);
      // observablereult.subscribe((record)=>{
      //   console.log(record);
      //   this.authservice.setStudentSession(record);

      // });

      this.message="Request Sent";
    }
    else{
      this.message="Already requested permission for one college Sent";
    }
    
  }

}
