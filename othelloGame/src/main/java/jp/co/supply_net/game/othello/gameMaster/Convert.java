package jp.co.supply_net.game.othello.gameMaster;

import java.util.ArrayList;
import java.util.List;

import jp.co.supply_net.game.othello.board.Grid;
import jp.co.supply_net.game.othello.dto.BoardInfo.Masu;

public class Convert {

	// フロント->サーバ変換
	private int convertNumX(String number){
        int num = Integer.parseInt(number);
        int num_x = num % 8 - 1;

        return num_x;
    }

    private int convertNumY(String number){
        int num = Integer.parseInt(number);
        int num_y = num / 8;

        return num_y;
    }

    public Grid convertNum(String number, String masuJoho) {
    	Grid grid = new Grid();
    	grid.setXPosition(this.convertNumX(number));
    	grid.setYPosition(this.convertNumY(number));
        grid.setSType(this.changType(masuJoho));
    	return grid;
	}
    public Grid convertNum(Masu masu) {
    	return this.convertNum(masu.getNumber(), masu.getMasuJoho());
    }

    public List<Grid> convertGridList(List<Masu> boardlist){
    	List<Grid> list = new ArrayList<>();

    	for(Masu masu: boardlist) {
    		Grid grid = this.convertNum(masu.getNumber(), masu.getMasuJoho());
    		list.add(grid);
    	}
    	return list;
    }

    private StoneType changType(String masuJoho) {
        // 白黒空の判定する
        return null;
    }

    // サーバ->フロント変換

    /**
     * GridリストをMasuリストに変換する
     * @param gridlist
     * @return
     */
    public List<Masu> convertMasuList(List<Grid> gridlist){
    	List<Masu> list = new ArrayList<>();

    	for(Grid grid: gridlist) {
    		Masu masu = convertMasu(grid);
    		list.add(masu);
    	}
    	return list;
    }

    /**
     * GridをMasuに変換する
     * @param grid
     * @return
     */
    public Masu convertMasu(Grid grid) {
    	// Gridのx,yからMasuの通し番号に変換する
    	return null;
    }
}