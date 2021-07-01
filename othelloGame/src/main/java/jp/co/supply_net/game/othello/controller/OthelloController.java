package jp.co.supply_net.game.othello.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.supply_net.game.othello.dto.InitGameDto;
import jp.co.supply_net.game.othello.gameMaster.OthelloGameMaster;
import jp.co.supply_net.game.othello.gameMaster.OtheloBoard;

@Controller
@RequestMapping(path = "/othello")
public class OthelloController {
    private static final Logger log = LoggerFactory.getLogger(OthelloController.class);

    @Autowired
    private OthelloGameMaster ogm;
    @Autowired
    private OtheloBoard ob;
    
    @RequestMapping(path = {"", "/index"}, method = RequestMethod.GET)
    public String firstView(Model model) {
        // ゲーム開始画面表示
        return "";
    }
    @RequestMapping(path = "/init", method = RequestMethod.POST)
    public String initGame(Model model, @ModelAttribute InitGameDto initGameDto) {
        // InitGameDtoからパス回数とプレーヤの石の色を取得しゲーム管理へ渡す
        // ゲーム管理にてゲーム盤のインスタンス生成
        // ゲーム画面表示
    	int maxPath = initGameDto.getMaxPath();
    	int playerStone = initGameDto.getPlayerStone();

        ogm.gameStart(maxPath, playerStone);
    	
        /*
         * ゲームのプレイ盤面（フロント）
         */
        return "demoview";
    }

    @RequestMapping(path = "/gameresult", method = RequestMethod.GET)
    public String resultView(Model model) {
        // ゲーム管理から石の数取得し勝敗判定
        // ゲーム結果画面表示
        model.addAttribute("whitenum", ob.getWhiteStone());
        model.addAttribute("blacknum", ob.getBlackStone());
        model.addAttribute("gameresult", "kekka");
        return "result";
    }
}
