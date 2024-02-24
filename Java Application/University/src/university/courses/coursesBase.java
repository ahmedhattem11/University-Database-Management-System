package university.courses;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public abstract class coursesBase extends AnchorPane {

    protected final TextField textDeptID;
    protected final TextField textDeptName;
    protected final TextField textDeptidFK;
    protected final Label label;
    protected final Label label0;
    protected final Button btnAddDepartment;
    protected final Button btnDeleteDepartment;
    protected final Button btnAddCourse;
    protected final TableView tableCourse;
    protected final TableColumn courseIDColumn;
    protected final TableColumn courseNameColumn;
    protected final TableColumn creditHoursColumn;
    protected final TableColumn capacityColumn;
    protected final TableColumn depIDColumnFK;
    protected final TableView tableDepartment;
    protected final TableColumn depIDColumn;
    protected final TableColumn depNameColumn;
    protected final Label label1;
    protected final Label label2;
    protected final Label label3;
    protected final TextField textCourseID;
    protected final TextField textCourseName;
    protected final Button btnDeleteCourse;
    protected final Separator separator;
    protected final Label textCreditHours;
    protected final TextField textCredit_Hours;
    protected final Separator separator0;
    protected final Label label4;
    protected final Label label5;

    public coursesBase() {

        textDeptID = new TextField();
        textDeptName = new TextField();
        textDeptidFK = new TextField();
        label = new Label();
        label0 = new Label();
        btnAddDepartment = new Button();
        btnDeleteDepartment = new Button();
        btnAddCourse = new Button();
        tableCourse = new TableView();
        courseIDColumn = new TableColumn();
        courseNameColumn = new TableColumn();
        creditHoursColumn = new TableColumn();
        capacityColumn = new TableColumn();
        depIDColumnFK = new TableColumn();
        tableDepartment = new TableView();
        depIDColumn = new TableColumn();
        depNameColumn = new TableColumn();
        label1 = new Label();
        label2 = new Label();
        label3 = new Label();
        textCourseID = new TextField();
        textCourseName = new TextField();
        btnDeleteCourse = new Button();
        separator = new Separator();
        textCreditHours = new Label();
        textCredit_Hours = new TextField();
        separator0 = new Separator();
        label4 = new Label();
        label5 = new Label();

        setId("AnchorPane");
        setPrefHeight(864.0);
        setPrefWidth(996.0);
        setStyle("-fx-background-color: #ffffff;");

        textDeptID.setLayoutX(743.0);
        textDeptID.setLayoutY(587.0);
        textDeptID.setPrefWidth(200.0);
        textDeptID.setPromptText("Enter department ID.....");
        textDeptID.setStyle("-fx-border-width: 0px 0px 2px 0px; -fx-background-color: transparent; -fx-border-color: #750B53;");

        textDeptName.setLayoutX(743.0);
        textDeptName.setLayoutY(669.0);
        textDeptName.setPrefWidth(200.0);
        textDeptName.setPromptText("Enter department name...");
        textDeptName.setStyle("-fx-background-color: transparent; -fx-border-color: #750B53; -fx-border-width: 0px 0px 2px 0px;");

        textDeptidFK.setLayoutX(188.0);
        textDeptidFK.setLayoutY(736.0);
        textDeptidFK.setPrefWidth(200.0);
        textDeptidFK.setPromptText("Enter Department ID");
        textDeptidFK.setStyle("-fx-background-color: transparent; -fx-border-width: 0px 0px 2px 0px; -fx-border-color: #750B53;");

        label.setLayoutX(568.0);
        label.setLayoutY(590.0);
        label.getStyleClass().add("label-font");
        label.getStylesheets().add("/university/courses/../home/resources/ButtonStyle.css");
        label.setText("Department_ID : ");
        label.setFont(new Font("Bodoni MT Bold", 18.0));

        label0.setLayoutX(556.0);
        label0.setLayoutY(672.0);
        label0.getStyleClass().add("label-font");
        label0.getStylesheets().add("/university/courses/../home/resources/ButtonStyle.css");
        label0.setText("Department Name :");
        label0.setFont(new Font("Bodoni MT Bold", 18.0));

        btnAddDepartment.setLayoutX(675.0);
        btnAddDepartment.setLayoutY(795.0);
        btnAddDepartment.setMnemonicParsing(false);
        btnAddDepartment.setOnAction(this::addDept);
        btnAddDepartment.getStyleClass().add("label-font");
        btnAddDepartment.getStylesheets().add("/university/courses/../home/resources/ButtonStyle.css");
        btnAddDepartment.setText("Add Department");
        btnAddDepartment.setFont(new Font("Bodoni MT Bold", 18.0));

        btnDeleteDepartment.setLayoutX(666.0);
        btnDeleteDepartment.setLayoutY(413.0);
        btnDeleteDepartment.setMnemonicParsing(false);
        btnDeleteDepartment.setOnAction(this::deleteDept);
        btnDeleteDepartment.getStyleClass().add("label-font");
        btnDeleteDepartment.getStylesheets().add("/university/courses/../home/resources/ButtonStyle.css");
        btnDeleteDepartment.setText("Delete Department");
        btnDeleteDepartment.setFont(new Font("Bodoni MT Bold", 18.0));

        btnAddCourse.setLayoutX(191.0);
        btnAddCourse.setLayoutY(795.0);
        btnAddCourse.setMnemonicParsing(false);
        btnAddCourse.setOnAction(this::addCourse);
        btnAddCourse.getStyleClass().add("label-font");
        btnAddCourse.getStylesheets().add("/university/courses/../home/resources/ButtonStyle.css");
        btnAddCourse.setText("Add Courses");
        btnAddCourse.setFont(new Font("Bodoni MT Bold", 18.0));

        tableCourse.setLayoutX(-1.0);
        tableCourse.setPrefHeight(394.0);
        tableCourse.setPrefWidth(650.0);

        courseIDColumn.setMinWidth(4.0);
        courseIDColumn.setPrefWidth(90.0);
        courseIDColumn.setText("Course ID");

        courseNameColumn.setPrefWidth(197.0);
        courseNameColumn.setText("Course Name");

        creditHoursColumn.setMinWidth(0.0);
        creditHoursColumn.setPrefWidth(111.0);
        creditHoursColumn.setText("Credit Hours");

        capacityColumn.setPrefWidth(105.0);
        capacityColumn.setText("Capacity");

        depIDColumnFK.setMinWidth(0.0);
        depIDColumnFK.setPrefWidth(149.0);
        depIDColumnFK.setText("Department_ID");

        tableDepartment.setLayoutX(649.0);
        tableDepartment.setPrefHeight(394.0);
        tableDepartment.setPrefWidth(347.0);

        depIDColumn.setPrefWidth(147.0);
        depIDColumn.setText("Department ID");

        depNameColumn.setMinWidth(0.0);
        depNameColumn.setPrefWidth(199.0);
        depNameColumn.setText("Department Name");

        label1.setLayoutX(47.0);
        label1.setLayoutY(560.0);
        label1.getStyleClass().add("label-font");
        label1.getStylesheets().add("/university/courses/../home/resources/ButtonStyle.css");
        label1.setText("Course ID:");
        label1.setFont(new Font("Bodoni MT Bold", 18.0));

        label2.setLayoutX(29.0);
        label2.setLayoutY(623.0);
        label2.getStyleClass().add("label-font");
        label2.getStylesheets().add("/university/courses/../home/resources/ButtonStyle.css");
        label2.setText("Course Name :");
        label2.setFont(new Font("Bodoni MT Bold", 18.0));

        label3.setLayoutX(22.0);
        label3.setLayoutY(742.0);
        label3.getStyleClass().add("label-font");
        label3.getStylesheets().add("/university/courses/../home/resources/ButtonStyle.css");
        label3.setText("Department ID :");
        label3.setFont(new Font("Bodoni MT Bold", 18.0));

        textCourseID.setLayoutX(188.0);
        textCourseID.setLayoutY(554.0);
        textCourseID.setPrefWidth(200.0);
        textCourseID.setPromptText("Enter Course ID");
        textCourseID.setStyle("-fx-border-width: 0px 0px 2px 0px; -fx-background-color: transparent; -fx-border-color: #750B53;");

        textCourseName.setLayoutX(188.0);
        textCourseName.setLayoutY(617.0);
        textCourseName.setPrefWidth(200.0);
        textCourseName.setPromptText("Enter Course Name");
        textCourseName.setStyle("-fx-background-color: transparent; -fx-border-color: #750B53; -fx-border-width: 0px 0px 2px 0px;");

        btnDeleteCourse.setLayoutX(185.0);
        btnDeleteCourse.setLayoutY(413.0);
        btnDeleteCourse.setMnemonicParsing(false);
        btnDeleteCourse.setOnAction(this::deleteCourse);
        btnDeleteCourse.getStyleClass().add("label-font");
        btnDeleteCourse.getStylesheets().add("/university/courses/../home/resources/ButtonStyle.css");
        btnDeleteCourse.setText("Delete Course");
        btnDeleteCourse.setFont(new Font("Bodoni MT Bold", 18.0));

        separator.setLayoutX(118.0);
        separator.setLayoutY(469.0);
        separator.setPrefHeight(5.0);
        separator.setPrefWidth(754.0);

        textCreditHours.setLayoutX(29.0);
        textCreditHours.setLayoutY(686.0);
        textCreditHours.getStyleClass().add("label-font");
        textCreditHours.getStylesheets().add("/university/courses/../home/resources/ButtonStyle.css");
        textCreditHours.setText("Credit Hours :");
        textCreditHours.setFont(new Font("Bodoni MT Bold", 18.0));

        textCredit_Hours.setLayoutX(188.0);
        textCredit_Hours.setLayoutY(671.0);
        textCredit_Hours.setPrefWidth(200.0);
        textCredit_Hours.setPromptText("Enter Credit Hours");
        textCredit_Hours.setStyle("-fx-background-color: transparent; -fx-border-color: #750B53; -fx-border-width: 0px 0px 2px 0px;");

        separator0.setLayoutX(495.0);
        separator0.setLayoutY(493.0);
        separator0.setOrientation(javafx.geometry.Orientation.VERTICAL);
        separator0.setPrefHeight(347.0);
        separator0.setPrefWidth(5.0);

        label4.setLayoutX(188.0);
        label4.setLayoutY(487.0);
        label4.setPrefHeight(35.0);
        label4.setPrefWidth(136.0);
        label4.getStyleClass().add("label-font");
        label4.setText("Add Course");
        label4.setFont(new Font("System Bold", 24.0));

        label5.setLayoutX(663.0);
        label5.setLayoutY(487.0);
        label5.setText("Add Department");
        label5.setFont(new Font("System Bold", 24.0));

        getChildren().add(textDeptID);
        getChildren().add(textDeptName);
        getChildren().add(textDeptidFK);
        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(btnAddDepartment);
        getChildren().add(btnDeleteDepartment);
        getChildren().add(btnAddCourse);
        tableCourse.getColumns().add(courseIDColumn);
        tableCourse.getColumns().add(courseNameColumn);
        tableCourse.getColumns().add(creditHoursColumn);
        tableCourse.getColumns().add(capacityColumn);
        tableCourse.getColumns().add(depIDColumnFK);
        getChildren().add(tableCourse);
        tableDepartment.getColumns().add(depIDColumn);
        tableDepartment.getColumns().add(depNameColumn);
        getChildren().add(tableDepartment);
        getChildren().add(label1);
        getChildren().add(label2);
        getChildren().add(label3);
        getChildren().add(textCourseID);
        getChildren().add(textCourseName);
        getChildren().add(btnDeleteCourse);
        getChildren().add(separator);
        getChildren().add(textCreditHours);
        getChildren().add(textCredit_Hours);
        getChildren().add(separator0);
        getChildren().add(label4);
        getChildren().add(label5);

    }

    protected abstract void addDept(javafx.event.ActionEvent actionEvent);

    protected abstract void deleteDept(javafx.event.ActionEvent actionEvent);

    protected abstract void addCourse(javafx.event.ActionEvent actionEvent);

    protected abstract void deleteCourse(javafx.event.ActionEvent actionEvent);

}
