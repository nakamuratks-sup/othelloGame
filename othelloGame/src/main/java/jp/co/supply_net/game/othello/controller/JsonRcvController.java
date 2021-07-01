package jp.co.supply_net.game.othello.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;

import jp.co.supply_net.game.othello.dto.DemoDto;
import jp.co.supply_net.game.othello.dto.JsonMapSampleDto;
import jp.co.supply_net.game.othello.dto.JsonSampleDto;

//@RestController
//@RequestMapping(path="/sample2")
public class JsonRcvController {
    private static final Logger log = LoggerFactory.getLogger(JsonRcvController.class);
    
    // @PostMapping(path="/json")
    // @ResponseBody
    public JsonSampleDto output1( @RequestBody JsonSampleDto jsonSampleDto) {
        // クライアントから来たjsonをspringがJsonSampleDtoに変換して渡される場所
        log.info(jsonSampleDto.getBangou());
        log.info(jsonSampleDto.getName());
        return jsonSampleDto;
    }

    // @PostMapping(path="/json")
    // @ResponseBody
    public List<JsonSampleDto> output1( @RequestBody List<JsonSampleDto> jsonSampleDto) {
        // クライアントから来たjsonをspringがJsonSampleDtoに変換して渡される場所
        for(JsonSampleDto masu: jsonSampleDto){
            log.info(masu.getBangou());
            log.info(masu.getName());
        }
        return jsonSampleDto;
    }

    // @PostMapping(path="/json")
    // @ResponseBody
    public String output1( @RequestBody String jsonString) {
        // クライアントから来たjsonをspringがJsonSampleDtoに変換して渡される場所
        log.info(jsonString);
        return jsonString;
    }

//    @PostMapping(path="/json")
//    @ResponseBody
    public JsonMapSampleDto output1( @RequestBody JsonMapSampleDto jsonMapDto) {
        // クライアントから来たjsonをspringがJsonSampleDtoに変換して渡される場所

        DemoDto demo = jsonMapDto.getDemoDto();
        log.info("x:" + demo.getXpos());
        log.info("y:" + demo.getYpos());

        for(JsonSampleDto masu: jsonMapDto.getJsonSampleDto()){
            log.info(masu.getBangou());
            log.info(masu.getName());
        }
        return jsonMapDto;
    }
}
