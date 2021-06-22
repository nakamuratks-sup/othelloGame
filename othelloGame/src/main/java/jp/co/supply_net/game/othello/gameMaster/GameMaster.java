package jp.co.supply_net.game.othello.gameMaster;

public class GameMaster {

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
	private String playerStone;
//	private Bord bord;
	
//	public GameMaster() {
//		// TODO 自動生成されたコンストラクター・スタブ
//	}
//	public GameMaster(int maxpath) {
//		// TODO 自動生成されたコンストラクター・スタブ
//	}
//	playerStone = BLACK ? stone_type.BLACK: stone_type.WHITE;

	public attack_timing setPlayerStone(String playerStone) {
		this.playerStone = playerStone;
		attack_timing timing = playerStone.equals("BLACK") ? attack_timing.FIRST: attack_timing.SECOND;
		return timing;
	}

	public void setMaxpath(int maxpath) {
		this.maxpath = maxpath;
	}
	
	public void hoge() {
		int tmp = 0;
		tmp = maxpath + 5;
	}


//	public void setBord(Bord bord) {
//		this.bord = bord;
//	}
	
}
