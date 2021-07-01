package jp.co.supply_net.game.othello.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JsonMapSampleDto {
    private DemoDto demoDto;
    private List<JsonSampleDto> jsonSampleDto;
}
