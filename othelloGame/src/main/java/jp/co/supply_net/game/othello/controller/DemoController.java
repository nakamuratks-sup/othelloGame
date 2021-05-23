package jp.co.supply_net.game.othello.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class DemoController {
	private static final Logger log = LoggerFactory.getLogger( DemoController.class);

	@RequestMapping(path = "/demo")
	public String demoMethodPre(Model model) {
		return "demoview";

	}

	@RequestMapping(path = "/demo/gettime", method = RequestMethod.GET)
	public String demoMethodSeond(Model model) {
		model.addAttribute("timestamp", new Date().toString());
		return "demoview";
	}
}
