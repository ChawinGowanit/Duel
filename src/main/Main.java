package main;




import application.GameController;
import gui.AttackPane;
import gui.HowToPlayPane;
import gui.MainPane;
import gui.PlacePane;
import gui.PlayerPane;
import javafx.animation.Animation;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
	public Scene scene, gameScene;
	public static ImageView startBtnImageView;
	public static ImageView howtoPlayImgView ;
	public static MainPane mainPane;
	public static PlacePane placePane;
	public static PlayerPane player1Pane;
	public static PlayerPane player2Pane;
	public static AttackPane atkPane;
	public static Pane gamePhase;
	public static Pane endPhase;
	public static MediaPlayer mediaPlayer;
	public static Stage primaryStage = new Stage();
	public static boolean endGame = false;

	public void start(Stage primaryStage) {
		Pane startingGame = new Pane();
		Scene scene = new Scene(startingGame, 1920, 1080);
		primaryStage.setTitle("Arknight Duel");
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.sizeToScene();
		primaryStage.setFullScreen(true);
		startingGame.setBackground(new Background(new BackgroundImage(
				new Image("/startingUI/startBg.png", 1920, 1080, false, true), BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
		Image startBtnImg = new Image("/startingUI/startBtn.png");
		startBtnImageView = new ImageView(startBtnImg);
		startBtnImageView.setFitHeight(147);
		startBtnImageView.setFitWidth(1180);
		startBtnImageView.setY(700);
		startBtnImageView.setX(350);
		Image setNameImg = new Image("/startingUI/setName.png");
		ImageView setNameImageView = new ImageView(setNameImg);
		setNameImageView.setVisible(false);
		setNameImageView.setFitHeight(250);
		setNameImageView.setFitWidth(1180);
		setNameImageView.setX(350);
		setNameImageView.setY(650);
		TextField player1Name = new TextField("Press Enter when finish");
		player1Name.setPrefHeight(50);
		player1Name.setPrefWidth(600);
		player1Name.setLayoutX(800);
		player1Name.setLayoutY(720);
		player1Name.setVisible(false);
		TextField player2Name = new TextField("Press Enter when finish");
		player2Name.setPrefHeight(50);
		player2Name.setPrefWidth(600);
		player2Name.setLayoutX(800);
		player2Name.setLayoutY(795);
		player2Name.setVisible(false);
		player2Name.setDisable(true);
		Image howtoPlayImg = new Image("/startingUI/howtoPlayBtn.png");
		howtoPlayImgView = new ImageView(howtoPlayImg);
		howtoPlayImgView.setFitHeight(117);
		howtoPlayImgView.setFitWidth(588);
		howtoPlayImgView.setY(875);
		howtoPlayImgView.setX(650);
		howtoPlayImgView.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				playSound();
				startBtnImageView.setDisable(true);
				howtoPlayImgView.setDisable(true);
				HowToPlayPane howToPlayPane = new HowToPlayPane();
				howToPlayPane.setLayoutX(300);
				howToPlayPane.setLayoutY(200);
				startingGame.getChildren().add(howToPlayPane);
				
			}
		});
		howtoPlayImgView.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				Image MouseOnmouseOnhowToPlayBtnImg = new Image("/startingUI/mouseOnhowToPlayBtn.png");
				howtoPlayImgView.setImage(MouseOnmouseOnhowToPlayBtnImg);
			}
		});
		howtoPlayImgView.setOnMouseExited(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				playSound();
				howtoPlayImgView.setImage(howtoPlayImg);
			}
		});
		player1Name.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				// TODO Auto-generated method stub
				player1Name.clear();
			}
		});
		player1Name.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent keyEvent) {
				// TODO Auto-generated method stub
				if (keyEvent.getCode().equals(KeyCode.ENTER)) {
					playSound();
					GameController.player1.setName(player1Name.getText());
					player1Name.setDisable(true);
					player2Name.setDisable(false);
				}
			}
		});
		player2Name.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				// TODO Auto-generated method stub
				player2Name.clear();
			}
		});
		startBtnImageView.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				Image MouseOnStartBtnImg = new Image("/startingUI/mouseOnStartBtn.png");
				startBtnImageView.setImage(MouseOnStartBtnImg);
			}
		});
		startBtnImageView.setOnMouseExited(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				playSound();
				Image MouseOnStartBtnImg = new Image("/startingUI/startBtn.png");
				startBtnImageView.setImage(MouseOnStartBtnImg);
			}
		});
		startBtnImageView.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				howtoPlayImgView.setVisible(false);
				startBtnImageView.setVisible(false);
				setNameImageView.setVisible(true);
				player1Name.setVisible(true);
				player2Name.setVisible(true);

			}

		});
		startingGame.getChildren().addAll(startBtnImageView, setNameImageView, player1Name, player2Name,howtoPlayImgView);
		// after entered player2 name go to next scene
		player2Name.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent keyEvent) {
				// TODO Auto-generated method stub
				if (keyEvent.getCode().equals(KeyCode.ENTER)) {
					playSound();
					GameController.player2.setName(player2Name.getText());
					GameController.initializeGame(); // addCardOnBoard 3 phase and firstUpdate
					primaryStage.setScene(creatGameScene());
					primaryStage.show();
					primaryStage.sizeToScene();
					primaryStage.setFullScreen(true);

				}
			}
		});
	}

	public static void main(String[] args) {
		launch(args);
	}

	public static Scene creatGameScene() {
		Media musicFile = new Media(ClassLoader.getSystemResource("bgm.mp3").toString());
		MediaPlayer bgm = new MediaPlayer(musicFile);
		mediaPlayer = bgm;
		mediaPlayer.setAutoPlay(true);
		mediaPlayer.setCycleCount(Animation.INDEFINITE);
		mediaPlayer.setVolume(0.1);

		gamePhase = new Pane();
		gamePhase.setPrefSize(1920, 1080);
		gamePhase.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));

		player1Pane = new PlayerPane(1);
		player1Pane.setLayoutX(0);
		player1Pane.setLayoutY(50);
		player1Pane.UpdatePlayerPane(1);

		player2Pane = new PlayerPane(2);
		player2Pane.setLayoutX(1650);
		player2Pane.setLayoutY(50);
		player2Pane.UpdatePlayerPane(2);

		player1Pane.updatePlayerPaneScreen();
		player2Pane.updatePlayerPaneScreen();

		placePane = new PlacePane();
		placePane.setLayoutX(225);
		placePane.setLayoutY(810);

		atkPane = new AttackPane();
		atkPane.setLayoutX(0);
		atkPane.setLayoutY(982);

		gamePhase.getChildren().addAll(player1Pane, player2Pane, placePane, atkPane);
		newMainPane(1);
		Scene gameScene = new Scene(gamePhase, 1920, 1080);
		return gameScene;
	}

	public static void newMainPane(int phase) {
		// TODO Auto-generated method stub
		mainPane = new MainPane(phase);
		mainPane.setLayoutX(300);
		mainPane.setLayoutY(0);
		gamePhase.getChildren().add(mainPane);
		GameController.mainBoard.updateCardOnBoard(GameController.getPhase());
		mainPane.updateCardOnPane();
		mainPane.updatePickableCardOnPane(GameController.getPhase());

	}

	public void playSound() {
		Media musicFile = new Media(ClassLoader.getSystemResource("buttonClickSound.mp3").toString());
		MediaPlayer buttonClick = new MediaPlayer(musicFile);
		mediaPlayer = buttonClick;
		mediaPlayer.setAutoPlay(true);
		mediaPlayer.setVolume(1);
	}
}
