/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.courses;

import DTOS.DTOCourse;
import DTOS.DTODepartment;
import DTOS.DTOEvaluation;
import DTOS.DTOStudent;
import DataAccessLayer.DAOCourses;
import DataAccessLayer.DAODepartment;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import university.students.StudentsController;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class CoursesController implements Initializable {

    @FXML
    private AnchorPane departmentPane;
    @FXML
    private TextField textDeptID;
    @FXML
    private TextField textDeptName;
    @FXML
    private TextField textDeptidFK;
    @FXML
    private Button btnAddDepartment;
    @FXML
    private Button btnDeleteDepartment;
    @FXML
    private Button btnAddCourse;
    @FXML
    private TableView<DTOCourse> tableCourse;
    @FXML
    private TableColumn<DTOCourse, Integer> courseIDColumn;
    @FXML
    private TableColumn<DTOCourse, String> courseNameColumn;
    @FXML
    private TableColumn<DTOCourse, Integer> creditHoursColumn;
    //@FXML
    //private TableColumn<DTOCourse, Integer> capacityColumn;
    @FXML
    private TableColumn<DTOCourse, Integer> depIDColumnFK;
    @FXML
    private TableView<DTODepartment> tableDepartment;
    @FXML
    private TableColumn<DTODepartment, Integer> depIDColumn;
    @FXML
    private TableColumn<DTODepartment, String> depNameColumn;
    @FXML
    private TextField textCourseID;
    @FXML
    private TextField textCourseName;
    @FXML
    private Button btnDeleteCourse;
    @FXML
    private Label textCreditHours;
    @FXML
    private TextField textCredit_Hours;
    @FXML
    private Button clearDepBtn;
    @FXML
    private Button clearCourseBtn;

    /**
     * Initializes the controller class.
     */
    
    DAOCourses dAOCourses = new DAOCourses();
    DAODepartment dAODepartment = new DAODepartment();
    
    DTOCourse selectedCourse;
    DTODepartment selectedDepartment;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ObservableList<DTOCourse> courses = FXCollections.observableArrayList();
        ObservableList<DTODepartment> departments = FXCollections.observableArrayList();
        try {
            courses = dAOCourses.getCourses();
            departments = dAODepartment.getDepartments();
        } catch (SQLException ex) {
            Logger.getLogger(StudentsController.class.getName()).log(Level.SEVERE, null, ex);
        }
         //View course data in table view
        courseIDColumn.setCellValueFactory(new PropertyValueFactory<>("course_id"));
        courseNameColumn.setCellValueFactory(new PropertyValueFactory<>("course_name"));
        creditHoursColumn.setCellValueFactory(new PropertyValueFactory<>("credit_hours"));
        depIDColumnFK.setCellValueFactory(new PropertyValueFactory<>("dep_id"));
        tableCourse.setItems((ObservableList<DTOCourse>) courses);
        
        //View department data in table view
        depIDColumn.setCellValueFactory(new PropertyValueFactory<>("dep_id"));
        depNameColumn.setCellValueFactory(new PropertyValueFactory<>("dep_name"));
        tableDepartment.setItems((ObservableList<DTODepartment>) departments);
    }    

    @FXML
    private void addDept(ActionEvent event) throws SQLException {
        String depIDText = textDeptID.getText();
        String depNameText = textDeptName.getText();

        int depID = Integer.parseInt(depIDText);

        try {
            if (depIDText.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION); // You can choose different types: ERROR, INFORMATION, WARNING, CONFIRMATION
                alert.setTitle("Department ID can not be empty");
                alert.setHeaderText(null);
                return;
            }

        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR); // You can choose different types: ERROR, INFORMATION, WARNING, CONFIRMATION
            alert.setTitle("Please enter a valid department ID");
            alert.setHeaderText(null);
            return;
        }

        // Validate and convert department ID to int
        try {
            if (depNameText.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION); // You can choose different types: ERROR, INFORMATION, WARNING, CONFIRMATION
                alert.setTitle("Please enter a department name");
                alert.setHeaderText(null);
                return;
            }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR); // You can choose different types: ERROR, INFORMATION, WARNING, CONFIRMATION
            alert.setTitle("Please enter a valid department name");
            alert.setHeaderText(null);
            return;
        }
        
        // Check if the department with the same dep_id already exists
        if (isDepartmentExists(depID)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("A department with the same ID already exists.");
            alert.showAndWait();
            return;
        }

        // Create DTOCourse object
        DTODepartment department = new DTODepartment(depID, depNameText);

        int result = dAODepartment.addDepartment(department);

        // Check the result and update UI accordingly
        if (result > 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION); // You can choose different types: ERROR, INFORMATION, WARNING, CONFIRMATION
            alert.setTitle("Success");
            alert.setHeaderText(null); // You can set a header if needed
            alert.setContentText("Department added successfully!");

            alert.showAndWait();
            ObservableList<DTODepartment> departments = FXCollections.observableArrayList();
            departments.addAll(dAODepartment.getDepartments());
            tableDepartment.setItems(departments);
            //clearTextFields(); // Implement this method to clear text fields
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR); // You can choose different types: ERROR, INFORMATION, WARNING, CONFIRMATION
            alert.setTitle("Error adding department");
            alert.setHeaderText(null); // You can set a header if needed  
        }
    }

    @FXML
    private void deleteDept(ActionEvent event) {
    // Get the selected department from the table view
    DTODepartment selectedDepartment = tableDepartment.getSelectionModel().getSelectedItem();

    if (selectedDepartment == null) {
        // If no department is selected, show an alert
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("No Department Selected");
        alert.setHeaderText(null);
        alert.setContentText("Please select a department to delete.");
        alert.showAndWait();
        return;
    }

    try {
        // Check if the department has associated students
        boolean hasAssociatedStudents = dAODepartment.hasAssociatedStudents(selectedDepartment);

        if (hasAssociatedStudents) {
            // If the department has associated students, show an alert and return
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Cannot Delete Department");
            alert.setHeaderText(null);
            alert.setContentText("Cannot delete the department because it has associated students.");
            alert.showAndWait();
            return;
        }
    } catch (SQLException ex) {
        Logger.getLogger(CoursesController.class.getName()).log(Level.SEVERE, null, ex);
        // Show an error message if there's an exception
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("An error occurred while checking associated students.");
        alert.showAndWait();
        return;
    }

    // Attempt to delete the selected department from the database
    int result = dAODepartment.deleteDepartment(selectedDepartment);
    if (result > 0) {
        // If deletion was successful, remove the department from the table view
        tableDepartment.getItems().remove(selectedDepartment);
        tableCourse.getItems().remove(selectedCourse);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Department Deleted");
        alert.setHeaderText(null);
        alert.setContentText("Department deleted successfully.");
        alert.showAndWait();
    } else {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Deleting Department");
        alert.setHeaderText(null);
        alert.setContentText("An error occurred while deleting the department.");
        alert.showAndWait();
    }
}


    @FXML
    private void addCourse(ActionEvent event) throws SQLException {
        String courseIDText = textCourseID.getText();
        String courseName = textCourseName.getText();
        String credithoursText = textCredit_Hours.getText();
        String dep_IDText = textDeptidFK.getText();

        int courseID = Integer.parseInt(courseIDText);
        int credithours = Integer.parseInt(credithoursText);
        int depID = Integer.parseInt(dep_IDText);

        try {
            if (courseIDText.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION); // You can choose different types: ERROR, INFORMATION, WARNING, CONFIRMATION
                alert.setTitle("Please enter a course ID");
                alert.setHeaderText(null);
                return;
            }

        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR); // You can choose different types: ERROR, INFORMATION, WARNING, CONFIRMATION
            alert.setTitle("Please enter a valid course ID");
            alert.setHeaderText(null);
            return;
        }

        // Validate and convert department ID to int
        try {
            if (dep_IDText.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION); // You can choose different types: ERROR, INFORMATION, WARNING, CONFIRMATION
                alert.setTitle("Department ID can not be empty");
                alert.setHeaderText(null);
                return;
            }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR); // You can choose different types: ERROR, INFORMATION, WARNING, CONFIRMATION
            alert.setTitle("Please enter a valid department ID");
            alert.setHeaderText(null);
            return;
        }
        
        // Check if the department exists
        if (!isDepartmentExists(depID)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("The specified department does not exist.");
            alert.showAndWait();
            return;
        }
        // Check if the course exists
        if (isCourseExists(courseID)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("This course ID already exists.");
            alert.showAndWait();
            return;
        }

        // Create DTOCourse object
        DTOCourse course = new DTOCourse(courseID, courseName, credithours, depID);

        int result = dAOCourses.addCourse(course);

        // Check the result and update UI accordingly
        if (result > 0) {
            tableCourse.getItems().add(selectedCourse);
            Alert alert = new Alert(Alert.AlertType.INFORMATION); // You can choose different types: ERROR, INFORMATION, WARNING, CONFIRMATION
            alert.setTitle("Success");
            alert.setHeaderText(null); // You can set a header if needed
            alert.setContentText("Course added successfully!");

            alert.showAndWait();
            ObservableList<DTOCourse> courses = FXCollections.observableArrayList();
            courses.addAll(dAOCourses.getCourses());
            tableCourse.setItems(courses);

            //clearTextFields(); // Implement this method to clear text fields
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR); // You can choose different types: ERROR, INFORMATION, WARNING, CONFIRMATION
            alert.setTitle("Error adding course");
            alert.setHeaderText(null); // You can set a header if needed  
        }
    }

    @FXML
    private void deleteCourse(ActionEvent event) {
        DTOCourse selectedCourse = tableCourse.getSelectionModel().getSelectedItem();

        if (selectedCourse == null) {
            // If no student is selected, show an alert
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Course Selected");
            alert.setHeaderText(null);
            alert.setContentText("Please select a course to delete.");
            alert.showAndWait();
            return;
        }
        
        try {
        // Check if the department has associated students
        boolean hasStudents = dAOCourses.hasStudents(selectedCourse);

        if (hasStudents) {
            // If the department has associated students, show an alert and return
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Cannot Delete Course");
            alert.setHeaderText(null);
            alert.setContentText("Cannot delete the course because it has associated students.");
            alert.showAndWait();
            return;
        }
    } catch (SQLException ex) {
        Logger.getLogger(CoursesController.class.getName()).log(Level.SEVERE, null, ex);
        // Show an error message if there's an exception
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("An error occurred while checking associated students.");
        alert.showAndWait();
        return;
    }

        // Attempt to delete the selected student from the database
        int result = dAOCourses.deleteCourse(selectedCourse);
        if (result > 0) {
            // If deletion was successful, remove the student from the table view
            tableCourse.getItems().remove(selectedCourse);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Course Deleted");
            alert.setHeaderText(null);
            alert.setContentText("Course deleted successfully.");
            alert.showAndWait();
            } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Deleting Course");
            alert.setHeaderText(null);
            alert.setContentText("An error occurred while deleting the course.");
            alert.showAndWait();
        }
    }
    
    private boolean isDepartmentExists(int depID) {
        try {
            // Get the list of department IDs
            ArrayList<Integer> departmentIDs = dAODepartment.getDep_id();
            // Check if the specified department ID exists in the list
            return departmentIDs.contains(depID);
        } catch (SQLException ex) {
            Logger.getLogger(CoursesController.class.getName()).log(Level.SEVERE, null, ex);
            // Return false in case of an exception
            return false;
        }
    }
    
    private boolean isCourseExists(int course_id) {
        try {
            // Get the list of department IDs
            ArrayList<Integer> courseIDs = dAOCourses.getCourse_id();
            // Check if the specified department ID exists in the list
            return courseIDs.contains(course_id);
        } catch (SQLException ex) {
            Logger.getLogger(CoursesController.class.getName()).log(Level.SEVERE, null, ex);
            // Return false in case of an exception
            return false;
        }
    }

    @FXML
    public void clearCOURSETextFields(ActionEvent event) {
        textCourseID.clear();
        textCourseName.clear();
        textCredit_Hours.clear();
        textDeptidFK.clear();
    }

    @FXML
     public void clearDEPTextFields(ActionEvent event) {
        textDeptID.clear();
        textDeptName.clear();
    }    
}
    
