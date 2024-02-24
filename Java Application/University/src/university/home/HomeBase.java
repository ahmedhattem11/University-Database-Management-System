package university.home;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;

public abstract class HomeBase extends BorderPane {

    protected final AnchorPane anchorPane;
    protected final Button btnStudent;
    protected final Button btnDepartment;
    protected final Button btnEvaluation;
    protected final Button btnReport;
    protected final Button btnCourse;
    protected final ImageView imgViewUniveristy;
    protected final ImageView imageView;
    protected final ImageView imageView0;
    protected final ImageView imageView1;
    protected final ImageView imageView2;
    protected final ImageView imageView3;
    protected final AnchorPane replacePane;
    protected final ImageView imgWelcome;
    protected final Label label;

    public HomeBase() {

        anchorPane = new AnchorPane();
        btnStudent = new Button();
        btnDepartment = new Button();
        btnEvaluation = new Button();
        btnReport = new Button();
        btnCourse = new Button();
        imgViewUniveristy = new ImageView();
        imageView = new ImageView();
        imageView0 = new ImageView();
        imageView1 = new ImageView();
        imageView2 = new ImageView();
        imageView3 = new ImageView();
        replacePane = new AnchorPane();
        imgWelcome = new ImageView();
        label = new Label();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(850.0);
        setPrefWidth(1300.0);

        BorderPane.setAlignment(anchorPane, javafx.geometry.Pos.CENTER);
        anchorPane.setPrefHeight(850.0);
        anchorPane.setPrefWidth(306.0);
        anchorPane.setStyle("-fx-background-color: #668cff;");

        btnStudent.setAlignment(javafx.geometry.Pos.CENTER);
        btnStudent.setLayoutX(-2.0);
        btnStudent.setLayoutY(348.0);
        btnStudent.setMnemonicParsing(false);
        btnStudent.setOnAction(this::viewStudents);
        btnStudent.setPrefHeight(60.0);
        btnStudent.setPrefWidth(321.0);
        btnStudent.getStyleClass().add("transparent-button");
        btnStudent.getStylesheets().add("/university/home/resources/ButtonStyle.css");
        btnStudent.setText(" Student");
        btnStudent.setFont(new Font("System Bold", 36.0));

        btnDepartment.setAlignment(javafx.geometry.Pos.CENTER);
        btnDepartment.setLayoutX(-1.0);
        btnDepartment.setLayoutY(438.0);
        btnDepartment.setMnemonicParsing(false);
        btnDepartment.setOnAction(this::viewDepartment);
        btnDepartment.setPrefHeight(74.0);
        btnDepartment.setPrefWidth(322.0);
        btnDepartment.getStyleClass().add("transparent-button");
        btnDepartment.getStylesheets().add("/university/home/resources/ButtonStyle.css");
        btnDepartment.setText("   Department");
        btnDepartment.setFont(new Font("System Bold", 36.0));

        btnEvaluation.setLayoutX(2.0);
        btnEvaluation.setLayoutY(632.0);
        btnEvaluation.setMnemonicParsing(false);
        btnEvaluation.setOnAction(this::viewEvaluation);
        btnEvaluation.setPrefHeight(68.0);
        btnEvaluation.setPrefWidth(322.0);
        btnEvaluation.getStyleClass().add("transparent-button");
        btnEvaluation.getStylesheets().add("/university/home/resources/ButtonStyle.css");
        btnEvaluation.setText("  Evaluation");
        btnEvaluation.setFont(new Font("System Bold", 36.0));

        btnReport.setLayoutX(-2.0);
        btnReport.setLayoutY(722.0);
        btnReport.setMnemonicParsing(false);
        btnReport.setOnAction(this::viewReport);
        btnReport.setPrefHeight(66.0);
        btnReport.setPrefWidth(323.0);
        btnReport.getStyleClass().add("transparent-button");
        btnReport.getStylesheets().add("/university/home/resources/ButtonStyle.css");
        btnReport.setText("  Reports");
        btnReport.setFont(new Font("System Bold", 36.0));

        btnCourse.setAlignment(javafx.geometry.Pos.CENTER);
        btnCourse.setLayoutX(-2.0);
        btnCourse.setLayoutY(531.0);
        btnCourse.setMnemonicParsing(false);
        btnCourse.setOnAction(this::viewCourse);
        btnCourse.setPrefHeight(74.0);
        btnCourse.setPrefWidth(322.0);
        btnCourse.getStyleClass().add("transparent-button");
        btnCourse.getStylesheets().add("/university/home/resources/ButtonStyle.css");
        btnCourse.setText(" Course");
        btnCourse.setFont(new Font("System Bold", 36.0));

        imgViewUniveristy.setFitHeight(235.0);
        imgViewUniveristy.setFitWidth(201.0);
        imgViewUniveristy.setLayoutX(60.0);
        imgViewUniveristy.setLayoutY(57.0);
        imgViewUniveristy.setPickOnBounds(true);
        imgViewUniveristy.setPreserveRatio(true);
        imgViewUniveristy.setImage(new Image(getClass().getResource("resources/icons8-university-100.png").toExternalForm()));

        imageView.setFitHeight(66.0);
        imageView.setFitWidth(83.0);
        imageView.setLayoutX(11.0);
        imageView.setLayoutY(350.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("resources/icons8-student-100.png").toExternalForm()));

