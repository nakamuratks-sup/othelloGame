package jp.co.supply_net.game.othello.gameMaster;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import jp.co.supply_net.game.othello.board.Grid;
import jp.co.supply_net.game.othello.dto.BoardInfo;
import jp.co.supply_net.game.othello.dto.BoardInfo.Masu;
import jp.co.supply_net.game.othello.enemy.OthelloEnemy;
import jp.co.supply_net.game.othello.enemy.OthelloEnemyFactory;


public class GameMaster implements OthelloGameMaster {

//	@Autowired
//	private Convert con;
	//private Board boa;


	private OtheloBoard ob;
	@Autowired
	private OthelloBoardFactory obf;

	private OthelloEnemy oe;
	@Autowired
	private OthelloEnemyFactory oef;
	
	private Convert con;


	/**
	 * 先攻or後攻
	 *
	 */
	public static enum AttackTiming {
		FIRST, SECOND
	};


	private int maxpath;
	private AttackTiming playerStone;
	private String passInfo;
	private Grid enemyGrid;
	private StoneType[][] latestBoard;
	private StoneType stoneType;
	private BoardInfo boardInfo;
	private List<Grid> gridList;
	private Grid grid;

//	public GameMaster() {
//		// TODO 自動生成されたコンストラクター・スタブ
//	}
//	public GameMaster(int maxpath) {
//		// TODO 自動生成されたコンストラクター・スタブ
//	}
//	playerStone = BLACK ? stone_type.BLACK: stone_type.WHITE;

	public void setPlayerStone(int playerStone) {
		//this.playerStone = playerStone;
		this.playerStone = playerStone == 1 ? AttackTiming.FIRST: AttackTiming.SECOND;

	}


	@Override
	//ゲーム開始
	public void gameStart(int maxPath, int playerStone){
		setPlayerStone(playerStone);
		this.maxpath = maxPath;
		this.ob = obf.createOtheloBoard();
		this.oe = oef.createTheOthelloEnemy(ob);

	}

	public int getWhite() {
		// TODO　暫定対処
		int countWhite = ob.getWhiteStone();
//		int countWhite = 15;
		return countWhite;

	}

	public int getBlack() {
		// TODO　暫定対処
		int countBlack = ob.getBlackStone();
//		int countBlack = 18;
		return countBlack;

	}

	//結果
	public String gameFinish() {
		String kekka = "";
		// TODO　暫定対処
		int countWhite = ob.getWhiteStone();
		int countBlack = ob.getBlackStone();
//		int countWhite = 15;
//		int countBlack = 18;

		if (countWhite > countBlack) {
			kekka = "白の勝ちです";
		}
		if (countBlack > countWhite) {
			kekka = "黒の勝ちです";
		}
		if (countWhite == countBlack) {
			kekka = "引き分けです";
		}
		return kekka;
	}

	//オセロの流れ
	public void gameProgram(AttackTiming playerStone, BoardInfo boardInfo) {
		//Gridに変換
		Masu masu = new BoardInfo().new Masu();
		this.grid = con.convertNum(masu.getNumber(), masu.getMasuJoho());
		this.gridList = con.convertGridList(boardInfo.getBoardList());
		
		//先攻：人間
		if (playerStone == AttackTiming.FIRST) {
			humanOthelloTurn(grid, gridList);

		}

		//先攻：CPU
		if (playerStone == AttackTiming.SECOND) {
			cpuOthelloTurn(grid, gridList);

		}
	}


	/*
	 * CPUが先攻の場合の流れ
	 */
	private void cpuOthelloTurn(Grid grid, List<Grid> gridList) {
		StoneType stoneType;
		//stoneTypeにCPUの色（白）設定
		stoneType = StoneType.BLACK;
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
			stoneType = StoneType.WHITE;
			//フロントから受け取った指定の場所に人間の石を置く
			ob.putStone(grid.getXPosition(), grid.getYPosition(), stoneType, gridList);

			//ボードから最新の盤面を取得
			latestBoard = ob.getBoardImage();
	}


	/*
	 * 人間が先攻の場合の流れ
	 */
	private void humanOthelloTurn(Grid grid, List<Grid> gridList) {


		//stoneTypeに人間の色（黒）設定
		stoneType = StoneType.BLACK;
		
		//フロントから受け取った指定の場所に人間の石を置く
		ob.putStone(grid.getXPosition(), grid.getYPosition(), stoneType, gridList);

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

	@Override
	public void inputBoardInfo(BoardInfo boardInfo) {
		// TODO 自動生成されたメソッド・スタブ
		
		//ゲームの流れ
		gameProgram(playerStone, boardInfo);
		
		
	}

	@Override
	public BoardInfo outputBoardInfo() {
		// TODO 自動生成されたメソッド・スタブ
		//リストをセット
		boardInfo.setBoardList(con.convertMasuList(gridList));
		//CPUが置いた場所をセット
		Masu masu = con.convertMasu(enemyGrid);
		boardInfo.setPutPosition(masu.getNumber());
		//CPUがパスしたかどうかの情報をセット
		boardInfo.setPassInfo(passInfo);
		
		return boardInfo;
	}



}