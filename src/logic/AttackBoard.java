package logic;

import java.util.HashMap;

import Card.base.Attackable;
import Card.base.Cost;
import application.GameController;

public class AttackBoard {
	private static int position = 0;
	private HashMap<Integer, Integer> posAndCoinLoss;

	public AttackBoard() {
		posAndCoinLoss = new HashMap<Integer, Integer>();
		posAndCoinLoss.put(1, 2);
		posAndCoinLoss.put(3, 2);
		posAndCoinLoss.put(6, 5);
		posAndCoinLoss.put(-1, 2);
		posAndCoinLoss.put(-3, 2);
		posAndCoinLoss.put(-6, 5);
	}

	public int getPosition() {
		return position;
	}
	
	public void setPosition(int pos) {
		position =pos;
	}
	
	public HashMap<Integer, Integer> getPosAndCoinLoss(){
		return this.posAndCoinLoss;
	}

	public void attackTime(Player player, Attackable card) {

		if (player.getNum() == 1) {
			position += card.getAttackPoint();
			rewardAndPun(player, GameController.player2);
		} else {
			position -= card.getAttackPoint();
			rewardAndPun(GameController.player1, player);
		}
	}

	public void rewardAndPun(Player player1, Player player2) {
		if (posAndCoinLoss.containsKey(position)) {
			if ((position == 1 )) {
				player1.increasePlayerPoint(posAndCoinLoss.get(1));
				posAndCoinLoss.remove(1);
			} else if (position == 3  || position == 6 ) {
				player2.setResourceCounter(Cost.reduceCost(player2.getResourceCounter(), new Cost(0, 0, 0, 0, 0, posAndCoinLoss.get(position))));
				posAndCoinLoss.remove(position);
			} else if (position == -3|| position == -6 ) {
				player1.setResourceCounter(Cost.reduceCost(player1.getResourceCounter(), new Cost(0, 0, 0, 0, 0, posAndCoinLoss.get(position))));
				posAndCoinLoss.remove(position);
			} else if (position == -1 ) {
				player2.increasePlayerPoint(posAndCoinLoss.get(-1));
				posAndCoinLoss.remove(-1);
			}
		}
	}

	public boolean winConditionCheck(Player player) {
		if (player.getNum() == 1) {
			if (position == 9) {
				return true;
			} else {
				return false;
			}
		} else {
			if (position == -9) {
				return true;
			} else {
				return false;
			}
		}
	}

}
