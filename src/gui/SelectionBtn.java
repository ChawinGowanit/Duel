package gui;

import java.io.File;

import application.GameController;
import javafx.event.EventHandler;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import logic.CheckEndPhase;
import logic.Turn;
import logic.exception.PickCardFailException;
import main.Main;

public class SelectionBtn extends Pane {
	private static MediaPlayer mediaPlayer;

	public SelectionBtn(int btn) {
		Image Btn;
		if (btn == 1) {
			Btn = new Image("/gameUI/buildBtn.png", 261, 108, false, false);
		} else if (btn == 2) {
			Btn = new Image("/gameUI/sellBtn.png", 261, 108, false, false);
		} else if (btn == 3) {
			Btn = new Image("/gameUI/buildPlaceBtn.png", 461, 108, false, false);
		} else if (btn == 4) {
			Btn = new Image("/gameUI/cancelBtn.png", 261, 108, false, false);
		} else if (btn == 5 || btn == 7) {
			Btn = new Image("/gameUI/yesBtn.png", 118, 64, false, false);
		} else {
			Btn = new Image("/gameUI/noBtn.png", 101, 63, false, false);
		}
		this.setPrefSize(Btn.getWidth(), Btn.getHeight());
		this.setBackground(new Background(new BackgroundImage(Btn, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
		this.setTooltip(btn);
		this.setMouseAction(btn);
		this.setVisible(false);
	}

	private void setTooltip(int btn) {
		// TODO Auto-generated method stub
		Tooltip tooltip = new Tooltip();
		tooltip.setFont(new Font(20));
		if (btn == 1) {
			tooltip.setText("Build this card by resource or chain symbol");
		} else if (btn == 2) {
			tooltip.setText("Sell this card");
		} else if (btn == 3) {
			tooltip.setText("Use this card to build place");
		} else if (btn == 4) {
			tooltip.setText("cancel and pick new card");
		} else if (btn == 5 || btn == 7) {
			tooltip.setText("confirm build");
		} else {
			tooltip.setText("cancel and pick new card");
		}
		this.setOnMouseMoved((MouseEvent e) -> {
				tooltip.show(this, e.getScreenX() +10, e.getScreenY() + 10);
			
		});
		this.setOnMouseExited((MouseEvent e) -> {
			tooltip.hide();
		});
	}

	public void setMouseAction(int btn) {
		if (btn == 1) {
			this.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent arg0) {
					// TODO Auto-generated method stub
					try {
						String path = new File("res/music/buttonClickSound.mp3").getAbsolutePath();
						Media buttonClick = new Media(new File(path).toURI().toString());
						mediaPlayer = new MediaPlayer(buttonClick);
						mediaPlayer.setAutoPlay(true);
						mediaPlayer.setVolume(1);
						Turn.setSelectedCard(Main.mainPane.getSelectedCard());
						if (Turn.canBulid(Main.mainPane.getSelectedCard(), GameController.getCurrentPlayer())) {
							Main.mainPane.setVisibleYesNoBtn(true);
							Main.mainPane.setVisibleSelecttionBtn(false);
						} else {
							Main.mainPane.setVisibleNotEnoughmaterial(true);
						}
					} catch (PickCardFailException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		} else if (btn == 2) {
			this.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent arg0) {
					// TODO Auto-generated method stub
					try {
						String path = new File("res/music/buttonClickSound.mp3").getAbsolutePath();
						Media buttonClick = new Media(new File(path).toURI().toString());
						mediaPlayer = new MediaPlayer(buttonClick);
						mediaPlayer.setAutoPlay(true);
						mediaPlayer.setVolume(1);
						Turn.setSelectedCard(Main.mainPane.getSelectedCard());
						Turn.sell();
						GameController.mainBoard.updateCardOnBoard(GameController.getPhase());
						Main.mainPane.updateCardOnPane();
						Main.mainPane.updatePickableCardOnPane(GameController.getPhase());
						GameController.mainBoard.updateCardOnBoard(GameController.getPhase());
						Main.mainPane.updateCardOnPane();
						Main.mainPane.updatePickableCardOnPane(GameController.getPhase());
						GameController.mainBoard.updateCardOnBoard(GameController.getPhase());
						Main.mainPane.updateCardOnPane();
						Main.mainPane.updatePickableCardOnPane(GameController.getPhase());
						Main.player1Pane.UpdatePlayerPane(1);
						Main.player2Pane.UpdatePlayerPane(2);
						Main.player1Pane.updatePlayerPaneScreen();
						Main.player2Pane.updatePlayerPaneScreen();
						Main.mainPane.setVisibleSelecttionBtn(false);
						Main.mainPane.setSelectedPlaceCard(null);
						CheckEndPhase.updateMainPane();
					} catch (PickCardFailException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		} else if (btn == 3) {
			this.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent arg0) {
					// TODO Auto-generated method stub
					String path = new File("res/music/buttonClickSound.mp3").getAbsolutePath();
					Media buttonClick = new Media(new File(path).toURI().toString());
					mediaPlayer = new MediaPlayer(buttonClick);
					mediaPlayer.setAutoPlay(true);
					mediaPlayer.setVolume(1);
					Main.mainPane.getSelectPlace().setVisible(true);
					Main.mainPane.setVisibleSelecttionBtn(false);
					Main.placePane.updateMouseCardAction();
					Main.mainPane.setSelectedPlaceCard(null);
					Main.placePane.updateMouseCardAction();
				}
			});
		} else if (btn == 4)

		{
			this.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent arg0) {
					// TODO Auto-generated method stub
					String path = new File("res/music/buttonClickSound.mp3").getAbsolutePath();
					Media buttonClick = new Media(new File(path).toURI().toString());
					mediaPlayer = new MediaPlayer(buttonClick);
					mediaPlayer.setAutoPlay(true);
					mediaPlayer.setVolume(1);
					Main.player1Pane.UpdatePlayerPane(1);
					Main.player2Pane.UpdatePlayerPane(2);
					Main.player1Pane.updatePlayerPaneScreen();
					Main.player2Pane.updatePlayerPaneScreen();
					Main.mainPane.setVisibleSelecttionBtn(false);
					Main.mainPane.setSelectedPlaceCard(null);
					Main.placePane.updateUnable();
				}
			});
		} else if (btn == 5) {
			this.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent arg0) {
					// TODO Auto-generated method stub
					try {
						String path = new File("res/music/buttonClickSound.mp3").getAbsolutePath();
						Media buttonClick = new Media(new File(path).toURI().toString());
						mediaPlayer = new MediaPlayer(buttonClick);
						mediaPlayer.setAutoPlay(true);
						mediaPlayer.setVolume(1);
						Turn.setSelectedCard(Main.mainPane.getSelectedCard());
						Turn.build();
						GameController.mainBoard.updateCardOnBoard(GameController.getPhase());
						Main.mainPane.updateCardOnPane();
						Main.mainPane.updatePickableCardOnPane(GameController.getPhase());
						GameController.mainBoard.updateCardOnBoard(GameController.getPhase());
						Main.atkPane.updateAttackPane();
						GameController.mainBoard.updateCardOnBoard(GameController.getPhase());
						Main.mainPane.updateCardOnPane();
						Main.mainPane.updatePickableCardOnPane(GameController.getPhase());
						Main.player1Pane.UpdatePlayerPane(1);
						Main.player2Pane.UpdatePlayerPane(2);
						Main.player1Pane.updatePlayerPaneScreen();
						Main.player2Pane.updatePlayerPaneScreen();
						Main.mainPane.updateCardOnPane();
						Main.mainPane.setVisibleYesNoBtn(false);
						Main.mainPane.setVisibleSelecttionBtn(false);
						Main.mainPane.setSelectedPlaceCard(null);
						CheckEndPhase.updateMainPane();
					} catch (PickCardFailException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		} else if (btn == 6) {
			this.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent arg0) {
					// TODO Auto-generated method stub
					String path = new File("res/music/buttonClickSound.mp3").getAbsolutePath();
					Media buttonClick = new Media(new File(path).toURI().toString());
					mediaPlayer = new MediaPlayer(buttonClick);
					mediaPlayer.setAutoPlay(true);
					mediaPlayer.setVolume(1);
					Main.player1Pane.UpdatePlayerPane(1);
					Main.player2Pane.UpdatePlayerPane(2);
					Main.player1Pane.updatePlayerPaneScreen();
					Main.player2Pane.updatePlayerPaneScreen();
					Main.mainPane.setVisibleYesNoBtn(false);
					Main.mainPane.setVisibleSelecttionBtn(false);
					Main.mainPane.setSelectedPlaceCard(null);
					Main.placePane.updateUnable();

				}
			});
		} else if (btn == 7) {
			this.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent arg0) {
					// TODO Auto-generated method stub
					try {
						String path = new File("res/music/buttonClickSound.mp3").getAbsolutePath();
						Media buttonClick = new Media(new File(path).toURI().toString());
						mediaPlayer = new MediaPlayer(buttonClick);
						mediaPlayer.setAutoPlay(true);
						mediaPlayer.setVolume(1);
						Turn.setSelectedCard(Main.mainPane.getSelectedCard());
						Turn.setSelectedPlaceCard(Main.mainPane.getSelectedPlaceCard());
						Turn.buildPlace();
						GameController.mainBoard.updateCardOnBoard(GameController.getPhase());
						GameController.mainBoard.updateCardOnBoard(GameController.getPhase());
						Main.mainPane.updateCardOnPane();
						Main.mainPane.updatePickableCardOnPane(GameController.getPhase());
						Main.atkPane.updateAttackPane();
						GameController.mainBoard.updateCardOnBoard(GameController.getPhase());
						Main.mainPane.updateCardOnPane();
						Main.mainPane.updatePickableCardOnPane(GameController.getPhase());
						Main.player1Pane.UpdatePlayerPane(1);
						Main.player2Pane.UpdatePlayerPane(2);
						Main.player1Pane.updatePlayerPaneScreen();
						Main.player2Pane.updatePlayerPaneScreen();
						Main.mainPane.updateCardOnPane();
						Main.mainPane.getAlertTextPane().setVisible(false);
						Main.mainPane.getSelectedPlaceCardBtn().setVisible(false);
						Main.mainPane.setVisibleYesNoBtn(false);
						Main.mainPane.setVisibleSelecttionBtn(false);
						Main.mainPane.setSelectedPlaceCard(null);
						Main.placePane.updateUnable();
						CheckEndPhase.updateMainPane();
					} catch (PickCardFailException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}

	}
}
