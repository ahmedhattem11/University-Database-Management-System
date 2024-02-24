/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.home;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class HomeController implements Initializable {

    @FXML
    private BorderPane parentAnchorPane;
    @FXML
    private Button btnStudent;
    @FXML
    private Button btnDepartment;
    @FXML
    private Button btnEvaluation;
    @FXML
    private Button btnReport;
    @FXML
    private Button btnCourse;
    @FXML
    private ImageView imgViewUniveristy;
    @FXML
    private AnchorPane replacePane;
    @FXML
    private ImageView imgWelcome;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    void viewStudents(ActionEvent event) throws IOException {
        System.out.println("Student button clicked");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/university/students/students.fxml"));
        Parent root= fxmlLoader.load();
        parentAnchorPane.setCenter(root);
        
    }

    @FXML
    void viewEvaluation(ActionEvent event) throws IOException {
        System.out.println("Evaluation button clicked");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/university/evaluation/evaluation.fxml"));
        Parent root= fxmlLoader.load();
        parentAnchorPane.setCenter(root);
    }

    @FXML
    void viewReport(ActionEvent event) throws IOException {
        System.out.println("Report button clicked");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/university/reports/reports.fxml"));
        Parent root= fxmlLoader.load();
        parentAnchorPane.setCenter(root);
    }

    @FXML
    void viewCourse(ActionEvent event) throws IOException {
        System.out.println("Course button clicked");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/university/courses/courses.fxml"));
        Parent root= fxmlLoader.load();
        parentAnchorPane.setCenter(root);
    }
    
}
