import { Component, OnInit } from '@angular/core';
import { DataAdminService } from '../data-admin.service';
import { DataService } from '../data.service';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-request-list',
  templateUrl: './request-list.component.html',
  styleUrls: ['./request-list.component.css']
})
export class RequestListComponent implements OnInit {

  constructor(private adminservice:DataAdminService,private service:DataService,
    private authservice:AuthService) { }

  //CollegeObj:any;
  //CollegeId:any;
  StudentList:any;

  ngOnInit() {
   let collegeObj=JSON.parse(window.sessionStorage.getItem("CollegeDetails"));
   console.log(collegeObj)
   //this.CollegeId=collegeObj.cid;
   let observableResult=this.service.SelectStudentsWithStatusPendingCollegeId(collegeObj.cid);
   observableResult.subscribe((result)=>{
     this.StudentList=result;

   })
  }
}
  
