/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.students;

import DTOS.DTOEvaluation;
import DTOS.DTOStudent;
import DataAccessLayer.DAOStudents;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class StudentsController implements Initializable {

    @FXML
    private AnchorPane studentPane;
    @FXML
    private TextField DepIDTextField;
    @FXML
    private TextField StdIDTextField;
    @FXML
    private TextField StdNameTextField;
    @FXML
    private TextField EmailTextField;
    @FXML
    private Label dataAlert;
    @FXML
    private Button btnAddStd;
    @FXML
    private Button btnRemoveStd;
    @FXML
    private Button btnDisplayStd;
    @FXML
    private DatePicker DOBTextField;
    @FXML
    private RadioButton MaleRadioBtn;
    @FXML
    private RadioButton FemaleRadioBtn;
    @FXML
    private TableView<DTOStudent> StdTableView;
    @FXML
    private TableColumn<DTOStudent, Integer> StdIDCoulmn;
    @FXML
    private TableColumn<DTOStudent, String> StdNameColumn;
    @FXML
    private TableColumn<DTOStudent, Integer> DepIDColumn;
    @FXML
    private TableColumn<DTOStudent, Double> CgpaColumn;
    @FXML
    private TableColumn<DTOStudent, String> CityColumn;
    @FXML
    private TableColumn<DTOStudent, String> EmailColumn;
    @FXML
    private TableColumn<DTOStudent, Character> GenderColumn;
    @FXML
    private TableColumn<DTOStudent, LocalDate> DOBColumn;
    @FXML
    private Button btnClear;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<DTOStudent> students = FXCollections.observableArrayList();

        try {
            students = daoStudent.getStudents();
        } catch (SQLException ex) {
            Logger.getLogger(StudentsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        StdIDCoulmn.setCellValueFactory(new PropertyValueFactory<>("std_id"));
        StdNameColumn.setCellValueFactory(new PropertyValueFactory<>("std_name"));
        DepIDColumn.setCellValueFactory(new PropertyValueFactory<>("dep_id"));
        CgpaColumn.setCellValueFactory(new PropertyValueFactory<>("cgpa"));
        CityColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
        DOBColumn.setCellValueFactory(new PropertyValueFactory<>("dob"));
        EmailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        GenderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
        StdTableView.setItems((ObservableList<DTOStudent>) students);               
    }    
    
    DTOStudent selectedStudent;
    DAOStudents daoStudent = new DAOStudents();
    
    @FXML
    private void addStudents(ActionEvent event) throws SQLException {
        try {
            // Retrieve values from UI components
            String stdIdText = StdIDTextField.getText();
            String stdName = StdNameTextField.getText();
            String depIdText = DepIDTextField.getText();
            String email = EmailTextField.getText();
            LocalDate dob = DOBTextField.getValue();

            // Check if all fields are empty
            if (stdIdText.isEmpty() && stdName.isEmpty() && depIdText.isEmpty() &&
                email.isEmpty() && dob == null && !MaleRadioBtn.isSelected() &&
                !FemaleRadioBtn.isSelected()) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Empty Fields");
                alert.setHeaderText(null);
                alert.setContentText("Please fill out at least one field.");
                alert.showAndWait();
                return;
            }

            // Validate email format
            if (!email.contains("@")) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Invalid Email");
                alert.setHeaderText(null);
                alert.setContentText("Please enter a valid email address.");
                alert.showAndWait();
                return;
            }

            // Validate and convert student ID to int
            int studentId;
            try {
                if (stdIdText.isEmpty()) {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Please enter a student ID");
                    alert.setHeaderText(null);
                    return;
                }
                studentId = Integer.parseInt(stdIdText);
            } catch (NumberFormatException e) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Please enter a valid student ID");
                alert.setHeaderText(null);
                return;
            }

            // Validate and convert department ID to int
            int departmentId;
            try {
                if (depIdText.isEmpty()) {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Department ID can not be empty");
                    alert.setHeaderText(null);
                    return;
                }
                departmentId = Integer.parseInt(depIdText);

                // Check if department ID exists in the system (you need to implement this logic)
                if (!isDepartmentValid(departmentId)) {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Invalid Department ID");
                    alert.setHeaderText(null);
                    alert.setContentText("The department ID provided does not exist.");
                    alert.showAndWait();
                    return;
                }
            } catch (NumberFormatException e) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Please enter a valid department ID");
                alert.setHeaderText(null);
                return;
            }

            // Check if the gender radio buttons are selected
            String gender;
            if (MaleRadioBtn.isSelected()) {
                gender = "M";
            } else if (FemaleRadioBtn.isSelected()) {
                gender = "F";
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Please select a gender");
                alert.setHeaderText(null);
                return;
            }

            // Create DTOStudent object
            DTOStudent student = new DTOStudent(studentId, stdName, departmentId, email, gender, Date.valueOf(dob));

            // Perform the action with the DTOStudent object (e.g., adding to the database)

            int result = daoStudent.addStudent(student);

            // Check the result and update UI accordingly
            if (result > 0) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Welcome");
                alert.setHeaderText(null);
                alert.setContentText("Student added successfully!");

                alert.showAndWait();
                clearTextFields();
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error adding user");
                alert.setHeaderText(null);
            }
        } catch (SQLException ex) {
            if (ex instanceof SQLIntegrityConstraintViolationException) {
                // Student with the same std_id already exists
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("A student with the same ID already exists.");
                alert.showAndWait();
            } else {
                Logger.getLogger(StudentsController.class.getName()).log(Level.SEVERE, null, ex);
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("An error occurred while adding the student.");
                alert.showAndWait();
            }
        }

        ObservableList<DTOStudent> students = FXCollections.observableArrayList();

        students = daoStudent.getStudents();
        // Refresh the TableView with updated evaluations
        //students.addAll(daoStudent.getStudents);
        StdTableView.setItems(students);     
    }


    private boolean isDepartmentValid(int departmentId) {
        try {
            // Query your database to check if the provided department ID exists
            // You should replace the logic here with your actual database query
            // Assume you have a DAO method to retrieve department IDs from the database
             ArrayList<Integer> validDepartmentIds = daoStudent.getDepartmentIDs();

            // Check if the provided department ID exists in the list of valid department IDs
            return validDepartmentIds.contains(departmentId);
        } catch (SQLException ex) {
            Logger.getLogger(StudentsController.class.getName()).log(Level.SEVERE, null, ex);
            return false; // Return false in case of an error or if department IDs cannot be retrieved
        }
    }

    @FXML
    private void deleteStudents(ActionEvent event) {
        // Get the selected student from the table view
        DTOStudent selectedStudent = StdTableView.getSelectionModel().getSelectedItem();

        if (selectedStudent == null) {
            // If no student is selected, show an alert
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Student Selected");
            alert.setHeaderText(null);
            alert.setContentText("Please select a student to delete.");
            alert.showAndWait();
            return;
        }

        // Attempt to delete the selected student from the database
        int result = daoStudent.deleteStudent(selectedStudent);
        if (result > 0) {
            // If deletion was successful, remove the student from the table view
            StdTableView.getItems().remove(selectedStudent);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Student Deleted");
            alert.setHeaderText(null);
            alert.setContentText("Student deleted successfully.");
            alert.showAndWait();
            } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Deleting Student");
            alert.setHeaderText(null);
            alert.setContentText("An error occurred while deleting the student.");
            alert.showAndWait();
        }
    }

    @FXML
    public void clearFields(ActionEvent event) {
        StdIDTextField.clear();
        DepIDTextField.clear();
        StdNameTextField.clear();
        EmailTextField.clear();
        DOBTextField.setValue(null); // Set DatePicker to null to clear its value
        MaleRadioBtn.setSelected(false);
        FemaleRadioBtn.setSelected(false);
    }
    public void clearTextFields() {
        StdIDTextField.clear();
        DepIDTextField.clear();
        StdNameTextField.clear();
        EmailTextField.clear();
        DOBTextField.setValue(null); // Set DatePicker to null to clear its value
        MaleRadioBtn.setSelected(false);
        FemaleRadioBtn.setSelected(false);
    }
}
