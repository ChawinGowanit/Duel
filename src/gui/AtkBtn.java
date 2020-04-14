package gui;

import application.GameController;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;

public class AtkBtn extends StackPane {
	private ImageView imgView;
	private Tooltip tooltip;

	public AtkBtn(int position) {
		super();
		Image Oddtile = new Image("/gameUI/Odd.png", 102, 99, false, false);
		Image Eventile = new Image("/gameUI/Even.png", 102, 99, false, false);
		if (position % 2 == 0) {
			imgView = new ImageView(Eventile);
			this.getChildren().add(imgView);
		} else {
			imgView = new ImageView(Oddtile);
			this.getChildren().add(imgView);
		}
		if (position == 1 || position == 3 || position == 6 || position == -1 || position == -3 || position == -6) {
			this.setTooltip(position);
		}
	}

	public AtkBtn(int position, boolean atkpos) {
		super();
		Image AtkOddtile = new Image("/gameUI/AttackOdd.png", 102, 99, false, false);
		Image AtkEventile = new Image("/gameUI/AttackEven.png", 102, 99, false, false);
		if (position % 2 == 0) {
			imgView = new ImageView(AtkEventile);
			this.getChildren().add(imgView);
		} else {
			imgView = new ImageView(AtkOddtile);
			this.getChildren().add(imgView);
		}
		this.setTooltip(position);
	}

	public void setTooltip(int position) {
		tooltip = new Tooltip();
		tooltip.setFont(new Font(16));
		if (position == GameController.ATKboard.getPosition()) {
			tooltip.setText("Attack Position : " + GameController.ATKboard.getPosition());
		} else if (position == 1 && GameController.ATKboard.getPosAndCoinLoss().containsKey(1)) {
			tooltip.setText("Attack Position : 1 \n" + GameController.player1.getName() + " + 2 Points!");
		} else if (position == 3 && GameController.ATKboard.getPosAndCoinLoss().containsKey(3)) {
			tooltip.setText("Attack Position : 3 \n" + GameController.player2.getName() + " - 2 LMD");
		} else if (position == 6 && GameController.ATKboard.getPosAndCoinLoss().containsKey(6)) {
			tooltip.setText("Attack Position : 6 \n" + GameController.player2.getName() + " - 5 LMD");
		} else if (position == -1 && GameController.ATKboard.getPosAndCoinLoss().containsKey(-1)) {
			tooltip.setText("Attack Position : -1 \n" + GameController.player2.getName() + " + 2 Points!");
		} else if (position == -3 && GameController.ATKboard.getPosAndCoinLoss().containsKey(-3)) {
			tooltip.setText("Attack Position : -3 \n" + GameController.player1.getName() + " - 2 LMD");
		} else if (position == -6 && GameController.ATKboard.getPosAndCoinLoss().containsKey(-6)) {
			tooltip.setText("Attack Position : -6 \n" + GameController.player1.getName() + " - 5 LMD");
		} else {
			tooltip = null;
		}
		this.setOnMouseMoved((MouseEvent e) -> {
			if (tooltip != null) {
				tooltip.show(this, e.getScreenX()+10, e.getScreenY());
			}
		});
		this.setOnMouseExited((MouseEvent e) -> {
			if (tooltip != null) {
				tooltip.hide();
			}
		});
	}

	public ImageView getImgView() {
		return imgView;
	}

	public void setImgView(ImageView imgView) {
		this.imgView = imgView;
	}
}
