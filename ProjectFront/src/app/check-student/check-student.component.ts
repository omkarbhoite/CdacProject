import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DataService } from '../data.service';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-check-student',
  templateUrl: './check-student.component.html',
  styleUrls: ['./check-student.component.css']
})
export class CheckStudentComponent implements OnInit {

  Students:any;
  message:any;
  constructor(private route:ActivatedRoute, private service:DataService,
    private router:Router, private authservice:AuthService) { }

  ngOnInit() {
  }
  Checkdetails(validationForm)
  {
    let studObj=validationForm.form.value;
    console.log(studObj);
    let observableResult=this.service.CheckRegisteredStudent(studObj);
    observableResult.subscribe((result)=>{
      console.log(result);
      if(result != null)
      {
        this.Students=result;
        console.log(this.Students.studentId);
       
        
       this.authservice.setStudentSession(result);
  
        //this.router.navigate(['/collegeInfo/'+this.Students.studentId]);
        this.router.navigate(['/home']);

      }
      else{
        this.message="Invalid username/password";
      }
      

    })
  }

}
