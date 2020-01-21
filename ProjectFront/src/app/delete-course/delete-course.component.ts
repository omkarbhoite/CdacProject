import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DataAdminService } from '../data-admin.service';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-delete-course',
  templateUrl: './delete-course.component.html',
  styleUrls: ['./delete-course.component.css']
})
export class DeleteCourseComponent implements OnInit {

  constructor(private route:ActivatedRoute, private adminservice:DataAdminService,
    private router:Router, private authservice:AuthService) { }

  ngOnInit() {
    this.route.paramMap.subscribe((result)=>{
      let courseId=result.get("courseId");
      console.log(courseId);
      let observableResult=this.adminservice.DeleteCourseById(courseId);
      observableResult.subscribe((deletedCourse)=>{
      console.log(deletedCourse);
      let collId=JSON.parse(window.sessionStorage.getItem("CollegeId"));
      //this.authservice.destroyLocationId();
      this.router.navigate(['/courses/'+collId]);
      })
  })
}

}
