package jp.co.supply_net.game.othello.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardInfo implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private List<Masu> boardList; //64個のマス情報
    private String putPosition; //最後に置いた場所
    private String passInfo; //パスかどうか

    @Getter
    @Setter
    public class Masu{
        private String number; //通し番号
        private String masuJoho; //黒、白、空
    }
}
