/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOS;

/**
 *
 * @author hp
 */
public class DTOCourse {
    private int course_id;
    private String course_name;
    private int credit_hours;
    private int capacity;
    private int dep_id;

    public DTOCourse(int course_id, String course_name, int credit_hours, int capacity, int dep_id) {
        this.course_id = course_id;
        this.course_name = course_name;
        this.credit_hours = credit_hours;
        this.capacity = capacity;
        this.dep_id = dep_id;
    }

    public DTOCourse(int course_id, String course_name, int credit_hours, int dep_id) {
        this.course_id = course_id;
        this.course_name = course_name;
        this.credit_hours = credit_hours;
        this.dep_id = dep_id;
    }



    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public int getCredit_hours() {
        return credit_hours;
    }

    public void setCredit_hours(int credit_hours) {
        this.credit_hours = credit_hours;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getDep_id() {
        return dep_id;
    }

    public void setDep_id(int dep_id) {
        this.dep_id = dep_id;
    }
    
    
    
}
