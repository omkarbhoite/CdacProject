import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DataService } from '../data.service';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-college',
  templateUrl: './college.component.html',
  styleUrls: ['./college.component.css']
})
export class CollegeComponent implements OnInit {

  // location={"lid":"","region":"","pincode":"",};
  location:any;
  locationLid:any;
  CollegeList:any;
 constructor(private route:ActivatedRoute, private service:DataService,
              private router:Router, private authservice:AuthService) { }

  ngOnInit() {
    this.route.paramMap.subscribe((result)=>{
      let lid=result.get("lid");
      console.log(lid)
      this.locationLid=lid;

      let observableResult=this.service.SelectLocationByNo(lid);
      observableResult.subscribe((records)=>{
        console.log(records);
        this.location=records;
        this.locationLid=this.location.lid;
        this.CollegeList=this.location.collegeList;
        this.authservice.setLocationId(this.location.lid);
       


      })

    })

  }
  


}
