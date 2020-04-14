package gui;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;
import main.Main;
import Card.base.ChainSymbols;
import application.GameController;


public class PlayerPane extends GridPane {
	public static FadeTransition fade1 = new FadeTransition();
	public static FadeTransition fade2 = new FadeTransition();
	private StackPane namePane ;
	private CounterPane pointPane;
	private CounterPane lmdPane;
	private CounterPane sellCardGainPane;
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
	private String sellCardGain;
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
	private ChainSymbols playerChainSymbols;
	private int i = 0;
	private int j = 9;

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
		namePane = new StackPane();
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
		Tooltip Bipolartooltip = new Tooltip();
		Bipolartooltip.setFont(new Font(16));
		Bipolartooltip.setText("Bipolar Nanoflake");
		bipolarImgView.setOnMouseMoved((MouseEvent e) -> {
			Bipolartooltip.show(this, e.getScreenX(), e.getScreenY() + 10);
		});
		bipolarImgView.setOnMouseExited((MouseEvent e) -> {
			Bipolartooltip.hide();
		});
		// D32steel
		d32steelCostPane = new CounterPane(d32steelCost);
		d32steelPane = new CounterPane(playerD32Steel);
		Image d32steelImg = new Image("/gameUI/d32steel.png");
		ImageView d32steelImgView = new ImageView(d32steelImg);
		d32steelImgView.setFitWidth(50);
		d32steelImgView.setFitHeight(50);
		Tooltip d32Steeltooltip = new Tooltip();
		d32Steeltooltip.setFont(new Font(16));
		d32Steeltooltip.setText("D32 Steel");
		d32steelImgView.setOnMouseMoved((MouseEvent e) -> {
			d32Steeltooltip.show(this, e.getScreenX(), e.getScreenY() + 10);
		});
		d32steelImgView.setOnMouseExited((MouseEvent e) -> {
			d32Steeltooltip.hide();
		});
		// manganeseOre
		manganeseOreCostPane = new CounterPane(manganeseOreCost);
		manganeseOrePane = new CounterPane(playerManganeseOre);
		Image manganeseOreImg = new Image("/gameUI/manganeseOre.png");
		ImageView manganeseOreImgView = new ImageView(manganeseOreImg);
		manganeseOreImgView.setFitWidth(40);
		manganeseOreImgView.setFitHeight(50);
		Tooltip manganeseOretooltip = new Tooltip();
		manganeseOretooltip.setFont(new Font(16));
		manganeseOretooltip.setText("Manganese Ore");
		manganeseOreImgView.setOnMouseMoved((MouseEvent e) -> {
			manganeseOretooltip.show(this, e.getScreenX(), e.getScreenY() + 10);
		});
		manganeseOreImgView.setOnMouseExited((MouseEvent e) -> {
			manganeseOretooltip.hide();
		});
		// polymerization
		polymerizationCostPane = new CounterPane(polymerizationCost);
		polymerizationPane = new CounterPane(playerPolymerization);
		Image polymerizationImg = new Image("/gameUI/polymerization.png");
		ImageView polymerizationImgView = new ImageView(polymerizationImg);
		polymerizationImgView.setFitWidth(50);
		polymerizationImgView.setFitHeight(50);
		Tooltip polymerizationtooltip = new Tooltip();
		polymerizationtooltip.setFont(new Font(16));
		polymerizationtooltip.setText("Polymerization Preperation");
		polymerizationImgView.setOnMouseMoved((MouseEvent e) -> {
			polymerizationtooltip.show(this, e.getScreenX(), e.getScreenY() + 10);
		});
		polymerizationImgView.setOnMouseExited((MouseEvent e) -> {
			polymerizationtooltip.hide();
		});
		// sugar pack
		sugarpackCostPane = new CounterPane(sugarPackCost);
		sugarpackPane = new CounterPane(playerSugarPack);
		Image sugarPackImg = new Image("/gameUI/sugarpack.png");
		ImageView sugarPacImgView = new ImageView(sugarPackImg);
		sugarPacImgView.setFitWidth(50);
		sugarPacImgView.setFitHeight(50);
		Tooltip sugerPacktooltip = new Tooltip();
		sugerPacktooltip.setFont(new Font(16));
		sugerPacktooltip.setText("Sugar Pack");
		sugarPacImgView.setOnMouseMoved((MouseEvent e) -> {
			sugerPacktooltip.show(this, e.getScreenX(), e.getScreenY() + 10);
		});
		sugarPacImgView.setOnMouseExited((MouseEvent e) -> {
			sugerPacktooltip.hide();
		});
		// Point
		pointPane = new CounterPane(playerPoint);
		Image pointImg = new Image("/gameUI/point.png");
		ImageView pointImgView = new ImageView(pointImg);
		pointImgView.setFitWidth(50);
		pointImgView.setFitHeight(50);
		Tooltip pointTooltip = new Tooltip();
		pointTooltip.setFont(new Font(16));
		pointTooltip.setText("Point");
		pointImgView.setOnMouseMoved((MouseEvent e) -> {
			pointTooltip.show(this, e.getScreenX(), e.getScreenY() + 10);
		});
		pointImgView.setOnMouseExited((MouseEvent e) -> {
			pointTooltip.hide();
		});
		// LMD
		lmdPane = new CounterPane(playerLMD);
		Image lmdImg = new Image("/gameUI/lmd.png");
		ImageView lmdImgView = new ImageView(lmdImg);
		lmdImgView.setFitWidth(50);
		lmdImgView.setFitHeight(40);
		Tooltip lmdtooltip = new Tooltip();
		lmdtooltip.setFont(new Font(14));
		lmdtooltip.setText("LMD");
		lmdImgView.setOnMouseMoved((MouseEvent e) -> {
			lmdtooltip.show(this, e.getScreenX(), e.getScreenY() + 10);
		});
		lmdImgView.setOnMouseExited((MouseEvent e) -> {
			lmdtooltip.hide();
		});
		// sell Card Gain
		sellCardGainPane = new CounterPane(sellCardGain);
		Image sellCardGainImg = new Image("/gameUI/sellCardGain.png");
		ImageView sellCardGainImgView = new ImageView(sellCardGainImg);
		sellCardGainImgView.setFitWidth(50);
		sellCardGainImgView.setFitHeight(50);
		Tooltip sellCardGaintooltip = new Tooltip();
		sellCardGaintooltip.setFont(new Font(16));
		sellCardGaintooltip.setText("Sell Card Gain");
		sellCardGainImgView.setOnMouseMoved((MouseEvent e) -> {
			sellCardGaintooltip.show(this, e.getScreenX(), e.getScreenY() + 10);
		});
		sellCardGainImgView.setOnMouseExited((MouseEvent e) -> {
			sellCardGaintooltip.hide();
		});
		// add on player pane
		this.addRow(1, pointImgView, pointPane);
		this.addRow(2, lmdImgView, lmdPane);
		this.addRow(3, sellCardGainImgView, sellCardGainPane);
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
			this.sellCardGain = Integer.toString(GameController.player1.getSellResourceGain());
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
			this.playerChainSymbols = GameController.player1.getChainSymbols();
		} else {
			this.playerPoint = Integer.toString(GameController.player2.getplayerPoint());
			this.playerLMD = Integer.toString(GameController.player2.getResourceCounter().getLMD());
			this.sellCardGain = Integer.toString(GameController.player2.getSellResourceGain());
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
			this.playerChainSymbols = GameController.player2.getChainSymbols();
		}

	}

	public void updatePlayerPaneScreen() {
		this.fade2.setNode(Main.player2Pane.namePane);
		this.fade1.setNode(Main.player1Pane.namePane);
		if (GameController.getCurrentPlayer().getNum() == 1) {
			
			Main.player2Pane.fade2.stop();
			Main.player2Pane.fade2.setFromValue(1);
			Main.player2Pane.fade2.setToValue(1);
			Main.player2Pane.fade2.setCycleCount(1);
			Main.player2Pane.fade2.setDuration(Duration.millis(1));
			Main.player2Pane.fade2.setAutoReverse(true);
			Main.player2Pane.fade2.play();
			
			Main.player1Pane.fade1.stop();
			Main.player1Pane.fade1.setFromValue(1);
			Main.player1Pane.fade1.setToValue(0.2);
			Main.player1Pane.fade1.setCycleCount(Animation.INDEFINITE);
			Main.player1Pane.fade1.setDuration(Duration.millis(500));
			Main.player1Pane.fade1.setAutoReverse(true);
			Main.player1Pane.fade1.play();
		}else {
			
			Main.player1Pane.fade1.stop();
			Main.player1Pane.fade1.setFromValue(1);
			Main.player1Pane.fade1.setToValue(1);
			Main.player1Pane.fade1.setCycleCount(1);
			Main.player1Pane.fade1.setDuration(Duration.millis(1));
			Main.player1Pane.fade1.setAutoReverse(true);
			Main.player1Pane.fade1.play();
			
			Main.player2Pane.fade2.stop();
			Main.player2Pane.fade2.setFromValue(1);
			Main.player2Pane.fade2.setToValue(0.2);
			Main.player2Pane.fade2.setCycleCount(Animation.INDEFINITE);
			Main.player2Pane.fade2.setDuration(Duration.millis(500));
			Main.player2Pane.fade2.setAutoReverse(true);
			Main.player2Pane.fade2.play();
		}
		BipolarCostPane.getText().textProperty().setValue(bipolarCost);
		BipolarPane.getText().textProperty().setValue(playerBipolar);

		d32steelCostPane.getText().textProperty().setValue(d32steelCost);
		d32steelPane.getText().textProperty().setValue(playerD32Steel);

		manganeseOreCostPane.getText().textProperty().setValue(manganeseOreCost);
		manganeseOrePane.getText().textProperty().setValue(playerManganeseOre);

		polymerizationCostPane.getText().textProperty().setValue(polymerizationCost);
		polymerizationPane.getText().textProperty().setValue(playerPolymerization);

		sugarpackCostPane.getText().textProperty().setValue(sugarPackCost);
		sugarpackPane.getText().textProperty().setValue(playerSugarPack);

		pointPane.getText().textProperty().setValue(playerPoint);

		lmdPane.getText().textProperty().setValue(playerLMD);

		sellCardGainPane.getText().textProperty().setValue(sellCardGain);
	}

	public void printChainSymbol(String chainSymbol) {
		Image chainSymbolsImg = new Image("/chainSymbol/" + chainSymbol + ".png");
		ImageView chainSymbolsImgView = new ImageView(chainSymbolsImg);
		chainSymbolsImgView.setFitWidth(60);
		chainSymbolsImgView.setFitHeight(60);
		Tooltip tooltip = new Tooltip();
		tooltip.setFont(new Font(14));
		tooltip.setText("Chain Symbol : " + chainSymbol);
		chainSymbolsImgView.setOnMouseMoved((MouseEvent e) -> {
			tooltip.show(this, e.getScreenX(), e.getScreenY() + 10);
		});
		chainSymbolsImgView.setOnMouseExited((MouseEvent e) -> {
			tooltip.hide();
		});
		if (i < 3) {
			this.addRow(j, chainSymbolsImgView);
			i++;
			if (i == 3) {
				j++;
				i = 0;
			}
		}
	}
	
}
