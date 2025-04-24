package com.login.security.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class DashBoardControler {

	@GetMapping("/home")
	public String GetCatogory() {
		return "DashBoard...";
	}
}
