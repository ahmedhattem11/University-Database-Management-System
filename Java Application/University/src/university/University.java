
package university;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author ahmed
 */
public class University extends Application{


    @Override
    public void start(Stage stage) throws Exception {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/university/home/home.fxml"));
            Scene scene = new Scene(root);
            
            stage.resizableProperty().setValue(false);
            stage.setScene(scene);
            stage.show(); 
        }catch(Exception ex){
            ex.printStackTrace();
        }
    
    }
    
    public static void main(String[] args) {
        launch(args);
        
    }
    
}
