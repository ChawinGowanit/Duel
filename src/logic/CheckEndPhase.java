package logic;

import application.GameController;
import main.Main;

public class CheckEndPhase {
	
	public static void updateMainPane() {
		if (GameController.mainBoard.checkIfAllBlankCard(GameController.mainBoard.getCardOnBoard(GameController.getPhase()))) {
			if (GameController.getPhase()== 1) {
				GameController.setPhase(2);
				Main.newMainPane(2);
				
			} else if (GameController.getPhase()== 2) {
				GameController.setPhase(3);
				Main.newMainPane(3);
			} else {
				
			}
			
		}
	}

}
