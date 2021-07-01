package jp.co.supply_net.game.othello.board;

import jp.co.supply_net.game.othello.gameMaster.StoneType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Grid {

	private int xPosition;
	private int yPosition;
	private StoneType sType;
}
