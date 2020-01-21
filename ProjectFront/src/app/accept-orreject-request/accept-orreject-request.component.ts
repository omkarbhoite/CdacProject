import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DataService } from '../data.service';
import { DataAdminService } from '../data-admin.service';

@Component({
  selector: 'app-accept-orreject-request',
  templateUrl: './accept-orreject-request.component.html',
  styleUrls: ['./accept-orreject-request.component.css']
})
export class AcceptOrrejectRequestComponent implements OnInit {

  StudentObj:any;
  CollegeObj:any;
  constructor(private route:ActivatedRoute,private service:DataService,
    private adminservice:DataAdminService,private router:Router) { }

  ngOnInit() {
    this.route.paramMap.subscribe((result)=>{
      let studentId=result.get("studentId");
      console.log(studentId)
      let observablereult=this.service.SelectStudentById(studentId);
      observablereult.subscribe((records)=>{
        this.StudentObj=records;
        this.CollegeObj=JSON.parse(window.sessionStorage.getItem("CollegeDetails"));
        if(this.StudentObj.requeststatus == 'PENDING')
        {
          console.log(this.StudentObj);

          //this.StudentObj.requeststatus = 'ACCEPTED';
         // studentObj.collegeId=this.collegeId;
          console.log(this.StudentObj);
          let observable=this.adminservice.UpdateRequestStatus(this.CollegeObj.cid,this.StudentObj);
          observable.subscribe((result)=>{
            this.router.navigate(['/requestList']);

          })
          //let collegeObj=JSON.parse(window.sessionStorage.getItem("CollegeDetails"));
         
          
        }

      })
  })
}

}
