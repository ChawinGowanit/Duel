package gui;

import Card.PlaceCard;
import application.GameController;
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
import javafx.scene.text.Font;
import logic.Turn;
import main.Main;

public class PlaceCardBtn extends Pane {
	private PlaceCard placeCard;

	PlaceCardBtn(PlaceCard placeCard) {
		this.placeCard = placeCard;
		Image placecardImg = new Image("/cardURL/placeCard" + placeCard.getImgURL(), 175, 117, false, false);
		this.setMinSize(175, 117);
		this.setBackground(new Background(new BackgroundImage(placecardImg, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
		this.setTooltip();
	}

	public void setTooltip() {
		Tooltip tooltip = new Tooltip();
		tooltip.setGraphic(new ImageView(new Image("/cardURL/placeCard" + placeCard.getImgURL(), 700, 468, false, false)));
		tooltip.setFont(new Font(18));
		String text = placeCard.getName() + "\n-----Cost------\n " + placeCard.getCost().toString()+ "\n-----Reward-----\n" ;
		if (placeCard.getAttackPoint() != 0) {
			text += "AttackPoint : " + placeCard.getAttackPoint() +"\n";
		}
		if (placeCard.getPlayerPoint() != 0) {
			text += "Point : " + placeCard.getPlayerPoint() +"\n";
		}
		if (placeCard.getResource().getLMD() != 0) {
			text += "LMD : " + placeCard.getResource().getLMD();
		}
		tooltip.setText(text);
		tooltip.setX(this.getMaxWidth());
		tooltip.setY(this.getMinHeight());
		this.setOnMouseMoved((MouseEvent e) -> {
			tooltip.show(this, 500 , 200);
		});
		this.setOnMouseExited((MouseEvent e) -> {
			tooltip.hide();
		});
	}

	public void setMouseAction() {
		if (Main.mainPane.getSelectedPlaceCard() == null) {
			this.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent arg0) {
					// TODO Auto-generated method stub
					Main.mainPane.setSelectedPlaceCard(placeCard);
					Main.mainPane.setSelectedPlaceCardBtn(placeCard);
					Main.mainPane.getSelectPlace().setVisible(false);
					if (Turn.canBuildPlace(Main.mainPane.getSelectedPlaceCard(), GameController.getCurrentPlayer())) {
						Main.mainPane.setVisibleYesNoBtn(true);
					} else {
						Main.mainPane.setVisibleNotEnoughmaterial(true);
					}
					System.out.println(Main.mainPane.getSelectedPlaceCard());
				}
			});
		}
	}

	public void setUnAbleMouseAction() {

		this.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}
		});
	}

	public PlaceCard getPlaceCard() {
		// TODO Auto-generated method stub
		return this.placeCard;
	}

}