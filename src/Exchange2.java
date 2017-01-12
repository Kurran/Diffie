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

public class Exchange2 {

	Scene scene2;
	StackPane generatePane = new StackPane();
	Numbers num = new Numbers();
	int font = 30;
	boolean lukeShared = false;
	boolean jessShared = false;

	public Scene generateScene(Stage stage) {

		Welcome welcomeScene = new Welcome();
		Exchange1 exchange1Scene = new Exchange1();

		Background background = new Background(new BackgroundFill(Color.DARKGREY, CornerRadii.EMPTY, Insets.EMPTY));
		generatePane.setBackground(background);

		// Back Button
		Button backbutton = new Button("Home");
		backbutton.setOnAction(e -> stage.setScene(welcomeScene.scene1(stage)));
		backbutton.setTranslateY(350);

		// Generate G and P
		// g

		Label pLabel = new Label();
		pLabel.setTranslateX(-50);
		pLabel.setTranslateY(-320);
		pLabel.setTextFill(num.pColor);
		pLabel.setText(Integer.toString((int) num.getP()));
		pLabel.setFont(new Font(font));

		Label gLabel = new Label();
		gLabel.setTranslateX(50);
		gLabel.setTranslateY(-320);
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

		generatePane.getChildren().add(jess);
		generatePane.getChildren().add(luke);

		// Fixed Key strings

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

		Label lukeSharedKeyLabel = new Label();
		lukeSharedKeyLabel.setTranslateX(200);
		lukeSharedKeyLabel.setTranslateY(375);
		lukeSharedKeyLabel.setFont(new Font(font));
		lukeSharedKeyLabel.setTextFill(num.lukeSharedKeyColor);
		lukeSharedKeyLabel.setText("Luke's Shared Key = " + Integer.toString((int) num.lukeSharedKey));

		Label lukePrivateKeyLabel = new Label();
		lukePrivateKeyLabel.setTranslateX(200);
		lukePrivateKeyLabel.setTranslateY(340);
		lukePrivateKeyLabel.setFont(new Font(font));
		lukePrivateKeyLabel.setTextFill(num.lukePrivateNumberColor);
		lukePrivateKeyLabel.setText("Luke's Private Key = " + Integer.toString((int) num.getLukePrivate()));
		// adding strings

		generatePane.getChildren().addAll(jessPrivateKeyLabel, jessSharedKeyLabel, lukeSharedKeyLabel,
				lukePrivateKeyLabel);

		// Shared secret Jess Calculation
		Label jessLukeKeyLabel = new Label();
		jessLukeKeyLabel.setTranslateX(-350);
		jessLukeKeyLabel.setTranslateY(-250);
		jessLukeKeyLabel.setText(Integer.toString((int) num.lukeSharedKey));
		jessLukeKeyLabel.setFont(new Font(font));
		jessLukeKeyLabel.setTextFill(num.lukeSharedKeyColor);

		Label jessRaisedPrivateLabel = new Label();
		jessRaisedPrivateLabel.setTranslateX(-330);
		jessRaisedPrivateLabel.setTranslateY(-275);
		jessRaisedPrivateLabel.setFont(new Font(font));
		jessRaisedPrivateLabel.setTextFill(num.jessPrivateNumberColor);
		jessRaisedPrivateLabel.setText(Integer.toString((int) num.jessPrivate));

		Label jessMod = new Label();
		jessMod.setTranslateX(-295);
		jessMod.setTranslateY(-250);
		jessMod.setFont(new Font(font));
		jessMod.setText("mod");

		Label jessModP = new Label();
		jessModP.setTranslateX(-215);
		jessModP.setTranslateY(-250);
		jessModP.setFont(new Font(font));
		jessModP.setTextFill(num.pColor);
		jessModP.setText(Integer.toString((int) num.p) + " = ");

		Label jessSharedKeyValueLabel = new Label();
		jessSharedKeyValueLabel.setTranslateX(-160);
		jessSharedKeyValueLabel.setTranslateY(-250);
		jessSharedKeyValueLabel.setTextFill(num.sharedKeyColor);
		jessSharedKeyValueLabel.setFont(new Font(font));
		jessSharedKeyValueLabel.setText(Integer.toString((int) num.sharedKey));

		// add shared secret jess
		generatePane.getChildren().addAll(jessLukeKeyLabel, jessRaisedPrivateLabel, jessMod, jessModP,
				jessSharedKeyValueLabel);

		// Showing lukes shared secret Key

		Label lukeKeyValueLabel = new Label();
		lukeKeyValueLabel.setTranslateX(190);
		lukeKeyValueLabel.setTranslateY(-150);
		lukeKeyValueLabel.setTextFill(num.lukeSharedKeyColor);
		lukeKeyValueLabel.setFont(new Font(font));
		lukeKeyValueLabel.setText(Integer.toString((int) num.lukeSharedKey) + " = ");

		Label lukeG = new Label();
		lukeG.setTranslateX(240);
		lukeG.setTranslateY(-150);
		lukeG.setTextFill(num.gColor);
		lukeG.setFont(new Font(font));
		lukeG.setText(Integer.toString((int) num.g));

		Label lukeGpow = new Label();
		lukeGpow.setTranslateX(250);
		lukeGpow.setTranslateY(-175);
		lukeGpow.setFont(new Font(font));
		lukeGpow.setTextFill(num.lukePrivateNumberColor);
		lukeGpow.setText(Integer.toString((int) num.lukePrivate));

		Label lukeMod = new Label();
		lukeMod.setTranslateX(295);
		lukeMod.setTranslateY(-150);
		lukeMod.setFont(new Font(font));
		lukeMod.setText("mod");

		Label lukeModP = new Label();
		lukeModP.setTranslateX(345);
		lukeModP.setTranslateY(-150);
		lukeModP.setTextFill(num.pColor);
		lukeModP.setFont(new Font(font));
		lukeModP.setText(Integer.toString((int) num.p));

		// adding lukes to pane

		generatePane.getChildren().addAll(lukeKeyValueLabel, lukeG, lukeGpow, lukeMod, lukeModP);

		Button workButton = new Button("Go");
		workButton.setOnAction(e -> {

		});
		workButton.setTranslateY(-350);
		workButton.setTranslateX(250);

		Label sharedTextLabel = new Label();
		sharedTextLabel.setFont(new Font(font));
		sharedTextLabel.setTranslateY(-350);
		sharedTextLabel.setTranslateX(-150);
		sharedTextLabel.setText("Why does this work? - Consider Jess");
		generatePane.getChildren().addAll(sharedTextLabel, workButton);

		// Layout 2

		// generatePane.getChildren().addAll(lukeG,lukeModP,lukeGpow, lukeMod);
		// generatePane.getChildren().addAll(jessG,jessModP,jessGpow,jessMod);
		// generatePane.getChildren().add(lukeKeyLabel);
		// generatePane.getChildren().add(lukeTextField);
		// generatePane.getChildren().add(backbutton);

		// generatePane.getChildren().add(exchange1Button);
		System.out.print("luke at gen: " + num.lukeKey);
		scene2 = new Scene(generatePane, 800, 800);
		return scene2;
	}

}