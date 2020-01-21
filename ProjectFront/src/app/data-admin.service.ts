import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DataAdminService {

  constructor(public http:HttpClient) { 
    console.log("In data-Admin constructor");

  }

  DeleteCollegeById(cid)
  {
    return this.http.delete("http://localhost:8080/CdacProject/college/"+cid);
  }
  InsertCollege(lid,collegeObj)
  {
    return this.http.post("http://localhost:8080/CdacProject/college/"+lid,collegeObj);
  }
  UpdateCourse(courseId,courseObj)
  {
    return this.http.put("http://localhost:8080/CdacProject/courses/"+courseId,courseObj);
  }
  DeleteCourseById(courseId)
  {
    return this.http.delete("http://localhost:8080/CdacProject/courses/"+courseId);
  }
  InsertCourse(cid,courseObj)
  {
    return this.http.post("http://localhost:8080/CdacProject/courses/"+cid,courseObj);
  }
  UpdateCollege(cid,collegeObj)
  {
    return this.http.put("http://localhost:8080/CdacProject/college/"+cid,collegeObj);
  }
  DeleteStudentById(studentId)
  {
    return this.http.delete("http://localhost:8080/CdacProject/students/"+studentId);
  }
  // InsertStudent(courseId,studObj)
  // {
  //   return this.http.post("http://localhost:8080/CdacProject/students/"+courseId,studObj);
  // }
  UpdateStudent(studentId,studentObj)
  {
    console.log(studentId,studentObj);
    return this.http.put("http://localhost:8080/CdacProject/students/"+studentId,studentObj);
  }
  SelectStudentWithFeedbackById(studentId)
  {
    return this.http.get("http://localhost:8080/CdacProject/students/studentsfeedback/"+studentId);
  }
  InsertFeedBack(studentId,feedBackObj)
  {
    return this.http.post("http://localhost:8080/CdacProject/feedback/"+studentId,feedBackObj);
  }
  SelectAllFeedback()
  {
    return this.http.get("http://localhost:8080/CdacProject/feedback/getAvg");
  }
  SelectStudentList()
  {
    return this.http.get("http://localhost:8080/CdacProject/students");

  }
  UpdateStudentPassword(studentId,studentObj)
  {
    console.log(studentId,studentObj);
    return this.http.put("http://localhost:8080/CdacProject/students/updatePassword/"+studentId,studentObj);
  }
  CheckRegisteredCollege(CollegeObj)
  {
    return this.http.post("http://localhost:8080/CdacProject/college",CollegeObj);
  }
  // SelectStudenstWithRequestPending(cid,studentObj)
  // {
  //   return this.http.post("http://localhost:8080/CdacProject/college/"+cid,studentObj);
  // }
  UpdateRequestStatus(collegeId,studsObj)
  {
    console.log(studsObj);
    return this.http.post("http://localhost:8080/CdacProject/college/requestStatus/"+collegeId,studsObj);
  }
  UpdateRequestStatusReject(collegeId,StudentObj)
  {
    console.log(StudentObj);
    return this.http.post("http://localhost:8080/CdacProject/college/requestStatusReject/"+collegeId,StudentObj)
  }

  DeleteAllFeedBack()
  {
    console.log("In deleteFeedBack service method");
    return this.http.delete("http://localhost:8080/CdacProject/feedback");

  }
  
  
  
}