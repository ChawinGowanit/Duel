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
						Turn.setSelectedCard(MainPane.getSelectedCard());
						if (Turn.canBulid(MainPane.getSelectedCard(), GameController.getCurrentPlayer())) {
							if (Cost.checkLmd(GameController.getCurrentPlayer().getResourceCounter(),
									MainPane.getSelectedCard().getCost(),
									GameController.getCurrentPlayer().getbuyResourceCost()) <= GameController
											.getCurrentPlayer().getResourceCounter().getLMD()) {
								MainPane.setVisibleYesNoBtn(true);
								MainPane.setVisibleSelecttionBtn(false);
							}
						} else {
							MainPane.setVisibleNotEnoughmaterial(true);
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
						Turn.setSelectedCard(MainPane.getSelectedCard());
						Turn.sell();
						GameController.mainBoard.updateCardOnBoard(GameController.getPhase());
						MainPane.updateCardOnPane();
						MainPane.setVisibleSelecttionBtn(false);
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
					MainPane.setVisibleSelecttionBtn(false);
				}
			});
		} else if (btn == 5) {
			this.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent arg0) {
					// TODO Auto-generated method stub
					try {
						Turn.setSelectedCard(MainPane.getSelectedCard());
						Turn.build();
						GameController.mainBoard.updateCardOnBoard(GameController.getPhase());
						MainPane.updateCardOnPane();
						MainPane.setVisibleYesNoBtn(false);
						MainPane.setVisibleSelecttionBtn(false);
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
					MainPane.setVisibleYesNoBtn(false);
					MainPane.setVisibleSelecttionBtn(false);
				}
			});
		}
	}
}
