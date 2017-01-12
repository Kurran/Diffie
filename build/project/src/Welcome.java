import java.awt.font.TextAttribute;
import java.text.AttributedString;

import javafx.animation.Animation.Status;
import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.web.HTMLEditor;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Welcome {

	Scene scene1;

	Timeline timeline;

	boolean appearbool = false;
	StackPane layout1 = new StackPane();
	Generate genScene = new Generate();
	Exchange1 exchange1 = new Exchange1();
	
	public Scene scene1(Stage stage) {
		
		
		// Button 1
		
		
		Background background = new Background(new BackgroundFill(Color.DARKGREY, CornerRadii.EMPTY, Insets.EMPTY));
		layout1.setBackground(background);
		
	
		Label label1 = new Label("A Visual Example of Diffie Hellman");
		label1.setFont(new Font(40));
		label1.setTextFill(Color.RED);
		label1.setTranslateY(-300);


		Button button1 = new Button("Continue to Diffie Hellman");
		button1.setOnAction(e -> stage.setScene(genScene.generateScene(stage)));


		layout1.getChildren().addAll(label1, button1);

		scene1 = new Scene(layout1, 800, 800);
		return scene1;

	}

}
