package gui;

import Card.PlaceCard;
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

public class PlaceCardBtn extends Pane {
	private PlaceCard placeCard;

	PlaceCardBtn(PlaceCard placeCard) {
		this.placeCard = placeCard;
		Image placecardImg = new Image("file:res/cardURL/placeCard" + placeCard.getImgURL(), 175, 117, false, false);
		this.setMinSize(175, 117);
		this.setBackground(new Background(new BackgroundImage(placecardImg, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
		this.setTooltip();
	}

	private void setTooltip() {
		Tooltip tooltip = new Tooltip();
		tooltip.setFont(new Font(14));
		tooltip.setText(placeCard.getName()+"\n-----Cost------\n " + placeCard.getCost().toString() + "\nAttackPoint : " + placeCard.getAttackPoint()
				+ "\nPoint : " + placeCard.getPlayerPoint());
		this.setOnMouseMoved((MouseEvent e) -> {
			tooltip.show(this, e.getScreenX(), e.getScreenY() + 10);
		});
		this.setOnMouseExited((MouseEvent e) -> {
			tooltip.hide();
		});
	}

}
