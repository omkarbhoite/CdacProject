import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DataAdminService } from '../data-admin.service';
import { AuthService } from '../auth.service';
import { DataService } from '../data.service';

@Component({
  selector: 'app-feed-back-list',
  templateUrl: './feed-back-list.component.html',
  styleUrls: ['./feed-back-list.component.css']
})
export class FeedBackListComponent implements OnInit {

  feedBackObj:any;
  InfoRating:any;
  LocationRating:any;
  WebApprating:any;

  constructor(private route:ActivatedRoute,
    private router:Router,private adminservice:DataAdminService,private authservice:AuthService) { }

  ngOnInit() {
    let observableResult=this.adminservice.SelectAllFeedback();
    observableResult.subscribe((result)=>{
      console.log(result);
      this.feedBackObj=result;
      this.InfoRating=this.feedBackObj.infoRating;
      this.LocationRating=this.feedBackObj.locationRating;
      this.WebApprating=this.feedBackObj.webAppRating;
    })
  }
  Delete()
  {
    this.router.navigate(['/deleteAllFeedBack']);

  }

}
