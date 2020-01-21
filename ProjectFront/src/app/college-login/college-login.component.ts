import { Component, OnInit } from '@angular/core';
import { DataAdminService } from '../data-admin.service';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-college-login',
  templateUrl: './college-login.component.html',
  styleUrls: ['./college-login.component.css']
})
export class CollegeLoginComponent implements OnInit {

  collegeObj:any;
  CollegeId:any;
  message:any;
  constructor(private route:ActivatedRoute, private adminservice:DataAdminService,
    private router:Router, private authservice:AuthService) { }

  ngOnInit() {
  }
  CheckCollegedetails(validationForm)
  {
    let CollegeObj=validationForm.form.value;
    console.log(CollegeObj);
    let observableResult=this.adminservice.CheckRegisteredCollege(CollegeObj);
    observableResult.subscribe((result)=>{
      console.log(result);
      if(result != null)
      {
        this.collegeObj=result;
        console.log(this.collegeObj.cid);
       
        
        this.authservice.setCollegeSession(result);
  
        //this.router.navigate(['/collegeInfo/'+this.Students.studentId]);
        this.router.navigate(['/requestList']);

      }
      else{
        this.message="Invalid username/password";
      }
      

    })
  }

}
