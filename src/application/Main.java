package application;

import logic.Turn;
import logic.exception.PickCardFailException;

import java.util.List;
import java.util.Scanner;

import Card.base.Cost;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application{
	private static int step = 1;
	public void start(Stage primaryStage) {
		Scene scene = new Scene(getPane(step),1540,868);
		primaryStage.setTitle("Arknight Duel");
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
		primaryStage.show();
		primaryStage.setFullScreen(true);
}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public Pane getPane(int step) {
		switch (step) {
		case 1:
			Pane startingGame = new Pane();
			startingGame.setBackground(new Background(new BackgroundImage(new Image("/startingUI/startBg.png",1540,868,false,true),
			        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
			          BackgroundSize.DEFAULT)));	
			Image startBtnImg = new Image("/startingUI/startBtn.png");
			ImageView startBtnImageView = new ImageView(startBtnImg);
			startBtnImageView.setFitHeight(147);
			startBtnImageView.setFitWidth(1180);
			startBtnImageView.setY(600);
			startBtnImageView.setX(175);
			Image setNameImg = new Image("/startingUI/setName.png");
			ImageView setNameImageView = new ImageView(setNameImg);
			setNameImageView.setVisible(false);
			setNameImageView.setFitHeight(250);
			setNameImageView.setFitWidth(1180);
			setNameImageView.setX(175);
			setNameImageView.setY(550);
			TextField player1Name = new TextField("Press Enter when finish");
			player1Name.setPrefHeight(50);
			player1Name.setPrefWidth(600);
			player1Name.setLayoutX(600);
			player1Name.setLayoutY(620);
			player1Name.setVisible(false);
			TextField player2Name = new TextField("Press Enter when finish");
			player2Name.setPrefHeight(50);
			player2Name.setPrefWidth(600);
			player2Name.setLayoutX(600);
			player2Name.setLayoutY(695);
			player2Name.setVisible(false);
			player2Name.setDisable(true);
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
						GameController.player1.setName(player1Name.getText());
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
			player2Name.setOnKeyPressed(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent keyEvent) {
					// TODO Auto-generated method stub
					if (keyEvent.getCode().equals(KeyCode.ENTER)) {
						GameController.player2.setName(player2Name.getText());
					}
				}
			});
			startBtnImageView.setOnMouseEntered(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					Image MouseOnStartBtnImg = new Image("/startingUI/mouseOnStartBtn.png");
					startBtnImageView.setImage(MouseOnStartBtnImg);
				}
			});
			startBtnImageView.setOnMouseExited(new EventHandler<MouseEvent>(){
				@Override
				public void handle(MouseEvent event) {
					// TODO Auto-generated method stub
					startBtnImageView.setImage(startBtnImg);

				}
			});
			startBtnImageView.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent arg0) {
					// TODO Auto-generated method stub
					startBtnImageView.setVisible(false);
					setNameImageView.setVisible(true);
					player1Name.setVisible(true);
					player2Name.setVisible(true);
				}
				
			});
			startingGame.getChildren().addAll(startBtnImageView,setNameImageView,player1Name,player2Name) ;
			return startingGame;
		case 2 :
			Pane gamePhase = new Pane();
			gamePhase.setBackground(new Background(new BackgroundImage(new Image("/gameUI/gameUI.png",1540,868,false,true),
			        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
			          BackgroundSize.DEFAULT)));
			
			
			return gamePhase;
		default :
			return null ;
		}
		
	}
}

