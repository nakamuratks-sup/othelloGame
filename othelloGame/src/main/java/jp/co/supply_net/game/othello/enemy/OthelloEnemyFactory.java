package jp.co.supply_net.game.othello.enemy;

public class OthelloEnemyFactory {
	public OthelloEnemy createTheOthelloEnemy() {
		return new OthelloEnemyImpl();
	}
}
