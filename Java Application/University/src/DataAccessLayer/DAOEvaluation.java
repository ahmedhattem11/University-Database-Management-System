package DataAccessLayer;

import DTOS.DTOCourse;
import DTOS.DTOEvaluation;
import DTOS.DTOReport;
import DTOS.DTOStd_Course;
import DTOS.DTOStudent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DAOEvaluation {

        public ObservableList<DTOEvaluation> getEvaluations() {
            ObservableList<DTOEvaluation> evaluations = FXCollections.observableArrayList();
            try (Connection connection = DAO.getConnection();
                 PreparedStatement statement = connection.prepareStatement("SELECT * FROM evaluation ORDER BY std_id");
                 ResultSet res = statement.executeQuery()) {

                while (res.next()) {
                    int std_id = res.getInt(1);
                    String std_name = res.getString(2);
                    int course_id = res.getInt(3);
                    String course_name = res.getString(4);
                    String grade_id = res.getString(5);
                    int credit_hours = res.getInt(6);
                    Date evaluation_date = res.getDate(7);
                    int semester = res.getInt(8);

                    evaluations.add(new DTOEvaluation(std_id, course_id, semester, std_name, course_name, grade_id, credit_hours, evaluation_date));
                }
            } catch (SQLException ex) {
                Logger.getLogger(DAOEvaluation.class.getName()).log(Level.SEVERE, null, ex);
            }
            return evaluations;
        }

    public int enrollStudent(DTOStd_Course enrollCourse) {
        int result = 0;
        try (Connection connection = DAO.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO std_course(STD_ID, COURSE_ID, SEMESTER, COURSE_NAME) VALUES (?,?,?,?)")) {

            statement.setInt(1, enrollCourse.getStd_id());
            statement.setInt(2, enrollCourse.getCourse_id());
            statement.setInt(3, enrollCourse.getSemester());
            statement.setString(4, enrollCourse.getCourse_name());
            result = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOEvaluation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public int unenrollStudent(DTOEvaluation delete) {
        int result = 0;
        try {
            try (PreparedStatement statement = DAO.getConnection().prepareCall("Delete from evaluation where std_id = ? and course_id = ? and semester = ?")) {
                statement.setInt(1, delete.getStd_id());
                statement.setInt(2, delete.getCourse_id());
                statement.setInt(3, delete.getSemester());
                result = statement.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOEvaluation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public int updateGrade(DTOEvaluation updateEvaluation) {
        int result = 0;
        try (Connection connection = DAO.getConnection();
             CallableStatement callableStatement = connection.prepareCall("{call CASESTUDY.update_evaluation_and_cgpa(?, ?, ?, ?)}")) {

            callableStatement.setInt(1, updateEvaluation.getStd_id());
            callableStatement.setInt(2, updateEvaluation.getCourse_id());
            callableStatement.setInt(3, updateEvaluation.getSemester());
            callableStatement.setString(4, updateEvaluation.getGrade_id());

            result = callableStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOEvaluation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public boolean depCourses(DTOStd_Course course) throws SQLException {
        // Query the database to check if the specified course belongs to the student's department
        String query = "SELECT COUNT(*) FROM COURSE WHERE COURSE_ID = ? AND DEP_ID = (SELECT DEP_ID FROM STUDENT WHERE STD_ID = ?)";
        try (PreparedStatement preparedStatement = DAO.getConnection().prepareStatement(query)) {
            preparedStatement.setInt(1, course.getCourse_id());
            preparedStatement.setInt(2, course.getStd_id());
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0; // Return true if the specified course belongs to the student's department
                }
            }
        }
        return false; // Return false if there's an error or the specified course does not belong to the student's department
    }

    

   public ObservableList<DTOReport> generateReport() {
    ObservableList<DTOReport> reportList = FXCollections.observableArrayList();
    try (Connection connection = DAO.getConnection();
         PreparedStatement statement = connection.prepareStatement(
             "SELECT course_id, " +
             "course_name, " +
             "COUNT(std_id) AS enrolled_students, " +
             "round(calculate_course_avg_gpa(course_id), 3) AS average_gpa " +
             "FROM evaluation " +
             "GROUP BY course_id, course_name " +
             "ORDER BY course_id, course_name")) {

        ResultSet res = statement.executeQuery();

        while (res.next()) {
            int courseId = res.getInt("course_id");
            String courseName = res.getString("course_name");
            int enrolledStudents = res.getInt("enrolled_students");
            double averageGPA = res.getDouble("average_gpa");

            reportList.add(new DTOReport(courseId, courseName, enrolledStudents, averageGPA));
        }
    } catch (SQLException ex) {
        Logger.getLogger(DAOEvaluation.class.getName()).log(Level.SEVERE, null, ex);
    }
    return reportList;
}


 
}
