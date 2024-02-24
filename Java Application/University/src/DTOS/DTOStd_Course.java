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
public class DTOStd_Course {
    private int std_id;
    private int course_id;
    private int semester;
    private String std_name;
    private String course_name;

    public DTOStd_Course(int std_id, int course_id, int semester, String std_name, String course_name) {
        this.std_id = std_id;
        this.course_id = course_id;
        this.semester = semester;
        this.std_name = std_name;
        this.course_name = course_name;
    }

    public DTOStd_Course(int std_id, int course_id, int semester, String course_name) {
        this.std_id = std_id;
        this.course_id = course_id;
        this.semester = semester;
        this.course_name = course_name;
    }
    

    public int getStd_id() {
        return std_id;
    }

    public void setStd_id(int std_id) {
        this.std_id = std_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getStd_name() {
        return std_name;
    }

    public void setStd_name(String std_name) {
        this.std_name = std_name;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }
    
    
    
}
