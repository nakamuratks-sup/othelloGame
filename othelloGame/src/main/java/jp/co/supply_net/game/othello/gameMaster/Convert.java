package jp.co.supply_net.game.othello.gameMaster;

import java.util.ArrayList;
import java.util.List;

import jp.co.supply_net.game.othello.board.Grid;
import jp.co.supply_net.game.othello.dto.BoardInfo;
import jp.co.supply_net.game.othello.dto.BoardInfo.Masu;

public class Convert {

	private StoneType stoneColor;
	private String masuColor;


	private int convertNumX(String number){
        int num = Integer.parseInt(number);
        int num_x = num % 8 - 1;
        if (num_x == 0) {
        	num_x = 7;
        }

        return num_x;
    }

    private int convertNumY(String number){
        int num_y;
    	int num = Integer.parseInt(number);
        int num_x = num % 8 - 1;
        int numY = num / 8;
        if (num_x == 0) {
        	num_y = numY - 1;
        }
        else
        {
        	num_y = numY;
        }

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
    
    
    
    private String convertNumber(int numberX, int numberY){
    	int num = numberY * 8 + numberX + 1;
    	String toshiNum = Integer.valueOf(num).toString();

        return toshiNum;
    }

    
    /*
     * GridをMasuに変換（1マス単位）
     */
    public Masu convertMasuNum(Grid grid) {
    	Masu masu = new BoardInfo().new Masu();
    	masu.setNumber(this.convertNumber(grid.getXPosition(), grid.getYPosition()));
        masu.setMasuJoho(this.changeTypetoMasu(grid.getSType()));
    	return masu;
	}

    /*
     * GridをList<Masu>に変換
     */
    public List<Masu> convertMasuList(List<Grid> boardlist){
    	List<Masu> list = new ArrayList<>();

    	for(Grid grid: boardlist) {
    		Masu masu = this.convertNumber(masu, masu);
    		list.add(masu);
    	}
    	return list;
    }
    
    /*
     * passInfoを設定
     */
    public String settingPassInfo(String passInfo) {
    	BoardInfo bi = new BoardInfo();
    	bi.setPassInfo = passInfo;
    	return bi;
	}
    
    /*
     * enum型をmasuJohoに変換
     */
    private String changeTypetoMasu(StoneType stoneColor) {
        // 白黒空の判定する
    	if (stoneColor == StoneType.BLACK) {
    		masuColor.equals("黒");
    	}
    	if (stoneColor == StoneType.WHITE) {
    		masuColor.equals("白");
    	}
    	if (stoneColor == StoneType.EMPTY) {
    		masuColor.equals("空");
    	}
    		
        return masuColor;
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