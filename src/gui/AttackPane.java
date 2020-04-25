package gui;

import application.GameController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;

public class AttackPane extends HBox {
	private ObservableList<AtkBtn> AtkBtnList = FXCollections.observableArrayList();

	private int AtckPos;

	public AttackPane() {
		AtckPos = GameController.ATKboard.getPosition();
		for (int i = -9; i < 10; i++) {
			if (i == AtckPos) {
				AtkBtn atkBtn = new AtkBtn(i, true);
				this.getChildren().add(atkBtn);
				AtkBtnList.add(atkBtn);

			} else {
				AtkBtn atkBtn = new AtkBtn(i);
				this.getChildren().add(atkBtn);
				AtkBtnList.add(atkBtn);
			}
		}
		updateAttackPane();
	}

	public void updateAttackPane() {
		if (AtckPos % 2 == 0) {
			Image Eventile = new Image("/gameUI/Even.png", 102, 99, false, false);
			AtkBtnList.get(AtckPos + 9).getImgView().setImage(Eventile);
			;
		} else {
			Image Oddtile = new Image("/gameUI/Odd.png", 102, 99, false, false);
			AtkBtnList.get(AtckPos + 9).getImgView().setImage(Oddtile);
			;
		}
		AtckPos = GameController.ATKboard.getPosition();
		if (AtckPos > 9) {
			AtckPos = 9;
		} else if (AtckPos < -9) {
			AtckPos = -9;
		}
		if (AtckPos % 2 == 0) {
			Image AtkEventile = new Image("/gameUI/AttackEven.png", 102, 99, false, false);
			AtkBtnList.get(AtckPos + 9).getImgView().setImage(AtkEventile);
		} else {
			Image AtkOddtile = new Image("/gameUI/AttackOdd.png", 102, 99, false, false);
			AtkBtnList.get(AtckPos + 9).getImgView().setImage(AtkOddtile);
		}
		for (int i = -9; i < 10; i++) {
			AtkBtnList.get(i + 9).setTooltip(i);
		}
	}

}
