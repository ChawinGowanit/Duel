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
}
