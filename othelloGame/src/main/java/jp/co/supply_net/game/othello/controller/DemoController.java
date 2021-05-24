package jp.co.supply_net.game.othello.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class DemoController {
	private static final Logger log = LoggerFactory.getLogger( DemoController.class);

	@RequestMapping(path = "/demo")
	public String demoMethodPre(HttpSession session, Model model) {
		return "demoview";

	}

	@RequestMapping(path = "/demo/gettime", method = RequestMethod.GET)
	public String demoMethodSeond(HttpSession session, Model model) {
		model.addAttribute("timestamp", new Date().toString());
		return "demoview";
	}

	@RequestMapping(path = "/demo/setposition", method = RequestMethod.POST)
	public String demoMethodThird(HttpSession session, Model model, @RequestParam("position") String position) {
		model.addAttribute("timestamp", position + "に置きました。");
		log.info(position);
		// return "demoview";
		return "recieve";
	}
}
