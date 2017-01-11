import java.awt.font.TextAttribute;
import java.text.AttributedString;

import javafx.animation.Animation.Status;
import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

	public Scene scene1(Stage stage) {
		// Button 1
		StackPane layout1 = new StackPane();
		Generate genScene = new Generate();
		Exchange1 exchange1 = new Exchange1();
		
	
		Label label1 = new Label("Welcome to the first scene!");
		label1.setTranslateY(-300);

		Label appear = new Label("Appear");
		appear.setTranslateY(100);
		appear.setTextFill(Color.BLUE);
		appear.setFont(new Font(30));

		Label appear1 = new Label("Appear 1");
		appear1.setTranslateY(200);

		Button button1 = new Button("Go to scene 2");
		button1.setOnAction(e -> stage.setScene(genScene.generateScene(stage)));
		button1.setTranslateY(300);

		FadeTransition fT = new FadeTransition(Duration.millis(2000), appear);
		fT.setFromValue(0.0f);
		fT.setToValue(1);
		// fT.play();

		FadeTransition fT1 = new FadeTransition(Duration.millis(2000), appear1);
		fT1.setFromValue(0.0f);
		fT1.setToValue(1);
		
		SequentialTransition seq = new SequentialTransition(fT,fT1);

		Button press = new Button("Press Me");
		press.setOnAction(e -> {

			layout1.getChildren().add(appear);
			layout1.getChildren().add(appear1);
			seq.play();

		});
		// button1.setTranslateY(300);

		// superScript.setTextFill(privateKeySuper);
		// Layout 1 - children laid out in vertical column

		layout1.getChildren().addAll(label1, button1, press);

		scene1 = new Scene(layout1, 800, 800);
		return scene1;

	}

}
