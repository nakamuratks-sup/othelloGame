package jp.co.supply_net.game.othello.board;

public class Convertinfo {
    public int convertNumX(boardList){
        int num = Integer.parseInt(number);
        int num_x = num % 8 - 1;

        return num_x;
    }

    public int convertNumY(boardList){
        int num = Integer.parseInt(number);
        int num_y = num / 8;

        return num_y;
    }
}
