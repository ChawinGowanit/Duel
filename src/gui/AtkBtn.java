package gui;

import application.GameController;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class AtkBtn extends Pane {
	public AtkBtn(int position) {
		Image Oddtile = new Image("/gameUI/Odd.png", 102, 99, false, false);
		ImageView OddtileImgView = new ImageView(Oddtile);
		Image Eventile = new Image("/gameUI/Even.png", 102, 99, false, false);
		ImageView EventileImgView = new ImageView(Eventile);
		if (position % 2 == 0) {
			this.getChildren().add(EventileImgView);
		} else {
			this.getChildren().add(OddtileImgView);
		}
		if (position == 1 || position == 3 || position == 6 || position == -1 || position == -3 || position == -6) {
			this.setTooltip(position);
		}
	}

	public AtkBtn(int position,boolean atkpos){
		Image AtkOddtile = new Image("/gameUI/AttackOdd.png",102,99,false,false);
		ImageView AtkOddtileImgView = new ImageView(AtkOddtile);
		Image AtkEventile = new Image("/gameUI/AttackEven.png",102,99,false,false);
		ImageView AtkEventileImgView = new ImageView(AtkEventile);
		if (position%2==0) {
			this.getChildren().add(AtkEventileImgView);
		} else {
			this.getChildren().add(AtkOddtileImgView);
		}
		this.setTooltip(position);
	}

	public void setTooltip(int position) {
		Tooltip tooltip = new Tooltip();
		tooltip.setFont(new Font(14));
		if (position == GameController.ATKboard.getPosition()) {
			tooltip.setText("Attack Position : "+GameController.ATKboard.getPosition());

		} else if (position == 1 && GameController.ATKboard.getPosAndCoinLoss().containsKey(1)) {
				tooltip.setText("Attack Position : 1 \n"+GameController.player1.getName()+" + 2 Points!");	
		} else if (position == 3 && GameController.ATKboard.getPosAndCoinLoss().containsKey(3)) {
				tooltip.setText("Attack Position : 3 \n"+GameController.player2.getName()+" - 2 LMD");		
		} else if (position == 6 && GameController.ATKboard.getPosAndCoinLoss().containsKey(6)) {
				tooltip.setText("Attack Position : 6 \n"+GameController.player2.getName()+" - 5 LMD");		
		} else if (position == -1 && GameController.ATKboard.getPosAndCoinLoss().containsKey(-1)) {
			tooltip.setText("Attack Position : -1 \n"+GameController.player2.getName()+" + 2 Points!");	
		} else if (position == -3 && GameController.ATKboard.getPosAndCoinLoss().containsKey(-3)) {
				tooltip.setText("Attack Position : -3 \n"+GameController.player1.getName()+" - 2 LMD");		
		} else if (position == -6 && GameController.ATKboard.getPosAndCoinLoss().containsKey(-6)) {
			tooltip.setText("Attack Position : -6 \n"+GameController.player1.getName()+" - 5 LMD");		
		}
			
			
			
			
			
		this.setOnMouseMoved((MouseEvent e) -> {
			tooltip.show(this, e.getScreenX(), e.getScreenY() + 10);
		});
		this.setOnMouseExited((MouseEvent e) -> {
			tooltip.hide();
		});
	}
}
