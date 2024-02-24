package university.reports;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public abstract class reportsBase extends AnchorPane {

    protected final ImageView imageView;
    protected final Label label;
    protected final TableView tableReports;
    protected final TableColumn courseIDColumn;
    protected final TableColumn courseNameColumn;
    protected final TableColumn enrolledStdColumn;
    protected final TableColumn averageGPAColumn;
    protected final Button btnGenerateReport;

    public reportsBase() {

        imageView = new ImageView();
        label = new Label();
        tableReports = new TableView();
        courseIDColumn = new TableColumn();
        courseNameColumn = new TableColumn();
        enrolledStdColumn = new TableColumn();
        averageGPAColumn = new TableColumn();
        btnGenerateReport = new Button();

        setId("AnchorPane");
        setPrefHeight(864.0);
        setPrefWidth(996.0);

        imageView.setFitHeight(864.0);
        imageView.setFitWidth(1000.0);
        imageView.setPickOnBounds(true);
        imageView.setImage(new Image(getClass().getResource("../home/resources/university-background-04.jpg").toExternalForm()));

        label.setAlignment(javafx.geometry.Pos.CENTER);
        label.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        label.setLayoutX(245.0);
        label.setLayoutY(31.0);
        label.getStylesheets().add("/university/reports/../home/resources/ButtonStyle.css");
        label.setText("Summary Report");
        label.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label.setTextFill(javafx.scene.paint.Color.WHITE);
        label.setFont(new Font("System Bold", 64.0));

        tableReports.setLayoutY(128.0);
        tableReports.setPrefHeight(614.0);
        tableReports.setPrefWidth(1000.0);
        tableReports.getStyleClass().add("transparent-button");
        tableReports.getStylesheets().add("/university/reports/../home/resources/ButtonStyle.css");

        courseIDColumn.setPrefWidth(172.0);
        courseIDColumn.setText("Course ID");

        courseNameColumn.setPrefWidth(309.0);
        courseNameColumn.setText("Course Name");

        enrolledStdColumn.setMinWidth(2.0);
        enrolledStdColumn.setPrefWidth(285.0);
        enrolledStdColumn.setText("Enrolled Students");

        averageGPAColumn.setMinWidth(2.0);
        averageGPAColumn.setPrefWidth(205.0);
        averageGPAColumn.setText("Average GPA");

        btnGenerateReport.setLayoutX(392.0);
        btnGenerateReport.setLayoutY(783.0);
        btnGenerateReport.setMnemonicParsing(false);
        btnGenerateReport.setOnAction(this::generateReport);
        btnGenerateReport.setStyle("-fx-background-color: transparent;");
        btnGenerateReport.getStyleClass().add("transparent-button");
        btnGenerateReport.setText("Generate Report");
        btnGenerateReport.setTextFill(javafx.scene.paint.Color.WHITE);
        btnGenerateReport.setFont(new Font("System Bold", 24.0));

        getChildren().add(imageView);
        getChildren().add(label);
        tableReports.getColumns().add(courseIDColumn);
        tableReports.getColumns().add(courseNameColumn);
        tableReports.getColumns().add(enrolledStdColumn);
        tableReports.getColumns().add(averageGPAColumn);
        getChildren().add(tableReports);
        getChildren().add(btnGenerateReport);

    }

    protected abstract void generateReport(javafx.event.ActionEvent actionEvent);

}
