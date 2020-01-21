import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthService } from '../auth.service';
import { DataAdminService } from '../data-admin.service';

@Component({
  selector: 'app-delete-college',
  templateUrl: './delete-college.component.html',
  styleUrls: ['./delete-college.component.css']
})
export class DeleteCollegeComponent implements OnInit {

  constructor(private route:ActivatedRoute, private service:DataAdminService,
    private router:Router, private authservice:AuthService) { }

  ngOnInit() {
    this.route.paramMap.subscribe((result)=>{
      let cid=result.get("cid");
      console.log(cid);
      let observableResult=this.service.DeleteCollegeById(cid);
      observableResult.subscribe((deletedCollege)=>{
      console.log(deletedCollege);
      let locnId=JSON.parse(window.sessionStorage.getItem("locationId"));
      //this.authservice.destroyLocationId();
      this.router.navigate(['/location/'+locnId]);
      })
  })

}
}
