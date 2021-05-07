package jp.co.supply_net.game.othello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloWorldSample {
	// 接続先（localhost:8080/）にアクセスするとこのメソッドが呼び出される
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	// 上記アノテーションを使って接続先URLとメソッド、クラスをバインドする
	public String index(Model model) {
		// 第1引数にHTMLの埋め込み文字を指定、第2引数に出力した文字を指定
		model.addAttribute("message","Hello SpringBoot");
		
		// 返却値にHTMLファイル名を指定
		return "index";
	}
}
