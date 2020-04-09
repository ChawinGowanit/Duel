package gui;

import Card.base.Cost;
import application.GameController;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import logic.Turn;
import logic.exception.PickCardFailException;
import main.Main;

public class SelectionBtn extends Pane {
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
		} else if (btn == 5) {
			Btn = new Image("/gameUI/yesBtn.png", 118, 64, false, false);
		} else {
			Btn = new Image("/gameUI/noBtn.png", 101, 63, false, false);
		}
		this.setPrefSize(Btn.getWidth(), Btn.getHeight());
		this.setBackground(new Background(new BackgroundImage(Btn, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
		this.setMouseAction(btn);
		this.setVisible(false);
	}

	public void setMouseAction(int btn) {
		if (btn == 1) {
			this.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent arg0) {
					// TODO Auto-generated method stub
					try {
						System.out.println(Main.mainPane.getSelectedCard());
						Turn.setSelectedCard(Main.mainPane.getSelectedCard());
						if (Turn.canBulid(Main.mainPane.getSelectedCard(), GameController.getCurrentPlayer())) {
							if (Cost.checkLmd(GameController.getCurrentPlayer().getResourceCounter(),
									Main.mainPane.getSelectedCard().getCost(),
									GameController.getCurrentPlayer().getbuyResourceCost()) <= GameController
											.getCurrentPlayer().getResourceCounter().getLMD()) {
								Main.mainPane.setVisibleYesNoBtn(true);
								Main.mainPane.setVisibleSelecttionBtn(false);
							}
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
						Turn.setSelectedCard(Main.mainPane.getSelectedCard());
						Turn.sell();
						GameController.mainBoard.updateCardOnBoard(GameController.getPhase());
						Main.player1Pane.UpdatePlayerPane(1);
						Main.player2Pane.UpdatePlayerPane(2);
						Main.player1Pane.updatePlayerPaneScreen();
						Main.player2Pane.updatePlayerPaneScreen();
						Main.mainPane.updateCardOnPane();
						Main.mainPane.setVisibleSelecttionBtn(false);
					} catch (PickCardFailException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		} else if (btn == 3) {

		} else if (btn == 4) {
			this.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent arg0) {
					// TODO Auto-generated method stub
					Main.player1Pane.UpdatePlayerPane(1);
					Main.player2Pane.UpdatePlayerPane(2);
					Main.player1Pane.updatePlayerPaneScreen();
					Main.player2Pane.updatePlayerPaneScreen();
					Main.mainPane.setVisibleSelecttionBtn(false);
				}
			});
		} else if (btn == 5) {
			this.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent arg0) {
					// TODO Auto-generated method stub
					try {
						Turn.setSelectedCard(Main.mainPane.getSelectedCard());
						Turn.build();
						GameController.mainBoard.updateCardOnBoard(GameController.getPhase());
						Main.atkPane.updateAttackPane();
						Main.player1Pane.UpdatePlayerPane(1);
						Main.player2Pane.UpdatePlayerPane(2);
						Main.player1Pane.updatePlayerPaneScreen();
						Main.player2Pane.updatePlayerPaneScreen();
						Main.mainPane.updateCardOnPane();
						Main.mainPane.setVisibleYesNoBtn(false);
						Main.mainPane.setVisibleSelecttionBtn(false);
					} catch (PickCardFailException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		} else {
			this.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent arg0) {
					// TODO Auto-generated method stub
					Main.player1Pane.UpdatePlayerPane(1);
					Main.player2Pane.UpdatePlayerPane(2);
					Main.player1Pane.updatePlayerPaneScreen();
					Main.player2Pane.updatePlayerPaneScreen();
					Main.mainPane.setVisibleYesNoBtn(false);
					Main.mainPane.setVisibleSelecttionBtn(false);
				}
			});
		}

	}
}
