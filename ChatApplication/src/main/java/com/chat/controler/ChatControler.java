package com.chat.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ChatControler {

	@GetMapping("chat")
	public String getMethodName() {
		return "Chat Service Running";
	}
	
}
