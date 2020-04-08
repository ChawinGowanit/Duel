package gui;


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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class CardBtn extends Pane {
	private Card card;

	public CardBtn(Card card) {
		this.card = card;
		updateCardImg();
		this.setTooltip();
		this.setMouseAction();
	}

	private void setMouseAction() {
		// TODO Auto-generated method stub
		if (this.card.isPickAble() == true) {
			MainPane.setSelectedCard(this.card);
			MainPane.setSelectedCardBtn(this.card);
			this.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent arg0) {
					// TODO Auto-generated method stub
					MainPane.setSelectedCard(card);
					MainPane.setVisibleSelecttionBtn(true);
				}
			});
		}
	}

	private void setTooltip() {
		Tooltip tooltip = new Tooltip();
		tooltip.setFont(new Font(14));
		String tooltipText = card.getName();
		if (card.getCost().toString().equals(new Cost().toString())) {
			tooltipText += "\n-----No Cost-----\n";
		} else {
			tooltipText += "\n-----Cost-----\n" + card.getCost() + "\n";
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
				tooltip.show(this, e.getScreenX(), e.getScreenY() + 10);
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
		if (card.equals(MainPane.getSelectedCard())) {
			this.setVisible(false);
		}
	}

	public void updateMouseAction() {
		// TODO Auto-generated method stub
		if (this.card.isPickAble() == true) {
			MainPane.setSelectedCard(this.card);
			MainPane.setSelectedCardBtn(this.card);
			this.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent arg0) {
					// TODO Auto-generated method stub
					MainPane.setSelectedCard(card);
					MainPane.setVisibleSelecttionBtn(true);
				}
			});
		}
	}

}
