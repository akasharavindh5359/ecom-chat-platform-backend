	package com.ecommerce.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.bot.dto.BotResponseDto;
import com.ecommerce.dto.ProductresponseDto;
import com.ecommerce.service.BotService;

@CrossOrigin(origins = "*",maxAge = 3600)	
@RestController
@RequestMapping("/bot")
public class ChatController {

	@Autowired
	BotService botService;
	
	private Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	    @PostMapping("/sendPrompt")
	    public ResponseEntity<?> processPrompt(@RequestParam("chat") String chat) {
	    	
	    	BotResponseDto botResDto = null;
	    	this.logger.info("<-------RestAPIServiceImpl------processPrompt()-------Start--->");
	    	try {
	    		botResDto =botService.BotServiceConfig(chat);
	    		this.logger.info("<-------RestAPIServiceImpl------processPrompt()-------End--->");
	    		
			}catch (Exception botvar1) {
				this.logger.info("<-------RestAPIServiceImpl------processPrompt()-------->",botvar1);
			}
	
	    	return new ResponseEntity<>(botResDto,HttpStatus.OK);
	         
	    }
	    
	
	
	
	
	
	
}
