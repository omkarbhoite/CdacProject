import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DataAdminService } from '../data-admin.service';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-delete-student',
  templateUrl: './delete-student.component.html',
  styleUrls: ['./delete-student.component.css']
})
export class DeleteStudentComponent implements OnInit {

  
  message:any;
  constructor(private route:ActivatedRoute, private adminservice:DataAdminService,
    private router:Router, private authservice:AuthService) { }

  ngOnInit() {
    this.route.paramMap.subscribe((result)=>{
      let studentId=result.get("studentId");
      console.log(studentId);
     
      let observableResult=this.adminservice.DeleteStudentById(studentId);
      observableResult.subscribe((deletedStudent)=>{
      console.log(deletedStudent);
      //let locnId=JSON.parse(window.sessionStorage.getItem("locationId"));
      //this.authservice.destroyLocationId();
      //this.router.navigate(['/collegeInfo/'+this.StudentId]);
      this.authservice.StudentSignOut();
      })
  })
  }

}
