package jp.co.supply_net.game.othello.enemy;

import jp.co.supply_net.game.othello.gameMaster.OtheloBoard;

public class OthelloEnemyFactory {
	public OthelloEnemy createTheOthelloEnemy(OtheloBoard board) {
		return new OthelloEnemyImpl(board);
	}
}
