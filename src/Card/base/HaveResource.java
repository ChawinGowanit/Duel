package Card.base;

import logic.Player;

public interface HaveResource {
	public void addPlayerCounter(Player player);
	public Cost getResource();
}