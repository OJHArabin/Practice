
package controller;

import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Student;

@ManagedBean
@SessionScoped
public class StudentController
{
 private Student currentStudent;
 private List<String> districtList;
 private List<String> zoneList;
 private List<String> genderList;
 private List<String> hobbyList;
 private List<Student> studentList;
    public StudentController()
    {
    }
        @PostConstruct
       public void init()
       {
           currentStudent=new Student();
           studentList=new LinkedList<>();
           districtList=new LinkedList<>();
           districtList.add("Jhapa");
           districtList.add("Illa");
           districtList.add("Panchthar");
           
           
           zoneList=new LinkedList<>();
           zoneList.add("Mechi");
           zoneList.add("Koshi");
           zoneList.add("Sagarmatha");
           
              
           genderList=new LinkedList<>();
           genderList.add("Male");
           genderList.add("Female");
           genderList.add("Third");
           
            hobbyList=new LinkedList<>();
           hobbyList.add("Cricket");
           hobbyList.add("Football");
           hobbyList.add("Others");
                   
       }
    public Student getCurrentStudent() {
        return currentStudent;
    }

    public void setCurrentStudent(Student currentStudent) {
        this.currentStudent = currentStudent;
    }

    public List<String> getDistrictList() {
        return districtList;
    }

    public void setDistrictList(List<String> districtList) {
        this.districtList = districtList;
    }

    public List<String> getZoneList() {
        return zoneList;
    }

    public void setZoneList(List<String> zoneList) {
        this.zoneList = zoneList;
    }
     public List<String> getGenderList() {
        return genderList;
    }

    public void setGenderList(List<String> genderList) {
        this.genderList = genderList;
    }

    public List<String> getHobbyList() {
        return hobbyList;
    }

    public void setHobbyList(List<String> hobbyList) {
        this.hobbyList = hobbyList;
    }
   public String save()
   {
       Student s=new Student();
       s.setName(currentStudent.getName());
       s.setZone(currentStudent.getZone());
       s.setDistrict(currentStudent.getDistrict());
       s.setDob(currentStudent.getDob());
       s.setGender(currentStudent.getGender());
       s.setHobbies(currentStudent.getHobbies());
       
       studentList.add(s);
       currentStudent.setName(null);
       currentStudent.setDistrict(null);
       currentStudent.setZone(null);
       currentStudent.setDob(null);
       currentStudent.setGender(null);
       currentStudent.setHobbies(null);
  
       
       return "index";
   }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
    public String view()
    {
        return "view";
    }
}
