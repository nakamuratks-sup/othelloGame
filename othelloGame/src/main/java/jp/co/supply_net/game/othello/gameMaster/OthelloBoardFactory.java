package jp.co.supply_net.game.othello.gameMaster;

import jp.co.supply_net.game.othello.board.Board;

public class OthelloBoardFactory {
    public OtheloBoard createOtheloBoard() {
        return new Board();
    }
}
