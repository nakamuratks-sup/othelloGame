package jp.co.supply_net.game.othello.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DemoDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int xpos;
	private int ypos;
}
