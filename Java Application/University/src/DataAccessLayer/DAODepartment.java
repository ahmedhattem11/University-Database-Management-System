/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

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
public class DAODepartment {
    
    public ArrayList<Integer> getDep_id() throws SQLException {
        ArrayList<Integer> getDep_id = new ArrayList<>();
        try (PreparedStatement statement = DAO.getConnection().prepareCall("Select dep_id from department")) {
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                getDep_id.add(res.getInt(1));
            }
        }
        return getDep_id;
    }
    
    public ObservableList<DTODepartment> getDepartments() throws SQLException {
    ObservableList<DTODepartment> departments = FXCollections.observableArrayList();
    try (PreparedStatement statement = DAO.getConnection().prepareStatement("Select dep_id, dep_name from department order by dep_id")) {
        ResultSet res = statement.executeQuery();
        while (res.next()) {
            int dep_id = res.getInt(1);
            String dep_name = res.getString(2);

            departments.add(new DTODepartment(dep_id, dep_name));
        }
    }
    return departments;
    }

    
    public int addDepartment(DTODepartment department) throws SQLException {
        int result;
        Connection connection = DAO.getConnection();
        
        // Log the connection to check for null
        System.out.println("Connection: " + connection);
        
        try (PreparedStatement statement = DAO.getConnection().prepareStatement("INSERT INTO department(DEP_ID, DEP_NAME) Values (?,?)")) {
            statement.setInt(1, department.getDep_id());
            statement.setString(2, department.getDep_name());
            result = statement.executeUpdate();
        }
        return result;
    }
    
    public int deleteDepartment(DTODepartment delete) {
        int result = 0;
        try {
            try (PreparedStatement statement = DAO.getConnection().prepareCall("Delete from department where dep_id = ?")) {
                statement.setInt(1, delete.getDep_id());
                result = statement.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCourses.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public boolean hasAssociatedStudents(DTODepartment department) throws SQLException {
        // Query the database to check if there are any associated students with the department
        String query = "SELECT COUNT(*) FROM student WHERE dep_id = ?";
        try (PreparedStatement preparedStatement = DAO.getConnection().prepareStatement(query)) {
            preparedStatement.setInt(1, department.getDep_id());
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
