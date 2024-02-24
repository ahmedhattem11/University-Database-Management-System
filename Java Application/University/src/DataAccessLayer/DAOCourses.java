/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

import DTOS.DTOCourse;
import DTOS.DTODepartment;
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

/**
 *
 * @author hp
 */
public class DAOCourses {
    
    public ArrayList<Integer> getCourse_id() throws SQLException {
        ArrayList<Integer> getCourse_ids = new ArrayList<>();
        try (PreparedStatement statement = DAO.getConnection().prepareCall("Select course_id from course order by course_id")) {
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                getCourse_ids.add(res.getInt(1));
            }
        }
        return getCourse_ids;
    }
    
    public ObservableList<DTOCourse> getCourses() throws SQLException {
    ObservableList<DTOCourse> courses = FXCollections.observableArrayList();
    try (PreparedStatement statement = DAO.getConnection().prepareStatement("Select course_id, course_name, credit_hours, dep_id from course order by course_id")) {
        ResultSet res = statement.executeQuery();
        while (res.next()) {
            int course_id = res.getInt(1);
            String course_name = res.getString(2);
            int credit_hours = res.getInt(3);
            int dep_id = res.getInt(4);

            courses.add(new DTOCourse(course_id, course_name, credit_hours, dep_id));
        }
    }
    return courses;
    }

    
    public int addCourse(DTOCourse course) throws SQLException {
        int result;
        Connection connection = DAO.getConnection();
        
        // Log the connection to check for null
        System.out.println("Connection: " + connection);
        
        try (PreparedStatement statement = DAO.getConnection().prepareStatement("INSERT INTO course(COURSE_ID, COURSE_NAME, CREDIT_HOURS, CAPACITY, DEP_ID) Values (?,?,?,?,?)")) {
            statement.setInt(1, course.getCourse_id());
            statement.setString(2, course.getCourse_name());
            statement.setInt(3, course.getCredit_hours());
            statement.setInt(4, course.getCapacity());
            statement.setInt(5, course.getDep_id());
            result = statement.executeUpdate();
        }
        return result;
    }
    
    public int deleteCourse(DTOCourse delete) {
        int result = 0;
        try {
            try (PreparedStatement statement = DAO.getConnection().prepareCall("Delete from course where course_id = ?")) {
                statement.setInt(1, delete.getCourse_id());
                result = statement.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCourses.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
        public boolean hasStudents(DTOCourse course) throws SQLException {
        // Query the database to check if there are any associated students with the department
        String query = "SELECT COUNT(*) FROM std_course WHERE course_id = ?";
        try (PreparedStatement preparedStatement = DAO.getConnection().prepareStatement(query)) {
            preparedStatement.setInt(1, course.getCourse_id());
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0; // Return true if there are associated students, false otherwise
                }
            }
        }
        return false; // Return false if there's an error or no associated students found
    }
}
