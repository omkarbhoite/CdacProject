import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { ActivatedRoute, Router } from '@angular/router';
import { DataService } from '../data.service';
import { DataAdminService } from '../data-admin.service';

@Component({
  selector: 'app-feed-back',
  templateUrl: './feed-back.component.html',
  styleUrls: ['./feed-back.component.css']
})
export class FeedBackComponent implements OnInit {

  StudentId:any;
  StudentObj:any;
  constructor(private route:ActivatedRoute,
    private router:Router,private adminservice:DataAdminService,private authservice:AuthService) { }

  ngOnInit() {
    
      // this.courseid=courseId;
     
      this.StudentObj=JSON.parse(window.sessionStorage.getItem("studDetails"));
      console.log(this.StudentObj.studentId);

      
  
  }
  OnFeedbackInsert(myForm)
  {
    let feedbackObj=myForm.form.value;
    //console.log(this.courseid);
    console.log(feedbackObj);
    let observableResult=this.adminservice.InsertFeedBack(this.StudentObj.studentId,feedbackObj)
    observableResult.subscribe((result)=>{
      console.log(result);
      
      
      this.router.navigate(['/home']);
    })
  }
  StudentDetails()
  {
    this.router.navigate(["/CheckStudent"]);
  }

}
