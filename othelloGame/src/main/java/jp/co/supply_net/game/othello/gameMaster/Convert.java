package jp.co.supply_net.game.othello.gameMaster;

import java.util.ArrayList;
import java.util.List;

import jp.co.supply_net.game.othello.board.Grid;
import jp.co.supply_net.game.othello.dto.BoardInfo.Masu;

public class Convert {

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

    public Grid convertNum(Masu masu) {
    	Grid grid = new Grid();
    	grid.setXPosition(this.convertNumX(masu.getNumber()));
    	grid.setYPosition(this.convertNumY(masu.getNumber()));
        grid.setSType(this.changType(masu.getMasuJoho()));
    	return grid;
	}

    public List<Grid> convertGridList(List<Masu> boardlist){
    	List<Grid> list = new ArrayList<>();

    	for(Masu masu: boardlist) {
    		Grid grid = this.convertNum(masu.getNumber());
    		list.add(grid);
    	}
    	return list;
    }

    private StoneType changType(String masuJoho) {
        // 白黒空の判定する
        return null;
    }

}