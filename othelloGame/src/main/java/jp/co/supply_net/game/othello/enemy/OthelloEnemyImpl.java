package jp.co.supply_net.game.othello.enemy;

import java.util.ArrayList;
import java.util.List;

import jp.co.supply_net.game.othello.board.Grid;
import jp.co.supply_net.game.othello.gameMaster.OtheloBoard;
import jp.co.supply_net.game.othello.gameMaster.StoneType;

public class OthelloEnemyImpl implements OthelloEnemy {

	private OtheloBoard otheloBoard;

	private Grid lastSetGrid;
	private StoneType myStone;

	OthelloEnemyImpl(OtheloBoard otheloBoard){
		this.otheloBoard = otheloBoard;
	}

	@Override
	public void enemyTurn(StoneType stoneType, List<Grid> gridList) {
		myStone = stoneType;
		// ボードから空きのマス情報を取得
		// ボードへ指定マスから返せる石の数を取得
		List<Grid> list = serchPutEnableGrid(this.getEmptyGrid(gridList));
		if (0 != list.size()) {
			// 最適解を計測
			Grid bestGrid = getBestPosition(list);
			// ボードに石を置く
			otheloBoard.putStone(bestGrid.getXPosition(), bestGrid.getYPosition(), myStone, gridList);
			lastSetGrid = bestGrid;
		} else {
			// 置ける場所がない場合は
			lastSetGrid = null;
		}
	}

	@Override
	public Grid getLastSetGrid() {
		return lastSetGrid;
	}

	// ボードから空きのマス情報を取得
	private List<Grid> getEmptyGrid(List<Grid> gridList) {
		/*
		 * リストの中からemptyだけを抽出
		 */
		List<Grid> emptyList = new ArrayList<>();
		for (Grid grid: gridList) {
			if (StoneType.EMPTY == grid.getSType()) {
				emptyList.add(grid);
			}
		}
		
		return emptyList;
		
	}
	private List<Grid> getEmptyGrid() {

		StoneType[][] board = otheloBoard.getBoardImage();

		int x = board.length;
		int y = board[0].length;

		List<Grid> emptyList = new ArrayList<>();

		for (int cntx = 0; cntx < x; cntx++) {
			for (int cnty = 0; cnty < y; cnty++) {
				if (StoneType.EMPTY == board[cntx][cnty]) {
					Grid grid = new Grid();
					grid.setXPosition(cntx);
					grid.setYPosition(cnty);
					emptyList.add(grid);
				}
			}
		}
		return emptyList;
	}

	// 空きマス情報から設置可能マス情報に絞り込み
	private List<Grid> serchPutEnableGrid(List<Grid> emptyList) {
		List<Grid> putList = new ArrayList<>();
		for (Grid grid : emptyList) {
			if (otheloBoard.isPutEnablePosition(grid.getXPosition(), grid.getYPosition(), myStone)) {
				putList.add(grid);
			}
		}
		return putList;
	}

	private Grid getBestPosition(List<Grid> gridList) {
		Grid bestGrid = null;
		int turnstone = 0;
		for (Grid grid : gridList) {
			int num = otheloBoard.countTurnStone(grid.getXPosition(), grid.getYPosition(), myStone);
			if (turnstone < num) {
				turnstone = num;
				bestGrid = grid;
			}
		}
		return bestGrid;
	}
}