/*
	public static void main(String args[]) throws PickCardFailException {
		Scanner keyboard = new Scanner(System.in);
		// set player name
		System.out.println("=====Start Game=====");
		System.out.println("please input player1 name");
		String playeOneName = keyboard.nextLine();
		GameController.player1.setName(playeOneName);
		System.out.println("Player1 : " + GameController.player1.getName());
		System.out.println(
				GameController.player1.getName() + "'s resources :" + GameController.player1.getResourceCounter());
		System.out.println("please input player2 name");
		String playeTwoName = keyboard.nextLine();
		GameController.player2.setName(playeTwoName);
		System.out.println("Player2 : " + GameController.player2.getName());
		System.out.println(
				GameController.player2.getName() + "'s resources :" + GameController.player2.getResourceCounter());
		============================================finish!!!=======================================================
		GameController.InitializeGame(); // addCardOnBoard 3 phase and firstUpdate

		while (!GameController.endGame || (GameController.ATKboard.getPosition() == 9)
				|| GameController.ATKboard.getPosition() == -9) {
			if (Turn.getPlayerTurn() == 1) {
				System.out.println("-----" + GameController.player1.getName() + "'s Turn" + "-----");
			} else {
				System.out.println("-----" + GameController.player2.getName() + "'s Turn" + "-----");
			}
			GameController.mainBoard.updateCardOnBoard(GameController.getPhase());
			System.out.println(GameController.placeBoard.getPlaceCardOnBoard());
			System.out.println(GameController.mainBoard.getCardOnBoard(GameController.getPhase()));
			System.out.println("Type card you want to pick");
			String card = keyboard.nextLine();
			try {
				Turn.setSelectedCard(GameController.mainBoard.getCardFromName(card, GameController.getPhase()));
				System.out.println("select action [build,sell,buildPlace,cancel]:");
				String action = keyboard.nextLine();

				switch (action) {
				case "build":
					if (Turn.buildController()) {
						System.out.println("Spend "
								+ Cost.checkLmd(GameController.getCurrentPlayer().getResourceCounter(),
										Turn.getSelectedCard().getCost(),
										GameController.getCurrentPlayer().getbuyResourceCost())
								+ " LMD to build? [y/n]");
						String respond = keyboard.nextLine();
						switch (respond) {
						case "y":
							Turn.build();
							break;
						case "n":
							break;
						default:
							System.out.println("Invalid answer");
						}
					} else {
						System.out.println("Selected Card Insufficient Material");
					}
					break;
				case "sell":
					Turn.sell();
					break;
				case "buildPlace":
					System.out.println("Type Place you want to build");
					String placeCard = keyboard.nextLine();
					Turn.setSelectedPlaceCard(GameController.placeBoard.getPlaceCardFromName(placeCard));
					if (Turn.buildPlaceController()) {
						System.out
								.println("Spend "
										+ Cost.checkLmd(GameController.getCurrentPlayer().getResourceCounter(),
												Turn.getSelectedPlaceCard().getCost(),
												GameController.getCurrentPlayer().getbuyResourceCost())
										+ "LMD to build?");
						String respond = keyboard.nextLine();
						switch (respond) {
						case "y":
							Turn.buildPlace();
							break;
						case "n":
							break;
						default:
							System.out.println("Invalid answer");
						}
					} else {
						System.out.println("Selected Card Insufficient Material");
					}
					break;
				case "cancel" :
					break;
				}
				switch (GameController.getPhase()) {
				case 1: // phase1
					if (GameController.mainBoard.checkIfAllBlankCard(GameController.mainBoard.getCardOnBoard(1))) {
						GameController.setPhase(2);
						System.out.println("=====Phase 2 Start!=====");
					}
					break;
				case 2: // phase 2
					if (GameController.mainBoard.checkIfAllBlankCard(GameController.mainBoard.getCardOnBoard(2))) {
						GameController.setPhase(3);
						System.out.println("=====Phase 3 Start!=====");
					}
					break;
				case 3: // phase 3
					if (GameController.mainBoard.checkIfAllBlankCard(GameController.mainBoard.getCardOnBoard(3))) {
						GameController.endGame = true;
						System.out.println("=====The game has end=====");
						if (GameController.player1.getplayerPoint() > GameController.player2.getplayerPoint()) {
							System.out.println(GameController.player1.getName() + " WIN!");
						} else if (GameController.player1.getplayerPoint() < GameController.player2.getplayerPoint()) {
							System.out.println(GameController.player2.getName() + " WIN!");
						} else {
							System.out.println(GameController.player1.getName() + " and "
									+ GameController.player2.getName() + " TIE!");
						}
					}
				default:
					break;
				}
				if (GameController.ATKboard.getPosition() == 9) {
					System.out.println("=====The game has end=====");
					System.out.println(GameController.player1.getName() + " WIN!");
				} else if (GameController.ATKboard.getPosition() == -9){
					System.out.println("=====The game has end=====");
					System.out.println(GameController.player1.getName() + " WIN!");
				}
			} catch (PickCardFailException e) {
				System.out.println(e.message);
			}
		}
	}

}
*/
