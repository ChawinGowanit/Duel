package Card.base;

import logic.Player;

public interface Attackable {
	public void attackPlayer(Player ATKplayer);
	public int getAttackPoint();
}