package jp.co.supply_net.game.othello.gameMaster;
import org.springframework.beans.factory.annotation.Autowired;

import jp.co.supply_net.game.othello.board.Grid;
import jp.co.supply_net.game.othello.dto.BoardInfo;
import jp.co.supply_net.game.othello.enemy.OthelloEnemy;


public class GameMaster {

	@Autowired
	//private Convert con;
	//private Board boa;
	private BoardCatchRelease bcr;
	private OtheloBoard ob;
	private OthelloEnemy oe;
	
	/**
	 * 先攻or後攻
	 *
	 */
	public static enum AttackTiming {
		FIRST, SECOND
	};
	
	
	private int maxpath;
	private AttackTiming playerStone;
//	private Bord bord;
	
//	public GameMaster() {
//		// TODO 自動生成されたコンストラクター・スタブ
//	}
//	public GameMaster(int maxpath) {
//		// TODO 自動生成されたコンストラクター・スタブ
//	}
//	playerStone = BLACK ? stone_type.BLACK: stone_type.WHITE;

	public AttackTiming setPlayerStone(int playerStone) {
		//this.playerStone = playerStone;
		AttackTiming timing = playerStone == 1 ? AttackTiming.FIRST: AttackTiming.SECOND;
		return timing;
	}

	//パス回数設定するときに使う（予定）
	//public void setMaxpath(int maxpath) {
	//	this.maxpath = maxpath;
	//}
	
	public void gameStart(int maxPath, int playerStone, BoardInfo boardInfo, Grid grid){
		//Board boa = new Board();
		this.playerStone = setPlayerStone(playerStone);
		this.maxpath = maxPath;
		
		//東ob.isPutEnablePosition(grid.getXPosition(), grid.getYPosition(), boardInfo.getBoardList());

	}
	
	//オセロの流れ
	public void gameProgram(AttackTiming timing, BoardInfo boardInfo) {
		//先攻：人間
		if (timing == AttackTiming.FIRST) {
			//フロントから受け取った指定の場所に人間の石を置く
			//東ob.putStone(boardInfo.getBoardList(), boardInfo.getPutPosition());
			
			
		}
		//先攻：CPU
		if (timing == AttackTiming.SECOND) {
			//CPUが石を置く
			oe.enemyTurn();
			//CPUが置いた情報を取得
			Grid enemyGrid = oe.getLastSetGrid();
			//ボードから最新の盤面を取得
			//東List<Masu> latestBoard = ob.getBoardImage();
			
			/* 
			 * latestBoard 
			 */
			
		}
	}
	
	
	



	


//	public void setBord(Bord bord) {
//		this.bord = bord;
//	}
	
}