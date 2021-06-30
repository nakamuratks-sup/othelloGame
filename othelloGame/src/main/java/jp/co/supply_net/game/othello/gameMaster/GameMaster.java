package jp.co.supply_net.game.othello.gameMaster;

import org.springframework.beans.factory.annotation.Autowired;

public class GameMaster {

	//@Autowired
	//private Convert con;
	//private Board boa;

	/**
	 * 先攻or後攻
	 *
	 */
	public static enum attack_timing {
		FIRST, SECOND
	};
	
	/**
	 * マス要素
	 *
	 */
	public static enum stone_type {
		EMPTY, BLACK, WHITE
	};
	
	private int maxpath;
	private attack_timing playerStone;
//	private Bord bord;
	
//	public GameMaster() {
//		// TODO 自動生成されたコンストラクター・スタブ
//	}
//	public GameMaster(int maxpath) {
//		// TODO 自動生成されたコンストラクター・スタブ
//	}
//	playerStone = BLACK ? stone_type.BLACK: stone_type.WHITE;

	public attack_timing setPlayerStone(int playerStone) {
		//this.playerStone = playerStone;
		attack_timing timing = playerStone == 1 ? attack_timing.FIRST: attack_timing.SECOND;
		return timing;
	}

	//パス回数設定するときに使う（予定）
	//public void setMaxpath(int maxpath) {
	//	this.maxpath = maxpath;
	//}

	public void gameStart(int maxPath, int playerStone){
		//Board boa = new Board();
		this.playerStone = setPlayerStone(playerStone);
		this.maxpath = maxPath;

	}



	


//	public void setBord(Bord bord) {
//		this.bord = bord;
//	}
	
}