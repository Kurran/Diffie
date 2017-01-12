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

public class Exchange1 {
	
	Scene scene2;
	Numbers num = new Numbers();
	Generate2 gen2 = new Generate2();
	int font = 30;

	public Scene Exchange1Scene(Stage stage){
	
			
		
	StackPane layout2 = new StackPane();
	Welcome scene1 = new Welcome();
	Background background = new Background(new BackgroundFill(Color.DARKGREY, CornerRadii.EMPTY, Insets.EMPTY));
	layout2.setBackground(background);
	
	//Button 2
    Button Next = new Button("Next");
    Next.setOnAction(e -> stage.setScene(gen2.generateScene(stage)));
    //Next.setTranslateY(300);
    
    Button homeButton = new Button("Home");
    homeButton.setOnAction(e -> stage.setScene(scene1.scene1(stage)));
    homeButton.setTranslateY(300);
    

	Label pLabel = new Label();
	pLabel.setTranslateX(-50);
	pLabel.setTranslateY(-145);
	pLabel.setTextFill(num.pColor);
	pLabel.setText(Integer.toString((int)num.getP()));
	pLabel.setFont(new Font(font));
	
	Label gLabel = new Label();
	gLabel.setTranslateX(50);
	gLabel.setTranslateY(-145);
	gLabel.setTextFill(num.gColor);
	gLabel.setText(Integer.toString((int)num.getG()));
	gLabel.setFont(new Font(font));
    
    Label lukeKeyLabel = new Label();
    lukeKeyLabel.setTranslateX(200);
    lukeKeyLabel.setFont(new Font(font));
    lukeKeyLabel.setTextFill(num.lukeSharedKeyColor);
    lukeKeyLabel.setText(Integer.toString((int)num.getLukeKey()));
    
    Label lukeSharedKeyLabel = new Label();
    lukeSharedKeyLabel.setTranslateX(200);
    lukeSharedKeyLabel.setTranslateY(375);
    lukeSharedKeyLabel.setFont(new Font(font));
    lukeSharedKeyLabel.setTextFill(num.lukeSharedKeyColor);
    lukeSharedKeyLabel.setText("Luke's Shared Key = " + Integer.toString((int)num.getLukeKey()));
    
    Label lukePrivateKeyLabel = new Label();
    lukePrivateKeyLabel.setTranslateX(200);
    lukePrivateKeyLabel.setTranslateY(340);
    lukePrivateKeyLabel.setFont(new Font(font));
    lukePrivateKeyLabel.setTextFill(num.lukePrivateNumberColor);
    lukePrivateKeyLabel.setText("Luke's Private Key = " + Integer.toString((int)num.getLukePrivate()));
    
    Label jessKeyLabel = new Label();
    jessKeyLabel.setTranslateX(-200);
    jessKeyLabel.setTextFill(num.jessSharedKeyColor);
    jessKeyLabel.setFont(new Font(font));
    jessKeyLabel.setText(Integer.toString((int)num.getJessKey()));
    
    Label jessPrivateKeyLabel = new Label();
    jessPrivateKeyLabel.setTranslateX(-200);
    jessPrivateKeyLabel.setTranslateY(340);
    jessPrivateKeyLabel.setFont(new Font(font));
    jessPrivateKeyLabel.setTextFill(num.jessPrivateNumberColor);
    jessPrivateKeyLabel.setText("Jessica's Private Key =  " +Integer.toString((int)num.getJessPrivate()));
    
    Label jessSharedKeyLabel = new Label();
    jessSharedKeyLabel.setTranslateX(-200);
    jessSharedKeyLabel.setTranslateY(375);
    jessSharedKeyLabel.setFont(new Font(font));
    jessSharedKeyLabel.setTextFill(num.jessSharedKeyColor);
    jessSharedKeyLabel.setText("Jessica's Shared Key = " + Integer.toString((int)num.getJessKey()));
    
    //Layout 2
   
    Line line = new Line();
	line.setStartX(-250);
	line.setStartY(-200);
	line.setEndX(-650);
	line.setEndY(-200);
	line.setTranslateY(200);
	layout2.getChildren().add(line);
    
    
    Image image = new Image(this.getClass().getResourceAsStream("/luke.jpg"), 200, 200, false, false);
    ImageView imgView = new ImageView(image);
    imgView.setTranslateX(250);
    imgView.setTranslateY(200);
    Image image1 = new Image(this.getClass().getResourceAsStream("/jess.jpg"), 200, 200, false, false);
    ImageView imgView1 = new ImageView(image1);
    imgView1.setTranslateX(-250);
    imgView1.setTranslateY(200);
    
    
	TranslateTransition jt = new TranslateTransition(Duration.millis(1000), jessKeyLabel);
	TranslateTransition lt = new TranslateTransition(Duration.millis(1000), lukeKeyLabel);
	jt.setByX(400);
	lt.setByX(-400);
	
    
    Button exchange = new Button("Exchange");
    exchange.setOnAction(e -> {
    	jt.play();
    	lt.play();
    	layout2.getChildren().add(Next);
    });
    exchange.setTranslateY(-300);
    
    layout2.getChildren().addAll(lukeKeyLabel, jessKeyLabel, jessPrivateKeyLabel, lukePrivateKeyLabel, jessSharedKeyLabel, lukeSharedKeyLabel, pLabel, gLabel);
    layout2.getChildren().add(exchange);
    //layout2.getChildren().add(t);
    layout2.getChildren().add(imgView);
    layout2.getChildren().add(imgView1);
   
    
	System.out.print("luke at exch: " + num.lukeKey);
    
    scene2 = new Scene(layout2, 800, 800);
    return scene2;
	}
}