        imageView0.setFitHeight(60.0);
        imageView0.setFitWidth(64.0);
        imageView0.setLayoutX(6.0);
        imageView0.setLayoutY(438.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("resources/icons8-department-100.png").toExternalForm()));

        imageView1.setFitHeight(58.0);
        imageView1.setFitWidth(61.0);
        imageView1.setLayoutX(15.0);
        imageView1.setLayoutY(547.0);
        imageView1.setPickOnBounds(true);
        imageView1.setPreserveRatio(true);
        imageView1.setImage(new Image(getClass().getResource("resources/icons8-course-100%20(1).png").toExternalForm()));

        imageView2.setFitHeight(65.0);
        imageView2.setFitWidth(69.0);
        imageView2.setLayoutX(11.0);
        imageView2.setLayoutY(724.0);
        imageView2.setPickOnBounds(true);
        imageView2.setPreserveRatio(true);
        imageView2.setImage(new Image(getClass().getResource("resources/icons8-health-graph-100.png").toExternalForm()));

        imageView3.setFitHeight(57.0);
        imageView3.setFitWidth(59.0);
        imageView3.setLayoutX(16.0);
        imageView3.setLayoutY(638.0);
        imageView3.setPickOnBounds(true);
        imageView3.setPreserveRatio(true);
        imageView3.setImage(new Image(getClass().getResource("resources/icons8-evaluation-100.png").toExternalForm()));
        setLeft(anchorPane);

        BorderPane.setAlignment(replacePane, javafx.geometry.Pos.CENTER);
        replacePane.setPrefHeight(864.0);
        replacePane.setPrefWidth(908.0);
        replacePane.setStyle("-fx-background-color: #ffffff;");

        imgWelcome.setFitHeight(864.0);
        imgWelcome.setFitWidth(996.0);
        imgWelcome.setPickOnBounds(true);
        imgWelcome.setImage(new Image(getClass().getResource("resources/university-background-04.jpg").toExternalForm()));

        label.setAlignment(javafx.geometry.Pos.CENTER);
        label.setLayoutX(17.0);
        label.setLayoutY(172.0);
        label.setPrefHeight(520.0);
        label.setPrefWidth(970.0);
        label.setText("Welcome to My University");
        label.setTextFill(javafx.scene.paint.Color.WHITE);
        label.setTextOverrun(javafx.scene.control.OverrunStyle.CLIP);
        label.setFont(new Font("System Bold", 72.0));
        setCenter(replacePane);

        anchorPane.getChildren().add(btnStudent);
        anchorPane.getChildren().add(btnDepartment);
        anchorPane.getChildren().add(btnEvaluation);
        anchorPane.getChildren().add(btnReport);
        anchorPane.getChildren().add(btnCourse);
        anchorPane.getChildren().add(imgViewUniveristy);
        anchorPane.getChildren().add(imageView);
        anchorPane.getChildren().add(imageView0);
        anchorPane.getChildren().add(imageView1);
        anchorPane.getChildren().add(imageView2);
        anchorPane.getChildren().add(imageView3);
        replacePane.getChildren().add(imgWelcome);
        replacePane.getChildren().add(label);

    }

    protected abstract void viewStudents(javafx.event.ActionEvent actionEvent);

    protected abstract void viewDepartment(javafx.event.ActionEvent actionEvent);

    protected abstract void viewEvaluation(javafx.event.ActionEvent actionEvent);

    protected abstract void viewReport(javafx.event.ActionEvent actionEvent);

    protected abstract void viewCourse(javafx.event.ActionEvent actionEvent);

}
