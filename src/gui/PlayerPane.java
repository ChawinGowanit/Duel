package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import application.GameController;

public class PlayerPane extends GridPane {
	private CounterPane pointPane;
	private CounterPane lmdPane;
	private CounterPane d32steelPane;
	private CounterPane d32steelCostPane;
	private CounterPane BipolarPane;
	private CounterPane BipolarCostPane;
	private CounterPane polymerizationPane;
	private CounterPane polymerizationCostPane;
	private CounterPane manganeseOrePane;
	private CounterPane manganeseOreCostPane;
	private CounterPane sugarpackPane;
	private CounterPane sugarpackCostPane;
	private String playerPoint;
	private String playerLMD;
	private String playerD32Steel;
	private String d32steelCost;
	private String playerBipolar;
	private String bipolarCost;
	private String playerPolymerization;
	private String polymerizationCost;
	private String playerManganeseOre;
	private String manganeseOreCost;
	private String playerSugarPack;
	private String sugarPackCost;

	public PlayerPane(int player) {
		this.setVgap(8);
		this.setHgap(8);
		this.setPadding(new Insets(8));
		this.setAlignment(Pos.CENTER);
		this.setPrefWidth(275);
		this.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
		Image nameRec = new Image("/gameUI/nameRec.png");
		ImageView nameRecImgView = new ImageView(nameRec);
		Text name = new Text();
		name.setFont(new Font(40));
		name.setFill(Color.WHITE);
		if (player == 1) {
			name.textProperty().setValue(GameController.player1.getName());
		} else {
			name.textProperty().setValue(GameController.player2.getName());
		}
		StackPane namePane = new StackPane();
		namePane.getChildren().addAll(nameRecImgView, name);
		this.add(namePane, 0, 0, 3, 1);
		UpdatePlayerPane(player);
		// BipolarNanoflake
		BipolarCostPane = new CounterPane(bipolarCost);
		BipolarPane = new CounterPane(playerBipolar);
		Image bipolarImg = new Image("/gameUI/Bipolar.png");
		ImageView bipolarImgView = new ImageView(bipolarImg);
		bipolarImgView.setFitWidth(50);
		bipolarImgView.setFitHeight(50);
		// D32steel
		d32steelCostPane = new CounterPane(d32steelCost);
		d32steelPane = new CounterPane(playerD32Steel);
		Image d32steelImg = new Image("/gameUI/d32steel.png");
		ImageView d32steelImgView = new ImageView(d32steelImg);
		d32steelImgView.setFitWidth(50);
		d32steelImgView.setFitHeight(50);
		// manganeseOre
		manganeseOreCostPane = new CounterPane(manganeseOreCost);
		manganeseOrePane = new CounterPane(playerManganeseOre);
		Image manganeseOreImg = new Image("/gameUI/manganeseOre.png");
		ImageView manganeseOreImgView = new ImageView(manganeseOreImg);
		manganeseOreImgView.setFitWidth(40);
		manganeseOreImgView.setFitHeight(50);
		// polymerization
		polymerizationCostPane = new CounterPane(polymerizationCost);
		polymerizationPane = new CounterPane(playerPolymerization);
		Image polymerizationImg = new Image("/gameUI/polymerization.png");
		ImageView polymerizationImgView = new ImageView(polymerizationImg);
		polymerizationImgView.setFitWidth(50);
		polymerizationImgView.setFitHeight(50);
		// sugar pack
		sugarpackCostPane = new CounterPane(sugarPackCost);
		sugarpackPane = new CounterPane(playerSugarPack);
		Image sugarPackImg = new Image("/gameUI/sugarpack.png");
		ImageView sugarPacImgView = new ImageView(sugarPackImg);
		sugarPacImgView.setFitWidth(50);
		sugarPacImgView.setFitHeight(50);
		// Point
		pointPane = new CounterPane(playerPoint);
		Image pointImg = new Image("/gameUI/point.png");
		ImageView pointImgView = new ImageView(pointImg);
		pointImgView.setFitWidth(50);
		pointImgView.setFitHeight(50);
		// LMD
		lmdPane = new CounterPane(playerLMD);
		Image lmdImg = new Image("/gameUI/lmd.png");
		ImageView lmdImgView = new ImageView(lmdImg);
		lmdImgView.setFitWidth(50);
		lmdImgView.setFitHeight(40);
		// add on player pane
		this.addRow(1, pointImgView, pointPane);
		this.addRow(2, lmdImgView, lmdPane);
		// this.addRow(3, arg1);
		this.addRow(4, d32steelImgView, d32steelPane, d32steelCostPane);
		this.addRow(5, bipolarImgView, BipolarPane, BipolarCostPane);
		this.addRow(6, polymerizationImgView, polymerizationPane, polymerizationCostPane);
		this.addRow(7, manganeseOreImgView, manganeseOrePane, manganeseOreCostPane);
		this.addRow(8, sugarPacImgView, sugarpackPane, sugarpackCostPane);

	}

