package Card.base;

import java.util.ArrayList;

import application.GameController;
import logic.Player;
import main.Main;

public class ChainSymbols {
	private ArrayList<String> chainSymbol;

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

	public boolean addChainSymbols(String chainSymbol1) {
		for (String ChainSymbols : chainSymbol) {
			if (chainSymbol1.equals(ChainSymbols)) {
				return false;
			}
		}
		this.chainSymbol.add(chainSymbol1);
		if (GameController.getCurrentPlayer().getNum() == 1) {
			Main.player1Pane.printChainSymbol(chainSymbol1);
		} else {
			Main.player2Pane.printChainSymbol(chainSymbol1);
		}
		return true;
	}

	public ArrayList<String> getChainSymbol() {
		return this.chainSymbol;
	}

	public static boolean isHaveChainSymbol(Player player, HaveChainSymbol card) {
		for (String chainSymbol : card.getChainSymbols().chainSymbol) {
			for (String playerChainSymbol : player.getChainSymbols().chainSymbol) {
				if (chainSymbol.equals(playerChainSymbol)) {
					return true;
				}
			}
		}
		return false;
	}

	public String toString() {
		String output = "";
		for (String chainSymbol : this.chainSymbol) {
			output += "\n - " + chainSymbol;
		}
		return output;
	}

	public void setChainSymbol(ArrayList<String> chainSymbol) {
		this.chainSymbol = chainSymbol;
	}
}
