package gui;


import Card.PlaceCard;
import application.GameController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import main.Main;

public class PlacePane extends HBox{
	private ObservableList<PlaceCardBtn> PlaceBtnList = FXCollections.observableArrayList();
	public PlacePane() {
		this.setPrefSize(1450, 145);
		this.setPadding(new Insets(8));	
		this.setAlignment(Pos.CENTER);	
		this.setBackground(new Background(new BackgroundImage(
				new Image("/gameUI/PlacePaneBg.png", 1450, 145, false, true), BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
		for (PlaceCard placeCard : GameController.placeBoard.getPlaceCardOnBoard()) {
			PlaceCardBtn placeCardBtn = new PlaceCardBtn(placeCard);
			this.PlaceBtnList.add(placeCardBtn);
		}
		this.getChildren().addAll(PlaceBtnList);

	}
	public ObservableList<PlaceCardBtn> getPlaceBtnList() {
		return PlaceBtnList;
	}
	public void updateMouseCardAction() {
		for (PlaceCardBtn placeCardBtn :PlaceBtnList) {
			placeCardBtn.setMouseAction();
		}
	}
	public void updateUnable() {
		for (PlaceCardBtn placeCardBtn :PlaceBtnList) {
			placeCardBtn.setUnAbleMouseAction();
		}
	}
}