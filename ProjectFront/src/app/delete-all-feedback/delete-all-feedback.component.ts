import { Component, OnInit } from '@angular/core';
import { DataAdminService } from '../data-admin.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-delete-all-feedback',
  templateUrl: './delete-all-feedback.component.html',
  styleUrls: ['./delete-all-feedback.component.css']
})
export class DeleteAllFeedbackComponent implements OnInit {

  constructor(private adminservice:DataAdminService,private router:Router) { }

  ngOnInit() {
    console.log("In Delete feedBack");
    let observableResult= this.adminservice.DeleteAllFeedBack();
    observableResult.subscribe((result)=>{
     console.log("In after delete feedBack");
     this.router.navigate(['/feedBackList']);
    })
    
   
  }

}
