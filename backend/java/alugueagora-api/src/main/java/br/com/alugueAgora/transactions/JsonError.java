package br.com.alugueAgora.transactions;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class JsonError {
	private HttpStatus httpCode;
	private String message;
	private String detailedMessage;
	private String resource;
	
	public JsonError(HttpStatus badRequest, String localizedMessage, String error) {
		this.httpCode = badRequest;
		this.message = localizedMessage;
		this.resource = error;
	}
}
