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
	private String passInfo;
	private Grid enemyGrid;
	private StoneType[][] latestBoard;
	private StoneType stoneType;
	
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
	
	public void gameStart(int maxPath, int playerStone, StoneType stoneType, BoardInfo boardInfo, Grid grid){
		//Board boa = new Board();
		this.playerStone = setPlayerStone(playerStone);
		this.maxpath = maxPath;
		
		ob.isPutEnablePosition(grid.getXPosition(), grid.getYPosition(), stoneType);

	}
	
	//オセロの流れ
	public void gameProgram(int playerStone, AttackTiming timing, StoneType stoneType, BoardInfo boardInfo, Grid grid) {
		
		setPlayerStone(playerStone);
		
		//先攻：人間
		if (timing == AttackTiming.FIRST) {
			humanOthelloTurn(grid);
			
			
			
		}
		
		//先攻：CPU
		if (timing == AttackTiming.SECOND) {
			cpuOthelloTurn(grid);
			
			
			/* 
			 * latestBoard 
			 */
			
		}
	}

	private void cpuOthelloTurn(Grid grid) {
		StoneType stoneType;
		//stoneTypeに人間の色（白）設定
		stoneType = StoneType.WHITE;
		//CPUが石を置く
		oe.enemyTurn(stoneType);
		//CPUが置いた情報を取得
		enemyGrid = oe.getLastSetGrid();
			//CPUが置いた場所が、nullの場合パスを意味する
			if (enemyGrid == null) {
				this.passInfo = "pass";
			} else {
				this.passInfo = null;
			}
			
		//ボードから最新の盤面を取得
		latestBoard = ob.getBoardImage();
		
		/*
		 * 人間のターン
		 */
			//stoneTypeに人間の色（黒）設定
			stoneType = StoneType.BLACK;
			//フロントから受け取った指定の場所に人間の石を置く
			ob.putStone(grid.getXPosition(), grid.getYPosition(), stoneType);
		
			//ボードから最新の盤面を取得
			latestBoard = ob.getBoardImage();
	}

	private void humanOthelloTurn(Grid grid) {

		 
		//stoneTypeに人間の色（黒）設定
		stoneType = StoneType.BLACK;
		//フロントから受け取った指定の場所に人間の石を置く
		ob.putStone(grid.getXPosition(), grid.getYPosition(), stoneType);
		
		//ボードから最新の盤面を取得
		latestBoard = ob.getBoardImage();
		
		/*
		 * CPUのターン
		 */
			//stoneTypeにCPUの色（白）設定
			stoneType = StoneType.WHITE;
			//CPUが石を置く
			oe.enemyTurn(stoneType);
			//CPUが置いた情報を取得
			enemyGrid = oe.getLastSetGrid();
				//CPUが置いた場所が、nullの場合パスを意味する
				if (enemyGrid == null) {
					this.passInfo = "pass";
				} else {
					this.passInfo = null;
				}
			
			//ボードから最新の盤面を取得
			latestBoard = ob.getBoardImage();
			
	}
	
	
	



	


//	public void setBord(Bord bord) {
//		this.bord = bord;
//	}
	
}