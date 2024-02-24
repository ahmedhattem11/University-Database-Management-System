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
public class DTODepartment {
    private int dep_id;
    private String dep_name;
    private String dep_head;
    private String email;
    private int instructor_count;
    private int std_count;

    public DTODepartment(int dep_id, String dep_name, String dep_head, String email, int instructor_count, int std_count) {
        this.dep_id = dep_id;
        this.dep_name = dep_name;
        this.dep_head = dep_head;
        this.email = email;
        this.instructor_count = instructor_count;
        this.std_count = std_count;
    }

    public DTODepartment(int dep_id, String dep_name) {
        this.dep_id = dep_id;
        this.dep_name = dep_name;
    }

    public int getDep_id() {
        return dep_id;
    }

    public void setDep_id(int dep_id) {
        this.dep_id = dep_id;
    }

    public String getDep_name() {
        return dep_name;
    }

    public void setDep_name(String dep_name) {
        this.dep_name = dep_name;
    }

    public String getDep_head() {
        return dep_head;
    }

    public void setDep_head(String dep_head) {
        this.dep_head = dep_head;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getInstructor_count() {
        return instructor_count;
    }

    public void setInstructor_count(int instructor_count) {
        this.instructor_count = instructor_count;
    }

    public int getStd_count() {
        return std_count;
    }

    public void setStd_count(int std_count) {
        this.std_count = std_count;
    }
    
    
    
}
