package gui;


import java.io.File;

import Card.TradingCard;
import Card.base.Attackable;
import Card.base.Card;
import Card.base.ChainSymbols;
import Card.base.Cost;
import Card.base.HaveChainSymbol;
import Card.base.HavePoint;
import Card.base.HaveResource;
import javafx.event.EventHandler;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
import main.Main;

public class CardBtn extends Pane {
	private Card card;
	private static MediaPlayer mediaPlayer;
	public CardBtn(Card card) {
		this.card = card;
		updateCardImg();
		this.setTooltip();
		this.setMouseAction();
	}

	private void setMouseAction() {
		// TODO Auto-generated method stub
		if (this.card.isPickAble() == true) {
			this.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent arg0) {
					// TODO Auto-generated method stub
					String path = new File("src/music/buttonClickSound.mp3").getAbsolutePath();
					Media buttonClick = new Media(new File(path).toURI().toString());
					mediaPlayer = new MediaPlayer(buttonClick);
					mediaPlayer.setAutoPlay(true);
					mediaPlayer.setVolume(1);
					Main.mainPane.setSelectedCard(card);
					Main.mainPane.setSelectedCardBtn(card);
					Main.mainPane.setVisibleSelecttionBtn(true);
				}
			});
		}
	}

	private void setTooltip() {
		Tooltip tooltip = new Tooltip();
		tooltip.setGraphic(new ImageView(new Image("/cardURL/Card" + card.getImgUrl(), 300, 422, false, false)));
		tooltip.setFont(new Font(20));
		String tooltipText = card.getName()+"\n";
		if (card.getCost().toString().equals(new Cost().toString())) {
			//tooltipText += "\n-----No Cost-----\n";
		} else {
			tooltipText += "-----Cost-----\n" + card.getCost();
		}
		if (card instanceof HaveChainSymbol
				&& ((HaveChainSymbol) card).getChainSymbols().toString() != new ChainSymbols().toString()
				&& !card.getCost().toString().equals(new Cost().toString())) {
			tooltipText += "or \nChain Symbol : " + ((HaveChainSymbol) card).getChainSymbols() + "\n";
		}
		if (card instanceof Attackable && ((Attackable) card).getAttackPoint() != 0) {
			tooltipText += "AttackPoint : " + ((Attackable) card).getAttackPoint() + "\n";
		}
		if (card instanceof HavePoint && ((HavePoint) card).getPlayerPoint() != 0) {
			tooltipText += "Point : " + ((HavePoint) card).getPlayerPoint() + "\n";
		}
		if (card instanceof HaveResource
				&& !((HaveResource) card).getResource().toString().equals(new Cost().toString())) {
			tooltipText += "-----Resource-----\n" + ((HaveResource) card).getResource() + "\n";
		}

		if (card instanceof TradingCard
				&& !((TradingCard) card).getReduceCost().toString().equals(new Cost().toString())) {
			tooltipText += "-----Reduce buy resource cost by-----\n" + ((TradingCard) card).getReduceCost();
		}
		tooltip.setText(tooltipText);
		this.setOnMouseMoved((MouseEvent e) -> {
			if (card.isFlipAble()) {
				tooltip.show(this, e.getScreenX() +10, e.getScreenY() + 10);
			}
		});
		this.setOnMouseExited((MouseEvent e) -> {
			tooltip.hide();
		});
	}

	public Card getCard() {
		return card;
	}

	public void updateCardImg() {
		if (card.isFlipAble()) {
			Image cardImg = new Image("/cardURL/Card" + card.getImgUrl(), 150, 211, false, false);
			this.setMinSize(150, 211);
			this.setBackground(new Background(new BackgroundImage(cardImg, BackgroundRepeat.NO_REPEAT,
					BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
		} else {
			Image cardImg = new Image("/cardURL/Card/backCard.png", 150, 211, false, false);
			this.setMinSize(150, 211);
			this.setBackground(new Background(new BackgroundImage(cardImg, BackgroundRepeat.NO_REPEAT,
					BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
		}
	}

	public void updateCardVisible() {
		if (card.equals(Main.mainPane.getSelectedCard())) {
			this.setVisible(false);
		}
	}

	public void updateMouseAction() {
		// TODO Auto-generated method stub
		if (this.card.isPickAble() == true) {
			this.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent arg0) {
					// TODO Auto-generated method stub
					Main.mainPane.setSelectedCard(card);
					Main.mainPane.setSelectedCardBtn(card);
					Main.mainPane.setVisibleSelecttionBtn(true);
				}
			});
		}
	}

}
