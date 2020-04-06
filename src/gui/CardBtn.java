package gui;

import Card.TradingCard;
import Card.base.Attackable;
import Card.base.Card;
import Card.base.HaveChainSymbol;
import Card.base.HavePoint;
import Card.base.HaveResource;
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
	private Card card ;
	public CardBtn(Card card) {
		this.card = card;
		Image cardImg = new Image("/cardURL"+card.getImgUrl(),109,153,false,false);
		this.setMinSize(109, 153);
		this.setBackground(new Background(new BackgroundImage(cardImg, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
		this.setTooltip();
	}
	private void setTooltip() {
		String tooltipText = card.getName()+"\n-----Cost-----\n"+card.getCost().toString()+"\n-----Reward-----\n";
		if (card instanceof Attackable) {
			tooltipText += "AttackPoint : "+((Attackable) card).getAttackPoint()+"\n";
		}
		if (card instanceof HavePoint) {
			tooltipText += "Point : "+((HavePoint) card).getPlayerPoint()+"\n";
		}
		if (card instanceof HaveResource) {
			tooltipText += "-----Resource-----\n"+((HaveResource) card).getResource()+"\n";
		}
		if (card instanceof HaveChainSymbol) {
			tooltipText += "Chain Symbol :"+ ((HaveChainSymbol) card).getChainSymbols()+"\n";
		}
		if (card instanceof TradingCard) {
			tooltipText += "-----Reduce buy resource cost by-----"+((TradingCard) card).getReduceCost();
		}
		Tooltip tooltip = new Tooltip();
		tooltip.setFont(new Font(14));
		tooltip.setText(tooltipText);
		this.setOnMouseMoved((MouseEvent e) -> {
			tooltip.show(this, e.getScreenX(), e.getScreenY() + 10);
		});
		this.setOnMouseExited((MouseEvent e) -> {
			tooltip.hide();
		});
	}
}
