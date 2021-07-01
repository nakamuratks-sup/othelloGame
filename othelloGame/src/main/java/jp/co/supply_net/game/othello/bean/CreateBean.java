package jp.co.supply_net.game.othello.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import jp.co.supply_net.game.othello.gameMaster.GameMaster;

@Component
public class CreateBean {

	@Bean
	public GameMaster getGameMaster() {
		GameMaster gm = new GameMaster();
//		ボードオブジェクトの設定
//		gm.setBord(new Bord());
		return gm;
		
	}
}
