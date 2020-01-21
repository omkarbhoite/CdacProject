import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { CollegeComponent } from './college/college.component';
import { CollegeInfoComponent } from './college-info/college-info.component';
import { CoursesComponent } from './courses/courses.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { HttpClient,HttpClientModule} from '@angular/common/http';
import { RouterModule} from '@angular/router';

import {NgModel, FormsModule, NgForm} from '@angular/forms';
import { AuthService } from './auth.service';
import { NotFoundComponent } from './not-found/not-found.component';
import { FeedBackComponent } from './feed-back/feed-back.component';
import { CheckStudentComponent } from './check-student/check-student.component';
import { DeleteCollegeComponent } from './delete-college/delete-college.component';
import { EditCollegeComponent } from './edit-college/edit-college.component';
import { InsertCollegeComponent } from './insert-college/insert-college.component';
import { DeleteCourseComponent } from './delete-course/delete-course.component';
import { InsertCourseComponent } from './insert-course/insert-course.component';
import { UpdateCourseComponent } from './update-course/update-course.component';
import { UpdateStudentComponent } from './update-student/update-student.component';
import { DeleteStudentComponent } from './delete-student/delete-student.component';
import { StudentListComponent } from './student-list/student-list.component';
import { FeedBackListComponent } from './feed-back-list/feed-back-list.component';
import { DeleteFeedbackComponent } from './delete-feedback/delete-feedback.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { CollegeLoginComponent } from './college-login/college-login.component';
import { RequestListComponent } from './request-list/request-list.component';
import { ViewCollegeInfoComponent } from './view-college-info/view-college-info.component';
import { AcceptOrrejectRequestComponent } from './accept-orreject-request/accept-orreject-request.component';
import { RejectRequestComponent } from './reject-request/reject-request.component';
import { DeleteAllFeedbackComponent } from './delete-all-feedback/delete-all-feedback.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    CollegeComponent,
    CollegeInfoComponent,
    CoursesComponent,
    RegisterComponent,
    LoginComponent,
    NotFoundComponent,
    FeedBackComponent,
    CheckStudentComponent,
    DeleteCollegeComponent,
    EditCollegeComponent,
    InsertCollegeComponent,
    DeleteCourseComponent,
    InsertCourseComponent,
    UpdateCourseComponent,
    UpdateStudentComponent,
    DeleteStudentComponent,
    StudentListComponent,
    FeedBackListComponent,
    DeleteFeedbackComponent,
    ForgotPasswordComponent,
    CollegeLoginComponent,
    RequestListComponent,
    ViewCollegeInfoComponent,
    AcceptOrrejectRequestComponent,
    RejectRequestComponent,
    DeleteAllFeedbackComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot([
      //{path:"**",component:NotFoundComponent},
      {path:"",component:HomeComponent},
      {path:"home",component:HomeComponent},
      {path:"location",component:CollegeComponent},
      {path:"location/:lid",component:CollegeComponent},
      {path:"collegeInfo",component:CollegeInfoComponent},
      //{path:"collegeInfo/:studentId",component:CollegeInfoComponent},
      {path:"courses",component:CoursesComponent},
      {path:"courses/:cid",component:CoursesComponent},
      {path:"login",component:LoginComponent},
      {path:"register",component:RegisterComponent},
      {path:"CheckStudent",component:CheckStudentComponent},
      {path:"deleteColllge/:cid",component:DeleteCollegeComponent},
      {path:"EditCollege/:cid",component:EditCollegeComponent},
      {path:"InsertCollege/:lid",component:InsertCollegeComponent},
      {path:"deleteCourse/:courseId",component:DeleteCourseComponent},
      {path:"EditCourse/:courseId",component:UpdateCourseComponent},
      {path:"InsertCourse/:cid",component:InsertCourseComponent},
      {path:"deleteStudent/:studentId",component:DeleteStudentComponent},
      {path:"EditStudent/:studentId",component:UpdateStudentComponent},
      {path:"feedBackList",component:FeedBackListComponent},
      {path:"StudentList",component:StudentListComponent},
      {path:"forgotPassword",component:ForgotPasswordComponent},
      {path:"feedback",component:FeedBackComponent,canActivate:[AuthService]},
      {path:"collegeLogin",component:CollegeLoginComponent},
      {path:"requestList",component:RequestListComponent},
      {path:"viewCollegeInfo",component:ViewCollegeInfoComponent,canActivate:[AuthService]},
      {path:"acceptRequest/:studentId",component:AcceptOrrejectRequestComponent},
      {path:"rejectRequest/:studentId",component:RejectRequestComponent},
      {path:"deleteAllFeedBack",component:DeleteAllFeedbackComponent}


      

    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
