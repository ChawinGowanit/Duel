package Card.base;

public class Cost {
	private int D32Steel;
	private int BipolarNanoflake;
	private int PolymerizationPreparation;
	private int SugarPack;
	private int ManganeseOre;
	private int LMD;

	public Cost() {
		this.D32Steel = 0;
		this.BipolarNanoflake = 0;
		this.PolymerizationPreparation = 0;
		this.SugarPack = 0;
		this.ManganeseOre = 0;
		this.LMD = 0;
	}

	public Cost(int D32Steel, int BipolarNanoflake, int PolymerizationPreparation, int SugarPack, int ManganeseOre,
			int LMD) {
		this.D32Steel = D32Steel;
		this.BipolarNanoflake = BipolarNanoflake;
		this.PolymerizationPreparation = PolymerizationPreparation;
		this.SugarPack = SugarPack;
		this.ManganeseOre = ManganeseOre;
		this.LMD = LMD;
	}

	public static Cost addCost(Cost cost1, Cost cost2) {
		Cost newCost = new Cost();
		newCost.D32Steel = cost1.D32Steel + cost2.D32Steel;
		newCost.BipolarNanoflake = cost1.BipolarNanoflake + cost2.BipolarNanoflake;
		newCost.PolymerizationPreparation = cost1.PolymerizationPreparation + cost2.PolymerizationPreparation;
		newCost.SugarPack = cost1.SugarPack + cost2.SugarPack;
		newCost.ManganeseOre = cost1.ManganeseOre + cost2.ManganeseOre;
		newCost.LMD = cost1.LMD + cost2.LMD;
		return newCost;
	}

	public String toString() {
		String output = "(D32Steel = " + this.D32Steel + ")(BipolarNanoflake = " + this.BipolarNanoflake
				+ ")(PolymerizationPreparation = " + this.PolymerizationPreparation + ")(SugarPack = " + this.SugarPack
				+ ")(ManganeseOre = " + this.ManganeseOre + ")(LMD = " + this.LMD + ")";
		return output;
	}

	public static Cost reduceCost(Cost cost1, Cost cost2) {
		Cost newCost = new Cost();
		if (cost1.D32Steel - cost2.D32Steel <= 0) {
			newCost.D32Steel = 0;
		} else {
			newCost.D32Steel = cost1.D32Steel - cost2.D32Steel;
		}
		if (cost1.BipolarNanoflake - cost2.BipolarNanoflake <= 0) {
			newCost.BipolarNanoflake = 0;
		} else {
			newCost.BipolarNanoflake = cost1.BipolarNanoflake - cost2.BipolarNanoflake;
		}
		if (cost1.PolymerizationPreparation - cost2.PolymerizationPreparation <= 0) {
			newCost.PolymerizationPreparation = 0;
		} else {
			newCost.PolymerizationPreparation = cost1.PolymerizationPreparation - cost2.PolymerizationPreparation;
		}
		if (cost1.SugarPack - cost2.SugarPack <= 0) {
			newCost.SugarPack = 0;
		} else {
			newCost.SugarPack = cost1.SugarPack - cost2.SugarPack;
		}
		if (cost1.ManganeseOre - cost2.ManganeseOre <= 0) {
			newCost.ManganeseOre = 0;
		} else {
			newCost.ManganeseOre = cost1.ManganeseOre - cost2.ManganeseOre;
		}
		if (cost1.LMD - cost2.LMD <= 0) {
			newCost.LMD = 0;
		} else {
			newCost.LMD = cost1.LMD - cost2.LMD;
		}
		return newCost;

	}

	public static boolean checkCost(Cost playerCost, Cost cardCost) {
		return (playerCost.D32Steel >= cardCost.D32Steel) && (playerCost.BipolarNanoflake >= cardCost.BipolarNanoflake)
				&& (playerCost.PolymerizationPreparation >= cardCost.PolymerizationPreparation)
				&& (playerCost.SugarPack >= cardCost.SugarPack) && (playerCost.ManganeseOre >= cardCost.ManganeseOre)
				&& (playerCost.LMD >= cardCost.LMD);

	}

	public static int checkLmd(Cost playerCost, Cost cardCost, Cost buyResourceCost) {
		// TODO Auto-generated method stub
		Cost haveToBuy = new Cost();
		if (playerCost.D32Steel < cardCost.D32Steel) {
			haveToBuy.D32Steel = cardCost.D32Steel - cardCost.D32Steel;
		}
		if (playerCost.BipolarNanoflake < cardCost.BipolarNanoflake) {
			haveToBuy.BipolarNanoflake = cardCost.BipolarNanoflake - cardCost.BipolarNanoflake;
		}
		if (playerCost.PolymerizationPreparation < cardCost.PolymerizationPreparation) {
			haveToBuy.PolymerizationPreparation = cardCost.PolymerizationPreparation- cardCost.PolymerizationPreparation;
		}
		if (playerCost.SugarPack < cardCost.SugarPack) {
			haveToBuy.SugarPack = cardCost.SugarPack - cardCost.SugarPack;
		}
		if (playerCost.ManganeseOre < cardCost.ManganeseOre) {
			haveToBuy.ManganeseOre = cardCost.ManganeseOre - cardCost.ManganeseOre;
		}
		if (playerCost.LMD < cardCost.LMD) {
			haveToBuy.LMD = cardCost.LMD - cardCost.LMD;
		}
		int LMD = 0;
		LMD += haveToBuy.D32Steel * buyResourceCost.D32Steel;
		LMD += haveToBuy.BipolarNanoflake * buyResourceCost.BipolarNanoflake;
		LMD += haveToBuy.PolymerizationPreparation * buyResourceCost.PolymerizationPreparation;
		LMD += haveToBuy.SugarPack * buyResourceCost.SugarPack;
		LMD += haveToBuy.ManganeseOre * buyResourceCost.ManganeseOre;
		return LMD ;
	}
	public void setLMD(int LMD) {
		this.LMD = LMD ;
	}
	public int getLMD() {
		return this.LMD;
	}
}