	public void UpdatePlayerPane(int player) {
		if (player == 1) {
			this.playerPoint = Integer.toString(GameController.player1.getplayerPoint());
			this.playerLMD = Integer.toString(GameController.player1.getResourceCounter().getLMD());
			this.playerD32Steel = Integer.toString(GameController.player1.getResourceCounter().getD32Steel());
			this.d32steelCost = Integer.toString(GameController.player1.getbuyResourceCost().getD32Steel());
			this.playerBipolar = Integer.toString(GameController.player1.getResourceCounter().getBipolarNanoflake());
			this.bipolarCost = Integer.toString(GameController.player1.getbuyResourceCost().getBipolarNanoflake());
			this.playerPolymerization = Integer
					.toString(GameController.player1.getResourceCounter().getPolymerizationPreparation());
			this.polymerizationCost = Integer
					.toString(GameController.player1.getbuyResourceCost().getPolymerizationPreparation());
			this.playerManganeseOre = Integer.toString(GameController.player1.getResourceCounter().getManganeseOre());
			this.manganeseOreCost = Integer.toString(GameController.player1.getbuyResourceCost().getManganeseOre());
			this.playerSugarPack = Integer.toString(GameController.player1.getResourceCounter().getSugarPack());
			this.sugarPackCost = Integer.toString(GameController.player1.getbuyResourceCost().getSugarPack());
		} else {
			this.playerPoint = Integer.toString(GameController.player2.getplayerPoint());
			this.playerLMD = Integer.toString(GameController.player2.getResourceCounter().getLMD());
			this.playerD32Steel = Integer.toString(GameController.player2.getResourceCounter().getD32Steel());
			this.d32steelCost = Integer.toString(GameController.player2.getbuyResourceCost().getD32Steel());
			this.playerBipolar = Integer.toString(GameController.player2.getResourceCounter().getBipolarNanoflake());
			this.bipolarCost = Integer.toString(GameController.player2.getbuyResourceCost().getBipolarNanoflake());
			this.playerPolymerization = Integer
					.toString(GameController.player2.getResourceCounter().getPolymerizationPreparation());
			this.polymerizationCost = Integer
					.toString(GameController.player2.getbuyResourceCost().getPolymerizationPreparation());
			this.playerManganeseOre = Integer.toString(GameController.player2.getResourceCounter().getManganeseOre());
			this.manganeseOreCost = Integer.toString(GameController.player2.getbuyResourceCost().getManganeseOre());
			this.playerSugarPack = Integer.toString(GameController.player2.getResourceCounter().getSugarPack());
			this.sugarPackCost = Integer.toString(GameController.player2.getbuyResourceCost().getSugarPack());
		}

	}
	public void updatePlayerPaneScreen() {

		BipolarCostPane.getText().textProperty().setValue(bipolarCost); 
		BipolarPane.getText().textProperty().setValue(playerBipolar); 

		d32steelCostPane .getText().textProperty().setValue(d32steelCost); 
		d32steelPane.getText().textProperty().setValue(playerD32Steel); 

		manganeseOreCostPane.getText().textProperty().setValue(manganeseOreCost); 
		manganeseOrePane.getText().textProperty().setValue(playerManganeseOre); 

		polymerizationCostPane.getText().textProperty().setValue(polymerizationCost); 
		polymerizationPane.getText().textProperty().setValue(playerPolymerization); 

		sugarpackCostPane.getText().textProperty().setValue(sugarPackCost); 
		sugarpackPane.getText().textProperty().setValue(playerSugarPack); 

		pointPane.getText().textProperty().setValue(playerPoint); 

		lmdPane.getText().textProperty().setValue(playerLMD); 

	}
}
