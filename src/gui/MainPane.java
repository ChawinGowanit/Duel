package gui;

import Card.base.Card;
import application.GameController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class MainPane extends Pane {
	private static Card selectedCard;
	private static SelectionBtn buildBtn;
	private static SelectionBtn sellBtn;
	private static SelectionBtn buildPlaceBtn;
	private static SelectionBtn cancelBtn;
	private static SelectionBtn yesBtn;
	private static SelectionBtn noBtn;
	private static CardBtn selectedCardBtn;
	private static AlertTextPane alertTextPane ;
	private static Pane notEnoughMaterial ;

	private static ObservableList<CardBtn> CardBtnList = FXCollections.observableArrayList();

	public MainPane(int phase) {
		this.setPrefSize(1357, 743);
		this.setPadding(new Insets(8));
		this.setBackground(new Background(new BackgroundImage(
				new Image("/gameUI/mainPaneBg.png", 1357, 743, false, true), BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
		if (phase == 1) {
			for (Card card : GameController.mainBoard.getCardOnBoard(1)) {
				CardBtn cardbtn = new CardBtn(card);
				CardBtnList.add(cardbtn);
			}
		} else if (phase == 2) {
			for (Card card : GameController.mainBoard.getCardOnBoard(2)) {
				CardBtn cardbtn = new CardBtn(card);
				CardBtnList.add(cardbtn);
			}

		} else {
			for (Card card : GameController.mainBoard.getCardOnBoard(3)) {
				CardBtn cardbtn = new CardBtn(card);
				CardBtnList.add(cardbtn);
			}
		}
		this.addCardOnPane(phase);
		buildBtn = new SelectionBtn(1);
		buildBtn.setLayoutX(0);
		buildBtn.setLayoutY(700);
		sellBtn = new SelectionBtn(2);
		sellBtn.setLayoutX(300);
		sellBtn.setLayoutY(700);
		buildPlaceBtn = new SelectionBtn(3);
		buildPlaceBtn.setLayoutX(600);
		buildPlaceBtn.setLayoutY(700);
		cancelBtn = new SelectionBtn(4);
		cancelBtn.setLayoutX(1100);
		cancelBtn.setLayoutY(700);
		alertTextPane = new AlertTextPane();
		alertTextPane.setLayoutX(450);
		alertTextPane.setLayoutY(650);
		yesBtn = new SelectionBtn(5);
		yesBtn.setLayoutX(550);
		yesBtn.setLayoutY(775);
		noBtn = new SelectionBtn(6);
		noBtn.setLayoutX(725);
		noBtn.setLayoutY(775);
		notEnoughMaterial = new AlertTextPane("notEnoughMaterial");
		notEnoughMaterial.setLayoutX(450);
		notEnoughMaterial.setLayoutY(650);
		this.getChildren().addAll(buildBtn, sellBtn, buildPlaceBtn, cancelBtn,alertTextPane,yesBtn,noBtn,notEnoughMaterial);
	}

	private void addCardOnPane(int phase) {
		// TODO Auto-generated method stub
		if (phase == 1 || phase == 2) {
			for (int i = 0; i < 20; i++) {
				if (i == 0) {
					CardBtnList.get(i).setLayoutX(500);
					CardBtnList.get(i).setLayoutY(150);
				} else if (i == 1) {
					CardBtnList.get(i).setLayoutX(675);
					CardBtnList.get(i).setLayoutY(150);
				} else if (i == 2) {
					CardBtnList.get(i).setLayoutX(425);
					CardBtnList.get(i).setLayoutY(225);
				} else if (i == 3) {
					CardBtnList.get(i).setLayoutX(600);
					CardBtnList.get(i).setLayoutY(225);
				} else if (i == 4) {
					CardBtnList.get(i).setLayoutX(775);
					CardBtnList.get(i).setLayoutY(225);
				} else if (i == 5) {
					CardBtnList.get(i).setLayoutX(325);
					CardBtnList.get(i).setLayoutY(300);
				} else if (i == 6) {
					CardBtnList.get(i).setLayoutX(500);
					CardBtnList.get(i).setLayoutY(300);
				} else if (i == 7) {
					CardBtnList.get(i).setLayoutX(675);
					CardBtnList.get(i).setLayoutY(300);
				} else if (i == 8) {
					CardBtnList.get(i).setLayoutX(850);
					CardBtnList.get(i).setLayoutY(300);
				} else if (i == 9) {
					CardBtnList.get(i).setLayoutX(225);
					CardBtnList.get(i).setLayoutY(375);
				} else if (i == 10) {
					CardBtnList.get(i).setLayoutX(400);
					CardBtnList.get(i).setLayoutY(375);
				} else if (i == 11) {
					CardBtnList.get(i).setLayoutX(600);
					CardBtnList.get(i).setLayoutY(375);
				} else if (i == 12) {
					CardBtnList.get(i).setLayoutX(775);
					CardBtnList.get(i).setLayoutY(375);
				} else if (i == 13) {
					CardBtnList.get(i).setLayoutX(950);
					CardBtnList.get(i).setLayoutY(375);
				} else if (i == 14) {
					CardBtnList.get(i).setLayoutX(150);
					CardBtnList.get(i).setLayoutY(450);
				} else if (i == 15) {
					CardBtnList.get(i).setLayoutX(325);
					CardBtnList.get(i).setLayoutY(450);
				} else if (i == 16) {
					CardBtnList.get(i).setLayoutX(500);
					CardBtnList.get(i).setLayoutY(450);
				} else if (i == 17) {
					CardBtnList.get(i).setLayoutX(675);
					CardBtnList.get(i).setLayoutY(450);
				} else if (i == 18) {
					CardBtnList.get(i).setLayoutX(850);
					CardBtnList.get(i).setLayoutY(450);
				} else if (i == 19) {
					CardBtnList.get(i).setLayoutX(1025);
					CardBtnList.get(i).setLayoutY(450);
				}
				this.getChildren().add(CardBtnList.get(i));
			}
		} else {
			for (int i = 0; i < 16; i++) {
				if (i == 0) {
					CardBtnList.get(i).setLayoutX(500);
					CardBtnList.get(i).setLayoutY(150);
				} else if (i == 1) {
					CardBtnList.get(i).setLayoutX(675);
					CardBtnList.get(i).setLayoutY(150);
				} else if (i == 2) {
					CardBtnList.get(i).setLayoutX(425);
					CardBtnList.get(i).setLayoutY(225);
				} else if (i == 3) {
					CardBtnList.get(i).setLayoutX(600);
					CardBtnList.get(i).setLayoutY(225);
				} else if (i == 4) {
					CardBtnList.get(i).setLayoutX(775);
					CardBtnList.get(i).setLayoutY(225);
				} else if (i == 5) {
					CardBtnList.get(i).setLayoutX(325);
					CardBtnList.get(i).setLayoutY(300);
				} else if (i == 6) {
					CardBtnList.get(i).setLayoutX(500);
					CardBtnList.get(i).setLayoutY(300);
				} else if (i == 7) {
					CardBtnList.get(i).setLayoutX(675);
					CardBtnList.get(i).setLayoutY(300);
				} else if (i == 8) {
					CardBtnList.get(i).setLayoutX(850);
					CardBtnList.get(i).setLayoutY(300);
				} else if (i == 9) {
					CardBtnList.get(i).setLayoutX(325);
					CardBtnList.get(i).setLayoutY(375);
				} else if (i == 10) {
					CardBtnList.get(i).setLayoutX(500);
					CardBtnList.get(i).setLayoutY(375);
				} else if (i == 11) {
					CardBtnList.get(i).setLayoutX(675);
					CardBtnList.get(i).setLayoutY(375);
				} else if (i == 12) {
					CardBtnList.get(i).setLayoutX(850);
					CardBtnList.get(i).setLayoutY(375);
				} else if (i == 13) {
					CardBtnList.get(i).setLayoutX(425);
					CardBtnList.get(i).setLayoutY(450);
				} else if (i == 14) {
					CardBtnList.get(i).setLayoutX(600);
					CardBtnList.get(i).setLayoutY(450);
				} else if (i == 15) {
					CardBtnList.get(i).setLayoutX(775);
					CardBtnList.get(i).setLayoutY(450);
				}
				this.getChildren().add(CardBtnList.get(i));
			}

		}
	}

	public static void updateCardOnPane() {
		for (CardBtn cardbtn : CardBtnList) {
			cardbtn.updateCardImg();
			cardbtn.updateCardVisible();
			updatePickableCardOnPane(GameController.getPhase());
		}
		for (CardBtn cardbtn : CardBtnList) {
			cardbtn.updateMouseAction();
		}
	}

	private static void updatePickableCardOnPane(int phase) {
		// TODO Auto-generated method stub
		if (phase == 1 || phase == 2) {
			for (CardBtn Cardbtn : CardBtnList) {
				if (Cardbtn.getCard().getPosition() == 1 || Cardbtn.getCard().getPosition() == 2) {
					if (!(CardBtnList.get(Cardbtn.getCard().getPosition() + 1).isVisible())
							&& (!CardBtnList.get(Cardbtn.getCard().getPosition() + 2).isVisible())) {
						Cardbtn.getCard().setPickAble(true);
					}
				} else if (Cardbtn.getCard().getPosition() == 3 || Cardbtn.getCard().getPosition() == 4
						|| Cardbtn.getCard().getPosition() == 5) {
					if (!(CardBtnList.get(Cardbtn.getCard().getPosition() + 2).isVisible())
							&& (!CardBtnList.get(Cardbtn.getCard().getPosition() + 3).isVisible())) {
						Cardbtn.getCard().setPickAble(true);
					}
				} else if (Cardbtn.getCard().getPosition() == 6 || Cardbtn.getCard().getPosition() == 7
						|| Cardbtn.getCard().getPosition() == 8 || Cardbtn.getCard().getPosition() == 9) {
					if (!(CardBtnList.get(Cardbtn.getCard().getPosition() + 3).isVisible())
							&& (!CardBtnList.get(Cardbtn.getCard().getPosition() + 4).isVisible())) {
						Cardbtn.getCard().setPickAble(true);
					}
				} else if (Cardbtn.getCard().getPosition() == 10 | Cardbtn.getCard().getPosition() == 11
						| Cardbtn.getCard().getPosition() == 12 | Cardbtn.getCard().getPosition() == 13
						| Cardbtn.getCard().getPosition() == 14) {
					if (!(CardBtnList.get(Cardbtn.getCard().getPosition() + 4).isVisible()
							&& (!CardBtnList.get(Cardbtn.getCard().getPosition() + 5).isVisible()))) {
						Cardbtn.getCard().setPickAble(true);
					}
				} else {
					Cardbtn.getCard().setPickAble(true);
				}

			}
		}

	}

	public static void setVisibleSelecttionBtn(boolean bool) {
		buildBtn.setVisible(bool);
		buildPlaceBtn.setVisible(bool);
		sellBtn.setVisible(bool);
		cancelBtn.setVisible(bool);

	}

	public static void setSelectedCard(Card card) {
		// TODO Auto-generated method stub
		selectedCard = card;
	}

	public static Card getSelectedCard() {
		// TODO Auto-generated method stub
		return selectedCard;
	}

	public static void removedCardFromPane(CardBtn card) {
		CardBtnList.set(CardBtnList.indexOf(card), new CardBtn(GameController.mainBoard.getBlankCard()));
	}

	public static void setSelectedCardBtn(Card card) {
		// TODO Auto-generated method stub
		for (CardBtn cardBtn : CardBtnList) {
			if (cardBtn.getCard().equals(card)) {
				selectedCardBtn = cardBtn;
			}
		}
	}

	public static CardBtn getSelectedCardBtn() {
		// TODO Auto-generated method stub
		return selectedCardBtn;
	}

	public static void setVisibleYesNoBtn(boolean b) {
		// TODO Auto-generated method stub
		alertTextPane.setVisible(b);
		yesBtn.setVisible(b);
		noBtn.setVisible(b);
	}
	public static void setVisibleNotEnoughmaterial(boolean bool) {
		notEnoughMaterial.setVisible(bool);
		MainPane.setVisibleSelecttionBtn(false);
	}
}
