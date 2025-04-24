package com.ecommerce.serviceimpl;



import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

import com.ecommerce.bot.dto.BotResponseDto;
import com.ecommerce.constants.EcommerceConstants;
import com.ecommerce.dto.ErrorDescription;
import com.ecommerce.service.BotService;

import okhttp3.OkHttpClient;



@Service
public class BotServiceImp implements BotService {

	private Logger logger = LoggerFactory.getLogger(BotServiceImp.class);
	
	private final ChatClient chatClient;
	  public BotServiceImp(ChatClient.Builder chatClient) {
	        this.chatClient = chatClient.build();
	    }
	  
	  

	

	@Override
	public BotResponseDto BotServiceConfig(String chat) {
		String BotResponse = null;
		BotResponseDto botResponseDto= new BotResponseDto();
		this.logger.info("<-------RestAPIServiceImpl------BotServiceConfig()-------Start--->");
		try {
			
			System.err.println(System.currentTimeMillis());
			CompletableFuture<String> future = CompletableFuture.supplyAsync(()-> {
				return chatClient.prompt(chat).call().content();
			});
			
		    String result = future.get(10, TimeUnit.SECONDS);
			if(result != null) {
				System.err.println(future.get());
				botResponseDto.setStatus(EcommerceConstants.STATUS_SUCCESS);
				botResponseDto.setResponseMes(EcommerceConstants.FETCHING_SUCCESS);
				botResponseDto.setBotResponse(result);
				return botResponseDto;
			}else {
				System.err.println(future.get());
				botResponseDto.setStatus(EcommerceConstants.STATUS_FAIL);
				botResponseDto.setResponseMes(EcommerceConstants.ERROR_MESG);
				return botResponseDto;

				
			}
			
			
			
			
			
//			if(BotResponse !=null) {
//				botResponseDto.setStatus(EcommerceConstants.STATUS_SUCCESS);
//				botResponseDto.setResponseMes(EcommerceConstants.FETCHING_SUCCESS);
//				botResponseDto.setBotResponse(BotResponse);
//				
//				return botResponseDto;
//			}else {
//				botResponseDto.setStatus(EcommerceConstants.STATUS_FAIL);
//				botResponseDto.setResponseMes(EcommerceConstants.ERROR_MESG);
//				return botResponseDto;
//			}
			 
		}catch (Exception botvar1) {
			botResponseDto.setStatus(EcommerceConstants.STATUS_FAIL);
			botResponseDto.setResponseMes(EcommerceConstants.SERVER_ERROR);
			botResponseDto.setErrorDetails(Arrays.asList(new ErrorDescription("500",botvar1.toString())));
		}
		return botResponseDto;
		
		
	}
	
	
	}

	
	


