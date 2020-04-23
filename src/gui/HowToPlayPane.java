package gui;

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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import main.Main;

public class HowToPlayPane extends Pane {
	private int clicktime = 1;
	private String tooltip = "";
	private Tooltip tt = new Tooltip();
	private static MediaPlayer mediaPlayer;

	public HowToPlayPane() {
		this.setPrefSize(1358, 744);
		this.setBackground(new Background(new BackgroundImage(
				new Image("/howToPlay/"+clicktime+".png", 1358, 744, false, true), BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
		tt = new Tooltip();
		tt.setFont(new Font(20));
		tooltip = "1/12\nClick to view next";
		tt.setText(tooltip);
		this.setOnMouseMoved((MouseEvent e) -> {
			tt.show(this, e.getScreenX() + 10, e.getScreenY() + 10);
		});
		this.setOnMouseExited((MouseEvent e) -> {
			tt.hide();
		});
		this.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				tt.hide();
				Media musicFile = new Media(ClassLoader.getSystemResource("buttonClickSound.mp3").toString());
				MediaPlayer buttonClick = new MediaPlayer(musicFile);
				mediaPlayer = buttonClick;
				mediaPlayer.setAutoPlay(true);
				mediaPlayer.setVolume(1);
				UpdateHowToPlayPane();
			}
		});
	}
	public void UpdateHowToPlayPane() {
		tt = new Tooltip();
		tt.setFont(new Font(20));
		if (clicktime!=11) {
			tooltip = clicktime+1+"/12\nClick to view next";
		} else {
			tooltip = "12/12\nClick to close";
		}
		tt.setText(tooltip);
		this.setOnMouseMoved((MouseEvent e) -> {
			tt.show(this, e.getScreenX() + 10, e.getScreenY() + 10);
		});
		this.setOnMouseExited((MouseEvent e) -> {
			tt.hide();
		});		if (clicktime != 12) {
			clicktime++;
			this.setBackground(new Background(new BackgroundImage(
					new Image("/howToPlay/"+clicktime+".png", 1358, 744, false, true), BackgroundRepeat.NO_REPEAT,
					BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
		} else {
			Main.startBtnImageView.setDisable(false);
			Main.howtoPlayImgView.setDisable(false);
			this.setVisible(false);
		}
	}

}
