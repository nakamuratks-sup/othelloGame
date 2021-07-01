package jp.co.supply_net.game.othello.gameMaster;

import jp.co.supply_net.game.othello.dto.BoardInfo;

public interface OthelloGameMaster {

	public void inputBoardInfo(BoardInfo boardInfo) ;
	
	public BoardInfo outputBoardInfo();
	
	public void gameStart(int maxPath, int playerStone);
	
	public int getWhite();
    
    public int getBlack();
    
    public String gameFinish();

}
