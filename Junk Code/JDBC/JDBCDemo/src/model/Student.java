/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author user
 */
public class Student {
    private Integer id;
    private String name;
    private String address;
    private Integer rn;
    private Integer clas;

    public Student() {
    }

    public Student(Integer id, String name, String address, Integer rn, Integer clas) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.rn = rn;
        this.clas = clas;
    }

    public Integer getClas() {
        return clas;
    }

    public void setClas(Integer clas) {
        this.clas = clas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getRn() {
        return rn;
    }

    public void setRn(Integer rn) {
        this.rn = rn;
    }
    
}
