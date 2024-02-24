/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOS;

import java.time.LocalDate;
import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author hp
 */
public class DTOStudent {
    private int std_id;
    private String std_name;
    private int dep_id;
    private double cgpa;
    private String city;
    private String email;
    private String gender;
    private Date dob;

    public DTOStudent(int std_id, String std_name, int dep_id, double cgpa, String city, String email, String gender, Date dob) {
        this.std_id = std_id;
        this.std_name = std_name;
        this.dep_id = dep_id;
        this.cgpa = cgpa;
        this.city = city;
        this.email = email;
        this.gender = gender;
        this.dob = dob;
    }
    //Constructor that adds students to table initially
    public DTOStudent(int std_id, String std_name, int dep_id, String email, String gender, Date dob) {
        this.std_id = std_id;
        this.std_name = std_name;
        this.dep_id = dep_id;
        this.email = email;
        this.gender = gender;
        this.dob = dob;
    }

    public int getStd_id() {
        return std_id;
    }

    public void setStd_id(int std_id) {
        this.std_id = std_id;
    }

    public String getStd_name() {
        return std_name;
    }

    public void setStd_name(String std_name) {
        this.std_name = std_name;
    }

    public int getDep_id() {
        return dep_id;
    }

    public void setDep_id(int dep_id) {
        this.dep_id = dep_id;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return this.dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
    
    public String getFormattedDob() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(this.dob);
    }
}
