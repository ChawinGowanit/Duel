package gui;

import Card.base.Cost;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class AlertTextPane extends Pane {
	private Pane lmdcheck;

	public AlertTextPane() {
		this.setMinSize(500, 130);
		lmdcheck = setText();
		lmdcheck.setLayoutX(0);
		lmdcheck.setLayoutY(0);
		this.getChildren().addAll(lmdcheck);
		this.setVisible(false);

	}

	public AlertTextPane(String notEnoughMaterial) {
		Text alertText = new Text();
		alertText.setFill(Color.WHITE);
		alertText.setFont(new Font(40));
		alertText.setX(75);
		alertText.setY(75);
		alertText.textProperty().setValue("Not enough material!");
		Image bg = new Image("/gameUI/alertTextBg.png", 500, 100, false, false);
		this.setMinSize(500, 100);
		this.setBackground(new Background(new BackgroundImage(bg, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
		this.getChildren().add(alertText);
		this.setVisible(false);
		this.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				MainPane.setVisibleNotEnoughmaterial(false);
				MainPane.setVisibleSelecttionBtn(false);

			}
		});
		Tooltip tooltip = new Tooltip();
		tooltip.setFont(new Font(14));
		tooltip.setText("Click to close");
		this.setOnMouseMoved((MouseEvent e) -> {
			tooltip.show(this, e.getScreenX(), e.getScreenY() + 10);
		});
		this.setOnMouseExited((MouseEvent e) -> {
			tooltip.hide();
		});
	}

	private Pane setText() {

		// TODO Auto-generated method stub
		String text = "Spend "
				+ Cost.checkLmd(GameController.getCurrentPlayer().getResourceCounter(),
						MainPane.getSelectedCard().getCost(), GameController.getCurrentPlayer().getbuyResourceCost())
				+ "LMD to build?";
		Text alertText = new Text();
		alertText.setFill(Color.WHITE);
		alertText.setFont(new Font(40));
		alertText.setX(75);
		alertText.setY(75);
		alertText.textProperty().setValue(text);
		Pane alertPane = new Pane();
		Image bg = new Image("/gameUI/alertTextBg.png", 500, 100, false, false);
		alertPane.setMinSize(500, 100);
		alertPane.setBackground(new Background(new BackgroundImage(bg, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
		alertPane.getChildren().add(alertText);
		return alertPane;
	}
}
