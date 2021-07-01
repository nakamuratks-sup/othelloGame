package jp.co.supply_net.game.othello.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InitGameDto {
    // 最大パス回数
    private int maxPath;
    // プレーヤが先攻(1)か後攻(2)か
    private int playerStone;
}
