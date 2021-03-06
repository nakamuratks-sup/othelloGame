package jp.co.supply_net.game.othello.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import jp.co.supply_net.game.othello.enemy.OthelloEnemyFactory;
import jp.co.supply_net.game.othello.gameMaster.GameMaster;
import jp.co.supply_net.game.othello.gameMaster.OthelloBoardFactory;
import jp.co.supply_net.game.othello.gameMaster.OthelloGameMaster;

@Component
public class CreateBean {

	@Bean
	public OthelloGameMaster getGameMaster() {
		GameMaster gm = new GameMaster();
//		ボードオブジェクトの設定
//		gm.setBord(new Bord());
		return gm;

	}

//	@Bean
//	public Convert getConvert() {
//		Convert con = new Convert();
//	 	return con;
//	}

	// @Bean
	// Public BoardCatchRelease getBoardCatchRelease() {
	// 	BoardCatchRelease bcr = new BoardCatchRelease();
	// 	return bcr;
	// }

	@Bean
	public OthelloBoardFactory getOthelloBoardFactory() {
		OthelloBoardFactory factory = new OthelloBoardFactory();
		return factory;
	}

	@Bean
	public OthelloEnemyFactory getOthelloEnemyFactory() {
		OthelloEnemyFactory factory = new OthelloEnemyFactory();
		return factory;
	}
}
