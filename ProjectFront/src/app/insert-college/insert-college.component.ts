import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute } from '@angular/router';
import { DataAdminService } from '../data-admin.service';

@Component({
  selector: 'app-insert-college',
  templateUrl: './insert-college.component.html',
  styleUrls: ['./insert-college.component.css']
})
export class InsertCollegeComponent implements OnInit {

  locationId:any;
  message:any;
  constructor(private adminservice:DataAdminService, 
    private router:Router,private route:ActivatedRoute) { }

  ngOnInit() {
    this.route.paramMap.subscribe((result)=>{
      let lid=result.get("lid");
      console.log(lid);
      // this.courseid=courseId;
      this.locationId=lid;
      
    })
  }
  OnCollegeInsert(myForm)
  {
    let colllegeObj=myForm.form.value;
    //console.log(this.courseid);
    console.log(colllegeObj);
    colllegeObj.collegeRole='COLLEGE';
    let observableResult=this.adminservice.InsertCollege(this.locationId,colllegeObj);
    observableResult.subscribe((result)=>{
      console.log(result);
      this.message="College Added succsesFully";
      
      this.router.navigate(['/location/'+this.locationId]);
    })
  }

}
