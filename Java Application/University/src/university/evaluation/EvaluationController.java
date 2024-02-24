
package university.evaluation;

import DTOS.DTOEvaluation;
import DTOS.DTOStd_Course;
import DataAccessLayer.DAOEvaluation;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
/**
 * FXML Controller class
 *
 * @author hp
 */
public class EvaluationController implements Initializable {

    @FXML
    private AnchorPane studentPane;
    @FXML
    private TextField textCourseID_ENR;
    @FXML
    private TextField textStdID_EVA;
    @FXML
    private TextField textSemester_EVA;
    @FXML
    private TextField textGrade_EVA;
    @FXML
    private Button btnUpdateGrade;
    @FXML
    private TableView<DTOEvaluation> evaluationTable;
    @FXML
    private TableColumn<DTOEvaluation, Integer> stdIDColumn;
    @FXML
    private TableColumn<DTOEvaluation, String> stdNameColumn;
    @FXML
    private TableColumn<DTOEvaluation, Integer> courseIDColumn;
    @FXML
    private TableColumn<DTOEvaluation, String> courseNameColumn;
    @FXML
    private TableColumn<DTOEvaluation, String> gradeColumn;
    @FXML
    private TableColumn<DTOEvaluation, Integer> creditHoursColumn;
    @FXML
    private TableColumn<DTOEvaluation, Integer> semesterColumn;
    @FXML
    private TableColumn<DTOEvaluation, Date> evaluationDateColumn;
    @FXML
    private TextField textStdID_ENR;
    @FXML
    private TextField textCourseID_EVA;
    @FXML
    private TextField textDSemester_ENR;
    @FXML
    private TextField textCourseName_ENR;
    @FXML
    private Button btnEnroll;
    @FXML
    private Button clearEnroll;
    @FXML
    private Button clearEvaluation;

    /**
     * Initializes the controller class.
     */
    DAOEvaluation dAOEvaluation = new DAOEvaluation();
    
    DTOEvaluation selectedEvaluation;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<DTOEvaluation> evaluations = FXCollections.observableArrayList();

