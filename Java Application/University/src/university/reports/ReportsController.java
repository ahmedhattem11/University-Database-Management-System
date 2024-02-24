/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.reports;

import DTOS.DTOEvaluation;
import DTOS.DTOReport;
import DataAccessLayer.DAOEvaluation;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class ReportsController implements Initializable {

    @FXML
    private TableView<DTOReport> tableReports;
    @FXML
    private TableColumn<DTOReport, Integer> courseIDColumn;
    @FXML
    private TableColumn<DTOReport, String> courseNameColumn;
    @FXML
    private TableColumn<DTOReport, Integer> enrolledStdColumn;
    @FXML
    private TableColumn<DTOReport, Double> averageGPAColumn;
    @FXML
    private Button btnGenerateReport;

    /**
     * Initializes the controller class.
     */
    
    DAOEvaluation dAOEvaluation = new DAOEvaluation();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void generateReport(ActionEvent event) {
        ObservableList<DTOReport> reportData = dAOEvaluation.generateReport();

        courseIDColumn.setCellValueFactory(new PropertyValueFactory<>("courseId"));
        courseNameColumn.setCellValueFactory(new PropertyValueFactory<>("courseName"));
        enrolledStdColumn.setCellValueFactory(new PropertyValueFactory<>("enrolledStudents"));
        averageGPAColumn.setCellValueFactory(new PropertyValueFactory<>("averageGPA"));

        tableReports.setItems(reportData);
    }

    
}
