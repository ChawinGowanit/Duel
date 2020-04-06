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
import Card.base.Cost;
import application.GameController;

public class PlayerPane extends GridPane {
	public PlayerPane(int player) {
		Cost playerCounter = new Cost();
		Cost buyCounter = new Cost();
		this.setVgap(8);
		this.setHgap(8);
		this.setPadding(new Insets(8));
		this.setAlignment(Pos.CENTER);
		this.setPrefWidth(275);
		this.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
		Image nameRec = new Image("/gameUI/nameRec.png");
		ImageView nameRecImgView = new ImageView(nameRec);
		Text name = new Text();
		int point = 0;
		name.setFont(new Font(40));
		name.setFill(Color.WHITE);
		if (player == 1) {
			name.textProperty().setValue(GameController.player1.getName());
			playerCounter = GameController.player1.getResourceCounter();
			buyCounter = GameController.player1.getbuyResourceCost();
			point = GameController.player1.getplayerPoint();
		} else {
			name.textProperty().setValue(GameController.player2.getName());
			playerCounter = GameController.player2.getResourceCounter();
			buyCounter = GameController.player2.getbuyResourceCost();
			point = GameController.player2.getplayerPoint();
		}
		StackPane namePane = new StackPane();
		namePane.getChildren().addAll(nameRecImgView, name);
		this.add(namePane, 0, 0, 3, 1);
		//BipolarNanoflake
			//BipolarnanoflakeCost
		Image BipolarResourceCostRec = new Image("/gameUI/resourceRec.png");
		ImageView BipolarResourceCostRecImgView = new ImageView(BipolarResourceCostRec);
		BipolarResourceCostRecImgView.setFitWidth(70);
		BipolarResourceCostRecImgView.setFitHeight(50);
		String BipolarCost = Integer.toString(buyCounter.getBipolarNanoflake());
		Text BipolarCosttext = new Text();
		BipolarCosttext.setFont(new Font(20));
		BipolarCosttext.setFill(Color.WHITE);
		BipolarCosttext.textProperty().setValue(BipolarCost);
		StackPane BipolarCostPane = new StackPane();
		BipolarCostPane.getChildren().addAll(BipolarResourceCostRecImgView,BipolarCosttext);
			//BipolarNanoflake counter
		Image BipolarResourceRec = new Image("/gameUI/resourceRec.png");
		ImageView BipolarResourceRecImgView = new ImageView(BipolarResourceRec);
		BipolarResourceRecImgView.setFitWidth(70);
		BipolarResourceRecImgView.setFitHeight(50);
		String Bipolar = Integer.toString(playerCounter.getBipolarNanoflake());
		Text Bipolartext = new Text();
		Bipolartext.setFont(new Font(20));
		Bipolartext.setFill(Color.WHITE);
		Bipolartext.textProperty().setValue(Bipolar);
		StackPane BipolarPane = new StackPane();
		BipolarPane.getChildren().addAll(BipolarResourceRecImgView,Bipolartext);
			//BipolarNanoflakeImg
		Image bipolarImg = new Image("/gameUI/Bipolar.png");
		ImageView bipolarImgView = new ImageView(bipolarImg);
		bipolarImgView.setFitWidth(50);
		bipolarImgView.setFitHeight(50);
		//D32steel
			//D32steelCost
		Image d32steelCostRec = new Image("/gameUI/resourceRec.png");
		ImageView d32steelCostRecImgView = new ImageView(d32steelCostRec);
		d32steelCostRecImgView.setFitWidth(70);
		d32steelCostRecImgView.setFitHeight(50);
		String d32steelCost = Integer.toString(buyCounter.getD32Steel());
		Text d32steelCosttext = new Text();
		d32steelCosttext.setFont(new Font(20));
		d32steelCosttext.setFill(Color.WHITE);
		d32steelCosttext.textProperty().setValue(d32steelCost);
		StackPane d32steelCostPane = new StackPane();
		d32steelCostPane.getChildren().addAll(d32steelCostRecImgView,d32steelCosttext);
			//D32steel counter
		Image d32ResourceRec = new Image("/gameUI/resourceRec.png");
		ImageView d32ResourceRecImgView = new ImageView(d32ResourceRec);
		d32ResourceRecImgView.setFitWidth(70);
		d32ResourceRecImgView.setFitHeight(50);
		String d32steel = Integer.toString(playerCounter.getD32Steel());
		Text d32steeltext = new Text();
		d32steeltext.setFont(new Font(20));
		d32steeltext.setFill(Color.WHITE);
		d32steeltext.textProperty().setValue(d32steel);
		StackPane d32steelPane = new StackPane();
		d32steelPane.getChildren().addAll(d32ResourceRecImgView,d32steeltext);
			//D32steel img
		Image d32steelImg = new Image("/gameUI/d32steel.png");
		ImageView d32steelImgView = new ImageView(d32steelImg);
		d32steelImgView.setFitWidth(50);
		d32steelImgView.setFitHeight(50);
		//manganeseOre
			//manganeseOreCost
		Image manganeseOreCostRec = new Image("/gameUI/resourceRec.png");
		ImageView manganeseOreCostRecImgView = new ImageView(manganeseOreCostRec);
		manganeseOreCostRecImgView.setFitWidth(70);
		manganeseOreCostRecImgView.setFitHeight(50);
		String manganeseOreCost = Integer.toString(buyCounter.getManganeseOre());
		Text manganeseOreCosttext = new Text();
		manganeseOreCosttext.setFont(new Font(20));
		manganeseOreCosttext.setFill(Color.WHITE);
		manganeseOreCosttext.textProperty().setValue(manganeseOreCost);
		StackPane manganeseOreCostPane = new StackPane();
		manganeseOreCostPane.getChildren().addAll(manganeseOreCostRecImgView,manganeseOreCosttext);
			//manganeseOreCounter
		Image manganeseOreRec = new Image("/gameUI/resourceRec.png");
		ImageView manganeseOreRecImgView = new ImageView(manganeseOreRec);
		manganeseOreRecImgView.setFitWidth(70);
		manganeseOreRecImgView.setFitHeight(50);
		String  manganeseOre = Integer.toString(playerCounter.getManganeseOre());
		Text manganeseOretext = new Text();
		manganeseOretext.setFont(new Font(20));
		manganeseOretext.setFill(Color.WHITE);
		manganeseOretext.textProperty().setValue(manganeseOre);
		StackPane manganeseOrePane = new StackPane();
		manganeseOrePane.getChildren().addAll(manganeseOreRecImgView,manganeseOretext);
			//manganeseOreImg
		Image manganeseOreImg = new Image("/gameUI/manganeseOre.png");
		ImageView manganeseOreImgView = new ImageView(manganeseOreImg);
		manganeseOreImgView.setFitWidth(40);
		manganeseOreImgView.setFitHeight(50);
		//polymerization
			//polymerizationCost
		Image polymerizationCostRec = new Image("/gameUI/resourceRec.png");
		ImageView polymerizationCostRecImgView = new ImageView(polymerizationCostRec);
		polymerizationCostRecImgView.setFitWidth(70);
		polymerizationCostRecImgView.setFitHeight(50);
		String polymerizationCost = Integer.toString(buyCounter.getPolymerizationPreparation());
		Text polymerizationCosttext = new Text();
		polymerizationCosttext.setFont(new Font(20));
		polymerizationCosttext.setFill(Color.WHITE);
		polymerizationCosttext.textProperty().setValue(polymerizationCost);
		StackPane polymerizationCostPane = new StackPane();
		polymerizationCostPane.getChildren().addAll(polymerizationCostRecImgView,polymerizationCosttext);
			//polymerizationCounter
		Image polymerizationRec = new Image("/gameUI/resourceRec.png");
		ImageView polymerizationRecImgView = new ImageView(polymerizationRec);
		polymerizationRecImgView.setFitWidth(70);
		polymerizationRecImgView.setFitHeight(50);
		String  polymerization = Integer.toString(playerCounter.getPolymerizationPreparation());
		Text polymerizationtext = new Text();
		polymerizationtext.setFont(new Font(20));
		polymerizationtext.setFill(Color.WHITE);
		polymerizationtext.textProperty().setValue(polymerization);
		StackPane polymerizationPane = new StackPane();
		polymerizationPane.getChildren().addAll(polymerizationRecImgView,polymerizationtext);
			//polymerizationImg
		Image polymerizationImg = new Image("/gameUI/polymerization.png");
		ImageView polymerizationImgView = new ImageView(polymerizationImg);
		polymerizationImgView.setFitWidth(50);
		polymerizationImgView.setFitHeight(50);
		//sugar pack
			//sugarpackCost
		Image sugarpackCostRec = new Image("/gameUI/resourceRec.png");
		ImageView sugarpackRecCostImgView = new ImageView(sugarpackCostRec);
		sugarpackRecCostImgView.setFitWidth(70);
		sugarpackRecCostImgView.setFitHeight(50);
		String sugarpackRecCost = Integer.toString(buyCounter.getSugarPack());
		Text sugarpackRecCosttext = new Text();
		sugarpackRecCosttext.setFont(new Font(20));
		sugarpackRecCosttext.setFill(Color.WHITE);
		sugarpackRecCosttext.textProperty().setValue(sugarpackRecCost);
		StackPane sugarpackRecCostPane = new StackPane();
		sugarpackRecCostPane.getChildren().addAll(sugarpackRecCostImgView,sugarpackRecCosttext);
			//sugarpackCounter
		Image sugarpackRec = new Image("/gameUI/resourceRec.png");
		ImageView sugarpackRecImgView = new ImageView(sugarpackRec);
		sugarpackRecImgView.setFitWidth(70);
		sugarpackRecImgView.setFitHeight(50);
		String  sugarpack = Integer.toString(playerCounter.getSugarPack());
		Text sugarpacktext = new Text();
		sugarpacktext.setFont(new Font(20));
		sugarpacktext.setFill(Color.WHITE);
		sugarpacktext.textProperty().setValue(sugarpack);
		StackPane sugarpackPane = new StackPane();
		sugarpackPane.getChildren().addAll(sugarpackRecImgView,sugarpacktext);
			//sugarpackCImg
		Image sugarPackImg = new Image("/gameUI/sugarpack.png");
		ImageView sugarPacImgView = new ImageView(sugarPackImg);
		sugarPacImgView.setFitWidth(50);
		sugarPacImgView.setFitHeight(50);	
		// Point
			//PointCounter
		Text pointStr = new Text();
		pointStr.setFont(new Font(20));
		pointStr.setFill(Color.WHITE);
		pointStr.textProperty().setValue(Integer.toString(point));
		Image resourceRec = new Image("/gameUI/resourceRec.png");
		ImageView resourceRecImgView = new ImageView(resourceRec);
		resourceRecImgView.setFitWidth(70);
		resourceRecImgView.setFitHeight(50);
		StackPane pointPane = new StackPane();
		pointPane.getChildren().addAll(resourceRecImgView,pointStr);
			//PointImg
		Image pointImg = new Image("/gameUI/point.png");
		ImageView pointImgView = new ImageView(pointImg);
		pointImgView.setFitWidth(50);
		pointImgView.setFitHeight(50);
		//LMD
			//LMDCounter
		Image lmdResourceRec = new Image("/gameUI/resourceRec.png");
		ImageView lmdResourceRecImgView = new ImageView(lmdResourceRec);
		lmdResourceRecImgView.setFitWidth(70);
		lmdResourceRecImgView.setFitHeight(50);
		String lmd = Integer.toString(playerCounter.getLMD());
		Text lmdtext = new Text();
		lmdtext.setFont(new Font(20));
		lmdtext.setFill(Color.WHITE);
		lmdtext.textProperty().setValue(lmd);
		StackPane lmdPane = new StackPane();
		lmdPane.getChildren().addAll(lmdResourceRecImgView,lmdtext);
			//LMDImg
		Image lmdImg = new Image("/gameUI/lmd.png");
		ImageView lmdImgView = new ImageView(lmdImg);
		lmdImgView.setFitWidth(50);
		lmdImgView.setFitHeight(40);	
		//add on player pane
		this.addRow(1, pointImgView, pointPane);
		this.addRow(2, lmdImgView,lmdPane);
		// this.addRow(3, arg1);
		this.addRow(4, d32steelImgView,d32steelPane,d32steelCostPane);
		this.addRow(5, bipolarImgView,BipolarPane,BipolarCostPane);
		this.addRow(6, polymerizationImgView,polymerizationPane,polymerizationCostPane);
		this.addRow(7, manganeseOreImgView,manganeseOrePane,manganeseOreCostPane);
		this.addRow(8, sugarPacImgView,sugarpackPane,sugarpackRecCostPane);

	}
	
	
	public void UpdatePlayerPane() {
		
	}
}
