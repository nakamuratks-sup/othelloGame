package jp.co.supply_net.game.othello.gameMaster;

public interface OtheloBoard {
    public int getWhiteStone();
    public int getBlackStone();
    public int getEmptySpace();

    // 指定の場所に石が置けるか判定
    public Boolean isPutEnablePosition(int xPosition, int yPosition, StoneType myStone);
    
    // 指定の場所に石を置く
    public void putStone(int x, int y, StoneType stoneType);

    // 盤面情報の複製を返す
    public StoneType[][] getBoardImage();

    // 返せる石の数をカウント
    public int countTurnStone(int x, int y, StoneType stoneType);
	
	
}
