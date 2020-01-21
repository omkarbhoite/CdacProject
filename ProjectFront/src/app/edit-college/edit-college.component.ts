import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DataService } from '../data.service';
import { AuthService } from '../auth.service';
import { DataAdminService } from '../data-admin.service';

@Component({
  selector: 'app-edit-college',
  templateUrl: './edit-college.component.html',
  styleUrls: ['./edit-college.component.css']
})
export class EditCollegeComponent implements OnInit {

  college:any;
  collegeId:any;
  Accredation:any;
  CollageName:any;
  EstablishmentYear:any;
  HostelInfo:any;
  HostelFee:any;
  Ownership:any;
  Rating:any;
  University:any;
  LocationId:any;
  Placement:any;
  CollegeEmail:any;
  CollegePassword:any;
  
  


  //college={"cid":"","collageName":"","establishmentYear":"","hostelInfo":"","ownership":"","accredation":"","rating":"","university":""};
  constructor(private route:ActivatedRoute, private service:DataService,
    private router:Router,private adminservice:DataAdminService) { }
    
  ngOnInit() {
    this.route.paramMap.subscribe((result)=>{
      let cid=result.get("cid");
      console.log(cid);
      this.collegeId=cid;
      let observableResult=this.service.SelectCollegeById(cid);
      observableResult.subscribe((records)=>{
        console.log(records);
        this.college=records;
        this.Accredation=this.college.accredation
        this.CollageName=this.college.collageName
        this.EstablishmentYear=this.college.establishmentYear;
        this.HostelInfo=this.college.hostelInfo
        this.HostelFee=this.college.hostelFee
        this.Ownership=this.college.ownership
        this.Rating=this.college.rating
        this.Placement=this.college.placement
        this.University=this.college.university
        this.LocationId=this.college.locationId;
        this.CollegeEmail=this.college.email;
        this.CollegePassword=this.college.password;
        console.log(this.college);

      })
    })
  }
  OnCollegeUpdate(myForm)
  {
    let collegeObj=myForm.form.value;
    console.log(collegeObj);
    let observableResult=this.adminservice.UpdateCollege(this.collegeId,collegeObj);
    observableResult.subscribe((collegeResult)=>{
      console.log(collegeResult);
      let locationId=JSON.parse(window.sessionStorage.getItem("locationId"));
      this.router.navigate(['/location/'+locationId]);

    })
  }

}
