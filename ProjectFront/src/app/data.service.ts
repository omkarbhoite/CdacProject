import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor(public http:HttpClient) {
    console.log("In service ctor")
  }
  Select()
  {
    return this.http.get("http://localhost:8080/CdacProject/location");
  }

  SelectLocationByNo(lid)
  {
    return this.http.get("http://localhost:8080/CdacProject/location/"+lid);
  }
  SelectCollegeById(cid)
  {
    return this.http.get("http://localhost:8080/CdacProject/college/"+cid);
  }
  InsertStudentData(studentObj)
  {
    return this.http.post("http://localhost:8080/CdacProject/students",studentObj);
  }
  SelectStudentById(studentId)
  {
    return this.http.get("http://localhost:8080/CdacProject/students/"+studentId);
  }
  CheckUser(userdetails)
  {
    return this.http.post("http://localhost:8080/CdacProject/users",userdetails);
  }
  CheckRegisteredStudent(studObj)
  {
    console.log(studObj);
    return this.http.post("http://localhost:8080/CdacProject/students/checkStudent",studObj);
  }
  CheckEmailExists(studObj)
  {
    console.log(studObj);
    return this.http.post("http://localhost:8080/CdacProject/students/checkEmailExists",studObj);
  }
  SelectCourseById(courseId)
  {
    return this.http.get("http://localhost:8080/CdacProject/courses/"+courseId);

  }
  CheckEmailAgeExists(studObj)
  {
    console.log(studObj);
    return this.http.post("http://localhost:8080/CdacProject/students/forgotpassword",studObj);
  }
  
  InsertStudentDataWithEmailApi(studentObj)
  {
    return this.http.post("http://localhost:8080/CdacProject/students/withEmail",studentObj);
  }
  
  SelectStudentsWithStatusPendingCollegeId(collegeId)
  {
    console.log(collegeId)
    return this.http.get("http://localhost:8080/CdacProject/college/studentsfrom/"+collegeId);
  }
  
  


}

