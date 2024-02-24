package university.evaluation;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public abstract class evaluationBase extends AnchorPane {

    protected final TextField textCourseID_ENR;
    protected final TextField textStdID_EVA;
    protected final TextField textSemester_EVA;
    protected final TextField textGrade_EVA;
    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    protected final Label label2;
    protected final Button btnUpdateGrade;
    protected final TableView evaluationTable;
    protected final TableColumn stdIDColumn;
    protected final TableColumn stdNameColumn;
    protected final TableColumn courseIDColumn;
    protected final TableColumn courseNameColumn;
    protected final TableColumn gradeColumn;
    protected final TableColumn creditHoursColumn;
    protected final TableColumn semesterColumn;
    protected final TableColumn evaluationDateColumn;
    protected final Separator separator;
    protected final Separator separator0;
    protected final Label label3;
    protected final Label label4;
    protected final Label label5;
    protected final TextField textStdID_ENR;
    protected final Label label6;
    protected final TextField textCourseID_EVA;
    protected final Label label7;
    protected final TextField textDSemester_ENR;
    protected final Label label8;
    protected final TextField textCourseName_ENR;
    protected final Button btnEnroll;

    public evaluationBase() {

        textCourseID_ENR = new TextField();
        textStdID_EVA = new TextField();
        textSemester_EVA = new TextField();
        textGrade_EVA = new TextField();
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        label2 = new Label();
        btnUpdateGrade = new Button();
        evaluationTable = new TableView();
        stdIDColumn = new TableColumn();
        stdNameColumn = new TableColumn();
        courseIDColumn = new TableColumn();
        courseNameColumn = new TableColumn();
        gradeColumn = new TableColumn();
        creditHoursColumn = new TableColumn();
        semesterColumn = new TableColumn();
        evaluationDateColumn = new TableColumn();
        separator = new Separator();
        separator0 = new Separator();
        label3 = new Label();
        label4 = new Label();
        label5 = new Label();
        textStdID_ENR = new TextField();
        label6 = new Label();
        textCourseID_EVA = new TextField();
        label7 = new Label();
        textDSemester_ENR = new TextField();
        label8 = new Label();
        textCourseName_ENR = new TextField();
        btnEnroll = new Button();

        setId("AnchorPane");
        setPrefHeight(864.0);
        setPrefWidth(996.0);
        setStyle("-fx-background-color: #ffffff;");
        getStylesheets().add("/university/evaluation/ButtonStyle.css");

        textCourseID_ENR.setLayoutX(684.0);
        textCourseID_ENR.setLayoutY(570.0);
        textCourseID_ENR.setPrefHeight(33.0);
        textCourseID_ENR.setPrefWidth(206.0);
        textCourseID_ENR.setPromptText("Enter student department ID...");
        textCourseID_ENR.setStyle("-fx-background-color: transparent; -fx-border-width: 0px 0px 2px 0px; -fx-border-color: #750B53;");

        textStdID_EVA.setLayoutX(180.0);
        textStdID_EVA.setLayoutY(497.0);
        textStdID_EVA.setPrefHeight(33.0);
        textStdID_EVA.setPrefWidth(206.0);
        textStdID_EVA.setPromptText("Enter student ID.....");
        textStdID_EVA.setStyle("-fx-border-width: 0px 0px 2px 0px; -fx-background-color: transparent; -fx-border-color: #750B53;");

        textSemester_EVA.setLayoutX(180.0);
        textSemester_EVA.setLayoutY(644.0);
        textSemester_EVA.setPrefHeight(33.0);
        textSemester_EVA.setPrefWidth(206.0);
        textSemester_EVA.setPromptText("Enter Semester..");
        textSemester_EVA.setStyle("-fx-background-color: transparent; -fx-border-color: #750B53; -fx-border-width: 0px 0px 2px 0px;");

        textGrade_EVA.setLayoutX(180.0);
        textGrade_EVA.setLayoutY(719.0);
        textGrade_EVA.setPrefHeight(33.0);
        textGrade_EVA.setPrefWidth(206.0);
        textGrade_EVA.setPromptText("Enter Student Grade..");
        textGrade_EVA.setStyle("-fx-border-color: #750B53; -fx-background-color: transparent; -fx-border-width: 0px 0px 2px 0px;");

        label.setLayoutX(41.0);
        label.setLayoutY(500.0);
        label.setText("Student ID :");
        label.setFont(new Font("System Bold", 18.0));

        label0.setLayoutX(48.0);
        label0.setLayoutY(647.0);
        label0.getStyleClass().add("label-font");
        label0.getStylesheets().add("/university/evaluation/../home/resources/ButtonStyle.css");
        label0.setText("Semester :");
        label0.setFont(new Font("Bodoni MT Bold", 18.0));

        label1.setLayoutX(55.0);
        label1.setLayoutY(722.0);
        label1.setPrefHeight(27.0);
        label1.setPrefWidth(66.0);
        label1.getStyleClass().add("label-font");
        label1.getStylesheets().add("/university/evaluation/../home/resources/ButtonStyle.css");
        label1.setText("Grade :");
        label1.setFont(new Font("Bodoni MT Bold", 18.0));

        label2.setLayoutX(46.0);
        label2.setLayoutY(573.0);
        label2.getStyleClass().add("label-font");
        label2.getStylesheets().add("/university/evaluation/../home/resources/ButtonStyle.css");
        label2.setText("Course ID :");
        label2.setFont(new Font("Bodoni MT Bold", 14.0));

        btnUpdateGrade.setLayoutX(157.0);
        btnUpdateGrade.setLayoutY(786.0);
        btnUpdateGrade.setMnemonicParsing(false);
        btnUpdateGrade.setOnAction(this::updateGrade);
        btnUpdateGrade.getStyleClass().add("label-font");
        btnUpdateGrade.getStylesheets().add("/university/evaluation/../home/resources/ButtonStyle.css");
        btnUpdateGrade.setText("Update Grade");
        btnUpdateGrade.setFont(new Font("Bodoni MT Bold", 18.0));

        evaluationTable.setLayoutX(-3.0);
        evaluationTable.setPrefHeight(388.0);
        evaluationTable.setPrefWidth(997.0);

        stdIDColumn.setPrefWidth(93.0);
        stdIDColumn.setText("Student ID");

        stdNameColumn.setPrefWidth(179.0);
        stdNameColumn.setText("Student Name");

        courseIDColumn.setPrefWidth(81.0);
        courseIDColumn.setText("Course ID");

        courseNameColumn.setPrefWidth(154.0);
        courseNameColumn.setText("Course Name");

        gradeColumn.setPrefWidth(83.0);
        gradeColumn.setText("Grade");

        creditHoursColumn.setPrefWidth(118.0);
        creditHoursColumn.setText("Credit Hours");

        semesterColumn.setPrefWidth(111.0);
        semesterColumn.setText("Semester");

        evaluationDateColumn.setPrefWidth(177.0);
        evaluationDateColumn.setText("Evaluation Date");

        separator.setLayoutX(189.0);
        separator.setLayoutY(398.0);
        separator.setPrefHeight(3.0);
        separator.setPrefWidth(612.0);

        separator0.setLayoutX(498.0);
        separator0.setLayoutY(408.0);
        separator0.setOrientation(javafx.geometry.Orientation.VERTICAL);
        separator0.setPrefHeight(428.0);
        separator0.setPrefWidth(3.0);

        label3.setAlignment(javafx.geometry.Pos.CENTER);
        label3.setLayoutX(121.0);
        label3.setLayoutY(424.0);
        label3.setPrefHeight(40.0);
        label3.setPrefWidth(241.0);
        label3.getStyleClass().add("label-font");
        label3.setText("Course Evaluation");
        label3.setFont(new Font("System Bold", 28.0));

        label4.setAlignment(javafx.geometry.Pos.CENTER);
        label4.setLayoutX(619.0);
        label4.setLayoutY(424.0);
        label4.setPrefHeight(40.0);
        label4.setPrefWidth(250.0);
        label4.getStyleClass().add("label-font");
        label4.setText("Course Enrollment");
        label4.setFont(new Font("System Bold", 28.0));

        label5.setLayoutX(537.0);
        label5.setLayoutY(500.0);
        label5.setText("Student ID :");
        label5.setFont(new Font("System Bold", 18.0));

        textStdID_ENR.setLayoutX(684.0);
        textStdID_ENR.setLayoutY(497.0);
        textStdID_ENR.setPrefHeight(33.0);
        textStdID_ENR.setPrefWidth(206.0);
        textStdID_ENR.setPromptText("Enter student ID.....");
        textStdID_ENR.setStyle("-fx-border-width: 0px 0px 2px 0px; -fx-background-color: transparent; -fx-border-color: #750B53;");

        label6.setLayoutX(542.0);
        label6.setLayoutY(573.0);
        label6.getStyleClass().add("label-font");
        label6.getStylesheets().add("/university/evaluation/../home/resources/ButtonStyle.css");
        label6.setText("Course ID :");
        label6.setFont(new Font("Bodoni MT Bold", 14.0));

        textCourseID_EVA.setLayoutX(180.0);
        textCourseID_EVA.setLayoutY(570.0);
        textCourseID_EVA.setPrefHeight(33.0);
        textCourseID_EVA.setPrefWidth(206.0);
        textCourseID_EVA.setPromptText("Enter student department ID...");
        textCourseID_EVA.setStyle("-fx-background-color: transparent; -fx-border-width: 0px 0px 2px 0px; -fx-border-color: #750B53;");

        label7.setLayoutX(543.0);
        label7.setLayoutY(722.0);
        label7.getStyleClass().add("label-font");
        label7.getStylesheets().add("/university/evaluation/../home/resources/ButtonStyle.css");
        label7.setText("Semester :");
        label7.setFont(new Font("Bodoni MT Bold", 18.0));

        textDSemester_ENR.setLayoutX(684.0);
        textDSemester_ENR.setLayoutY(719.0);
        textDSemester_ENR.setPrefHeight(33.0);
        textDSemester_ENR.setPrefWidth(206.0);
        textDSemester_ENR.setPromptText("Enter Semester..");
        textDSemester_ENR.setStyle("-fx-background-color: transparent; -fx-border-color: #750B53; -fx-border-width: 0px 0px 2px 0px;");

        label8.setLayoutX(525.0);
        label8.setLayoutY(647.0);
        label8.setPrefHeight(27.0);
        label8.setPrefWidth(127.0);
        label8.getStyleClass().add("label-font");
        label8.getStylesheets().add("/university/evaluation/../home/resources/ButtonStyle.css");
        label8.setText("Course Name :");
        label8.setFont(new Font("Bodoni MT Bold", 18.0));

        textCourseName_ENR.setLayoutX(684.0);
        textCourseName_ENR.setLayoutY(644.0);
        textCourseName_ENR.setPrefHeight(33.0);
        textCourseName_ENR.setPrefWidth(206.0);
        textCourseName_ENR.setPromptText("Enter Course Name..");
        textCourseName_ENR.setStyle("-fx-border-color: #750B53; -fx-background-color: transparent; -fx-border-width: 0px 0px 2px 0px;");

        btnEnroll.setLayoutX(673.0);
        btnEnroll.setLayoutY(786.0);
        btnEnroll.setMnemonicParsing(false);
        btnEnroll.setOnAction(this::enrollStd);
        btnEnroll.getStyleClass().add("label-font");
        btnEnroll.getStylesheets().add("/university/evaluation/../home/resources/ButtonStyle.css");
        btnEnroll.setText("Enroll Student");
        btnEnroll.setFont(new Font("Bodoni MT Bold", 18.0));

        getChildren().add(textCourseID_ENR);
        getChildren().add(textStdID_EVA);
        getChildren().add(textSemester_EVA);
        getChildren().add(textGrade_EVA);
        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(label1);
        getChildren().add(label2);
        getChildren().add(btnUpdateGrade);
        evaluationTable.getColumns().add(stdIDColumn);
        evaluationTable.getColumns().add(stdNameColumn);
        evaluationTable.getColumns().add(courseIDColumn);
        evaluationTable.getColumns().add(courseNameColumn);
        evaluationTable.getColumns().add(gradeColumn);
        evaluationTable.getColumns().add(creditHoursColumn);
        evaluationTable.getColumns().add(semesterColumn);
        evaluationTable.getColumns().add(evaluationDateColumn);
        getChildren().add(evaluationTable);
        getChildren().add(separator);
        getChildren().add(separator0);
        getChildren().add(label3);
        getChildren().add(label4);
        getChildren().add(label5);
        getChildren().add(textStdID_ENR);
        getChildren().add(label6);
        getChildren().add(textCourseID_EVA);
        getChildren().add(label7);
        getChildren().add(textDSemester_ENR);
        getChildren().add(label8);
        getChildren().add(textCourseName_ENR);
        getChildren().add(btnEnroll);

    }

    protected abstract void updateGrade(javafx.event.ActionEvent actionEvent);

    protected abstract void enrollStd(javafx.event.ActionEvent actionEvent);

}
