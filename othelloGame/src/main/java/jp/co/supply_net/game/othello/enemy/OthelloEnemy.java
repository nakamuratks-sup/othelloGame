package jp.co.supply_net.game.othello.enemy;

import jp.co.supply_net.game.othello.board.Grid;

/**
 * オセロゲームの対戦CPU
 *
 */
public interface OthelloEnemy {

	/**
	 * CPUが石を置く処理を書く
	 *
	 */
	public void enemyTurn();

	/**
	 * CPUが最後に置いたマスの情報を返す
	 * @return nullの場合はパスを意味する
	 */
	public Grid getLastSetGrid();


}
