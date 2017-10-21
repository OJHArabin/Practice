
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Student implements Serializable
{
    private String name;
    private String district;
    private String zone;
    private Date dob;
    private String gender;
    private List<String> hobbies;

    public Student() {
    }

    public Student(String name, String district, String zone, Date dob, String gender, List<String> hobbies) {
        this.name = name;
        this.district = district;
        this.zone = zone;
        this.dob = dob;
        this.gender = gender;
        this.hobbies = hobbies;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
}
