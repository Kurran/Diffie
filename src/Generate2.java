import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Generate2 {

	Scene scene2;
	StackPane generatePane = new StackPane();
	Numbers num = new Numbers();

	public Scene generateScene(Stage stage) {

		Welcome welcomeScene = new Welcome();
		Exchange1 exchange1Scene = new Exchange1();
		
		
		// Back Button
		Button backbutton = new Button("Back");
		backbutton.setOnAction(e -> stage.setScene(welcomeScene.scene1(stage)));
		backbutton.setTranslateY(350);
		
		Button exchange1Button = new Button("Next");
		exchange1Button.setOnAction(e -> {
			
		
		});
		exchange1Button.setTranslateY(-300);


		// Generate G and P
		//g

		Label gLabel = new Label();
		gLabel.setTranslateX(250);
		gLabel.setTranslateY(-145);
		gLabel.setTextFill(num.gColor);

		Button gbutton = new Button("Set g");
		gbutton.setOnAction(e -> {
		
		}

		);

		gbutton.setTranslateX(250);
		gbutton.setTranslateY(-205);
		
		//p
		
		Label pLabel = new Label();
		pLabel.setTranslateX(-250);
		pLabel.setTranslateY(-145);
		pLabel.setTextFill(num.pColor);

		
		
		//Images
		//URL url = this.getClass().getResourceAsStream("/luke.jpg");
		Image lukeRead = new Image(this.getClass().getResourceAsStream("/luke.jpg"), 200, 200, false, false);
		ImageView luke = new ImageView(lukeRead);
		luke.setTranslateX(250);
		luke.setTranslateY(200);

		Image jessRead = new Image(this.getClass().getResourceAsStream("/jess.jpg"), 200, 200, false, false);
		ImageView jess = new ImageView(jessRead);
		jess.setTranslateX(-250);
		jess.setTranslateY(200);
		
		
		//Generate Jess Key

	
		Label jessPrivateLabel = new Label();
		jessPrivateLabel.setTranslateX(-250);
		jessPrivateLabel.setTranslateY(350);
		jessPrivateLabel.setTextFill(num.jessPrivateNumberColor);
		jessPrivateLabel.setText(Integer.toString((int)num.getJessPrivate()));
		
		
		Label jessLukeKeyLabel = new Label();
		jessLukeKeyLabel.setTranslateX(-335);
		jessLukeKeyLabel.setTranslateY(-70);
		jessLukeKeyLabel.setTextFill(num.lukeSharedKeyColor);
		FadeTransition fjessLukeKeyLabel = new FadeTransition(Duration.millis(1000),jessLukeKeyLabel);
		fjessLukeKeyLabel.setFromValue(0);
		fjessLukeKeyLabel.setToValue(1);
		
		Label jessRaisedPrivateLabel = new Label();
		jessRaisedPrivateLabel.setTranslateX(-350);
		jessRaisedPrivateLabel.setTranslateY(-50);
		jessRaisedPrivateLabel.setTextFill(num.jessPrivateNumberColor);
		FadeTransition fjessRaisedPrivateLabel = new FadeTransition(Duration.millis(1000),jessRaisedPrivateLabel);
		fjessRaisedPrivateLabel.setFromValue(0);
		fjessRaisedPrivateLabel.setToValue(1);
		

		Label jessMod = new Label();
		jessMod.setTranslateX(-305);
		jessMod.setTranslateY(-50);
		FadeTransition fJessMod = new FadeTransition(Duration.millis(1000),jessMod);
		fJessMod.setFromValue(0);
		fJessMod.setToValue(1);
		
		Label jessModP = new Label();
		jessModP.setTranslateX(-275);
		jessModP.setTranslateY(-50);
		jessModP.setTextFill(num.pColor);
		FadeTransition fJessModP = new FadeTransition(Duration.millis(1000),jessModP);
		fJessModP.setFromValue(0);
		fJessModP.setToValue(1);

		
		Label jessSharedKeyValueLabel = new Label();
		jessSharedKeyValueLabel.setTranslateX(-250);
		jessSharedKeyValueLabel.setTranslateY(-50);
		jessSharedKeyValueLabel.setTextFill(num.sharedKeyColor);
		FadeTransition fjessSharedKeyValueLabel = new FadeTransition(Duration.millis(1000),jessSharedKeyValueLabel);
		fjessSharedKeyValueLabel.setFromValue(0);
		fjessSharedKeyValueLabel.setToValue(1);
		
		SequentialTransition jessSeq = new SequentialTransition(fjessLukeKeyLabel, fjessRaisedPrivateLabel,fJessMod, fJessModP, fjessSharedKeyValueLabel);
		generatePane.getChildren().addAll(jessPrivateLabel, jessLukeKeyLabel, jessRaisedPrivateLabel, jessMod, jessModP, jessSharedKeyValueLabel);
		Button jessKeyButton = new Button("Generate Jessica's Shared Key");
		jessKeyButton.setOnAction(e -> {
			{
			jessMod.setText("mod");
			jessModP.setText((Integer.toString((int)num.getP())+ " \u2261 "));
			//double x = Math.pow(3,15) % 17;
			double x = Math.pow(num.getLukeKey(), num.getJessPrivate())%num.getP();
			num.setSharedKey(x);
			jessLukeKeyLabel.setText(Integer.toString((int)num.getLukeKey()));
			jessRaisedPrivateLabel.setText(Integer.toString((int)num.getJessPrivate()));
			jessSharedKeyValueLabel.setText(Integer.toString((int) x));
			jessSeq.play();
			
			}
		});
		jessKeyButton.setTranslateX(-250);
		jessKeyButton.setTranslateY(45);
		
		//Generate Luke Key
		
		Label lukePrivateLabel = new Label();
		lukePrivateLabel.setTranslateX(250);
		lukePrivateLabel.setTranslateX(-350);
		lukePrivateLabel.setTextFill(num.lukePrivateNumberColor);
		lukePrivateLabel.setText(Integer.toString((int)num.getLukePrivate()));
		
		Label lukeJessKeyLabel = new Label();
		lukeJessKeyLabel.setTranslateX(250);
		lukeJessKeyLabel.setTranslateY(-50);
		lukeJessKeyLabel.setTextFill(num.jessSharedKeyColor);
		FadeTransition fLukeJessKeyLabel = new FadeTransition(Duration.millis(1000),lukeJessKeyLabel);
		fLukeJessKeyLabel.setFromValue(0);
		fLukeJessKeyLabel.setToValue(1);
		
		Label lukeRaisedPrivateLabel = new Label();
		lukeRaisedPrivateLabel.setTranslateX(265);
		lukeRaisedPrivateLabel.setTranslateY(-70);
		lukeRaisedPrivateLabel.setTextFill(num.lukePrivateNumberColor);
		FadeTransition fLukeRaisedPrivateLabel = new FadeTransition(Duration.millis(1000),lukeRaisedPrivateLabel);
		fLukeRaisedPrivateLabel.setFromValue(0);
		fLukeRaisedPrivateLabel.setToValue(1);
		
		
		Label lukeMod = new Label();
		lukeMod.setTranslateX(285);
		lukeMod.setTranslateY(-50);
		FadeTransition fLukeMod = new FadeTransition(Duration.millis(1000),lukeMod);
		fLukeMod.setFromValue(0);
		fLukeMod.setToValue(1);
		
		
		Label lukeModP = new Label();
		lukeModP.setTranslateX(315);
		lukeModP.setTranslateY(-50);
		lukeModP.setTextFill(num.pColor);
		FadeTransition fLukeModP = new FadeTransition(Duration.millis(1000),lukeModP);
		fLukeModP.setFromValue(0);
		fLukeModP.setToValue(1);
		
		
		Label lukeSharedKeyValueLabel = new Label();
		lukeSharedKeyValueLabel.setTranslateX(350);
		lukeSharedKeyValueLabel.setTranslateY(-50);
		lukeSharedKeyValueLabel.setTextFill(num.lukeSharedKeyColor);
		FadeTransition fLukeSharedKeyValueLabel = new FadeTransition(Duration.millis(1000),lukeSharedKeyValueLabel);
		fLukeSharedKeyValueLabel.setFromValue(0);
		fLukeSharedKeyValueLabel.setToValue(1);
	
		SequentialTransition lukeSeq = new SequentialTransition(fLukeJessKeyLabel, fLukeRaisedPrivateLabel,fLukeMod, fLukeModP, fLukeSharedKeyValueLabel);
		generatePane.getChildren().addAll(lukePrivateLabel, lukeJessKeyLabel, lukeRaisedPrivateLabel, lukeMod, lukeModP, lukeSharedKeyValueLabel);

		Button lukeKeyButton = new Button("Generate Luke's Key");
		lukeKeyButton.setOnAction(e -> {
			lukeMod.setText("mod");
			lukeModP.setText((Integer.toString((int)num.getP())+ " \u2261 "));
			//double x = Math.pow(3,15) % 17;
			double x = Math.pow(num.getJessKey(), num.getLukePrivate())%num.getP();
			num.setSharedKey(x);
			lukeJessKeyLabel.setText(Integer.toString((int)num.getJessKey()));
			lukeRaisedPrivateLabel.setText(Integer.toString((int)num.getLukePrivate()));
			lukeSharedKeyValueLabel.setText(Integer.toString((int) x));
			lukeSeq.play();
			
		});

//		lukeKeyButton.setTranslateX(250);
//		lukeKeyButton.setTranslateY(45);
		
		
		
		// Layout 2
		
		
		//generatePane.getChildren().addAll(lukeG,lukeModP,lukeGpow, lukeMod);
		//generatePane.getChildren().addAll(jessG,jessModP,jessGpow,jessMod);
		//generatePane.getChildren().add(lukeKeyLabel);
		//generatePane.getChildren().add(lukeTextField);
		generatePane.getChildren().add(lukeKeyButton);
		generatePane.getChildren().add(jessKeyButton);
		generatePane.getChildren().add(backbutton);
		generatePane.getChildren().add(jess);
		generatePane.getChildren().add(luke);
		generatePane.getChildren().add(exchange1Button);
		System.out.print("luke at gen: " + num.lukeKey);
		scene2 = new Scene(generatePane, 800, 800);
		return scene2;
	}

}