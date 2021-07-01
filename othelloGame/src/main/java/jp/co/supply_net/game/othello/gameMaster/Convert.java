package jp.co.supply_net.game.othello.gameMaster;

import java.util.ArrayList;
import java.util.List;

import jp.co.supply_net.game.othello.board.Grid;
import jp.co.supply_net.game.othello.dto.BoardInfo.Masu;

public class Convert {

	private StoneType stoneColor;


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

    /*
     * MasuをGridに変換（1マス単位）
     */
    public Grid convertNum(Masu masu) {
    	Grid grid = new Grid();
    	grid.setXPosition(this.convertNumX(masu.getNumber()));
    	grid.setYPosition(this.convertNumY(masu.getNumber()));
        grid.setSType(this.changeType(masu.getMasuJoho()));
    	return grid;
	}

    /*
     * GridをList<Grid>に変換
     */
    public List<Grid> convertGridList(List<Masu> boardlist){
    	List<Grid> list = new ArrayList<>();

    	for(Masu masu: boardlist) {
    		Grid grid = this.convertNum(masu);
    		list.add(grid);
    	}
    	return list;
    }

    /*
     * masuJohoをenum型に変換
     */
    private StoneType changeType(String masuJoho) {
        // 白黒空の判定する
    	if (masuJoho.equals("黒")) {
    		stoneColor = StoneType.BLACK;
    	}
    	if (masuJoho.equals("白")) {
    		stoneColor = StoneType.WHITE;
    	}
    	if (masuJoho.equals("空")) {
    		stoneColor = StoneType.EMPTY;
    	}
    		
        return stoneColor;
    }
    
    
    
    private int convertNumXtoMasu(int number){
        int num_x = number % 8 - 1;
        

        return num_x;
    }

    private int convertNumYtoMasu(int number){
        int num_y = number / 8;

        return num_y;
    }
    
    /*
     * GridをMasuに変換（1マス単位）
     */
    public Grid convertMasuNum(Grid grid) {
    	Grid grid2 = new Grid();
    	grid.setXPosition(this.convertNumXtoMasu(grid.getXPosition()));
    	grid.setYPosition(this.convertNumYtoMasu(grid.getYPosition()));
        grid.setSType(this.changeTypetoMasu(grid.getSType()));
    	return grid;
	}

    /*
     * GridをList<Masu>に変換
     */
    public List<Grid> convertMasuList(List<Masu> boardlist){
    	List<Grid> list = new ArrayList<>();

    	for(Masu masu: boardlist) {
    		Grid grid = this.convertNum(masu);
    		list.add(grid);
    	}
    	return list;
    }
    
    /*
     * enum型をmasuJohoに変換
     */
    private StoneType changeTypetoMasu(StoneType stoneColor) {
        // 白黒空の判定する
    	if (stoneColor == StoneType.BLACK) {
    		stoneColor.equals("黒");
    	}
    	if (stoneColor == StoneType.WHITE) {
    		stoneColor.equals("白");
    	}
    	if (stoneColor == StoneType.EMPTY) {
    		stoneColor.equals("空");
    	}
    		
        return stoneColor;
    }
    
    
    /*
     * 
     */
    
    /*
     * enum型をmasuJohoに変換
     */
    
    /*
     * 二次元配列に変換するメソッド
     */
    
    /*
     * 二次元配列をGridのリストに変換するメソッド
     */

}