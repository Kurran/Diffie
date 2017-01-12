import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class Main extends Application {

    Stage window;
    

	public static void main(String[] args) {
        launch(args);
        System.out.println(-3%5);
    }

    @Override
    public void start(Stage primaryStage) {
    	
        window = primaryStage;
        Welcome scene1 = new Welcome();
        //Display scene 1 at first
        window.setScene(scene1.scene1(window));
        window.setTitle("Title");
        //window.setWidth(800);
        //window.setHeight(800);
        window.show();
       
    }

}

