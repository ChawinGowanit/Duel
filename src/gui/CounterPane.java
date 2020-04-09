package gui;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class CounterPane extends StackPane {
	private Text text ;
	public CounterPane(String counter) {
		super();
		text = new Text();
		text.setFont(new Font(20));
		text.setFill(Color.WHITE);
		text.textProperty().setValue(counter);
		Image resourceRec = new Image("/gameUI/resourceRec.png");
		ImageView resourceRecImgView = new ImageView(resourceRec);
		resourceRecImgView.setFitWidth(70);
		resourceRecImgView.setFitHeight(50);
		this.getChildren().addAll(resourceRecImgView, text);
	}
	public Text getText() {
		return text;
	}
}
