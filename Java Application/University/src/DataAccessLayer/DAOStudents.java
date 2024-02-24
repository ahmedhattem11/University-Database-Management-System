/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

import DTOS.DTOStudent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;

/**
 *
 * @author hp
 */
public class DAOStudents {
   
    public ArrayList<Integer> getStd_IDs() throws SQLException {
        ArrayList<Integer> getStd_IDs = new ArrayList<>();
        try (PreparedStatement statement = DAO.getConnection().prepareCall("Select std_id from student")) {
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                getStd_IDs.add(res.getInt(1));
            }
        }
        return getStd_IDs;
    }
    
    public ArrayList<Integer> getDepartmentIDs() throws SQLException {
        ArrayList<Integer> getDep_ID = new ArrayList<>();
        try (PreparedStatement statement = DAO.getConnection().prepareCall("Select dep_id from department")) {
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                getDep_ID.add(res.getInt(1));
            }
        }
        return getDep_ID;
    }
    
    public ObservableList<DTOStudent> getStudents() throws SQLException {
    ObservableList<DTOStudent> students = FXCollections.observableArrayList();
    try (PreparedStatement statement = DAO.getConnection().prepareStatement("Select * from student order by std_id")) {
        ResultSet res = statement.executeQuery();
        while (res.next()) {
            int std_id = res.getInt(1);
            String std_name = res.getString(2);
            int dep_id = res.getInt(3);
            double cgpa = res.getDouble(4);
            String city = res.getString(5);
            Date dob = res.getDate(8);
            //LocalDate dob = (dobSQL != null) ? dobSQL.toLocalDate() : null; // Check for null
            String email = res.getString(6);
            String gender = res.getString(7);

            students.add(new DTOStudent(std_id, std_name, dep_id, cgpa, city, email, gender, dob));
        }
    }
    return students;
    }

    
    public int addStudent(DTOStudent student) throws SQLException {
        int result;
        Connection connection = DAO.getConnection();
        
        // Log the connection to check for null
        System.out.println("Connection: " + connection);
        
        try (PreparedStatement statement = DAO.getConnection().prepareStatement("INSERT INTO student(STD_ID, STD_NAME, DEP_ID, EMAIL, gender, DOB) Values (?,?,?,?,?,?)")) {
            statement.setInt(1, student.getStd_id());
            statement.setString(2, student.getStd_name());
            statement.setInt(3, student.getDep_id());
            statement.setString(4, student.getEmail());
            statement.setString(5, student.getGender());
            statement.setDate(6, student.getDob());
            result = statement.executeUpdate();
        }
        return result;
    }
    
    public int deleteStudent(DTOStudent delete) {
        int result = 0;
        try {
            try (PreparedStatement statement = DAO.getConnection().prepareCall("Delete from student where std_id = ?")) {
                statement.setInt(1, delete.getStd_id());
                result = statement.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOStudents.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
