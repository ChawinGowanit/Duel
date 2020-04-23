package gui;

import Card.base.ChainSymbols;
import Card.base.Cost;
import Card.base.HaveChainSymbol;
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
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import main.Main;

public class AlertTextPane extends StackPane {
	private Text lmdcheck;

	public AlertTextPane() {
		this.setMinSize(500, 130);
		Image bg = new Image("/gameUI/alertTextBg.png", 500, 100, false, false);
		this.setBackground(new Background(new BackgroundImage(bg, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
		lmdcheck = new Text();
		lmdcheck.setFill(Color.WHITE);
		lmdcheck.setFont(new Font(40));
		this.setText();
		lmdcheck.setLayoutX(0);
		lmdcheck.setLayoutY(0);
		this.getChildren().addAll(lmdcheck);

	}

	public AlertTextPane(String text) {
		Text alertText = new Text();
		alertText.setFill(Color.WHITE);
		alertText.setFont(new Font(40));
		alertText.setX(75);
		alertText.setY(75);
		alertText.textProperty().setValue(text);
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
				Main.mainPane.getSelectPlace().setVisible(false);
				Main.mainPane.setVisibleNotEnoughmaterial(false);
				Main.mainPane.setVisibleSelecttionBtn(false);
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

	public void setText() {
		// TODO Auto-generated method stub
		if (Main.mainPane.getSelectedPlaceCard() == null) {
			if ((Main.mainPane.getSelectedCard() instanceof HaveChainSymbol && ChainSymbols
					.isHaveChainSymbol(GameController.getCurrentPlayer(), (HaveChainSymbol) Main.mainPane.getSelectedCard()))) {
				lmdcheck.textProperty().setValue("Build by Chain Symbol?");
			} else {
				lmdcheck.textProperty().setValue("Spend " + Cost.checkLmd(GameController.getCurrentPlayer().getResourceCounter(),
						Main.mainPane.getSelectedCard().getCost(), GameController.getCurrentPlayer().getbuyResourceCost())
						+ " LMD to build?");
			}
		}else {
			lmdcheck.textProperty()
			.setValue("Spend " + Cost.checkLmd(GameController.getCurrentPlayer().getResourceCounter(),
					Main.mainPane.getSelectedPlaceCard().getCost(), GameController.getCurrentPlayer().getbuyResourceCost())
					+ " LMD to build?");
		}
	}
}
