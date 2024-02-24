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
public class DTOGrade {
    private String grade_id;
    private int points;
    private String grade_status;

    public DTOGrade(String grade_id, int points, String grade_status) {
        this.grade_id = grade_id;
        this.points = points;
        this.grade_status = grade_status;
    }

    public String getGrade_id() {
        return grade_id;
    }

    public void setGrade_id(String grade_id) {
        this.grade_id = grade_id;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getGrade_status() {
        return grade_status;
    }

    public void setGrade_status(String grade_status) {
        this.grade_status = grade_status;
    }
    
    
    
}