        evaluations = dAOEvaluation.getEvaluations();
         //View course data in table view
        stdIDColumn.setCellValueFactory(new PropertyValueFactory<>("std_id"));
        stdNameColumn.setCellValueFactory(new PropertyValueFactory<>("std_name"));
        courseIDColumn.setCellValueFactory(new PropertyValueFactory<>("course_id"));
        courseNameColumn.setCellValueFactory(new PropertyValueFactory<>("course_name"));
        gradeColumn.setCellValueFactory(new PropertyValueFactory<>("grade_id"));
        creditHoursColumn.setCellValueFactory(new PropertyValueFactory<>("credit_hours"));
        semesterColumn.setCellValueFactory(new PropertyValueFactory<>("semester"));
        evaluationDateColumn.setCellValueFactory(new PropertyValueFactory<>("evaluation_date"));
        evaluationTable.setItems((ObservableList<DTOEvaluation>) evaluations);
    }    

    @FXML
    private void updateGrade(ActionEvent event) throws SQLException {
        try {
            int stdID = Integer.parseInt(textStdID_EVA.getText());
            int courseID = Integer.parseInt(textCourseID_EVA.getText());
            int semester = Integer.parseInt(textSemester_EVA.getText());
            String grade_id = textGrade_EVA.getText();

            // Validate the grade_id
            if (!isValidGrade(grade_id)) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Invalid Grade");
                alert.setContentText("Please enter a valid grade from the predefined list.");
                alert.showAndWait();
                return; // Exit the method if the grade is invalid
            }

            DTOEvaluation evaluateStudent = new DTOEvaluation(stdID, courseID, semester, grade_id);

            int result = dAOEvaluation.updateGrade(evaluateStudent);

            if (result > 0) {
                // Grade update successful, show success alert
                Alert successAlert = new Alert(AlertType.INFORMATION);
                successAlert.setTitle("Success");
                successAlert.setHeaderText("Grade Update Successful");
                successAlert.setContentText("Grade updated successfully!");
                successAlert.showAndWait();
            } else {
                // Grade update failed, show error alert
                Alert errorAlert = new Alert(AlertType.ERROR);
                errorAlert.setTitle("Error");
                errorAlert.setHeaderText("Grade Update Failed");
                errorAlert.setContentText("Failed to update grade!");
                errorAlert.showAndWait();
            }

            // Refresh the TableView with updated evaluations
            ObservableList<DTOEvaluation> evaluations = FXCollections.observableArrayList();
            evaluations.addAll(dAOEvaluation.getEvaluations());
            evaluationTable.setItems(evaluations);
        }catch (NumberFormatException e) {
            // Handle if any of the text fields contain non-numeric input
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid Input");
            alert.setContentText("Please enter valid numeric values for student ID, course ID, and semester!");
            alert.showAndWait();
        }
        // Handle SQLException, such as showing an error message
        
    }

    @FXML
    private void enrollStd(ActionEvent event) {
        try {
            int stdID = Integer.parseInt(textStdID_ENR.getText());
            int courseID = Integer.parseInt(textCourseID_ENR.getText());
            int semester = Integer.parseInt(textDSemester_ENR.getText());
            String courseName = textCourseName_ENR.getText();

            DTOStd_Course enrollCourse = new DTOStd_Course(stdID, courseID, semester, courseName);
            
        // Check if the course belongs to the student's department
        if (!isCourseInDepartment(enrollCourse)) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Course Not in Department");
            alert.setContentText("The course you are trying to enroll in does not belong to your department.");
            alert.showAndWait();
            return;
        }

            int result = dAOEvaluation.enrollStudent(enrollCourse);

            Alert alert;
            if(result > 0) {
                // Enrollment successful, show success alert
                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Enrollment Successful");
                alert.setContentText("Student enrolled successfully!");
            } else {
                // Enrollment failed, show error alert
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Enrollment Failed");
                alert.setContentText("Failed to enroll student!");
            }
            alert.showAndWait();
            
            // Refresh the TableView with updated evaluations
            ObservableList<DTOEvaluation> evaluations = FXCollections.observableArrayList();
            evaluations.addAll(dAOEvaluation.getEvaluations());
            evaluationTable.setItems(evaluations);
            
        }catch (NumberFormatException e) {
            // Handle if any of the text fields contain non-numeric input
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid Input");
            alert.setContentText("Please enter valid numeric values for student ID, course ID, and semester!");
            alert.showAndWait();
            
            
        }
        // Handle SQLException, such as showing an error message
        
        
    }
    private boolean isValidGrade(String grade_id) {
        // Define the valid grade values
        String[] validGrades = {"A", "A-", "B", "B+", "B-", "C", "C+", "C-", "D", "D+", "F"};

        // Check if the entered grade_id matches any of the valid grades
        for (String validGrade : validGrades) {
            if (grade_id.equals(validGrade)) {
                return true;
            }
    }

    return false;
    }
    
    private boolean isCourseInDepartment(DTOStd_Course course) {
        try {
            // Query the database to check if the specified course belongs to the student's department
            return dAOEvaluation.depCourses(course);
        } catch (SQLException ex) {
            Logger.getLogger(EvaluationController.class.getName()).log(Level.SEVERE, null, ex);
            return false; // Return false in case of an exception
        }
    }
    
    
    @FXML
    private void unenrollStd(ActionEvent event) {
         // Get the selected student from the table view
        DTOEvaluation selectedEvaluation = evaluationTable.getSelectionModel().getSelectedItem();

        if (selectedEvaluation == null) {
            // If no student is selected, show an alert
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Enrollment Selected");
            alert.setHeaderText(null);
            alert.setContentText("Please select an enrollment to delete.");
            alert.showAndWait();
            return;
        }

        // Attempt to delete the selected student from the database
        int result = dAOEvaluation.unenrollStudent(selectedEvaluation);
        if (result > 0) {
            // If deletion was successful, remove the student from the table view
            evaluationTable.getItems().remove(selectedEvaluation);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Student Unenrolled");
            alert.setHeaderText(null);
            alert.setContentText("Student unenrolled successfully.");
            alert.showAndWait();
            } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Unennrolling Student");
            alert.setHeaderText(null);
            alert.setContentText("An error occurred while unenrolling the student.");
            alert.showAndWait();
        }
    }
    
    @FXML
    public void clearEnrollTxT(ActionEvent event) {
        textStdID_ENR.clear();
        textCourseName_ENR.clear();
        textCourseID_ENR.clear();
        textDSemester_ENR.clear();
    }

    @FXML
    public void clearEvaluationTxT(ActionEvent event) {
        textCourseID_EVA.clear();
        textStdID_EVA.clear();
        textSemester_EVA.clear();
        textGrade_EVA.clear();
    }
}

    



