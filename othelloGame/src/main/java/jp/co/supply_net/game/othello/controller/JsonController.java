package jp.co.supply_net.game.othello.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jp.co.supply_net.game.othello.dto.BoardInfo;
import jp.co.supply_net.game.othello.gameMaster.OthelloGameMaster;


@RestController
@RequestMapping(path="/sample")
public class JsonController {
    private static final Logger log = LoggerFactory.getLogger(JsonController.class);
    
    @Autowired
    private OthelloGameMaster ogm;

    @PostMapping(path="/json")
    @ResponseBody
    public BoardInfo output1( @RequestBody BoardInfo boardInfo) {
        // クライアントから来たjsonをspringがBoardListに変換して渡される場所

        
        /*
         * ゲーム管理にBoardInfoの値を渡す
         */
        ogm.inputBoardInfo(boardInfo);
        
        /*
         * フロントにBoardInfoを送り返す
         */
        return ogm.outputBoardInfo();
    }

}
