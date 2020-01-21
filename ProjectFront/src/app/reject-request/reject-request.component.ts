import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DataService } from '../data.service';
import { DataAdminService } from '../data-admin.service';

@Component({
  selector: 'app-reject-request',
  templateUrl: './reject-request.component.html',
  styleUrls: ['./reject-request.component.css']
})
export class RejectRequestComponent implements OnInit {

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

         
          console.log(this.StudentObj);
          let observable=this.adminservice.UpdateRequestStatusReject(this.CollegeObj.cid,this.StudentObj);
          observable.subscribe((result)=>{
            this.router.navigate(['/requestList']);

          })
          //let collegeObj=JSON.parse(window.sessionStorage.getItem("CollegeDetails"));
         
          
        }

      })
  })
  }

}
