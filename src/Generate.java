import java.net.URL;

import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.application.*;
import javafx.geometry.Insets;
import javafx.stage.*;
import javafx.util.Duration;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Generate {

	Scene scene2;

	public double getJesskey() {
		return jesskey;
	}

	public void setJesskey(double jesskey) {
		this.jesskey = jesskey;
	}

	public double getLukekey() {
		return lukekey;
	}

	public void setLukekey(double lukekey) {
		this.lukekey = lukekey;
	}

	double jesskey;
	double lukekey;

	static double lukeKeySend;

	public double getLukeKeySend() {
		return lukeKeySend;
	}

	public void setLukeKeySend(double lukeKeySend) {
		this.lukeKeySend = lukeKeySend;
	}

	public double getJessKeySend() {
		return jessKeySend;
	}

	public void setJessKeySend(double jessKeySend) {
		this.jessKeySend = jessKeySend;
	}

	double jessKeySend;

	public double getG() {
		return g;
	}

	public void setG(double g) {
		this.g = g;
	}

	public double getP() {
		return p;
	}

	public void setP(double p) {
		this.p = p;
	}

	double g;
	double p;

	boolean jessBool = false;
	boolean lukeBool = false;

	static boolean gPicked = false;
	static boolean pPicked = false;

	StackPane generatePane = new StackPane();
	Numbers num = new Numbers();
	
	int font = 30;

	public Scene generateScene(Stage stage) {

		Welcome welcomeScene = new Welcome();
		Exchange1 exchange1Scene = new Exchange1();
		
		Background background = new Background(new BackgroundFill(Color.DARKGREY, CornerRadii.EMPTY, Insets.EMPTY));
		generatePane.setBackground(background);
		
		
		Label explainText = new Label("This is Luke Cage and Jessica Jones, they need to communicate securely, select values of P and G and generate their keys!");
		generatePane.getChildren().add(explainText);
		//explainText.setMaxWidth(350);
		explainText.setWrapText(true);
		explainText.setTranslateY(-350);
		explainText.setFont(new Font(20));
		
		// Back Button
		Button backbutton = new Button("Back");
		backbutton.setOnAction(e -> stage.setScene(welcomeScene.scene1(stage)));
		backbutton.setTranslateY(350);
		
		Button exchange1Button = new Button("Next");
		exchange1Button.setOnAction(e -> {
			if (jessBool && lukeBool){
				stage.setScene(exchange1Scene.Exchange1Scene(stage));
				System.out.print("luke at exchbutn: " + num.lukeKey);
			}
		
		});
		exchange1Button.setTranslateY(-300);


		// Generate G and P
		//g
		TextField gTextField = new TextField();
		gTextField.setTranslateX(250);
		gTextField.setTranslateY(-175);
		gTextField.setMaxWidth(50);

		Label gLabel = new Label();
		gLabel.setTranslateX(250);
		gLabel.setTranslateY(-145);
		gLabel.setTextFill(num.gColor);
		gLabel.setFont(new Font(50));
		
		Label genTextLabel = new Label();
		genTextLabel.setTranslateY(-350);
		genTextLabel.setFont(new Font(20));
		generatePane.getChildren().add(genTextLabel);
		
		Button gbutton = new Button("Set g");
		gbutton.setOnAction(e -> {
			String gStr = gTextField.getText();
			double gTemp = Double.parseDouble(gStr);
			setG(gTemp);
			num.setG(gTemp);
			gLabel.setText("G = " + gStr);
			gPicked = true;
			generatePane.getChildren().remove(gTextField);
			if(pPicked){
				System.out.println("called");
				generatePane.getChildren().remove(explainText);
				genTextLabel.setText("Now generate their keys by choosing a private key!");
			}
		}

		);
		
		

		gbutton.setTranslateX(250);
		gbutton.setTranslateY(-205);
		
		//p
		TextField pTextField = new TextField();
		pTextField.setTranslateX(-250);
		pTextField.setTranslateY(-175);
		pTextField.setMaxWidth(50);

		Label pLabel = new Label();
		pLabel.setTranslateX(-250);
		pLabel.setTranslateY(-145);
		pLabel.setTextFill(num.pColor);
		pLabel.setFont(new Font(50));

		Button pbutton = new Button("Set P");
		pbutton.setOnAction(e -> {
			String pStr = pTextField.getText();
			double pTemp = Double.parseDouble(pStr);
			setP(pTemp);
			pLabel.setText("P = " + pStr);
			pPicked = true;
			generatePane.getChildren().remove(pTextField);
			//generatePane.getChildren().remove(pLabel);
			num.setP(pTemp);
			System.out.println(pPicked);
			if(gPicked){
				System.out.println("called");
				generatePane.getChildren().remove(explainText);
				genTextLabel.setText("Now generate their keys by choosing a private key!");
			}
		}

		);
		
		pbutton.setTranslateX(-250);
		pbutton.setTranslateY(-205);
		
		Line line = new Line();
		line.setStartX(-250);
		line.setStartY(-200);
		line.setEndX(-650);
		line.setEndY(-200);
		line.setTranslateY(200);
		generatePane.getChildren().add(line);
	
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
		TextField jessTextField = new TextField();
		jessTextField.setTranslateX(-250);
		jessTextField.setTranslateY(75);
		jessTextField.setMaxWidth(50);
		
		
	
		Label jessPrivateLabel = new Label();
		jessPrivateLabel.setTranslateX(-250);
		jessPrivateLabel.setTranslateY(350);
		jessPrivateLabel.setTextFill(num.jessPrivateNumberColor);
		jessPrivateLabel.setFont(new Font(22));
		
		Label jessG = new Label();
		jessG.setTranslateX(-350);
		jessG.setTranslateY(-50);
		jessG.setTextFill(num.gColor);
		jessG.setFont(new Font(font));
		FadeTransition fJessG = new FadeTransition(Duration.millis(1000),jessG);
		fJessG.setFromValue(0);
		fJessG.setToValue(1);
		
		Label jessGpow = new Label();
		jessGpow.setTranslateX(-330);
		jessGpow.setTranslateY(-75);
		jessGpow.setFont(new Font(font));
		jessGpow.setTextFill(num.jessPrivateNumberColor);
		FadeTransition fJessGpow = new FadeTransition(Duration.millis(1000),jessGpow);
		fJessGpow.setFromValue(0);
		fJessGpow.setToValue(1);
		
		Label jessMod = new Label();
		jessMod.setTranslateX(-295);
		jessMod.setTranslateY(-50);
		jessMod.setFont(new Font(font));
		FadeTransition fJessMod = new FadeTransition(Duration.millis(1000),jessMod);
		fJessMod.setFromValue(0);
		fJessMod.setToValue(1);
		
		Label jessModP = new Label();
		jessModP.setTranslateX(-215);
		jessModP.setTranslateY(-50);
		jessModP.setTextFill(num.pColor);
		jessModP.setFont(new Font(font));
		FadeTransition fJessModP = new FadeTransition(Duration.millis(1000),jessModP);
		fJessModP.setFromValue(0);
		fJessModP.setToValue(1);
		
		
		
		Label jessKeyValueLabel = new Label();
		jessKeyValueLabel.setTranslateX(-160);
		jessKeyValueLabel.setTranslateY(-50);
		jessKeyValueLabel.setFont(new Font(font));
		jessKeyValueLabel.setTextFill(num.jessSharedKeyColor);
		FadeTransition fJessKeyVal = new FadeTransition(Duration.millis(1000),jessKeyValueLabel);
		fJessKeyVal.setFromValue(0);
		fJessKeyVal.setToValue(1);
		
		SequentialTransition jessSeq = new SequentialTransition(fJessG, fJessGpow,fJessMod, fJessModP, fJessKeyVal);
		
		Button jessKeyButton = new Button("Generate Jessica's Key");
		jessKeyButton.setOnAction(e -> {
			if(gPicked && pPicked){
			String jessStr = jessTextField.getText();
			double jessTemp = Double.parseDouble(jessStr);
			setJesskey(jessTemp);
			jessPrivateLabel.setText("Jessica's Private Number = " + jessStr);
			jessBool = true;
			generatePane.getChildren().remove(jessTextField);
			jessG.setText(Integer.toString((int)getG()));
			jessGpow.setText(jessStr);
			jessMod.setText("mod");
			jessModP.setText(Integer.toString((int)getP())+ " \u2261 ");
			//double x = Math.pow(3,15) % 17;
			double x = Math.pow(getG(), getJesskey())%getP();
			setJessKeySend(x);
			jessKeyValueLabel.setText(Integer.toString((int)x));
			num.setJessKey(x);
			num.setJessPrivate(jessTemp);
			jessSeq.play();
			num.setJessSharedKey(x);
			
			}
		});
		jessKeyButton.setTranslateX(-250);
		jessKeyButton.setTranslateY(45);
		
		//Generate Luke Key
		
		Label lukePrivateKeyLabel = new Label();
		lukePrivateKeyLabel.setTranslateX(250);
		lukePrivateKeyLabel.setTranslateY(350);
		lukePrivateKeyLabel.setTextFill(num.lukePrivateNumberColor);
		lukePrivateKeyLabel.setFont(new Font(20));
		
		
		TextField lukeTextField = new TextField();
		lukeTextField.setTranslateX(250);
		lukeTextField.setTranslateY(75);
		lukeTextField.setMaxWidth(50);
		
		

		Label lukeG = new Label();
		lukeG.setTranslateX(190);
		lukeG.setTranslateY(-50);
		lukeG.setTextFill(num.gColor);
		lukeG.setFont(new Font(font));
		FadeTransition fLukeG = new FadeTransition(Duration.millis(1000),lukeG);
		fLukeG.setFromValue(0);
		fLukeG.setToValue(1);
		
		Label lukeGpow = new Label();
		lukeGpow.setTranslateX(210);
		lukeGpow.setTranslateY(-75);
		lukeGpow.setFont(new Font(font));
		lukeGpow.setTextFill(num.lukePrivateNumberColor);
		FadeTransition fLukeGpow = new FadeTransition(Duration.millis(1000),lukeGpow);
		fLukeGpow.setFromValue(0);
		fLukeGpow.setToValue(1);
		
		
		Label lukeMod = new Label();
		lukeMod.setTranslateX(245);
		lukeMod.setTranslateY(-50);
		lukeMod.setFont(new Font(font));
		FadeTransition fLukeMod = new FadeTransition(Duration.millis(1000),lukeMod);
		fLukeMod.setFromValue(0);
		fLukeMod.setToValue(1);
		
		
		Label lukeModP = new Label();
		lukeModP.setTranslateX(325);
		lukeModP.setTranslateY(-50);
		lukeModP.setTextFill(num.pColor);
		lukeModP.setFont(new Font(font));
		FadeTransition fLukeModP = new FadeTransition(Duration.millis(1000),lukeModP);
		fLukeModP.setFromValue(0);
		fLukeModP.setToValue(1);
		
		
		Label lukeKeyValueLabel = new Label();
		lukeKeyValueLabel.setTranslateX(370);
		lukeKeyValueLabel.setTranslateY(-50);
		lukeKeyValueLabel.setTextFill(num.lukeSharedKeyColor);
		lukeKeyValueLabel.setFont(new Font(font));
		FadeTransition fLukeKeyVal = new FadeTransition(Duration.millis(1000),lukeKeyValueLabel);
		fLukeKeyVal.setFromValue(0);
		fLukeKeyVal.setToValue(1);
		
		SequentialTransition lukeSeq = new SequentialTransition(fLukeG, fLukeGpow,fLukeMod, fLukeModP, fLukeKeyVal);
		
		Button lukeKeyButton = new Button("Generate Luke's Key");
		lukeKeyButton.setOnAction(e -> {
			if(gPicked && pPicked){
			String lukeStr = lukeTextField.getText();
			double lukeTemp = Double.parseDouble(lukeStr);
			setLukekey(lukeTemp);
			lukePrivateKeyLabel.setText("Luke's Private Number = " + lukeStr);
			lukeBool = true;
			generatePane.getChildren().remove(lukeTextField);
			lukeG.setText(Integer.toString((int)getG()));
			lukeGpow.setText(lukeStr);
			lukeMod.setText("mod");
			lukeModP.setText(Integer.toString((int)getP()) + " \u2261 ");
			//double x = Math.pow(3,15) % 17;
			double x = Math.pow(getG(), getLukekey())%getP();
			setLukeKeySend(x);
			num.setLukeSharedKey(x);
			lukeKeyValueLabel.setText(Integer.toString((int)x));
			num.setLukeKey(x);
			num.setLukePrivate(lukeTemp);
			System.out.print("luke at button: " + num.lukeKey);
			lukeSeq.play();
			}
		});

		lukeKeyButton.setTranslateX(250);
		lukeKeyButton.setTranslateY(45);
		
		
		
		// Layout 2
		
		generatePane.getChildren().addAll(lukeKeyValueLabel,jessKeyValueLabel);
		generatePane.getChildren().addAll(lukeG,lukeModP,lukeGpow, lukeMod);
		generatePane.getChildren().addAll(jessG,jessModP,jessGpow,jessMod);
		generatePane.getChildren().add(pbutton);
		generatePane.getChildren().add(gbutton);
		generatePane.getChildren().add(pTextField);
		generatePane.getChildren().add(gTextField);
		generatePane.getChildren().add(pLabel);
		generatePane.getChildren().add(gLabel);
		generatePane.getChildren().add(jessPrivateLabel);
		generatePane.getChildren().add(lukePrivateKeyLabel);
		generatePane.getChildren().add(jessTextField);
		generatePane.getChildren().add(lukeTextField);
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
