import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Generate2 {

	Scene scene2;
	StackPane generatePane = new StackPane();
	Numbers num = new Numbers();
	int font = 30;
	boolean lukeShared = false;
	boolean jessShared = false;
	Exchange2 exchange2 = new Exchange2();

	public Scene generateScene(Stage stage) {

		Welcome welcomeScene = new Welcome();
		Exchange1 exchange1Scene = new Exchange1();

		Background background = new Background(new BackgroundFill(Color.DARKGREY, CornerRadii.EMPTY, Insets.EMPTY));
		generatePane.setBackground(background);

		Button nextButton = new Button("Next");
		nextButton.setOnAction(e -> stage.setScene(exchange2.generateScene(stage)));
		generatePane.getChildren().add(nextButton);

		// Back Button
		Button backbutton = new Button("Home");
		backbutton.setOnAction(e -> stage.setScene(welcomeScene.scene1(stage)));
		backbutton.setTranslateY(350);

		Label sharedTextLabel = new Label();
		sharedTextLabel.setFont(new Font(font));
		sharedTextLabel.setTranslateY(-350);
		sharedTextLabel.setText("Generate..");
		generatePane.getChildren().add(sharedTextLabel);

		// Generate G and P
		// g

		Label pLabel = new Label();
		pLabel.setTranslateX(-50);
		pLabel.setTranslateY(-145);
		pLabel.setTextFill(num.pColor);
		pLabel.setText(Integer.toString((int) num.getP()));
		pLabel.setFont(new Font(font));

		Label gLabel = new Label();
		gLabel.setTranslateX(50);
		gLabel.setTranslateY(-145);
		gLabel.setTextFill(num.gColor);
		gLabel.setText(Integer.toString((int) num.getG()));
		gLabel.setFont(new Font(font));
		generatePane.getChildren().addAll(gLabel, pLabel);

		Line line = new Line();
		line.setStartX(-250);
		line.setStartY(-200);
		line.setEndX(-650);
		line.setEndY(-200);
		line.setTranslateY(200);
		generatePane.getChildren().add(line);

		// Images
		// URL url = this.getClass().getResourceAsStream("/luke.jpg");
		Image lukeRead = new Image(this.getClass().getResourceAsStream("/luke.jpg"), 200, 200, false, false);
		ImageView luke = new ImageView(lukeRead);
		luke.setTranslateX(250);
		luke.setTranslateY(200);

		Image jessRead = new Image(this.getClass().getResourceAsStream("/jess.jpg"), 200, 200, false, false);
		ImageView jess = new ImageView(jessRead);
		jess.setTranslateX(-250);
		jess.setTranslateY(200);

		// Generate Jess Key

		Label jessPrivateKeyLabel = new Label();
		jessPrivateKeyLabel.setTranslateX(-200);
		jessPrivateKeyLabel.setTranslateY(340);
		jessPrivateKeyLabel.setFont(new Font(font));
		jessPrivateKeyLabel.setTextFill(num.jessPrivateNumberColor);
		jessPrivateKeyLabel.setText("Jessica's Private Key =  " + Integer.toString((int) num.getJessPrivate()));

		Label jessSharedKeyLabel = new Label();
		jessSharedKeyLabel.setTranslateX(-200);
		jessSharedKeyLabel.setTranslateY(375);
		jessSharedKeyLabel.setFont(new Font(font));
		jessSharedKeyLabel.setTextFill(num.jessSharedKeyColor);
		jessSharedKeyLabel.setText("Jessica's Shared Key = " + Integer.toString((int) num.getJessKey()));

		Label jessLukeKeyLabel = new Label();
		jessLukeKeyLabel.setTranslateX(-350);
		jessLukeKeyLabel.setTranslateY(-50);
		jessLukeKeyLabel.setFont(new Font(font));
		jessLukeKeyLabel.setTextFill(num.lukeSharedKeyColor);
		FadeTransition fjessLukeKeyLabel = new FadeTransition(Duration.millis(1000), jessLukeKeyLabel);
		fjessLukeKeyLabel.setFromValue(0);
		fjessLukeKeyLabel.setToValue(1);

		Label jessRaisedPrivateLabel = new Label();
		jessRaisedPrivateLabel.setTranslateX(-330);
		jessRaisedPrivateLabel.setTranslateY(-75);
		jessRaisedPrivateLabel.setFont(new Font(font));
		jessRaisedPrivateLabel.setTextFill(num.jessPrivateNumberColor);
		FadeTransition fjessRaisedPrivateLabel = new FadeTransition(Duration.millis(1000), jessRaisedPrivateLabel);
		fjessRaisedPrivateLabel.setFromValue(0);
		fjessRaisedPrivateLabel.setToValue(1);

		Label jessMod = new Label();
		jessMod.setTranslateX(-295);
		jessMod.setTranslateY(-50);
		jessMod.setFont(new Font(font));
		FadeTransition fJessMod = new FadeTransition(Duration.millis(1000), jessMod);
		fJessMod.setFromValue(0);
		fJessMod.setToValue(1);

		Label jessModP = new Label();
		jessModP.setTranslateX(-215);
		jessModP.setTranslateY(-50);
		jessModP.setFont(new Font(font));
		jessModP.setTextFill(num.pColor);
		FadeTransition fJessModP = new FadeTransition(Duration.millis(1000), jessModP);
		fJessModP.setFromValue(0);
		fJessModP.setToValue(1);

		Label jessSharedKeyValueLabel = new Label();
		jessSharedKeyValueLabel.setTranslateX(-160);
		jessSharedKeyValueLabel.setTranslateY(-50);
		jessSharedKeyValueLabel.setTextFill(num.sharedKeyColor);
		jessSharedKeyValueLabel.setFont(new Font(font));
		FadeTransition fjessSharedKeyValueLabel = new FadeTransition(Duration.millis(1000), jessSharedKeyValueLabel);
		fjessSharedKeyValueLabel.setFromValue(0);
		fjessSharedKeyValueLabel.setToValue(1);

		SequentialTransition jessSeq = new SequentialTransition(fjessLukeKeyLabel, fjessRaisedPrivateLabel, fJessMod,
				fJessModP, fjessSharedKeyValueLabel);
		generatePane.getChildren().addAll(jessPrivateKeyLabel, jessSharedKeyLabel, jessLukeKeyLabel,
				jessRaisedPrivateLabel, jessMod, jessModP, jessSharedKeyValueLabel);
		Button jessKeyButton = new Button("Generate Jessica's Shared Key");
		jessKeyButton.setOnAction(e -> {
			{
				jessMod.setText("mod");
				jessModP.setText((Integer.toString((int) num.getP()) + " \u2261 "));
				// double x = Math.pow(3,15) % 17;
				double x = Math.pow(num.getLukeKey(), num.getJessPrivate()) % num.getP();
				num.setSharedKey(x);
				jessLukeKeyLabel.setText(Integer.toString((int) num.getLukeKey()));
				jessRaisedPrivateLabel.setText(Integer.toString((int) num.getJessPrivate()));
				jessSharedKeyValueLabel.setText(Integer.toString((int) x));
				jessSeq.play();
				jessShared = true;
				if (lukeShared) {
					sharedTextLabel.setText("They have generated the same shared Key!");
				}

			}
		});
		jessKeyButton.setTranslateX(-250);
		jessKeyButton.setTranslateY(45);

		// Generate Luke Key

		Label lukeSharedKeyLabel = new Label();
		lukeSharedKeyLabel.setTranslateX(200);
		lukeSharedKeyLabel.setTranslateY(375);
		lukeSharedKeyLabel.setFont(new Font(font));
		lukeSharedKeyLabel.setTextFill(num.lukeSharedKeyColor);
		lukeSharedKeyLabel.setText("Luke's Shared Key = " + Integer.toString((int) num.getLukeKey()));

		Label lukePrivateKeyLabel = new Label();
		lukePrivateKeyLabel.setTranslateX(200);
		lukePrivateKeyLabel.setTranslateY(340);
		lukePrivateKeyLabel.setFont(new Font(font));
		lukePrivateKeyLabel.setTextFill(num.lukePrivateNumberColor);
		lukePrivateKeyLabel.setText("Luke's Private Key = " + Integer.toString((int) num.getLukePrivate()));

		Label lukeJessKeyLabel = new Label();
		lukeJessKeyLabel.setTranslateX(190);
		lukeJessKeyLabel.setTranslateY(-50);
		lukeJessKeyLabel.setFont(new Font(font));
		lukeJessKeyLabel.setTextFill(num.jessSharedKeyColor);
		FadeTransition fLukeJessKeyLabel = new FadeTransition(Duration.millis(1000), lukeJessKeyLabel);
		fLukeJessKeyLabel.setFromValue(0);
		fLukeJessKeyLabel.setToValue(1);

		Label lukeRaisedPrivateLabel = new Label();
		lukeRaisedPrivateLabel.setTranslateX(210);
		lukeRaisedPrivateLabel.setTranslateY(-70);
		lukeRaisedPrivateLabel.setTextFill(num.lukePrivateNumberColor);
		lukeRaisedPrivateLabel.setFont(new Font(font));
		FadeTransition fLukeRaisedPrivateLabel = new FadeTransition(Duration.millis(1000), lukeRaisedPrivateLabel);
		fLukeRaisedPrivateLabel.setFromValue(0);
		fLukeRaisedPrivateLabel.setToValue(1);

		Label lukeMod = new Label();
		lukeMod.setTranslateX(245);
		lukeMod.setTranslateY(-50);
		lukeMod.setFont(new Font(font));
		FadeTransition fLukeMod = new FadeTransition(Duration.millis(1000), lukeMod);
		fLukeMod.setFromValue(0);
		fLukeMod.setToValue(1);

		Label lukeModP = new Label();
		lukeModP.setTranslateX(325);
		lukeModP.setTranslateY(-50);
		lukeModP.setFont(new Font(font));
		lukeModP.setTextFill(num.pColor);
		FadeTransition fLukeModP = new FadeTransition(Duration.millis(1000), lukeModP);
		fLukeModP.setFromValue(0);
		fLukeModP.setToValue(1);

		Label lukeSharedKeyValueLabel = new Label();
		lukeSharedKeyValueLabel.setTranslateX(370);
		lukeSharedKeyValueLabel.setTranslateY(-50);
		lukeSharedKeyValueLabel.setFont(new Font(font));
		lukeSharedKeyValueLabel.setTextFill(num.sharedKeyColor);
		FadeTransition fLukeSharedKeyValueLabel = new FadeTransition(Duration.millis(1000), lukeSharedKeyValueLabel);
		fLukeSharedKeyValueLabel.setFromValue(0);
		fLukeSharedKeyValueLabel.setToValue(1);

		SequentialTransition lukeSeq = new SequentialTransition(fLukeJessKeyLabel, fLukeRaisedPrivateLabel, fLukeMod,
				fLukeModP, fLukeSharedKeyValueLabel);
		generatePane.getChildren().addAll(lukePrivateKeyLabel, lukeSharedKeyLabel, lukeJessKeyLabel,
				lukeRaisedPrivateLabel, lukeMod, lukeModP, lukeSharedKeyValueLabel);

		Button lukeKeyButton = new Button("Generate Luke's Key");
		lukeKeyButton.setOnAction(e -> {
			lukeMod.setText("mod");
			lukeModP.setText((Integer.toString((int) num.getP()) + " \u2261 "));
			// double x = Math.pow(3,15) % 17;
			double x = Math.pow(num.getJessKey(), num.getLukePrivate()) % num.getP();
			num.setSharedKey(x);
			lukeJessKeyLabel.setText(Integer.toString((int) num.getJessKey()));
			lukeRaisedPrivateLabel.setText(Integer.toString((int) num.getLukePrivate()));
			lukeSharedKeyValueLabel.setText(Integer.toString((int) x));
			lukeSeq.play();
			lukeShared = true;
			if (jessShared) {
				sharedTextLabel.setText("They have generated the same shared Key!");
			}

		});

		lukeKeyButton.setTranslateX(250);
		lukeKeyButton.setTranslateY(45);

		// Layout 2

		// generatePane.getChildren().addAll(lukeG,lukeModP,lukeGpow, lukeMod);
		// generatePane.getChildren().addAll(jessG,jessModP,jessGpow,jessMod);
		// generatePane.getChildren().add(lukeKeyLabel);
		// generatePane.getChildren().add(lukeTextField);
		generatePane.getChildren().add(lukeKeyButton);
		generatePane.getChildren().add(jessKeyButton);
		generatePane.getChildren().add(backbutton);
		generatePane.getChildren().add(jess);
		generatePane.getChildren().add(luke);
		// generatePane.getChildren().add(exchange1Button);
		System.out.print("luke at gen: " + num.lukeKey);
		scene2 = new Scene(generatePane, 800, 800);
		return scene2;
	}

}