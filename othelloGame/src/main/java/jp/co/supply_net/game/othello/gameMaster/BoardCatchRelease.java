package jp.co.supply_net.game.othello.gameMaster;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import jp.co.supply_net.game.othello.controller.JsonController;
import jp.co.supply_net.game.othello.dto.BoardInfo;

public class BoardCatchRelease {

    @Autowired
    private JsonController jc;
    private List boardList;
    private String putPosition;
    private String passInfo;

    public void setBoardList(List boardList) {
        this.boardList = boardList;
    }

    public void setPutPusition(String putPosition) {
        this.putPosition = putPosition;
    }

    public void setPassInfo(String passInfo) {
        this.passInfo = passInfo;
    }

}