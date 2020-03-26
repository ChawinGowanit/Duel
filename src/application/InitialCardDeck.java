package application;

import java.util.ArrayList;
import Card.MilitaryCard;
import Card.PointCard;
import Card.RawMaterialCard;
import Card.TradingCard;
import Card.base.Card;
import Card.base.Cost;

public class InitialCardDeck {
	public ArrayList<Card> startingCard;
	public ArrayList<Card> midGameCard;
	public ArrayList<Card> lateGameCard;

	public InitialCardDeck() {
		// cardAgeOne
		this.startingCard = new ArrayList<Card>();
		this.startingCard.add(new MilitaryCard("Volcano Boss", new Cost(), 1, ""));
		this.startingCard.add(new MilitaryCard("Volcano Boss", new Cost(), 1, ""));
		this.startingCard.add(new MilitaryCard("Ambriel", new Cost(0, 0, 1, 0, 0, 0), 1, "Laternora"));
		this.startingCard.add(new MilitaryCard("Ifrit", new Cost(1, 0, 0, 0, 0, 0), 1, "Rhine Lab"));
		this.startingCard.add(new MilitaryCard("EarthSpirit", new Cost(0, 0, 0, 0, 0, 2), 1, "Leithanien"));
		this.startingCard.add(new PointCard("Lappland", new Cost(), 3, "Rhodes Island"));
		this.startingCard.add(new PointCard("Istina", new Cost(), 3, "Ursus"));
		this.startingCard.add(new PointCard("Meteor", new Cost(0, 1, 0, 0, 0, 0), 3, "Kazimierz"));
		this.startingCard.add(new RawMaterialCard("Cuora", new Cost(), new Cost(0, 0, 1, 0, 0, 0)));
		this.startingCard.add(new RawMaterialCard("Frostleaf", new Cost(0, 0, 0, 0, 0, 1), new Cost(0, 0, 1, 0, 0, 0)));
		this.startingCard.add(new RawMaterialCard("Courior", new Cost(), new Cost(1, 0, 0, 0, 0, 0)));
		this.startingCard.add(new RawMaterialCard("Matterhorn", new Cost(0, 0, 0, 0, 0, 1), new Cost(1, 0, 0, 0, 0, 0)));
		this.startingCard.add(new RawMaterialCard("Shirayuki", new Cost(), new Cost(0, 1, 0, 0, 0, 0)));
		this.startingCard.add(new RawMaterialCard("FlameBringer", new Cost(0, 0, 0, 0, 0, 1), new Cost(0, 1, 0, 0, 0, 0)));
		this.startingCard.add(new RawMaterialCard("Out-country", new Cost(0, 0, 0, 0, 0, 1), new Cost(0, 0, 0, 0, 1, 0)));
		this.startingCard.add(new RawMaterialCard("Forest", new Cost(0, 0, 0, 0, 0, 1), new Cost(0, 0, 0, 1, 0, 0)));
		this.startingCard.add(new TradingCard("Motoimaru", new Cost(0, 0, 0, 0, 0, 3), "", new Cost(),"decreaseBipolarNanoFlakeCost", 0));
		this.startingCard.add(new TradingCard("Shaw", new Cost(0, 0, 0, 0, 0, 3), "", new Cost(),"decreaseD32SteelCost", 0));
		this.startingCard.add(new TradingCard("Dur-Nar", new Cost(0, 0, 0, 0, 0, 3), "", new Cost(),"decreasePolymerizationPreparationCost", 0));
		this.startingCard.add(new TradingCard("Rope", new Cost(), "Rim Bilition", new Cost(0, 0, 0, 0, 0, 4), "", 0));
		// cardAgeTwo
		this.midGameCard = new ArrayList<Card>();
		this.midGameCard.add(new MilitaryCard("Reunion's Attack", new Cost(0, 2, 0, 0, 0, 0), 2, ""));
		this.midGameCard.add(new MilitaryCard("Reunion's Attack", new Cost(0, 0, 2, 0, 0, 0), 2, ""));
		this.midGameCard.add(new MilitaryCard("Saria", new Cost(0, 0, 0, 0, 0, 3), 1, "Rhine Lab"));
		this.midGameCard.add(new MilitaryCard("Swire", new Cost(0, 1, 1, 1, 0, 0), 2, "Lungman"));
		this.midGameCard.add(new MilitaryCard("Mostima", new Cost(1, 0, 1, 0, 0, 0), 1, "Laternora"));
		this.midGameCard.add(new MilitaryCard("W", new Cost(2, 0, 0, 0, 1, 0), 2, "Reunion"));
		this.midGameCard.add(new PointCard("Hellagur", new Cost(0, 0, 2, 0, 1, 0), 5, ""));
		this.midGameCard.add(new PointCard("Texas", new Cost(2, 0, 0, 0, 0, 0), 4, "Rhodes Island,Penguin Logistic"));
		this.midGameCard.add(new PointCard("Zima", new Cost(0, 0, 1, 1, 0, 0), 4, "Ursus,Victoria"));
		this.midGameCard.add(new PointCard("Platinum", new Cost(0, 3, 0, 0, 0, 0), 5, "Kazimierz"));
		this.midGameCard.add(new PointCard("Jessica", new Cost(0, 1, 1, 0, 0, 0), 4, "Black Steel"));
		this.midGameCard.add(new RawMaterialCard("Bison", new Cost(0, 0, 0, 0, 0, 2), new Cost(0, 0, 2, 0, 0, 0)));
		this.midGameCard.add(new RawMaterialCard("Vigna", new Cost(0, 0, 0, 0, 0, 2), new Cost(2, 0, 0, 0, 0, 0)));
		this.midGameCard.add(new RawMaterialCard("Grani", new Cost(0, 0, 0, 0, 0, 2), new Cost(0, 2, 0, 0, 0, 0)));
		this.midGameCard.add(new RawMaterialCard("Cave", new Cost(), new Cost(0, 0, 0, 0, 1, 0)));
		this.midGameCard.add(new RawMaterialCard("Village", new Cost(), new Cost(0, 0, 0, 1, 0, 0)));
		this.midGameCard.add(new TradingCard("Manticore", new Cost(1, 0, 0, 0, 0, 3), "", new Cost(0, 0, 0, 1, 1, 0), "", 0));
		this.midGameCard.add(new TradingCard("Executor", new Cost(0, 0, 0, 1, 1, 2), "", new Cost(1, 1, 1, 0, 0, 0), "", 0));
		this.midGameCard.add(new TradingCard("Cliffheart", new Cost(0, 0, 0, 0, 0, 4), "", new Cost(),"decreaseManganeseAndSugerCost", 0));
		this.midGameCard.add(new TradingCard("Pramanix", new Cost(), "Kjerag", new Cost(0, 0, 0, 0, 0, 6), "", 0));
		// cardAgeThree
		this.lateGameCard = new ArrayList<Card>();
		this.lateGameCard.add(new MilitaryCard("Reunion's Squad", new Cost(3, 0, 2, 0, 0, 0), 3, ""));
		this.lateGameCard.add(new MilitaryCard("Skullshatterer", new Cost(0, 0, 0, 0, 0, 8), 3, ""));
		this.lateGameCard.add(new MilitaryCard("Eyjafjalla", new Cost(1, 2, 0, 1, 0, 0), 2, "Leithanien"));
		this.lateGameCard.add(new MilitaryCard("Ch'en", new Cost(0, 0, 3, 0, 1, 0), 2, "Lungman"));
		this.lateGameCard.add(new MilitaryCard("Tulula", new Cost(2, 2, 0, 0, 0, 0), 2, "Reunion"));
		this.lateGameCard.add(new PointCard("Mayer", new Cost(1, 1, 1, 0, 2, 0), 7, ""));
		this.lateGameCard.add(new PointCard("Aak", new Cost(0, 3, 2, 0, 0, 0), 7, ""));
		this.lateGameCard.add(new PointCard("Hoshiguma", new Cost(0, 2, 0, 0, 1, 0), 5, ""));
		this.lateGameCard.add(new PointCard("Exusial", new Cost(2, 0, 2, 0, 0, 0), 6, "Penguin Logistic"));
		this.lateGameCard.add(new PointCard("Siege", new Cost(1, 0, 1, 2, 0, 0), 6, "Victoria"));
		this.lateGameCard.add(new PointCard("Liskarm", new Cost(2, 1, 0, 1, 0, 0), 5, "Black Steel"));
		this.lateGameCard.add(new TradingCard("Hung", new Cost(0, 0, 0, 2, 0, 0), "", new Cost(), "", 3));
		this.lateGameCard.add(new TradingCard("Nightingale", new Cost(0, 0, 1, 1, 1, 0), "", new Cost(), "", 3));
		this.lateGameCard.add(new TradingCard("Magallan", new Cost(0, 2, 0, 0, 1, 0), "", new Cost(), "", 3));
		this.lateGameCard.add(new TradingCard("Savage", new Cost(2, 0, 0, 0, 1, 0), "Rim Bilition", new Cost(), "", 3));
		this.lateGameCard.add(new TradingCard("Silverash", new Cost(1, 1, 1, 0, 0, 0), "Kjerag", new Cost(), "", 3));
	}
}
