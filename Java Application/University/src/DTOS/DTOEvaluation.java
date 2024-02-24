/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOS;

import java.sql.Date;

/**
 *
 * @author hp
 */
public class DTOEvaluation {
    private int std_id;
    private int course_id;
    private int semester;
    private String std_name;
    private String course_name;
    private String grade_id;
    private int credit_hours;
    private Date evaluation_date;

    public DTOEvaluation(int std_id, int course_id, int semester, String std_name, String course_name, String grade_id, int credit_hours, Date evaluation_date) {
        this.std_id = std_id;
        this.course_id = course_id;
        this.semester = semester;
        this.std_name = std_name;
        this.course_name = course_name;
        this.grade_id = grade_id;
        this.credit_hours = credit_hours;
        this.evaluation_date = evaluation_date;
    }

    public DTOEvaluation(int std_id, int course_id, int semester, String grade_id) {
        this.std_id = std_id;
        this.course_id = course_id;
        this.semester = semester;
        this.grade_id = grade_id;
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

    public String getGrade_id() {
        return grade_id;
    }

    public void setGrade_id(String grade_id) {
        this.grade_id = grade_id;
    }

    public int getCredit_hours() {
        return credit_hours;
    }

    public void setCredit_hours(int credit_hours) {
        this.credit_hours = credit_hours;
    }

    public Date getEvaluation_date() {
        return evaluation_date;
    }

    public void setEvaluation_date(Date evaluation_date) {
        this.evaluation_date = evaluation_date;
    }
    
    
    
     
}
