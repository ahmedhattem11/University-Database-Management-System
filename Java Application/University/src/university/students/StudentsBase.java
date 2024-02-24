package university.students;

import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public abstract class StudentsBase extends AnchorPane {

    protected final TextField DepIDTextField;
    protected final TextField StdIDTextField;
    protected final TextField StdNameTextField;
    protected final TextField EmailTextField;
    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    protected final Label label2;
    protected final Label dataAlert;
    protected final Label label3;
    protected final Button btnAddStd;
    protected final Button btnRemoveStd;
    protected final Button btnDisplayStd;
    protected final DatePicker DOBTextField;
    protected final Label label4;
    protected final RadioButton MaleRadioBtn;
    protected final RadioButton FemaleRadioBtn;
    protected final TableView StdTableView;
    protected final TableColumn StdIDCoulmn;
    protected final TableColumn StdNameColumn;
    protected final TableColumn DepIDColumn;
    protected final TableColumn CgpaColumn;
    protected final TableColumn CityColumn;
    protected final TableColumn EmailColumn;
    protected final TableColumn GenderColumn;
    protected final TableColumn DOBColumn;
    protected final Separator separator;
    protected final Button btnClear;

    public StudentsBase() {

        DepIDTextField = new TextField();
        StdIDTextField = new TextField();
        StdNameTextField = new TextField();
        EmailTextField = new TextField();
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        label2 = new Label();
        dataAlert = new Label();
        label3 = new Label();
        btnAddStd = new Button();
        btnRemoveStd = new Button();
        btnDisplayStd = new Button();
        DOBTextField = new DatePicker();
        label4 = new Label();
        MaleRadioBtn = new RadioButton();
        FemaleRadioBtn = new RadioButton();
        StdTableView = new TableView();
        StdIDCoulmn = new TableColumn();
        StdNameColumn = new TableColumn();
        DepIDColumn = new TableColumn();
        CgpaColumn = new TableColumn();
        CityColumn = new TableColumn();
        EmailColumn = new TableColumn();
        GenderColumn = new TableColumn();
        DOBColumn = new TableColumn();
        separator = new Separator();
        btnClear = new Button();

        setId("AnchorPane");
        setPrefHeight(864.0);
        setPrefWidth(996.0);
        setStyle("-fx-background-color: #ffffff;");
        getStylesheets().add("/university/students/ButtonStyle.css");

        DepIDTextField.setLayoutX(170.0);
        DepIDTextField.setLayoutY(664.0);
        DepIDTextField.setPrefHeight(33.0);
        DepIDTextField.setPrefWidth(231.0);
        DepIDTextField.setPromptText("Enter student department ID...");
        DepIDTextField.setStyle("-fx-background-color: transparent; -fx-border-width: 0px 0px 2px 0px; -fx-border-color: #750B53;");

        StdIDTextField.setLayoutX(170.0);
        StdIDTextField.setLayoutY(618.0);
        StdIDTextField.setPrefHeight(33.0);
        StdIDTextField.setPrefWidth(231.0);
        StdIDTextField.setPromptText("Enter student ID.....");
        StdIDTextField.setStyle("-fx-border-width: 0px 0px 2px 0px; -fx-background-color: transparent; -fx-border-color: #750B53;");

        StdNameTextField.setLayoutX(692.0);
        StdNameTextField.setLayoutY(618.0);
        StdNameTextField.setPrefHeight(33.0);
        StdNameTextField.setPrefWidth(244.0);
        StdNameTextField.setPromptText("Enter student name...");
        StdNameTextField.setStyle("-fx-background-color: transparent; -fx-border-color: #750B53; -fx-border-width: 0px 0px 2px 0px;");

        EmailTextField.setLayoutX(692.0);
        EmailTextField.setLayoutY(664.0);
        EmailTextField.setPrefHeight(33.0);
        EmailTextField.setPrefWidth(244.0);
        EmailTextField.setPromptText("Enter student Email...");
        EmailTextField.setStyle("-fx-border-color: #750B53; -fx-background-color: transparent; -fx-border-width: 0px 0px 2px 0px;");

        label.setLayoutX(34.0);
        label.setLayoutY(621.0);
        label.setText("Student_ID : ");
        label.setFont(new Font("System Bold", 18.0));

        label0.setLayoutX(537.0);
        label0.setLayoutY(621.0);
        label0.getStyleClass().add("label-font");
        label0.getStylesheets().add("/university/students/../home/resources/ButtonStyle.css");
        label0.setText("Student Name:");
        label0.setFont(new Font("Bodoni MT Bold", 18.0));

        label1.setLayoutX(58.0);
        label1.setLayoutY(719.0);
        label1.setPrefHeight(27.0);
        label1.setPrefWidth(61.0);
        label1.getStyleClass().add("label-font");
        label1.getStylesheets().add("/university/students/../home/resources/ButtonStyle.css");
        label1.setText("DOB : ");
        label1.setFont(new Font("Bodoni MT Bold", 18.0));

        label2.setLayoutX(570.0);
        label2.setLayoutY(667.0);
        label2.getStyleClass().add("label-font");
        label2.getStylesheets().add("/university/students/../home/resources/ButtonStyle.css");
        label2.setText("Email : ");
        label2.setFont(new Font("Bodoni MT Bold", 18.0));

        dataAlert.setText("");

        label3.setLayoutX(17.0);
        label3.setLayoutY(667.0);
        label3.getStyleClass().add("label-font");
        label3.getStylesheets().add("/university/students/../home/resources/ButtonStyle.css");
        label3.setText("Department_ID : ");
        label3.setFont(new Font("Bodoni MT Bold", 14.0));

        btnAddStd.setLayoutX(272.0);
        btnAddStd.setLayoutY(780.0);
        btnAddStd.setMnemonicParsing(false);
        btnAddStd.setOnAction(this::addStudents);
        btnAddStd.getStyleClass().add("label-font");
        btnAddStd.getStylesheets().add("/university/students/../home/resources/ButtonStyle.css");
        btnAddStd.setText("Add Student");
        btnAddStd.setFont(new Font("Bodoni MT Bold", 18.0));

        btnRemoveStd.setLayoutX(160.0);
        btnRemoveStd.setLayoutY(502.0);
        btnRemoveStd.setMnemonicParsing(false);
        btnRemoveStd.setOnAction(this::deleteStudents);
        btnRemoveStd.setPrefHeight(39.0);
        btnRemoveStd.setPrefWidth(174.0);
        btnRemoveStd.getStyleClass().add("label-font");
        btnRemoveStd.getStylesheets().add("/university/students/../home/resources/ButtonStyle.css");
        btnRemoveStd.setText("Remove Student");
        btnRemoveStd.setFont(new Font("Bodoni MT Bold", 18.0));

        btnDisplayStd.setLayoutX(657.0);
        btnDisplayStd.setLayoutY(502.0);
        btnDisplayStd.setMnemonicParsing(false);
        btnDisplayStd.setOnAction(this::viewStudents);
        btnDisplayStd.getStyleClass().add("label-font");
        btnDisplayStd.getStylesheets().add("/university/students/../home/resources/ButtonStyle.css");
        btnDisplayStd.setText("Display Students");
        btnDisplayStd.setFont(new Font("Bodoni MT Bold", 18.0));

        DOBTextField.setLayoutX(170.0);
        DOBTextField.setLayoutY(716.0);
        DOBTextField.setPrefHeight(33.0);
        DOBTextField.setPrefWidth(231.0);
        DOBTextField.setPromptText("Enter student birthdate....");
        DOBTextField.setStyle("-fx-background-color: transparent; -fx-border-color: #750B53; -fx-border-width: 0px 0px 2px 0px;");

        label4.setLayoutX(563.0);
        label4.setLayoutY(719.0);
        label4.setPrefHeight(27.0);
        label4.setPrefWidth(75.0);
        label4.getStyleClass().add("label-font");
        label4.getStylesheets().add("/university/students/../home/resources/ButtonStyle.css");
        label4.setText("Gender :");

        MaleRadioBtn.setLayoutX(740.0);
        MaleRadioBtn.setLayoutY(719.0);
        MaleRadioBtn.setMnemonicParsing(false);
        MaleRadioBtn.getStyleClass().add("label-font");
        MaleRadioBtn.getStylesheets().add("/university/students/../home/resources/ButtonStyle.css");
        MaleRadioBtn.setText("Male");

        FemaleRadioBtn.setLayoutX(843.0);
        FemaleRadioBtn.setLayoutY(719.0);
        FemaleRadioBtn.setMnemonicParsing(false);
        FemaleRadioBtn.getStyleClass().add("label-font");
        FemaleRadioBtn.getStylesheets().add("/university/students/../home/resources/ButtonStyle.css");
        FemaleRadioBtn.setText("Female");

        StdTableView.setPrefHeight(491.0);
        StdTableView.setPrefWidth(996.0);

        StdIDCoulmn.setPrefWidth(82.0);
        StdIDCoulmn.setText("Student ID");

        StdNameColumn.setPrefWidth(146.0);
        StdNameColumn.setText("Student Name");

        DepIDColumn.setPrefWidth(113.0);
        DepIDColumn.setText("Department ID");

        CgpaColumn.setPrefWidth(105.0);
        CgpaColumn.setText("CGPA");

        CityColumn.setPrefWidth(84.0);
        CityColumn.setText("City");

        EmailColumn.setPrefWidth(196.0);
        EmailColumn.setText("E-mail");

        GenderColumn.setPrefWidth(79.0);
        GenderColumn.setText("Gender");

        DOBColumn.setPrefWidth(190.0);
        DOBColumn.setText("Date of birth");

        separator.setLayoutX(98.0);
        separator.setLayoutY(575.0);
        separator.setPrefHeight(6.0);
        separator.setPrefWidth(787.0);

        btnClear.setLayoutX(567.0);
        btnClear.setLayoutY(780.0);
        btnClear.setMnemonicParsing(false);
        btnClear.setOnAction(this::clearFields);
        btnClear.setPrefHeight(39.0);
        btnClear.setPrefWidth(119.0);
        btnClear.getStyleClass().add("label-font");
        btnClear.getStylesheets().add("/university/students/../home/resources/ButtonStyle.css");
        btnClear.setText("Clear");
        btnClear.setFont(new Font("Bodoni MT Bold", 18.0));

        getChildren().add(DepIDTextField);
        getChildren().add(StdIDTextField);
        getChildren().add(StdNameTextField);
        getChildren().add(EmailTextField);
        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(label1);
        getChildren().add(label2);
        getChildren().add(dataAlert);
        getChildren().add(label3);
        getChildren().add(btnAddStd);
        getChildren().add(btnRemoveStd);
        getChildren().add(btnDisplayStd);
        getChildren().add(DOBTextField);
        getChildren().add(label4);
        getChildren().add(MaleRadioBtn);
        getChildren().add(FemaleRadioBtn);
        StdTableView.getColumns().add(StdIDCoulmn);
        StdTableView.getColumns().add(StdNameColumn);
        StdTableView.getColumns().add(DepIDColumn);
        StdTableView.getColumns().add(CgpaColumn);
        StdTableView.getColumns().add(CityColumn);
        StdTableView.getColumns().add(EmailColumn);
        StdTableView.getColumns().add(GenderColumn);
        StdTableView.getColumns().add(DOBColumn);
        getChildren().add(StdTableView);
        getChildren().add(separator);
        getChildren().add(btnClear);

    }

    protected abstract void addStudents(javafx.event.ActionEvent actionEvent);

    protected abstract void deleteStudents(javafx.event.ActionEvent actionEvent);

    protected abstract void viewStudents(javafx.event.ActionEvent actionEvent);

    protected abstract void clearFields(javafx.event.ActionEvent actionEvent);

}
