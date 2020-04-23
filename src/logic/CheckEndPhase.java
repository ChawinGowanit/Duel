package logic;

import application.GameController;
import gui.CardBtn;
import gui.PlaceCardBtn;
import javafx.event.EventHandler;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import main.Main;

public class CheckEndPhase {

	public static void updateMainPane() {
		if (GameController.mainBoard
				.checkIfAllBlankCard(GameController.mainBoard.getCardOnBoard(GameController.getPhase()))) {
			if (GameController.ATKboard.getPosition() != 9 && GameController.ATKboard.getPosition() != -9) {
				if (GameController.getPhase() == 1) {
					GameController.setPhase(2);
					Main.newMainPane(2);

				} else if (GameController.getPhase() == 2) {
					GameController.setPhase(3);
					Main.newMainPane(3);
					System.out.println(GameController.mainBoard.getCardOnBoard(3));
					GameController.mainBoard.updateCardOnBoard(GameController.getPhase());
					Main.mainPane.updateCardOnPane();
					Main.mainPane.updatePickableCardOnPane(GameController.getPhase());
					System.out.println(GameController.mainBoard.getCardOnBoard(3));
				} else {
					endPhase();
				}
			} else {
				endPhase();
			}
		}
		if (GameController.ATKboard.getPosition() == 9 || GameController.ATKboard.getPosition() == -9) {
			endPhase();
		}
	}

	public static void endPhase() {
		for (CardBtn card : Main.mainPane.getCardBtnList()) {
			card.setVisible(false);
		}
		for (PlaceCardBtn card : Main.placePane.getPlaceBtnList()) {
			card.setDisable(true);
		}
		String text;
		Text winText = new Text();
		if (GameController.ATKboard.getPosition() == 9) {
			text = GameController.player1.getName() + " win!";
		} else if (GameController.ATKboard.getPosition() == -9) {
			text = GameController.player2.getName() + " win!";
		} else {
			if (GameController.player1.getplayerPoint() > GameController.player2.getplayerPoint()) {
				text = GameController.player1.getName() + " win!";
			} else if (GameController.player1.getplayerPoint() == GameController.player2.getplayerPoint()) {
				text = GameController.player1.getName() + " and " + GameController.player2.getName() + " tie!";
			} else {
				text = GameController.player2.getName() + " win!";
			}
		}
		winText.setFont(new Font(40));
		winText.setFill(Color.WHITE);
		winText.textProperty().setValue(text);
		StackPane winRec = new StackPane();
		Image winRecImg = new Image("/endUI/endRec.png");
		ImageView winRecImgView = new ImageView(winRecImg);
		winRecImgView.setFitWidth(750);
		winRecImgView.setFitHeight(154);
		winRec.getChildren().addAll(winRecImgView, winText);
		winRec.setLayoutX(300);
		winRec.setLayoutY(300);

		// quitBtn
		Image quitBtnImg = new Image("/endUI/quitBtn.png");
		ImageView quitBtnImageView = new ImageView(quitBtnImg);
		quitBtnImageView.setFitHeight(107);
		quitBtnImageView.setFitWidth(648);
		quitBtnImageView.setY(500);
		quitBtnImageView.setX(350);

		quitBtnImageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		Tooltip tooltip = new Tooltip();
		tooltip.setText("Close the game");
		tooltip.setFont(new Font(18));
		quitBtnImageView.setOnMouseMoved((MouseEvent e) -> {
			tooltip.show(quitBtnImageView, e.getScreenX() + 10, e.getScreenY() + 10);
		});
		quitBtnImageView.setOnMouseExited((MouseEvent e) -> {
			tooltip.hide();
		});

		Main.mainPane.getChildren().addAll(winRec, quitBtnImageView);
	}

}
