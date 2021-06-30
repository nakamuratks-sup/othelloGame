package jp.co.supply_net.game.othello.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import jp.co.supply_net.game.othello.controller.JsonController;
//import jp.co.supply_net.game.othello.gameMaster.Convert;
import jp.co.supply_net.game.othello.gameMaster.BoardCatchRelease;
import jp.co.supply_net.game.othello.gameMaster.GameMaster;
import jp.co.supply_net.game.othello.gameMaster.OthelloBoardFactory;

@Component
public class CreateBean {

	@Bean
	public GameMaster getGameMaster() {
		GameMaster gm = new GameMaster();
//		ボードオブジェクトの設定
//		gm.setBord(new Bord());
		return gm;
		
	}

	@Bean
	public JsonController getJsonController() {
		JsonController jc = new JsonController();
//		ボードオブジェクトの設定
//		gm.setBord(new Bord());
		return jc;
	}

	// @Bean
	// public Convert getConvert() {
	// 	Convert con = new Convert();
	// 	return con;
	// }

	// @Bean
	// Public BoardCatchRelease getBoardCatchRelease() {
	// 	BoardCatchRelease bcr = new BoardCatchRelease();
	// 	return bcr;
	// }

	public OthelloBoardFactory getOthelloBoardFactory() {
		OthelloBoardFactory factory = new OthelloBoardFactory();
		return factory;
	}
}
