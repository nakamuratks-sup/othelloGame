package jp.co.supply_net.game.othello.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultGameDto {
    // 黒石の数
    int stoneNumBlack;
    // 白石の数
    int stoneNumWhite;
    // 勝敗メッセージ
    String resultMessage;
}
