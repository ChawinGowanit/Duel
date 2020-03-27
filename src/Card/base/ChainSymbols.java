package Card.base;

import java.util.ArrayList;

import logic.Player;

public class ChainSymbols {
	public ArrayList<String> chainSymbol;

	public ChainSymbols() {
		this.chainSymbol = new ArrayList<String>();
	}

	public ChainSymbols(String chainSymbol) {
		this.chainSymbol = new ArrayList<String>();
		this.chainSymbol.add(chainSymbol);
	}

	public ChainSymbols(String chainSymbol1, String chainSymbol2) {
		this.chainSymbol = new ArrayList<String>();
		this.chainSymbol.add(chainSymbol1);
		this.chainSymbol.add(chainSymbol2);
	}

	public void addChainSymbols(String chainSymbol1) {
		this.chainSymbol.add(chainSymbol1);
	}

	public ArrayList<String> getChainSymbol() {
		return this.chainSymbol;
	}

	public static boolean isHaveChainSymbol(Player player, HaveChainSymbol card) {
		for (String chainSymbol:card.getChainSymbols().chainSymbol) {
			for (String playerChainSymbol:player.getChainSymbols().chainSymbol) {
				if (chainSymbol.equals(playerChainSymbol)) {
					return true ;
				}
			}
		}
		return false ;
	}
}
