package jp.co.supply_net.game.othello.gameMaster;

import java.util.ArrayList;
import java.util.List;

import jp.co.supply_net.game.othello.board.Grid;
import jp.co.supply_net.game.othello.dto.BoardInfo;
import jp.co.supply_net.game.othello.dto.BoardInfo.Masu;

public class Convert {

	private String masuColor;

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
    	// Gridのx,yからMasuの通し番号と石の色に変換する
    	Masu masu = new BoardInfo().new Masu();
    	
    	int numberX = grid.getXPosition();
    	int numberY = grid.getYPosition();
    	
    	//通し番号に変換
    	int num = numberY * 8 + numberX + 1;
    	String toshiNum = Integer.valueOf(num).toString();
    	
    	masu.setNumber(toshiNum);
    	masu.setMasuJoho(this.changeTypetoMasu(grid.getSType()));

    	return masu;
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
}