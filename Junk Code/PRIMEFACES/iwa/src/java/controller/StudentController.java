
package controller;

import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import entity.Student;
import javax.ejb.EJB;
import logic.StudentFacade;

@ManagedBean
@SessionScoped
public class StudentController
{
 private Student currentStudent;
  @EJB
  StudentFacade studentFacade;

   private List<Student> studentList;
    public StudentController()
    {
    }
        @PostConstruct
       public void init()
       {
           currentStudent=new Student();
           studentList=new LinkedList<>();
           
                   
       }
    public Student getCurrentStudent() {
        return currentStudent;
    }

    public void setCurrentStudent(Student currentStudent) {
        this.currentStudent = currentStudent;
    }

    
   public String save()
   {
       studentFacade.create(currentStudent);
      // Student s=new Student();
       
//       s.setName(currentStudent.getName());
//       s.setZone(currentStudent.getZone());
//       s.setDistrict(currentStudent.getDistrict());
//       s.setDob(currentStudent.getDob());
//       s.setGender(currentStudent.getGender());
//       s.setHobbies(currentStudent.getHobbies());
       
//       studentList.add(s);
//       currentStudent.setName(null);
//       currentStudent.setDistrict(null);
//       currentStudent.setZone(null);
//       currentStudent.setDob(null);
//       currentStudent.setGender(null);
//       currentStudent.setHobbies(null);
  
       
       return "index";
   }

    public List<Student> getStudentList() {
        return studentFacade.findAll();
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
    public String view()
    {
        return "view";
    }
}
