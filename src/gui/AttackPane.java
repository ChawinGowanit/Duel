package gui;

import application.GameController;

import javafx.scene.layout.HBox;

public class AttackPane extends HBox{
	private int AtckPos;
	public AttackPane() {
		AtckPos = GameController.ATKboard.getPosition() ;
		for (int i =-9;i < 10;i++) {
			if (i == AtckPos) {
				this.getChildren().add(new AtkBtn(i,true));
			} else {
				this.getChildren().add(new AtkBtn(i));

			}
		}
		updateAttackPane();
	}
	
	public void updateAttackPane(){
		if (GameController.ATKboard.getPosition()!= AtckPos) {
			AtckPos = GameController.ATKboard.getPosition();
			GameController.ATKboard.getPosition();
		}
		
	}
}
