package com.ecommerce.bot.dto;

import java.util.List;

import com.ecommerce.dto.ErrorDescription;

public class BotResponseDto {
	
	private String status;
	private String responseMes;
	private String BotResponse;
	private List<ErrorDescription> errorDetails;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getResponseMes() {
		return responseMes;
	}
	public void setResponseMes(String responseMes) {
		this.responseMes = responseMes;
	}
	public String getBotResponse() {
		return BotResponse;
	}
	public void setBotResponse(String botResponse) {
		BotResponse = botResponse;
	}
	public List<ErrorDescription> getErrorDetails() {
		return errorDetails;
	}
	public void setErrorDetails(List<ErrorDescription> errorDetails) {
		this.errorDetails = errorDetails;
	}
	
	

}
