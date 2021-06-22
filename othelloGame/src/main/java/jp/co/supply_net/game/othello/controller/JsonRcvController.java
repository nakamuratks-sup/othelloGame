package jp.co.supply_net.game.othello.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jp.co.supply_net.game.othello.dto.JsonSampleDto;

@RestController
@RequestMapping(path="/sample")
public class JsonRcvController {
    private static final Logger log = LoggerFactory.getLogger(JsonRcvController.class);
    
    @PostMapping(path="/json")
    @ResponseBody
    public JsonSampleDto output1( @RequestBody JsonSampleDto jsonSampleSto) {
        // クライアントから来たjsonをspringがJsonSampleDtoに変換して渡される場所
        log.info(jsonSampleSto.getBangou());
        log.info(jsonSampleSto.getName());
        return jsonSampleSto;
    }
}
