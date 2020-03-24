package logic;

import java.util.HashMap;



public  class AttackBoard {
	private static int position=0;
	private  HashMap<Integer , Integer> PosAndCoinLoss = new HashMap<Integer, Integer>();
	
	public AttackBoard() {
		PosAndCoinLoss.put(1, 2);
		PosAndCoinLoss.put(3,2);
		PosAndCoinLoss.put(6,5);
		PosAndCoinLoss.put(-1, 2);
		PosAndCoinLoss.put(-3,2);
		PosAndCoinLoss.put(-6,5);
	}
	
	public static void attackTime(Player player) {
		if (player.getNum()==1) {
			position+=player.getAttackpoint();
		}else {
			position-=player.getAttackpoint();
		}
	}
	
	public void rewardAndPun(Player player1,Player player2) {
		if (PosAndCoinLoss.containsKey(position)) {
			if (position==1) {
				player1.increasePlayerPoint(PosAndCoinLoss.get(1));
				PosAndCoinLoss.remove(1);
			}else if (position==3 || position==6) {
				player2.increasePlayerMoney(-PosAndCoinLoss.get(position));
				PosAndCoinLoss.remove(position);
			}else if (position==-3 || position==-6) {
				player1.increasePlayerMoney(-PosAndCoinLoss.get(position));
				PosAndCoinLoss.remove(position);
			}else if (position==-1) {
				player2.increasePlayerPoint(PosAndCoinLoss.get(-1));
				PosAndCoinLoss.remove(-1);
			}
		}
	}
	public static boolean winConditionCheck(Player player) {
		if (player.getNum()==1){
			if (position ==9) {
				return true;
			}else {
				return false;
			}
		}else {
			if (position==-9) {
				return true;
			}else {
				return false;
			}
		}
	}
	
}
